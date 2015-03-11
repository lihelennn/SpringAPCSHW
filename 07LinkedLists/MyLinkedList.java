import java.util.*;

public class MyLinkedList{

    LNode a = new LNode();

    public MyLinkedList(){

    }

    public String toString(){
	String ans = "";
	while (a.getNext() != null){
	    ans += a.getData();
	}
	return ans;
    }
}
