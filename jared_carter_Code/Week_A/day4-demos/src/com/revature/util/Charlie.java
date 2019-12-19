package com.revature.util;

import com.revature.models.Alpha;
import com.revature.models.Circle;

public class Charlie extends Alpha {

    @Override
    public Circle getShape() {
        return new Circle();
    }
}
