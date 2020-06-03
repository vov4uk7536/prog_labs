
import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import com.google.gson.*;
import com.google.gson.stream.*;
import java.time.LocalDate;
import java.io.FileOutputStream;
import java.util.stream.Collectors;

public class main {
  static Scanner input = new Scanner(System.in);
  static HashMap<Long, LabWork> collection = new HashMap<Long, LabWork>();
  static String command = "";
  static java.time.LocalDate Date_of_initialization = LocalDate.now();
  static Long key;
  static Long id;
  static String difficulty = null;
  static String element = "";
  static Gson gson = new Gson();
  static String file_name;
  static String file = "";
  static String str = null;
  static String author_str = null;
  static String file_name_for_script = null;

  public static void main(String[] args) throws IOException
  {
    file_name = args[0];

    JsonReader file_reader = new JsonReader(new BufferedReader(new FileReader(file_name)));
    JsonParser jsonParser = new JsonParser();
    JsonArray labs = jsonParser.parse(file_reader).getAsJsonArray();

    for (JsonElement aLaba : labs) {
      LabWork laba = gson.fromJson(aLaba, LabWork.class);
      collection.put(laba.getId(),laba);
    }

    while (true) {
      command = input.next();
      command(command);
    }
  }

  public static void command (String command) throws IOException {
    String start_of_saving = "[ ";
    String end_of_saving = "]";
    String comma = ", ";
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
          for(Entry<Long, LabWork> entry : collection.entrySet())
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
          for (Entry<Long, LabWork> entry : collection.entrySet()) {

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
        if(file_name.equals(file_name_for_script))
          System.out.println("В файле присутствует рекурсия выполнение сего файла");
        else
        {
          file_name_for_script = file_name;
          FileReader fr = new FileReader(file_name);
          BufferedReader reader = new BufferedReader(fr);
          String line = reader.readLine();

          while (line != null)
          {
            InputStream Input_for_System_in = new ByteArrayInputStream(line.getBytes("UTF-8"));
            System.setIn(Input_for_System_in);
            input = new Scanner(System.in);
            command(input.next());
            System.setIn(System.in);
            line = reader.readLine();
          }
        }
        file_name_for_script = null;
        break; //execute_script file_name   считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
      }

      case "remove_lower":{
        element = input.nextLine();
        try {
          LabWork labWork = gson.fromJson(element, LabWork.class);
          HashMap<Long, LabWork> acollection = (HashMap<Long, LabWork>) collection.clone();
          for(Entry<Long, LabWork> entry : acollection.entrySet())
          {
            if (labWork.compareTo(entry.getValue()) > 0)
            {
              collection.remove(entry.getKey());
            }
          }
        }
        catch (JsonSyntaxException e)
        {
          System.out.println("Неправильно введён элемент");
          input.nextLine();
        }
        break; //remove_lower {element}   удалить из коллекции все элементы, меньшие, чем заданный
      }

      case "replace_if_greater":{
        if (!collection.containsKey(key = input.nextLong())) {
          System.out.println("Элемента с таким key уже существует");
          input.nextLine();
        }
        else
        {
          element = input.nextLine();
          try {
            LabWork labWork = gson.fromJson(element, LabWork.class);
            if (labWork.compareTo(collection.get(key)) > 0)
            {
              collection.put(key,labWork);
            }
          }
          catch (JsonSyntaxException e)
          {
            System.out.println("Неправильно введён элемент");
            input.nextLine();
          }
        }
        element = "";
        break; //replace_if_greater key {element} заменить значение по ключу, если новое значение больше старого
      }

      case "remove_lower_key":{
        key = input.nextLong();
        HashMap<Long, LabWork> acollection = (HashMap<Long, LabWork>) collection.clone();
        for(Entry<Long, LabWork> entry : acollection.entrySet())
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
          for(Entry<Long, LabWork> entry : acollection.entrySet())
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
          for (Entry<Long, LabWork> entry : collection.entrySet()) {
            if (1>0) {
              min_coordinates = collection.get(entry.getKey()).getCoordinates();
            }
          }
        }
        break; //вывести любой объект из коллекции, значение поля coordinates которого является минимальным
      }

      case "print_field_ascending_author":{
        author_str = input.nextLine();
        Person author = new Person();
        try {
          author = gson.fromJson(author_str, Person.class);
          for(Entry<Long, LabWork> entry : collection.entrySet()) {
            if (collection.get(entry.getKey()).getAuthor() != null && collection.get(entry.getKey()).getAuthor().equals(author))
              System.out.println(collection.get(entry.getKey()));
          }
        }
        catch (JsonSyntaxException e)
        {
          System.out.println("Неправильно введён автор");
          input.nextLine();
        }

        break; //print_field_ascending_author author - вывести значения поля author в порядке возрастания
      }

      case "":{

        break;
      }

      case "exit":{
        System.exit(0);
        break;
      }

      default:{
        System.out.println("Неизвестная команда");
      }

    }
  }
}
