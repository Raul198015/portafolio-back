package portafolio.domain.models;

import jakarta.persistence.*;


@Entity
@Table


public class Portafolio{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String nombre;
private String descripcion;
private String urlrepo;
private String lenguajes;
private String imagen;

public Portafolio() {

}

public Portafolio(Integer id, String nombre, String descripcion, String urlrepo, String lenguajes, String imagen ) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlrepo  = urlrepo;
        this.lenguajes = lenguajes;
        this.imagen= imagen;
        }

public Portafolio(String nombre, String descripcion, String urlrepo, String lenguajes, String imagen   ) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlrepo = urlrepo;
        this.lenguajes= lenguajes;
        this.imagen= imagen;
        }



public Integer getId() {return id;}

public void setId(Integer id) {
        this.id = id;
        }

public String getNombre() {
        return nombre;
        }

public void setNombre(String nombre) {
        this.nombre = nombre;
        }

public String getDescripcion() {
        return descripcion;
        }

public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        }

public String getUrlrepo() {return urlrepo;}

public void setUrlrepo(String urlrepo) {
        this.urlrepo = urlrepo;
        }

public String getLenguajes() {
        return lenguajes;
        }

public void setLenguajes(String lenguajes) {
        this.lenguajes = lenguajes;
        }
public String getImagen() {return imagen;}

public void setImagen(String imagen) { this.imagen = imagen;}
}
