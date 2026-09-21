package Back_end;

/*Victor Manuel Leyva Perez
  Geovani Gael Carmona Barbosa
  Manuel Angel Espinoza Lopez
 */
public class Libro {

   
    private String titulo;
    private String autor;
    private int    anioPublicacion;

    
    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo          = titulo;
        this.autor           = autor;
        this.anioPublicacion = anioPublicacion;
    }

    
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Libro otro = (Libro) obj;
        return anioPublicacion == otro.anioPublicacion
                && titulo.equalsIgnoreCase(otro.titulo)
                && autor.equalsIgnoreCase(otro.autor);
    }

    
    @Override
    public int hashCode() {
        int resultado = 17;
        resultado = 31 * resultado + (titulo  != null ? titulo.toLowerCase().hashCode()  : 0);
        resultado = 31 * resultado + (autor   != null ? autor.toLowerCase().hashCode()   : 0);
        resultado = 31 * resultado + anioPublicacion;
        return resultado;
    }

    
    @Override
    public String toString() {
        return "Libro{"
                + "titulo='"        + titulo          + '\''
                + ", autor='"       + autor           + '\''
                + ", anio="         + anioPublicacion
                + '}';
    }
}
