public class Coordinates {
    private double x; //Значение поля должно быть больше -628
    private Long y; //Поле не может быть null

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
