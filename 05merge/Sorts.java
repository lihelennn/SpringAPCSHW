import java.util.*;

public class Sorts{

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

	if (hello.length >= 2){
	    mergesort(one);
	    mergesort(two);
	}

	merge(one, two, combine);
	// System.out.println(1);
	System.arraycopy(combine,0,hello,0,combine.length);
	// System.out.println(Arrays.toString(hello));

	

    }

    public static void main(String[]args){
	int[]test1 = new int[7];
	// int[]test2 = new int[4];
	// int[]c = new int[test1.length + test2.length];
	test1[0] = 10;
	test1[1] = 7;
	test1[2] = 4;
	test1[3] = 2;
	test1[4] = 9;
	test1[5] = 6;
	test1[6] = 8;
	mergesort(test1);
	System.out.println(Arrays.toString(test1));
	// System.out.println(Arrays.toString(c));
    }
}
			   
