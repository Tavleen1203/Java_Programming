package dp_1;

public class MinSteps_Memo {
	
	public static int minStepsM(int n) {
		int[] storage = new int[n+1];
		return minStepsHelper(n,storage);
	}

	private static int minStepsHelper(int n, int[] storage) {
		if(n==1) {
			storage[n]=0;
			return storage[n];
		}
		
		if(storage[n]!=0) {
			return storage[n];
		}
		
		int op1 = minStepsHelper(n-1,storage);
		int min=op1;
		
		if(n%3==0) {
			int op2 = minStepsHelper(n/3,storage);
			if(op2<min) {
				min=op2;
			}
		}
		if(n%2==0) {
			int op3=minStepsHelper(n/2,storage);
			if(op3<min) {
				min=op3;
			}
		}
		storage[n]=1 + min;
		return storage[n];
		
	}

	public static void main(String[] args) {
		int n=33;
		System.out.println(minStepsM(n));

	}

}
