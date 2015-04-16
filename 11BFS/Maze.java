//figure out toString(animate)

import java.util.*;
import java.io.*;

public class Maze{

    private char[][]mazeC;
    private int[][]maze ;
    private int maxx,maxy;
    private int startx,starty,endx,endy;
    private LinkedList<Coordinate> deck = new LinkedList<Coordinate>();
    private LinkedList<Coordinate> deckhelper = new LinkedList<Coordinate>();
    private MyDeque<Coordinate>pQueue = new MyDeque<Coordinate>();
    private int current = 0;
    private boolean solveable = false;
    
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

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
	    if (c=='E'){
		endx = i%maxx;
		endy = i/maxx;
	    }
	}
    }

    // private String go(int x,int y){
    // 	return ("["+x+";"+y+"H");
    // }
    
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
	// return hide()+clear()+go(0,0)+ans+"\n"+show();
	return ans;
    }


    public String toString(boolean animate){
	if (animate){
	    return hide + go(0,0) + toString() + "\n" + show;
	}else{
	    return toString();
	}
    }

    public boolean solveBFS(boolean animate){
	// boolean curr = false;
	deck.addLast(new Coordinate(startx, starty, current));
	maze[startx][starty] = 0;
	mazeC[startx][starty] = 'x';
	int x = startx;
	int y = starty;
	current = deck.getFirst().getCurrent() + 1;
	while (deck.size() > 0){
	    x = deck.getFirst().getX();
	    y = deck.getFirst().getY();
	    current = deck.getFirst().getCurrent() + 1;
	    if (mazeC[x][y] == 'E'){
		endx = x;
		endy = y;
		maze[x][y] = current;
		mazeC[x][y] = 'x';
		solveable = true;
		if (animate){
		    System.out.println(this);
		    this.solutionCoordinates();
		    System.out.println(this);
		}
		// System.out.println(deckhelper);
		return true;
	    }
	    if (mazeC[x+1][y] == ' ' || mazeC[x+1][y] == 'E'){
		deck.addLast(new Coordinate(x+1,y,current));
		if (mazeC[x+1][y] == ' '){
		    mazeC[x+1][y] = 'x';
		    maze[x+1][y] = current;
		}
		// curr = true;

	    }
	    if (mazeC[x-1][y] == ' ' || mazeC[x-1][y] == 'E'){
		deck.addLast(new Coordinate(x-1,y,current));
		if (mazeC[x-1][y] == ' '){
		    mazeC[x-1][y] = 'x';
		    maze[x-1][y] = current;
		}
		// curr = true;

	    }
	    if (mazeC[x][y+1] == ' '|| mazeC[x][y+1] == 'E'){
		deck.addLast(new Coordinate(x,y+1,current));
		if (mazeC[x][y+1] == ' '){
		    mazeC[x][y+1] = 'x';
		    maze[x][y+1] = current;
		}
		// curr = true;
	    }
	    if (mazeC[x][y-1] == ' '|| mazeC[x][y-1] == 'E'){
		deck.addLast(new Coordinate(x,y-1,current));
		if (mazeC[x][y-1] == ' '){
		    mazeC[x][y-1] = 'x';
		    maze[x][y-1] = current;
		}
		// curr = true;
	    }
	    // if (curr){
	    // 	current = deck.getFirst().getCurrent() + 1;
	    // 	curr = false;
	    // }
	    // System.out.println("current" + current);
	    // deckhelper.addLast(deck.removeFirst());
	    deck.removeFirst();
	    if (animate){
		System.out.println(toString(true));
		wait(50);
	    }
	}
	solveable = false;
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
	    current = deck.getLast().getCurrent() + 1;
	    deck.removeLast();
	    if (mazeC[x][y] == 'E'){
		endx = x;
		endy = y;	
		maze[x][y] = current;
		mazeC[x][y] = 'x';
		solveable = true;
		if (animate){
		    System.out.println(this);
		    this.solutionCoordinates();
		    System.out.println(this);
		}
		return true;
	    }
	    if (mazeC[x+1][y] == ' ' || mazeC[x+1][y] == 'E'){
		deck.addLast(new Coordinate(x+1,y,current));
		if (mazeC[x+1][y] == ' '){
		    mazeC[x+1][y] = 'x';
		    maze[x+1][y] = current;
		}

	    }
	    if (mazeC[x-1][y] == ' ' || mazeC[x-1][y] == 'E'){
		deck.addLast(new Coordinate(x-1,y,current));
		if (mazeC[x-1][y] == ' '){
		    mazeC[x-1][y] = 'x';
		    maze[x-1][y] = current;
		}

	    }
	    if (mazeC[x][y+1] == ' '|| mazeC[x][y+1] == 'E'){
		deck.addLast(new Coordinate(x,y+1,current));
		if (mazeC[x][y+1] == ' '){
		    mazeC[x][y+1] = 'x';
		    maze[x][y+1] = current;
		}
	    }
	    if (mazeC[x][y-1] == ' '|| mazeC[x][y-1] == 'E'){
		deck.addLast(new Coordinate(x,y-1,current));
		if (mazeC[x][y-1] == ' '){
		    mazeC[x][y-1] = 'x';
		    maze[x][y-1] = current;
		}
	    }
	    // current++;
	    // System.out.println("current" + current);
	    // deck.removeLast();
	    // System.out.println(deck);
	    if (animate){
		System.out.println(toString(true));
		wait(50);
	    }
	}
	solveable = false;
	return false;
    }

    public boolean solveBFS(){
	return solveBFS(false);
    }

    public boolean solveDFS(){
	return solveDFS(false);
    }

    public int[] solutionCoordinates(){
	int x = endx;
	int y = endy;
	boolean sub = false;
	int[]ans = new int[current*2];
	if (solveable){
	    ans[current*2 -2] = x;
	    ans[current*2 -1] = y;
	    while (current > 1){
		if (maze[x+1][y] == current - 1){
		    ans[(current-1)*2] = x+1;
		    ans[(current-1)*2 +1] = y;
		    maze[x+1][y] = -1;
		    x++;
		    current--;
		    sub = true;
		}
		if (maze[x-1][y] == current - 1){
		    ans[(current-1)*2] = x-1;
		    ans[(current-1)*2 +1] = y;
		    maze[x-1][y] = -1;
		    x--;
		    current--;
		    sub = true;
		}
		if (maze[x][y+1] == current - 1){
		    ans[(current-1)*2] = x;
		    ans[(current-1)*2 +1] = y+1;
		    maze[x][y+1] = -1;
		    y++;
		    current--;
		    sub = true;
		}
		if (maze[x][y-1] == current - 1){
		    ans[(current-1)*2] = x;
		    ans[(current-1)*2 +1] = y-1;
		    maze[x][y-1] = -1;
		    y--;
		    current--;
		    sub = true;
		}
		if (sub == false){
		    current--;
		}
	    }
	    ans[0] = startx;
	    ans[1] = starty;   
	    
	    //mark solution
	    int place = 0;
	    while (place +1 < ans.length){
		mazeC[ans[place]][ans[place+1]] = 'S';
		place+=2;
	    }
	}
	return ans;
    }

    public int distance(int startx, int starty, int endx, int endy){
	return Math.abs(endx-startx) + Math.abs(endy-starty);
    }

    public boolean solveBest(boolean animate){
	Coordinate one;
	pQueue.add(new Coordinate(startx, starty, current),1);
	maze[startx][starty] = 0;
	mazeC[startx][starty] = 'x';
	int x = startx;
	int y = starty;
	System.out.println(pQueue);
	pQueue.add(new Coordinate(x,y,current),distance(x+1,y,endx,endy));
	while(pQueue.size() > 0){
	    one = pQueue.removeSmallest();
	    x = one.getX();
	    y = one.getY();

	    if (mazeC[x][y] == 'E'){
		endx = x;
		endy = y;	
		maze[x][y] = current;
		mazeC[x][y] = 'x';
		solveable = true;
		if (animate){
		    System.out.println(this);
		    this.solutionCoordinates();
		    System.out.println(this);
		}
		return true;
	    }
	    if (mazeC[x+1][y] == ' ' || mazeC[x+1][y] == 'E'){
		pQueue.add(new Coordinate(x+1,y,current),distance(x+1,y,endx,endy));
		if (mazeC[x+1][y] == ' '){
		    mazeC[x+1][y] = 'x';
		    maze[x+1][y] = current;
		}

	    }
	    if (mazeC[x-1][y] == ' ' || mazeC[x-1][y] == 'E'){
		pQueue.add(new Coordinate(x-1,y,current),distance(x-1,y,endx,endy));
		if (mazeC[x-1][y] == ' '){
		    mazeC[x-1][y] = 'x';
		    maze[x-1][y] = current;
		}

	    }
	    if (mazeC[x][y+1] == ' '|| mazeC[x][y+1] == 'E'){
		pQueue.add(new Coordinate(x,y+1,current),distance(x,y+1,endx,endy));
		if (mazeC[x][y+1] == ' '){
		    mazeC[x][y+1] = 'x';
		    maze[x][y+1] = current;
		}
	    }
	    if (mazeC[x][y-1] == ' '|| mazeC[x][y-1] == 'E'){
		pQueue.add(new Coordinate(x,y+1,current),distance(x,y+1,endx,endy));
		if (mazeC[x][y-1] == ' '){
		    mazeC[x][y-1] = 'x';
		    maze[x][y-1] = current;
		}
	    }



	}
	return false;

    }

}

