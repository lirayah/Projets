<?=validation_errors(); ?>
<?=form_open('/sondage/create')?>

<h3>Créer un sondage</h3>
<div>
    <div>
        <label for="Titre">
            Titre
            <input type="text" name="titre" id="titre" placeholder="Titre" value="<?=set_value('titre')?>" required>
        </label>
    </div>
    <div>
        <label for="Lieu">
            Lieu
            <input type="text" name="lieu" id="lieu" placeholder="Lieu" value="<?=set_value('lieu')?>" required>
        </label>
    </div>
    <div>
        <label for="Description">
            Description
            <textarea name="descriptif" id="descriptif" placeholder="Description" value="<?=set_value('descriptif')?>" required></textarea>
        </label>
    </div>
    <div id="dateid">
        <label for="date">
            Date
            <input type="datetime-local" class="date-btn" name="dates[]" id="dates" value="<?=set_value('dates[]')?>" required>
            <button type="button" id="add">Ajouter une date et heure</button>
        </label>
    </div>

    <button type="submit">Submit</button>
</div>
<script>
    document.getElementById('add').addEventListener('click', function() {
        var div = document.createElement('div');
        div.innerHTML = `
        <label for="date">
        Date
        <input type="datetime-local" class="date-btn" name="dates[]" value="<?=set_value('dates[]')?>" required>
        <button type="button" class="remove">Supprimer la date</button>
        </label>
        `;
        var addButton = document.getElementById('add');
        addButton.parentNode.insertBefore(div, addButton);
    });

    document.addEventListener('click', function(e) {
    if (e.target && e.target.classList.contains('remove')) {
        e.target.parentNode.parentNode.remove();
    }
    });
</script>