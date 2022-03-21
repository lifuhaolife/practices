package leetcode._2022._03._0317;

public class ClimblingStairs {


    public static int climbingStairs(int n){
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }

        return r ;
    }
    public static void main(String[] args) {
        System.out.println(climbingStairs(3));
    }
}
