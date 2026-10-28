@SuppressWarnings("unchecked")
public class ArrayQueue<T> implements QueueInterface<T>
{
    private T[] queue;
    private int size;
    private int headIndex;
    private int tailIndex;

    public ArrayQueue()
    {
        this.queue = (T[])new Object[4];
        size = 0;
        headIndex = 0;
        tailIndex = 0;       
    }
    // returns the logical size of the queue
    public int size()
    {
        return size;
    } 
    
    // tests if this queue is empty
    public boolean empty()
    {
        return (size == 0);
    }

    private boolean isFull()
    {
        return(size == queue.length);
    }
    
    // adds an item onto the rear of this queue
    public T add(T item)
    {
        if(isFull())
            {
                doubleLength();
                queue[tailIndex] = item;
                size++;
                tailIndex++;
            }
       else if (tailIndex == queue.length - 1)
       {
            tailIndex = 0;
            queue[tailIndex] = item;
            size++;
            tailIndex++;
        }
       
       else
       {
            queue[tailIndex] = item;
            tailIndex++;
            size++;
       }
       return item;
    }
        
    // looks at the object at the front of this queue
    // without removing it from the queue
    public T peek() throws QueueUnderflowException
    {
       if(queue[headIndex] == null || empty())
       {
            throw new QueueUnderflowException("No elements in the queue");
       }
       else
       {
            return queue[headIndex];
       }
    }
    
    // removes the object at the front of this queue 
    // and returns that object as the value of this function
    public T remove() throws QueueUnderflowException
    {
        if(empty())
       {
            throw new QueueUnderflowException("No elements in the queue");
       }
       else
       {
        
            T current = queue[headIndex];
            queue[headIndex] = null;
                headIndex++;
            size--;
            if(size <= queue.length/4)
            {
                halfLength();
            }
            return current;
       }
    }
    
    // removes all of the elements from this stack
    public void clear()
    {
        for (int i = 0; i < queue.length; i++)
        {
            queue[i] = null;
        }
        size = 0;
        headIndex = 0;
        tailIndex = 0;
    }

      public void doubleLength()
    {
        int length = queue.length;
        T[] newQueue = (T[])new Object[2*length];
        if(tailIndex > headIndex)
        {
            for(int i = headIndex; i < queue.length; i++)
            {
                newQueue[i] = queue[i];
            }
        }
        else
        {
           for(int i = headIndex; i < queue.length; i++)
            {
                newQueue[i - headIndex] = queue[i];
            } 
            for(int i = 0; i < headIndex; i++)
            {
                newQueue[i + queue.length - headIndex] = queue[i];
            }
            headIndex = 0;
            tailIndex = size -1;
        }
       

        queue = newQueue;
    }
    public void halfLength()
    {
        int length = this.queue.length;
        T[] newQueue = (T[])new Object[length/2];
        for(int i = 0; i < newQueue.length; i++)
        {
            newQueue[i] = queue[i];
        }

        queue = newQueue;
    }
}