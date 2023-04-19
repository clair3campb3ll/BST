/**
 * <h1>BinaryTreeNode Class</h1>
 * The BinaryTreeNode class represents a node in a binary tree data structure. 
 * Each node has a data element of generic data type, and two child nodes, left and right.
 * <p>
 * @author Hussein Suleman
 * @param <dataType> the type of data stored in the node
 */

public class BinaryTreeNode<dataType>
{
   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   
   /**
    * Creates a new BinaryTreeNode object with the given data and child nodes
    * @param d The data to store in the node
    * @param l The left child of the node
    * @param r The right child of the node
    */
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
   }
   /**
    * Returns the left child of the node
    * @return BinaryTreeNode The left child of the node
    */
   BinaryTreeNode<dataType> getLeft () { return left; }
   /**
    * Returns the right child of the node.
    * @return BinaryTreeNode The right child of the node
    */
   BinaryTreeNode<dataType> getRight () { return right; }
}
