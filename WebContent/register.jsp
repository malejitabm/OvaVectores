<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Vectores</title>
<link rel="icon" type="image/ico" href="img/vectores-logo.ico">
<link href="https://fonts.googleapis.com/css?family=Oxygen:300,400,700"
	rel="stylesheet">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="wrap">
		<header class="header grey-background">
			<img class="header-img" width="103" height="60"
				src="img/vectores-logo.png">
		</header>
		<div class="register-form cloud-background">
			<h1 class="register-title">Regístrate</h1>
			<form onsubmit="verifyRegisterInfo()">
				<div class="center asbestos-text">
					<input id="codigo" class="register-field" type="text" placeholder="Código" name="id"/>
				</div>
				<div class="center asbestos-text">
					<input id="nombre" class="register-field" type="text" placeholder="Nombre" name="name"/>
				</div>
				<div class="center asbestos-text">
					<input id="pass1" class="register-field" type="password" placeholder="Contraseña" name="password1"/>
				</div>
				<div class="center password asbestos-text">
					<input id="pass2" class="register-field" type="password" placeholder="Confirmar Contraseña" name="password2"/>
				</div>
				<div class="center">
					<button class="login-button" type="submit" value="Registrar">Registrar</button>
				</div>
			</form>
		</div>
		<div id="message"></div>
	</div>
	<footer class="footer grey-background">
		<p
			style="color: white; text-align: center; padding: 20px; font-weight: lighter;">
			Universidad Francisco de Paula Santander<br>
			<br> Daniel Vega Santos - Alejandra Bohorquez<br>
			<br> &copy; 2016
		</p>
	</footer>
	<script src="js/validator.js" charset="utf-8"></script>
</body>
</html>