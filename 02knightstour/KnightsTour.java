
import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;


    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String name(){
	return "Li,Helen";
    }

    public String toString(){
	String ans = "\n";
	//build your knights tour here...
	int place = 0;
	int place2 = 0;
	while (place < board.length){
	    while (place2 < board[0].length){
		ans+= "  " + board[place][place2] + "  ";
		place2+=1;
	    }
	    ans += "\n";
	    place+=1;
	    place2 = 0;
	}
	return hide + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){
	board = new int[size][size];
	int place = 0;
	int place2 = 0;
	while (place < board.length){
	    while (place2 < board[0].length){
		board[place][place2] = -1;
		place2+=1;
	    }
	    place+=1;
	    place2 = 0;
	}
				
    }

    
    public void solve(){
	solve(0,0,0);
				
    }

    public void solve(int startx, int starty){
	solve(startx,starty,0);
				
    }


		
    public boolean solve(int x,int y,int currentMoveNumber){
	System.out.println(this);
	wait(20);

	if (currentMoveNumber == board.length * board[0].length - 1){
	    return true;
	}
	if (x < 0 || x >= board.length || y < 0 || y >= board[0].length){
	    return false;
	}
	if (board[x][y] >= 0){
	    return false;
	}
	board[x][y] = currentMoveNumber;
	if (solve(x+1,y+2,currentMoveNumber+1) || solve(x-1,y+2,currentMoveNumber+1) || solve(x+1,y-2,currentMoveNumber+1) || solve(x-1,y-2,currentMoveNumber+1)||
	    solve(x+2,y+1,currentMoveNumber+1) || solve(x-2,y+1,currentMoveNumber+1) || solve(x+2,y-1,currentMoveNumber+1) || solve(x-2,y-1,currentMoveNumber+1)){
	    return true;
	}
	board[x][y] = -1;				
	return false;
    }



    public static void main(String[]args){
	KnightsTour test;
	if (args.length < 0){
	    test = new KnightsTour(6);
	}else{
	    test = new KnightsTour(Integer.parseInt(args[0]));
	    if (test.solve(0,0,0)){
		test.solve();
		System.out.println(test);
	    }else{
		System.out.println("No Solution");
	    }
	}
    }
}