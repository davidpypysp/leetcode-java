package com.shiping.leetcode.easy;

/**
 * Created by davidpy on 5/25/16.
 */
public class RectangleArea {
    public static void main(String[] args) {
        new RectangleArea().computeArea(-3,-3,0,5,-3,-3,3,3);
    }
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overlap = 0;
        if(A < E) {
            overlap =  comput(A, B, C, D, E, F, G, H);
        }
        else {
            overlap = comput(E, F, G, H, A, B, C, D);
        }
        return (C-A) * (D-B) + (G-E) * (H-F) - overlap;
    }

    public int comput(int lx1, int ly1, int lx2, int ly2, int rx1, int ry1, int rx2, int ry2) {
        if(lx2 <= rx1 || ly1 >= ry2 || ly2 <= ry1) { //not overlap
            return 0;
        }
        else if(lx1 <= rx1 && ly1 <= ry1 && lx2 >= rx2 && ly2 >= ry2) { //fully overlap
            return (ry2 - ry1) * (rx2 - rx1);
        }
        else { // partially overlap
            int cy1 = ry1 < ly1 ? ly1 : ry1;
            int cx1 = rx1;
            int cy2 = ry2 < ly2 ? ry2 : ly2;
            int cx2 = rx2 < lx2 ? rx2 : lx2;
            return (cy2 - cy1) * (cx2 - cx1);
        }
    }
}
