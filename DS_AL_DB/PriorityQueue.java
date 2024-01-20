// enqueue O(log(n))
// dequeue O(log(n))
public class PriorityQueue {
    private Element[] arr; // Array of elements
    private int size;      // Maximum size of the queue
    private int count;     // Current number of elements in the queue

    class Element {
        int value;
        int priority;
    }

    PriorityQueue(int size){
        this.arr = new Element[size];
        this.size=size;
        this.count=0;
    }

    // Function to add an element `x` with priority `p`
    public void enqueue(int x, int p) {

        if(!isFull()){
            Element item = new Element();
            item.value = x;
            item.priority = p;

            // Place the element based on its priority
            int i;
            for (i = count - 1; (i >= 0 && arr[i].priority < p); i--) {
                arr[i + 1] = arr[i];
            }
            arr[i + 1] = item;
            count++;
        }
    }
    void dequeue() {
        if (isEmpty()) {
            System.out.println("Underflow! Priority Queue is empty.");
            return;
        }

        // Shift all elements to the left
        for (int i = 0; i < count - 1; i++) {
            arr[i] = arr[i + 1];
        }
        count--;
    }



    boolean isEmpty() {
        return count == 0;
    }

    boolean isFull() {
        return count == size;
    }


}
