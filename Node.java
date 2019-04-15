package binarySearchTree;

public class Node {
	public int value;
	public int depth;
	
	public Node parentNode;
	public Node leftNode;
	public Node rightNode;

	public Node() {
		init();
	}
	public void init() {
		parentNode = null;
		leftNode = null;
		rightNode = null;
	}
}