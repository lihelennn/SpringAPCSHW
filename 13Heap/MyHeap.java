import java.util.*;

public class MyHeap{

    private boolean isMax = true;
    private int[]arr = new int[5];
    private int capacity = 5;


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
	System.out.println(Arrays.toString(arr));
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
	if (arr[0] == 1){
	    arr[0]--;
	    arr[1] = -1;
	}else{
	    arr[0]--;
	    int sub = arr[arr[0]];
	    arr[arr[0]] = -1;
	    arr[1] = sub;
	    switchChild(arr[0]);
	}
	return peek();
    }



    public int peek(){
	return arr[1];
    }


    private void switchParent(int ind){
	int sub;
	while (ind/2 != 0 && (isMax && arr[ind] > arr[ind/2]) || (!isMax && arr[ind] < arr[ind/2])){
	    sub = arr[ind];
	    arr[ind] = arr[ind/2];
	    arr[ind/2] = sub;
	    ind/=2;
	}
    }

    private void switchChild(int ind){
	int sub,ind2;
	while (ind < arr[0]){
	    if (ind*2 < arr[0] && ind*2+1 < arr[0]){
		if (arr[ind*2] > arr[ind*2+1]){
		    ind2 = ind*2;
		}else{
		    ind2 = ind*2+1;
		}
	    }else{
		if (ind*2 < arr[0]){
		    ind = ind*2;
		}
	    }
	    sub = arr[ind];
	    arr[ind] = arr[ind2];
	    arr[ind2] = sub;
	    ind = ind2;
	}
    }

    // while (ind*2 < arr[0]-1 && (isMax && arr[ind] < arr

    public String toString(){
	String ans = "[";
	int place = 0;
	while (place < arr.length){
	    ans+=arr[place] + "  ";
	    place++;
	}
	ans+="]";
	return ans;
    }
	 
    public static void main(String[]args){
	MyHeap test = new MyHeap();
	test.add(12);
	test.add(10);
	test.add(13);
	test.add(20);
	test.add(17);
	test.add(14);
	test.remove();
	System.out.println(test);
    }

}
