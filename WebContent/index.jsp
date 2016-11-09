<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Vectores</title>
<link rel="icon" type="image/ico" href="img/vectores-logo.ico">
<link href="https://fonts.googleapis.com/css?family=Oxygen:300,400,700"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%
		if(session.getAttribute("user") != null){
			response.sendRedirect("home.jsp");
			return;
		}
	%>
	<div class="wrap">
		<header class="header grey-background">
			<img class="header-img" width="103" height="60"
				src="img/vectores-logo.png">
		</header>
		<div class="login cloud-background">
			<h1 class="register-title">Bienvenido</h1>
			<form action="login" method="post">
				<div class="center asbestos-text">
					<input class="register-field" type="text" placeholder="Código" name="id" />
				</div>
				<div class="center asbestos-text">
					<input class="login-field" type="password" placeholder="Contraseña" name="password"/>
				</div>
				<div class="center register">
					<a class="register-link" href="register.jsp">¿Aún no estas
						registrado?</a>
				</div>
				<div class="center">
					<button class="login-button" type="submit" value="Iniciar Sesión">Iniciar
						Sesión</button>
				</div>
			</form>
		</div>
		<div class="como-container navy-background">
			<p class="how-text">¿Cómo funciona?</p>

			<div class="number-text">
				<div class="circle a-clockwork-orange"
					style="display: inline-block;">
					<p class="number">1</p>
				</div>
				<p class="instruction">Registrate al Ova, llenando unos cuantos
					datos</p>
			</div>

			<div class="number-text">
				<div class="circle a-clockwork-orange"
					style="display: inline-block;">
					<p class="number">2</p>
				</div>
				<p class="instruction">Ingresa a la platafoma</p>
			</div>

			<div class="number-text">
				<div class="circle a-clockwork-orange"
					style="display: inline-block;">
					<p class="number">3</p>
				</div>
				<p class="instruction">Elige libremente que tema quieres
					reforzar</p>
			</div>

			<div class="number-text">
				<div class="circle a-clockwork-orange"
					style="display: inline-block;">
					<p class="number">4</p>
				</div>
				<p class="instruction">
					Y...<span style="text-decoration: underline;">diviertete</span>
					aprendiendo!
				</p>
			</div>

		</div>

		<div class="infoobj-container cloud-background">

			<div class="info">
				<p class="title">Información Adicional</p>
				<ul style="padding-left: 30px;">
					<li class="obj-item">
						<p>
							<b>El tema:</b> Vectores y Matrices para Fundamentos de
							Programación
						</p>
					</li>
					<li class="obj-item">
						<p>
							<b>Propósitos o necesidad educativa a satisfacer:</b> Que el
							estudiante tenga las suficientes competencias para la utilización
							adecuada de la estructura de datos en la resolución<br> de
							problemas lógicas y matemáticas.
						</p>
					</li>
					<li class="obj-item">
						<p>
							<b>Público objetivo:</b> estudiantes de Ingeniería de Sistemas y
							electrónica de la<br> Universidad Francisco de Paula
							Santander.
						</p>
					</li>
				</ul>
			</div>
			<div class="obj">
				<p class="title">Objetivos</p>
				<ul style="padding-left: 20px;">
					<li class="obj-item">
						<p>Dar descripción y explicación de los temas relacionados con
							los Array unidimensionales y multidimensionales a los estudiantes
							que ingresen al OVA.</p>
					</li>
					<li class="obj-item">
						<p>Mostrar Ejemplos descriptivos al estudiante para mejor
							comprensión del tema.</p>
					</li>
					<li class="obj-item">
						<p>Proporcionar actividades evaluativas de los temas que el
							OVA da a conocer.</p>
					</li>
					<li class="obj-item">
						<p>Proporcionar informes de los resultados de la solución de
							actividades evaluativas de los temas que el OVA proporciona al
							estudiante.</p>
					</li>
					<li class="obj-item">
						<p>Proporciona un repositorio de ejercicios resueltos y no
							resueltos para que el estudiante pueda practicar y reforzar los
							conocimientos.</p>
					</li>
				</ul>
			</div>

		</div>
	</div>
	<footer class="footer grey-background">
		<p
			style="color: white; text-align: center; padding: 20px; font-weight: lighter;">
			Universidad Francisco de Paula Santander<br>
			<br> Daniel Vega Santos - Alejandra Bohorquez<br>
			<br> &copy; 2016
		</p>
	</footer>
</body>
</html>