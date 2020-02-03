export const apiRegister = async (username:string, password:string, firstName:string, lastName:string, email:string): Promise<object> => {
    let credentials = {
        username,
        password,
        firstName,
        lastName,
        email
    }

    try {
        const response = await fetch('http://localhost:8080/project_1_ERS/users', {
            method: 'POST',
            mode: 'no-cors',
            credentials: 'include',
            body: JSON.stringify(credentials),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        console.log(response.json());
        if(response.status === 201) {
            const body = await response.json()
            console.log(body);
            return{
                body,
                registerMessage: 'Registration Successful'
            }
        }else if (response.status === 401) {
            return {
                registerMessage: 'Invalid user input',
                body: null
            }
        }else {
            return {
                registerMessage: 'Something went wrong',
                body: null
            }
        }
    } catch(e) {
        console.log(e);
        return {
            registerMessage: 'Something went wrong'
        }
        
    }
}