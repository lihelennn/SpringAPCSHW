import java.util.*;

public class Recursion implements hw1{

    public String name(){
	return "Li,Helen";
    }

    public int fact(int n){
	if (n < 0){
	    throw new IllegalArgumentException("number cannot be less than zero!");
	}else{
	    if (n <= 1){
		return 1;
	    }else{
		return (n * fact(n - 1));
	    }
	}
    }

    public int fib(int n){
	if (n < 0){
	    throw new IllegalArgumentException("number cannot be less than zero!");
	}else{
	    if (n == 0 || n == 1){
		return n;
	    }else{
		return helpFib(n, 2, 0, 1);
	    }
	}
    }

    public int helpFib(int orig, int index, int sum1, int sum2){
	if (index == orig){
	    return sum1 + sum2;
	}else{
	    return helpFib(orig, index + 1, sum2, sum1 + sum2);
	}
    }

    public double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException("number cannot be less than zero!");
	}else{
	    return guess(n, 1.00);
	}
    }

    public double guess(double n, double guessNum){
	if(Math.abs(n - guessNum * guessNum) < 0.00001){
	    return guessNum;
	}else{
	    return guess(n, ((n / guessNum + guessNum) / 2));
	}
    }


    // public static void main(String[]args){
    // 	Recursion test = new Recursion();
    // 	System.out.println(test.name());
    // 	System.out.println(test.fact(0));
    // 	System.out.println(test.fact(5));
    // 	System.out.println(test.fact(1));
    // 	System.out.println(test.fact(3));
    // 	System.out.println(test.fib(0));
    // 	System.out.println(test.fib(1));
    // 	System.out.println(test.fib(2));
    // 	System.out.println(test.fib(3));
    // 	System.out.println(test.fib(4));
    // 	System.out.println(test.fib(5));
    // 	System.out.println(test.fib(6));
    // 	System.out.println(test.fib(10));
    // 	System.out.println(test.sqrt(100.0));
    // 	System.out.println(test.sqrt(1.00000));
    // 	System.out.println(test.sqrt(16.0));
    // 	System.out.println(test.sqrt(256.00));

    // }
}


