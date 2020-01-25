package com.revature.mockERS;

import com.revature.mockERS.util.RequestViewHelper;

public class MockERSDriver {
    public static void main(String[] args) {
        RequestViewHelper rvh = new RequestViewHelper();
        rvh.process("/ers-app/dashboard.view");
    }
}
