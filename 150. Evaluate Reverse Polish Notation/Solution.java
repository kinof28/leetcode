
// import java.lang.reflect.Array;
import java.util.Arrays;
// import java.util.stream.Stream;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                solution.evalRPN(new String[] { "2", "1", "+", "3", "*" }));
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
                    if (tokens[i] == "+") {

                        tokens[i - 2] = Integer.parseInt(tokens[i - 2]) + Integer.parseInt(tokens[i - 1]) + "";

                    } else if (tokens[i] == "-") {

                        tokens[i - 2] = Integer.parseInt(tokens[i - 2]) - Integer.parseInt(tokens[i - 1]) + "";

                    } else if (tokens[i] == "*") {

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
        String[] result = new String[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            result[array1.length + i] = array2[i];
        }
        System.out.println(Arrays.toString(result));
        return result;
        // return concatWithStream(array1, array2);
    }

    // private static <T> T[] concatWithStream(T[] array1, T[] array2) {
    // return Stream.concat(Arrays.stream(array1), Arrays.stream(array2))
    // .toArray(size -> (T[])
    // Array.newInstance(array1.getClass().getComponentType(), size));
    // }
}