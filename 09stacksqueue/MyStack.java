import java.util.*;

public class MyStack<T>{

    LinkedList<T> stack = new LinkedList<T>();

    public MyStack(){
    }

    public T push(T n){
	stack.add(0, n);
	return n;
    }

    public boolean empty(){
	return stack.size() == 0;
    }

    public T peek(){
	return stack.get(0);
    }

    public T pop(){
	return stack.remove(0);
    }

    public String toString(){
	return stack.toString();
    }

}

