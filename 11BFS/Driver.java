public class Driver{

    public static void main(String[]args){

     	Maze test = new Maze("data1.dat");
	System.out.println(test.name());
	System.out.println(test.solveBFS(true));
	// System.out.println(test.solveDFS(true));

    }


}
