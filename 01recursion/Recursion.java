public class Recursion{

    public String name(){
	return "Li,Helen";
    }

    public int fact(int n){
	if (n <= 1){
	    return 1;
	}else{
	    return (n * fact(n - 1));
	}
    }

    public int fib(int n){
	if (n == 0 || n == 1){
	    return n;
	}else{
	    return helpFib(n, 2, 1);
	}
    }

    public int helpFib(int orig, int first, int value1, int sec, int value2, int sum){
	if (first + 1 == orig || sec + 1 == orig){
	    return sum;
	}else{
	    return helpFib(orig, first + 1, sec, sum + first);
	}
    }





    public static void main(String[]args){
	Recursion test = new Recursion();
	System.out.println(test.fact(5));
	System.out.println(test.fact(1));
	System.out.println(test.fact(3));
	System.out.println(test.fib(0));
	System.out.println(test.fib(1));
	System.out.println(test.fib(2));
	System.out.println(test.fib(3));
	System.out.println(test.fib(4));
	System.out.println(test.fib(5));
	System.out.println(test.fib(6));

    }
}





// public interface hw1{
//     public String name();
//     public int fact(int n);
//     public int fib(int n);
//     public double sqrt(double n); 
// }




