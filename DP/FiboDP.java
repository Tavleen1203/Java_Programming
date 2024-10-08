package dp_1;

public class FiboDP {
	public static long fiboDP(int n) {
		long[] storage = new long[n+1];
		storage[0]=0;
		storage[1]=1;
		
		for(int i=2;i<=n;i++) {
			storage[i]=storage[i-1]+storage[i-2];
		}
		return storage[n];
			
	}

	public static void main(String[] args) {
		int n=100;
		System.out.println(fiboDP(n));
	}
}
