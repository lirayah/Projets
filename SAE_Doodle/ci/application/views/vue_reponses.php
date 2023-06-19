<?=form_open("/answer?cle=".$data[0]['cleSondage'])?>
<div>
    <h1><?php echo $data[0]['titre']?></h1>
    <h3>Lieu : <?php echo $data[0]['lieu']?></h3>
    <h5>Descriptif: <?php echo $data[0]['descriptif']?></h5>
    <div>
        <label for="Nom">
            Nom
            <input type="text" name="nom" id="nom" placeholder="Nom" value="<?=set_value('nom')?>" required>
        </label>
    </div>
    <div>
        <label for="Prenom">
            Prénom
            <input type="text" name="prenom" id="prénom" placeholder="Prénom" value="<?=set_value('prenom')?>" required>
        </label>
    </div>

    <?php
    foreach ($data as $dadata) {
        $date = new DateTime($dadata['dates'],new DateTimeZone('UTC'));
        echo "<input type='checkbox' name='dates[]' id='dates' value=".strtotime($dadata['dates']).">".$date->format('d-m-Y h:i T')."<br>";
    }
    ?>
    <br>
    <button type="submit">Submit</button>

</div>