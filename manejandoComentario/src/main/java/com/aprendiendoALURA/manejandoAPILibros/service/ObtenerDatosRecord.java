package com.aprendiendoALURA.manejandoAPILibros.service;

import com.aprendiendoALURA.manejandoAPILibros.modelo.DatosAutor;
import com.aprendiendoALURA.manejandoAPILibros.modelo.DatosLibro;
import com.aprendiendoALURA.manejandoAPILibros.modelo.IDIOMA;
import com.aprendiendoALURA.manejandoAPILibros.modelo.ObtenerDatosApi;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;


public class ObtenerDatosRecord {

    private ObjectMapper mapper= new ObjectMapper();
    private  JsonNode rootNodeAutores;
    private  JsonNode elementos;
    private JsonNode elegirLanguage;
    private IDIOMA idiomaLibro;
    //Para saber si la busqueda tuvo exito y hay libros disponibles
    private long contadorValido;

    //Libro que se va a buscar y agregar
    DatosLibro libro;
    //libros que se agregar al autor
    private List<DatosLibro> libroAutor;

    //Datos Autor
    private String nombreAutorLibro;
    private int fechaNacimiento;
    private int fechaFallecimiento;

    private  String idioma;
    private int descargas;

    /*
    //Opcion seria para escoger libro o author
    public void getInformacionRecord(JsonNode datosApi,
                                     int idApi ,
                                     String palabraBusqueda,
                                     List<String> listaPalabras,
                                     DatosLibro libroGenerar,
                                     DatosAutor autorGenerar,List<DatosLibro>libroAgregar){

        //Obteniendo toda la informacion al consultar la API
        //elementos= datosApi.masDatos();
        elementos = datosApi;
        if(elementos.isArray()){

            System.out.println("Longitud elementos"+ elementos.size());
            for(JsonNode elemento: elementos){

                //contadorValido=Integer.parseInt(elemento.get("count").asText());
                /*
                try {

                }catch(NullPointerException exception)
                {
                    System.out.println(exception);
                }
                */
              //  System.out.println("COUNT"+idApi);
/*
                contadorValido= idApi;
              //  System.out.println("contador: "+contadorValido);

                if(contadorValido>0){ //Indica que si encontro informacion



                            String titulo= elemento.get("title").asText();
                            rootNodeAutores =elemento.get("authors");

                            for(JsonNode autor: rootNodeAutores)
                            {
                                nombreAutorLibro= autor.get("name").asText();
                                fechaNacimiento= autor.get("birth_year").asInt();
                                fechaFallecimiento= autor.get("death_year").asInt();
                                break;
                            }
                            idioma =elemento.get("languages");
                            descargas=elemento.get("download_count").asInt();

                            //solo para comprobar si se obtienen los datos
                 /*   System.out.println("titulo: " + titulo);
                    System.out.println("Autor: " + nombreAutorLibro);
                    System.out.println("fecha Nacimiento: " + fechaNacimiento);
                    System.out.println("fecha Fallecimiento: " + fechaFallecimiento);
                    System.out.println("Idioma: " + idioma);
                    System.out.println("Numero de descargas: " + descargas);
                 */
                    //crear el autor
                    //ahorita q estoy aca puedo generar un json ya con los datos correspondientes y en los campos
                    //de datosLibro poner el alias como estan los datos aca @JsonAlias("titulo") y asi obtener los datos
                    //como siempre se hace, POr el momento esa opcion se cancela mejor lo hacemos de manera directa
/*
                    autorGenerar= new DatosAutor(nombreAutorLibro,fechaNacimiento,fechaFallecimiento);
                    System.out.println("Imprimir datos Autor ya formado bien, aun sin agregar el libro ");
                    System.out.println(autorGenerar);

                    //Crear el libro
                    libroGenerar = new DatosLibro(titulo,autorGenerar,idioma,descargas);
                    System.out.println("Imprimir datos libro ta formado bien");
                    System.out.println(libroGenerar);

                    libroAgregar.add(libroGenerar);
                    System.out.println("LIBRO SEGUN AGREDADO A LA LISTA"+libroAgregar);


                    //agregamos Libro ahora asi al autor
                    //autorGenerar.listaLibros().add(libroGenerar);
                    //System.out.println("autor ya con libro generado");
                    //System.out.println(autorGenerar);


                    System.out.println("PALABRA BUSQUEDA");
                    listaPalabras.add(palabraBusqueda);
                    System.out.println("LIStA PALABRAS" + listaPalabras);

                    break;



                }


            }

        }
    }

    */


    public void getInformacionRecord(JsonNode datosApi,
                                     int idApi ,
                                     String palabraBusqueda,
                                     List<String> listaPalabras,
                                     DatosLibro libroGenerar,
                                     DatosAutor autorGenerar,List<DatosLibro>libroAgregar){

        //Obteniendo toda la informacion al consultar la API
        //elementos= datosApi.masDatos();
        elementos = datosApi;
        if(elementos.isArray()){

            //System.out.println("Longitud elementos"+ elementos.size());
            if(elementos.size() >0){

                for(JsonNode elemento: elementos){

                        String titulo= elemento.get("title").asText();
                        rootNodeAutores =elemento.get("authors");

                        for(JsonNode autor: rootNodeAutores)
                        {
                            nombreAutorLibro= autor.get("name").asText();
                            fechaNacimiento= autor.get("birth_year").asInt();
                            fechaFallecimiento= autor.get("death_year").asInt();
                            break;
                        }

                        //aqui modifique ultimamente
                        elegirLanguage = elemento.get("languages");
                     //   System.out.println("Elegir lenguage tal como esta en la API, y antes de entrar al foreach"+ elegirLanguage);
                        for(JsonNode aux: elegirLanguage){
                            idioma = aux.asText();
                       //     System.out.println("DENTRO DEL FOREACH PARA IDIOMA"+ idioma);
                            break;
                        }




                       // idioma =elemento.get("languages");
                        descargas=elemento.get("download_count").asInt();


                        autorGenerar= new DatosAutor(nombreAutorLibro,fechaNacimiento,fechaFallecimiento);
                     //   System.out.println("Imprimir datos Autor ya formado bien, aun sin agregar el libro ");
                      //  System.out.println(autorGenerar);

                        //Crear el libro
                        libroGenerar = new DatosLibro(titulo,autorGenerar,idioma,descargas);
                     //   System.out.println("Imprimir datos libro ta formado bien");
                      //  System.out.println(libroGenerar);

                        libroAgregar.add(libroGenerar);
                     //   System.out.println("LIBRO SEGUN AGREDADO A LA LISTA"+libroAgregar);



                      //  System.out.println("PALABRA BUSQUEDA");
                        listaPalabras.add(palabraBusqueda);
                      //  System.out.println("LIStA PALABRAS" + listaPalabras);

                        break;






                }

            } else if(elementos.size()==0){
                System.out.println("Opcion no valida");
            }













        }
    }


    /*
    public DatosLibro getInformacionRecord(JsonNode datosApi,
                                         int idApi ,
                                        String palabraBusqueda,
                                        List<String> listaPalabras,
                                        DatosLibro libroGenerar,
                                        DatosAutor autorGenerar,List<DatosLibro>libroAgregar){
           //Obteniendo toda la informacion al consultar la API
           //elementos= datosApi.masDatos();
           elementos = datosApi;
          if(elementos.isArray()){

               System.out.println("Longitud elementos"+ elementos.size());
              if(elementos.size() >0){

                   for(JsonNode elemento: elementos){

                           String titulo= elemento.get("title").asText();
                           rootNodeAutores =elemento.get("authors");

                           for(JsonNode autor: rootNodeAutores)
                           {
                               nombreAutorLibro= autor.get("name").asText();
                                fechaNacimiento= autor.get("birth_year").asInt();
                                fechaFallecimiento= autor.get("death_year").asInt();
                               break;
                            }
                            idioma =elemento.get("languages");
                           descargas=elemento.get("download_count").asInt();


                            autorGenerar= new DatosAutor(nombreAutorLibro,fechaNacimiento,fechaFallecimiento);
                           System.out.println("Imprimir datos Autor ya formado bien, aun sin agregar el libro ");
                            System.out.println(autorGenerar);

                           //Crear el libro
                           libroGenerar = new DatosLibro(titulo,autorGenerar,idioma,descargas);
                           System.out.println("Imprimir datos libro ta formado bien");
                           System.out.println(libroGenerar);

                           libroAgregar.add(libroGenerar);
                           System.out.println("LIBRO SEGUN AGREDADO A LA LISTA"+libroAgregar);



                           System.out.println("PALABRA BUSQUEDA");
                           listaPalabras.add(palabraBusqueda);
                           System.out.println("LIStA PALABRAS" + listaPalabras);

                           break;






                  }

                } else if(elementos.size()==0){
                    System.out.println("Opcion no valida");
                }













            }
        }
*/

}
