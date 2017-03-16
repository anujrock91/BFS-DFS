package Snippet;

import java.util.Arrays;

public class PerfectSquares {
	
	public int minSquares(int n){
		if(n==1){ return 1; }
		int num = (int)Math.sqrt(n);
		int dp[] = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=num;j++){
				if(j*j <= i){
					dp[i] = Math.min((dp[i-(j*j)]+1),dp[i]);
				}
			}
		}
		return dp[n];
	}
	
	
	public static void main(String args[]){
		System.out.println(new PerfectSquares().minSquares(13));
	}
}
