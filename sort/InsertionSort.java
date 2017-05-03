public class InsertionSort
{
  public static void main(String[] args)
  {
    // 정렬할 배열 선언
    int[] array = new int[]{5,4,3,2,1};

    for(int i = 1; i < array.length; i++)
    {
      int currentValue = array[i];
      int j = i - 1;

      for(; j >= 0; j--)
      {
        if(currentValue < array[j])
          break;

        array[j+1] = array[j];
      }

      array[j+1] = currentValue;
    }

    // 정렬 결과 출력
    for(int i = 0; i < array.length; i ++)
    {
      System.out.println(array[i]);
    }
  }
}