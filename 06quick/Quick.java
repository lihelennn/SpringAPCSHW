import java.util.*;

public class Quick{

    public void partition(int[]ary, int si, int ei){
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

	/*
	Random r = new Random();
	int pivotal = pivotal = r.nextInt(ei - si) + si;
	while (pivotal < si || pivotal > ei){
	    pivotal = r.nextInt(ei - si + 1) + si;
	}
	*/

	int pivotal = ary[si];

	//recreate

	int index = si + 1;
	while (si != ei){
	    if (ary[index] < pivotal){
		D[si] = ary[index];
		si++;
	    }else{
		D[ei] = ary[index];
		ei--;
	    }
	    index++;
	}
	D[si] = pivotal;

	//copy back
	System.arraycopy(D,0,ary,0,D.length);
    }

    public static void main(String[]args){
	Quick tester = new Quick();
	int[]ary = {3,5,1,13,53,2};
	tester.partition(ary,0,ary.length-1);
	System.out.println(Arrays.toString(ary));
	tester.partition(ary,3,ary.length-1);
	System.out.println(Arrays.toString(ary));
	tester.partition(ary,3,ary.length-1);
	System.out.println(Arrays.toString(ary));


    }
  







}


