import java.util.*;

public class Quick{

    public String name(){
	return "li,helen";
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
	System.out.println("pivotal" + pivotal);
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
	// System.out.println("pivotal" + pivotal);
	int start = si;
	int end = ei-1;
	int one,two;

	//swapping to the end
	one = ary[ary.length-1];
	ary[ind] = one;
	ary[ary.length-1] = pivotal;

	while (start < end){
	    // System.out.println(Arrays.toString(ary));
	  
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
	    ary[ary.length-1] = one;
	    return start + 1;
	}else{
	    one = ary[start];
	    ary[start] = pivotal;
	    ary[ary.length-1] = one;
	    return start;
	}
	// System.out.println("start" + start);
	// System.out.println("one" + one);
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

    /*
      public static void quicksort(int[]ary){
      int start = 0;
      int end = ary.length-1;
      int now = partitionIn(ary,start,end);
      System.out.println(Arrays.toString(ary));
      System.out.println("start" + start);
      System.out.println("end" + end);
      System.out.println("now" + now);
      if (ary.length > 1){
      if (now >= 2){
      quicksort(Arrays.copyOfRange(ary,start,now-1));
      }
      if (now < ary.length - 2){
      quicksort(Arrays.copyOfRange(ary,now+1,end));
      }
	    
      }
      }
    */

    public static void quicksortH(int[]ary, int start, int end){
	// int start = 0;
	// int end = ary.length-1;
	int now = partitionIn(ary,start,end);
	// System.out.println(Arrays.toString(ary));
	// System.out.println("start" + start);
	// System.out.println("end" + end);
	// System.out.println("now" + now);
	if (ary.length > 1 && end!= now && start!= now){
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
    
    /*
    public static void main(String[]args){
	Quick tester = new Quick();
	int[]ary = {5,4,3,7,1,2,59,-2,-5,-1, -10, 100};
	// System.out.println(Arrays.toString(ary));
	System.out.println(partitionIn2(ary,0,ary.length-1));
	// tester.partitionIn(ary,0,ary.length-1);
	// quicksort(ary);
	// System.out.println(Arrays.toString(ary));
	// System.out.println(quickSelect(ary,11));
	// tester.partition(ary,3,ary.length-1);
	// System.out.println(Arrays.toString(ary));
	// tester.partition(ary,3,ary.length-1);
	// System.out.println(Arrays.toString(ary));

    }
    */
   
    // start1 = start1;
    // end1 = now1-1;
    // start2 = now1+1;
    // end2 = end1;
    // now1 = partition(ary,start1,end1);
    // now2 = partition(ary,start2,end2);
    // quicksort(ary);

}


