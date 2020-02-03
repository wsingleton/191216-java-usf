export class User {

    id: number;
    role: string;
    username: string;
    password: string;
    firstName: string;
    lastName: string;

    constructor(
        id: number, role: string,
        un: string, pw: string,
        fn: string, ln: string
    ) {
        this.id = id;
        this.role = role;
        this.username = un;
        this.password = pw;
        this.firstName = fn;
        this.lastName = ln;
    }
}