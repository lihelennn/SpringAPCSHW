public class Driver{

    public static void main(String[]args){
	MyLinkedList tester = new MyLinkedList(2);
	System.out.println(tester);
	LNode n1 = new LNode(13);
	System.out.println(n1);
	System.out.println(tester.add(n1));
	System.out.println(tester.toString());
	System.out.println("size" + tester.size());
	System.out.println(tester.get(1));
	// System.out.println(tester.get(10));
	System.out.println(tester.indexOf(2));
	System.out.println(tester.indexOf(13));
	// System.out.println(tester.indexOf(1000));
        tester.add(2,1000);
	System.out.println(tester);
    }
}
