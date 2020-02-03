export const apiLogin = async (username:string, password:string): Promise<object> => {
    let credentials = {
        username,
        password
    }
    try {
        const response = await fetch('http://localhost:8080/project_1_ERS/auth', {
            method: 'POST',
            mode: 'no-cors',
            credentials: 'include',
            body: JSON.stringify(credentials),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        console.log(response.json());
        if(response.status === 200) {
            const body = await response.json()
            console.log(body)
            return{
                body,
                loginMessage: 'Login successful'
            }
        }else if (response.status === 401) {
            return {
                loginMessage: 'Incorrect username or password',
                body: null
            }
        }else {
            return {
                loginMessage: 'Something went wrong',
                body: null
            }
        }
    } catch (e) {
        console.log(e);
        return {
            loginMessage: 'Something went wrong'
        }
        
    }
}