import java.util.*;

public class HeapSort{

    public static void HeapSort(int[]array){
	//turn array into heap
	switchChild(array, array.length-1);
	sort(array);
    }

    private static void switchChild(int[]arr, int end){
	int sub,ind,ind2,ind3;
	ind = end;
	ind3 = ind;
	while (ind3 >= 0){
	    while (ind >= 0){
		if (ind*2+1 < end+1 && ind*2+2 < end+1){
		    if (arr[ind*2+1] > arr[ind*2+2]){
			ind2 = ind*2+1;
		    }else{
			ind2 = ind*2+2;
		    }
		}else{
		    if (ind*2+1 < end+1){
			ind2 = ind*2+1;
		    }else{
			break;
		    }
		}
		if (arr[ind2] > arr[ind]){
		    // System.out.println(arr[ind] + "," + arr[ind2]);
		    sub = arr[ind];
		    arr[ind] = arr[ind2];
		    arr[ind2] = sub;
		}
		ind = ind2;
	    }
	    ind3--;
	    ind = ind3;
	}
	// System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[]arr){
	int sub = 0;
	int last = arr.length-1;
	while (last>= 0){
	    sub = arr[last];
	    arr[last] = arr[0];
	    arr[0] = sub;
	    last--;
	    switchChild(arr,last);
	}
    }


    public static void main(String[]args){
	int[]a = {4, 2, 6, 1, 3, 2, 50, 14, -14, 15, 208, 10, 492, -29};
	System.out.println(Arrays.toString(a));
	HeapSort(a);
	System.out.println(Arrays.toString(a));

	int[]b = new int[50];
	int place = 49;
	int place2 = 0;
	while (place >= 0){
	    b[place2] = place;
	    place2++;
	    place--;
	}
	System.out.println(Arrays.toString(b));
	HeapSort(b);
	System.out.println(Arrays.toString(b));

	int[]c = new int[100];
	int place3 = 0;
	while (place3 < 100){
	    c[place3] = place3;
	    place3++;
	}
	System.out.println(Arrays.toString(c));
	HeapSort(c);
	System.out.println(Arrays.toString(c));
    }

}
