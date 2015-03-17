public class Driver{

    public static void main(String[]args){
	MyLinkedList<Integer> tester = new MyLinkedList<Integer>(99);
	System.out.println(tester.name());
	System.out.println(tester);
	// LNode n1 = new LNode(13);
	// System.out.println(n1);
	System.out.println(tester.add(1));
	System.out.println(tester.toString());
	System.out.println("size" + tester.size());
	System.out.println(tester.add(999));
	System.out.println(tester.toString());
	System.out.println("size" + tester.size());
	System.out.println(tester.get(1));
	// System.out.println(tester.get(10));
	System.out.println(tester.indexOf(1));
	System.out.println(tester.indexOf(13));
	System.out.println(tester.indexOf(1000));
        tester.add(2,1000);
	System.out.println(tester);
	System.out.println(tester.set(2, 9));
	System.out.println(tester);
	System.out.println(tester.size());
    	// System.out.println(tester.set(-1, 509));
    	// System.out.println(tester);
	System.out.println(tester.remove(0));
	System.out.println(tester);
	System.out.println(tester.size());
	System.out.println(tester.remove(1));
	System.out.println(tester);
	System.out.println(tester.size());
	System.out.println(tester.size());
	System.out.println(tester.remove(0));
	System.out.println(tester);
	System.out.println(tester.size());
	tester.add(0,800);
	System.out.println(tester);
	tester.add(1,36);
	System.out.println(tester);
	tester.add(2,1126);
	System.out.println(tester);


    }
}
