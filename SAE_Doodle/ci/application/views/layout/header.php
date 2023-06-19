<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<title>Doodle du pauvre</title>
		<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@1.*/css/pico.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<?=link_tag('assets/style.css')?>
	</head>
	<body>
		<?php if(isset($this->session->logged['logged_in'])):?>
		<?=anchor('/user/login/destroy','Se deconnecter',['role'=>'button'])?>
		<?=anchor('/consulter/profil','Allez au profil',['role'=>'button'])?>
		<?php else:?>
		<?=anchor('/','Accueil',['role'=>'button'])?>
		<?php endif;?>
		<main class="container">
