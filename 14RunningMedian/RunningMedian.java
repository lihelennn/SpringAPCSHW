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
			    if (min.peek() >= value){
				max.add(min.remove());
				size2++;
			    }
			}
		    }else{
			if (max.peek() >= value){
			    min.add(value);
			    size1++;
			}else{
			    if (max.peek() <= value){
				min.add(max.remove());
				size1++;
			    }
			}
		    }
		}
	    }
	}
    }

    public static void main(String[]args){
	RunningMedian test = new RunningMedian();
	test.add(3);
	test.add(10);
	test.add(20);
	test.add(15);
	System.out.println(test.getMedian());
    }

}
		 
