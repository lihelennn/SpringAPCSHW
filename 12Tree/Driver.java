public class Driver{

    public static void main( String[] args ) {
	BSTree<Integer>test = new BSTree<Integer>();

	System.out.println(test.name());

	test.add(5);
	test.add(60);
	test.add(9);
	test.add(4);
	test.add(2304);
	test.add(-1);
	test.add(10);
	test.add(3);

	System.out.println(test);
	System.out.println("\n\n\n\n");

	// test.remove(9);
	// test.remove(-1);
	// test.remove(4);
	// test.remove(5);
	test.remove(60);
	test.remove(4);
	test.remove(5);

	test.add(1);

	System.out.println(test);
    }

}
