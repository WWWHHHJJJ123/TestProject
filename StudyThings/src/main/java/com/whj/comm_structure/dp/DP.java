package com.whj.comm_structure.dp;

/**
 * @author CiZhong
 * @date 2024-11-05
 */
public class DP {

    public static void main(String[] args) {

        int[][] a = {{1}, {3, 2}, {4, 10, 1}, {4, 3, 2, 20}};
        int[][] newArr = a.clone();
        System.out.println(newArr.length);
        System.out.println(solve(a, 0, 0));

    }


    public static int solve(int[][] a, int i, int j) {

        //第 n+1 层结束  ===》从0层开始计算 ，那么 i = n 时结束
        if (i == a.length) {
            return 0;
        }


        return a[i][j] + Math.max(solve(a, i + 1, j), solve(a, i + 1, j + 1));
    }

}
