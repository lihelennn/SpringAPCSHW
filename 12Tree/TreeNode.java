import java.util.*;

public class TreeNode<T>{
    private TreeNode<T>left;
    private TreeNode<T>right;
    private T data;

    public String name(){
	return "li.helen";
    }

    public TreeNode(T n){
	setData(n);
    }

    public T getData(){
	return data;
    }

    public void setData(T n){
	data = n;
    }

    public TreeNode<T> getLeft(){
	return left;
    }

    public TreeNode<T> getRight(){
	return right;
    }

    public void setLeft(TreeNode<T> n){
	left = n;
    }

    public void setRight(TreeNode<T> n){
	right = n;
    }

}