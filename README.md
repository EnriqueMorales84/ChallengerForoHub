# ChallengerForoHub
Crear un foro sobre cualquier tema y que puedan agregar,modificar, y borrar comentarios por parte de los usuarios registrados usando Spring boot 3

<img src="/pantallaPrincipal.png">



<br><br>
Proyecto que corresponde al tercer challenge de Alura que sera crear un foro sobre cualquier tema y que puedan agregar,modificar, y borrar comentarios por parte de los usuarios registrados usando Spring boot 3
<br>

<h2> :white_check_mark: Estado del Proyecto: FINALIZADO Y FUNCIONANDO CORRECTAMENTE </h2>
<br>
<h2> :warning: Información importante :warning:</h2>
 Deberas descargar todos los archivos en la misma carpeta para que pueda funcionar de manera correcta dicha aplicación  y no marque errores de rutas o que no sea posible de localizar algun recurso importante. 
 

<br>

<h2> :pencil: Pre-requisitos </h2>
Deberas de instalar POSTGRES , para poder crear una BD y almacenar la informacion referente a libros y autores, asi como agregar diferentes dependencias en tu archivo pom.xml para tener un correcto funcionamiento 

Una conexión a internet para que la aplicacion pueda acceder a la API y obtener la informacion del libro que desea agregar el usuario.

<img src="/aplicaciones.png" alt="menuPrincipal">



<h2> :computer: Funcionalidades del proyecto </h2>


<h3>:pencil: Opcion 1.</h3> El usuario debera de ingresar una palabra que corresponda al titulo del libro 
que desea agregar a la biblioteca, si dicho nombre no se repite , se agregara sin problema
a la BD.
<img src="/opcion1.png" alt="opcion1">

Además de que aparecera la informacion completa del nuevo elemento
<img src="/libroAgregado.png" alt="libroAgregado">

en caso contrario, recibira un mensaje que el titulo no se puede agregar mas de
dos veces.
<img src="/NoagregarDoble.png" alt="Nodoble">

<h3>:pencil: Opcion 2.</h3> Nos mostrara la coleccion de libros que tenemos actualmente,ademas
de la informacion individual de estos, como son titulo, nombre del autor, idioma(s)
y numero de descargas.
<img src="/informacionLibros.png" alt="opcion2">

<h3>:pencil: Opcion 3.</h3> Podemos obtener la informacion referente a los autores de nuestros libros, como
son: nombre, fecha de nacimiento, fecha de fallecimiento y sus respectivas publicaciones
<img src="/datosAutor.png" alt="opcion3">

<h3>:pencil: Opcion 4.</h3> Apartir de una fecha que ingresemos, podemos obtener los autores que vivieron 
durante ese periodo.
<img src="/fechaNacimiento.png" alt="opcion4">
<br>
<img src="/fechaNacimientoDos.png" alt="opcion4-2">

<h3>:pencil: Opcion 5.</h3> Se puede consultar publicaciones en determinado idioma, en caso de que no
este disponible , la aplicacion nos indicara esto.
<img src="/idiomaNOdisponible.png" alt="opcion4">

En nuestro ejemplo seleccionamos "en" para obtener la informacion del libro
<img src="/opcion5.png" alt="opcion4">


<h3> :hammer: Construido con :wrench: </h3>
Las tecnologias utilizadas para desarrollar esta aplicación fueron 3:
<ul>
 <li> SpringBoot</li>
 <li> POstgres</li>
 <li> IntelliJ</li>
</ul>

<h3> :black_nib: Autor</h3>
Enrique Morales Espinosa, desarrollador web junior 

<h3> :bookmark_tabs: Licencia</h3>
Este proyecto esta bajo licencia ALURA G8

