public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String s : strs) {
            String temp = toCanonicalForm(s);
            ArrayList<String> list = new ArrayList<String>();
            if (map.containsKey(temp)) {
                list = map.get(temp);
            }
            list.add(s);
            map.put(temp,list);
        }
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
    public String toCanonicalForm(String input) {
        char[] ch = input.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
}