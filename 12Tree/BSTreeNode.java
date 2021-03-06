import java.io.*;
import java.util.*;

//type cast the data in compare to to type t
public class BSTreeNode<T extends Comparable> {

    private T data;
    private BSTreeNode<T> left;
    private BSTreeNode<T> right;

    public String name(){
	return "li.helen";
    }

    public BSTreeNode( T d ) {
 
	data = d;
	left = right = null;
    }
    
    //accessors
    public T getData() {
	return data;
    }
    public BSTreeNode<T> getLeft() {
	return left;
    }
    public BSTreeNode<T> getRight() {
	return right;
    }

    //mutators
    public void setData( T d ) {
	data = d;
    }
    public void setLeft( BSTreeNode<T> l ) {
	left = l;
    }
    public void setRight( BSTreeNode<T> r ) {
	right = r;
    }

    //empty?
    public boolean rightEmpty(){
	return right == null;
    }

    public boolean leftEmpty(){
	return left == null;
    }

    //toString
    public String toString(){
	if (this == null){
	    return "";
	}else{
	    String ans = "";
	    ans += this.getData();
	    return ans;
	}
    }

}
