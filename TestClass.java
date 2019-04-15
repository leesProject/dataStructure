package binarySearchTree;

public class TestClass {

	public static void main(String args[]) {
		// TODO Auto-generated method stub
		new TestClass();
	}
	public TestClass() {
		BinaryTree bTree = new BinaryTree();
		bTree.insert(50);
		bTree.insert(25);
		bTree.insert(75);
		bTree.insert(12);
		bTree.insert(37);
		bTree.insert(6);
		bTree.insert(18);
		bTree.insert(31);
		bTree.insert(43);
		bTree.insert(3);
		bTree.insert(9);
		bTree.insert(15);
		bTree.insert(21);
		bTree.insert(28);
		bTree.insert(34);
		bTree.insert(40);
		bTree.insert(46);		
		
		bTree.remove(12);

		Node node = bTree.search(9);

		System.out.println("Parent: "+node.parentNode.value);
		System.out.println("Left: "+node.leftNode.value);
		System.out.println("Right: "+node.rightNode.value);
		System.out.println(bTree.search(6).rightNode);

		
	}
}