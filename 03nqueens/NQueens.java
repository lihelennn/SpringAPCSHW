import java.util.*;
import java.io.*;

public class NQueens{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private char[][]board;


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

    public NQueens(int size){
	board = new char[size][size];
	int place = 0;
	int place2 = 0;
	while (place < board.length){
	    while (place2 < board[0].length){
		board[place][place2] = '_';
		place2+=1;
	    }
	    place+=1;
	    place2 = 0;
	}				
    }

    /*
      public void solve(){
      solve(0,0,0);				
      }

      public void solve(int startx, int starty){
      solve(startx,starty,0);
      }
    */

    public boolean solve(){
	return solve(0,0,0);
    }

    public boolean solve(int x){
	return solve(x,0,0);
    }

		
    public boolean solve(int x,int y,int currentMoveNumber){
	//	System.out.println(this);
	//	wait(1000);
	int solver,place, place2, reset1, reset2;
	char[][]alt = new char[board.length][board[0].length];
	
	if (x < 0 || x >= board.length || y < 0 || y >= board[0].length){
	    return false;
	}


	if (board[x][y] == 'Q' || board[x][y] == 'x'){
	    return false;
	}



	place = x+1;
        place2 = y+1;
	while (place < board.length && place2 < board[0].length && place >= 0 && place2 >= 0){
	    if (board[place][place2] == 'Q'){
		System.out.println(place + ",aaa" + place2); 
		System.out.println(x + "," + y);
		return false;
	    }	
	    place++;
	    place2++;
	}
       
	place = x;
        place2 = y+1;
      	while (place < board.length && place2 < board[0].length && place >= 0 && place2 >= 0){
	    if (board[place][place2] == 'Q'){
		System.out.println(place + ",bbb" + place2);
		System.out.println(x + "," + y);
		return false;
	    }	
	    place2++;
	}
	
	place = x;
        place2 = y-1;
	while (place < board.length && place2 < board[0].length && place >= 0 && place2 >= 0){
	    if (board[place][place2] == 'Q'){
		System.out.println(place + ",ccc" + place2); 
		System.out.println(x + "," + y);
		return false;
	    }
	    place2--;
	}
	place = x+1;
        place2 = y-1;
	while (place < board.length && place2 < board[0].length && place >= 0 && place2 >= 0){
	    if (board[place][place2] == 'Q'){
		System.out.println(place + ",ddd" + place2);
		System.out.println(x + "," + y); 
		return false;
	    }	
	    place++;
	    place2--;
	}
	place = x-1;
        place2 = y+1;
	while (place < board.length && place2 < board[0].length && place >= 0 && place2 >= 0){
	    if (board[place][place2] == 'Q'){
		System.out.println(place + ",eee" + place2); 
		System.out.println(x + "," + y);
		return false;
	    }	
	    place--;
	    place2++;
	}
	place = x-1;
        place2 = y-1;
	while (place < board.length && place2 < board[0].length && place >= 0 && place2 >= 0){
	    if (board[place][place2] == 'Q'){
		System.out.println(place + ",fff" + place2); 
		System.out.println(x + "," + y);
		return false;
	    }	
	    place--;
	    place2--;
	}


	board[x][y] = 'Q';
	/*
	  alt = board;

	  place = x+1;
	  place2 = y+1;
	  while (place < board.length && place2 < board[0].length && place >= 0 && place2 >= 0){
	  board[place][place2] = 'x';	
	  place++;
	  place2++;
	  }
	  place = x;
	  place2 = y-1;
	  while (place < board.length && place2 < board[0].length && place >= 0 && place2 >= 0 && place!=x){
	  board[place][place2] = 'x';	
	  place2--;
	  }
	  place = x;
	  place2 = y+1;
	  while (place < board.length && place2 < board[0].length && place >= 0 && place2 >= 0 && place2!=y){
	  board[place][place2] = 'x';	
	  place2++;
	  }
	  place = 0;
	  place2 = y;
	  while (place < board.length && place2 < board[0].length && place >= 0 && place2 >= 0 && place2!=y){
	  board[place][place2] = 'x';	
	  place++;
	  }
	  place = x+1;
	  place2 = y-1;
	  while (place < board.length && place2 < board[0].length && place >= 0 && place2 >= 0){
	  board[place][place2] = 'x';	
	  place++;
	  place2--;
	  }
	  place = x-1;
	  place2 = y+1;
	  while (place < board.length && place2 < board[0].length && place >= 0 && place2 >= 0){
	  board[place][place2] = 'x';	
	  place--;
	  place2++;
	  }
	  place = x-1;
	  place2 = y-1;
	  while (place < board.length && place2 < board[0].length && place >= 0 && place2 >= 0){
	  board[place][place2] = 'x';	
	  place--;
	  place2--;
	  }
	*/

	solver = 0;
	while (solver < board.length){
	    System.out.println("alright");
	    if (solve(solver, y+1, currentMoveNumber+1)){
		System.out.println("good");
		/*
		  reset1 = 0;
		  reset2 = 0;
		  while (reset1 < board.length){
		  while (reset2 < board[0].length){
		  if (board[reset1][reset2] == 't'){
		  board[reset1][reset2] = 'x';
		  }
		  reset2++;
		  }
		  reset2 = 0;
		  reset1++;
		  }
		*/
		return true;
	    }
	    solver++;
	}
	if (currentMoveNumber == board.length - 1){
	    return true;
	}
	board[x][y] = '_';
	/*
	  reset1 = 0;
	  reset2 = 0;
	  while (reset1 < board.length){
	  while (reset2 < board[0].length){
	  if (board[reset1][reset2] == 't'){
	  board[reset1][reset2] = '_';
	  }
	  reset2++;
	  }
	  reset2 = 0;
	  reset1++;
	  }
	*/

	return false;
	
    }

   public static void main(String[]arrr){
     NQueens t = new NQueens(5);
	t.solve(3);
	System.out.println(t);
    }

}
