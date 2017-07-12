public class Solution {
    public String frequencySort(String s) {// 62 ms
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<Map.Entry<Character, Integer>>listObjects = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
        // sort the listObjects in decreasing order of scores
        Collections.sort(listObjects, new Comparator<Map.Entry<Character,Integer> >() {
            public int compare(Map.Entry<Character,Integer> a, Map.Entry<Character,Integer> b){
                return b.getValue() - a.getValue();
            }
        });
        // print the result;
        for (Map.Entry<Character, Integer> curr : listObjects) {
            for(int i = 0; i < curr.getValue(); i++){
                sb.append(curr.getKey());
            }
        }
        return sb.toString();
    }
    public String frequencySort2(String s) {// 40 ms
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        ArrayList<Character>[] bucket = new ArrayList[s.length()+1];
        for(Character ch : map.keySet()) {
            int freq = map.get(ch);
            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<Character>();
            }
            bucket[freq].add(ch);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = bucket.length-1; i >= 0; i--) {
            if(bucket[i] != null) {
                for(char ch : bucket[i]) {
                    for(int j = 0; j < i; j++) {
                        sb.append(ch);
                    }
                }
            }
        }
        return sb.toString();
    }
    public String frequencySort3(String s) {// 13ms
        int[] charCount=new int[256];
        
        for(char c:s.toCharArray()){
            charCount[(int)c]++;
        }
        
        List<Character>[] bucket=new List[s.length()+1];
        for(int i=0;i<256;i++){
            int freq=charCount[i];
            if(freq!=0){
                if(bucket[freq]==null){
                    bucket[freq]=new ArrayList<>();
                }
                bucket[freq].add((char)i);
            }
        }
        
        StringBuilder sb=new StringBuilder();
        for(int freq=bucket.length-1;freq>0;freq--){
            if(bucket[freq]!=null){
                for(char c: bucket[freq]){
                    for(int i=0;i<freq;i++) sb.append(c);
                }
            }
        }
        
        return sb.toString();
    }
}