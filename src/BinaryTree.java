/**
 * <h1>BinaryTree Class</h1>
 * The BinaryTree class represents a binary tree data structure.
 * It consists of a root node, which is a BinaryTreeNode object.
 * <p>
 * @author Hussein Suleman
 * @param <dataType> The type of data stored in the nodes of the tree
 */

public class BinaryTree<dataType>
{
   BinaryTreeNode<dataType> root;
   /**
    * Creates a new empty BinaryTree object with null root
    */
   public BinaryTree ()
   {
      root = null;
   }
   /**
    * Returns the height of the tree
    * @return int The height of the tree
    */
   public int getHeight ()
   {
      return getHeight (root);
   }
   /**
    * Returns the height of the subtree rooted at the given node
    * @param node The root of the subtree
    * @return int The height of the subtree rooted at the given node
    */
   public int getHeight ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   /**
    * Returns the size of the tree
    * @return int The size of the tree
    */
   public int getSize ()
   {
      return getSize (root);
   }   
   /**
    * Returns the size of the subtree rooted at the given node
    * @param node The root of the subtree
    * @return int The size of the subtree rooted at the given node
    */
   public int getSize ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   /**
    * Prints the data stored in the given node
    * @param node The node to visit
    */
   public void visit ( BinaryTreeNode<dataType> node )
   {
      System.out.println (node.data);
   }
   /**
    * Traverses the tree in pre-order
    */
   public void preOrder ()
   {
      preOrder (root);
   }
   /**
    * Traverses the subtree rooted at the given node in pre-order
    * @param node The root of the subtree
    */
   public void preOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }
   /**
    * Traverses the tree in post-order
    */
   public void postOrder ()
   {
      postOrder (root);
   }
   /**
    * Traverses the subtree rooted at the given node in post-order
    * @param node The root of the subtree
    */
   public void postOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }
   /**
    * Traverses the tree in in-order
    */
   public void inOrder ()
   {
      inOrder (root);
   }
   /**
    * Traverses the subtree rooted at the given node in in-order
    * @param node The root of the subtree
    */
   public void inOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }
   /**
    * Traverses the tree in level-order
    */
   public void levelOrder ()
   {
      if (root == null)
         return;
      BTQueue<dataType> q = new BTQueue<dataType> ();
      q.enQueue (root);
      BinaryTreeNode<dataType> node;
      while ((node = q.getNext ()) != null)
      {
         visit (node);
         if (node.getLeft () != null)
            q.enQueue (node.getLeft ());
         if (node.getRight () != null)
            q.enQueue (node.getRight ());
      }
   }
}