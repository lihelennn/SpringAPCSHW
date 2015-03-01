//worked with Felicity on this

import java.util.*;
import java.io.*;

public class makelake{
    private int[][]lake;
    private int[][]instructions;
    private int landElevation;

    public String toString(){
	int place = 0;
	int place2 = 0;
	String ans = "";
	while (place < lake.length){
	    while (place2 < lake[0].length){
		ans += lake[place][place2] + "   ";
		place2 ++;
	    }
	    place2 = 0;
	    place ++;
	    ans += "\n";
	}
	return ans;
    }

    public makelake(String fileName){
	try{
	    Scanner scan = new Scanner(new File(fileName));
	    lake = new int [scan.nextInt()][scan.nextInt()];
	    landElevation = scan.nextInt();
	    instructions = new int [scan.nextInt()][3];
	    for(int i = 0;i<lake.length;i++){
		for(int ii=0;ii<lake[0].length;ii++){
		    lake[i][ii]=scan.nextInt();
		}
	    }
	    for(int i=0;i<instructions.length;i++){
		for(int ii=0;ii<3;ii++){
		    instructions[i][ii] = scan.nextInt();
		}
	    }
	}catch(Exception FileNotFoundException){
	    System.out.println("File not found");
	}
    }

    private void stomp(){
	for(int i = 0;i<instructions.length;i++){
	    stomp(i);
	}
	System.out.println("stomp");
	System.out.println(this);
    }

    //stomp() helper method
    public void stomp(int step){
	int x = instructions[step][0];
	int y = instructions[step][1];
	int b = findBiggest(x,y);
	int limit = b-instructions[step][2];
	System.out.println(limit);
	for(int i=0;i<3;i++){
	    for(int m=0;m<3;m++){
		try{
		    if(lake[x+i][y+m]>limit){
			lake[x+i][y+m] = limit;
		    }
		}catch(Exception IndexOutOfBoundsException){}
	    }
	}
	System.out.println(this);
    }
    //stomp(int step) helper method
    private int findBiggest(int x, int y){
	int b = 0;
	for(int i=0;i<3;i++){
	    for(int ii=0;ii<=3;ii++){
		try{
		    if(lake[x+i][y+ii]>b){
			b = lake[x+i][y+ii];
		    }
		}catch(Exception IndexOutOfBoundsException){}
	    }
	}
	return b;
    }


    private void calcDepth(){
	for(int i=0;i<lake.length;i++){
	    for(int ii=0;ii<lake.length;ii++){
		if(lake[i][ii]<landElevation){
		    lake[i][ii]=landElevation-lake[i][ii];;
		}else{
		    lake[i][ii]=0;
		}
	    }
	}
	System.out.println(this);
    }

    private int calcVolume(){
	int t=0;
	int c = 0;
	for(int i=0;i<lake.length;i++){
	    for(int ii=0;ii<lake.length;ii++){
		if(lake[i][ii]>0){
		    c = lake[i][ii];
		    t=t+c;
		}
	    }
	}
	return t*72*72;
    }

    public int runProgram(){
	stomp();
	calcDepth();
	return calcVolume();
    }

    public static void main(String[]moo){
	makelake beef = new makelake("testing.txt");
	System.out.println(beef.runProgram());
    }

}
