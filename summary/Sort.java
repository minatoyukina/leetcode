package leetcode.summary;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ccq
 * @since 2021/5/25 15:23
 */
public class Sort {

    @Test
    public void test() {
        System.out.println(Arrays.toString(bubbleSort(new int[]{4, 1, 3, 5, 2, 7, 6})));
        System.out.println(Arrays.toString(selectSort(new int[]{4, 1, 3, 5, 2, 7, 6})));
        System.out.println(Arrays.toString(insertSort(new int[]{4, 1, 3, 5, 2, 7, 6})));
        System.out.println(Arrays.toString(quickSort(new int[]{4, 1, 3, 5, 2, 7, 6})));
        System.out.println(Arrays.toString(mergeSort(new int[]{4, 1, 3, 5, 2, 7, 6})));
    }

    private int[] bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    private int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) index = j;
            }
            if (i != index) {
                int tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
            }
        }
        return arr;
    }

    private int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (i != j) arr[j] = tmp;
        }
        return arr;
    }

    private int[] quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void qSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivot = arr[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && arr[i] < pivot) i++;
            while (i < j && arr[j] > pivot) j--;
            if (i < j && arr[i] == arr[j]) i++;
            else {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        qSort(arr, start, i - 1);
        qSort(arr, j + 1, end);
    }

    private int[] mergeSort(int[] arr) {
        mSort(arr, new int[arr.length], 0, arr.length - 1);
        return arr;
    }

    @SuppressWarnings("all")
    private void mSort(int[] arr, int[] res, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        int start1 = start, start2 = mid + 1;
        mSort(arr, res, start1, mid);
        mSort(arr, res, start2, end);
        int k = start;
        while (start1 <= mid && start2 <= end) {
            if (arr[start1] < arr[start2]) res[k++] = arr[start1++];
            else res[k++] = arr[start2++];
        }
        while (start1 <= mid) res[k++] = arr[start1++];
        while (start2 <= end) res[k++] = arr[start2++];
        for (int i = start; i <= end; i++) arr[i] = res[i];
    }
}
