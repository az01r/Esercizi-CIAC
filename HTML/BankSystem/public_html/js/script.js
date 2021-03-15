function init() {
    /*
     * eseguita nell'onload del body, per cui dopo che sono stati caricati 
     * tutti gli oggetti nel document
     */
    /*
     * l'evento del click lo descrivo qui e non nel button per pulizia e sicurezza
     */
    document.querySelector("#btnCarica").addEventListener("click", carica);
    msg = "";
    /*
     let select = document.getElementById("idt");
     select.innerHTML = "";
     for (p of posts) {
     let option = document.createElement("option");
     option.text = p.title;
     option.value = p.id;
     select.appendChild(option);
     }*/
}

function carica() {
    url = 'https://gugudesign.it/sapere/?getCustomerTransaction';
    fetch(url)
            .then(response => response.json())
            .then(function (dati) {
                msg = "";
                msg = dati[0].nome + " " + dati[0].cognome;
                ris = document.querySelector("#dresult");
                ris.innerHTML = msg;
            });
}