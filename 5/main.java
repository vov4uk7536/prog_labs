import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class main {
  public static void main(String args[]) throws IOException
  {
    String file_name = args[0];

    Scanner input = new Scanner(System.in);
    FileReader file = new FileReader(file_name); //file.read(a) - пример чтения из файла в масив a

    char [] a = new char[4];
    String command = "";

    file.read(a);
    /*
    for(char c : a)
      System.out.print(c);   // Вывод символов один за другими
    */
    file.close();


    while (!command.equals("exit")) {

      switch(command) {
        case "help":{
          System.out.println(" help : вывести справку по доступным командам \n info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.) \n show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении \n insert key {element} : добавить новый элемент с заданным ключом \n update id {element} : обновить значение элемента коллекции, id которого равен заданному \n remove_key key : удалить элемент из коллекции по его ключу \n clear : очистить коллекцию \n save : сохранить коллекцию в файл \n execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме. \n exit : завершить программу (без сохранения в файл) \n remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный \n replace_if_greater key {element} : заменить значение по ключу, если новое значение больше старого \n remove_lower_key key : удалить из коллекции все элементы, ключ которых меньше, чем заданный \n remove_all_by_difficulty difficulty : удалить из коллекции все элементы, значение поля difficulty которого эквивалентно заданному \n min_by_coordinates : вывести любой объект из коллекции, значение поля coordinates которого является минимальным \n print_field_ascending_author author : вывести значения поля author в порядке возрастания");
          break; //вывести справку по доступным командам
        }

        case "info":{

          break; // вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
        }

        case "show":{

          break; //вывести в стандартный поток вывода все элементы коллекции в строковом представлении
        }

        case "insert":{

          break; //insert key {element}   добавить новый элемент с заданным ключом
        }

        case "update":{

          break; //update id {element}   обновить значение элемента коллекции, id которого равен заданному
        }

        case "remove_key":{

          break; //remove_key key   удалить элемент из коллекции по его ключу
        }

        case "clear":{

          break; //очистить коллекцию
        }

        case "save":{

          break; //сохранить коллекцию в файл
        }

        case "execute_script":{

          break; //execute_script file_name   считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
        }

        case "exit":{

          break; //завершить программу (без сохранения в файл)
        }

        case "remove_lower":{

          break; //remove_lower {element}   удалить из коллекции все элементы, меньшие, чем заданный
        }

        case "replace_if_greater":{

          break; //replace_if_greater key {element}   заменить значение по ключу, если новое значение больше старого
        }

        case "remove_lower_key":{

          break; //удалить из коллекции все элементы, ключ которых меньше, чем заданный
        }

        case "remove_all_by_difficulty":{

          break; //remove_all_by_difficulty difficulty   удалить из коллекции все элементы, значение поля difficulty которого эквивалентно заданному
        }

        case "min_by_coordinates":{

          break; //вывести любой объект из коллекции, значение поля coordinates которого является минимальным
        }

        case "print_field_ascending_author":{

          break; //print_field_ascending_author author   вывести значения поля author в порядке возрастания
        }

        case "":{

          break;
        }

        default:{
          System.out.println("unknown command");
        }

      }
      command = input.next();
    }
    input.close();
  }
}
