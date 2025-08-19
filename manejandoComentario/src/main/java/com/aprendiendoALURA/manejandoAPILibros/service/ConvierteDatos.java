package com.aprendiendoALURA.manejandoAPILibros.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ConvierteDatos implements IConvierteDatos{

    private ObjectMapper mapper= new ObjectMapper();
    JsonNode rootNode;
    JsonNode elementos;

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {

                 return mapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
