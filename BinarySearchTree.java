public class BinarySearchTree<E extends Comparable<E>> implements SimpleSSet<E>
{
    //set the size of the BST to 0
    int size = 0;

    //implement the class Node with the following public instance variables:
    // "value" of the Node, "right" and "left" children of the Node, and the "parent" of the Node
    public class Node<E>
    {
        public E value = null;
        public Node<E> left = null;
        public Node<E> right = null;
        public Node<E> parent = null;
    }

    //create and initialize the root Node
    Node<E> root = new Node<E>();

    //this method returns the size of the BST
    @Override
    public int size()
    {
        return size;
    }

    //this method checks whether the BST is empty and returns true or false accordingly
    @Override
    public boolean isEmpty()
    {
        return (size() == 0);
    }

    //this method adds a Node containing the value x into the BST
    //the method returns true if the node was added while it returns false is a node already contains the value x in the BST
    @Override
    public boolean add(E x)
    {
        //check if the BST is empty
        if (isEmpty())
        {
            //set the root node's value to be x and increment the size of the BST by 1
            root.value = x;
            size++;
            return true;
        }

        //if BST is not empty, create a newNode and set its value to be x
        Node<E> newNode = new Node<E>();
        newNode.value = x;

        //make a currentNode variable that points to the root node
        Node<E> currentNode = root;

        //make a parentNode that points to the parent node of currentNode
        Node<E> parentNode = null;

        //repeat until we reach the child of a leaf (a node with no children), which is essentially null
        while (currentNode != null)
        {
            //store currentNode into parentNode before currentNode is changed
            parentNode = currentNode;
            //if x is equal to currentNode's value, return false since the value already exists in the BST
            if (x.compareTo(currentNode.value) == 0)
            {
                return false;
            }
            //if x is less than currentNode's value, then travel down the left of currentNode
            else if (x.compareTo(currentNode.value) < 0)
            {
                currentNode = currentNode.left;
            }
            //if x is greater than currentNode's value, then travel down the right of currentNode
            else
            {
                currentNode = currentNode.right;
            }
        }

        //set newNode's parent to be the leaf
        newNode.parent = parentNode;

        //use if statements to decide whether to place newNode either to the left or right of the leaf
        if(x.compareTo(parentNode.value) < 0)
        {
            parentNode.left = newNode;
        }
        else
        {
            parentNode.right = newNode;
        }

        //increment the size of the BST by 1
        size++;

        return true;
    }

    //the method returns the value if deleteNode manages to remove it from the BST.
    //else, if it doesn't manage to find the value, it returns null
    @Override
    public E remove(E x)
    {
        //if the findNode() method found a node containing x in the BST, call the deleteNode function
        if (findNode(x) != null)
        {
            Node<E> temp = deleteNode(root, x);
            //Decrement the size of the BST by 1
            size--;
            return x;
        }
        else
        {
            //method returns null if no node containing x is found in the BST
            return null;
        }
    }

    //this method deletes the node containing the value x from the BST if such a node exists
    //else, if such a node is not found, the method returns null
    public Node<E> deleteNode(Node<E> node, E x)
    {
        //return null if the root doesn't exist
        if (node == null)
        {
            return null;
        }
        //recursively call the method if x is greater than the value of the root
        if (x.compareTo(node.value) > 0)
        {
            node.right = deleteNode(node.right, x);
        }
        //recursively call the method if x is lesser than the value of the root
        else if (x.compareTo(node.value) < 0)
        {
            node.left = deleteNode(node.left, x);
        }
        //the node to be deleted has been found
        else
        {
            //if node to be deleted has two children
            if ((node.left != null) && (node.right != null))
            {
                Node<E> secondBiggestNode = findMinNode(node.right);
                node.value = secondBiggestNode.value;
                Node<E> temp = deleteNode(node.right, secondBiggestNode.value);
            }
            //if node only has a left child
            else if (node.left != null)
            {
                node = node.left;
            }
            //if node only has a right child
            else if (node.right != null)
            {
                node = node.right;
            }
            //if node has no children
            else
            {
                node = null;
            }
        }

        //return the pointer to the node to be deleted
        return node;
    }

    //this method is exactly like the find(E x) method, but returns the node found instead of the value of the node found
    public Node<E> findNode(E x)
    {
        //check if the BST is empty
        if (isEmpty())
        {
            return null;
        }

        //make a currentNode variable that points to the root node
        Node<E> currentNode = root;

        while (currentNode != null)
        {
            //if currentNode's value is equal to x, then return Node since it has been found
            if (x.compareTo(currentNode.value) == 0)
            {
                return currentNode;
            }
            //if x is less than currentNode's value then x must be to the left of currentNode
            else if (x.compareTo(currentNode.value) < 0)
            {
                //set currentNode to be currentNode's left child
                currentNode = currentNode.left;
            }
            //if x is bigger than currentNode's value then x must be to the right of curNode
            else if (x.compareTo(currentNode.value) > 0)
            {
                //set currentNode to be currentNode's right child
                currentNode = currentNode.right;
            }
        }

        //when currentNode is null, then that means x could not be found
        return null;
    }

    //this method returns the value of the node if it is found. Else, it returns null
    @Override
    public E find(E x)
    {
        //check if the BST is empty
        if (isEmpty())
        {
            return null;
        }

        //make a currentNode variable that points to the root node
        Node<E> curNode = root;

        while (curNode != null)
        {
            //if currentNode's value is equal to x, then return the value since it has been found
            if (x.compareTo(curNode.value) == 0)
            {
                return curNode.value;
            }
            //if x is less than currentNode's value then x must be to the left of currentNode
            else if (x.compareTo(curNode.value) < 0)
            {
                //set currentNode to be currentNode's left child
                curNode = curNode.left;
            }
            //if x is greater than currentNode's value then x must be to the right of currentNode
            else if (x.compareTo(curNode.value) > 0)
            {
                //set currentNode to be currentNode's right child
                curNode = curNode.right;
            }
        }

        //when currentNode is null, then that means x could not be found
        return null;
    }

    //this method finds and returns the smallest value held by a node in the BST
    @Override
    public E findMin()
    {
        //make a currentNode variable that points to the root node
        Node<E> currentNode = root;

        //while currentNode has a left child, travel down the left side of tree
        while (currentNode.left != null)
        {
            currentNode = currentNode.left;
        }

        //when you get to left-most leaf, return its value
        return currentNode.value;
    }

    //this method finds and returns the largest value held by a node in the BST
    @Override
    public E findMax()
    {
        //make a currentNode variable that points to the root node
        Node<E> currentNode = root;

        //while currentNode has a right child, travel down the right side of tree
        while (currentNode.right != null)
        {
            currentNode = currentNode.right;
        }

        //when you get to right-most leaf, return its value
        return currentNode.value;
    }

    //this method finds and returns the node containing the smallest value in the BST
    public Node<E> findMinNode(Node<E> node)
    {
        //while node has a left child, travel down left side of tree
        while (node.left != null)
        {
            node = node.left;
        }

        //when you get to left-most leaf, return the node
        return node;
    }

    //this method finds and returns the node containing the largest value in the BST
    public Node<E> findMaxNode(Node<E> node)
    {
        //while node has a right child, travel down right side of tree
        while (node.right != null)
        {
            node = node.right;
        }
        //when you get to right-most leaf, return the node
        return node;
    }

    //this method finds and returns the height of the BST
    public int height()
    {
        //if tree is empty then the method should return -1
        if (isEmpty())
        {
            return -1;
        }

        //else calculate and return height using the recursive computeDepth method
        return computeDepth(root);
    }

    //this method calculates the depth of certain node in the BST
    public int computeDepth(Node<E> node)
    {
        //if the node is null (does not exist) then return -1
        if (node == null)
        {
            return -1;
        }

        //else return 1 + max of the depth of right child and depth of the left child through recursive calls
        else
        {
            return (1 + Math.max(computeDepth(node.right),computeDepth(node.left)));
        }
    }
}