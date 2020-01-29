let creds = {
    username: 'buhlakay',
    password: 'boatsnhoes'
};

function login(username, password) {

    if (username === 'buhlakay' && password === 'boatsnhoes') {

        let authUser = {
            ...creds,   // we can "spread" properties of one object into another
            firstName: 'Blake',
            lastName: 'Dunn',
            role: 'Admin'
        };

        return authUser;
    }
}

let user = login(creds.username, creds.password);
console.log(user);

let credsArray = ['buhlakay', 'boatsnhoes'];

// We can "spread" array values across the params of a function
user = login(...credsArray);
console.log(user);

function sum(a, b, ...more) {
    return more.reduce((x, y) => {
        return x + y;
    }, a + b)
}

let result = sum(1, 2, 3, 4, 5);
console.log(result);