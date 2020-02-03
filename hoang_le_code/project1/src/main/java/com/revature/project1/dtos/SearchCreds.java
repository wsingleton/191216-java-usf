package com.revature.project1.dtos;

public class SearchCreds {
    private int sId;

    public SearchCreds() {super();
    }

    public SearchCreds(int sId) {
        this.sId = sId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }
}
