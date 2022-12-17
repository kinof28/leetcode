import java.util.Stack;

class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        if (tokens.length == 0)
            return 0;
        else if (tokens.length == 1)
            return Integer.parseInt(tokens[0]);
        else
            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i].equals("+") || tokens[i].equals("*") || tokens[i].equals("-") || tokens[i].equals("/")) {
                    int v2 = stack.pop(), v1 = stack.pop();
                    if (tokens[i].equals("+")) {
                        stack.add(v1 + v2);
                    } else if (tokens[i].equals("-")) {
                        stack.add(v1 - v2);
                    } else if (tokens[i].equals("*")) {
                        stack.add(v1 * v2);
                    } else {
                        stack.add(v1 / v2);
                    }
                } else {
                    stack.add(Integer.parseInt(tokens[i]));
                }
            }
        return stack.pop();
    }

}