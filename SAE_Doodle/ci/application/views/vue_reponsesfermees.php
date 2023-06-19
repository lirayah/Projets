<?=form_open("/answer?cle=".$data[0]['cleSondage'])?>
<div>
    <h1><?php echo $data[0]['titre']?></h1>
    <h3>Lieu : <?php echo $data[0]['lieu']?></h3>
    <h5>Descriptif: <?php echo $data[0]['descriptif']?></h5>
    <br/>
    Ce sondage a été fermé par l'organisateur, vous ne pouvez plus y répondre.<br/><br/>
    <?=anchor("/","Retourner à l'accueil",['role'=>'button'])?>
</div>
