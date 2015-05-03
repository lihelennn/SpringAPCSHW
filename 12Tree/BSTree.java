//Your binary search tree skeleton file:

import java.io.*;
import java.util.*;

public class BSTree <T extends Comparable> {

    private BSTreeNode<T> root;

    public BSTree() {
	root = null;
    }

    public boolean isEmpty() {
	return root == null;
    }
    public boolean isLeaf( BSTreeNode<T> t ) {
	return (t.getLeft() == null && t.getRight() == null);
    }

    /*======== public void add() ==========
      Inputs:   T c  
      Returns: 

      Wrapper for the recursive add method
      ====================*/
    public void add( T c ) {
	root = add( root, new BSTreeNode<T>(c) );
    }

    /*======== public BSTreeNode<T> add() ==========
      Inputs:  BSTreeNode<T> curr
      BSTreeNode<T> t 
      Returns: 

      Add t to the correct place in the tree rooted at curr.
      ====================*/
    private BSTreeNode<T> add(BSTreeNode<T> curr, BSTreeNode<T> t) {
	if (curr == null){
	    curr = t;
     	    return curr;
	}else{
	    if (curr.getData().compareTo(t.getData()) < 0){
	        curr.setRight(add(curr.getRight(),t));
	    }else{
		curr.setLeft(add(curr.getLeft(),t));
	    }
	}
	return curr;
    }

    /*======== public void remove() ==========
      Inputs:   T c  
      Returns: 
      
      Wrapper for the recursive remove method
      ====================*/
    public void remove( T c ) {
        root = remove( root, c );
    }

    /*======== public BSTreeNode<T> remove() ==========
      Inputs:   BSTreeNode<T> curr
      T c
      Returns: 

      Should remove the value c from the tree rooted at
      curr, if it exists.
      ====================*/
    private BSTreeNode<T> remove( BSTreeNode<T> curr, T c ) {
	BSTreeNode<T>sub = curr;
	if (curr.getData().equals(c)){
	    //leaf
	    if (curr.rightEmpty() && curr.leftEmpty()){
		curr = null;
		return curr;
	    }else{
		//only one child
		if (curr.rightEmpty() && !curr.leftEmpty()){
		    // curr = remove(curr.getLeft(),curr.getLeft().getData());
		    curr = curr.getLeft();
		    return curr;

		}else{
		    if (!curr.rightEmpty() && curr.leftEmpty()){
			// curr = remove(curr.getRight(),curr.getRight().getData());
			curr = curr.getRight();
			return curr;

		    }else{
			//has two children
			if (!curr.rightEmpty() && !curr.leftEmpty()){
			    BSTreeNode<T>help = getSub(root);
			    remove(root,help.getData());
			    curr.setData(help.getData());
			    return curr;
			}
		    }
		}
	    }
	}else{
	    if (curr.getData().compareTo(c) < 0){
		// if (!curr.rightEmpty()){
		curr.setRight(remove(curr.getRight(),c));
		// }
	    }else{
		// if (!curr.leftEmpty()){
		curr.setLeft(remove(curr.getLeft(),c));
		// }
	    }
	}
	return sub;
    }

    private BSTreeNode<T> getSub(BSTreeNode<T>curr){
	Random rand = new Random();
	int r = rand.nextInt(2);
	if (r == 0){
	    curr = curr.getLeft();
	    while (!curr.rightEmpty()){
		curr = curr.getRight();
	    }
	}else{
	    curr = curr.getRight();
	    while (!curr.leftEmpty()){
		curr = curr.getLeft();
	    }
	}
	return curr;
    }



    /*======== public void inOrder()) ==========
      Inputs:   
      Returns: 

      Wrapper for the recursive inOrder method
      ====================*/
    public void inOrder() {
	inOrderHelper( root );
	System.out.println();
    }

    /*======== public void inOrderHelper() ==========
      Inputs:   BSTreeNode<T> t  
      Returns: 
      
      Performs an in-order traversal for the tree with 
      root t.
      ====================*/
    public void inOrderHelper( BSTreeNode<T> t ) {
	if (t == null) 
	    return;
	inOrderHelper( t.getLeft() );
	System.out.print( t.getData() + " ");
	inOrderHelper( t.getRight() );
    }


    /**
     * stolen from: Dennis Yatunin
     * (no not really stolen from, donated by)
     */
    public int getHeight(){
    	return getHeight(root);
    }

    private int getHeight(BSTreeNode<T> r ){
    	if(r == null){
    	    return 0;
    	}else{
    	    //System.out.println("recursion height");
    	    return 1 + Math.max(getHeight(r.getLeft()),
    				getHeight(r.getRight()));
    	}
    }

    private int maxLength() {
    	// returns the minimum number of characters required
    	// to print the data from any node in the tree
    	if (root == null)
    	    return 0;
    	return maxLength(root);
    }

    private int maxLength(BSTreeNode<T> curr) {
    	int max = curr.toString().length();
    	int temp;
    	if (curr.getLeft() != null) {
    	    temp = maxLength(curr.getLeft());
    	    if (temp > max)
    		max = temp;
    	}
    	if (curr.getRight() != null) {
    	    temp = maxLength(curr.getRight());
    	    if (temp > max)
    		max = temp;
    	}
    	return max;
    }

    private String spaces(double n) {
    	// returns a String of n spaces
    	String result = "";
    	for (int i = 0; i < n; i++)
    	    result += " ";
    	return result;
    }

    /*
      getLevel will produce a String for each level of the tree.
      The resulting Strings will look like this:

      ._______________________________
      ._______________._______________
      ._______._______._______._______
      .___.___.___.___.___.___.___.___
      ._._._._._._._._._._._._._._._._

      toString will combine those Strings and provide an output that
      will look like this:

      _______________.
      _______._______________.
      ___._______._______._______.
      _.___.___.___.___.___.___.___.
      ._._._._._._._._._._._._._._._.
      In these diagrams, each dot represents wordLength characters,
      each underscore represents wordLength spaces, and, for any nodes
      that are null, the dots will be "replaced" by underscores.
    */

    private String getLevel(BSTreeNode<T> curr, int currLevel, int targetLevel, int height, int wordLength) {
    	if (currLevel == 1){
    	    return curr.toString() + 
    		spaces(wordLength - curr.toString().length()) +
    		spaces(wordLength * 
    		       Math.pow(2, height - targetLevel + 1) - 
    		       wordLength);
    	}
    	String result = "";
    	if (curr.getLeft() != null){
    	    result += getLevel(curr.getLeft(), currLevel - 1, targetLevel, height, wordLength);
    	}else{
    	    result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
    	}
    	if (curr.getRight() != null){
    	    result += getLevel(curr.getRight(), currLevel - 1, targetLevel, height, wordLength);
    	}else{ 
    	    result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
    	}
    	return result;
    }
		
    public String toString() {
    	if (root == null){
    	    return "";
    	}
    	String result = "";
    	int height = getHeight();
    	int wordLength = maxLength();
    	// add the every level of the tree except the last one
    	for (int level = 1; level < height; level++){
    	    // remove extra spaces from the end of each level's String to prevent lines from
    	    // getting unnecessarily long and add spaces to the front of each level's String
    	    // to keep everything centered
    	    result += spaces(wordLength * Math.pow(2, height - level) - wordLength) +
    		getLevel(root, level, level, height, wordLength).replaceFirst("\\s+$", "") +
    		"\n";
    	}
    	// now add the last level (level = height)
    	result += getLevel(root, height, height, height, wordLength).replaceFirst("\\s+$", "");
				
    	return result;
    }

   
    public static void main( String[] args ) {
	BSTree<Integer>test = new BSTree<Integer>();
	test.add(5);
	test.add(60);
	test.add(9);
	test.add(4);
	test.add(2304);
	test.add(-1);
	test.add(10);
	test.add(3);

	System.out.println(test);
	System.out.println("\n\n\n\n");

	// test.remove(9);
	// test.remove(-1);
	// test.remove(4);
	test.remove(5);
	test.remove(60);

	System.out.println(test);


    }

}
