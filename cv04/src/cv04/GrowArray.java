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
public class GrowArray {
    int array[];
    
    public void enlarge(){
        int[] newarray = new int[this.array.length*2];
        for (int i=0;i<this.array.length;i++){
            newarray[i] = this.array[i];
        }
        this.array = newarray;
    }
    
    public void shrink(){
        int [] newarray = new int[this.array.length/2];
        for (int i=0;i<this.array.length/2;i++){
            newarray[i] = this.array[i];
        }
        this.array = newarray;
    }
    
}
