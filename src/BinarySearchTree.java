/**
 * <h1>Binary Search Tree Class</h1>
 * This class represents a Binary Search Tree data structure. It extends the BinaryTree class.
 * The Binary Search Tree is generic and works with any data type that implements Comparable interface.
 * The nodes in the tree are sorted based on their values.
 * <p>
 * @author Hussein Suleman
 * @param <dataType> The data type of the elements stored in the tree.
*/

public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   /**
    * Inserts a new node with the specified data in the tree
    * @param d The data to be inserted.
    */
   public void insert ( dataType d )
   {
      if (root == null)
         root = new BinaryTreeNode<dataType> (d, null, null);
      else
         insert (d, root);
   }

   /**
    * Inserts a new node with the specified data in the subtree rooted at the given node.
    * @param d The data to be inserted.
    * @param node The root of the subtree to insert the node into.
    */
   public void insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (d.compareTo (node.data) <= 0)
      {
         if (node.left == null)
            node.left = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         if (node.right == null)
            node.right = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.right);
      }
   }
   
   /**
    * Finds the node containing the specified data in the tree.
    * @param d The data to be searched for.
    * @return The node containing the specified data, or null if not found.
    */
   public BinaryTreeNode<dataType> find ( dataType d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }

   /**
    * Finds the node containing the specified data in the subtree rooted at the given node.
    * @param d The data to be searched for.
    * @param node The root of the subtree to search in.
    * @return Returns the node containing the specified data, or null if not found.
    */
   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (d.compareTo (node.data) == 0) 
         return node;
      else if (d.compareTo (node.data) < 0)
         return (node.left == null) ? null : find (d, node.left);
      else
         return (node.right == null) ? null : find (d, node.right);
   }
   /**
    * Deletes the node containing the specified data from the tree.
    * @param d The data to be deleted.
    */
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }   

   /**
    * Deletes the node containing the specified data from the subtree rooted at the given node.
    * @param d The data to be deleted.
    * @param node The root of the subtree to delete the node from.
    * @return The root of the modified subtree.
    */
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else if (node.left != null && node.right != null )
      {
         node.data = findMin (node.right).data;
         node.right = removeMin (node.right);
      }
      else
         if (node.left != null)
            node = node.left;
         else
            node = node.right;
      return node;
   }
   
   /**
    * Returns the node containing the minimum value in the binary search tree rooted at the specified node.
    * @param node The root node of the binary search tree to search
    * @return The node containing the minimum value, or null if the tree is empty
    */
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }

   /**
    * Removes the node containing the minimum value in the binary search tree rooted at the specified node.
    * @param node The root node of the binary search tree to modify
    * @return The root node of the modified binary search tree, or null if the tree is empty
    */
   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return null;
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }
   
}
