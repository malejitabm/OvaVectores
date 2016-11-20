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
			<li><a class="item" href="" onclick="return enableContent(1);">Inicio</a>
			</li>
			<li><a class="item" href="" onclick="return enableSubItem(1);">Inicializaci�n</a>
				<ul class="hidden-menu">
					<li><a class="subitem" href=""
						onclick="return enableContent(4);">Contenido Te�rico</a></li>
					<li><a class="subitem" href=""
						onclick="return enableContent(5);">Cuestionario</a></li>
				</ul></li>
			<li><a class="item" href="" onclick="return enableSubItem(2);">Recorrido</a>
				<ul class="hidden-menu">
					<li><a class="subitem" href=""
						onclick="return enableContent(4);">Contenido Te�rico</a></li>
					<li><a class="subitem" href=""
						onclick="return enableContent(5);">Cuestionario</a></li>
				</ul></li>
			<li><a class="item" href="" onclick="return enableSubItem(3);">Asignaci�n</a>
				<ul class="hidden-menu">
					<li><a class="subitem" href=""
						onclick="return enableContent(4);">Contenido Te�rico</a></li>
					<li><a class="subitem" href=""
						onclick="return enableContent(5);">Cuestionario</a></li>
				</ul></li>
			<li><a class="item" href="" onclick="return enableSubItem(4);">Busqueda
					de elementos</a>
				<ul class="hidden-menu">
					<li><a class="subitem" href=""
						onclick="return enableContent(4);">Contenido Te�rico</a></li>
					<li><a class="subitem" href=""
						onclick="return enableContent(5);">Cuestionario</a></li>
				</ul></li>
			<li><a class="item" href="" onclick="return enableSubItem(5);">Algoritmos
					de ordenamiento</a>
				<ul class="hidden-menu">
					<li><a class="subitem" href=""
						onclick="return enableContent(4);">Contenido Te�rico</a></li>
					<li><a class="subitem" href=""
						onclick="return enableContent(5);">Cuestionario</a></li>
				</ul></li>
			<li><a id="repo" class="item" onclick="return enableContent(2);"
				href="">Repositorio</a></li>
			<li><a class="item" onclick="return enableContent(3);" href="">Evaluaci�n
					final</a></li>
			<li><a class="item" href="removeSession.jsp">Salir<img width="16px"
					height="16px" src="img/logout.png" /></a></li>
		</ul>
	</div>
	<div class="filler"></div>

	<div id="home" class="hidden-content center">
		<br>
		<br>
		<br>
		<h1 class="content-title center">Introducci�n, Conceptos B�sicos.</h1>
		<br>
		<p class="justify">Es importante como estudiantes de ingenier�a desarrollar la
			capacidad de abstracci�n de problemas y aplicar soluciones l�gicas a
			ellos, por ello el siguiente contenido proporcionar� conceptos
			b�sicos a tener en cuenta para desarrollar el siguiente curso sobre
			Vectores y Matrices.</p>
		<br>
		<iframe width="470" height="402"
			src="http://edpuzzle.com/embed/media/582a8f7774b4fef43e81229f"
			frameborder="0" allowfullscreen></iframe>
	</div>

	<div id="repository" class="hidden-content">
		<h1 class="content-title center">Repositorio
			de Ejercicios</h1>
			<br>
		<ol class="repo-list">
			<li class="repo-item">
				<p>Validar si una matriz es una matriz identidad. es una matriz
					cuadrada que tiene solamente 1s en la diagonal principal, y 0s por
					todas partes.</p><img src="img/matriz_identidad.png">

			</li>
			<li class="repo-item">
				<p>Dada una matriz y un entero, crear dos vectores uno con lo
					menores del entero y otro con los n�mero mayores a ese entero.</p>
			</li>
			<li class="repo-item">
				<p>Dado un vector, ordenarlo y hallar el valor medio.</p>
			</li>
			<li class="repo-item">
				<p>Dado un entero, generar un vector de tama�o del n�mero, con
					valores de 0 a ese entero.</p>
			</li>
			<li class="repo-item">
				<p>Utilizando arrays, escribir un algoritmo que visualice un
					cuadrado m�gico de orden impar n, comprendido entre 3 y 11. El
					usuario debe elegir el valor de n. Un cuadrado m�gico se compone de
					n�meros enteros comprendidos entre 1 y n. La suma de los n�meros
					que figuran en cada fila, columna y diagonal son iguales.</p><img src="img/cuadro_magico.jpg" width=178 height=180>
			</li>
			<li class="repo-item">
				<p>Escribir el algoritmo que permita obtener el n�mero de
					elementos positivos de una tabla.</p>
			</li>
			<li class="repo-item">
				<p>Leer una matriz de 3 por 3 elementos y calcular la suma de
					cada una de sus filas y columnas, dejando dichos resultados en dos
					vectores, uno de la suma de las filas y otro de las columnas.</p>
			</li>
			<li class="repo-item">
				<p>Se dispone de una lista (vector) de N elementos. Se desea
					dise�ar un algoritmo que permita insertar el valor x en el lugar
					k-�simo de la mencionada lista.</p>
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
					(array) si el nombre est� en la lista.</p>
			</li>
		</ol>
	</div>

	<div id="final-exam" class="hidden-content">
		<p class="home-text">Evaluaci�n final en construcci�n</p>
	</div>

	<div id="theory" class="hidden-content">
		<video id="video-content" width="640px" height="480px" controls>
			<source src="video/ini-vectores.mp4" type="video/mp4" />
			<p class="home-text">La reproducci�n de video no se encuentra disponible en tu navegador</p>
		</video>
	</div>
	<div id="questions" class="hidden-content">
		<pre>
<code class="java">public static void main(String[] args){
	System.out.println("Hello World using Highlight.js!!!");
}</code>
		</pre>
	</div>
	
	<div id="profile" class="hidden-content">
		<p class="home-text">Perfil del usuario en construcci�n</p>
	</div>
	<script src="js/view-controller.js"></script>
	<script src="js/highlight.pack.js"></script>
	<script>hljs.initHighlightingOnLoad();</script>
</body>

</html>