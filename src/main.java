public class main
{
    public static void main(String[] args)
    {
        System.out.println("Duration: " + QuickSorter.timedQuickSort(QuickSorter.generateRandomList(10), QuickSorter.PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS));
    }
}
