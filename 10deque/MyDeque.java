import java.util.*;

public class MyDeque<T>{

    int size = 10;
    Object[] data = new Object[size];
    int head = size / 2;
    int tail = head + 1;

    public static void resize(int size, Object[]data){
	Object[]new = new Object[size];
	int place = 0;
	while (place < data.length){
	    new[place] = data[place];
	    place++;
	}
    }

    public void addFirst(T value){
	if ((head-1 == tail) || (head == 0 && tail == size-1)){
	    size*= 2;
	    resize(size, data);
	}
	if (head == 0){
	    head = size-1;
	    if (head-1 != tail){
		data[head] = Object(value);
	    }
	}else{
	    if (head-1 < size && data[head-1] == null){
		data[head-1] = (Object)value;
	        head--;
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
		data[tail] = Object(value);
	    }
	}else{
	    if (tail+1 < size && data[tail+1] == null){
		data[tail+1] = (Object)value;
		tail++;
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

    public static void main(String[]args){
	MyDeque<Integer> = 

	    }

    public T getFirst(){
	T ans = (T)data[head];
	return ans;
    }

    public T getLast(){
	T ans = (T)data[tail];
	return ans;
    }






