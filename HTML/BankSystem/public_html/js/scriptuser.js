/* global fetch, obj */

function initUser() {

    if (sessionStorage.getItem("token"))
    {
        getInfoUser();
        getInfoAccount();
    } else {
        sessionStorage.clear();
        window.location.href = "home.html";
    }

}

function getInfoUser() {
    let id = sessionStorage.getItem("id");
    let url = "https://pwbanksystem.tssdev.it/resources/users/" + id;
    fetch(url, {
        method: 'GET',
        headers: {
            'Authorization': "Bearer " + sessionStorage.getItem("token"),
            'Accept': 'application/json',
            'Content-Type': 'application/json'}
    })
            .then(response => response.json())
            .then(function (infoUser) {
                if (infoUser !== "") {
                    let info = document.querySelector('#info_user');
                    html = infoUser.lname + " " + infoUser.fname + " - " + infoUser.email;
                    info.innerHTML = html;
                }
            }).catch(error => {
        console.log("Errore durante fetch:" + error);
    });
}

function getInfoUserAccount() {
    let id = sessionStorage.getItem("id");
    let url = "https://pwbanksystem.tssdev.it/resources/users/" + id + "/accounts";
    fetch(url, {
        method: 'GET',
        headers: {
            'Authorization': "Bearer " + sessionStorage.getItem("token"),
            'Accept': 'application/json',
            'Content-Type': 'application/json'}
    })
            .then(response => response.json())
            .then(function (infoAccounts) {
                if (infoAccounts !== "") {
                    let divInfo = document.querySelector('#info_accounts');
                    let total = infoAccounts.total;
                    let data = infoAccounts.data;
                    for (obj of data) {
                        let idAccount = obj.id;
                        let opt = document.createElement("option");
                        opt.innerHTML = "idAccount: " + idAccount + " - balance: " + balance;
                        document.querySelector('#sel_id_account)').appendChild(opt);
                    }
                }
            }).catch(error => {
        console.log("Errore durante fetch:" + error);
    });
}

function getInfoUserAccountTransaction() {
    let id = document.querySelector("#sel_");
    let url = "https://pwbanksystem.tssdev.it/resources/users/" + id + "/accounts";
    fetch(url, {
        method: 'GET',
        headers: {
            'Authorization': "Bearer " + sessionStorage.getItem("token"),
            'Accept': 'application/json',
            'Content-Type': 'application/json'}
    })
            .then(response => response.json())
            .then(function (trans) {
                if (trans !== "") {
                    let amount = obj.amount;
                    let descr = obj.descr;
                    let type = obj.type;
                    let date = obj.date;
                    html += "<h3>mov: " + type + " - " + amount + " - " + when + " - " + descr + "</h3>";
                }
                document.querySelector('#info_transactions').innerHTML = html;
            
            
            }).catch(error => {
        console.log("Errore durante fetch:" + error);
    });
}