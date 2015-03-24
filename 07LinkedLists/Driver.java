public class Driver{

    public static void main(String[]args){

	MyLinkedList<Integer> test3 = new MyLinkedList<Integer>();
	test3.add(0);
	test3.add(1);
	test3.add(2);
	test3.add(4);
	test3.add(5);
	test3.add(6);
	test3.add(7);
	test3.add(8);
	test3.add(9);
	System.out.println(test3);
	
	for (int number : test3){
	    System.out.println(number);
	}


       
	
	  MyLinkedList<Integer> tester = new MyLinkedList<Integer>();
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
	  System.out.println(tester.set(0, 9));
	  System.out.println(tester);
	  System.out.println(tester.size());
	  // System.out.println(tester.set(-1, 509));
	  // System.out.println(tester);
	  System.out.println(tester.remove(0));
	  System.out.println(tester);
	  System.out.println(tester.remove(1));
	  System.out.println(tester);
	  System.out.println(tester.remove(0));
	  System.out.println(tester);
	  tester.add(0,800);
	  System.out.println(tester);
	  tester.add(0,36);
	  System.out.println(tester);
	  tester.add(1,1126);
	  System.out.println(tester);
	
       

    }
}
