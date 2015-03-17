import java.util.*;

public class Driver{

    public static void main(String[]args){
	Sorts hi = new Sorts();
	int[] tester = {100, -98, 45, 36, -92, 1000, 50, 80, 70};
	System.out.println(hi.name());
	System.out.println(Arrays.toString(tester));
	System.out.println(Sorts.quickSelect(tester,3));
	Sorts.quicksort(tester);
	System.out.println(Arrays.toString(tester));
	System.out.println(Sorts.quickSelect(tester,3));

	quickSelect hello = new quickSelect();
	int[]test = {45, 69, 50, -100, 1000, -400, 560, -479};
	System.out.println(hello.name());
	System.out.println(Arrays.toString(test));
	// System.out.println(quickSelect.quickSelect(test,100));
	Sorts.quicksort(test);
	System.out.println(Arrays.toString(test));

    }

}
