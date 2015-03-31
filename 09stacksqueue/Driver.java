public class Driver{

    public static void main(String[]args){

	MyQueue<Integer> test1= new MyQueue<Integer>();
	System.out.println(test1.name());
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

	MyStack<Integer> test2 = new MyStack<Integer>();
	System.out.println(test2.name());
	System.out.println(test2.push(5));
	System.out.println(test2.push(6));
	System.out.println(test2.push(7));
	System.out.println(test2);
	System.out.println(test2.pop());
	System.out.println(test2);
	System.out.println(test2.peek());
	System.out.println(test2);

    }


}
