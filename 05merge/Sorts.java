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
	System.out.println(Arrays.toString(hello));
	int half = hello.length/2;
	int otherhalf = hello.length - half;
	int[]one = new int[half];
	int[]two = new int [otherhalf];
	int[]combine = new int[hello.length];

	if (one.length <= 1 && two.length <= 1){
	    merge(one, two, combine);
	    System.arraycopy(combine,0,hello,0,one.length+two.length);
	}



	while (hello.length > 2){
	    mergesort(one);
	    mergesort(two);
	    merge(one,two,hello);
	}



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
	// System.out.println(Arrays.toString(c));
    }
}
			   
