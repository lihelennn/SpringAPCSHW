import java.util.*;

public class HeapSort{

    public static void HeapSort(int[]array){
	//turn array into heap
	switchParent(array);
    }


    private static void switchParent(int[]arr){
	int sub;
	int ind3 = arr.length-1;
	int ind = arr.length-1;
	while (ind3 >= 0){
	    while ((ind-1)/2 != 0){
		if ((ind-1)/2 > 0){
		    if (arr[ind] > arr[(ind-1)/1]){
			sub = arr[ind];
			arr[ind] = arr[(ind-1)/2];
			arr[(ind-1)/2] = sub;
		    }
		}
	        ind = (ind-1)/2;
	    }
	    ind3--;
	    ind=ind3;
	}
    }

    private static void switchChild(int[]arr){
	int sub,ind,ind2,ind3;
	ind = 0;
	ind3 = 0;
	while (ind3 < arr.length){
	    while (ind < arr.length){
		if (ind*2+1 < arr.length && ind*2+2 < arr.length){
		    if (arr[ind*2+1] > arr[ind*2+2]){
			ind2 = ind*2+1;
		    }else{
			ind2 = ind*2+2;
		    }
		}else{
		    if (ind*2+1 < arr.length){
			ind2 = ind*2+1;
		    }else{
			break;
		    }
		}
		if (arr[ind2] > arr[ind]){
		    System.out.println(arr[ind] + "," + arr[ind2]);
		    sub = arr[ind];
		    arr[ind] = arr[ind2];
		    arr[ind2] = sub;
		}
		ind = ind2;
	    }
	    ind3++;
	    ind = 0;
	    System.out.println(Arrays.toString(arr));
	}
    }



    public static void main(String[]args){
	int[]a = {4, 2, 6, 1, 3, 2, 50, 10, 492, -29};
	System.out.println(Arrays.toString(a));
	HeapSort(a);
	System.out.println(Arrays.toString(a));
    }

}
