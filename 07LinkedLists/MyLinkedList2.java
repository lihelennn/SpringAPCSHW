import java.util.*;

public class MyLinkedList2{

    LNode a = new LNode();
    LNode tail = new LNode();
    int size = 0;

    public MyLinkedList(){
	a = null;
    }

    public MyLinkedList(int data){
	size = 1;
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

    public boolean add(int i){
	LNode temp = a;
	if (a.getNext() == null){
	    a.setNext(new LNode(i));
	}else{
	    while (temp.getNext() != null){
		temp = temp.getNext();
	    }
	    temp.setNext(new LNode(i));
	}
	size++;
	tail = temp;
	return true;
    }

    public int size(){
	// int ans = 0;
	// LNode temp = a;
	// while (temp.getNext() != null){
	//     ans++;
	//     temp = temp.getNext();
	// }
	// ans++;
	// return ans;
	return size;
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
	    if (index == 0){
		temp.setNext(new LNode(a.getData()));
		temp.setData(i);
		// LNode b = new LNode(i);
		// b.setNext(temp);
	    }else{
		while (index > 1){
		    temp = temp.getNext();
		    index--;
		}
		temp.setNext(new LNode(i));
	    }
	}
	size++;
	while (temp.getNext() != null){
	    temp = temp.getNext();
	}
	tail = temp;
    }

    public int set(int index, int i){
	LNode temp = a;
	int old = 0;
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    while (index > 0){
		temp = temp.getNext();
		index--;
	    }
	    old = temp.getData();
	    temp.setData(i);
	}
	return old;
    }   

    public int remove(int index){
	int old = 0;
	LNode temp = a;
	if (index < 0 || index >= size ()){
	    throw new IndexOutOfBoundsException();
	}else{
	    if (index == 0){
		old = temp.getData();
		temp = null;
		size = 0;
	    }else{
		while (index > 1){
		    temp = temp.getNext();
		    index--;
		}
		old = temp.getNext().getData();
		temp.setNext(temp.getNext().getNext());
		size--;
	    
		while (temp.getNext() != null){
		    temp = temp.getNext();
		}
		tail = temp;
	    }
	}
	return old;

    }
	
}
