import {render , html} from './lib/lit-html.js';

export default class LoginView extends HTMLElement {
    connectedCallback(){
        // interfaccia grafica componente
        render(this.view,this);
        this.usr = document.querySelector('#usr');
        this.usr = document.querySelector('#pwd');
    }

    view() {
        return html`
        <form @submit=${e => this.onLogin(e)}>
            <input type='text' name='usr' id='usr'>
            <input type='password' name='pwd' id='pwd'>
            <input type='submit'>
            
        </form>
        `;
    }

    onLogin(e) {
        e.preventDefault();
        const f = new FormData();
        f.append("usr", this.usr.value);
        f.append("pwd", this.usr.value);
        // fetch
    }
}

customElements.define('login-view',LoginView);