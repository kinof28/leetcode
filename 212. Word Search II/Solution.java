
import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i',
        // 'h', 'k', 'r' },
        // { 'i', 'f', 'l', 'v' } };
        char[][] board = { { 'a', 'b', 'c' }, { 'a', 'e', 'd' }, { 'a', 'f', 'g' } };
        String[] words = { "eaafgdcba", "eaabcdgfa" };
        // String[] words = { "aaa" };
        System.out.println("result: ---- " +
                solution.findWords(board, words).toString());
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            System.out.println("word: " + word);
            if (wordExists(board, word))
                result.add(word);
        }
        return result;
    }

    public boolean wordExists(char[][] board, String word) {
        List<int[]> firstLetterIndexes = firstLetterIndexes(board, word.charAt(0));
        for (int[] indexes : firstLetterIndexes) {
            char[][] clonedBoard = clone2DArray(board);
            clonedBoard[indexes[0]][indexes[1]] = '*';
            if (checkNeighborsR(indexes, clonedBoard, word, 1))
                return true;
        }
        return false;
    }

    public char[][] clone2DArray(char[][] board) {
        char[][] clonedBoard = new char[board.length][];
        for (int i = 0; i < board.length; i++) {
            clonedBoard[i] = board[i].clone();
        }
        return clonedBoard;
    }

    public List<int[]> firstLetterIndexes(char[][] board, char ch) {
        List<int[]> indexes = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ch) {
                    indexes.add(new int[] { i, j });
                }
            }
        }
        return indexes;
    }

    public boolean checkNeighborsR(int[] previousCharIndexes, char[][] board, String word, int index) {
        System.out.println("board: ");
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        if (index == word.length())
            return true;
        if (previousCharIndexes[0] != 0) {
            if (board[previousCharIndexes[0] - 1][previousCharIndexes[1]] == word.charAt(index)) {
                board[previousCharIndexes[0] - 1][previousCharIndexes[1]] = '*';
                return checkNeighborsR(new int[] { previousCharIndexes[0] - 1, previousCharIndexes[1] }, board, word,
                        index + 1);
            }
        }
        if (previousCharIndexes[0] != board.length - 1) {
            if (board[previousCharIndexes[0] + 1][previousCharIndexes[1]] == word.charAt(index)) {
                board[previousCharIndexes[0] + 1][previousCharIndexes[1]] = '*';
                return checkNeighborsR(new int[] { previousCharIndexes[0] + 1, previousCharIndexes[1] }, board, word,
                        index + 1);
            }
        }
        if (previousCharIndexes[1] != 0) {
            if (board[previousCharIndexes[0]][previousCharIndexes[1] - 1] == word.charAt(index)) {
                board[previousCharIndexes[0]][previousCharIndexes[1] - 1] = '*';
                return checkNeighborsR(new int[] { previousCharIndexes[0], previousCharIndexes[1] - 1 }, board, word,
                        index + 1);
            }
        }
        if (previousCharIndexes[1] != board[previousCharIndexes[0]].length - 1) {
            if (board[previousCharIndexes[0]][previousCharIndexes[1] + 1] == word.charAt(index)) {
                board[previousCharIndexes[0]][previousCharIndexes[1] + 1] = '*';
                return checkNeighborsR(new int[] { previousCharIndexes[0], previousCharIndexes[1] + 1 }, board, word,
                        index + 1);
            }
        }
        return false;
    }
}