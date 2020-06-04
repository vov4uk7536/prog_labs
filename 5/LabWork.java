import java.time.LocalDate;
import java.util.*;

public class LabWork implements Comparable<LabWork> {
    /** id объекта Labwork */
    private Long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    /** Имя объекта Labwork */
    private String name; //Поле не может быть null, Строка не может быть пустой
    /** Объект класса Coordinates */
    private Coordinates coordinates; //Поле не может быть null
    /** Время создания объекта */
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    /** Минимальная точка Labwork */
    private Float minimalPoint; //Поле может быть null, Значение поля должно быть больше 0
    /** Объект класса Difficulty */
    private Difficulty difficulty; //Поле не может быть null
    /** Объект класса Author */
    private Person author; //Поле может быть null

    /** Функция, придающая объекту Labwork вид для записи в gson
     * @return Объект Labwork
     * */
    public String toString() {
        return "LabWork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", minimalPoint=" + minimalPoint +
                ", difficulty=" + difficulty +
                ", author=" + author +
                '}';
    }
    /** Функция получения id Labwork
     * @return id Labwork
     * */
    public Long getId() {
        return id;
    }
    /** Функция получения имени Labwork
     * @return Имя Labwork
     * */
    public String getName() {
        return name;
    }
    /** Функция получения Coordinates Labwork
     * @return Coordinates Labwork
     * */
    public Coordinates getCoordinates() {
        return coordinates;
    }
    /** Функция получения Даты создания Labwork
     * @return Дата создания Labwork
     * */
    public LocalDate getCreationDate() {
        return creationDate;
    }
    /** Функция получения минимальной точки Labwork
     * @return Минимальная точка Labwork
     * */
    public Float getMinimalPoint() {
        return minimalPoint;
    }
    /** Функция получения Difficulty Labwork
     * @return Difficulty Labwork
     * */
    public Difficulty getDifficulty() {
        return difficulty;
    }
    /** Функция получения Author Labwork
     * @return Author Labwork
     * */
    public Person getAuthor() {
        return author;
    }
    /** Функция присваивания id Labwork
     * @param id id Labwork
     * */
    public void setId(long id) {
        this.id = id;
    }
    /** Функция присваивания имени Labwork
     * @param name Имя Labwork
     * */
    public void setName(String name) {
        this.name = name;
    }
    /** Функция присваивания Coordinates Labwork
     * @param coordinates Coordinates Labwork
     * */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    /** Функция присваивания даты создания Labwork
     * @param creationDate Дата создания Labwork
     * */
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    /** Функция присваивания минимальной точки Labwork
     * @param minimalPoint Минимальная точка Labwork
     * */
    public void setMinimalPoint(Float minimalPoint) {
        this.minimalPoint = minimalPoint;
    }
    /** Функция присваивания Difficulty Labwork
     * @param difficulty Difficulty Labwork
     * */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
    /** Функция присваивания Author Labwork
     * @param author Author Labwork
     * */
    public void setAuthor(Person author) {
        this.author = author;
    }

    /** Функция сравнивания Labwork */
    public int compareTo(LabWork labWork) {
        if (labWork.id == null) {
            if (id != null)
                return 1;
        }
        else
        if (id != null)
            return id.compareTo(labWork.id);

        if (labWork.name == null) {
            if (name != null)
                return 1;
        }
        else
        if (name != null && name.compareTo(labWork.name) != 0)
            return name.compareTo(labWork.name);

        if (labWork.coordinates == null) {
            if (coordinates != null)
                return 1;
        }
        else
        if (coordinates != null && coordinates.compareTo(labWork.coordinates) != 0)
            return coordinates.compareTo(labWork.coordinates);

        if (labWork.creationDate == null){
            if (creationDate != null)
                return 1;
            else
            {
                if (creationDate != null && creationDate.compareTo(labWork.creationDate) != 0)
                {
                    return creationDate.compareTo(labWork.creationDate);
                }
            }
        }
        if (labWork.minimalPoint == null){
            if (minimalPoint != null)
                return 1;
            else
            {
                if (minimalPoint != null && minimalPoint.compareTo(labWork.minimalPoint) != 0)
                {
                    return minimalPoint.compareTo(labWork.minimalPoint);
                }
            }
        }
        if (labWork.difficulty == null){
            if (difficulty != null)
                return 1;
            else
            {
                if (difficulty != null && difficulty.compareTo(labWork.difficulty) != 0)
                {
                    return difficulty.compareTo(labWork.difficulty);
                }
            }
        }
        if (labWork.author == null){
            if (author != null)
                return 1;
            else
            {
                if (author != null && author.compareTo(labWork.author) != 0)
                {
                    return author.compareTo(labWork.author);
                }
            }
        }
        return 0;
    }
}
