<?=validation_errors(); ?>
<?=form_open('user/login')?>
<?php if (isset($erreur)) {
    echo $erreur;
}
?>
<div class="grid">
    <label for="login">Login
    <input type="login" id="login" name="login" placeholder="Login" value="<?=set_value('login')?>" required>
    </label>
</div>
<div class="grid">
    <label for="password">Password
        <input type="password" id="password" name="password" placeholder="Password" value="<?=set_value('password')?>" required>
    </label>
</div>

<div class="grid">
    <button type="submit">Submit</button>
    <?=anchor('/user/create',"Vous n'avez pas de compte ?",['role'=>'button'])?>
</div>

</form>