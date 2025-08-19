package com.aprendiendoALURA.manejandoAPILibros.modelo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="autores" )
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nombreAutor;
    private int fechaNacimiento;
    private int fechaFallecimiento;

   // @OneToMany(mappedBy = "datosAutor",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "datosAutor",fetch =FetchType.EAGER)
    private List<Libro>librosPublicados = new ArrayList<>();


    public Autor(){

    }

    public Autor(DatosAutor autor){
        this.nombreAutor=autor.nombreAutor();
        this.fechaNacimiento=autor.fechaNacimiento();
        this.fechaFallecimiento=autor.fechaFallecimiento();
    }

    public Autor(Libro autorLibro){
        this.nombreAutor=autorLibro.getAutor().nombreAutor();
        this.fechaNacimiento=autorLibro.getAutor().fechaNacimiento();
        this.fechaFallecimiento=autorLibro.getAutor().fechaFallecimiento();
    }

    public List<Libro> getLibrosPublicados() {
        return librosPublicados;
    }

    public void setLibrosPublicados(List<Libro> librosPublicados) {
        this.librosPublicados = librosPublicados;
    }

    public void setLibro(Libro libro){

        this.librosPublicados.add(libro);
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public int getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(int fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    @Override
    public String toString(){

        return "Autor:"+ nombreAutor +"\n"+
                "Fecha de nacimiento: "+ fechaNacimiento+"\n"+
                "Fecha de fallecimiento: "+ fechaFallecimiento +
                "\n " + librosPublicados;

    }
}
