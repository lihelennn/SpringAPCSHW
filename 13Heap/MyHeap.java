public class MyHeap{

    private boolean isMax = true;
    private int[]arr = new int[5];


    public MyHeap(){
	isMax = true;
	arr[0] = 0;
    }

    public void add(int n){
	if (arr[0] == 0){
	    arr[0]++;
	    arr[1] = n;
	}else{
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
