package dpQues;

public class LootHouses {
	public static int maxMoneyLooted(int[] houses) {
        int n = houses.length;
        
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return houses[0];
        }
         
        int[] dp = new int[n];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);
        
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(houses[i] + (i >= 2 ? dp[i - 2] : 0), dp[i - 1]);
        }
        
        return dp[n - 1];
    }
	
	public static void main(String[] args) {
		int[] houses = {23,45,66,12,34};
		System.out.println(maxMoneyLooted(houses));

	}

}
