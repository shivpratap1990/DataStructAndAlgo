package com.sps.metrics;

public class MaxCostPathUsingDP {

    int m,n;
    int metrics[][];

    public int metricsSumDp(){
        int maxSum = 0;
        int temp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            temp[0][i] = maxSum + metrics[0][i];
            maxSum = temp[0][i];
        }
        maxSum = 0;
        for(int i=0;i<n;i++){
            temp[i][0] = maxSum + metrics[i][0];
            maxSum = temp[i][0];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int a = temp[i-1][j];
                int b = temp[i][j-1];
                int c = temp[i-1][j-1];
                temp[i][j] = metrics[i][j] + Math.max(a,Math.max(b,c));
            }
        }

        return temp[m-1][n-1];
    }

    public static void main(String[] args){
        MaxCostPathUsingDP obj = new MaxCostPathUsingDP();
        obj.metric();
    }

    public void metric(){
        n = m = 3;
        metrics = new int[][]{{500, 100, 230},
                {1000, 300, 100},
                {200, 1000, 200}};
        System.out.println(metricsSumDp());
    }
}
