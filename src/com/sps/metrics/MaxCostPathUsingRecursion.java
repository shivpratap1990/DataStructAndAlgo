package com.sps.metrics;

public class MaxCostPathUsingRecursion {
    int m,n;
    int metrics[][];

    public int metricsSum(int i, int j) {
        int maxSum;
        if (i == m - 1 && j == n - 1)
            return metrics[i][j];

        if (i < m - 1 && j < n - 1) {
            int maxValue = Math.max(metricsSum(i + 1, j), (Math.max(metricsSum(i + 1, j + 1), metricsSum(i, j + 1))));
            maxSum = metrics[i][j] + maxValue;
        } else if (i < m - 1) {
            maxSum = metrics[i][j] + metricsSum(i + 1, j);
        } else {
            maxSum = metrics[i][j] + metricsSum(i, j + 1);
        }
        return maxSum;
    }

    public void metric(){
        n = m = 3;
        metrics = new int[][]{{500, 100, 230},
                {1000, 300, 100},
                {200, 1000, 200}};
        System.out.println(metricsSum(0,0));
    }

    public static void main(String[] args){
        MaxCostPathUsingRecursion obj = new MaxCostPathUsingRecursion();
        obj.metric();
    }
}
