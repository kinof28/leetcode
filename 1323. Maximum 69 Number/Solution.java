class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximum69Number(9669));
    }

    public int maximum69Number(int num) {
        String string = num + "";
        System.out.println("string in the beginning: " + string);
        for (int i = 0; i < string.length(); i++)
            if (string.charAt(i) == '6') {
                if (i != string.length() - 1)
                    string = string.substring(0, i) + '9' + string.substring(i + 1);
                else
                    string = string.substring(0, i) + '9';
                System.out.println("string: " + string);
                return Integer.parseInt(string);
            }
        return num;
    }
}