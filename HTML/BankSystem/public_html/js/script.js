var loggedUser;
var modal = document.getElementById('fregister');
window.onclick = function (event) {
    if (event.target == modal) {
        cancelRegister();
    }
}
function init() {
    const form = document.querySelector('#freg');
    form.addEventListener('submit', doRegistrazione);

}
function cancelRegister() {
    modal = document.getElementById('fregister');
    modal.style.display = "none";
    let allinput = document.querySelectorAll(".modal input");
    for (i of allinput)
        i.value = "";
}
function registrazione() {
    document.getElementById('fregister').style.display = 'block';
}
function doRegistrazione(event) {
    event.preventDefault();
    const data = new FormData(event.target);
    const formJSON = Object.fromEntries(data.entries());
    //checkbox array stesso name piu' oggetti
    formJSON.news = data.getAll('news');
    let bodydata = JSON.stringify(formJSON)
    fetch("http://example.com/api/endpoint/", {
        method: "post",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: bodydata
    })
            .then((response) => {
                //do something awesome that makes the world a better place
            });
}



function showLogin() {
    const flog = document.querySelector("#flogin");
    if (flog.style.display == "none")
        flog.style.display = "block";
    else
        flog.style.display = "none";
}


function login() {

    url = "https://pwbanksystem.tssdev.it/resources/auth";
    let usr = document.querySelector("#flogin #usr").value;
    let pwd = document.querySelector("#flogin #pwd").value;
//alfonso
//alfonso
    const fd = new FormData(document.querySelector("#flogin"));
    const d = new URLSearchParams(fd);

    fetch(url, {
        method: 'POST',
        body: d,
        //Authorization: "Bearer qd23f2f2wf24f23fwgwge",

    }).then(response =>
        response.text()
    ).then(function (token) {
        if (token != "") {
            let decoded = jwt_decode(token);
            let id = decoded.sub;
            let group = decoded.groups[0];
            let usr = decoded.upn;
            sessionStorage.setItem("token", token);
            sessionStorage.setItem("id", id);
            sessionStorage.setItem("group", group);
            sessionStorage.setItem("usr", usr);
            if (group == "USER")
                window.location.href = "user.html";
            if (group == "ADMIN")
                window.location.href = "admin.html";
        }


        showLogin();
    }).catch(error => {
        console.log("Errore durante fetch:" + error);
    })

}

function exlogin() {
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
                    loggedUser = record;
                    html += visJSONobj(record);
                    sessionStorage.setItem("id_user", record.id);
                    sessionStorage.setItem("id_account", record.id_account);
                    sessionStorage.setItem("token", token);
                    divout.innerHTML = html;
                    let msgloguser = "Benvenuto " + loggedUser.nome.toUpperCase() + " " + loggedUser.cognome.toUpperCase()
                            + "<br>conto n° " + loggedUser.id_account;
                    document.querySelector("#loguser").innerHTML = msgloguser;

                    document.querySelector("#dlogin").style.display = "none";
                    document.querySelector("#dbank").style.display = "block";
                } else {
                    sessionStorage.clear();
                    document.querySelector("#dlogin").style.display = "block";
                    document.querySelector("#dbank").style.display = "none";
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






