package org.example.quickSort;

import java.util.Comparator;

public class QuickSort {

    private static <E> void quickSort(Object[] arr, int i, int j, Comparator<? super E> c) {
        if (i >= j) {
            return;
        }

        int pivotIndex = partition(arr, i, j, c);
        quickSort(arr, i, pivotIndex - 1, c); // Сортируем левую часть
        quickSort(arr, pivotIndex + 1, j, c); // Сортируем правую часть
    }

    private static <E> int partition(Object[] arr, int i, int j, Comparator<? super E> c) {
        Object pivot = arr[i];
        int s1Index = i;
        int s2Index = i;

        for (int k = i + 1; k <= j; ++k) {
            if (c.compare((E) arr[k], (E) pivot) >= 0) {
                ++s2Index;
            } else {
                ++s1Index;
                swap(arr, s1Index, k);
                ++s2Index;
            }
        }

        swap(arr, i, s1Index);
        return s1Index;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <E> void sort(Object[] arr, Comparator<? super E> c) {
        if (arr.length > 0) {
            quickSort(arr, 0, arr.length - 1, c);
        }
    }

}
