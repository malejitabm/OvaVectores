<%@ page import="edu.self.model.DTOUser" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Vectores</title>
<link rel="icon" type="image/ico" href="img/vectores-logo.ico">
<link href="https://fonts.googleapis.com/css?family=Oxygen:300,400,700"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/androidstudio.css"/>
</head>
<% 
	DTOUser user;
%>
<body>
	<%
		if(session.getAttribute("user") == null){
			response.sendRedirect("index.jsp");
			return;
		}
		user = (DTOUser)session.getAttribute("user");
	%>
	<div class="nav-bar grey-background">

		<div class="nav-bar-header">
			<img class="header-img" width="103" height="60"
				src="img/vectores-logo.png">
		</div>
		<div class="user-info">
			<a href="" onclick="return enableContent(6);"><img width="64px"
				height="64px" src="img/user.png"></a>
			<p>
				Bienvenido,<br><%=user.getName()%>
			</p>
		</div>
		<ul>
			<li><a class="item" href="" onclick="return enableHomeContent();">Inicio</a>
			</li>
			
			<li><a class="item" href="" onclick="return enableSubItem(1);">Inicialización</a>
				<ul class="hidden-menu">
					<li><a class="subitem" href=""
						onclick="return retrieveVideoContent(1);">Contenido Teórico</a></li>
					<li><a class="subitem" href=""
						onclick="return retrieveCuestionary(1);">Cuestionario</a></li>
				</ul></li>
			<li><a class="item" href="" onclick="return enableSubItem(2);">Recorrido</a>
				<ul class="hidden-menu">
					<li><a class="subitem" href=""
						onclick="return retrieveVideoContent(2);">Contenido Teórico</a></li>
					<li><a class="subitem" href=""
						onclick="return retrieveCuestionary(3);">Cuestionario</a></li>
				</ul></li>
			<li><a class="item" href="" onclick="return enableSubItem(3);">Asignación</a>
				<ul class="hidden-menu">
					<li><a class="subitem" href=""
						onclick="return retrieveVideoContent(3);">Contenido Teórico</a></li>
					<li><a class="subitem" href=""
						onclick="return retrieveCuestionary(2);">Cuestionario</a></li>
				</ul></li>
			<li><a class="item" href="" onclick="return enableSubItem(4);">Busqueda
					de elementos</a>
				<ul class="hidden-menu">
					<li><a class="subitem" href=""
						onclick="return retrieveVideoContent(4);">Contenido Teórico</a></li>
					<li><a class="subitem" href=""
						onclick="return retrieveCuestionary(4);">Cuestionario</a></li>
				</ul></li>
			<li><a class="item" href="" onclick="return enableSubItem(5);">Algoritmos
					de ordenamiento</a>
				<ul class="hidden-menu">
					<li><a class="subitem" href=""
						onclick="return retrieveVideoContent(5);">Contenido Teórico</a></li>
					<li><a class="subitem" href=""
						onclick="return retrieveCuestionary(5);">Cuestionario</a></li>
				</ul></li>
			<li><a id="repo" class="item" onclick="return enableContent(2);"
				href="">Repositorio</a></li>
				
			<li><a class="item" onclick="return enableContent(7);" href="">Ejercicios Resueltos</a></li>
			
			<li><a class="item" onclick="return enableContent(3);" href="">Evaluación
					final</a></li>
					
			<li><a class="item" href="removeSession.jsp">Salir<img width="16px"
					height="16px" src="img/logout.png" /></a></li>
		</ul>
	</div>
	<div class="content">
		<div id="home" class="hidden-content center">
			<br> <br> <br>
			<h1 class="content-title center">Introducción, Conceptos
				Básicos.</h1>
			<br>
			<p class="justify">Es importante como estudiantes de ingeniería
				desarrollar la capacidad de abstracción de problemas y aplicar
				soluciones lógicas a ellos, por ello el siguiente contenido
				proporcionará conceptos básicos a tener en cuenta para desarrollar
				el siguiente curso sobre Vectores y Matrices.</p>
			<br>
			<div id ="home-video-content">
				
			</div>
		</div>

		<div id="repository" class="hidden-content">
			<h1 class="content-title center">Repositorio de Ejercicios</h1>
			<br>
			<ol class="repo-list">
				<li class="repo-item">
					<p>Validar si una matriz es una matriz identidad. es una matriz
						cuadrada que tiene solamente 1s en la diagonal principal, y 0s por
						todas partes.</p>
					<img src="img/matriz_identidad.png">

				</li>
				<li class="repo-item">
					<p>Dada una matriz y un entero, crear dos vectores uno con lo
						menores del entero y otro con los número mayores a ese entero.</p>
				</li>
				<li class="repo-item">
					<p>Dado un vector, ordenarlo y hallar el valor medio.</p>
				</li>
				<li class="repo-item">
					<p>Dado un entero, generar un vector de tamaño del número, con
						valores de 0 a ese entero.</p>
				</li>
				<li class="repo-item">
					<p>Utilizando arrays, escribir un algoritmo que visualice un
						cuadrado mágico de orden impar n, comprendido entre 3 y 11. El
						usuario debe elegir el valor de n. Un cuadrado mágico se compone
						de números enteros comprendidos entre 1 y n. La suma de los
						números que figuran en cada fila, columna y diagonal son iguales.</p>
					<img src="img/cuadro_magico.jpg" width=178 height=180>
				</li>
				<li class="repo-item">
					<p>Escribir el algoritmo que permita obtener el número de
						elementos positivos de una tabla.</p>
				</li>
				<li class="repo-item">
					<p>Leer una matriz de 3 por 3 elementos y calcular la suma de
						cada una de sus filas y columnas, dejando dichos resultados en dos
						vectores, uno de la suma de las filas y otro de las columnas.</p>
				</li>
				<li class="repo-item">
					<p>Se dispone de una lista (vector) de N elementos. Se desea
						diseñar un algoritmo que permita insertar el valor x en el lugar
						k-ésimo de la mencionada lista.</p>
				</li>
				<li class="repo-item">
					<p>Se dispone de las notas de cuarenta alumnos. Cada uno de
						ellos puede tener una o varias notas. Escribir un algoritmo que
						permita obtener la media de cada alumno y la media de la clase a
						partir de la entrada de las notas desde el terminal.</p>
				</li>
				<li class="repo-item">
					<p>Se tiene una lista de N nombres de alumnos. Escribir un
						algoritmo que solicite el nombre de un alumno, busque en la lista
						(array) si el nombre está en la lista.</p>
				</li>
			</ol>
		</div>

		<div id="final-exam" class="hidden-content">
			<p class="home-text">Evaluación final en construcción</p>
		</div>

		<div id="theory" class="hidden-content">
			<!--  Here is going to render the video content of the platform -->
		</div>

		<div id="questions" class="hidden-content">
			<!-- Here is going to show the questions with their respective options -->
		</div>

		<div id="profile" class="hidden-content">
			<p class="home-text">Perfil del usuario en construcción</p>
		</div>
		<div id="algorithms" class="hidden-content">
			<br> <br> <br>
			<h1 class="content-title center">Ejercicios Resueltos</h1>
			<br>
			<p class="justify">
				En los siguientes ejercicios resueltos le ayudaran a leer y 
				comprender código, tenga en cuenta que la lógica de cada
				estudiante es diferente, intente entenderlos y crear su propio
				código.</p>
				<br>
			<ol class="repo-list">
				<li class="repo-item">
					<p>Dado un vector de tamaño n, decir sí la suma de sus elementos es prima.</p>
					<pre>
						<code class="java">public String primero(int[] n){
	int suma = 0; // Crear una variable llamada "suma" de tipo de datos entero(int).
	for(int i = 0;i <= n.length - 1;i++){//usar el "for" para recorrer el vector "n"
		//sumar los valores de cada posición del vector
		suma += n[i];
	}
	//preguntar si la suma obtenida es prima
	if(suma % 2 != 0){
		//si es cierto, el método finaliza dando el siguiente mensaje.
		return "Es prima";
	}
	//si no es cierto, el método finaliza dando el siguiente mensaje.
	return "No es prima";
}
						</code>
					</pre>
				</li>
				<li class="repo-item">
					<p>Dado una matriz y un entero, contar cuantas veces está el número en la matriz,</p>
					<pre>
						<code class="java">public String segundo(int[][] n,int entero){
	int contador = 0;//Se crea una variable llamada "contador" para llevar las veces
	//Se utiliza el for para recorrer la matriz en sus filas
	for(int i = 0;i <= n.length - 1;i++){
		//Se utiliza el for para recorrer la matriz en sus columnas segun la fila en donde se encuentra
		for(int j = 0;i <= n[i].length - 1;j++){
			//Verificar si esta el numero
			if(n[i][j] == entero){
				//Si esta el numero, se aumenta el contador
				contador++;
			}
		}
	}
	return "El numero esta: "+contador+" veces en la matriz";
}
						</code>
					</pre>
				</li>
				<li class="repo-item">
					<p>Crear un método que sume las filas impares de una matriz N x M.</p>
					<pre>
						<code class="java">public String tercero(int[][] n){
	int suma = 0;// Crear una variable llamada "suma" de tipo de dato entero
	//Recorrer la matriz con el for
	for(int i = 0;i <= n.length - 1;i++){
		//Solo entra en las filas impares utilizando %
		if(i % 2 != 0){
			for(int j = 0;j <= n[i].length - 1;j++){
				//Suma los valores de las posiciones en la variable suma
				suma += n[i][j];
			}
		}
	}
	return "La suma es: "+suma;
}
						</code>
					</pre>
				</li>
				<li class="repo-item">
					<p>Dado un vector de tipo entero, sacar el promedio de este.</p>
					<pre>
						<code class="java">public String cuarto(int[] n){
	int suma = 0;
	//Pasa por cada posicion del vector
	for(int i = 0;i <= n.length-1;i++){
		//Suma sus elementos
		suma += n[i];
	}
	//Crea una variable "promedio" y se aplica la formula
	double promedio = suma / n.length;
	//El metodo termina con el promedio que da
	return "El promedio es: "+ promedio;
}
						</code>
					</pre>
				</li>
				<li class="repo-item">
					<p>Dado un número buscar en una matriz todos los menores a él.</p>
					<pre>
						<code class="java">public String quinto(int numero,int[][] n){
	String cadena = "Numeros: ";//Se crea una variable de tipo cadena de caracteres
	//Recorre la matriz por sus filas
	for(int i = 0;i <= n.length - 1;i++){
		//Recorre la matriz por sus columnas
		for(int j = 0;j <= n[i].length - 1;j++){
			//Pregunta por el elemento y compara con el numero
			if(n[i][j] < numero){
				//Concatena todos los numeros menores a este
				cadena += n[i][j] + ", ";
			}
		}
	}
	return cadena;
}
						</code>
					</pre>
				</li>
				<li class="repo-item">
					<p>Dado un número, decir si el promedio de un vector es mayor a este</p>
					<pre>
						<code class="java">public String sexto(int[] n,int entero){
	int suma = 0;//Se crea una variable de tipo entero para acumular los valores
	//Recorrer y sumar los valores del vector
	for(int i = 0;i <= n.length - 1;i++){
		suma += n[i];
	}
	//Se realiza la formula del promedio
	int promedio = suma/n.length;
	//Se compara si es mayor
	if(entero > promedio){
		return "El número es mayor que el promedio del vector";
	}
	return "El número es menor que el promedio del vector";
}
						</code>
					</pre>
				</li>
				<li class="repo-item">
					<p>Crea un arreglo o array multidimensional que contiene 3 columnas y las filas que tu quieras,
						 las dos primeras columnas tendrán números y en la tercera columna será el resultado de sumar
						 el número de la primera y segunda columna.</p>
					<pre>
						<code class="java">public int[][] septimo(int numeroFilas,ArrayList<Integer> a){
	//Se crea otra matriz donde se van a realizar las operaciones
	int[][] n= new int[numeroFilas][3];
	int y = 0;//Se crea una variable de tipo entero para utilizar
	for(int i = 0;i <= n.length - 1;i++){
		for(int j = 0;j <= n[0].length - 1;j++){
			if(j == 2){
				n[i][j] = n[i][j-1]+n[i][j-2];
			}else{
				n[i][j] = a.get(y);
				y++;
			}
		}
	}
	return n;
}
						</code>
					</pre>
				</li>
				<li class="repo-item">
					<p>Dada dos matrices, realizar su multiplicación y dar una tercera resultante.</p>
					<pre>
						<code class="java">public int[][] octavo(int[][] n,int[][] m){
	int[][] result = new int[n.length][n[0].length];
	for(int i = 0;i <= n.length - 1;i++){
		for(int j = 0;j <= n[i].length - 1;j++){
			result[i][j] = n[i][j] * m[i][j];
		}
	}
	return result;
}
						</code>
					</pre>
				</li>
			</ol>
		</div>
		<div id="message" class="animated fadeIn alert ">
			<p class="alert-message center"> Este es un mensaje</p>
		</div>
		
	</div>
	
	<script src="js/view-controller.js"></script>
	<script src="js/validator.js"></script>
	<script src="js/highlight.pack.js"></script>
	<script>hljs.initHighlightingOnLoad();</script>
</body>

</html>