package com.aprendiendoALURA.manejandoAPILibros.repository;

import com.aprendiendoALURA.manejandoAPILibros.modelo.Autor;
import com.aprendiendoALURA.manejandoAPILibros.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro,Long> {

    List<Libro> findByIdioma(String idioma);


    @Query("SELECT l FROM Libro l WHERE l.titulo LIKE %:titulo%")
    List<Libro> findByTituloContaining(@Param("titulo") String titulo);

}
