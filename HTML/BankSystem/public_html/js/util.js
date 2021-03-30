
function visJSONobj(jsonO) {
    let nhtml = "";
    for (var key in jsonO) {
        if (jsonO.hasOwnProperty(key)) {
            if (isObject(jsonO[key])) {
                let ris = visJSONobj(jsonO[key]);
                nhtml += key + ": <div class='in'>" + ris + "</div><br>";
            } else
            {
                nhtml += key + ": " + jsonO[key] + "<br>";
            }
        }
    }
    return nhtml;
}
function isObject(o) {
    return o instanceof Object && o.constructor === Object;
}
