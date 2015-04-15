public class Test{

    public static void main(String[]args){
	MyDeque<String> hi = new MyDeque<String>();
	System.out.println(hi);

	hi.add("yo", 1);
	hi.add("hello", 2);
	hi.add("ooo", 3);
	System.out.println(hi);
	hi.arrayString();
	System.out.println(hi.findSmallest());


        hi.removeSmallest();
	System.out.println(hi);
	hi.arrayString();
	System.out.println(hi);
    }

}

