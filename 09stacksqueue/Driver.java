public class Driver{

    public static void main(String[]args){

	MyQueue<Integer> test1= new MyQueue<Integer>();
	System.out.println(test1.enqueue(0));
	System.out.println(test1.enqueue(1));
	System.out.println(test1.enqueue(2));
	System.out.println(test1);
	System.out.println(test1.dequeue());
	System.out.println(test1);
	System.out.println(test1.dequeue());
	System.out.println(test1);
	System.out.println(test1.enqueue(10));
	System.out.println(test1.dequeue());
	System.out.println(test1);




    }


}
