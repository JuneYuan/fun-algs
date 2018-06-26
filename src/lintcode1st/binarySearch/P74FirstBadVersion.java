package lintcode1st.binarySearch;

public class P74FirstBadVersion {

    public int findFirstBadVersion(int n) {
        int lb = 0, ub = n + 1;
        while (lb + 1 < ub) {
            int md = lb + (ub - lb)/2;
            if (VersionControl.isBadVersion(md)) {
                ub = md;
            } else {
                lb = md;
            }
        }

        return ub;
    }

}

public class VersionControl {
    public static boolean isBadVersion(int k) {
        return false;
    }
}
