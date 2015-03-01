//worked with Felicity

import java.util.*;
import java.io.*;

public class ctravel{

    private char[][]field;
    private int[][]destination = new int[2][2];
    private int time;
    String help = "";
  
    public ctravel(String fileName){
	try{
	    Scanner scan = new Scanner(new File(fileName));
	    field = new char[scan.nextInt()][scan.nextInt()];
	    time = scan.nextInt();
	    for(int i=0;i<field.length;i++){
		help = scan.next();
		for(int ii=0;ii<field[0].length;ii++){
		    field[i][ii]=help.charAt(ii);
		}
	    }
	    for(int i=0;i<2;i++){
		for(int ii=0;ii<2;ii++){
		    destination[i][ii] = scan.nextInt();
		}
	    }
	}catch(Exception FileNotFoundException){
	    System.out.println("File not found");
	}
    }

    public String toString(){
	int place = 0;
	int place2 = 0;
	String ans = "";
	while (place < field.length){
	    while (place2 < field[0].length){
		ans += field[place][place2] + "   ";
		place2 ++;
	    }
	    place2 = 0;
	    place ++;
	    ans += "\n";
	}
	return ans;
    }


    public boolean solve(int x, int y, int seconds){
	if (field[x][y] == '*'){
	    return false;
	}
	return false;

    }

    public static void main(String[] args){
	ctravel test = new ctravel("testingctravel.txt");
	System.out.println(test);
    }



}
