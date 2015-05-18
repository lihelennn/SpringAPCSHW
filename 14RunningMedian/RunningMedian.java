import java.util.*;

public class RunningMedian{

    private int med1;
    private MyHeap min = new MyHeap();
    private MyHeap max = new MyHeap(false);
    private int size1 = 0;
    private int size2 = 0;

    public double getMedian(){
	if (size1 == size2){
	    return ((double)min.peek() + (double)max.peek() ) / 2;
	}
	else{
	    if (size1 > size2){
		return (double)min.peek();
	    }else{
		return (double)max.peek();
	    }
	}
    }

    public void add(int value){
	if (size1 == 0 && size2 == 0){
	    min.add(value);
	    size1++;
	}else{
	    if (size2 == 0 && size1 == 1){
		if (min.peek() < value){
		    max.add(value);
		}else{
		    max.add(min.remove());
		    min.add(value);
		}
		size2++;
	    }else{
		//if there are two medians
		if (size1 == size2){
		    if (min.peek() >= value){
			min.add(value);
			size1++;
		    }else{
			if (value >= min.peek() && value < max.peek()){
			    min.add(value);
			    size1++;
			}else{
			    if (max.peek() <= value){
				max.add(value);
				size2++;
			    }
			}
		    }
		}else{
		    if (size1 > size2){
			if (min.peek() <= value){
			    max.add(value);
			    size2++;
			}else{
			    max.add(min.remove());
			    min.add(value);
			    size2++;
			}
		    }else{
			if (max.peek() >= value){
			    min.add(value);
			    size1++;
			}else{
			    min.add(max.remove());
			    size1++;
			    max.add(value);
			}
		    }
		}
	    }
	}
	// System.out.println(size1 + "," + size2);
    }

    private void toStringH(){
	System.out.println(min.toString());
	System.out.println(max.toString());
    }

    public static void main(String[]args){
	RunningMedian test = new RunningMedian();
	test.add(3);
	test.add(43);
	test.add(183);
	test.add(-24);
	test.add(10);
	test.add(20);
	test.add(17);
	test.add(34);
	test.add(25);
	test.add(9);
	test.add(20);
	test.add(16);
	test.add(15);
	// test.toStringH();
	System.out.println(test.getMedian());
    }

}
		 
