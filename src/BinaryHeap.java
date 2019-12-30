import java.util.Arrays;

/**
 * This is a binary heap and specifically a max int heap
 */
public class BinaryHeap {

    public BinaryHeap(){
        this(10);
    }

    public BinaryHeap(int capacity){
        BinaryHeap.CAPACITY = capacity;
        arr = new int[capacity];
    }

    public static int CAPACITY;
    public int size = 0;
    int[] arr = null;

    public int parentIndex(int index){ return (index-1)/2; }
    public int leftChildIndex(int parentIndex){
        int childIndex = 2*parentIndex+1;
        return childIndex >= size ? -1 : childIndex;
    }
    public int rightChildIndex(int parentIndex){
        int childIndex = 2*parentIndex+2;
        return childIndex >= size ? -1 : childIndex;
    }

    public void insert(int data){
        if(size >= CAPACITY){
            System.out.println("\nArray FULL!");
            return;
        }

        if(size == 0)
            arr[size++] = data;
        else {
            arr[size++] = data;
            heapifyUp(size-1);
        }

    }

    public void remove(){
        System.out.println("Removing -> "+arr[0]);
        if(size == 0)
            System.out.println("Array Empty");
        else {
            arr[0] = arr[size-1];
            arr[--size] = 0;

            heapifyDown(0);
        }
    }

    void heapifyUp(int index) {
        int parentIndex = parentIndex(index);
        if(arr[index] > arr[parentIndex]){
            swap(index, parentIndex);
            if(index != 0)
                heapifyUp(parentIndex);
        }

    }


    void heapifyDown(int index){
        int leftChildIndex = leftChildIndex(index);
        int rightChildIndex = rightChildIndex(index);


        if((leftChildIndex == -1 || arr[index] > arr[leftChildIndex]) &&
           (rightChildIndex == -1 || arr[index] > arr[rightChildIndex])) {
            return;
        }

        int largerChildIndex = (rightChildIndex == -1) ? leftChildIndex : arr[leftChildIndex] > arr[rightChildIndex] ? leftChildIndex : rightChildIndex;
        swap(index, largerChildIndex);

        heapifyDown(largerChildIndex);



    }

    void swap(int index, int parentIndex){
        int parent = arr[parentIndex];
        arr[parentIndex] = arr[index];
        arr[index] = parent;
    }

    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap();
        binaryHeap.insert(50);
        binaryHeap.insert(25);
        binaryHeap.insert(75);
        binaryHeap.insert(125);
        binaryHeap.insert(10);
        binaryHeap.insert(40);
        binaryHeap.insert(100);
        binaryHeap.insert(80);
        binaryHeap.insert(90);
        binaryHeap.insert(200);
        binaryHeap.insert(15);


        System.out.println(binaryHeap);

        binaryHeap.remove();
        System.out.println(binaryHeap);
        binaryHeap.remove();
        System.out.println(binaryHeap);
        binaryHeap.remove();
        System.out.println(binaryHeap);
        binaryHeap.remove();
        System.out.println(binaryHeap);
        binaryHeap.remove();
        System.out.println(binaryHeap);
        binaryHeap.remove();
        System.out.println(binaryHeap);
        binaryHeap.remove();
        System.out.println(binaryHeap);
        binaryHeap.remove();
        System.out.println(binaryHeap);

    }


    @Override
    public String toString() {
        return "{" + Arrays.toString(arr) + "}";
    }
}
