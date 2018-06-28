package leetcode1st.binarySearch;

public class P74SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null) {
            return false;
        }

        int ROW = matrix.length, COL = matrix[0].length;
        int st = -1, ed = ROW * COL;
        while (st + 1 < ed) {
            int md = st + (ed - st)/2;
            if (matrix[md / COL][md % COL] < target) {
                st = md;
            } else {
                if (matrix[md / COL][md % COL] == target) {
                    return true;
                }
                ed = md;
            }
        }

        return false;
    }
}
