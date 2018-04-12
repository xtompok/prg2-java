/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv02;

/**
 *
 * @author jethro
 */
public class Cv02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        SimpleIntListInterface list = new SimpleLinkedList();
        
        System.out.println(list.isEmpty());

	list.add(10);
	list.add(5);
	list.add(0,3);
	list.add(1,8);
	((SimpleLinkedList)list).print();	
        list.remove(10);
        list.remove(5);
        list.remove(3);
        list.remove(8);
        ((SimpleLinkedList)list).print();
    }
    
}
