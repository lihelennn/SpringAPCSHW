import java.io.*;
import java.util.*;

public class BTree<E> {

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;

    private int randSeed;
    

    private TreeNode<E> root;

    public BTree() {
	root = null;
    }

    /*======== public void add() ==========
      Inputs:   E d
      Returns: 
      
      Wrapper method for the recursive add()
      ====================*/     
    public void add( E d ) {
	if (root == null){
	    root = new TreeNode<E>(d);
	}else{
	    add(root,new TreeNode<E>(d));
	}
    }

    /*======== public void add() ==========
      Inputs:   TreeNode<E> curr, TreeNode<E> bn  
      Returns: 
      
      Adds bn to the tree rooted at curr. If curr has 
      an available child space, then attach bn there.

      Otherwise, try to add at the subtree rooted at
      one of curr's children. Choose the child to be
      added to randomly.
      ====================*/
    private void add( TreeNode<E> curr, TreeNode<E> bn ) {
	// Random rand = new Random(randSeed);
	Random rand = new Random();

	int n = rand.nextInt(2);
	if (curr.leftEmpty() && curr.rightEmpty()){
	    if (n == 0){
		curr.setRight(bn);
	    }else{
		curr.setLeft(bn);
	    }
	}else{
	    if (curr.rightEmpty() && !curr.leftEmpty()){
		curr.setRight(bn);
	    }else{
		if (curr.leftEmpty() && !curr.rightEmpty()){
		    curr.setLeft(bn);
		}else{
		    if (n == 0){
			curr = curr.getRight();
			this.add(curr,bn);
		    }else{
			curr = curr.getLeft();
			this.add(curr,bn);
		    }
		}
	    }
	}
    }
   
    public void traverse( int mode) {
	if ( mode == PRE_ORDER )
	    preOrder( root );
	else if ( mode == IN_ORDER )
	    inOrder( root );
	else
	    postOrder( root );
	System.out.println();
    }
    /*======== public void preOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      pre-order Traversal
      ====================*/
    public void preOrder( TreeNode<E> curr ) {
	if (curr != null){
	    System.out.println(curr.toString());
	    preOrder(curr.getLeft());
	    preOrder(curr.getRight());
	}
    }


    /*======== public void inOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      in-order Traversal
      ====================*/
    public void inOrder( TreeNode<E> curr ) {
        if (curr != null){
	    inOrder(curr.getLeft());
	    System.out.println(curr.toString());
	    inOrder(curr.getRight());
	}
    }

    /*======== public void postOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing a
      post-order Traversal    
      ====================*/
    public void postOrder( TreeNode<E> curr ) {
	if (curr != null){
	    postOrder(curr.getLeft());
	    postOrder(curr.getRight());
	    System.out.println(curr.toString());
	}
    }
    
    /*======== public int getHeight()) ==========
      Inputs:   
      Returns: The height of the tree

      Wrapper for the recursive getHeight method
      ====================*/
    public int getHeight() {
	return getHeight( root );
    }
    /*======== public int getHeight() ==========
      Inputs:   TreeNode<E> curr  
      Returns:  The height of the tree rooted at node curr
      
      ====================*/
    public int getHeight( TreeNode<E> curr ) {
	int left, right;
	if (curr.leftEmpty() && curr.rightEmpty()){
	    return 1;
	}
	if (curr.rightEmpty()){
	    left = getHeight(curr.getLeft());
	    return left + 1;
	}else{
	    if (curr.leftEmpty()){
		right = getHeight(curr.getRight());
		return right + 1;
	    }else{
		left = getHeight(curr.getLeft());
		right = getHeight(curr.getRight());
		if (left > right){
		    return left + 1;
		}else{
		    return right + 1;
		}
	    }
	}
    }

    /*======== public String getLevel() ==========
      Inputs:   TreeNode<E> curr
      int level
      Returns: A string containing all the elements on the
      given level, ordered left -> right
      
      ====================*/
    private String getLevel( TreeNode<E> curr, int level) {
	if (curr == null){
	    return "";
	}
	if (level == 0){
	    return curr.toString();
	}
	return getLevel(curr.getLeft(), level-1) + getLevel(curr.getRight(), level-1);
    }
    
    /*======== public String toString()) ==========
      Inputs:   
      Returns: A string representation of the tree
     
      This string should display each level as a separate line.
      A simple version might look something like this:

      0
      1 2
      3 4 5

      Note that you cannot tell exactly where 3, 4 and 5 lie.
      That is ok, but if you want a CHALLENGE, you can try to
      get the output to look nicer, something like this:
      0
      1      2
      3  4   5
      ====================*/
    public String toString() {
	String ans = "";
	int level = getHeight();
	int place = 0;
	while (place <= level){
	    ans += getLevel(root, place) + "\n";
	    place++;
	}
	return ans;
    }

    public static void main( String[] args ) {

	BTree<Integer> t = new BTree<Integer>();

	for ( int i=0; i < 8; i++ ) 
	    t.add( i );
	System.out.println( "Pre-order: ");
	t.traverse( PRE_ORDER );
	System.out.println( "In-order: ");
	t.traverse( IN_ORDER );
	System.out.println( "Post-order: ");
	t.traverse( POST_ORDER );
	System.out.println( "Height: " + t.getHeight() );

	System.out.println( t );
    }
}
