package Biblioteca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Libreria {

    // Atributos
    public HashMap<String, ArrayList<Libro>> inventario = new HashMap<>();

    // Constructor
    public Libreria( ){
        this.inventario = new HashMap<>();
    }

    // Métodos
    public void agregarLibro(){

        @SuppressWarnings("resource")
        Scanner agregarlib = new Scanner(System.in);
        
        System.out.println("Titulo del libro: ");
        String titulo = agregarlib.nextLine();

        System.out.println("Autor: ");
        String autor = agregarlib.nextLine();

        System.out.println("ISBN: ");
        String isbn = agregarlib.nextLine();

        System.out.println("Editorial: ");
        String editorial = agregarlib.nextLine();

        System.out.println("Year: ");
        int year = agregarlib.nextInt();

        System.out.println("Precio del libro: ");
        double precio = agregarlib.nextDouble();

        ArrayList<Libro> libros = new ArrayList<Libro>();

        libros.add(new Libro(titulo,autor, isbn,editorial, year, precio));
        inventario.put(titulo, libros);

        System.out.println("Hay un total de "+ libros.size() + " Libro/s en el inventario" );
        
    }

    public void buscarLibroPorTitulo(String titulo){
        ArrayList<Libro> libros = inventario.get(titulo);
        if (libros != null) {
            System.out.println("Libros encontrados con el título '" + titulo + "':");
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        } else {
            System.out.println("No se encontraron libros con el título '" + titulo + "'.");
        }
    }

    public void buscarLibroPorAutor(String autorBuscado) {
        boolean encontrado = false;

        for (ArrayList<Libro> libros : inventario.values()) {
            for (Libro libro : libros) {
                if (libro.getAutor().equalsIgnoreCase(autorBuscado)) {
                    System.out.println("Libro/s encontrado/s:");
                    System.out.println("Título: " + libro.getTitulo());
                    System.out.println("Autor: " + libro.getAutor());
                    System.out.println("ISBN: " + libro.getIsbn());
                    System.out.println("Editorial: " + libro.getEditorial());
                    System.out.println("Año: " + libro.getYear());
                    System.out.println("Precio: " + libro.getPrecio());

                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron libros del autor '" + autorBuscado + "'.");
        }
    }

    public void mostrarInventario(){
        System.out.println("El inventario es: "+ inventario);
    }
    
}



