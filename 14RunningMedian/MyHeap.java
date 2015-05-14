import java.util.*;

public class MyHeap{

    private boolean isMax = true;
    private int[]arr = new int[5];
    private int capacity = 5;

    public String name(){
	return "li.helen";
    }

    public MyHeap(){
	isMax = true;
	arr[0] = 0;
    }

    public MyHeap(boolean isMaxx){
	isMax = isMaxx;
	arr[0] = 0;
    }

    private void resize(){
	int[]sub = new int[capacity * 2];
	int place = 0;
	while (place < arr.length){
	    sub[place] = arr[place];
	    place++;
	}
	arr = sub;
	capacity*=2;
    }


    public void add(int n){
	if (arr[0] == capacity-1){
	    resize();
	}
	if (arr[0] == 0){
	    arr[0]++;
	    arr[1] = n;
	}else{
	    arr[arr[0] + 1] = n;
	    arr[0]++;
	    switchParent(arr[0]);
	}
    }

    public int remove(){
	if (arr[0] <= 0){
	    throw new NoSuchElementException();
	}else{
	    int largest = arr[1];
	    if (arr[0] == 1){
		arr[0]--;
		arr[1] = -1;
	    }else{
		int sub = arr[arr[0]];
		arr[arr[0]] = -1;
		arr[1] = sub;
		arr[0]--;
		switchChild(1);

	    }
	    return largest;
	}
    }

    public int peek(){
	if (arr[0] > 0){
	    return arr[1];
	}
	throw new NoSuchElementException(); 
    }


    private void switchParent(int ind){
	int sub;
	while (ind/2 != 0 && (isMax && arr[ind] > arr[ind/2]) || (!isMax && arr[ind] < arr[ind/2])){
	    if (ind/2 > 0){
		sub = arr[ind];
		arr[ind] = arr[ind/2];
		arr[ind/2] = sub;
	    }
	    ind/=2;
	}
    }

    private void switchChild(int ind){
	int sub,ind2;
	if (isMax){
	    while (ind <= arr[0]){
		if (ind*2 <= arr[0] && ind*2+1 <= arr[0]){
		    if (arr[ind*2] > arr[ind*2+1]){
			ind2 = ind*2;
		    }else{
			ind2 = ind*2+1;
		    }
		}else{
		    if (ind*2 <= arr[0]){
			ind2 = ind*2;
		    }else{
			break;
		    }
		}
		if (arr[ind2] > arr[ind]){
		    sub = arr[ind];
		    arr[ind] = arr[ind2];
		    arr[ind2] = sub;
		    ind = ind2;
		}else{
		    //break out if no more shifting down is required
		    ind = arr[0] + 1;
		}
	    }
	}else{
	    while (ind <= arr[0]){
		if (ind*2 <= arr[0] && ind*2+1 <= arr[0]){
		    if (arr[ind*2] < arr[ind*2+1]){
			ind2 = ind*2;
		    }else{
			ind2 = ind*2+1;
		    }
		}else{
		    if (ind*2 <= arr[0]){
			ind2 = ind*2;
		    }else{
			break;
		    }
		}
		// System.out.println("ind2" + ind2);
		if (arr[ind2] < arr[ind]){
		    sub = arr[ind];
		    arr[ind] = arr[ind2];
		    arr[ind2] = sub;
		    ind = ind2;
		}else{
		    //break out if no more shifting down is required
		    ind = arr[0] + 1;
		}
	    }
	}
    }
  
    public String toStringH(){
	String ans = "[";
	int place = 0;
	while (place < arr.length){
	    ans+=arr[place] + "  ";
	    place++;
	}
	ans+="]";
	return ans;
    }

    public String toString() {
	String ans = "";
	if (arr[0] > 0){
	    int level = getHeight();
	    int place = 0;
	    while (place <= level){
		ans += getLevel( place) + "\n";
		place++;
	    }
	    return ans;
	}
	return ans + "\n";
    }

    private int getHeight(){
	int times = 0;
	int sub = 0;
	while (sub < arr[0]){
	    sub += (int)Math.pow(2, times);
	    times++;
	}
	return times;
    }

    private String getLevel(int level) {
	if (level == 0){
	    return Integer.toString(arr[1]);
	}
	int start = (int)Math.pow(2, level);
	String ans = "";
	while (start <= arr[0] && start < (int)Math.pow(2,level+1)){
	    ans += arr[start] + "  ";
	    start++;
	}
	return ans;
    }

	 
    public static void main(String[]args){
	MyHeap test = new MyHeap();

	System.out.println(test.name());

	test.add(12);
	System.out.println(test);
	test.add(10);
	System.out.println(test);
	test.add(13);
	System.out.println(test);
	test.add(20);
	System.out.println(test);
	test.add(17);
	System.out.println(test);
	test.add(14);
	System.out.println(test);
	test.add(32);
	System.out.println(test);
	test.add(6);
	System.out.println(test);
	test.add(99);
	System.out.println(test);
	test.add(-142);
	System.out.println(test);

	System.out.println(test.peek());

	System.out.println(test.remove());
	System.out.println(test);
	System.out.println(test.remove());
	System.out.println(test);
	System.out.println(test.remove());
	System.out.println(test);
	System.out.println(test.remove());
	System.out.println(test);
	System.out.println(test.remove());
	System.out.println(test);
	System.out.println(test.remove());
	System.out.println(test);
	System.out.println(test.remove());
	System.out.println(test);
	System.out.println(test.remove());
	System.out.println(test);
	System.out.println(test.remove());
	System.out.println(test);
	System.out.println(test.remove());
	System.out.println(test);
	System.out.println(test.remove());
	System.out.println(test);
    }

}
