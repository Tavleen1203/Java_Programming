package dp_1;

import java.util.Arrays;

public class Fibo_Mem {
	public static int fiboMemoized(int n) {
		int[] storage = new int[n+1];
		Arrays.fill(storage, -1);
		return fiboMHelper(n, storage);
	}
	
	public static int fiboMHelper(int n, int[] storage) {
		if(n==0 || n==1) {
			storage[n]=n;
			return storage[n];
		}
		
		if(storage[n]!=-1) {
			return storage[n];
		}
		
		storage[n]=fiboMHelper(n-1,storage)+fiboMHelper(n-2,storage);
		return storage[n];
	}

	public static void main(String[] args) {
		int n=44;
		System.out.println(fiboMemoized(n));
	}

}
