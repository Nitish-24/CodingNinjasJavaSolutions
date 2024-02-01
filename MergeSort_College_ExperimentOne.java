import java.util.Scanner;

public class MergeSort_College_ExperimentOne {

  public static void divideIntoSubParts(int arr[], int startingIndex, int endIndex) {
    if (startingIndex >= endIndex) {
      return;
    }
    int mid = startingIndex + (endIndex - startingIndex) / 2;
    divideIntoSubParts(arr, startingIndex, mid);
    divideIntoSubParts(arr, mid + 1, endIndex);
    mergeDivide(arr, startingIndex, mid, endIndex);
  }

  public static void mergeDivide(int arr[], int startingIndex, int mid, int endIndex) {
    int merged[] = new int[endIndex - startingIndex + 1];
    int index = startingIndex;
    int index2 = mid + 1;
    int x = 0;
    while (index <= mid && index2 <= endIndex) {
      if (arr[index] <= arr[index2]) {
        merged[x++] = arr[index++];
      } else {merged[x++] = arr[index2++];}
    }
      while (index <= mid) {
        merged[x++] = arr[index++];
      }
      while (index2 <= endIndex) {
        merged[x++] = arr[index2++];
      }
      for (int i = 0, j = startingIndex; i < merged.length; i++, j++) {
        arr[j] = merged[i];
      }
    }
  

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    System.out.println("Enter the size of array:");
    int n = scn.nextInt();
    int ary[] = new int[n];
    for (int i = 0; i < ary.length; i++) {
      ary[i] = scn.nextInt();
    }
    divideIntoSubParts(ary, 0, n - 1);
    for (int i : ary) {
        System.out.print(i+ " ");
    }
    scn.close();
  }
}
