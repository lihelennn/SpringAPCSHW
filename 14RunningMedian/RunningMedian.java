import java.util.*;

public class RunningMedian{

    private int med1;
    private MyHeap min = new MyHeap(false);
    private MyHeap max = new MyHeap();
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
	}else{
	    if (size2 == 0 && size1 == 1){
		if (min.peek() < value){
		    max.add(value);
		    size2++;
		}else{
		    max.add(min.remove());
		    min.add(value);
		    size1++;
		}
	    }else{
		//if there are two medians
		if (size1 == size2){
		    if (min.peek() > value){
			med1 = min.remove();
			min.add(value);
		    }else{
			if (max.peek() < value){
			    med1 = max.remove();
			    max.add(value);
			}else{
			    med1 = value;
			}
		    }
		}

		 