public class MyHeap{

    private boolean isMax = true;
    private int[]arr = new int[5];
    int capacity = 0;


    public MyHeap(){
	isMax = true;
	arr[0] = 0;
    }

    private void resize(){
	int[]sub = new int[arr[0] * 2];
	int place = 0;
	while (place < arr.length){
	    sub[place] = arr[place];
	    place++;
	}
	arr = sub;
	capacity*=2;
    }


    public void add(int n){
	if (arr[0] == 0){
	    arr[0]++;
	    arr[1] = n;
	}else{
	    if (arr[0] == capacity){
		resize();
	    }
	    arr[arr[0] + 1] = n;
	    arr[0]++;
	    switchParent(arr[0]);
	}
    }


    public void switchParent(int ind){
	int sub;
	while ((isMax && arr[ind] > arr[ind/2]) || (!isMax && arr[ind] < arr[ind/2])){
	    sub = arr[ind];
	    arr[ind] = arr[ind/2];
	    arr[ind/2] = sub;
	    ind/=2;
	}
    }
	 


}
