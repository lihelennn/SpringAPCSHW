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
	return "li.helen";
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
	return hide + clear + go(0,0) + ans + "\n" + show;
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
    
    // public void solve(){
    // 	solve(0,0,0);
				
    // }

    // public void solve(int startx, int starty){
    // 	solve(startx,starty,0);
				
    // }

    public boolean solve(){
	return solve(0,0,0);
    }

    public boolean solve(int x, int y){
	return solve(x,y,0);
    }
		
    public boolean solve(int x,int y,int currentMoveNumber){
	//		System.out.println(this);
        //		wait(10);
	// if (currentMoveNumber == 10){
	//     System.out.println(this);
	// }

	if (x < 0 || x >= board.length || y < 0 || y >= board[0].length){
	    return false;
	}
	if (board[x][y] > -1){
	    return false;
	}
	board[x][y] = currentMoveNumber;
	if (solve(x+1,y+2,currentMoveNumber+1) || solve(x-1,y+2,currentMoveNumber+1) || solve(x+1,y-2,currentMoveNumber+1) || solve(x-1,y-2,currentMoveNumber+1)||
	    solve(x+2,y+1,currentMoveNumber+1) || solve(x-2,y+1,currentMoveNumber+1) || solve(x+2,y-1,currentMoveNumber+1) || solve(x-2,y-1,currentMoveNumber+1)){
	    return true;
	}
	if (currentMoveNumber == board.length * board[0].length - 1){
	    return true;
	}
	
	board[x][y] = -1;
	return false;
    }

    /*
    public static void main(String[]arrr){
	KnightsTour t = new KnightsTour(5);
	System.out.println(t.name());
	System.out.println("Knights Tour:");
    

	KnightsTour q = new KnightsTour(5);
	q.solve();
	System.out.println(q);


	KnightsTour w = new KnightsTour(5);
	w.solve(3,3);
	System.out.println(w);


	KnightsTour a = new KnightsTour(6);
	if(a.solve()){
	    System.out.println(a);
	}else{
	    System.out.println("Cannot solve");
	}
    }

    */
}
