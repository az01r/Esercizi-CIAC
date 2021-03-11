/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global fetch */

console.log("users js ok");
let divElement = document.querySelector("#users");
fetch("http://localhost:8080/PrimaWebApplication-1.0-SNAPSHOT/resources/users")
        .then(response => {
            console.log(response);
            return response.json();
        })
        .then(json => {
            json.forEach(u => {
                let pElement = document.createElement("p");
                pElement.text = u.id + ": " + u.nome + " " + u.cognome;
                divElement.appendChild(pElement);
            });
           // divElement.innerHTML = json;
        });
