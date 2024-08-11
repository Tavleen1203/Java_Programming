package dpQues;

public class CoinChangeRecursion {
	public static int changeR(int[] coins, int value) {
		return changeHelper(coins,value,0);
	}

	private static int changeHelper(int[] coins, int value, int i) {
		if(value==0) {
			return 1;
		}
		if(value<0 || i == coins.length) {
			return 0;
		}
		
		return changeHelper(coins, value - coins[i],i) +  changeHelper(coins, value, i+1);
	}

	public static void main(String[] args) {
		int[] coins = {1,2,5};
		System.out.println(changeR(coins,5));

	}
}
