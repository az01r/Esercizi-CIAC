var loggedUser;
function init() {
    /*
     * eseguita nell'onload del body, per cui dopo che sono stati caricati 
     * tutti gli oggetti nel document
     * NB l'evento del click lo descrivo qui e non nel button per pulizia e sicurezza
     */
    document.querySelector("#btnCarica").addEventListener("click", caricaTransaction);
    document.querySelector("#btnLogin").addEventListener("click", login);
    document.querySelector("#btnAddTransaction").addEventListener("click", addTransaction);

}

function carica() {
    url = 'https://gugudesign.it/sapere/?getCustomerTransaction';
    fetch(url)
            .then(response => response.json())
            .then(function (dati) {
                msg = "";
                for (i = 0; i < dati.length; i++) {
                    msg += i + ") nominativo: " + dati[i].cognome + " " + dati[i].nome + " saldo: " + dati[i].amount + "<br>";
                }
                ris = document.querySelector("#dResult"); // #id_oggetto seleziona l'oggetto 
                ris.innerHTML = msg;
            });
}

function login() {
    let url = "https://gugudesign.it/sapere/?login"; // let inizializza una varuabile locale
    let usr = document.querySelector("#usr").value;
    let pwd = document.querySelector("#pwd").value;
    let f = document.querySelector('#fLogin');
    let formData = new FormData(f);
    /*
     let formData = new FormData();
     formData.append('usr',usr); // usr tra apici è il nome che diamo al parametro, usr senza apici è il valore
     formData.append('pwd',pwd);
     */
    fetch(url, {
        method: 'POST',
        body: formData
    })
            .then(response => response.json()
            )
            .then(function (json) {
                let divOut = document.querySelector("#dResult");
                if (json.hasOwnProperty("token")) { // loggato
                    let html = "";
                    let msg = json.login;
                    let token = json.token;
                    let record = json.items[0]; // arriva un array da 0 o 1 record
                    loggedUser = record;
                    html += visJSONobj(record);
                    sessionStorage.setItem("id_user", record); // oggetto globale
                    sessionStorage.setItem("id_account", record.id_account);
                    sessionStorage.setItem("token", token);
                    divOut.innerHTML = html;
                    let msgLoguser = "Benvenuto " + loggedUser.nome.toUpperCase() + " " + loggedUser.cognome.toUpperCase()
                            + "<br>Conto n° " + loggedUser.id_account.toUpperCase();
                    document.querySelector("#logUser").innerHTML = msgLoguser;
                    document.querySelector("#dLogin").style.display = "none"; // NB quello che abbiamo fatto nelle righe precendenti diventa quindi inutile 
                    document.querySelector("#dBank").style.display = "block"; // NB quello che abbiamo fatto nelle righe precendenti diventa quindi inutile 

                } else {
                    sessionStorage.clear();
                    //html = "LOGIN ERRATA!!!";
                    //divOut.innerHTML = html;
                }
                document.querySelector("#dLoginMsg").innerHTML = json.login;
            })
            .catch(error => {
                console.log("Errore durante fetch:" + error);
            });
}

function entra() {
    if (sessionStorage.getItem("id_user") !== "") {
        document.querySelector("#fLogin").style.display = "none";
        document.querySelector("#dAccount").style.display = "block";
    } else
    {
        document.querySelector("#fLogin").style.display = "block";
        document.querySelector("#dAccount").style.display = "none";
    }
}

function addTransaction() {
// sdafsfsdfsdf.it/getGPSposition.php?city=ivrea&reg=piemonte
    url = "https://gugudesign.it/sapere/?addTransaction/";
    let id_account = sessionStorage.getItem("id_account");
    let amount = document.querySelector("#amount").value;
    let formData = new FormData();
    formData.append('id_account', id_account);
    formData.append('amount', amount);
    const myHeaders = new Headers({
        'Content-Type': 'application/json',
        'Authorization': sessionStorage.get("token")
    });
    fetch(url, {
        method: 'POST', /*get(in chiaro) o post(per dati sensibili)*/
        body: formData,
    }
    )
            .then(response =>
                response.json()
            )
            .then(function (json) {

                divout = document.querySelector("#dResult");
                html = "";
                for (let j in json) {
                    html += visJSONobj(json[j]);
                }
                if (html === "")
                    html = "LOGIN ERRATA!!!";
                divout.innerHTML = html;
                caricaTransaction();
            })
            .catch(error => {
                console.log("Errore durante fetch:" + error);
            });
}

function caricaTransaction() {
    let id = sessionStorage.getItem("id_account");
    url = "https://gugudesign.it/sapere/?getCustomerTransaction/"+id;
    fetch(url)
            .then(response => response.json())
            .then(function (dati) {
                msg = "";
                for (let i = 0; i < dati.length; i++) {
                    msg += (i + 1) + ") nominativo: "
                            + dati[i].cognome + " " + dati[i].nome + " importo="
                            + dati[i].amount + " in data " + dati[i].date_transaction
                            + "<br>";
                }
                ris = document.querySelector("#dResult");
                ris.innerHTML = msg;
            });
}
