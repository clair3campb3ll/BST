/**
 * <h1>BTQueueNode Class</h1>
 * The BTQueueNode class is a node for the BTQueue class.
 * It contains a BinaryTreeNode element and a reference to the next node in the queue.
 * <p>
 * @author Hussein Suleman
 * @param <dataType> The type of data stored in the queue node
 */
public class BTQueueNode<dataType>
{
   BinaryTreeNode<dataType> node;
   BTQueueNode<dataType> next;
   /**
    * Constructs a BTQueueNode with the specified element and next node
    * @param n The BinaryTreeNode element in this node
    * @param nxt The next node in the queue
    */
   public BTQueueNode ( BinaryTreeNode<dataType> n, BTQueueNode<dataType> nxt )
   {
      node = n;
      next = nxt;
   }
}
