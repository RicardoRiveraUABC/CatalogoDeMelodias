import vista.CatalogoView;
import modelo.CatalogoMelodias;
import control.ControlCatalogo;

public class Main {
    public static void main(String[] args) {
        CatalogoMelodias modelo = new CatalogoMelodias();
        CatalogoView vista = new CatalogoView();
        ControlCatalogo control = new ControlCatalogo(vista, modelo);
        control.iniciar();
    }
}