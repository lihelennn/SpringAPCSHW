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
		    destination[i][ii]--;
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


    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public boolean solve(int x, int y, int current){
	// System.out.println(this);
	// wait(20);
	// System.out.println(x + "," + y);

	if (x<0 || x>=field.length || y<0 || y>=field[0].length){
	    return false;
	}
	if (field[x][y] == '*'){ 
	    return false;
	}

	/*
	if (timeremaining == 0){
	    return (x == destination[1][0] && y == destination[1][1]);
	}
	*/

	if (x == destination[1][0] && y == destination[1][1]){
	    return true;
	}

	if (field[x][y] == '.'){
	    field[x][y] = '@';
	    if (solve(x+1, y, current+1) || solve(x-1, y, current+1) || solve(x, y+1, current+1) || solve(x, y-1, current+1)){
		field[x][y] = (char)current;
		return true;
	    }
	    field[x][y] = '*';
	}
	return false;
    }

    public int solver(int x, int y, int current, int solutions){
	if (solve(x, y, 0)){
	    if (current == time && x == destination[1][0] && y == destination[1][1]){
		solver(x,y,0,solutions+1);
	    }
	    if (x>=0 && x<field.length && y>=0 && y<field[0].length){
		if (field[x][y] != '*'){






    public boolean run(){
	System.out.println(destination[0][0] + "," + destination[0][1]);
	return solve(destination[0][0], destination[0][1],0);
    }

    public static void main(String[] args){
	ctravel test = new ctravel("testingctravel.txt");
	System.out.println(test);
	System.out.println(test.run());
	System.out.println(test);

    }



}
