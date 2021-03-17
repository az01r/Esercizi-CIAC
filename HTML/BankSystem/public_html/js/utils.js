function visJSONobj(jsonO) {    // jsonO è un array di records
    let nhtml = "";
    for (var key in jsonO) {    // si possono scorrere i campi di un oggetto usando un for
        if (isObject(jsonO[key])) {
            let ris = visJSONobj(jsonO[key]);
            nhtml += key + ": <div class='in'>" + ris + "</div><br>";
        } else
        {
            nhtml += key + ": " + jsonO[key] + "<br>";
        }

    }
    return nhtml;
}

function isObject(o) {
    return o instanceof Object && o.constructor === Object;
}