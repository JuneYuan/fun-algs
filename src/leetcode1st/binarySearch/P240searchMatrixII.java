package leetcode1st.binarySearch;

public class P240SearchMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int occur = 0;
        int row = 0, col = matrix[0].length - 1;
        while (row >= 0 && row < matrix.length
            && col >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                occur++;
                col--;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return occur > 0;
    }

}
