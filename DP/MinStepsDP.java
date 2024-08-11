package dp_1;

public class MinStepsDP {
	
	public static int minStepsDP(int n) {
		int[] storage=new int[n+1];
		
		storage[1]=0;
		
		for(int i=2;i<=n;i++) {
			int op1 = Integer.MAX_VALUE;
			int op2= Integer.MAX_VALUE;
			int op3 = Integer.MAX_VALUE;
			
			op1= storage[i-1];
			
			if(i%2==0) {
				op2=storage[i/2];
			}
			
			if(i%3==0) {
				op3= storage[i/3];
			}
			
			storage[i]=1 +Math.max(op1, Math.max(op2, op3));
		}
		
		return storage[n];
//			int min = storage[i-1];
//			if(i%3==0) {
//				if(storage[i/3]<min) {
//					min=storage[i/3];
//				}	
//			}
//			if(i%2==0) {
//				if(min>storage[i/2]) {
//					min=storage[i/2];
//				}
//			}
//			storage[i]=min+1;
//		}
//		return storage[n];
		
		
	}
	
	

	public static void main(String[] args) {
		System.out.println(minStepsDP(100));

	}

}
