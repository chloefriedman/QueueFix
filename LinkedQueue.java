@SuppressWarnings("unchecked")
public class LinkedQueue<T> implements QueueInterface<T>
{
    private LLNode<T> stack;
    private int size;

    public LinkedQueue()
    {
        size = 0;
        stack = null;
    }
    // returns the logical size of the queue
    public int size()
    {
        return size;
    } 
    
    // tests if this queue is empty
    public boolean empty()
    {
        return(size == 0);
    }
    
    // adds an item onto the rear of this queue
    public T add(T item)
    {
        if(size == 0)
        {
            stack = new LLNode<T>(item);
            return stack.getInfo();
        }
        else
        {
            LLNode<T> temp = stack;
            while(temp.getLink() != null)
            {
                temp = temp.getLink();
            }
            LLNode<T> toAdd = new LLNode<T>(item);
            temp.setLink(toAdd);
            size++;
            return toAdd.getInfo();
        }
        
    }
        
    // looks at the object at the front of this queue
    // without removing it from the queue
    public T peek() throws QueueUnderflowException
    {
        if(stack == null || size == 0)
        {
            throw new QueueUnderflowException("No items in Queue");
        }
        else
        {
            return stack.getInfo();
        }
    }
    
    // removes the object at the front of this queue 
    // and returns that object as the value of this function
    public T remove() throws QueueUnderflowException
    {
        if(stack == null || size == 0)
        {
            throw new QueueUnderflowException("No items in Queue");
        }
        else
        {
            T removing = stack.getInfo();
            LLNode<T> tempRef = stack.getLink();
            stack = tempRef;
            size--;
            return removing;
        }
    }
    
    // removes all of the elements from this stack
    public void clear()
    {
        stack = null;
        size = 0;
    }
}