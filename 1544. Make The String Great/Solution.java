class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.makeGood("leEeetcode"));
    }

    public String makeGood(String s) {
        int i = 0;
        boolean flag = false;
        while (true) {
            if (s.length() < 2)
                return s;
            if (String.valueOf(s.charAt(i)).equalsIgnoreCase(String.valueOf(s.charAt(i + 1)))
                    && !String.valueOf(s.charAt(i)).equals(String.valueOf(s.charAt(i + 1)))) {
                if (i != 0 && i != s.length() - 2)
                    s = s.substring(0, i) + s.substring(i + 2);
                else if (i == 0)
                    s = s.substring(i + 2);
                else
                    s = s.substring(0, i);
                flag = true;
                i = 0;
            } else {
                i++;
                flag = false;
            }
            if (!flag && i == s.length() - 1)
                break;
        }
        return s;
    }

}