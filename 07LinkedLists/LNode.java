import java.util.*;

public class LNode<T>{
    private LNode<T> next;
    private T data;
    
     public String name(){
	return "li.helen";
    }

    public LNode(T n){
	setData(n);
    }

    // public LNode(){
    // 	data=null;
    // 	next = null;
    // }

    public LNode(){
	// data = null;
    }

    public LNode(T n, LNode<T> m){
	data = n;
	next = m;
    }

    public T getData(){
	return data;
    }

    public void setData(T n){
	data = n;
    }

    public LNode<T> getNext(){
	return next;
    }

    public void setNext(LNode<T> n){
	next = n;
    }

    public String toString(){
	return "[" + this.getData() + "]";
    }

}

