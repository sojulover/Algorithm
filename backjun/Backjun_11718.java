import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjun_11718
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    /**
     * 백준 알고리즘에서 종료 조건이 없을 경우 EOF(End of Files)가 사용된다.
     * EOF란 입출력에서 파일이나 문자열의 종료를 의미하는 값으로 C에서는 -1, 자바 등에서는 null이 된다
     *
     * Scanner는 편리하지만 띄어쓰기나 개행문자를 만나면 서로 다른 글자로 인식하기 때문에 이 문제를 해결하기엔 적합하지 않다.
     * - hasNextLine 함수를 통해 구현 가능.
     */

    while((line = in.readLine()) != null)
    {
      System.out.println(line);
    }
    in.close();
  }
}