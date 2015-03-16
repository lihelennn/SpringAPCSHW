import java.util.*;

public class Sorts{

    public String name(){
	return "li.helen";
    }

    public static int partition(int[]ary, int si, int ei){
	int[]D = new int[ary.length];
	int place = 0;

	//copy some elements over to a new copy
	while (place < ary.length){
	    if (place < si || place > ei){
		D[place]=ary[place];
	    }
	    place++;
	}

	//choose a pivot element

	Random r = new Random();
	int pivotal = ary[r.nextInt(ei - si + 1) + si];
	// System.out.println("pivot" + pivotal);

	//	int pivotal = ary[si];

	//recreate

	int index = si;
	while (si < ei){
	    if (ary[index] < pivotal){
		D[si] = ary[index];
		si++;
	    }else{
		if (ary[index] > pivotal){
		    D[ei] = ary[index];
		    ei--;
		}
	    }
	    index++;
	}
	D[si] = pivotal;

	//copy back
	System.arraycopy(D,0,ary,0,D.length);
	// System.out.println(Arrays.toString(D));

	return si;

    }

    //partition with multiple swaps
    public static int partitionIn(int[]ary, int si, int ei){
	Random r = new Random();
	int pivotal = ary[r.nextInt(ei - si + 1) + si];
	// System.out.println("pivotal" + pivotal);
	int start = si;
	int end = ei;
	int one,two;
	while (start != end){
	    //what to do if we reach pivotal;
	    if (ary[start] == pivotal){
		one = ary[start];
		two = ary[start + 1];
		ary[start+1] = one;
		ary[start] = two;;
	    }
	    if (ary[end] == pivotal){
		one = ary[end];
		two = ary[end-1];
		ary[end-1] = one;
		ary[end] = two;
	    }
	    if (ary[start] > ary[end]){
		one = ary[start];
		two = ary[end];
		//swap
		ary[end] = one;
		ary[start] = two;
	    }
	    if (ary[end] > pivotal){
		end--;
	    }
	    if (ary[start] < pivotal){
		start++;
	    }
	}
	return start;
    }

    //partition with swap pivot to the end
    public static int partitionIn2(int[]ary, int si, int ei){
	Random r = new Random();
	int ind = r.nextInt(ei - si + 1) + si;
	int pivotal = ary[ind];
	System.out.println("pivotal" + pivotal);
	int start = si;
	int end = ei;
	int one,two;

	System.out.println("start" + start);
	System.out.println("end" + end);

	//swapping to the end
	one = ary[end];
	ary[ind] = one;
	ary[end] = pivotal;

	while (start < end){
	    System.out.println(Arrays.toString(ary));
	  
	    if (ary[start] > ary[end]){
		one = ary[start];
		two = ary[end];
		//swap
		ary[end] = one;
		ary[start] = two;
	    }
	    if (ary[end] > pivotal){
		end--;
	    }
	    if (ary[start] < pivotal){
		start++;
	    }
	}
	//swap back
	if (ary[start] < pivotal){
	    one = ary[start+1];
	    ary[start+1] = pivotal;
	    ary[ei] = one;
	    System.out.println(Arrays.toString(ary));
	    System.out.println(start+1);
	    return start + 1;
	}else{
	    one = ary[start];
	    ary[start] = pivotal;
	    ary[ei] = one;
	    System.out.println(Arrays.toString(ary));
	    System.out.println(start);
	    return start;
	}
	// System.out.println("start" + start);
	// System.out.println("one" + one);
    }


    public static void quicksortH(int[]ary, int start, int end){
	// int start = 0;
	// int end = ary.length-1;
	int now = partitionIn(ary,start,end);
	// System.out.println(Arrays.toString(ary));
	// System.out.println("start" + start);
	// System.out.println("end" + end);
	// System.out.println("now" + now);
	if (ary.length > 1 && end>now && now>start){
	    // if (ary.length > 1){
	    if (now >= 2){
		quicksortH(ary,start,now-1);
	    }
	    if (now < ary.length - 2){
		quicksortH(ary,now+1,end);

	    }
	}
    }

    public static void quicksort(int[]ary){
	quicksortH(ary,0,ary.length-1);
    }

    public static int quickSelect(int[] ary, int target){
	if (target < 0 || target >= ary.length){
	    System.out.println("out of bounds");
	}

	int start = 0;
	int end = ary.length-1;
	int now = partition(ary,start,end);

	while (now != target){
	    // System.out.println(Arrays.toString(ary));
	    // System.out.println("start" + start);
	    // System.out.println("end" + end);
	    if (target > now){
		start = now;

	    }else{
		if (target < now){
		    end = now;
		}
	    }
	    now = partition(ary,start,end);
	}
	// System.out.println("answer");
	return ary[target];
    }

    
    public static void main(String[]args){
	int[]ary = {3,10,2,-9,9,14,13,15,100,-100};
	System.out.println(Arrays.toString(ary));
	quicksort(ary);
	System.out.println(Arrays.toString(ary));
    }
    

}
