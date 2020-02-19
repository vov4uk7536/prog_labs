import java.util.HashMap;
import java.io.*;

public class main {
  public static void main(String args[]) throws IOException
  {
    String file_name = args[0];
    FileReader file = new FileReader(file_name); //file.read(a) - пример чтения из файла в масив a
    char [] a = new char[4];
    file.read(a);
    /*
    for(char c : a)
      System.out.print(c);   // Вывод символов один за другими
    */
    file.close();
  }
}
