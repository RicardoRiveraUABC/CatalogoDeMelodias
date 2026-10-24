package vista;

import modelo.Genero;
import java.util.Scanner;

public class CatalogoView {

    private Scanner leerNumeros  = new Scanner(System.in);
    private Scanner leerCadenas  = new Scanner(System.in);

    private static final String[] FORMATOS = {"mp3", "ogg", "wav", "flac"};

    public int mostrarMenu() {
        System.out.println("\n --- MENÚ CATÁLOGO DE MELODÍAS --- ");
        System.out.println("1. Registrar melodía");
        System.out.println("2. Mostrar todo el catálogo");
        System.out.println("3. Salir");
        System.out.print("Elige una opción: ");
        return leerNumeros.nextInt();
    }

    public String leerNombreMelodia()  { System.out.print("Nombre: ");     return leerCadenas.nextLine(); }
    public String leerCompositor()     { System.out.print("Compositor: "); return leerCadenas.nextLine(); }
    public String leerCantante()       { System.out.print("Cantante: ");   return leerCadenas.nextLine(); }
    public int    leerAnioMelodia()    { System.out.print("Año: ");        return leerNumeros.nextInt(); }
    public double leerPrecioMelodia()  { System.out.print("Precio: ");     return leerNumeros.nextDouble(); }

    public void mostrarCadena(String cadena) { System.out.println(cadena); }

    public String mostrarObtenerGenero() {
        Genero[] generos = Genero.values();
        for (int i = 0; i < generos.length; i++) {
            System.out.println((i + 1) + ". " + generos[i]);
        }
        System.out.print("Elige género: ");
        int num = leerNumeros.nextInt();
        return generos[num - 1].name();
    }

    public String mostrarObtenerFormato() {
        for (int i = 0; i < FORMATOS.length; i++) {
            System.out.println((i + 1) + ". " + FORMATOS[i]);
        }
        System.out.print("Elige formato: ");
        int num = leerNumeros.nextInt();
        return FORMATOS[num - 1];
    }
}