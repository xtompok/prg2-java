/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv06;

/**
 *
 * @author jethro
 */
public class Cv06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	    RBTree tree = new RBTree();
	    for (int i=0;i<10;i++){
	    	tree.insert(i);
	    	tree.insert(10-i);
	    
	    }
	    tree.print();
    }
    
}

class RBTree {
	Node root;

	public RBTree(){
		root = null;	
	}

	void insert(int a){
		if (root == null){
			root = new Node(a);
		}	
		Node item = root;
		while (true){
			if (a == item.value){
				return;	
			}
			if (a < item.value) {
				if (item.left == null){
					Node n = new Node(a);
					item.left = n;
					n.up = item;
					return;
				}
				item = item.left;
			} else {
				if (item.right == null){
					Node n = new Node(a);
					item.right = n;
					n.up = item;
					return;
				}
				item = item.right;
			}
		}
	}

	boolean delete(int a){}

	boolean find(int a){}

	void print(){
		System.out.println("Printing tree:");
		print(root);
	}	

	void print(Node n){
		if (n == NULL){
			return;	
		}
		n.print();
		print(n.left);
		print(n.right);
	}
}

class Node {
	int value;
	Node up;
	Node left;
	Node right;	
	
	public Node(int a){
		value = a;	
		up = null;
		left = null;
		right = null;
	}

	public void print(){
		System.out.format("N%d: ",value);
		if (up != null){
			System.out.format("u:%4d ",up.value);	
		} else {
			System.out.print("u:NULL ");	
		}
		if (left != null){
			System.out.format("l:%4d ",left.value);	
		} else {
			System.out.print("l:NULL ");	
		}
		if (right != null){
			System.out.format("r:%4d ",right.value);	
		} else {
			System.out.print("r:NULL ");	
		}
		System.out.println();
	}
}
