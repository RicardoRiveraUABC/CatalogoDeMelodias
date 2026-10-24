package control;

import modelo.CatalogoMelodias;
import modelo.Melodia;
import vista.CatalogoView;

public class ControlCatalogo {

    private CatalogoMelodias modelo;
    private CatalogoView vista;

    public ControlCatalogo(CatalogoView vista, CatalogoMelodias modelo) {
        this.modelo = modelo;
        this.vista  = vista;
    }

    public void iniciar() {
        int opcion = 0;
        while (opcion != 3) {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1: registrar();        break;
                case 2: mostrarCatalogo();  break;
                case 3: vista.mostrarCadena("ADIOS"); break;
                default: vista.mostrarCadena("Opción inválida");
            }
        }
    }

    private void registrar() {
        vista.mostrarCadena("--- Registrar nueva melodía ---");
        String nombre     = vista.leerNombreMelodia();
        String cantante   = vista.leerCantante();
        String compositor = vista.leerCompositor();
        String genero     = vista.mostrarObtenerGenero();
        String formato    = vista.mostrarObtenerFormato();
        int    anyo       = vista.leerAnioMelodia();
        double precio     = vista.leerPrecioMelodia();

        Melodia nueva = modelo.crearObjetoMelodia(nombre, compositor, anyo, genero, cantante, precio, formato);

        boolean ok = modelo.registrarMelodia(nueva);
        if (ok) vista.mostrarCadena("✔ Melodía registrada con ID " + nueva.getId());
        else    vista.mostrarCadena("✘ Ya existe una versión con ese cantante y año.");
    }

    private void mostrarCatalogo() {
        vista.mostrarCadena(modelo.mostrarTodasMelodias());
    }
}