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
class ListItem{
    Integer value;
    ListItem next;

}


public class SimpleLinkedList implements SimpleIntListInterface {
    
    private ListItem head;

    @Override
    public int size() {
        int count;
        count = 0;
        
        ListItem  item;
        item = this.head;
        while(item != null){
            count++;
            item = item.next;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        if (head == null){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Integer a) {
        if (this.indexOf(a)!=-1){
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Integer a) {
        ListItem newItem = new ListItem();
        newItem.value = a;
        if (head == null){
            head = newItem;
            head.next = null;
            return true;
        }
        ListItem item = head;
        while (item.next != null){
            item = item.next;
        }
        newItem.next = item.next;
        item.next = newItem;
        return true;
    }

    @Override
    public boolean add(int index, Integer a) {
        ListItem newItem = new ListItem();
        newItem.value = a;
            
        if (index == 0){
            newItem.next = head;
            head = newItem;
            return true;
        }
        ListItem item;
        item = head;
        for (int i=0;i<index;i++){
            item = item.next;
        }
        newItem.next = item.next;
        item.next = newItem;
        return true;
    }

    
    @Override
    public void print(){
       ListItem item;
       item = this.head;
       while (item != null){
           System.out.format("%d, ",item.value);
           item = item.next;
       }
       System.out.println();
    }
    
    @Override
    public boolean remove(Integer a){
            ListItem item;
            item = head;
            ListItem memitem;
            memitem = head;

            if (head.value.equals(a)){
                    head = head.next;
                    return true;		
            }

            while (! item.value.equals(a)){
                    memitem = item;
                    if (item.next == null){
                            return false;	
                    }
                    item = item.next;
            }

            memitem.next = item.next;

            return true;

    }

    @Override
    public Integer get(int index) {
	ListItem item;
	item = head;
	
	for (int i = 0; i < index; i++){
		if (item.next == null){
			throw new ArrayIndexOutOfBoundsException();	
		}
		item = item.next;	
	}	
	return item.value;
    }

    @Override
    public Integer set(int index, Integer a) {
	ListItem item;
	item = head;

	for (int i = 0; i < index; i++){
		if (item.next == null){
			throw new ArrayIndexOutOfBoundsException();	
		}
		item = item.next;	
	}	
	Integer b;
	b = item.value;
	item.value = a;

	return b;
    }


    @Override
    public void clear() {
    	head = null;
    }

    @Override
    public int indexOf(Integer a) {
	ListItem item;
	item = head;

	if (head == null){
		return -1;	
	}

	int i=0;
	while (! item.value.equals(a)){
		i++;
		if (item.next == null){
			return -1;	
		}
		item = item.next;
	}
	return i;
	
    }


    @Override
    public int[] toArray() {
	int[] array = new int[this.size()];
	ListItem item;
	item = head;

	for (int i=0;i<array.length;i++){
		array[i] = item.value;
		item = item.next;		
	}

	return array;

    }


}
