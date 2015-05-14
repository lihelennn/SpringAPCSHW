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
	    int sub = arr[arr[0]];
	    arr[arr[0]] = -1;
	    System.out.println(arr[0]);
	    arr[1] = sub;
	    arr[0]--;
	    switchChild(1);

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
	while (ind <= arr[0]){
	    System.out.println(this);
	    if (ind*2 <= arr[0] && ind*2+1 <= arr[0]){
		System.out.println("ind*" + arr[ind*2]);
		System.out.println("ind+" + arr[ind*2+1]);
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
	    System.out.println("ind2" + ind2);
	    if (arr[ind2] > arr[ind]){
		sub = arr[ind];
		arr[ind] = arr[ind2];
		arr[ind2] = sub;
	    }
	    ind = ind2;
	    System.out.println("IND" + ind);
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
	System.out.println(test);
	test.remove();
	test.remove();
	test.remove();
	test.remove();
	test.remove();
	test.remove();
	test.remove();
	System.out.println(test);
    }

}
