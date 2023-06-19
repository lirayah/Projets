<?=validation_errors(); ?>
<?=form_open('/sondage/modifier?cle='.$infos[0]['cleSondage'])?>

<h3>Modifier votre sondage</h3>
<div>
    <?php
        echo "<u>Titre actuel</u>: ".$infos[0]['titre']."<br/>";
        echo "<u>Lieu actuel</u>: ".$infos[0]['lieu']."<br/>";
        echo "<u>Descriptif actuel</u>: ".$infos[0]['descriptif']."<br/>";
        echo "<br/><br/>"
    ?>
    <div>
        <label for="Titre">
            Titre
            <input type="text" name="titre" id="titre" placeholder="Titre" value="<?=set_value('titre')?>" required>
        </label>
    </div>
    <div>
        <label for="Lieu">
            Lieu
            <input type="text" name="lieu" id="lieu" placeholder='Lieu' value="<?=set_value('lieu')?>" required>
        </label>
    </div>
    <div>
        <label for="Description">
            Description
            <textarea name="descriptif" id="descriptif" placeholder='Descriptif' value="<?=set_value('descriptif')?>" required></textarea>
        </label>
    </div>

    <button type="submit">Submit</button>
</div>