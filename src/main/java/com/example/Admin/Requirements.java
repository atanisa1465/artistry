package com.example.Admin;

import java.util.ArrayList;

public class Requirements {

    private static int statementExecutionCount = 0;
    private static int searchInt = generateInt();
    private static int merges;
    private static int sorts;

    public static int generateInt() { return (int)(Math.random()*10); }
    public static int[] generateArr() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) { arr[i] = generateInt(); }
        return arr;
    }
        
    public static int sumDigits(int num) {
        if (num/10 == 0) { return num; }
        return (num%10 + sumDigits(num/10));
      }
      
      public static int sumDigitsIterative(int num) {
        int sum = 0; 
        for (int i = num; i%10 != 0; i/=10) { sum += i%10; }
        return sum;
      }
      
      //Traverse String
      public static int countOccurrence(String val, String find) {
        int count = 0;
        if (val.length() < 1) { return 0; }
        if (val.substring(0,1).toLowerCase().equals(find)) { count++; }
        return count + countOccurrence(val.substring(1), find);
      }
      
      //Traverse Array
      public static int findNumEven(int[] num) {
        int count = 0;
        if (num.length == 1) { return 0; }
        if (num.length < 1) { return 0; }
        if (num[0] % 2 == 0) { count++; }
        int[] next = new int[num.length - 1];
        for (int i = 0; i < next.length; i++) { next[i] = num[i+1]; }
        return count + findNumEven(next);
      }
      
      //Traverse ArrayList
      public static int findNumFactors(ArrayList<Integer> toCheck, int num) {
        int count = 0;
        if (toCheck.size() < 1) { return 0; }
        if (num % toCheck.remove(0) == 0) { count++; }
        return count + findNumFactors(toCheck, num);
      }

      public static int binarySearch(int[] arr, int left, int right) {
        statementExecutionCount++;
        if (right >= left) {
          int mid = (left + right) / 2;
          if (arr[mid] == searchInt) { return mid; }
          else if (arr[mid] > searchInt) { return binarySearch(arr, left, mid - 1); }
          else { return binarySearch(arr, mid + 1, right); }
        }
        return -1;
      }
      public static int binarySearch(ArrayList<Integer> arr, int left, int right) {
        statementExecutionCount++;
        if (right >= left) {
          int mid = (left + right) / 2;
          if (arr.get(mid) == searchInt) { return mid; }
          else if (arr.get(mid) > searchInt) { return binarySearch(arr, left, mid - 1); }
          else { return binarySearch(arr, mid + 1, right); }
        }
        return -1;
      }
    
      public static int binarySearchIterative(int[] arr, int left, int right) {
        while (right >= left) {
          statementExecutionCount++;
                int mid = (left + right) / 2;
                if (arr[mid] == searchInt) { return mid; }
                else if (arr[mid] > searchInt) { right = mid - 1; }
                else { left = mid + 1; }
            } 
        statementExecutionCount++;
        return -1;
      }
      public static int binarySearchIterative(ArrayList<Integer> arr, int left, int right) {
        statementExecutionCount++;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr.get(mid) == searchInt) { return mid; }
                else if (arr.get(mid) > searchInt) { right = mid - 1; }
                else { left = mid + 1; }
          statementExecutionCount++;
            } return -1;
      }

      public Requirements() {
        int[] arr = {1,2,4,5,6,7,8};
        int[] arrTwo = {1,3,5,7,9};
        System.out.println("\nNumber of Even Values in arr: " + findNumEven(arr));
        System.out.println("Number of Even Values in arrTwo: " + findNumEven(arrTwo));
    
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int n : arr) { list.add(n); }
        ArrayList<Integer> listTwo = new ArrayList<Integer>();
        for (int n : arrTwo) { listTwo.add(n); }
        System.out.println("\nNumber of Factors of 48 in list: " + findNumFactors(list, 48));
        System.out.println("Number of Factors of 48 in listTwo: " + findNumFactors(listTwo, 48));

        int[] search = generateArr();
        System.out.println("Random Array: ");
        sort(search, 0, 999);

      }

      public static void merge(int arr[], int l, int m, int r) {
        merges++;
        int n1 = m - l + 1;
        int n2 = r - m;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for (int i = 0; i < n1; i++) { left[i] = arr[l + i]; }
        for (int j = 0; j < n2; ++j) { right[j] = arr[m + 1 + j]; }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
          if (left[i] <= right[j]) {
            arr[k] = left[i];
            i++;
          } else {
            arr[k] = right[j];
            j++;
          } k++;
        }
        while (i < n1) {
          arr[k] = left[i];
          i++;
          k++;
        }
        while (j < n2) {
          arr[k] = right[j];
          j++;
          k++;
        }
      }
      
      public static void sort(int arr[], int l, int r) {
        sorts++;
        if (l < r) {
          int m =(l + r)/2;
          sort(arr, l, m);
          sort(arr, m + 1, r);
          merge(arr, l, m, r);
        }
      }

}
