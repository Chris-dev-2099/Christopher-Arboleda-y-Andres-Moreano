import java.util.Scanner;

import Biblioteca.Libreria;
import Biblioteca.Prestamo;


public class App {
    
    static Libreria libreria = new Libreria();
    static Prestamo prestamo = new Prestamo(libreria.inventario);
    
    public static void main(String[] args) throws Exception {

        Scanner option = new Scanner(System.in);
        Integer optionMenu ;

        do {
            System.out.println("\n--------- Bienvenido a la Biblioteca ---------");
            System.out.println("Elija una opción para continuar o digite 8 para finalizar el programa.");
            System.out.println("1. Agregar un libro");
            System.out.println("2. Buscar libro por título");
            System.out.println("3. Buscar libro por autor");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Realizar préstamo");
            System.out.println("6. Devolver libro prestado");
            System.out.println("7. Listado de libros prestados");
            System.out.println("8. Salir");
            
            optionMenu = option.nextInt();

            switch (optionMenu) {
                case 1:
                    System.out.println("Seleccionó la opción 1.");

                    libreria.agregarLibro();

                    break;
                case 2:
                    System.out.println("Seleccionó la opción 2.");

                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Ingrese el -Título- del libro que desea buscar:");
                    String libroBuscado = scanner.nextLine();

                    libreria.buscarLibroPorTitulo(libroBuscado);

                    break;
                case 3:
                    System.out.println("Seleccionó la opción 3.");

                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Ingrese el -Autor- del libro que desea buscar:");
                    String autorBuscado = scanner2.nextLine();

                    libreria.buscarLibroPorAutor(autorBuscado);

                    break;
                case 4:
                    System.out.println("Seleccionó la opción 3.");

                    System.out.println("-------- Inventario --------");
                    libreria.mostrarInventario();

                    break;
                case 5:
                    System.out.println("Realizando préstamo...");
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Ingrese el titulo del libro que desea pedir prestado: ");
                    String libroPrestar = scanner3.nextLine();
                    System.out.println("Ingrese su nombre de usuario: ");
                    String nombreUsuario = scanner3.nextLine();

                    prestamo.realizarPrestamo(libroPrestar,nombreUsuario);
                    

                    break;
                case 6:
                    System.out.println("Devolviendo libro prestado...");

                    Scanner scanner4 = new Scanner(System.in);
                    System.out.println("Ingrese el isbn del libro que desea devolver: ");
                    String devolver = scanner4.nextLine();

                    prestamo.devolverLibro(devolver);

                    break;
                case 7:
                    System.out.println("Listado de libros prestados...");

                    prestamo.mostrarLibrosPrestados();
                    
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }

        } while (optionMenu != 8);
        
        option.close();
    }
}

