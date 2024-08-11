package dpQues;

public class Chocolates {
	public static int minChocolates(int[] rating) {
		int n = rating.length;
		int dp[] = new int[n+1];
		
		dp[0]=1;
		
		int i =0;
		int sum=0;
		
		for(i=1 ; i<n ;i++) {
			if(rating[i]>rating[i-1]) {
				dp[i]= 1+dp[i-1];
			}else {
				dp[i]=1;
			}
		}
		
		for( i = n-2; i>=0; i--) {
			if(rating[i]> rating[i+1] && dp[i]<=dp[i+1]) {
				dp[i] = 1 + dp[i+1];
			}
		}
		
		for( i=0;i<n;i++) {
			sum+=dp[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] rating = {1,0,2};
		System.out.println(minChocolates(rating));
	

	}

}
