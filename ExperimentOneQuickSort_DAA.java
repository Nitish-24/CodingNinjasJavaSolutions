import java.util.Scanner;

public class ExperimentOneQuickSort_DAA {

  public static void quickSort(int ary[], int low, int high) {
    if (low < high) {
      int pivort = partition(ary, low, high);

      quickSort(ary, low, pivort - 1);
      quickSort(ary, pivort + 1, high);
    }
  }

  private static int partition(int[] ary, int low, int high) {
    int pivot = ary[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (ary[j] < pivot) {
        i++;
        int temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
      }
    }
    i++;
    int temp = ary[i];
    ary[i] = ary[high];
    ary[high] = temp;
    return i;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    System.out.println("Enter Size: ");
    int size = scn.nextInt();
    int ary[] = new int[size];
    System.out.println("Enter the data in array: ");
    for (int i = 0; i < ary.length; i++) {
      ary[i] = scn.nextInt();
    }
    int low = 0;
    int high = ary.length - 1;
    quickSort(ary, low, high);

    for (int i : ary) {
      System.out.print(i + " ");
    }

    scn.close();
  }
}
