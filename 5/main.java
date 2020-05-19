/*ШО НАДО СДЕЛАТЬ!!!!!!!!!!!!!!!!
1)чтение и добавление нескольких лаб в коллекцию СДЕЛЯЛь
2)сортировка коллекции
3)запись в файл через java.io.FileOutputStream, а не через FileWriter
4)задокумментировать все классы в javadoc
5) Программа должна корректно работать с неправильными данными (ошибки пользовательского ввода, отсутсвие прав доступа к файлу и т.п.).

*/
import java.util.*;
import java.io.*;
import com.google.gson.*;
import com.google.gson.stream.*;

public class main {
  public static void main(String[] args) throws IOException
  {
    int key;
    int id;
    int id_count = 0;
    String difficulty = null;
    String author = null;
    String element = null;
    String file_name = args[0];
    String file = "";
    String command = "";
    String str = null;
    char[] Char = new char[1];

    Scanner input = new Scanner(System.in);
    HashMap<Integer, LabWork> collection = new HashMap<Integer, LabWork>();
    Gson gson = new Gson();
    JsonReader reader = new JsonReader(new BufferedReader(new FileReader(file_name)));
    JsonParser jsonParser = new JsonParser();
    JsonArray labs = jsonParser.parse(reader).getAsJsonArray();

    for (JsonElement aLaba : labs){
      LabWork laba = gson.fromJson(aLaba, LabWork.class);
      collection.put(id_count,laba);
      collection.get(id_count).setId(id_count);
      id_count++;
    }

    //FileWriter writer = new FileWriter(file_name); //writer.write(json); - запись
   // writer.write(gson.toJson(labs[0]));
   // writer.close();

    System.out.println(collection.get(0));
    System.out.println(collection.get(1));

    while (!command.equals("exit")) {

      switch(command) {
        case "help":{
          System.out.println(" help : вывести справку по доступным командам \n info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.) \n show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении \n insert key {element} : добавить новый элемент с заданным ключом \n update id {element} : обновить значение элемента коллекции, id которого равен заданному \n remove_key key : удалить элемент из коллекции по его ключу \n clear : очистить коллекцию \n save : сохранить коллекцию в файл \n execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме. \n exit : завершить программу (без сохранения в файл) \n remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный \n replace_if_greater key {element} : заменить значение по ключу, если новое значение больше старого \n remove_lower_key key : удалить из коллекции все элементы, ключ которых меньше, чем заданный \n remove_all_by_difficulty difficulty : удалить из коллекции все элементы, значение поля difficulty которого эквивалентно заданному \n min_by_coordinates : вывести любой объект из коллекции, значение поля coordinates которого является минимальным \n print_field_ascending_author author : вывести значения поля author в порядке возрастания");
          break; //вывести справку по доступным командам
        }

        case "info":{

          break; //вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
        }

        case "show":{
          System.out.println(collection.get(0));
          break; //вывести в стандартный поток вывода все элементы коллекции в строковом представлении
        }

        case "insert":{
          key = input.nextInt();
          element = input.next();

          break; //insert key {element}   добавить новый элемент с заданным ключом
        }

        case "update":{
          id = input.nextInt();
          element = input.next();

          break; //update id {element}   обновить значение элемента коллекции, id которого равен заданному
        }

        case "remove_key":{
          key = input.nextInt();

          break; //remove_key key   удалить элемент из коллекции по его ключу
        }

        case "clear":{
          collection.clear();
          break; //очистить коллекцию
        }

        case "save":{

          break; //сохранить коллекцию в файл
        }

        case "execute_script":{
          file_name = input.next();

          break; //execute_script file_name   считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
        }

        /*case "exit":{

          break; //завершить программу (без сохранения в файл)
        }*/

        case "remove_lower":{
          element = input.next();

          break; //remove_lower {element}   удалить из коллекции все элементы, меньшие, чем заданный
        }

        case "replace_if_greater":{
          key = input.nextInt();

          break; //replace_if_greater key {element}   заменить значение по ключу, если новое значение больше старого
        }

        case "remove_lower_key":{
          key = input.nextInt();

          break; //remove_lower_key key   удалить из коллекции все элементы, ключ которых меньше, чем заданный
        }

        case "remove_all_by_difficulty":{
          difficulty = input.next();

          break; //remove_all_by_difficulty difficulty   удалить из коллекции все элементы, значение поля difficulty которого эквивалентно заданному
        }

        case "min_by_coordinates":{

          break; //вывести любой объект из коллекции, значение поля coordinates которого является минимальным
        }

        case "print_field_ascending_author":{
          author = input.next();

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
