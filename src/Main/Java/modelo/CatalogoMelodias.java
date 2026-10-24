package modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogoMelodias {

    private ArrayList<Melodia> canciones;

    public CatalogoMelodias() {
        this.canciones = new ArrayList<>();
    }

    public ArrayList<Melodia> getCanciones() {
        return canciones;
    }

    public boolean registrarMelodia(Melodia melodia) {
        if (melodia == null) return false;
        if (canciones.contains(melodia)) return false;
        canciones.add(melodia);
        return true;
    }

    public Melodia crearObjetoMelodia(String nombre, String compositor, int anyo,
                                      String genero, String cantante,
                                      double precio, String formato) {
        return new Melodia(nombre, compositor, anyo, genero, cantante, precio, formato);
    }

    public boolean removerMelodia(String nombre) {
        return canciones.removeIf(m -> m.getNombre().equalsIgnoreCase(nombre));
    }

    public Melodia buscarPorId(int id) {
        for (Melodia m : canciones) if (m.getId() == id) return m;
        return null;
    }

    public ArrayList<Melodia> buscarPorNombre(String nombre) {
        return canciones.stream()
                .filter(m -> m.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public double obtenerPrecioColeccion() {
        return canciones.stream().mapToDouble(Melodia::getPrecio).sum();
    }

    public ArrayList<String> obtenerTodosLosGeneros() {
        return canciones.stream()
                .map(Melodia::getGenero)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public HashSet<String> obtenerTodosLosGenerosIterativo() {
        HashSet<String> generos = new HashSet<>();
        for (Melodia m : canciones) generos.add(m.getGenero());
        return generos;
    }

    public ArrayList<String> obtenerTodosLosCantantes() {
        return canciones.stream()
                .map(Melodia::getCantante)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Melodia> melodiasPorCompositor(String compositor) {
        return canciones.stream()
                .filter(m -> m.getCompositor().equalsIgnoreCase(compositor))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Melodia> melodiasPorCantante(String cantante) {
        return canciones.stream()
                .filter(m -> m.getCantante().equalsIgnoreCase(cantante))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Melodia> melodiasPorAnio(int anyo) {
        return canciones.stream()
                .filter(m -> m.getAnyo() == anyo)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Melodia> melodiasPorGenero(String genero) {
        return canciones.stream()
                .filter(m -> m.getGenero().equalsIgnoreCase(genero))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Melodia> ordenarPorPrecio() {
        return canciones.stream()
                .sorted(Comparator.comparingDouble(Melodia::getPrecio))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Melodia> ordenarPorAnio() {
        return canciones.stream()
                .sorted(Comparator.comparingInt(Melodia::getAnyo))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Melodia> ordenarPorCantante() {
        return canciones.stream()
                .sorted(Comparator.comparing(Melodia::getCantante))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public String mostrarTodasMelodias() {
        if (canciones.isEmpty()) return "El catálogo está vacío.";
        StringBuilder sb = new StringBuilder();
        for (Melodia m : canciones) sb.append(m).append("\n");
        return sb.toString();
    }
}