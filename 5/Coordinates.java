public class Coordinates {
    private Double x; //Значение поля должно быть больше -628
    private Long y; //Поле не может быть null

    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }
}
