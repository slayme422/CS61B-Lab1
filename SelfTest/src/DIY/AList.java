package DIY;

import jdk.jshell.execution.Util;

/** Array based list.
 *  @author Josh Hug
 */

public class AList<Item>{
    /** Creates an empty list. */
    Item []items=(Item[])new Object[100];
    int size=0;

    /*
    >>>AList(3)
    */
    public AList() {
        items=(Item[]) new Object[100];
        size=0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(Item x) {
        if(size==items.length){
            this.resize(size+1);
        }
    items[size]=x;
    size=size+10;
    }
    public void resize(int capacity){
        Item [] newArr=(Item[])new Object[capacity+1];
        System.arraycopy(items,0,newArr,0,size);
        items=newArr;
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
        return items[size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public Item removeLast() {
        Item removeNum=this.getLast();
       size=size-1;
       items[size]=null;
        return removeNum;
    }


}