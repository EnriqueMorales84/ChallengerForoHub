package com.aprendiendoALURA.manejandoAPILibros.principal;
import com.aprendiendoALURA.manejandoAPILibros.modelo.*;
import com.aprendiendoALURA.manejandoAPILibros.repository.AutorRepository;
import com.aprendiendoALURA.manejandoAPILibros.repository.LibroRepository;
import com.aprendiendoALURA.manejandoAPILibros.service.ConsumoAPI;
import com.aprendiendoALURA.manejandoAPILibros.service.ConvierteDatos;
import com.aprendiendoALURA.manejandoAPILibros.service.ObtenerDatosRecord;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.*;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();

    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private String palabraLibroBuscar;
    private String palabraEnMinusculas;
    private ConvierteDatos conversor = new ConvierteDatos();
    ObtenerDatosApi informacionparaLibro;
    private DatosAutor autorLibro;
    private DatosLibro libroBuscar;
    private JsonNode datos;

    //Lista para almacenar los valores buscados de libros, y usar como llave para indicar
    // si el libro fue buscado y agregado a la BD y evitar duplicados
    List<String>busquedaLibro= new ArrayList<>();
    List<DatosLibro> librosAgregar = new ArrayList<>();

    //Antes de este codigo todo funciona medio bien

    private DatosAutor autorFinal;
    private DatosLibro libroFinal;

    private LibroRepository repository;
    private AutorRepository repositoryAutor;
    private List<Libro>mostrarLibrosBD = new ArrayList<>();
    private List<Libro>mostrarLibrosCategoria = new ArrayList<>();

    public Principal(LibroRepository repository, AutorRepository repositoryAutor){
        this.repository = repository;
        this.repositoryAutor=repositoryAutor;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {

            var menu = """
                    1 - Buscar libro por titulo
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                              
                    0 - Salir
                    """;
            System.out.println(menu);

            try {
                opcion = teclado.nextInt();
                teclado.nextLine();


                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nombre del libro que desea buscar");
                        palabraLibroBuscar= teclado.nextLine();
                        if( !verificarPalabra(busquedaLibro,palabraLibroBuscar) ){

                            // buscarLibro(palabraLibroBuscar);
                            buscarLibro(palabraLibroBuscar);
                            //  System.out.println("LIsta libros "+librosAgregar.size());

                            //  System.out.println("LIsta libros "+librosAgregar);
                            //  System.out.println("Obtener el ultimo libro"+ librosAgregar.get(librosAgregar.size()-1 ));

                            //Para verificar si ya existe el libro
                            List<Libro>BuscarLibroEnBD=repository.findByTituloContaining(palabraLibroBuscar);
                            if(BuscarLibroEnBD.size()>0){
                                System.out.println("Este libro no se puede agregar dos veces");
                            } else{

                                if(!librosAgregar.isEmpty()){
                                    libroFinal = librosAgregar.get(librosAgregar.size()-1 );

                                    Libro booK = new Libro( libroFinal);
                                    //  System.out.println(booK.toString());
                                    repository.save(booK);

                                    System.out.println(booK);

                                    Autor nuevoAutor= new Autor(booK);
                                    nuevoAutor.setLibro(booK);
                                    //   repository.save(nuevoAutor);
                                  //  System.out.println(nuevoAutor.toString());
                                } else {
                                    System.out.println("Este titulo no se encuentra disponible en este momento");
                                }

                            }




                            //  System.out.println("LIBRO FINAL"+ libroFinal);





                            //   System.out.println("AUTOR DEL ULTIMO LIBRO"+ libroFinal.autor());






                        } else{
                            System.out.println("Al parecer ya existe un titulo con esa palabra, elija una nueva por favor :)");
                        }

                        break;

                    case 2:
                        listarLibrosBuscados();
                        break;

                    case 3:
                        listarAutores();
                        break;

                    case 4: buscarAutorporFechaNacimiento();
                        break;

                    case 5: buscaLibroPorIdioma();
                        break;



                    case 0:
                        System.out.println("Cerrando la aplicación...");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }

            } catch (InputMismatchException e){
                System.err.println("La entrada debe ser un numero entre 0 y 5 , verifica tu respuesta por favor  y vuelva a ejecutar la aplicacion con la informacion correcta!");
                opcion=0;
            }


            //



        }

    }

    private void buscarAutorporFechaNacimiento() {
        List<Autor>autoresVivos= new ArrayList<>();
        System.out.println("Ingrese el año vivo de autor(es) que desea buscar");
         var fechaNacimiento = teclado.nextInt();
        autoresVivos= repositoryAutor.findByfechaNacimientoBetween(fechaNacimiento,fechaNacimiento+100);

        if(!autoresVivos.isEmpty())
           autoresVivos.forEach(System.out::println);
        else
            System.out.println("No existen autores vivos entre esta fecha: "+ fechaNacimiento);


    }











    private void listarAutores() {

        List<Autor> autoresDisponibles= new ArrayList<>();
        autoresDisponibles = repositoryAutor.findAll();

        if (autoresDisponibles.size()>0){
            autoresDisponibles.stream()
                    .sorted(Comparator.comparing(Autor::getId))
                    .forEach(System.out::println);
        } else{
            System.out.println("NO hay autores registrados aun");
        }



    }

    private void buscaLibroPorIdioma() {
        System.out.println("Ingrese el idioma para buscar los libros");
        System.out.println("Recuerda solo debes de ingresar dos letras");
        System.out.println(idiomasDisponibles());

        var idiomaBuscar = teclado.nextLine();
        mostrarLibrosCategoria = repository.findByIdioma(idiomaBuscar);


        if(mostrarLibrosCategoria.size()>0)
          mostrarLibrosCategoria.forEach(System.out::println);
        else
            System.out.println("No existen publicaciones en ese idioma");


    }

    private String idiomasDisponibles(){

        var idiomasLibrosDisponibles = """
                    
                    es - español
                    en - ingles
                    fr - francés
                    pt - portugues
                    
                    """;
        return idiomasLibrosDisponibles;
    }

    public void buscarLibro(String palabrasBuscar){
        /*
        System.out.println("Ingrese el nombre del libro que desea buscar");
        palabraLibroBuscar= teclado.nextLine();

*/

        var json=consumoApi.obtenerDatos(URL_BASE+palabrasBuscar.replace(" ","%20"));
           informacionparaLibro =conversor.obtenerDatos(json, ObtenerDatosApi.class);
           datos = informacionparaLibro.masDatos();

        ObtenerDatosRecord iniciarBusquedaLibro= new ObtenerDatosRecord();

        /*
        * JsonNode datosApi,
                                     int idApi ,
                                     String palabraBusqueda,
                                     List<String> listaPalabras,
                                     DatosLibro libroGenerar,
                                     DatosAutor autorGenerar,List<DatosLibro>libroAgregar
        *
        *
        *
        *
        * */




        iniciarBusquedaLibro.getInformacionRecord(datos, informacionparaLibro.numero(), palabrasBuscar,busquedaLibro,libroBuscar,autorLibro,librosAgregar);



        }

        public boolean verificarPalabra(List<String>palabrasBuscar, String palabraClave ){
            for(String palabraBuscar : palabrasBuscar){

                if(palabraBuscar.equalsIgnoreCase(palabraClave))
                {
                    System.out.println("No se pueden registrar el mismo libro más de una vez");
                    return true;
                }
            }

            return false;
        }

    private void listarLibrosBuscados(){

        mostrarLibrosBD = repository.findAll();
        mostrarLibrosBD.stream()
                        .sorted(Comparator.comparing(Libro::getId))
                                .forEach(System.out::println);
    }



}
