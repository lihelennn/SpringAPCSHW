import java.util.*;

public class MyDeque<T>{

    int size = 100;
    Object[] data = new Object[size];
    int[]nums = new int[size];
    int head = size/2;
    int tail = head+1;
    int hC = head;
    int tC = tail;
    boolean begin = true;
    boolean begin2 = true;
    int numElements = 0;

    public String name(){
	return "li.helen";
    }

    public void resize(int size1){
	Object[]ans = new Object[size1];
	int[]numbers = new int[size1];
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
	    numbers[h] = nums[hC];
	    if (hC == head){
		break;
	    }
	    h--;
	    hC--;
	}
	ans[h] = data[hC];
	numbers[h] = nums[hC];

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
	    numbers[t] = nums[tC];
	    if (tC == tail){
		break;
	    }
	    t++;
	    tC++;
	}
	ans[t] = data[tC];
	numbers[t] = nums[tC];
	hC = saveh;
	tC = savet;
	// head = hC;
	// h--;
	// t--;
	head = h;
	tail = t;
	data = ans;
	nums = numbers;
	size=size1;

    }

    public void addFirst(T value){
	// System.out.println(toString());
	// System.out.println("size" + size);
	if (size == 1){
	    data = new Object[5];
	    size = 5;
	    head = size / 2;
	    tail = head + 1;
	    hC = head;
	    tC = tail;
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
	    data = new Object[5];
	    size = 5;
	    head = size / 2;
	    tail = head + 1;
	    hC = head;
	    tC = tail;
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

    public void arrayString(){
	System.out.println(Arrays.toString(data));
	System.out.println(Arrays.toString(nums));
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

   public void add(Object o, int n){
	if (begin2){
	    nums[tail] = n;
	}else{
	    nums[tail+1] = n;
	}
	this.addLast((T)o);
    }

   public int removeSmallest(){
       //making this compatible with with I do with add(object, int): addLast
       int smallest = nums[head+1];
       int place = head+1;
       if (head <= tail){
	   smallest = nums[place];
	   while (place <= tail){
	       if (nums[place] < smallest){
		   smallest = nums[place];
	       }
	       place++;
	   }
       }
       return smallest;
   }

}








