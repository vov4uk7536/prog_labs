import java.util.HashMap;
import java.util.Scanner;
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
    Scanner input = new Scanner(System.in);
    String command = "";

    while (!command.equals("exit")) {

      switch(command) {
        case "help":{
          System.out.println(" help : вывести справку по доступным командам \n info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.) \n show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении \n insert key {element} : добавить новый элемент с заданным ключом \n update id {element} : обновить значение элемента коллекции, id которого равен заданному \n remove_key key : удалить элемент из коллекции по его ключу \n clear : очистить коллекцию \n save : сохранить коллекцию в файл \n execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме. \n exit : завершить программу (без сохранения в файл) \n remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный \n replace_if_greater key {element} : заменить значение по ключу, если новое значение больше старого \n remove_lower_key key : удалить из коллекции все элементы, ключ которых меньше, чем заданный \n remove_all_by_difficulty difficulty : удалить из коллекции все элементы, значение поля difficulty которого эквивалентно заданному \n min_by_coordinates : вывести любой объект из коллекции, значение поля coordinates которого является минимальным \n print_field_ascending_author author : вывести значения поля author в порядке возрастания");
          break;
        }

        case "info":{

          break;
        }

        case "clear":{

          break;
        }

        case "save":{

          break;
        }

        case "":{

          break;
        }

        default:{
          System.out.println("unknown command");
        }

      }
      command = input.nextLine();
    }
  }
}
