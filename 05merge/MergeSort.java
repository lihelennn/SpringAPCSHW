import java.util.*;

public class MergeSort{

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


    public static void main(String[]args){
	int[]test1 = new int[3];
	int[]test2 = new int[4];
	int[]c = new int[7];
	test1[0] = 1;
	// test1[1] = 3;
	// test1[2] = 5;
	test2[0] = 2;
	// test2[1] = 4;
	// test2[2] = 6;
	// test2[3] = 8;
	merge(test1,test2,c);
	System.out.println(Arrays.toString(c));
    }

}
			   
