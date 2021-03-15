function init() {
    /*
     * eseguita nell'onload del body, per cui dopo che sono stati caricati 
     * tutti gli oggetti nel document
     */
    /*
     * l'evento del click lo descrivo qui e non nel button per pulizia e sicurezza
     */
    document.querySelector("#btnlogin").addEventListener("click", welcome);
    msg = "";
    let select = document.getElementById("idt");
    select.innerHTML = "";
    for (p of posts) {
        let option = document.createElement("option");
        option.text = p.title;
        option.value = p.id;
        select.appendChild(option);
    }
    /* 
     vecchio modo
     for (i = 0; i < posts.length; i++) {
     p = posts[i];
     msg += '<option value="' + p.id + '">' + p.title + '</option>';
     }
     document.querySelector("#idt").innerHTML = msg;
     */
}


function welcome() {
    /*
     * let crea un variabile locale
     * in genere si evita di creare variabili globali perchè 
     * se si caricano script esterni che usano una variabile globale con lo 
     * stesso nome, lo script non funziona
     */
    let c = document.getElementById("cognome"); // vecchio modo
    let n = document.querySelector("#nome"); // nuovo modo, ritorna un array di un solo elemento
    let ct = c.value;
    let nt = n.value;
    let msg;
    if (document.getElementById("cognome").value === "" || nt === "") {
        msg = "Compilare i campi richiesti";
        c.value = "";
        n.value = "";

    } else {
        msg = "Benvenuto " + n.value + " " + c.value;
    }
    document.querySelector("#msg").innerHTML = msg; // scrive nel div 

}

