import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class main
{
    public static void main(String[] args) throws IOException
    {
        // Read in command line arguments
        int arr_size = Integer.parseInt(args[0]);

        File report_txt = new File(args[1]);
        BufferedWriter report = new BufferedWriter(new FileWriter(report_txt));

        File unsorted_txt = new File(args[2]);
        BufferedWriter unsorted = new BufferedWriter(new FileWriter(unsorted_txt));

        File sorted_txt = new File(args[3]);
        BufferedWriter sorted = new BufferedWriter(new FileWriter(sorted_txt));


        ArrayList<Integer> arr = QuickSorter.generateRandomList(arr_size);

        // Convert ArrayList to int[]
        int[] int_list = convertToArray(arr);

        // Write unsorted arr to file
        unsorted.write(Arrays.toString(int_list));

        report.write("UNSORTED -> SORTED"); report.newLine();
        report.write("Array Size = " + arr_size); report.newLine();
        report.write("FIRST_ELEMENT : " + QuickSorter.timedQuickSort(arr, QuickSorter.PivotStrategy.FIRST_ELEMENT)); report.newLine();
        report.write("RANDOM_ELEMENT : " + QuickSorter.timedQuickSort(arr, QuickSorter.PivotStrategy.RANDOM_ELEMENT)); report.newLine();
        report.write("MEDIAN_OF_THREE_RANDOM_ELEMENTS : " + QuickSorter.timedQuickSort(arr, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS)); report.newLine();
        report.write("MEDIAN_OF_THREE_ELEMENTS : " + QuickSorter.timedQuickSort(arr, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_ELEMENTS)); report.newLine(); report.newLine();

        int[] sorted_list = QuickSorter.access_list;
        // Write sorted arr to file
        sorted.write(Arrays.toString(sorted_list));


        // Unsorted JUST 10% of elements
        double calc_ten = arr_size * .1;
        int tenpercent_arr = (int)calc_ten;


        Random numGen = new Random();
        for(int count = 0; count < tenpercent_arr; count++)
        {
            int toswap1 = numGen.nextInt(arr_size);
            int toswap2 = numGen.nextInt(arr_size);

            int temp = sorted_list[toswap1];
            sorted_list[toswap1] = sorted_list[toswap2];
            sorted_list[toswap2] = temp;

        }

        // Convert int[] back to ArrayList for it to be passed
        arr = convertToList(sorted_list);

        report.write("10% UNSORTED -> SORTED"); report.newLine();
        report.write("Array Size = " + arr_size); report.newLine();
        report.write("FIRST_ELEMENT : " + QuickSorter.timedQuickSort(arr, QuickSorter.PivotStrategy.FIRST_ELEMENT)); report.newLine();
        report.write("RANDOM_ELEMENT : " + QuickSorter.timedQuickSort(arr, QuickSorter.PivotStrategy.RANDOM_ELEMENT)); report.newLine();
        report.write("MEDIAN_OF_THREE_RANDOM_ELEMENTS : " + QuickSorter.timedQuickSort(arr, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS)); report.newLine();
        report.write("MEDIAN_OF_THREE_ELEMENTS : " + QuickSorter.timedQuickSort(arr, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_ELEMENTS)); report.newLine(); report.newLine();

        // Already sorted so just run through it
        report.write("SORTED -> SORTED"); report.newLine();
        report.write("Array Size = " + arr_size); report.newLine();
        report.write("FIRST_ELEMENT : " + QuickSorter.timedQuickSort(arr, QuickSorter.PivotStrategy.FIRST_ELEMENT)); report.newLine();
        report.write("RANDOM_ELEMENT : " + QuickSorter.timedQuickSort(arr, QuickSorter.PivotStrategy.RANDOM_ELEMENT)); report.newLine();
        report.write("MEDIAN_OF_THREE_RANDOM_ELEMENTS : " + QuickSorter.timedQuickSort(arr, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS)); report.newLine();
        report.write("MEDIAN_OF_THREE_ELEMENTS : " + QuickSorter.timedQuickSort(arr, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_ELEMENTS)); report.newLine(); report.newLine();



        // Flushing and closing to get output to files
        report.flush();
        report.close();

        sorted.flush();
        sorted.close();

        unsorted.flush();
        unsorted.close();
    }

    public static int[] convertToArray(ArrayList<Integer> int_arr)
    {
        // Convert ArrayList to int[]
        Object[]holder = int_arr.toArray();
        int[] temp = new int[holder.length];
        for(int i = 0; i < holder.length; i++)
        {
            temp[i] = (int) holder[i];
        }

        return temp;
    }

    public static ArrayList<Integer> convertToList(int[] int_arr)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i < int_arr.length; i++)
        {
            temp.add(int_arr[i]);
        }
        return temp;
    }





}
