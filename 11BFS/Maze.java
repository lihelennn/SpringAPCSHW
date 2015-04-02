import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    private LinkedList<Coordinate> deck = new LinkedList<Coordinate>();
    private int current = 0;

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

	maze = new char[maxx][maxy];
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx]= c;
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
	    ans += maze[i%maxx][i/maxx];
	}
	return hide()+invert()+go(0,0)+ans+"\n"+show();
    }

    public boolean solveBFShelper(){
	// if (maze[x][y] == 'E'){
	//     return true;
	// }
	deck.addLast(new Coordinate(startx, starty, current));
	maze[startx][starty] = '0';
	int x = startx;
	int y = starty;
	while (deck.size() != 0){
	    if (maze[deck.getFirst().getX()][deck.getFirst().getY()] == 'E'){
		return true;
	    }
	    if (maze[x+1][y] == ' '){
		deck.addLast(new Coordinate(x+1,y,current+1));
		maze[x+1][y] = Integer.toString(current+1).charAt(0);
	    }
	    if (maze[x-1][y] == ' '){
		deck.addLast(new Coordinate(x-1,y,current+1));
		maze[x-1][y] = Integer.toString(current+1).charAt(0);
	    }
	    if (maze[x][y+1] == ' '){
		deck.addLast(new Coordinate(x,y+1, current+1));
		maze[x][y+1] = Integer.toString(current+1).charAt(0);
	    }
	    if (maze[x][y-1] == ' '){
		deck.addLast(new Coordinate(x,y-1,current+1));
		maze[x][y-1] = Integer.toString(current+1).charAt(0);
	    }
	    current++;
	    deck.removeFirst();
	}
	return false;
    }

}



		    
	

