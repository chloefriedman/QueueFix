public class LinkedQueue implements QueueInterface
{
    // returns the logical size of the queue
    public int size();    
    
    // tests if this queue is empty
    public boolean empty();
    
    // adds an item onto the rear of this queue
    public T add(T item);
        
    // looks at the object at the front of this queue
    // without removing it from the queue
    public T peek() throws QueueUnderflowException;
    
    // removes the object at the front of this queue 
    // and returns that object as the value of this function
    public T remove() throws QueueUnderflowException;
    
    // removes all of the elements from this stack
    void clear();
}