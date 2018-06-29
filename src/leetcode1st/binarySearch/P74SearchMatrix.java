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

    public boolean solution(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null) {
            return false;
        }

        // find first row >= target
        int[] row = null;
        int ROW = matrix.length, COL = matrix[0].length;
        int st = 0, ed = ROW - 1;
        while (st + 1 < ed) {
            int md = st + (ed - st)/2;
            if (matrix[md][COL - 1] == target) {
                st = md;
            } else if (matrix[md][COL - 1] < target) {
                st = md;
            } else {
                ed = md;
            }
        }

        if (COL > 0 && matrix[st][COL - 1] >= target) {
            row = matrix[st];
        } else if (COL > 0 && matrix[ed][COL - 1] >= target) {
            row = matrix[ed];
        } else {
            return false;
        }

        // binary search in row
        st = 0;
        ed = COL - 1;
        while (st + 1 < ed) {
            int md = st + (ed - st)/2;
            if (row[md] == target) {
                return true;
            } else if (row[md] < target) {
                st = md;
            } else {
                ed = md;
            }
        }

        return (row[st] == target || row[ed] == target);
    }

}
