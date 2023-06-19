<?=validation_errors(); ?>

<?php
    echo "<h1>".$this->session->logged['login']."</h1>";
?>
    <?=anchor('/sondage/create',"Créer un sondage",['role'=>'button'])?>
    <?=anchor('/user/modifier',"Modifier profil",['role'=>'button'])?>
    <br/><br/><br/><br/><br/>
    <h2><u>Vos sondages :</u></h2>
<?php
    foreach($infos as $data){
        echo "<h4>".$data['titre']." --> <a href=\"../consulter/regarder?cle=".$data['cleSondage']."\"<button type=\"button\">Consulter</button></a></h4><br/><br/>";
    }

?>