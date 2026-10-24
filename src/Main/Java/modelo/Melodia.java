package modelo;

import java.util.Objects;

public class Melodia {
    private static int contadorId = 1;

    private int id;
    private String nombre;
    private String compositor;
    private int anyo;
    private String genero;
    private String cantante;
    private double precio;
    private String formato;

    public Melodia(String nombre, String compositor, int anyo, String genero,
                   String cantante, double precio, String formato) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.compositor = compositor;
        this.anyo = anyo;
        this.genero = genero;
        this.cantante = cantante;
        this.precio = precio;
        this.formato = formato;
    }

    public int getId()            { return id; }
    public String getNombre()     { return nombre; }
    public String getCompositor() { return compositor; }
    public int getAnyo()          { return anyo; }
    public String getGenero()     { return genero; }
    public String getCantante()   { return cantante; }
    public double getPrecio()     { return precio; }
    public String getFormato()    { return formato; }

    public void setNombre(String nombre)         { this.nombre = nombre; }
    public void setCompositor(String compositor) { this.compositor = compositor; }
    public void setAnyo(int anyo)                { this.anyo = anyo; }
    public void setGenero(String genero)         { this.genero = genero; }
    public void setCantante(String cantante)     { this.cantante = cantante; }
    public void setPrecio(double precio)         { this.precio = precio; }
    public void setFormato(String formato)       { this.formato = formato; }

    @Override
    public String toString() {
        return "ID: " + id + " | " + nombre + " | " + cantante +
                " | " + anyo + " | " + compositor + " | $" + precio +
                " | " + formato + " | " + genero;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Melodia)) return false;
        Melodia otra = (Melodia) obj;
        return this.cantante.equals(otra.cantante) && this.anyo == otra.anyo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantante, anyo);
    }
}