import java.util.Vector;

public class SectionSum
{
  final static int MIN = 0;

  /**
   * 벡터를 순회하여 연속구간의 합이 가장 큰 경우(값)를 구하는 4개의 알고리즘으로 각각 시간 복잡도의 차이가 있다.
   */
  public static void main(String[] args)
  {
    Vector<Integer> vectorArray = new Vector<>();
    for(int i = 0; i < 1500; i++)
    {
      int number = (int) Math.round(Math.random() * 10);
      number = Math.round(Math.random() * 1) == 1 ? number * -1 : number;
      vectorArray.add(number);
    }

    long t1 = System.currentTimeMillis();
    printResult(inefficientMaxSum(vectorArray), t1, System.currentTimeMillis());
    t1 = System.currentTimeMillis();
    printResult(betterMaxSum(vectorArray), t1, System.currentTimeMillis());
    t1 = System.currentTimeMillis();
    printResult(fastMaxSum(vectorArray, 0, vectorArray.size() - 1), t1, System.currentTimeMillis());
    t1 = System.currentTimeMillis();
    printResult(fastestMaxSum(vectorArray), t1, System.currentTimeMillis());
  }

  public static void printResult(int result, long t1, long t2)
  {
    System.out.println("결관   : " + result);
    System.out.println("걸린시간: " + (t2 - t1));
    System.out.println("-------------------------------------------");
  }

  public static int max(int a, int b)
  {
    return a > b ? a : b;
  }

  public static int inefficientMaxSum(Vector<Integer> array)
  {
    int length = array.size();
    int result = MIN;

    for(int i = 0; i < length; i++)
    {
      for(int j = i; j < length; j++)
      {
        int sum = MIN;
        for(int k = i; k <= j; k++)
        {
          sum += array.get(k);
        }

        result = max(result, sum);
      }
    }
    return result;
  }

  public static int betterMaxSum(Vector<Integer> array)
  {
    int length = array.size();
    int result = MIN;

    for(int i = 0; i < length; i++)
    {
      int sum = 0;
      for(int j = i; j < length; j++)
      {
        sum += array.get(j);
        result = max(result, sum);
      }
    }
    return result;
  }

  /**
   * 분할 정복 기법을 이용한 알고리즘
   * 1. 가장 큰 합이 중간 값을 포함하는 경우.
   * - 중간을 기준으로 왼쪽과 오른쪽, 양방향으로 덧셈을 진행하면서 각각 가장 큰 값을 구한 뒤 서로 더하여 총 합계를 얻음.
   *
   * 2. 가장 큰 합이 중간 값을 포함하지 않고 왼쪽이나 오른쪽에 존재할 경우
   *
   * 3. 1과 2 중 큰 값을 리턴
   */
  public static int fastMaxSum(Vector<Integer> array, int lo, int hi)
  {
    if(lo == hi)
      return array.get(lo);

    int mid = (lo + hi) / 2;
    int left = MIN, right = MIN, sum = 0;

    for(int i = mid; i >= lo; i--)
    {
      sum += array.get(i);
      left = max(left, sum);
    }
    sum = 0;
    for(int j = mid + 1; j <= hi; j++)
    {
      sum += array.get(j);
      right = max(right, sum);
    }

    int single = max(fastMaxSum(array, lo, mid), fastMaxSum(array, mid+1, hi));
    return max(left + right, single);
  }

  public static int fastestMaxSum(Vector<Integer> array)
  {
    int length = array.size();
    int result = MIN, psum = 0;

    for(int i = 0; i < length; i++)
    {
      psum = max(psum, 0) + array.get(i);
      result = max(psum, result);
    }

    return result;
  }
}