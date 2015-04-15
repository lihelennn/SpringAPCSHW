public class Test{

    public static void main(String[]args){
	MyDeque<String> hi = new MyDeque<String>();
	hi.add("yo", 1);
	hi.add("hello", 2);
	hi.add("ooo", 3);
	hi.arrayString();

        hi.removeSmallest();
	hi.arrayString();
	System.out.println(hi);
    }

}

