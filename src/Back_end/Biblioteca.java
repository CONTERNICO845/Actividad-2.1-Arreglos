package Back_end;

/*Victor Manuel Leyva Perez
  Geovani Gael Carmona Barbosa
  Manuel Angel Espinoza Lopez
 */
public class Biblioteca {

    
    private Libro[] libros;

   
    public Biblioteca(int capacidad) {
        crearBiblioteca(capacidad);
    }

    
    public String crearBiblioteca(int capacidad) {
        if (capacidad <= 0) {
            return "ERROR: La capacidad debe ser mayor que cero.";
        }
        libros = new Libro[capacidad];
        return "Biblioteca creada con capacidad para " + capacidad + " libro(s).";
    }

    
    public String mostrarLibros() {
        if (libros == null) {
            return "ERROR: La biblioteca no ha sido creada.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("── Listado de libros (capacidad: ").append(libros.length).append(") ──\n");

        boolean hayAlguno = false;
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null) {
                sb.append("  [").append(i).append("] ").append(libros[i]).append("\n");
                hayAlguno = true;
            }
        }

        if (!hayAlguno) {
            sb.append("  (Sin libros registrados)\n");
        }
        return sb.toString().trim();
    }

    
    public String agregarLibro(Libro libro, int indice) {
        if (libros == null) {
            return "ERROR: La biblioteca no ha sido creada.";
        }
        if (libro == null) {
            return "ERROR: El libro no puede ser nulo.";
        }
        if (!indiceValido(indice)) {
            return "ERROR: Índice fuera de rango. Rango válido: 0 – " + (libros.length - 1) + ".";
        }
        if (libros[indice] != null) {
            return "ERROR: Ya existe un libro en el índice " + indice + ". Use 'Modificar' para reemplazarlo.";
        }
        libros[indice] = libro;
        return "Libro agregado en el índice " + indice + ": " + libro;
    }

    
    public String mostrarLibroPorIndice(int indice) {
        if (libros == null) {
            return "ERROR: La biblioteca no ha sido creada.";
        }
        if (!indiceValido(indice)) {
            return "ERROR: Índice fuera de rango. Rango válido: 0 – " + (libros.length - 1) + ".";
        }
        if (libros[indice] == null) {
            return "INFO: No hay libro en el índice " + indice + ".";
        }
        return "Índice [" + indice + "]: " + libros[indice];
    }

    
    public String modificarLibro(int indice, Libro libro) {
        if (libros == null) {
            return "ERROR: La biblioteca no ha sido creada.";
        }
        if (libro == null) {
            return "ERROR: El libro nuevo no puede ser nulo.";
        }
        if (!indiceValido(indice)) {
            return "ERROR: Índice fuera de rango. Rango válido: 0 – " + (libros.length - 1) + ".";
        }
        if (libros[indice] == null) {
            return "ERROR: No existe libro en el índice " + indice + ". Use 'Agregar' para insertar uno nuevo.";
        }
        Libro anterior = libros[indice];
        libros[indice] = libro;
        return "Libro modificado en índice " + indice
                + ".\n  Anterior: " + anterior
                + "\n  Nuevo:    " + libro;
    }

   
    public String eliminarLibro(int indice) {
        if (libros == null) {
            return "ERROR: La biblioteca no ha sido creada.";
        }
        if (!indiceValido(indice)) {
            return "ERROR: Índice fuera de rango. Rango válido: 0 – " + (libros.length - 1) + ".";
        }
        if (libros[indice] == null) {
            return "INFO: No hay libro en el índice " + indice + " para eliminar.";
        }
        Libro eliminado = libros[indice];
        libros[indice] = null;
        return "Libro eliminado del índice " + indice + ": " + eliminado;
    }

    
    public String destruirBiblioteca() {
        if (libros == null) {
            return "ERROR: La biblioteca ya estaba destruida o nunca fue creada.";
        }
        libros = null;
        return "Biblioteca destruida. Todos los datos han sido eliminados.";
    }

   
    private boolean indiceValido(int indice) {
        return indice >= 0 && indice < libros.length;
    }
}
