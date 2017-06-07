import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String item : tokens) {
            int a;
            int b;
            switch(item) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a+b);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b-a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b*a);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b/a);
                    break;
                default:
                    stack.push(Integer.parseInt(item));
            }
        }
        return stack.peek();
    }
}