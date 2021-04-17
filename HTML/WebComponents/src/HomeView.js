export default class HomeView extends HTMLElement {
    connectedCallback(){
        //creare interfaccia grafica componente
        this.innerHTML = `
        <h1>Home view</h1>
        <p>Benvenuto in app</p>
        `
    }
}

customElements.define('home-view',HomeView); // indica al browser che quando trova il tag home-view deve creare un'istanza di HomeView