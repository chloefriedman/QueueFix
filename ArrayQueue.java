public class ArrayQueue<T> implements QueueInterface<T>{
    // returns the logical size of the queue
    private T[] queue;
    private int size;
    private int headInd;
    private int tailInd;

    public ArrayQueue(){
        this.queue = (T[]) new Object[4];
        size = 0;
        headInd = 0;
        tailInd = 0;
    }

    public int size(){
        return size;
    }   
    
    // tests if this queue is empty
    public boolean empty(){
        return(size == 0);
    }

    public boolean isFull(){
        return (size == queue.length);
    }
    
    // adds an item onto the rear of this queue
    public T add(T item){
        if(empty()){
            headInd = 0;
            tailInd = 0;
        }
        else{
            if(isFull()){
                doubleLength();
            }
            if(tailInd == queue.length - 1){
                tailInd = 0;
            }
            else{
                tailInd++;
            }
        }
        queue[tailInd] = item;
        size++;
        return item;
    }
        
    // looks at the object at the front of this queue
    // without removing it from the queue
    public T peek() throws QueueUnderflowException{
        if(empty()){
            throw new QueueUnderflowException("No elements in the queue");
        }
        else
        return queue[headInd];

    }
    
    // removes the object at the front of this queue 
    // and returns that object as the value of this function
    public T remove() throws QueueUnderflowException{
         if(empty()){
            throw new QueueUnderflowException("No elements in the queue");
        }
        else{
            T current = queue[headInd];
            queue[headInd] = null;
            size--;
            if(size == 0){
                headInd = 0;
                tailInd = 0;
            }
            else{
                if(headInd == queue.length - 1){
                    headInd = 0;
                }
                else{
                    headInd++;
                }
                if(queue.length > 4 && size <= queue.length / 4){
                    halfLength();
                }
            }
            return current;
        }
    }
    
    // removes all of the elements from this stack
    public void clear(){
        queue = (T[]) new Object[4];
        size = 0;
        headInd = 0;
        tailInd = 0;
    }
    
    public void doubleLength(){
        int length = queue.length;
        T[] newQueue = (T[]) new Object[length * 2];
        int current = headInd;
        for(int i = 0; i < size; i++){
            newQueue[i] = queue[current];
            current++;
            if(current == length){
                current = 0;
            }
        }
        queue = newQueue;
        headInd = 0;
        tailInd = size - 1;
        
    }

    public void halfLength(){
        int length = queue.length;
        T[] newQueue = (T[]) new Object[length / 2];
        int current = headInd;
        for(int i = 0; i < size; i++){
            newQueue[i] = queue[current];
            current++;
            if(current == length){
                current = 0;
            }
        }
        queue = newQueue;
        headInd = 0;
        tailInd = size - 1;
    }
}