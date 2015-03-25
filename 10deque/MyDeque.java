import java.util.*;

public class MyDeque{

    int size = 10;
    Object[] data = new Object[size];
    int head = size / 2;
    int tail = head + 1;

    public void addFirst(T value){

    }

    public void addLast(T value){
	if (tail+1 < size && data[tail+1] != null){
	    data[tail+1] = (Object)value;
	    tail++;
	}else{
	    if (tail == size){
		tail = 0;
		if (tail+1 != head){
		    data[tail] = (Object)value;
		}
	    }
	    if (tail+1 == head){
		size*= 2;
		resize(size, data);
	    }
	}
    }




