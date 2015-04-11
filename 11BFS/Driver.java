public class Driver{

    public static void main(String[]args){

     	Maze test = new Maze("data1.dat");
	System.out.println(test.name());
	// System.out.println(test.solveBFS(true));
	System.out.println(test.solveDFS(true));
	System.out.println(test.solutionCoordinates());


    	Maze test2 = new Maze("data2.dat");
	System.out.println(test2.solveBFS(true));
	// System.out.println(test2.solveDFS(true));
	System.out.println(test2.solutionCoordinates());


    }


}
