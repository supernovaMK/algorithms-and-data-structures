package algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeSort {

    static int[] copy;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        copy = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        mergeSort(arr, 0, arr.length - 1);

        StringBuilder stringBuilder = new StringBuilder();
        for (var a : arr) {
            stringBuilder.append(a).append(" ");
        }
        System.out.println(stringBuilder);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int idx = left;
        int l = left;
        int r = mid + 1;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                copy[idx] = arr[l];
                idx++;
                l++;
            } else {
                copy[idx] = arr[r];
                idx++;
                r++;
            }
        }
        if (l > mid) {
            while (r <= right) {
                copy[idx] = arr[r];
                idx++;
                r++;
            }
        } else {
            while (l <= mid) {
                copy[idx] = arr[l];
                idx++;
                l++;
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = copy[i];
        }
    }
}
