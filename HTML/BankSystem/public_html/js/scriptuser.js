/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function inituser() {

    if (sessionStorage.getItem("token"))
    {
        getInfouser();
    } else {
        sessionStorage.clear();
        window.location.href = "home.html";
    }



}

function getInfouser() {
    let id = sessionStorage.getItem("id");
    let url = "https://pwbanksystem.tssdev.it/resources/users/" + id;
    fetch(url, {
        method: 'GET',
        headers: {
            'Authorization': "Bearer " + sessionStorage.getItem("token"),
            'Accept': 'application/json',
            'Content-Type': 'application/json'}
    }).then(response =>
        response.json()
    ).then(function (infouser) {
        if (infouser != "") {
            let w = "Welcome <span class='usr'>" + infouser.fname + " " + infouser.lname + "</span>";
            document.querySelector('#hwelcome').innerHTML = w;

            let info = document.querySelector('#info_user');
            html = "<h3>Profilo Utente<h3><hr>" + infouser.lname + " " 
                    + infouser.fname + "<br>" + infouser.email;
            info.innerHTML = html.toUpperCase();
            return true;
        }
    }).then(ok => getInfouserAccount()
    ).catch(error => {
        console.log("Errore durante fetch:" + error);
    })


}

function getInfouserAccount() {
    let id = sessionStorage.getItem("id");
    let url = "https://pwbanksystem.tssdev.it/resources/users/" + id + "/accounts";
    fetch(url, {
        method: 'GET',
        headers: {
            'Authorization': "Bearer " + sessionStorage.getItem("token"),
            'Accept': 'application/json',
            'Content-Type': 'application/json'}
    }).then(response =>
        response.json()
    ).then(function (infoaccounts) {
        if (infoaccounts != "") {
            let divinfo = document.querySelector('#info_accounts');
            let total = infoaccounts.total;
            let data = infoaccounts.data;
            for (obj of data) {
                let idaccount = obj.id;
                let opt = document.createElement("option");
                opt.value = idaccount;
                opt.innerHTML = "# " + idaccount + " [balance &euro;" + obj.balance + "]"; // whatever property it has
                document.querySelector('#selidaccount').appendChild(opt);
            }
            getInfouserAccountTransaction();
        }
    }).catch(error => {
        console.log("Errore durante fetch:" + error);
    })


}

function getInfouserAccountTransaction() {
    let id = document.querySelector("#selidaccount").value;
    let url = "https://pwbanksystem.tssdev.it/resources/accounts/" + id + "/transactions";
    fetch(url, {
        method: 'GET',
        headers: {
            'Authorization': "Bearer " + sessionStorage.getItem("token"),
            'Accept': 'application/json',
            'Content-Type': 'application/json'}
    }).then(response =>
        response.json()
    ).then(function (trans) {
        if (trans != "") {
            let data = trans.data;
            let html = "<tr><th>n#</th><th>tipo</th><th>valore</th><th>data</th><th>descrizione</th></tr>";
            let ind = 1;
            for (obj of data) {
                let amount = obj.amount;
                let descr = obj.descr ? obj.descr : "---";
                let type = obj.type;
                let when = obj.when;
                html += "<tr><td>" + ind + "</td><td>" + type + "</td><td>" + amount;
                html += "</td><td>" + when + "</td><td>" + descr + "</td></tr>";
                ind++;
            }
            html = "<h3>Conto N° " + id + "</h3><table>" + html + "</table>"
            document.querySelector('#info_transactions').innerHTML = html;

        }
    }).catch(error => {
        console.log("Errore durante fetch:" + error);
    })
}

function logout() {
    sessionStorage.clear();
    window.location.href = "home.html"


}

