import java.util.*;

public class LNode{
    private LNode next;
    private int data;

    public LNode(int n){
	data = n;
    }

    // public LNode(){
    // 	data=null;
    // 	next = null;
    // }

    public LNode(){
	// data = null;
    }

    public LNode(int n, LNode m){
	data = n;
	next = m;
    }

    public int getData(){
	return data;
    }

    public void setData(int n){
	data = n;
    }

    public LNode getNext(){
	return next;
    }

    public void setNext(LNode n){
	next = n;
    }

    public String toString(){
	return "[" + this.getData() + "]";
    }

}

