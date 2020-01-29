var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
export class LoginComponent {
    constructor(userService) {
        this.userService = userService;
        this.template = `
    <div class="login-form">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="username-cred" class="sr-only">Username</label>
        <input type="text" id="username-cred" class="form-control" placeholder="Username" required autofocus>
        <label for="password-cred" class="sr-only">Password</label>
        <input type="password" id="password-cred" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" id="submit-creds">Sign in</button>
        <br>
        <div hidden class="alert alert-danger text-center" id="alert-msg" role="alert">
            Invalid Credentials!
        </div>
        <p class="mt-5 mb-3 text-muted">&copy; Revature 2017-2019</p>
    </div>
    `;
        this.render = () => {
            console.log('LoginComponent.render() invoked!');
            document.getElementById('root').innerHTML = this.template;
            document.getElementById('submit-creds').addEventListener('click', this.login);
        };
        this.login = () => __awaiter(this, void 0, void 0, function* () {
            let username = document.getElementById('username-cred').value;
            let password = document.getElementById('password-cred').value;
            let authUser = yield this.userService.authenticate({ username, password });
            console.log(authUser);
        });
        console.log('LoginComponent initialized!');
    }
}
