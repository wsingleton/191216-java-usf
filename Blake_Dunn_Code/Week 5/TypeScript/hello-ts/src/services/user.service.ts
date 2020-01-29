import { Credentials } from "../models/credentials.js";
import { API_URL } from '../main.js';

export class UserService {

    constructor() {
        console.log('UserService initialized');
    }

    authenticate = async (creds: Credentials) => {
        console.log('UserService.authenticate() invoked!');
        let resp = await fetch(`${API_URL}/auth`, {
            method: 'POST',
            body: JSON.stringify({...creds})
        });

        return await resp.json();
    }
}