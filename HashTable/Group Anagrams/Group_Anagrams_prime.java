public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String s : strs) {
            String temp = toCanonicalForm(s);
            if (!map.containsKey(temp)) {
                map.put(temp, new ArrayList<String>());
            }
            map.get(temp).add(s);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
    public String toCanonicalForm(String input) {
        char[] ch = input.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
}