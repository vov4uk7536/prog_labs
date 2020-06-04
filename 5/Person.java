import java.util.Objects;

public class Person {
    /** Имя человека */
    private String name; //Поле не может быть null, Строка не может быть пустой
    /** Высота человека */
    private Long height; //Поле не может быть null, Значение поля должно быть больше 0
    /** Вес человека */
    private Integer weight; //Поле не может быть null, Значение поля должно быть больше 0
    /** Номер паспорта человека */
    private String passportID; //Строка не может быть пустой, Поле не может быть null

    /** Создание элемента для файлa json */
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", passportID='" + passportID + '\'' +
                '}';
    }
    /** Функция получения имени
     * @return Значение имени
     * */
    public String getName() {
        return name;
    }
    /** Функция получения высоты
     * @return Значение высоты
     * */    public Long getHeight() {
        return height;
    }
    /** Функция получения веса
     * @return Значение веса
     * */    public Integer getWeight() {
        return weight;
    }
    /** Функция получения номера паспорта
     * @return Значение номера паспорта
     * */    public String getPassportID() {
        return passportID;
    }
    /** Функция задания имени
     * @param name Имя
     * */
    public void setName(String name) {
        this.name = name;
    }
    /** Функция задания высоты
     * @param height Высота
     * */    public void setHeight(long height) {
        this.height = height;
    }
    /** Функция задания веса
     * @param weight Вес
     * */    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    /** Функция задания номера паспорта
     * @param passportID Номер паспорта
     * */    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }
    /** Функция для сравнения элементов Person
     * @param person объект класса человек
     * */
    public int compareTo(Person person) {
        if (person != null) {
            if (person.name == null) {
                if (name != null)
                    return 1;
            } else if (name != null && name.compareTo(person.name) != 0)
                return name.compareTo(person.name);

            if (person.height == null) {
                if (height != null)
                    return 1;
            } else if (height != null && height.compareTo(person.height) != 0)
                return height.compareTo(person.height);

            if (person.weight == null) {
                if (weight != null)
                    return 1;
            } else if (weight != null && weight.compareTo(person.weight) != 0)
                return weight.compareTo(person.weight);

            if (person.passportID == null) {
                if (passportID != null)
                    return 1;
            } else if (passportID != null && passportID.compareTo(person.passportID) != 0)
                return passportID.compareTo(person.passportID);
        }
        else
            return 1;
        return 0;
    }
}
