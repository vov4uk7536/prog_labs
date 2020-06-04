public class Coordinates implements Comparable<Coordinates>{
    /** Координата x */
    private Double x; //Значение поля должно быть больше -628
    /** Координата y */
    private Long y; //Поле не может быть null
    /** Функция, придающая объекту вид для записи в gson */
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /** Функция получения координаты x
     * @return Координату x
     * */
    public Double getX() {
        return x;
    }
    /** Функция задания координаты х
     * @param x Координата х
     * */
    public void setX(double x) {
        this.x = x;
    }
    /** Функция получения координаты y
     * @return Координату y
     * */
    public Long getY() {
        return y;
    }
    /** Функция задания координаты y
     * @param y Координата y
     * */
    public void setY(long y) {
        this.y = y;
    }
    /** Функция сравнивания объектов класса Coordinates
     * @param coordinates Объект класса Coordinates
     * */
    public int compareTo(Coordinates coordinates) {
        if (coordinates != null) {
            if (coordinates.x == null) {
                if (x != null)
                    return 1;
            } else if (x != null)
                return x.compareTo(coordinates.x);

            if (coordinates.y == null) {
                if (y != null)
                    return 1;
            } else if (y != null) {
                return y.compareTo(coordinates.y);
            }
        }
        else
            return 1;

        return 0;
    }
}
