package pq_2;

public class Inplace_HeapSort {
	public static void heapSort(int[] arr) {
		
		for(int i=1;i<arr.length;i++) {
			int ci=i;
			int pi=(ci-1)/2;
			
			while(ci>0) {
				if(arr[ci]>arr[pi]) {
					break;
				}
				int temp=arr[ci];
				arr[ci]=arr[pi];
				arr[pi]=temp;
				ci=pi;
				pi=(ci-1)/2;		
			}
		}
		
		for(int i=arr.length-1;i>=0;i--) {
			int min=arr[0];
			arr[0]=arr[i];
			arr[i]=min;
			
			int pi=0;
			int li=2*pi+1;
			int ri=2*pi+2;
			
			while(pi<i) {
				int mini=pi;
				int minVal=arr[mini];
				
				if(li<i) {
					int lc = arr[li];
					if(lc<minVal) {
						mini=li;
						minVal=arr[mini];
					}
				}
				
				if(ri<i) {
					int rc = arr[ri];
					if(rc<minVal) {
						mini=ri;
						minVal=arr[mini];
					}
				}
				if(pi==mini) {
					break;
				}else {
					arr[mini]=arr[pi];
					arr[pi]=minVal;
				}
				pi=mini;
				li=2*pi+1;
				ri=2*pi+2;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr= {1,8,5,7,9,3,5,0};
		heapSort(arr);
		for(int num: arr) {
			System.out.print(num + " ");
		}
	}
}
