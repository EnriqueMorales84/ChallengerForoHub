package com.aprendiendoALURA.manejandoAPILibros.repository;

import com.aprendiendoALURA.manejandoAPILibros.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor,Long> {


    List<Autor>findByfechaNacimientoBetween(int fechaInicial, int fechaLimite);
}


/*
* public interface LibroRepository extends JpaRepository<Libro,Long> {

    List<Libro> findByIdioma(String idioma);

    List<Libro> findByAutor();

    @Query("SELECT nombreAutor,fechaNacimiento,fechaFallecimiento,titulo from Autor,Libro")
    List<Autor> nombreAutores();

}

*
*
* */

