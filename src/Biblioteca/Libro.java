package Biblioteca;

public class Libro {
    
    // Atributos
    private String titulo;
    private String autor;
    private String isbn;
    private String editorial;
    private int year;
    private double precio;
    
    // constructor
    public Libro( String titulo, String autor, String isbn, String editorial, int year, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.editorial = editorial;
        this.year = year;
        this.precio = precio;
    }

    // Metodos
    
    @Override
    public String toString() {
        return String.format("Libro{titulo='%s', autor='%s', ISBN='%s', editorial='%s', año=%d, precio=%.2f}",
                             titulo, autor, isbn, editorial, year, precio);
    }

    // Titulo
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Autor
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    // ISBN
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Editorial
    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    // Year
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Precio
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
