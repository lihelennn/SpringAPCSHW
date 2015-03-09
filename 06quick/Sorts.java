import java.util.*;

public class Sorts{

  public static void quicksortH(int[]ary, int start, int end){
	// int start = 0;
	// int end = ary.length-1;
	int now = partitionIn(ary,start,end);
	System.out.println(Arrays.toString(ary));
	System.out.println("start" + start);
	System.out.println("end" + end);
	System.out.println("now" + now);
	if (ary.length > 1 && end!= now && start!= now){
	    if (now >= 2){
		quicksortH(ary,start,now-1);
	    }
	    if (now < ary.length - 2){
		quicksortH(ary,now+1,end);

	    }
	}
    }

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

    public static void quicksort(int[]ary){
	quicksortH(ary,0,ary.length-1);
    }

    public static void main(String[]args){
	int[]ary = {3,10,2,-9,9,14,13,15,100,-100};
	System.out.println(Arrays.toString(ary));
	quicksort(ary);
	System.out.println(Arrays.toString(ary));
    }

}
