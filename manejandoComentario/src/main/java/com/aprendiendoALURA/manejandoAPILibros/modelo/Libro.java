package com.aprendiendoALURA.manejandoAPILibros.modelo;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;

@Entity
@Table(name="libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique= true)
    private String titulo;

    @Transient
    private DatosAutor autor;



    //@ManyToOne
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name="autor_id")
    private Autor datosAutor;
    private String idioma;
    private Integer numeroDescargas;

    //en todas las variables para almacenar autor hay q checar q no se repita el nombre antes de agregar
    //ya seria con consulta

    public Libro(){ }

    public Libro(DatosLibro libro){
        this.titulo= libro.titulo();
        this.autor=libro.autor();

        //se asignan valores a la clase AUTOR no al record
        this.datosAutor = new Autor(libro.autor());

       //Checar que al inicializar un objeto libro ,cambiar el valor a ENUM IDIOMA, ya que
        // se encuentra como JNODE
         this.idioma=libro.idioma();
        this.numeroDescargas= libro.numeroDescargas();
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public DatosAutor getAutor() {
        return autor;
    }

    public void setAutor(DatosAutor autor) {

        this.autor = autor;
    }



    /************DATOS DEL AUTOR DE LA CLASE*****************/
    public Autor getDatosAutor() {
        return datosAutor;
    }

    public void setDatosAutor(Autor datosAutor) {
        datosAutor.setLibro(this);
        this.datosAutor = datosAutor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Integer numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    @Override
    public String toString(){

        return "------LIBRO----\n" +
                "Titulo: " + titulo +"\n"+
                " "+ datosAutor.getNombreAutor() +"\n"+
                "IDIOMA: "+ idioma+"\n"+
                "Numero de descargas: "+ numeroDescargas +
                "\n-------------";

    }

}
