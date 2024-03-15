
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

        // this is not recursive
    public static int partition(List<Integer> list, int low, int high) {
        int pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j) <= pivot) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    public static void moveBack(List<Integer> list, int i) {
        int temp = list.get(i);
        list.remove(i);
        list.add(temp);
    }
    public static int recursivePartition(List<Integer> list, int low, int pivotIndex) {
        if( low == pivotIndex ){
            return pivotIndex;
        }
        else 
        {
            int pivot = list.get(pivotIndex);
            if( list.get(low) > pivot ){
                moveBack(list, low);
                return recursivePartition( list, low , pivotIndex - 1);
            }
            return recursivePartition( list, low + 1 , pivotIndex );
        }
    }

    public static void quickSort(List<Integer> list, int low, int high) {
        if (low < high) {
            // int pivotIndex = partition(list, low, high);
            int pivotIndex = recursivePartition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }


    public static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(7);
        list.add(10);
        list.add(9);
        list.add(1);
        list.add(5);

        System.out.println("Lista original:");
        printList(list);

        quickSort(list, 0, list.size() - 1);

        System.out.println("Lista ordenada:");
        printList(list);
    }
}
