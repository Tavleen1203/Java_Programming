package dp_1;
import java.util.*;

public class ByteLand {
	
	public static Long maxCurrencyM(Long n) {
		Map<Long,Long> dpM = new HashMap<>();
		return maxHelperM(n,dpM);
	}
	
	private static Long maxHelperM(Long n, Map<Long, Long> dpM) {
		if(n<=1) {
			dpM.put(n, n);
			return dpM.get(n);
		}
		
		if(dpM.get(n)!= null) {
			return dpM.get(n);
		}
		
		long ans = maxHelperM(n/2, dpM)+ maxHelperM(n/3, dpM)+maxHelperM(n/3, dpM);
		
		dpM.put(n,Math.max(n, ans));
		return dpM.get(n);
	}



	public static int maxCurrency(int n) {
		if(n<=1) {
			return n;
		}
		int currency = maxCurrency(n/2)+ maxCurrency(n/3)+ maxCurrency(n/4);
		int ans = Math.max(n, currency);
		
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(maxCurrencyM(15L));
	}

}
