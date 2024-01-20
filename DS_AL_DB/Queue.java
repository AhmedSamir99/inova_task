import java.util.Arrays;
//enqueue O(1)
// dequeue worst case O(n)
public class Queue {

    private final int[] array;
    private final int size ;
    private final int front ;
    private int rear ;
    public Queue(int size) {
        this.array = new int[size];
        this.size = size;
        front = 0;
        rear = -1;
    }

    public void enqueue(int input){
        if(!isFull()){
            array[++rear]=input;
        }
        else{
            System.out.println("the queue is full");
        }
    }

    public void dequeue(){
        if(!isEmpty()){
            rear--;
        }
        else{
            System.out.println("the queue is emtpy");
        }
    }


    private Boolean isEmpty(){
        return rear<front;
    }

    private Boolean isFull(){
        return rear-front+1 == size;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
