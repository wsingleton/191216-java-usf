window.onload = () => {
    const LOGIN_COMPONENT = new LoginComponent();
    LOGIN_COMPONENT.render();

}

class LoginComponent {

    template = `
        <div id="login-component">
            <input type="text" id="username-cred" />
            <br> <br>
            <input type="password" id="password-cred" />
            <br> <br>
            <button id="submit-creds">Login</button>
        </div>    
    `;

    constructor() {
        console.log('LoginComponent instantiation complete!');
    }

    render = () => {
        console.log('LoginComponent.render() invoked!');
        document.getElementById('root').innerHTML = this.template;
        document.getElementById('submit-creds').addEventListener('click', this.login);
    }

    login = () => {
        console.log('LoginComponent.login() invoked!');
        let username = document.getElementById('username-cred').value;
        let password = document.getElementById('password-cred').value;
        console.log('Provided credentials: ', username, password);
    }
}