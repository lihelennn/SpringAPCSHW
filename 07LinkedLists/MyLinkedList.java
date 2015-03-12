import java.util.*;

public class MyLinkedList{

    LNode a = new LNode();

    public MyLinkedList(){

    }

    public String toString(){
	String ans = "";
	LNode temp = a;
	while (temp.getNext() != null){
	    ans += temp.getData();
	    temp = temp.getNext();
	}
	return ans;
    }

    public boolean add(LNode value){
	LNode temp = a;
	if (a.getNext() == null){
	    a.setNext(value);
	}else{
	    while (temp.getNext() != null){
		temp = temp.getNext();
	    }
	    temp.setNext(value);
	    a = temp;
	}
	return true;
    }

    public int size(){
	int ans = 0;
	LNode temp = a;
	while (temp.getNext() != null){
	    ans++;
	    temp = temp.getNext();
	}

    /*
    public int get(int index){
	if (index < 0 || index >= 
    */
	
}
