import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ArtCoder on 2017. 6. 12..
 */
public class QuickSort
{
  public static void main(String[] args)
  {
    int[] array = new int[]{6,5,5,5,2,1,3,4};
    quickSort(array, 0, array.length - 1);

    for(int i = 0; i < array.length; i++)
      System.out.print(array[i]);
  }

  public static void quickSort(int[] array, int left, int right)
  {
    int i, j, pivot, temp;
    System.out.println("call!");

    if(left < right)
    {
      i = left;
      j = right;
      pivot = array[left];

      // 피벗을 중심으로 좌, 우 분할
      while(i < j)
      {
        while(array[j] > pivot) j--;
        while(array[i] <= pivot && i < j) i++;

        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }

      // 재귀 호출로 정렬
      array[left] = array[i];
      array[i] = pivot;
      quickSort(array, left, i - 1);
      quickSort(array, i + 1, right);
    }
  }
}
