package practica2xd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Practica2xd {
    private String name;
    private Autor autor;
    private double precio;
    private int qty;

    public Practica2xd(String name, Autor autor, double precio, int qty) {
        this.name = name;
        this.autor = autor;
        this.precio = precio;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("****** MENU ********");
            System.out.println("1-MOSTRAR LISTA DE LIBROS");
            System.out.println("2-AGREGAR LIBRO Y ASIGNAR EL AUTOR AL LIBRO");
            System.out.println("3-ELIMINAR LIBRO");
            System.out.println("4-EDITAR LIBRO");
            System.out.println("5-BUSCAR LIBRO POR TITULO");
            System.out.println("6-BUSCAR EL AUTOR DADO UN LIBRO");
            System.out.println("7-ORDENAR LOS LIBROS POR AUTOR");
            System.out.println("0-SALIR");
            System.out.println("*********************");
            System.out.print("SELECCIONE UNA OPCION: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarlistalibros();
                    break;
                case 2:
                    agregarlibroyasignarautor();
                    break;
                case 3:
                    eliminarlibro();
                    break;
                case 4:
                    editarlibro();
                    break;
                case 5:
                    buscarlibrotitulo();
                    break;
                case 6:
                    buscarautordadolibro();
                    break;
                case 7:
                    ordenarlibrosautor();
                    break;
                case 0:
                    System.out.println("Saliendo del menu...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no valida. Por favor, seleccione una opción valida.");

            }
        } while (opcion != 0);

        scanner.close(); // Cerrar el Scanner al final del programa
    }

    private static ArrayList<Practica2xd> listaLibros = new ArrayList<>();

    private static void mostrarlistalibros() {
        if (listaLibros.isEmpty()) {
            System.out.println("No hay libros en la lista.");
        } else {
            System.out.println("Lista de libros:");
            for (Practica2xd libro : listaLibros) {
                System.out.println(libro.getName() + " - " + libro.getAutor().getName());
            }
        }
    }

    private static void agregarlibroyasignarautor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del libro: ");
        String nombreLibro = scanner.next();
        System.out.print("Ingrese el nombre del autor: ");
        String nombreAutor = scanner.next();
        System.out.print("Ingrese el email del autor: ");
        String emailAutor = scanner.next();
        System.out.print("Ingrese el género del autor: ");
        char generoAutor = scanner.next().charAt(0);

        Autor autor = new Autor(nombreAutor, emailAutor, generoAutor);
        Practica2xd libro = new Practica2xd(nombreLibro, autor, 0.0, 0);

        listaLibros.add(libro);
        System.out.println("Libro agregado con éxito.");
    }

    private static void eliminarlibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del libro a eliminar: ");
        String nombreLibro = scanner.next();

        ArrayList<Practica2xd> librosAEliminar = new ArrayList<>();

        for (Practica2xd libro : listaLibros) {
            if (libro.getName().equals(nombreLibro)) {
                librosAEliminar.add(libro);
            }
        }

        if (!librosAEliminar.isEmpty()) {
            listaLibros.removeAll(librosAEliminar);
            System.out.println("Libro(s) eliminado(s) con éxito.");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private static void editarlibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del libro a editar: ");
        String nombreLibro = scanner.next();

        for (Practica2xd libro : listaLibros) {
            if (libro.getName().equals(nombreLibro)) {
                System.out.print("Ingrese el nuevo nombre del libro: ");
                libro.setName(scanner.next());
                System.out.print("Ingrese el nuevo precio del libro: ");
                libro.setPrecio(scanner.nextDouble());
                System.out.print("Ingrese la nueva cantidad del libro: ");
                libro.setQty(scanner.nextInt());
                System.out.println("Libro editado con éxito.");
                return;
            }
        }

        System.out.println("Libro no encontrado.");
    }

    private static void buscarlibrotitulo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el título del libro a buscar: ");
        String tituloLibro = scanner.next();

        for (Practica2xd libro : listaLibros) {
            if (libro.getName().equals(tituloLibro)) {
                System.out.println("Libro encontrado: " + libro.getName() + " - " + libro.getAutor().getName());
                return;
            }
        }

        System.out.println("Libro no encontrado.");
    }

    private static void buscarautordadolibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el título del libro para buscar al autor: ");
        String tituloLibro = scanner.next();

        for (Practica2xd libro : listaLibros) {
            if (libro.getName().equals(tituloLibro)) {
                Autor autor = libro.getAutor();
                System.out.println("Autor del libro " + tituloLibro + ": " + autor.getName() +
                        ", Email: " + autor.getEmail() + ", Género: " + autor.getGenero());
                return;
            }
        }

        System.out.println("Libro no encontrado.");
    }

    private static void ordenarlibrosautor() {
        Collections.sort(listaLibros, Comparator.comparing(libro -> libro.getAutor().getName()));
        System.out.println("Libros ordenados por autor:");
        mostrarlistalibros();
    }
}
