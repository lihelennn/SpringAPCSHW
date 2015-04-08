//make the mazeC also change (along with the maze)

import java.util.*;
import java.io.*;

public class Maze{

    private char[][]mazeC;
    private int[][]maze ;
    private int maxx,maxy;
    private int startx,starty;
    private LinkedList<Coordinate> deck = new LinkedList<Coordinate>();
    private LinkedList<Coordinate> deckhelper = new LinkedList<Coordinate>();
    private int current = 0;

    public String name(){
	return "li.helen";
    }

    public Maze(String filename){
	startx = -1;
	starty = -1;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line= in.nextLine();
		if(maxy==0){
		    //calculate width of the maze
		    maxx=line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans+=line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: "+filename+" could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}

	mazeC = new char[maxx][maxy];
	maze = new int[maxx][maxy];
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    mazeC[i%maxx][i/maxx]= c;
	    if(c=='S'){
		startx = i%maxx;
		starty = i/maxx;
	    }
	}
    }

    private String go(int x,int y){
	return ("["+x+";"+y+"H");
    }
    
    private String clear(){
	return  "[2J";
    }

    private String hide(){
	return  "[?25l";
    }

    private String show(){
	return  "[?25h";
    }
    private String invert(){
	return  "[37";
    }

    public void clearTerminal(){
	System.out.println(clear());
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = ""+maxx+","+maxy+"\n";
	for(int i=0;i<maxx*maxy;i++){
	    if(i%maxx ==0 && i!=0){
		ans+="\n";
	    }
	    ans += mazeC[i%maxx][i/maxx];
	}
	// for(int i=0;i<maxx*maxy;i++){
	//     if(i%maxx ==0 && i!=0){
	// 	ans+="\n";
	//     }
	//     ans += maze[i%maxx][i/maxx];
	// }
	// return hide()+invert()+go(0,0)+ans+"\n"+show();
	return hide()+clear()+go(0,0)+ans+"\n"+show();

    }

    public boolean solveBFS(boolean animate){
	boolean curr = false;
	deck.addLast(new Coordinate(startx, starty, current));
	maze[startx][starty] = 0;
	mazeC[startx][starty] = 'x';
	int x = startx;
	int y = starty;
	while (deck.size() > 0){
	    // if (current == 62){
	    // 	return true;
	    // }
	
	    x = deck.getFirst().getX();
	    y = deck.getFirst().getY();
	    if (mazeC[x][y] == 'E'){
		maze[x][y] = current+1;
		mazeC[x][y] = 'x';
		System.out.println(this);
		System.out.println(deckhelper);
		return true;
	    }
	    if (mazeC[x+1][y] == ' ' || mazeC[x+1][y] == 'E'){
		System.out.println(1);
		deck.addLast(new Coordinate(x+1,y,current+1));
		if (mazeC[x+1][y] == ' '){
		    mazeC[x+1][y] = 'x';
		    maze[x+1][y] = current+1;
		}
		curr = true;

	    }
	    if (mazeC[x-1][y] == ' ' || mazeC[x-1][y] == 'E'){
		deck.addLast(new Coordinate(x-1,y,current+1));
		System.out.println(2);
		if (mazeC[x-1][y] == ' '){
		    mazeC[x-1][y] = 'x';
		    maze[x-1][y] = current+1;
		}
		curr = true;

	    }
	    if (mazeC[x][y+1] == ' '|| mazeC[x][y+1] == 'E'){
		deck.addLast(new Coordinate(x,y+1,current+1));
		System.out.println(3);
		if (mazeC[x][y+1] == ' '){
		    mazeC[x][y+1] = 'x';
		    maze[x][y+1] = current+1;
		}
		curr = true;
	    }
	    if (mazeC[x][y-1] == ' '|| mazeC[x][y-1] == 'E'){
		deck.addLast(new Coordinate(x,y-1,current+1));
		System.out.println(4);
		if (mazeC[x][y-1] == ' '){
		    mazeC[x][y-1] = 'x';
		    maze[x][y-1] = current+1;
		}
		curr = true;
	    }
	    if (curr){
		current++;
		curr = false;
	    }
	    System.out.println("current" + current);
	    deckhelper.addLast(deck.removeFirst());
	    if (animate){
		System.out.println(this);
	    }
	}
	return false;
    }

    public boolean solveDFS(boolean animate){
	deck.addLast(new Coordinate(startx, starty, current));
	maze[startx][starty] = 0;
	mazeC[startx][starty] = 'x';
	int x = startx;
	int y = starty;
	while (deck.size() > 0){
	    x = deck.getLast().getX();
	    y = deck.getLast().getY();
	    deck.removeLast();
	    if (mazeC[x][y] == 'E'){	
		maze[x][y] = current+1;
		mazeC[x][y] = 'x';
		System.out.println(this);
		return true;
	    }
	    if (mazeC[x+1][y] == ' ' || mazeC[x+1][y] == 'E'){
		System.out.println(1);
		deck.addLast(new Coordinate(x+1,y,current+1));
		if (mazeC[x+1][y] == ' '){
		    mazeC[x+1][y] = 'x';
		    maze[x+1][y] = current+1;
		}

	    }
	    // x = deck.getLast().getX();
	    // y = deck.getLast().getY();
	    if (mazeC[x-1][y] == ' ' || mazeC[x-1][y] == 'E'){
		deck.addLast(new Coordinate(x-1,y,current+1));
		System.out.println(2);
		if (mazeC[x-1][y] == ' '){
		    mazeC[x-1][y] = 'x';
		    maze[x-1][y] = current+1;
		}

	    }
	    // x = deck.getLast().getX();
	    // y = deck.getLast().getY();
	    if (mazeC[x][y+1] == ' '|| mazeC[x][y+1] == 'E'){
		deck.addLast(new Coordinate(x,y+1,current+1));
		System.out.println(3);
		if (mazeC[x][y+1] == ' '){
		    mazeC[x][y+1] = 'x';
		    maze[x][y+1] = current+1;
		}
	    }
	    // x = deck.getLast().getX();
	    // y = deck.getLast().getY();
	    if (mazeC[x][y-1] == ' '|| mazeC[x][y-1] == 'E'){
		deck.addLast(new Coordinate(x,y-1,current+1));
		System.out.println(4);
		if (mazeC[x][y-1] == ' '){
		    mazeC[x][y-1] = 'x';
		    maze[x][y-1] = current+1;
		}
	    }
	    current++;
	    System.out.println("current" + current);
	    // deck.removeLast();
	    System.out.println(deck);
	    if (animate){
		System.out.println(this);
	    }
	}
	return false;
    }

    public boolean solveBFS(){
	return solveBFS(false);
    }

}



		    
	

