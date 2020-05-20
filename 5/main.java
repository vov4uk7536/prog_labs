/*ШО НАДО СДЕЛАТЬ!!!!!!!!!!!!!!!!
1)чтение и добавление нескольких лаб в коллекцию СДЕЛЯЛь
2)сортировка коллекции
3)запись в файл через java.io.FileOutputStream, а не через FileWriter
4)задокумментировать все классы в javadoc
5) Программа должна корректно работать с неправильными данными (ошибки пользовательского ввода, отсутсвие прав доступа к файлу и т.п.).
//insert 3 {"id"=1, "name"='Egorka', "coordinates":{"x"=1.0, "y"=1}, "creationDate"=null, "minimalPoint"=6.0, "difficulty"=null, "author":{"name"='Egorka', "height"=6, "weight"=5, "passportID"='4'}}
*/
import java.util.*;
import java.io.*;
import com.google.gson.*;
import com.google.gson.stream.*;
import java.time.LocalDate;

public class main {
  public static void main(String[] args) throws IOException
  {
    Long key;
    Long id;
    String difficulty = null;
    String author = null;
    String element = "";
    String file_name = args[0];
    String file = "";
    String command = "";
    String str = null;

    java.time.LocalDate Date_of_initialization = LocalDate.now();

    Scanner input = new Scanner(System.in);
    HashMap<Long, LabWork> collection = new HashMap<Long, LabWork>();
    Gson gson = new Gson();
    JsonReader reader = new JsonReader(new BufferedReader(new FileReader(file_name)));
    JsonParser jsonParser = new JsonParser();
    JsonArray labs = jsonParser.parse(reader).getAsJsonArray();

    for (JsonElement aLaba : labs){
      LabWork laba = gson.fromJson(aLaba, LabWork.class);
      collection.put(laba.getId(),laba);
    }

    //FileWriter writer = new FileWriter(file_name); //writer.write(json); - запись
    // writer.write(gson.toJson(labs[0]));
    // writer.close();


    while (!command.equals("exit")) {

      switch(command) {
        case "help":{
          System.out.println(" help : вывести справку по доступным командам \n info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.) \n show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении \n insert key {element} : добавить новый элемент с заданным ключом \n update id {element} : обновить значение элемента коллекции, id которого равен заданному \n remove_key key : удалить элемент из коллекции по его ключу \n clear : очистить коллекцию \n save : сохранить коллекцию в файл \n execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме. \n exit : завершить программу (без сохранения в файл) \n remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный \n replace_if_greater key {element} : заменить значение по ключу, если новое значение больше старого \n remove_lower_key key : удалить из коллекции все элементы, ключ которых меньше, чем заданный \n remove_all_by_difficulty difficulty : удалить из коллекции все элементы, значение поля difficulty которого эквивалентно заданному \n min_by_coordinates : вывести любой объект из коллекции, значение поля coordinates которого является минимальным \n print_field_ascending_author author : вывести значения поля author в порядке возрастания");
          break; //вывести справку по доступным командам
        }

        case "info":{
          System.out.println("Тип коллекции: HashMap" + "\n" + "Дата инициализации:" + Date_of_initialization + "\n" + "Колличество элементов коллекции: " + collection.size());
          break; //вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
        }

        case "show":{
          if(collection.isEmpty())
            System.out.println("Коллекция пуста");
          else
            for(Map.Entry<Long, LabWork> entry : collection.entrySet())
              System.out.println(entry.getValue());
          break; //вывести в стандартный поток вывода все элементы коллекции в строковом представлении
        }

        case "insert":{
          if (collection.containsKey(key = input.nextLong())) {
            System.out.println("Элемент с таким key уже существует");
            input.nextLine();
          }
          else
          {
            element = input.nextLine();
            try {
              collection.put(key, gson.fromJson(element, LabWork.class));
              collection.get(key).setId(key);
            }
            catch (JsonSyntaxException e)
            {
              System.out.println("Неправильно введён элемент");
              input.nextLine();
            }
          }
          element = "";
          break; //insert key {element}   добавить новый элемент с заданным ключом
        }

        case "update":{
          if (!collection.containsKey(key = input.nextLong()))
          {
            System.out.println("Элемента с таким key не существует");
            input.nextLine();
          }
          else
          {
            element = input.nextLine();
            try {
              System.out.println(gson.fromJson(element, LabWork.class));
              collection.remove(key);
              collection.put(key, gson.fromJson(element, LabWork.class));
            }
            catch (JsonSyntaxException e)
            {
              System.out.println("Неправильно введён элемент");
              input.nextLine();
            }
          }
          element = "";
          break; //update id {element}   обновить значение элемента коллекции, id которого равен заданному
          // update 31024 {"id" = 31024, "name": null, "coordinates": null, "creationDate": null, "minimalPoint": 0, "difficulty": null, "author": null}
        }

        case "remove_key":{
          if (!collection.containsKey(key = input.nextLong()))
            System.out.println("Элемента с таким key не существует");
          else
            collection.remove(key);
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

        case "remove_lower":{
          element = input.next();

          break; //remove_lower {element}   удалить из коллекции все элементы, меньшие, чем заданный
        }

        case "replace_if_greater":{
          key = input.nextLong();

          break; //replace_if_greater key {element}   заменить значение по ключу, если новое значение больше старого
        }

        case "remove_lower_key":{
          key = input.nextLong();
          HashMap<Long, LabWork> acollection = (HashMap<Long, LabWork>) collection.clone();
          for(Map.Entry<Long, LabWork> entry : acollection.entrySet())
            if(entry.getKey() < key)
              collection.remove(entry.getKey());
          acollection.clear();
          break; //remove_lower_key key   удалить из коллекции все элементы, ключ которых меньше, чем заданный
        }

        case "remove_all_by_difficulty":{
          difficulty = input.next();
          try
          {
            HashMap<Long, LabWork> acollection = (HashMap<Long, LabWork>) collection.clone();
            for(Map.Entry<Long, LabWork> entry : acollection.entrySet())
              if(entry.getValue().getDifficulty() == Difficulty.valueOf(difficulty))
                collection.remove(entry.getKey());
            acollection.clear();
          }
          catch (IllegalArgumentException e)
          {
            System.out.println("Такой сложности не существует");
          }

          break; //remove_all_by_difficulty difficulty   удалить из коллекции все элементы, значение поля difficulty которого эквивалентно заданному
        }

        case "min_by_coordinates":{

          break; //вывести любой объект из коллекции, значение поля coordinates которого является минимальным
        }

        case "print_field_ascending_author":{
          author = input.next();

          break; //print_field_ascending_author author - вывести значения поля author в порядке возрастания
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
