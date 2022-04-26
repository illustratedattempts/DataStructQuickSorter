import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class QuickSorter
{
    enum PivotStrategy
    {
        FIRST_ELEMENT,
        RANDOM_ELEMENT,
        MEDIAN_OF_THREE_RANDOM_ELEMENTS,
        MEDIAN_OF_THREE_ELEMENTS
    }

    public static <E extends Comparable<E>> Duration timedQuickSort(ArrayList<E> list, PivotStrategy pivotStrategy)
    {
        // Convert Object ArrayList to int[]
        Object[] list_holder = list.toArray();
        int[] int_list = new int[list_holder.length];
        for(int i = 0; i < list_holder.length; i++)
        {
            int_list[i] = (int) list_holder[i];
        }

        // Start Program Timing Here:
        long startTime = System.nanoTime();
        quickSort(int_list, 0, int_list.length-1, pivotStrategy);

        long endTime = System.nanoTime();
        long exec_Time = endTime - startTime;

        return Duration.ofNanos(exec_Time);

    }
    private static void quickSort(int[] a, int left, int right, PivotStrategy pivotStrategy)
    {
        if(left < right)
        {
            //System.out.println("lo: " + left + " hi: " + right + " Before Partition: " + Arrays.toString(a));
            int pivot_pos = partition(a, left, right, pivotStrategy);
            quickSort(a, left, pivot_pos - 1, pivotStrategy);
            quickSort(a, pivot_pos + 1, right, pivotStrategy);
        }
    }
    private static int partition(int[] arr, int lo, int hi, PivotStrategy pivotStrategy)
    {
        int pivot = -1;
        int pivot_holder = hi;
        int j = lo;
        int j_limit = hi - 1;


        // Assign Pivot:
        switch (pivotStrategy)
        {
            case FIRST_ELEMENT -> {
                pivot = arr[lo];
                arr[lo] = arr[hi];
                arr[hi] = pivot;
            }
            case RANDOM_ELEMENT -> {
                Random genRando = new Random();
                int randoIndex = genRando.nextInt(hi - lo) + lo;
                pivot = arr[randoIndex];
                arr[randoIndex] = arr[hi];
                arr[hi] = pivot;
            }
            case MEDIAN_OF_THREE_ELEMENTS -> {
                // Get the Median of 3 Elements and then re-arrange them
                int center = (lo + hi) / 2;
                if (arr[center] < arr[lo])
                {
                    int temp = arr[center];
                    arr[center] = arr[lo];
                    arr[lo] = temp;
                }
                if (arr[hi] < arr[lo])
                {
                    int temp = arr[hi];
                    arr[hi] = arr[lo];
                    arr[lo] = temp;
                }
                if (arr[hi] < arr[center])
                {
                    int temp = arr[hi];
                    arr[hi] = arr[center];
                    arr[center] = temp;
                }

                // Set the center as the second to last element
                int temp_med3 = arr[center];
                arr[center] = arr[hi - 1];
                arr[hi - 1] = temp_med3;
                pivot_holder = hi - 1;
                pivot = arr[pivot_holder];
                j_limit = hi - 1 - 1;
            }
            case MEDIAN_OF_THREE_RANDOM_ELEMENTS -> {
                Random genRandoEle = new Random();
                int Index1 = genRandoEle.nextInt(hi - lo) + lo;
                int Index2 = genRandoEle.nextInt(hi - lo) + lo;
                int Index3 = genRandoEle.nextInt(hi - lo) + lo;
                int before = Index1;
                int middle = Index2;
                int after = Index3;
                System.out.println("BEFORE: " + Arrays.toString(arr));
                //System.out.println("BEFORE: " +  "before: " + before + " middle: " + middle + " after: " + after);
                // Need to compare positions to know where they are for placement
                if (middle < before)
                {
                    int temp_med3r = before;
                    before = middle;
                    middle = temp_med3r;
                }
                if (after < before)
                {
                    int temp_med3r = after;
                    after = before;
                    before = temp_med3r;
                }
                if (after < middle)
                {
                    int temp_med3r = after;
                    after = middle;
                    middle = temp_med3r;
                }
                //System.out.println("AFTER: " + "before: " + before + " middle: " + middle + " after: " + after);
                // Swap numbers inside the positions themselves
                //System.out.println("BEFORE: " + "before: " + arr[before] + " middle: " + arr[middle] + " after: " + arr[after]);
                if (arr[middle] < arr[before])
                {
                    int temp = arr[middle];
                    arr[middle] = arr[before];
                    arr[before] = temp;
                }
                if (arr[after] < arr[before])
                {
                    int temp = arr[after];
                    arr[after] = arr[before];
                    arr[before] = temp;
                }
                if (arr[after] < arr[middle])
                {
                    int temp = arr[after];
                    arr[after] = arr[middle];
                    arr[middle] = temp;
                }
                //System.out.println("AFTER: " + "before: " + arr[before] + " middle: " + arr[middle] + " after: " + arr[after]);
                // Move the already sorted elements into place like Median of 3:

                /*
                // Swap first and middle
                int temp_swap1 = arr[lo];
                arr[lo] = arr[before];
                arr[before] = temp_swap1;

                int temp_swap2 = arr[hi];
                arr[hi] = arr[after];
                arr[after] = temp_swap2;
                */

                int temp_swap = arr[hi];
                arr[hi] = arr[middle];
                arr[middle] = temp_swap;
                System.out.println("AFTER: " + Arrays.toString(arr));
                pivot = arr[pivot_holder];
                System.out.println("Pivot: " + pivot + " Pivot_Holder: " + pivot_holder);
            }
        }
        int i = lo - 1;
        for(; j <= j_limit; j++)
        {
            if(arr[j] < pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[pivot_holder];
        arr[pivot_holder] = temp;
        System.out.println("lo: " + lo + " hi: " + hi + " After Partition: " + Arrays.toString(arr));
        return i;
    }
    public static ArrayList<Integer> generateRandomList(int size)
    {
        ArrayList<Integer> holder = new ArrayList<>();
        // Random Number Generator
        Random randoGen = new Random();
        int i = 0;
        while(i < size)
        {
            holder.add(randoGen.nextInt());
            i++;
        }
        return holder;
    }
}
