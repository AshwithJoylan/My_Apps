package com.example.shreyas.benchmarkapp.utils;

import java.util.Arrays;

public class Calculator {

    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];

        for(int i=0;i<array.length;i++) {
            array[i] = i+1;
        }
        return array;
    }

    public static int[] generateSortedArrayDesc(int size) {
        int[] array = new int[size];

        for(int i=array.length-1;i>=0;i--) {
            array[i] = i+1;
        }
        return array;
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];

        for(int i=0;i<array.length;i++) {
            array[i] = (int) (Math.random()*1000);
        }
        return array;
    }

    public static long doSelectionSort(int[] array) {
        int n = array.length;
        int[] newArray = new int[n];
        newArray = Arrays.copyOf(array, n);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (newArray[j] < newArray[min_idx])
                    min_idx = j;
            int temp = array[min_idx];
            newArray[min_idx] = newArray[i];
            newArray[i] = temp;
        }
        return System.currentTimeMillis()-startTime;

    }

    public static long doBubbleSort(int[] array){
        int n = array.length;
        int[] newArray = new int[n];
        newArray = Arrays.copyOf(array, n);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (newArray[j] > newArray[j+1])
                {
                    int temp = newArray[j];
                    newArray[j] = newArray[j+1];
                    newArray[j+1] = temp;
                }
        return System.currentTimeMillis()-startTime;
    }

    public  static long doMurgeSort(int[] array, int l,int r){
        int n = array.length;
        int[] newArray = new int[n];
        newArray = Arrays.copyOf(array, n);
        long startTime = System.currentTimeMillis();
        if (l < r)
        {
            int m = l+(r-l)/2;
            doMurgeSort(newArray, l, m);
            doMurgeSort(newArray, m+1, r);

            merge(newArray, l, m, r);
        }
        return System.currentTimeMillis()-startTime;
    }

    public static void merge(int arr[], int l, int m, int r)
    {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 =  r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (j = 0; j < n2; j++)
            R[j] = arr[m + 1+ j];
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public  static long doHeapSort(int[] array){
        int n = array.length;
        int[] newArray = new int[n];
        newArray = Arrays.copyOf(array, n);
        long startTime = System.currentTimeMillis();
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(newArray, n, i);
        for (int i=n-1; i>=0; i--)
        {
            int temp = newArray[0];
            newArray[0] = newArray[i];
            newArray[i] = temp;
            heapify(newArray, i, 0);
        }
        return System.currentTimeMillis()-startTime;
    }

    public static void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    public  static long doInsertionSort(int[] array){
        int n = array.length;
        int[] newArray = new int[n];
        newArray = Arrays.copyOf(array, n);
        long startTime = System.currentTimeMillis();
        for (int i=1; i<n; ++i) {
            int key = newArray[i];
            int j = i - 1;
            while (j >= 0 && newArray[j] > key) {
                newArray[j + 1] = newArray[j];
                j = j - 1;
            }
            newArray[j + 1] = key;
        }
        return System.currentTimeMillis()-startTime;
    }
}
