package dp_1;

public class NoOfST {
	public static long findBalancedTR(int h) {
		if(h==0 || h==1) {
			return 1;
		}
		
		long x = findBalancedTR(h-1);
		long y = findBalancedTR(h-2);
		
		return (x*x)+ (2*x*y);
	}

	
	public static void main(String[] args) {
		System.out.println(findBalancedTR(5));
     }

}
