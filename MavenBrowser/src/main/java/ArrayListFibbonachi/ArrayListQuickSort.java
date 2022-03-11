package ArrayListFibbonachi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListQuickSort {
    public static void QuickSort(List<Integer> list) {
        sort(list, 0, list.size() - 1);
    }

    public static void sort(List<Integer> list, int from, int to) {
        if (from < to) {
            int pivot = from;
            int left = from + 1;
            int right = to;
            int pivotValue = list.get(pivot);
            while (left <= right) {
                // left <= to -> limit protection
                while (left <= to && pivotValue >= list.get(left)) {
                    left++;
                }
                // right > from -> limit protection
                while (right > from && pivotValue < list.get(right)) {
                    right--;
                }
                if (left < right) {
                    Collections.swap(list, left, right);
                }
            }
            Collections.swap(list, pivot, left - 1);
            sort(list, from, right - 1); // <-- pivot was wrong!
            sort(list, right + 1, to);   // <-- pivot was wrong!
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList(Arrays.asList(3, 5, 1, 0));
        System.out.println(numbers);
        QuickSort(numbers);
        System.out.println(numbers);
    }
}
