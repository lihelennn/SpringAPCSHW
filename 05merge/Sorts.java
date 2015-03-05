import java.util.*;

public class Sorts{

    //sorted: 100,000 elements 78 milliseconds
    //reverse sorted: 100,000 elements 31 milliseconds
    //small range random (1, 2, 3): 100,000 elements 15 milliseconds
    //large range random (-1000000 - 1000000): 100,000 elements 32 milliseconds

    public static void merge(int[]a, int[]b, int[]c){
	int placea = 0;
	int placeb = 0;
	int placeans = 0;
	int[]ans = new int[a.length + b.length];
       	while (placea < a.length && placeb < b.length){
	    //      	    if (b[placeb].compareTo(a[placea].getItemNumber()) <= 0){
	    if (b[placeb] < a[placea]){
		ans[placeans] = b[placeb];
		placeb++;
	    }else{
		ans[placeans] = a[placea];
		placea++;
	    }
	    placeans ++;

	}
	while (placea < a.length){
	    ans[placeans] = a[placea];
	    placea++;
	    placeans++;
	}
	while(placeb < b.length){
	    ans[placeans] = b[placeb];
	    placeb++;
	    placeans++;
	}
	System.arraycopy(ans,0,c,0,ans.length);

	/*
	  int place = 0;
	  String answerString = "[";
	  while (place < ans.length){
	  answerString += ans[place] + ", ";
	  place++;
	  } 
	  return answerString;
	*/
    }


    public static void mergesort(int[]hello){
	// System.out.println(Arrays.toString());

	//split
	int half = hello.length/2;
	int otherhalf = hello.length - half;
	int[]one = new int[half];
	int place = 0;
	while (place < half){
	    one[place] = hello[place];
	    place++;
	}
	int[]two = new int [otherhalf];
	place = half;
	int place2 = 0;
	while(place2 < otherhalf){
	    two[place2] = hello[place];
	    place2++;
	    place++;
	}
	// System.out.println(Arrays.toString(one));
	// System.out.println(Arrays.toString(two));
	// System.arraycopy(hello,one.length,two,0,two.length);

	
	int[]combine = new int[hello.length];

	//divide
	if (hello.length >= 2){
	    mergesort(one);
	    mergesort(two);
	}

	//merge
	merge(one, two, combine);
	// System.out.println(1);
	System.arraycopy(combine,0,hello,0,combine.length);
	// System.out.println(Arrays.toString(hello));

    }


    public static void main(String[]args){

	/*

	  Random r = new Random();
	  int[]test1 = new int[100000];
	  int start = 0;
	  while (start < test1.length){
	  test1[start]=start;
	  start++;
	  }
	  int[]test2 = new int[100000];
	  start = 0;
	  int end = 100000;
	  while (start < test2.length){
	  test2[start] = end;
	  start++;
	  end--;
	  }
	  int[]test3 = new int[100000];
	  int place = 0;
	  while (place < test3.length){
	  test3[place] = r.nextInt(3) + 1;
	  place++;
	  }

	*/

	Random r = new Random();

	int place=0;


	int[]test1 = new int[1000000];
	place = 0;
	while (place < test1.length){
	    test1[place] = r.nextInt(2000000) - 1000000;
	    place++;
	}

	int[]test2 = new int[2000000];
	place = 0;
	while (place < test2.length){
	    test2[place] = r.nextInt(2000000) - 1000000;
	    place++;
	}

	int[]test3 = new int[4000000];
	place = 0;
	while (place < test3.length){
	    test3[place] = r.nextInt(2000000) - 1000000;
	    place++;
	}

	/*
	  int[]test4 = new int[100000];
	  place = 0;
	  while (place < test4.length){
	  test4[place] = r.nextInt(2000000) - 1000000;
	  place++;
	  }
	*/

	// int[]test2 = new int[4];
	// int[]c = new int[test1.length + test2.length];

	long start_time = System.currentTimeMillis();
	mergesort(test1);
	long end_time = System.currentTimeMillis();
	System.out.println(end_time-start_time);
	start_time = System.currentTimeMillis();
	Arrays.sort(test1);
	end_time = System.currentTimeMillis();
	System.out.println(end_time-start_time);
	// System.out.println(test1);
	// System.out.println(Arrays.toString(test1));

	start_time = System.currentTimeMillis();
	mergesort(test2);
	end_time = System.currentTimeMillis();
	System.out.println(end_time-start_time);
	start_time = System.currentTimeMillis();
	Arrays.sort(test2);
	end_time = System.currentTimeMillis();
	System.out.println(end_time-start_time);
	// System.out.println(test2);
	// System.out.println(Arrays.toString(test2));

	start_time = System.currentTimeMillis();
	mergesort(test3);
	end_time = System.currentTimeMillis();
	System.out.println(end_time-start_time);
	start_time = System.currentTimeMillis();
	Arrays.sort(test3);
	end_time = System.currentTimeMillis();
	System.out.println(end_time-start_time);
	// System.out.println(test3);
	// System.out.println(Arrays.toString(test3));

	/*
	  start_time = System.currentTimeMillis();
	  mergesort(test4);
	  end_time = System.currentTimeMillis();
	  System.out.println(end_time-start_time);
	  start_time = System.currentTimeMillis();
	  Arrays.sort(test4);
	  end_time = System.currentTimeMillis();
	  System.out.println(end_time-start_time);
	  // System.out.println(test4);
	  // System.out.println(Arrays.toString(test4));
	  */

    }
    
   


   
}
			  
