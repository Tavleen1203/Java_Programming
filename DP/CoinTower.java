package dpQues;

public class CoinTower {
	public static String findWinner(int n, int x, int y) {
        
        boolean[] dp = new boolean[n+1];


        dp[0]=false;
        dp[1]=true;


        for(int i =1;i<=n;i++){
            dp[i]=!dp[i-1];
            if(i-x>=0){
                dp[i]|=!dp[i-x];
            }
            if(i-y>=0){
                dp[i]|=!dp[i-y];
            }
        }
        return dp[n]? "A Wins" : "B Wins"; 
    }


	public static void main(String[] args) {
		System.out.println(findWinner(4, 2, 3));
	}
}
