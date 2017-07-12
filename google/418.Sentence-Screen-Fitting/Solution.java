public class Solution {
    public static void main(String[] args) {
        String[] sentence = {"I", "had", "apple", "pie"};
        int rows = 4;
        int cols = 5;
        System.out.println(wordsTyping3(sentence, rows, cols));
    }
    public static int wordsTyping(String[] sentence, int rows, int cols) {//Time Limit Exceeded O(rows*cols)
        if(cols == 0 || sentence == null || sentence.length == 0) {
            return 0;
        }
        int index = 0;
        int output = 0;
        for(int i = 0; i < rows; i++) {
            int remainSpace = cols;
            while(remainSpace >= sentence[index].length()) {
                // System.out.println("remainSpace " + remainSpace + " word " + sentence[index]);
                remainSpace -= sentence[index].length()+1;
                if(index == sentence.length-1) {
                    index = 0;
                    output++;
                } else {
                    index++;
                }   
            }
        }
        return output;
    }
    public static int wordsTyping2(String[] sentence, int rows, int cols) {//24 ms O(rows)
        String s = String.join(" ", sentence) + " ";
        System.out.println(s);
        int start = 0;
        int len = s.length();
        for(int i = 0; i < rows; i++) {
            start += cols;
            if(s.charAt(start % len) == ' ') {
                start++;
            } else {
                while(start > 0 && s.charAt((start-1) % len) != ' ') {
                    start--;
                }
            }
        }
        return start/len;
    }
    public static int wordsTyping3(String[] sentence, int rows, int cols) {//26 ms O(rows)+O(cols*sentence.length)
        int[] nextIndex = new int[sentence.length];
        int[] times = new int[sentence.length];
        for(int i = 0; i < sentence.length; i++) {
            int curtLen = 0;
            int count = 0;
            int next = i;
            while(curtLen+sentence[next].length() <= cols) {
                curtLen += sentence[next++].length()+1;
                if(next == sentence.length) {
                    next = 0;
                    count++;
                } 
            }
            nextIndex[i] = next;
            times[i] = count;
        }
        int start = 0;
        int output = 0;
        for(int i = 0; i < rows; i++) {
            output += times[start];
            start = nextIndex[start]; 
        }
        return output;
    }
}