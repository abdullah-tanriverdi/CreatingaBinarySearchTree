public class Main {

    public static void main(String[]args){
        BinarySearchTree myTree= new BinarySearchTree();

        // Various values are added to the tree.
        myTree.insert(10);
        myTree.insert(10);
        myTree.insert(10);
        myTree.insert(8);
        myTree.insert(20);
        myTree.insert(25);
        myTree.insert(16);

        // Checking whether certain values are present in the tree.
        System.out.println(myTree.contains(16));
        System.out.println(myTree.contains(10));
        System.out.println(myTree.contains(19));


        System.out.println(myTree.root.value);
        System.out.println(myTree.root.right.value);
        System.out.println(myTree.root.right.right.value);
        System.out.println(myTree.root.left.value);
        System.out.println(myTree.root.right.left.value);
        System.out.println(myTree.minOfNode(myTree.root).value);
        System.out.println(myTree.maxOfNode(myTree.root).value);


    }
}


 /*This section defines
 the Node class that represents the nodes of the tree*/
class Node{
    int value ;
    Node left;
    Node right;

    public Node(int value){
        this.value=value;
        this.left=null;
        this.right=null;

    }
}

class BinarySearchTree {
    Node root;

    //The public BinarySearchTree() method creates an empty tree.
    public BinarySearchTree() {
        this.root = null;

    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (this.root == null) {
            this.root = newNode;
            return true;
        }
        Node tempNode=this.root;
        while(true){
            if (newNode.value== tempNode.value){
                return false;
            }
            if (newNode.value< tempNode.value){
                if (tempNode.left==null){
                    tempNode.left=newNode;
                    return true;
                }
                tempNode=tempNode.left;
            }else{
                if (tempNode.right==null){
                    tempNode.right=newNode;
                    return true;
                }
                tempNode= tempNode.right;
            }
        }
    }


    //This method checks whether a particular value exists in the tree.
    public boolean contains(int value){
        Node tempNode= this.root;
        while (tempNode!=null){
            if(value<tempNode.value){
                tempNode=tempNode.left;
            }else if (value > tempNode.value){
                tempNode=tempNode.right;
            }else{
                return true;
            }
        }
        return false;
    }


    /*This method contains a loop that finds the smallest
     value starting from a given node.*/
    public Node minOfNode(Node currentNode){
        while (currentNode.left!=null){
            currentNode=currentNode.left;
        }
        return currentNode;
    }


    /*This method contains a loop that finds
     the largest value starting from a given node.*/
    public Node maxOfNode(Node currentNode){
        while (currentNode.right!=null){
           currentNode=currentNode.right;
        }
        return currentNode;
    }
}

