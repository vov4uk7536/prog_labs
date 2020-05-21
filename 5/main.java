/*ШО НАДО СДЕЛАТЬ!!!!!!!!!!!!!!!!
1)чтение и добавление нескольких лаб в коллекцию СДЕЛЯЛь
2)сортировка коллекции
3)запись в файл через java.io.FileOutputStream, а не через FileWriter
4)задокумментировать все классы в javadoc
5) Программа должна корректно работать с неправильными данными (ошибки пользовательского ввода, отсутсвие прав доступа к файлу и т.п.).
//insert 3 {"id"=1, "name"='Egorka', "coordinates":{"x"=1.0, "y"=1}, "creationDate"=null, "minimalPoint"=6.0, "difficulty"=null, "author":{"name"='Egorka', "height"=6, "weight"=5, "passportID"='4'}}
*/
import java.util.*;
import java.util.Map.Entry;
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
    String start_of_saving = "[ ";
    String end_of_saving = "]";
    String comma = ", ";

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

    for(Map.Entry<Long, LabWork> entry : collection.entrySet())
      System.out.println(entry.getKey() + ":  " + entry.getValue());

    /*Map<Long, LabWork> map = new TreeMap<Long, LabWork>(collection);
    Set set = map.entrySet();
    Iterator iterator = set.iterator();
    collection.clear();
    while(iterator.hasNext()) {
      Map.Entry me = (Map.Entry)iterator.next();
      System.out.print(me.getKey() + ": ");
      System.out.println(me.getValue());
    }*/
    //TreeMap<Long, LabWork> sorted = new TreeMap<>(collection);
    //Set<Entry<Long, LabWork>> mappings = sorted.entrySet();


    for(Map.Entry<Long, LabWork> entry : collection.entrySet())
      System.out.println(entry.getKey() + ":  " + entry.getValue());

    while (!command.equals("exit")) {

      switch(command) {
        case "help":{
          System.out.println(" help : справка по доступным командам \n info : информация о коллекции \n show : вывод всех элементов коллекции \n insert key {element} : добавить новый элемент с заданным ключом \n update id {element} : обновить значение элемента коллекции по id \n remove_key key : удалить элемент из коллекции по ключу \n clear : очистить коллекцию \n save : сохранить коллекцию в файл \n execute_script file_name : считать и исполнить скрипт из указанного файла \n exit : завершить программу (без сохранения в файл) \n remove_lower {element} : удаление из коллекции всех элементов, меньших, чем заданный \n replace_if_greater key {element} : замена значения по ключу, если новое значение больше старого \n remove_lower_key key : удаление из коллекции всех элементов, ключ которых меньше, чем заданный \n remove_all_by_difficulty difficulty : удаление из коллекции всех элементов, значение поля difficulty которого эквивалентно заданному \n min_by_coordinates : вывод любого объектв из коллекции, значение поля coordinates которого является минимальным \n print_field_ascending_author author : вывод значения поля author в порядке возрастания");
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
              System.out.println("Был добавлен элемент с key = " + key);
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
              System.out.println("Был обновлён элеммент с id = " + key);
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
          else {
            collection.remove(key);
            System.out.println("Был удалён элемент с key = " + key);
          }
          break; //remove_key key   удалить элемент из коллекции по его ключу
        }

        case "clear":{
          collection.clear();
          System.out.println("Коллекция была успешно отчищена");
          break; //очистить коллекцию
        }

        case "save":{
          FileOutputStream writer = new FileOutputStream(file_name);
          writer.write(start_of_saving.getBytes());
          int i = 1;
          if (collection.size() == 0)
            System.out.println("Была записана пустая коллекция");
          else {
            for (Map.Entry<Long, LabWork> entry : collection.entrySet()) {

              writer.write(gson.toJson(entry.getValue()).getBytes());
              if (i != collection.size()) {
                writer.write(comma.getBytes());
                i++;
              }
            }
            System.out.println("Было записано " + i + " эллемента(ов) коллекции");
          }
          writer.write(end_of_saving.getBytes());
          writer.close();
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
          if (collection.size() == 0)
            System.out.println("Коллекция пуста");
          else
          {
            Coordinates min_coordinates = new Coordinates();
            for (Map.Entry<Long, LabWork> entry : collection.entrySet()) {
              if (1>0) {
                min_coordinates = collection.get(entry.getKey()).getCoordinates();
              }
            }
          }
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
