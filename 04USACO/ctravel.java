//worked with Felicity

import java.util.*;
import java.io.*;

public class ctravel{

    private int[][]field;
    private int[][]destination=new int[2][2];
    private int time;
  
    public cowTravel(String fileName){
	try{
	    Scanner scan = new Scanner(new File(fileName));
	    field = new int[scan.nextInt()][scan.nextInt()];
	    time = scan.nextInt();
	    for(int i=0;i<field.length;i++){
		for(int ii=0;ii<field[0].length;ii++){
		    field[i][ii]=scan.nextInt();
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

}
