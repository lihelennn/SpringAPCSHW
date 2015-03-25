import java.util.*;

public class MyDeque{

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

    }

    public void addLast(T value){
	if (tail+1 == head){
	    size*= 2;
	    resize(size, data);
	}
	if (tail == size){
	    tail = 0;
	    if (tail+1 != head){
		data[tail] = Object(value);
	    }
	}else{
	if (tail+1 < size && data[tail+1] == null){
	    data[tail+1] = (Object)value;
	    tail++;
	}else{
	    if (tail == size){
		tail = 0;
		if (tail+1 != head){
		    data[tail] = (Object)value;
		}
	    }
	}
	}
    }



