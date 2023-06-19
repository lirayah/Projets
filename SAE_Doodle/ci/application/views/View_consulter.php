<?=validation_errors(); ?>
<?php
    echo "<h1>".$array[0][0]['titre']."</h1>";
    echo "<h6>".$array[0][0]['descriptif']."</h6>";
    echo "Lieu : ".$array[0][0]['lieu']."<br/>";
    if ($array[0][0]['open']==1){
        echo "Statut : Ouvert<br/>";
    }
    else {
        echo "Statut : Fermé<br/>";
    }

    $cetteCle=$this->input->get('cle');
    echo "<br/><u><b>Voici le lien à partager pour répondre au sondage:</b></u><br/>";
    echo "<a href=\"../answer?cle=".$cetteCle."\">http://dwarves.iut-fbleau.fr/~proal/PHP/SAE2.02/ci/index.php/answer?cle=".$cetteCle."</a><br/><br/><br/>";
    
    echo "<u><b>Votes:</b></u><br/>";
    foreach ($array[1] as $date){
        echo $date['dates']." -> ".$date['votes'].'<br/>';
    }


    $nomprecedent="";
    $prenomprecedent="";
    foreach($array[2] as $data){
        if ($prenomprecedent!=$data['Prenom'] or $nomprecedent!=$data['Nom']){
            echo '<br/><br/><br/><br/>';
            echo "<u>".$data['Nom']." ".$data['Prenom']."</u>";
            $prenomprecedent=$data['Prenom'];
            $nomprecedent=$data['Nom'];
        }
        print_r('<br/>');
        print_r($data['dates']);
    }
?>
<br/><br/><br/><br/><br/><br/>
<div class='grid'>
    <?=anchor("/sondage/modifier?cle=".$cetteCle,"Modifier le sondage",['role'=>'button'])?>

    <?php if ($array[0][0]['open']==1):?>
    <?=anchor("/sondage/fermeture?cle=".$cetteCle,"Clore le sondage",['role'=>'button'])?>
    <?php else:?>
    <?=anchor("/sondage/ouverture?cle=".$cetteCle,"Rouvrir le sondage",['role'=>'button'])?>
    <?php endif;?>
    
    <?=anchor("/sondage/suppression?cle=".$cetteCle,"Supprimer le sondage",['role'=>'button'])?>
</div>