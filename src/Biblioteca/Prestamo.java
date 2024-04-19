package Biblioteca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.Map;

public class Prestamo {
    private HashMap<String, ArrayList<Libro>> inventario;
    private Map<String, DetallePrestamo> prestamos;

    public Prestamo(HashMap<String, ArrayList<Libro>> inventario) {
        this.inventario = inventario;
        this.prestamos = new HashMap<>();
    }

    public void realizarPrestamo(String tituloLibro, String nombreUsuario) {
        if (inventario.containsKey(tituloLibro) && !inventario.get(tituloLibro).isEmpty()) {
            ArrayList<Libro> libros = inventario.get(tituloLibro);
            if (!libros.isEmpty()) {
                Libro libro = libros.remove(0);
                DetallePrestamo detalle = new DetallePrestamo(libro, nombreUsuario, new Date(), null);
                prestamos.put(libro.getIsbn(), detalle);
                System.out.println("Libro prestado a " + nombreUsuario);
            } else {
                System.out.println("No hay más ejemplares disponibles de " + tituloLibro);
            }
        } else {
            System.out.println("No se encontró el libro titulado: " + tituloLibro);
        }
    }

    public void devolverLibro(String isbn) {
        if (prestamos.containsKey(isbn)) {
            DetallePrestamo detalle = prestamos.remove(isbn);
            ArrayList<Libro> libros = inventario.get(detalle.getLibro().getTitulo());
            libros.add(detalle.getLibro());
            System.out.println("Libro devuelto: " + detalle.getLibro().getTitulo());
        } else {
            System.out.println("No se encontró un préstamo activo para el ISBN: " + isbn);
        }
    }

    public void mostrarLibrosPrestados() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay libros prestados en este momento.");
        } else {
            System.out.println("Libros Prestados:");
            for (DetallePrestamo detalle : prestamos.values()) {
                Libro libro = detalle.getLibro();
                System.out.println("ISBN: " + libro.getIsbn() + " - Título: " + libro.getTitulo() +
                                   ", Autor: " + libro.getAutor() +
                                   ", Prestado a: " + detalle.getNombreUsuario() +
                                   ", Fecha de Préstamo: " + detalle.getFechaPrestamo() +
                                   (detalle.getFechaDevolucion() != null ? 
                                    ", Fecha de Devolución: " + detalle.getFechaDevolucion() : 
                                    ", Aún no devuelto"));
            }
        }
    }    
}

class DetallePrestamo {
    private Libro libro;
    private String nombreUsuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public DetallePrestamo(Libro libro, String nombreUsuario, Date fechaPrestamo, Date fechaDevolucion) {
        this.libro = libro;
        this.nombreUsuario = nombreUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}

