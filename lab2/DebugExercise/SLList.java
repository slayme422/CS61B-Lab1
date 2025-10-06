package DebugExercise;

import net.sf.saxon.type.AnyType;
import org.w3c.dom.Node;

public class SLList {
    public static String trainer = "Ash";
    class StuffNode {
        AnyType item;
        StuffNode next;
        ;
        public StuffNode(AnyType x, StuffNode n) {
            item = x;
            next = n;
        }
    }
    private StuffNode sentinel;
    private int size;
    /*add的第一个东西永远都在sentinel.next*/
    public SLList(AnyType x){
        sentinel.next=new StuffNode(x, null);
        size=1;
    }
    public void addFirst(AnyType x){

    }

    public static void main(String[] args) {

    }
    }


