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
	    for (int i=0;i<10;i++){
		tree.delete(i);	    
		System.out.println(tree.find(i));
	    }
	    tree.print();
	    tree.insert(4);
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

	boolean delete(int a){
		Node node;
		node = findRef(a);

		if (node.left == null && node.right == null){
			if (node == node.up.left){
				node.up.left = null;
			}
			if (node == node.up.right){
				node.up.right = null;
			}
			node.up = null;
			return true;
		}
		if (node.left == null){
			if (node.right.left == null){
				node.value = node.right.value; 
				if (node.right.right != null){
					node.right.right.up = node;
				}
				node.right = node.right.right;
				return;
			}
			Node next = findNext(node);
			if (next.right != null){
				next.right.up = next.up;
			}
			next.up.left = next.right;
			node.value = next.value;
			return true;
		}

		if (node.left.right == null){
			node.value = node.left.value; 
			if (node.left.left != null){
				node.left.left.up = node;
			}
			node.left = node.left.left;
			return;
		}

		Node next = findPrev(node);
		if (next.left != null){
			next.left.up = next.up;
		}
		next.up.right = next.left;
		node.value = next.value;
		return true;
	}

	Node findNext(Node n){
		n = n.right;
		while (n.left != null){
			n = n.left;
		}
		return n;
	}
	
	Node findPrev(Node n){
		n = n.left;
		while (n.right != null){
			n = n.right;
		}
		return n;
	}

	boolean find(int a){
		return (findRef(a) != null);
        }

	Node findRef(int a){
		if (root == null){
			return null;	
		}
		Node node;
		node = root;

		while (node != null){
			if (a > node.value){
				node = node.right;
				continue;
			}
			if (a == node.value){
				return node;
			}
			if (a < node.value){
				node = node.left;	
				continue;
			}
		}
		return null;
        }

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
