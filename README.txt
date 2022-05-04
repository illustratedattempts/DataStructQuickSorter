Name: Thanh Vo
NetID: ttv170230
Files submitting: README.txt, QuickSorter.java, main.java
File structure:
*ttv170230.zip
    *README.txt
    *QuickSorter.java
    *main.java

IDE: IntelliJ
Java Version: Java 17

Notes about the program: 
* Each run will generate 3 new files that will match the names of the arguments in the execution command. In the case where the files of identical naming structure already exists, the program will overwrite it.
* The QuickSorter's static timedQuickSort function takes in an ArrayList that will be converted to an array for less complicated element swapping due to the size of the array itself known to not change at all throughout the program's execution.
* Therefore, there are functions within main that exist such as convertToArray and convertToList that facilitate the continuous switching between the two data structures.
* [[IMPORTANT]] There may be some alarm that different pivot strategies method calls take in the same array. Note that the array itself remains in its unsorted state due to the timedQuickSort function manipulates only it's self contained array copied from the arraylist.
* Due to the previously mentioned timedQuickSort's inner workings, getting the sorted array is difficult. Therefore, there exists a static int[] field that is meant to be publically accessed for the main class' use.
* Within main, there are a couple instances where there are conversions from arraylist to array and vice versa. These appear for 10% UNSORTED -> SORTED (accessing array, swapping 10% elements, converting it back into an arraylist), and for easy access of the toString for writing it into the files (writing unsorted array to file, writing sorted array to file).

Summary of findings (Analysis):
It seems that in all cases the median of three elements is always an order of magnitude less than the other three methods. Thus, the median of three elements from the partitioning strategy is said to be the fastest. Why was it one of the fastest? It's probably that in the determination of the median pivot element, there is already a one less comparison needed to be done within the partitioning method itself because we are already swapping the first, last, and middle element into their proper places already.

The times follow the pattern: UNSORTED > 10% UNSORTED > ALREADY SORTED. Which is to be expected.

As to which pivot strategy works better for the three different instances, it seems that median of three dominates regardless.

Reports of various array sizes below (10, 1000, 100,000, 1,000,000, and 10,000,000):
UNSORTED -> SORTED
Array Size = 10
FIRST_ELEMENT : PT0.01252869S
RANDOM_ELEMENT : PT0.000020747S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.000023666S
MEDIAN_OF_THREE_ELEMENTS : PT0.000007601S

10% UNSORTED -> SORTED
Array Size = 10
FIRST_ELEMENT : PT0.000004269S
RANDOM_ELEMENT : PT0.000016675S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.000021001S
MEDIAN_OF_THREE_ELEMENTS : PT0.000006434S

SORTED -> SORTED
Array Size = 10
FIRST_ELEMENT : PT0.00000422S
RANDOM_ELEMENT : PT0.000017136S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.000029101S
MEDIAN_OF_THREE_ELEMENTS : PT0.000004564S


UNSORTED -> SORTED
Array Size = 1000
FIRST_ELEMENT : PT0.001307343S
RANDOM_ELEMENT : PT0.001058533S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.001245949S
MEDIAN_OF_THREE_ELEMENTS : PT0.000195363S

10% UNSORTED -> SORTED
Array Size = 1000
FIRST_ELEMENT : PT0.000246804S
RANDOM_ELEMENT : PT0.000958338S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.001250091S
MEDIAN_OF_THREE_ELEMENTS : PT0.000149624S

SORTED -> SORTED
Array Size = 1000
FIRST_ELEMENT : PT0.000251914S
RANDOM_ELEMENT : PT0.000922715S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.001180778S
MEDIAN_OF_THREE_ELEMENTS : PT0.000149283S



UNSORTED -> SORTED
Array Size = 100000
FIRST_ELEMENT : PT0.024090335S
RANDOM_ELEMENT : PT0.033971255S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.031496026S
MEDIAN_OF_THREE_ELEMENTS : PT0.011456475S

10% UNSORTED -> SORTED
Array Size = 100000
FIRST_ELEMENT : PT0.011204452S
RANDOM_ELEMENT : PT0.015415744S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.012887533S
MEDIAN_OF_THREE_ELEMENTS : PT0.007658176S

SORTED -> SORTED
Array Size = 100000
FIRST_ELEMENT : PT0.012640055S
RANDOM_ELEMENT : PT0.01008927S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.013144825S
MEDIAN_OF_THREE_ELEMENTS : PT0.006909748S



UNSORTED -> SORTED
Array Size = 1000000
FIRST_ELEMENT : PT0.167161881S
RANDOM_ELEMENT : PT0.211117801S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.296264387S
MEDIAN_OF_THREE_ELEMENTS : PT0.139831465S

10% UNSORTED -> SORTED
Array Size = 1000000
FIRST_ELEMENT : PT0.128640075S
RANDOM_ELEMENT : PT0.116178569S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.141815165S
MEDIAN_OF_THREE_ELEMENTS : PT0.063826255S

SORTED -> SORTED
Array Size = 1000000
FIRST_ELEMENT : PT0.114800037S
RANDOM_ELEMENT : PT0.108436776S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.135348951S
MEDIAN_OF_THREE_ELEMENTS : PT0.066422651S



UNSORTED -> SORTED
Array Size = 10000000
FIRST_ELEMENT : PT1.214986096S
RANDOM_ELEMENT : PT1.609272S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT1.854525689S
MEDIAN_OF_THREE_ELEMENTS : PT1.181307422S

10% UNSORTED -> SORTED
Array Size = 10000000
FIRST_ELEMENT : PT1.204243854S
RANDOM_ELEMENT : PT2.122069054S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT1.324333843S
MEDIAN_OF_THREE_ELEMENTS : PT0.702355386S

SORTED -> SORTED
Array Size = 10000000
FIRST_ELEMENT : PT1.201836715S
RANDOM_ELEMENT : PT1.090543616S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT1.418158826S
MEDIAN_OF_THREE_ELEMENTS : PT0.704581662S



