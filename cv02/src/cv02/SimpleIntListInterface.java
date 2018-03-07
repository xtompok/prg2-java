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
public interface SimpleIntListInterface {
    int size();
    boolean isEmpty();
    boolean contains(Integer a);
    int [] toArray();
    boolean add(Integer a);
    boolean add(int index, Integer a);
    boolean remove(Integer a);
    Integer get(int index);
    Integer set(int index,Integer a);
    void clear();
    int indexOf(Integer a);
}
