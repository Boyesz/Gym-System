<!DOCTYPE html>
<html>
<head> <title>E-ticket</title> 
<link rel="stylesheet" type="text/css" href="gymregistration.css">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<style>
@import url('https://fonts.googleapis.com/css?family=Fresca');
@import url('https://fonts.googleapis.com/css?family=Indie Flower');
@import url('https://fonts.googleapis.com/css?family=Bellefair');

</style>
</head>
<body>

<div>
</div>

<div class="head , to-mid">
<a href="index.html">F�oldal</a>
<a href="https://www.facebook.com/MyPass-446124199089225/">Facebook</a>
<a href="contact.html">Kapcsolat</a>
</div>
<div id="mySidenav" class="sidenav">
  <a href="#" id="about">About</a>
  <a href="#" id="blog">Blog</a>
  <a href="#" id="projects">Projects</a>
  <a href="#" id="contact">Contact</a>
</div>
<div class="full-mid">
<div class="mytitle">Konditerem Regisztráció</div>

<div class="to-mid">
<form class="login" action="/gym/addGym" method="POST">
<a class="adatok"> Felhasználónév </a><br><br>
  <form:label class="adatok" path = "name">Felhasználónév</form:label>
  <form:input path = "name" />
<input class="doboz" type="text" name="Name" /><br><br>
<a class="adatok"> Jelszó </a><br>
<input class="doboz" type="password" name="Password" /><br><br>
<a class="enlink" href="">Elfelejtett jelsz�?</a><br><br>
<input class="gomb" type="submit" class="butn" value="Bejelentkez�s" /><br><br>
</form></div></a>
</div>
</div>

<div class="foot to-mid">
<a target="_blank">E-ticket 2017 All rights reserved.</a>

</div>


</body>
</html>