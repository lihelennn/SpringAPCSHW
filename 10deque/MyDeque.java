import java.util.*;

public class MyDeque<T>{

    int size = 5;
    Object[] data = new Object[size];
    int head = size/2;
    int tail = head+1;
    int hC = head;
    int tC = tail;
    boolean begin = true;
    boolean begin2 = true;
    int numElements = 0;

    public void resize(int size1){
	Object[]ans = new Object[size1];
	int h = size1/2;
	int t = h + 1;
	int saveh = h;
	int savet = t;
	while (hC != head){
	    // System.out.println(Arrays.toString(data));
	    // System.out.println(Arrays.toString(ans));
	    // System.out.println(hC);
	    if (h == -1){
		h = size1-1;
	    }
	    if (hC == -1){
		hC = size-1;
	    }
	    ans[h] = data[hC];
	    if (hC == head){
		break;
	    }
	    h--;
	    hC--;
	}
	ans[h] = data[hC];
	while (tC != tail){
	    // System.out.print(tC);
	    // System.out.println(size);
	    // System.out.println(Arrays.toString(ans));
	    if (t == size1){
		t = 0;
	    }
	    if (tC == size){     
		tC = 0;
	    }
	    ans[t] = data[tC];
	    if (tC == tail){
		break;
	    }
	    t++;
	    tC++;
	}
	ans[t] = data[tC];
	hC = saveh;
	tC = savet;
	// head = hC;
	// h--;
	// t--;
	head = h;
	tail = t;
	data = ans;
	size=size1;

    }

    public void addFirst(T value){
	// System.out.println(toString());
	// System.out.println("size" + size);
	if (size == 1){
	    resize(5);
	}
	if (((head-1 == tail  || head == tail) && (data[head] != null && data[head-1] != null)) || (head == 0 && tail == size-1)){
	    // System.out.println("need to resize first");
	    resize(size*2);
	}
	if (head == 0){
	    head = size-1;
	    if (data[head] == null || head-1 != tail){
		data[head] = value;
		// System.out.println(1);
	    }
	}else{
	    if (begin == true){
		data[head] = value;
		begin = false;
		// System.out.println(2);
	    }else{
		if (head-1 < size || data[head-1] == null){
		    data[head-1] = value;
		    head--;
		    // System.out.println(3);
		}
	    }
	}
	numElements++;
    }


    public void addLast(T value){
	if (size == 1){
	    resize(5);
	}
	if (((tail+1 == head || head == tail) && (data[tail] != null && data[tail+1] != null)) || (tail==size-1 && head == 0)){
	    // System.out.println("need to resize last");
	    resize(size*2);
	}
	if (tail == size-1){
	    tail = 0;
	    if (tail != head){
		data[tail] = value;
	    }
	}else{
	    if (begin2 == true){
		data[tail] = value;
		begin2 = false;
	    }else{
		// if (tail+1 < size && data[tail+1] == null){
		if (tail + 1 < size){
		    data[tail+1] = value;
		    tail++;
		}
	    }
	}
	numElements++;
    }

    public String toString(){
	String ans = "";
	int place = 0;
	while (place < data.length){
	    ans += data[place] + " ";
	    place++;
	}
	return ans + "head:" + head + "   tail:" + tail;
    }

    public int size(){
	return size;
    }

    public T getFirst(){
	if (numElements == 0){
	    throw new NoSuchElementException();
	}
	T ans = (T)data[head];
	return ans;
    }

    public T getLast(){
	if (numElements == 0){
	    throw new NoSuchElementException();
	}
	T ans = (T)data[tail];
	return ans;
    }

    public T removeFirst(){
	if (numElements == 0){
	    throw new NoSuchElementException();
	}
	T ans = (T)data[head];
	data[head] = null;
	if (head != size-1){
	    head++;
	}else{
	    head = 0;
	}
	numElements--;
	return ans;
    }

    public T removeLast(){
	if (numElements == 0){
	    throw new NoSuchElementException();
	}
	T ans = (T)data[tail];
	data[tail] = null;
	if (tail != 0){
	    tail--;
	}else{
	    tail = size-1;
	}
	numElements--;
	return ans;
    }


    public static void main(String[]args){
	MyDeque<Integer>test = new MyDeque<Integer>();
	// test.addFirst(10);
	// test.addFirst(9);
	// test.addLast(0);
	// test.addLast(1);
	// System.out.println(test);
	// // System.out.println(test.removeLast());
	// // System.out.println(test.removeFirst());
	// // System.out.println(test);
	// test.addFirst(8);
	// System.out.println(test);
	// System.out.println(test.size());
	// test.addFirst(7);
	// System.out.println(test.size());
	// System.out.println(test);
	// System.out.println(test.removeFirst());
	// System.out.println(test.removeFirst());
	// // System.out.println(test);
	// test.addLast(2);
	// test.addLast(3);
	// test.addLast(4);
	// test.addLast(5);
	// System.out.println(test);
	// test.addLast(6);
	// test.addFirst(7);
	// System.out.println(test);
	// test.addLast(8);
	// System.out.println(test);
	// test.addFirst(10);
	// System.out.println(test);
	// test.addFirst(9);
	// System.out.println(test);
	// test.addFirst(8);
	// System.out.println(test);
	// test.addFirst(7);
	// System.out.println(test);
	// test.addFirst(6);
	// System.out.println(test);
	// System.out.println(test.removeFirst());
	// System.out.println(test);
	// test.addLast(100);
	// System.out.println(test);
	// test.addLast(10000);
	// System.out.println(test);
	// test.addLast(2);
	// System.out.println(test);
	// test.addLast(30000);
	// System.out.println(test);
	// test.addLast(40000);
	// System.out.println(test);
	// test.addLast(50000);
	// System.out.println(test);
	// test.addLast(60000);
	// System.out.println(test);
	// test.addLast(70000);
	// System.out.println(test);
	// test.addLast(80000);
	// System.out.println(test);
	// test.addLast(90000);
	// System.out.println(test);
	// System.out.println(test.size());
	// test.addFirst(111);
	// System.out.println(test);

	// test.addFirst(222);
	// System.out.println(test);

	// test.addFirst(333);
	// System.out.println(test);

	// test.addFirst(444);
	// System.out.println(test);
	// test.addFirst(555);
	// System.out.println(test);
	// test.addFirst(666);
	// System.out.println(test);
	// test.addFirst(666);
	// System.out.println(test);
	// System.out.println(test.size());
	// System.out.println(test.removeFirst());
	// System.out.println(test.removeFirst());
	// System.out.println(test.removeFirst());
	// System.out.println(test.removeFirst());
	// System.out.println(test.removeFirst());
	// System.out.println(test.removeFirst());
	// System.out.println(test.removeFirst());
	// System.out.println(test.removeFirst());
	// System.out.println(test.removeFirst());	
	// System.out.println(test.removeFirst());
	// System.out.println(test.removeFirst());
	// System.out.println(test.removeFirst());
	// System.out.println(test.removeFirst());
	// System.out.println(test);
	// System.out.println(test.removeLast());
	// System.out.println(test);
	// System.out.println(test.removeLast());
	// System.out.println(test.removeLast());
	// System.out.println(test.removeLast());
	// System.out.println(test.removeLast());
	// System.out.println(test.removeLast());
	// System.out.println(test.removeLast());
	// System.out.println(test.removeLast());
	// test.addLast(2);
	// System.out.println(test);
	// test.addLast(3);
	// System.out.println(test);
	// test.addFirst(100);
	// System.out.println(test);
	// System.out.println(test.getFirst());
	// System.out.println(test.getLast());
	// System.out.println(test.removeLast());
	// System.out.println(test.getLast());
	// System.out.println(test.removeFirst());
	// System.out.println(test.getFirst());
	// System.out.println(test);

	test.addFirst(10);
	test.addLast(20);
	System.out.println(test.getFirst());
	System.out.println(test.getLast());
	System.out.println(test.removeFirst());
	System.out.println(test);
	System.out.println(test.getFirst());
	System.out.println(test.removeLast());









    }

}








