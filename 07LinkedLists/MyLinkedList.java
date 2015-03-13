import java.util.*;

public class MyLinkedList{

    LNode a = new LNode();

    public MyLinkedList(){

    }

    public MyLinkedList(int data){
	a.setData(data);
    }

    public String toString(){
	String ans = "[";
	LNode temp = a;
	while (temp.getNext() != null){
	    ans += temp.getData() + " , ";
	    temp = temp.getNext();
	}
	ans += temp.getData();
	return ans + "]";
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
	ans++;
	return ans;
    }

    
    public int get(int index){
	LNode temp = a;
    	if (index < 0 || index >= this.size()){
    	    throw new IndexOutOfBoundsException();
    	}
	while (index > 0){
	    temp = temp.getNext();
	    index--;
	}
	return temp.getData();
    }

    public int indexOf(int i){
	int ans = 0;
	LNode temp = a;
	if (a.getData() == i){
	    return ans;
	}
	while (temp.getNext() != null){
	    if (temp.getNext().getData() == i){
		return ans + 1;
	    }
	    temp = temp.getNext();
	    ans++;
	}
	return -1;
    }

    public void add(int index, int i){
	LNode temp = a;
	if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    while (index > 1){
		temp = temp.getNext();
		index--;
	    }
	    temp.setNext(new LNode(i));
	}
    }

    
	
}
