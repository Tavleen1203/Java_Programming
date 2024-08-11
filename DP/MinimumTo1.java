package dp_1;

public class MinimumTo1 {
	public static int minStepsTo1(int n){
		
		if(n==1) {
			return 0;
		}
		
		int op1 = minStepsTo1(n-1);
		int min=op1;
		
		if(n%3==0) {
			int op2 = minStepsTo1(n/3);
			if(op2<min) {
				min=op2;
			}
		}
		if(n%2==0) {
			int op3=minStepsTo1(n/2);
			if(op3<min) {
				min=op3;
			}
		}
		return 1 + min;
	}
	
	public static void main(String[] args) {
		System.out.println(minStepsTo1(10));
	}
}
