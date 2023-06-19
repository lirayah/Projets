<?=validation_errors(); ?>
<?=form_open('user/create')?>
<?php if (isset($erreur)) {
  echo $erreur;
}
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
      <?=anchor('/user/login',"Vous avez déjà un compte ?",['role'=>'button'])?>
  </div>
</form>
