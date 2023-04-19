/**
 * The BTQueue class implements a queue data structure specifically designed for BinaryTreeNode elements.
 * It allows elements to be added to the back of the queue and removed from the front of the queue.
 * <p>
 * @author Hussein Suleman
 * @param <dataType> The type of data stored in the queue
 */
public class BTQueue<dataType>
{   
   BTQueueNode<dataType> head;
   BTQueueNode<dataType> tail;
   /**
    * Constructs an empty BTQueue.
   */  
   public BTQueue ()
   {
      head = null;
      tail = null;
   }
   /**
    * Retrieves and removes the head of the queue.
    * @return BinaryTreeNode The head of the queue, or null if the queue is empty
    */
   public BinaryTreeNode<dataType> getNext ()
   {
      if (head == null)
         return null;
      BTQueueNode<dataType> qnode = head;
      head = head.next;
      if ( head == null )
         tail = null;
      return qnode.node;
   }
   /**
    * Inserts the specified element into the queue
    * @param node The BinaryTreeNode to be added to the queue
    */
   public void enQueue ( BinaryTreeNode<dataType> node )
   {
      if (tail == null)
      {   
         tail = new BTQueueNode<dataType> (node, null);
         head = tail;
      }   
      else
      {
         tail.next = new BTQueueNode<dataType> (node, null);
         tail = tail.next;
      }   
   }   
}
