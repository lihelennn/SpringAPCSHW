import java.util.*;
import java.io.*;
public class Mazesolver{

    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;

    public Mazesolver(String filename){
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
    
    public boolean solve(){
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}else{
	    maze[startx][starty]=' ';
	    return solve(startx,starty);
	}
    }

    public boolean solve(int x,int y){
	System.out.println(this);
	wait(20);
	//ASSIGNMENT IS TO COMPLETE THIS PART******************

	if (maze[x][y] == 'E'){
	    return true;
	}
	if (maze[x][y] == ' '){
	    maze[x][y] = '@';
	    if ((solve(x, y+1) || solve(x+1,y) || solve(x-1, y) || solve(x, y-1))){
		return true;
	    }
	    maze[x][y] = '.';
	    //mark the floor with 0.
	    //try to move in all directions
	    //when that fails, we replaced a @ with.
	}
			
	//ASSIGNMENT IS TO COMPLETE THE PART ABOVE THIS******************
	return false;//by default the maze didn't get solved
    }


}
