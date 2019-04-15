package binarySearchTree;

public class BinaryTree {
	public Node rootNode;
	public int depth;
	public int numOfLeaves;
	
	public BinaryTree(){
		this.init();
	}
	
	public void init() {
		this.rootNode = null;
		this.depth = 0;
		this.numOfLeaves = 0;
	}

	public void remove(int paraInt) {
		Node tempNode = search(paraInt);
		if(tempNode == null) {
			System.out.println("There is no node with value of "+paraInt);
			return;
		}
		else {
			if(tempNode.leftNode == null && tempNode.rightNode == null) {
				if(tempNode.parentNode.leftNode == tempNode) {
					tempNode.parentNode.leftNode = null;
				} else if (tempNode.parentNode.rightNode == tempNode){
					tempNode.parentNode.rightNode = null;
				}
			} else if (tempNode.leftNode == null) {
				if(tempNode.parentNode.leftNode == tempNode) {
					tempNode.parentNode.leftNode = tempNode.rightNode;
				} else if (tempNode.parentNode.rightNode == tempNode){
					tempNode.parentNode.rightNode = tempNode.rightNode;
				}
			} else if (tempNode.rightNode == null) {
				if(tempNode.parentNode.leftNode == tempNode) {
					tempNode.parentNode.leftNode = tempNode.leftNode;
				} else if (tempNode.parentNode.rightNode == tempNode){
					tempNode.parentNode.rightNode = tempNode.leftNode;
				}
			} else {
				Node newNode = findMax(tempNode.leftNode);
				
				/* disconnect newNode from its previous parent*/
				newNode.parentNode.rightNode = null;
				
				if(tempNode.parentNode.leftNode == tempNode) {
					tempNode.parentNode.leftNode = newNode;			
					
				} else if (tempNode.parentNode.rightNode == tempNode){
					tempNode.parentNode.rightNode = newNode;
				}
				
				newNode.parentNode = tempNode.parentNode;

				newNode.leftNode = tempNode.leftNode;
				newNode.rightNode = tempNode.rightNode;
				
				tempNode.leftNode.parentNode = newNode;
				tempNode.rightNode.parentNode = newNode;
			}
		}
	}
	
	public void insert(int paraInt){
		Node tempNode = null;

		if(null == rootNode) {
			rootNode = new Node();
			rootNode.init();
			rootNode.value = paraInt;
			rootNode.depth = 0;
			depth++;
		} else {
			tempNode = rootNode;
			while(true) {
				if(tempNode.value > paraInt) {
					if(tempNode.leftNode == null) {
						tempNode.leftNode = new Node();
						tempNode.leftNode.init();
						tempNode.leftNode.value = paraInt;
						tempNode.leftNode.parentNode = tempNode;
						tempNode.leftNode.depth = tempNode.depth+1;

						if(depth <= tempNode.leftNode.depth) {
							if(depth < tempNode.leftNode.depth) {
								depth = tempNode.leftNode.depth;
								this.numOfLeaves = 0;
							}
							this.numOfLeaves++;
						}
						
						break;
					} else {
						tempNode = tempNode.leftNode;
					}
				} else if(tempNode.value < paraInt) {
					if(tempNode.rightNode == null) {
						tempNode.rightNode = new Node();
						tempNode.rightNode.init();
						tempNode.rightNode.value = paraInt;
						tempNode.rightNode.parentNode = tempNode;
						tempNode.rightNode.depth = tempNode.depth+1;

						if(depth <= tempNode.rightNode.depth) {
							if(depth < tempNode.rightNode.depth) {
								depth = tempNode.rightNode.depth;
								this.numOfLeaves = 0;
							}
							this.numOfLeaves++;
						}

						break;
					} else {
						tempNode = tempNode.rightNode;
					}
				} else {
					System.out.println("BinaryTree Exception: ");
					System.out.println("You input a duplicated value."
							+ "Duplicated Value: "+paraInt);
					break;
				}
			}
		}
	}

	public Node search(int paraInt) {
		if (rootNode == null) {
			/*Exception handling*/
			return null;
		}

		Node tempNode = rootNode;

		while(true) {
			if(tempNode.value > paraInt) {
				tempNode = tempNode.leftNode;
				if (tempNode == null) {
					return null;
				}
			} else if(tempNode.value < paraInt) {
				tempNode = tempNode.rightNode;
				if (tempNode == null) {
					return null;
				}				
			} else if(tempNode.value == paraInt) {
				return tempNode;
			} 
		}	
	}

	public Node findMax(Node paraNode) {
		if(paraNode.rightNode == null) {
			return paraNode;
		} else {
			Node tempNode = paraNode;
			while(true) {
				tempNode = tempNode.rightNode;
				if(tempNode.rightNode == null) {
					break;
				}
			}
			return tempNode;
		}
	}
}
