import java.util.*;

public class MyDeque<T>{

    int size = 5;
    Object[] data = new Object[size];
    int head = size / 2;
    int tail = head + 1;
    boolean begin = true;
    boolean begin2 = true;

    public void resize(int size, Object[]data){
	Object[]ans = new Object[size];
	int place = 0;
	while (place < data.length){
	    ans[place] = data[place];
	    place++;
	}
	data=ans;
    }

    public void addFirst(T value){
	System.out.println(toString());
	System.out.println("size" + size);
	if ((head-1 == tail) || (head == 0 && tail == size-1)){
	    size*= 2;
	    resize(size, data);
	}
	if (head == 0){
	    head = size-1;
	    if (head-1 != tail){
		data[head] = value;
	    }
	}else{
	    if (begin == true){
		data[head] = value;
		begin = false;
	    }else{
		if (head-1 < size && data[head-1] == null){
		    data[head-1] = value;
		    head--;
		}
	    }
	}
    }



    public void addLast(T value){
	if ((tail+1 == head) || (tail==size-1 && head == 0)){
	    size*= 2;
	    resize(size, data);
	}
	if (tail == size-1){
	    tail = 0;
	    if (tail+1 != head){
		data[tail] = value;
	    }
	}else{
	    if (begin2 == true){
		data[tail] = value;
		begin2 = false;
	    }else{
		if (tail+1 < size && data[tail+1] == null){
		    data[tail+1] = value;
		    tail++;
		}
	    }
	}
    }

    public String toString(){
	String ans = "";
	int place = 0;
	while (place < data.length){
	    ans += data[place] + " ";
	    place++;
	}
	return ans;
    }

    public int size(){
	return size;
    }

    public T getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	T ans = (T)data[head];
	return ans;
    }

    public T getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	T ans = (T)data[tail];
	return ans;
    }

    public T removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	T ans = (T)data[head];
	data[head] = null;
	if (head != size-1){
	    head++;
	}else{
	    head = 0;
	}
	return ans;
    }

    public T removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	T ans = (T)data[tail];
	data[tail] = null;
	if (tail != 0){
	    tail--;
	}else{
	    tail = size-1;
	}
	return ans;
    }

    public static void main(String[]args){
	MyDeque<Integer>test = new MyDeque<Integer>();
	test.addFirst(10);
	test.addFirst(9);
	test.addLast(0);
	test.addLast(1);
	System.out.println(test);
	// System.out.println(test.removeLast());
	// System.out.println(test.removeFirst());
	// System.out.println(test);
	test.addFirst(8);
	System.out.println(test);
	System.out.println(test.size());
	test.addFirst(7);
	System.out.println(test.size());
	System.out.println(test);
    }

}








