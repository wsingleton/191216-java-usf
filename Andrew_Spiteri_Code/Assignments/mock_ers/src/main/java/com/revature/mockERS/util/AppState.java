package com.revature.mockERS.util;

import com.revature.mockERS.repositories.UserRepository;

public class AppState {
    private UserSession currentSession;
    private Boolean appRunning;

    public AppState(){
        appRunning = true;

        final UserRepository userRepo = new UserRepository();

    }

    public UserSession getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(UserSession currentSession) {
        this.currentSession = currentSession;
    }

    public void invalidateCurrentSession(){
        this.currentSession = null;
    }

    public Boolean isSessionValid(){
        return (this.currentSession != null);
    }

    public void setAppRunning(Boolean appRunning) {
        this.appRunning = appRunning;
    }

    public Boolean isAppRunning() {
        return appRunning;
    }

    
}