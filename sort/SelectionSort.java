public class SelectionSort
{
  public static void main(String[] args)
  {
    // 정렬할 배열 선언
    //int[] array = new int[]{5,4,3,2,1};
    int[] array = new int[]{221, 1,2,32,521,112,43,24,24,52,111,23,43,13,123,122,452,56};

    for(int i =  0; i < array.length; i++)
    {
      int minIndex = i;

      for(int j = i+1; j < array.length; j++)
      {
        if(array[minIndex] > array[j])
          minIndex = j;
      }

      // i와 minIndex가 같을때 IF문 생략
      int temp = array[i];
      array[i] = array[minIndex];
      array[minIndex] = temp;
    }

    // 정렬 결과 출력
    for(int i = 0; i < array.length; i++)
    {
      System.out.println(array[i]);
    }
  }
}