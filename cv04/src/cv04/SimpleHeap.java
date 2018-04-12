/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv04;

/**
 *
 * @author jethro
 */
public class SimpleHeap {
	public int size;
	private int [] array;

	public SimpleHeap(int capacity){
		this.size = 0;
		this.array = new int[capacity+1];
	}


	public void insert(int num){
		this.size++;
		this.array[this.size] = num;
		int index = this.size;		
		while (index > 1){
			if (this.array[index] < this.array[index/2]){
				int tmp = this.array[index];
				this.array[index] = this.array[index/2];
				this.array[index/2] = tmp;
				index = index/2;				
			} else {
				break;
			}
		}
	}

	public int extractMin(){
		int num = this.array[1];
		int tmp;
		tmp = this.array[this.size];
		this.array[this.size] = this.array[1];
		this.array[1] = tmp;
		this.size--;
		int index = 1;
		while (index <= size){
			if (index*2 > size){
				break;
			}
			if (index*2+1 > size){
				if (this.array[index*2] < this.array[index]){
					tmp = this.array[index];
					this.array[index] = this.array[index*2];
					this.array[index*2] = tmp;
				}
				break;	
			}
			if ((this.array[index] <= this.array[index*2])&&
				(this.array[index] <= this.array[index*2+1])){
				break;
			}
			if (this.array[index*2] < this.array[index*2+1]){
				tmp = this.array[index*2];
				this.array[index*2] = this.array[index];
				this.array[index] = tmp;
				index = index*2;
			} else {
				tmp = this.array[index*2+1];
				this.array[index*2+1] = this.array[index];
				this.array[index] = tmp;
				index = index*2+1;
			}

		}		
		return num;		
	}

	public static void main(String []args){
		SimpleHeap sh;
		sh = new SimpleHeap(10);

		for (int i=0;i<10;i++){
			sh.insert(10-i);
		}
		
		for (int i=0;i<10;i++){
			System.out.format("%d ",sh.extractMin());
		}


	}
    
}
