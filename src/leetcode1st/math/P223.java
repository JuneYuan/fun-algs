package leetcode1st.math;

public class P223 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int intersectionArea = 0;
        
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        if (left <= right && bottom <= top) {
            intersectionArea = (right - left) * (top - bottom);
        }
        
        int rectArea1 = Math.abs(C - A) * Math.abs(D - B);
        int rectArea2 = Math.abs(G - E) * Math.abs(H - F);
        int ans = rectArea1 + rectArea2 - intersectionArea;
        return ans;
    }

}
