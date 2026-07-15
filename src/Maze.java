import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Maze {

    private int[][] maze;

    public Maze() {

        maze = new int[][] {
                { 0, 0, 0, 1, 0, 0 },
                { 1, 1, 0, 1, 0, 1 },
                { 0, 1, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0 }
        };

        Celda inicio = new Celda(0, 0);
        Celda fin = new Celda(0, 2);

        List<Celda> camino = new ArrayList<>();
        Set<Celda> visitados = new HashSet<>();
        findPath2(maze, inicio, fin, camino, visitados);
        System.out.println("LABERINTO CON EL CAMINO SET");
        imprimirCamino(visitados);

        System.out.println("LABERINTO ORIGINAL");
        imprimirLaberinto();

        boolean encontrado = findPath(maze, inicio, fin, camino);

        if (encontrado == true) {

            System.out.println("\nCAMINO:");

            for (int i = 0; i < camino.size(); i++) {
                Celda c = camino.get(i);

                System.out.print("(" + c.getX() + "," + c.getY() + ")");

                if (i < camino.size() - 1) {
                    System.out.print(" -> ");
                }
            }

        } else {
            System.out.println("No existe un camino.");
        }

    }

    private boolean findPath(int[][] maze, Celda inicio, Celda fin, List<Celda> camino) {

        int fila = inicio.getX();
        int columna = inicio.getY();

        // Fuera del laberinto
        if (fila < 0 || fila >= maze.length ||
                columna < 0 || columna >= maze[0].length) {
            return false;
        }

        // Pared o visitada
        if (maze[fila][columna] == 1 || maze[fila][columna] == 2) {
            return false;
        }

        // Llegó al destino
        if (inicio.equals(fin)) {
            camino.add(0, inicio);
            return true;
        }

        // Marcar como visitada
        maze[fila][columna] = 2;

        // Derecha
        if (findPath(maze, new Celda(fila, columna + 1), fin, camino)) {
            camino.add(0, inicio);
            return true;
        }

        // Abajo
        if (findPath(maze, new Celda(fila + 1, columna), fin, camino)) {
            camino.add(0, inicio);
            return true;
        }

        // Izquierda
        if (findPath(maze, new Celda(fila, columna - 1), fin, camino)) {
            camino.add(0, inicio);
            return true;
        }

        // Arriba
        if (findPath(maze, new Celda(fila - 1, columna), fin, camino)) {
            camino.add(0, inicio);
            return true;
        }

        return false;
    }

    private void imprimirLaberinto() {

        for (int i = 0; i < maze.length; i++) {

            for (int j = 0; j < maze[i].length; j++) {

                if (maze[i][j] == 1) {
                    System.out.print("# ");
                } else {
                    System.out.print(". ");
                }
            }

            System.out.println();
        }
    }

    private void imprimirCamino(Set<Celda> camino) {

        for (int i = 0; i < maze.length; i++) {

            for (int j = 0; j < maze[i].length; j++) {

                Celda actual = new Celda(i, j);

                if (camino.contains(actual)) {
                    System.out.print("* ");
                } else if (maze[i][j] == 1) {
                    System.out.print("# ");
                } else {
                    System.out.print(". ");
                }
            }

            System.out.println();
        }
    }

    private boolean findPath2(int[][] maze, Celda inicio, Celda fin, List<Celda> camino, Set<Celda> visitados) {
        int fila = inicio.getX();
        int columna = inicio.getY();

        // Fuera de límites
        if (fila < 0 || fila >= maze.length || columna < 0 || columna >= maze[0].length) {
            return false;
        }

        // Pared (1) o ya visitado en el Set
        if (maze[fila][columna] == 1 || visitados.contains(inicio)) {
            return false;
        }

        // Llegó al destino
        if (inicio.equals(fin)) {
            camino.add(0, inicio);
            return true;
        }

        // Registrar en el Set
        visitados.add(inicio);

        // Marcar como visitada en la matriz (para rastro visual si se requiere)
        maze[fila][columna] = 2;

        // Derecha
        if (findPath2(maze, new Celda(fila, columna + 1), fin, camino, visitados)) {
            camino.add(0, inicio);
            return true;
        }

        // Abajo
        if (findPath2(maze, new Celda(fila + 1, columna), fin, camino, visitados)) {
            camino.add(0, inicio);
            return true;
        }

        // Izquierda
        if (findPath2(maze, new Celda(fila, columna - 1), fin, camino, visitados)) {
            camino.add(0, inicio);
            return true;
        }

        // Arriba
        if (findPath2(maze, new Celda(fila - 1, columna), fin, camino, visitados)) {
            camino.add(0, inicio);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        new Maze();

    }
}