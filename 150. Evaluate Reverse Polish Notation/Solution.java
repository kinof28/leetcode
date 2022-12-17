
// import java.lang.reflect.Array;
import java.util.Arrays;
// import java.util.stream.Stream;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("result array: " +
                solution.evalRPN(new String[] { "4", "13", "5", "/", "+" }));
        // System.out.println("result String: " +
        // solution.evalRPNString("21+3*"));
    }

    public int evalRPN(String[] tokens) {
        if (tokens.length == 0)
            return 0;
        else if (tokens.length == 1)
            return Integer.parseInt(tokens[0]);
        else
            for (int i = 0; i < tokens.length; i++) {

                try {
                    Integer.parseInt(tokens[i]);
                } catch (NumberFormatException exception) {

                    if (tokens[i].equals("+")) {

                        tokens[i - 2] = Integer.parseInt(tokens[i - 2]) + Integer.parseInt(tokens[i - 1]) + "";

                    } else if (tokens[i].equals("-")) {

                        tokens[i - 2] = Integer.parseInt(tokens[i - 2]) - Integer.parseInt(tokens[i - 1]) + "";

                    } else if (tokens[i].equals("*")) {

                        tokens[i - 2] = Integer.parseInt(tokens[i - 2]) * Integer.parseInt(tokens[i - 1]) + "";

                    } else {
                        int val = Integer.parseInt(tokens[i - 1]) != 0 ? Integer.parseInt(tokens[i - 1]) : 1;
                        tokens[i - 2] = Integer.parseInt(tokens[i - 2]) / val + "";
                    }
                    return evalRPN(this.concatenateArrays(Arrays.copyOfRange(tokens, 0, i - 1),
                            Arrays.copyOfRange(tokens, i + 1, tokens.length)));

                }

            }
        return 0;
    }

    public String[] concatenateArrays(String[] array1, String[] array2) {
        String[] result = (Arrays.toString(array1).replace("[", "").replace("]", "").replace(" ", "") + ","
                + Arrays.toString(array2).replace("[", "").replace("]", "").replace(" ", "")).split(",");
        return result;
    }

}