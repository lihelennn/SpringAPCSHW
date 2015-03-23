import java.util.*;

public class MyQueue<T>{

    LinkedList<T> queue = new LinkedList<T>();

    public MyQueue(){
    }

    public boolean enqueue(T n){
	return queue.add(n);
    }

    public T dequeue(){
	return queue.remove(0);
    }

    public boolean isEmpty(){
	return queue.size() == 0;
    }

    public String toString(){
	return queue.toString();
    }

}


