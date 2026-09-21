package Back_end;

/**
 * Clase que gestiona una colección de libros mediante un arreglo crudo.
 * Actividad 2.1 - Arreglos
 *
 * PROHIBIDO usar ArrayList, List, Map o cualquier colección de Java.
 */
public class Biblioteca {

    // ── Atributo privado ────────────────────────────────────────────────────
    private Libro[] libros;

    // ── Constructor ─────────────────────────────────────────────────────────
    /**
     * Crea una biblioteca con la capacidad indicada.
     *
     * @param capacidad número máximo de libros (debe ser > 0)
     */
    public Biblioteca(int capacidad) {
        crearBiblioteca(capacidad);
    }

    // ══════════════════════════════════════════════════════════════════════
    //  1. crearBiblioteca
    // ══════════════════════════════════════════════════════════════════════
    /**
     * Inicializa (o reinicializa) el arreglo interno con la capacidad dada.
     *
     * @param capacidad número máximo de libros
     * @return mensaje de resultado
     */
    public String crearBiblioteca(int capacidad) {
        if (capacidad <= 0) {
            return "ERROR: La capacidad debe ser mayor que cero.";
        }
        libros = new Libro[capacidad];
        return "Biblioteca creada con capacidad para " + capacidad + " libro(s).";
    }

    // ══════════════════════════════════════════════════════════════════════
    //  2. mostrarLibros
    // ══════════════════════════════════════════════════════════════════════
    /**
     * Devuelve una representación de todos los libros registrados.
     *
     * @return cadena con el listado o mensaje de estado
     */
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

    // ══════════════════════════════════════════════════════════════════════
    //  3. agregarLibro
    // ══════════════════════════════════════════════════════════════════════
    /**
     * Inserta un libro en el índice indicado.
     *
     * @param libro  libro a agregar (no puede ser null)
     * @param indice posición destino en el arreglo
     * @return mensaje de resultado
     */
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

    // ══════════════════════════════════════════════════════════════════════
    //  4. mostrarLibroPorIndice
    // ══════════════════════════════════════════════════════════════════════
    /**
     * Devuelve el libro almacenado en el índice indicado.
     *
     * @param indice posición a consultar
     * @return mensaje con los datos del libro o error
     */
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

    // ══════════════════════════════════════════════════════════════════════
    //  5. modificarLibro
    // ══════════════════════════════════════════════════════════════════════
    /**
     * Reemplaza el libro en la posición indicada.
     *
     * @param indice posición a modificar
     * @param libro  nuevo libro (no puede ser null)
     * @return mensaje de resultado
     */
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

    // ══════════════════════════════════════════════════════════════════════
    //  6. eliminarLibro
    // ══════════════════════════════════════════════════════════════════════
    /**
     * Elimina (pone a null) el libro en el índice indicado.
     *
     * @param indice posición a vaciar
     * @return mensaje de resultado
     */
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

    // ══════════════════════════════════════════════════════════════════════
    //  7. destruirBiblioteca
    // ══════════════════════════════════════════════════════════════════════
    /**
     * Libera el arreglo, dejando la biblioteca sin inicializar.
     *
     * @return mensaje de resultado
     */
    public String destruirBiblioteca() {
        if (libros == null) {
            return "ERROR: La biblioteca ya estaba destruida o nunca fue creada.";
        }
        libros = null;
        return "Biblioteca destruida. Todos los datos han sido eliminados.";
    }

    // ── Helpers privados ────────────────────────────────────────────────────
    private boolean indiceValido(int indice) {
        return indice >= 0 && indice < libros.length;
    }
}
