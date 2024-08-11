package pq_1;

import java.util.ArrayList;

public class Priority_Queue {
	
	private ArrayList<Integer> heap;
	
	public Priority_Queue() {
		heap = new ArrayList<Integer>();
	}
	
	boolean isEmpty() {
		return heap.size()==0;
	}
	
	int size() {
		return heap.size();
	}
	
	int getMin() throws PQ_Empty_Exception {
		if(isEmpty()) {
			throw new PQ_Empty_Exception();
		}
		return heap.get(0);
	}
	
	void insert(int item) {
		heap.add(item);
		
		//UP-HEAPIFY
		int index = heap.size()-1;
		int pi = (index-1)/2;
		while(index>0) {
			if(heap.get(index)<heap.get(pi)) {
				int temp = heap.get(index);
				heap.set(index, heap.get(pi));
				heap.set(pi, temp);
				index = pi ;
				pi = (index-1)/2;
			}else {
				return;
			}
		}
	}
	
	int removeMin() throws PQ_Empty_Exception {
		if(isEmpty()) {
			throw new PQ_Empty_Exception();
		}
		
		int temp = heap.get(0);
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		//DOWN-HEAPIFY
		int index = 0;
		int minIndex=0;
		int lc = 1;
		int rc = 2;
		
		while(lc<heap.size()) {
			if(heap.get(lc)<heap.get(minIndex)) {
				minIndex=lc;
			}
			if(rc<heap.size()&& heap.get(rc)<heap.get(minIndex)) {
				minIndex=rc;
			}
			if(minIndex==index) {
				break;
			}else {
				int temp1 = heap.get(index);
				heap.set(index,  heap.get(minIndex));
				heap.set(minIndex, temp1);
				index=minIndex;
				lc=2*index+1;
				rc=2*index+2;
			}
		}
		return temp;		
	}
	
}
