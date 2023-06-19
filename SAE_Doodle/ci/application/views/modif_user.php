<?=validation_errors(); ?>
<?=form_open('user/modifier')?>
<?php if (isset($erreur)) {
  echo $erreur;
}
?>
<h2>Modifier votre profil</h2>
<?php
        echo "<u>Login actuel</u>: ".$infos[0]['login']."<br/>";
        echo "<u>Nom actuel</u>: ".$infos[0]['nom']."<br/>";
        echo "<u>Prenom actuel</u>: ".$infos[0]['prenom']."<br/>";
        echo "<u>Email actuel</u>: ".$infos[0]['email']."<br/>";
        echo "<br/><br/>"
?>
<div class="grid">
	<label for="prenom">
    Prénom
    <input type="text" id="prenom" name="prenom" placeholder="Prénom" value="<?=set_value('prenom')?>"required>
	</label>

	  <label for="nom">
      Nom 
      <input type="text" id="nom" name="nom" placeholder="Nom" value="<?=set_value('nom')?>" required>
	  </label>
  </div>
  <div>
    <label for="login">
        Login
        <input type="text" id="login" name="login" placeholder="Login" value="<?=set_value('login')?>" required>
    </label>
</div>
  
  <label for="email">Adresse mail</label>
  <input type="email" id="email" name="email" placeholder="Email" value="<?=set_value('email')?>" required>

<div class="grid">
  <label for="password">Password
  <input type="password" id="password" name="password" placeholder="Password" value="<?=set_value('password')?>" required>
</label>

<label for="password">Confirmation password
  <input type="password" id="cpassword" name="cpassword" placeholder="Password" value="<?=set_value('cpassword')?>" required>
</label>

</div>
  <div class="grid">
    <button type="submit">Submit</button>
  </div>
</form>
