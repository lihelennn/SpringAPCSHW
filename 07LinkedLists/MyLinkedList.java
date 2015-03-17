import java.util.*;

public class MyLinkedList<T>{

    LNode<T> a = new LNode<T>();
    LNode<T> tail = new LNode<T>();
    LNode<T> dummy = new LNode<T>();
    int size = 0;

    public String name(){
	return "li.helen";
    }

    public MyLinkedList(){
	a = null;
	tail = null;
	dummy = null;
    }

    public MyLinkedList(T data){
	size = 1;
	a.setData(data);
	tail.setData(data);
	dummy.setNext(a);
    }

    public String toString(){
	String ans = "[";
	LNode<T> temp = a;
	if (temp.getData() != null){
	    while (temp.getNext() != null){
		ans += temp.getData() + " , ";
		temp = temp.getNext();
	    }
	}
	if (temp.getData() != null){
	    ans += temp.getData();
	}
	return ans + "]";
    }

    /*
      public boolean add(T i){
      // LNode<T> temp = a;
      LNode<T> temp = tail;
      // if (a.getNext() == null){
      //     a.setNext(new LNode<T>(i));
      if (a.getData() == null){
      a.setData(i);
      // tail = a;
      System.out.println("1");
      }else{
      while (temp.getNext() != null){
      temp = temp.getNext();
      }
      temp.setNext(new LNode<T>(i));
      // tail = temp.getNext();
      System.out.println("2");
      }
      size++;
      tail = temp.getNext();
      return true;
      }
    */
    

    public boolean add(T i){
	// System.out.println("tail");
	// System.out.println(tail);
	// System.out.println("a");
	// System.out.println(a);
	LNode<T> temp = a;
	if (temp.getData() == null){
	    temp.setData(i);
	}else{
	    while (temp.getNext() != null){
		temp = temp.getNext();
	    }
	    temp.setNext(new LNode<T>(i));

	}
	tail = temp.getNext();
	size++;
	// tail = tail.getNext();
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

    
    public T get(int index){
	LNode<T> temp = a;
	if (index < 0 || index >= this.size()){
	    throw new IndexOutOfBoundsException();
	}
	while (index > 0){
	    temp = temp.getNext();
	    index--;
	}
	return temp.getData();
    }

    public int indexOf(T i){
	int ans = 0;
	LNode<T> temp = a;
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

    public void add(int index, T i){
	LNode<T> temp = dummy;
	LNode<T> temp1 = a;
	if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    while (index > 0){
		temp = temp.getNext();
		index--;
	    }
	    LNode<T> help = temp.getNext();
	    temp.setNext(new LNode<T>(i));
	    temp = temp.getNext();
	    temp.setNext(help);
	}    
	size++;
	while (temp.getNext() != null){
	    temp = temp.getNext();
	    tail = temp;
	}
	if (dummy.getNext() != null){
	    a = dummy.getNext();
	}
	// System.out.println(tail.toString());
    }

    public T set(int index, T i){
	LNode<T> temp = a;
	T old;
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
	while (temp.getNext() != null){
	    temp = temp.getNext();
	    tail = temp;
	}
	if (dummy.getNext() != null){
	    a = dummy.getNext();
	}
     
	return old;
    }   

    public T remove(int index){
	T old;
	LNode<T> temp = a;
	if (index < 0 || index >= size ()){
	    throw new IndexOutOfBoundsException();
	}else{
	    if (size == 1){
		old = temp.getData();
		temp.setData(null);
		size = 0;
	    }else{
		if (index == 0){
		    old = temp.getData();
		    temp.setData(temp.getNext().getData());
		    temp.setNext(temp.getNext().getNext());
		}else{
		    while (index > 1){
			temp = temp.getNext();
			index--;
		    }
		    old = temp.getNext().getData();
		    temp.setNext(temp.getNext().getNext());
		}
		size--;
		while (temp.getNext() != null){
		    temp = temp.getNext();
		    tail = temp;
		}
	    }
	}
	if (dummy.getNext() != null){
	    a = dummy.getNext();
	}
	return old;
    }

}
