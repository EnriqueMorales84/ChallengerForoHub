package com.aprendiendoALURA.manejandoAPILibros.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Objects;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(

/*
        Con estos datos se obtiene toda la informacion correspondiente del json
        mandar esta informacion al record ObtenerDatosApi
        y ajustar la informacion ya me voy a jetear
        @JsonAlias("count") int numero,
        @JsonAlias("next") String direccion,
        @JsonAlias("previous") String nose,
        @JsonAlias("results") JsonNode masDatos


*/      // Long idLibro,
         String titulo,
         DatosAutor autor,
         String idioma,
         Integer numeroDescargas



) {


}
