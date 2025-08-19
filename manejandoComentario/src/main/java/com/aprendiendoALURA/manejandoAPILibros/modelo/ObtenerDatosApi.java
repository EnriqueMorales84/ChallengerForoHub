package com.aprendiendoALURA.manejandoAPILibros.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ObtenerDatosApi(
        @JsonAlias("count") int numero,
        //@JsonAlias("next") String direccion,
        //@JsonAlias("previous") String nose,
        @JsonAlias("results") JsonNode masDatos
) {
}
