import java.util.Objects;

public class Celda {

    private int x;
    private int y;

    public Celda(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Hace que dos celdas con la misma X e Y sean tratadas como IGUALES
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Celda celda = (Celda) o;
        return x == celda.x && y == celda.y;
    }

    // Obligatorio para que el HashSet sepa agruparlos correctamente
    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
