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
    private int current = 0;
    private boolean solveable = false;
    private int[] coord;
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
		if (animate){
		    System.out.println(this);
		    this.charAnswer();
		    System.out.println(this);		}
		// System.out.println(deckhelper);
		solveable = true;
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
		if (animate){
		    System.out.println(this);
		    this.charAnswer();
		    System.out.println(this);
		}
		solveable = true;
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
	coord = new int[current*2];
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
	    System.out.println(Arrays.toString(ans));
	    // System.out.println("length" + ans.length / 2);
	}
	// int place = 0;
	// while (place +2 < ans.length){
	//     mazeC[ans[place]][ans[place+1]] = 'a';
	//     place+=2;
	// }
	// System.out.println(this);
	// System.out.println("length" + ans.length / 2);

	return ans;
    }

    public void charAnswer(){
	int x = endx;
	int y = endy;
	boolean sub = false;
	int[]ans = new int[current*2];
	coord = new int[current*2];
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

	    int place = 0;
	    System.out.println(Arrays.toString(ans));
	    while (place +2 < ans.length){
		mazeC[ans[place]][ans[place+1]] = 'a';
		place+=2;
	    }
	    System.out.println(mazeC.toString());
	}
   


    }

}

