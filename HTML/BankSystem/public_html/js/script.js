var loggedUser;

function init() {
    /* eseguita nell'onload del body per cui dopo che 
     * sono stati caricati tutti gli oggetti nel document
     */
    document.querySelector("#bcarica").addEventListener('click', caricaTransaction);
    document.querySelector("#blogin").addEventListener('click', login);
    document.querySelector("#baddTransaction").addEventListener('click', addTransaction);
    /* let select = document.getElementById("idt");
     select.innerHTML = "";
     for (p of posts) {
     
     let option = document.createElement("option");
     option.text = p.title;
     option.value = p.id;
     select.appendChild(option);
     }
     */
}
function login() {
    let url = "https://gugudesign.it/sapere/?login";
    let usr = document.querySelector("#usr").value;
    let pwd = document.querySelector("#pwd").value;
    let f = document.querySelector("#flogin");
    let formData = new FormData(f);
   
    fetch(url, {
        method: 'POST',
        body: formData
    })
            .then(response =>
                response.json()
            )
            .then(function (json) {
                if (json.hasOwnProperty("token")) { //loggato
                    let divout = document.querySelector("#dresult");
                    let html = "";
                    let token = json.token;
                    let record = json.items[0];
                    loggedUser=record;
                    html += visJSONobj(record);
                    sessionStorage.setItem("id_user", record.id);
                    sessionStorage.setItem("id_account", record.id_account);
                    sessionStorage.setItem("token", token);
                    divout.innerHTML = html;
                    let msgloguser="Benvenuto " + loggedUser.nome.toUpperCase() + " " + loggedUser.cognome.toUpperCase() 
                            + "<br>conto n° " + loggedUser.id_account;
                    document.querySelector("#loguser").innerHTML=msgloguser;

                    document.querySelector("#dlogin").style.display="none";
                    document.querySelector("#dbank").style.display="block";
                } else {
                    sessionStorage.clear();
                    document.querySelector("#dlogin").style.display="block";
                    document.querySelector("#dbank").style.display="none";
                }
                document.querySelector("#dloginmsg").innerHTML = json.login;
            })
            .catch(error => {
                console.log("Errore durante fetch:" + error);
            })
}
function entra() {
    if (sessionStorage.getItem("id_user") != "") {
        document.querySelector("#flogin").style.display = "none";
        document.querySelector("#daccount").style.display = "block";
    } else
    {
        document.querySelector("#flogin").style.display = "block";
        document.querySelector("#daccount").style.display = "none";
    }


}
function addTransaction() {
    //   sdafsfsdfsdf.it/getGPSposition.php?city=ivrea&reg=piemonte
    url = "https://gugudesign.it/sapere/?addTransaction";
    let id_account = sessionStorage.getItem("id_account");
    let amount = document.querySelector("#amount").value;
    let formData = new FormData();
    formData.append('id_account', id_account);
    formData.append('amount', amount);
      

    fetch(url, {
        method: 'POST',
        body: formData,
        
    }
    )
            .then(response =>
                response.json()
            )
            .then(function (json) {
               if (json.hasOwnProperty("add"))
                caricaTransaction();
            })
            .catch(error => {
                console.log("Errore durante fetch:" + error);
            })

}
function caricaTransaction() {
    let id = sessionStorage.getItem("id_account");
    url = "https://gugudesign.it/sapere/?getCustomerTransaction/" + id;
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
                ris = document.querySelector("#dresult");
                ris.innerHTML = msg;
            });
}






