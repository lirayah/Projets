let bouton;
window.onload = function() {
    bouton = document.getElementById("haut");
    bouton.style.display = "none";
}

window.onscroll= function() {descente()};

function descente(){
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        bouton.style.display = "block";
    }
    else {
        bouton.style.display = "none";
    }
}

function EnHaut(){
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
    bouton.style.display = "none";
}