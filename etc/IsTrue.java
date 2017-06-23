import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsTrue
{
  // 주어지는 문자열에 1이 있고, 1 다음 문자가 2인지 여부를 리턴하는 메소드
  // input: 1111112 <- X
  // input: 1221    <- X
  // input: 121212  <- O
  // input: 12      <- O

  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine().toCharArray();
    System.out.println(isTrue(str.toCharArray()));
    System.out.println(isTrue(str));
  }

  public static boolean isTrue(char[] str)
  {
    if(str[str.length - 1] == 1)
      return false;
    for(int i = 0; i < str.length - 1; i++)
    {
      if(str[i] == '1' && str[i + 1] != '2')
        return false;
    }

    return true;
  }

  public static boolean isTrue2(String str)
  {
    String[] arr = str.split("12");

    for(String a : arr)
    {
      if(a.contains("1"))
      {
        return false;
      }
    }

    return true;
  }
}