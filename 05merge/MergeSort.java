import java.util.*;

public class MergeSort{

    public static String merge(Object[]a, Object[]b){
	int placea = 0;
	int placeb = 0;
	int placeans = 0;
	Object[]ans = new Object[a.length + b.length];
       	while (placea < a.length && placeb < b.length){
      	    if (b[placeb].compareTo(a[placea]) <= 0){
		ans[placeans] = b[placeb];
		placeb++;
	    }else{
		ans[placeans] = a[placea];
		placea++;
	    }
	    placeans ++;

	}
	int place = 0;
	String answerString = "[";
	while (place < ans.length){
	    answerString += ans[place] + ", ";
	    place++;
	}
	return answerString;
    }

    public static void main(String[]args){
	Object[]test1 = new Object[3];
	Object[]test2 = new Object[4];
	test1[0] = 1;
	test1[1] = 3;
	test1[2] = 5;
	test2[0] = 2;
	test2[1] = 4;
	test2[2] = 6;
	test2[3] = 8;
	System.out.println(merge(test1, test2));
    }
}
			   
