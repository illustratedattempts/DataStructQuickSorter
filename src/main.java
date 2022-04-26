public class main
{
    public static void main(String[] args)
    {
        int size = 1000000;
        System.out.println("First Element: " + QuickSorter.timedQuickSort(QuickSorter.generateRandomList(size), QuickSorter.PivotStrategy.FIRST_ELEMENT));
        System.out.println("Random Element: " + QuickSorter.timedQuickSort(QuickSorter.generateRandomList(size), QuickSorter.PivotStrategy.RANDOM_ELEMENT));
        System.out.println("Median of 3 Random Elements: " + QuickSorter.timedQuickSort(QuickSorter.generateRandomList(size), QuickSorter.PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS));
        System.out.println("Median of 3 Elements: " + QuickSorter.timedQuickSort(QuickSorter.generateRandomList(size), QuickSorter.PivotStrategy.MEDIAN_OF_THREE_ELEMENTS));
    }
}
