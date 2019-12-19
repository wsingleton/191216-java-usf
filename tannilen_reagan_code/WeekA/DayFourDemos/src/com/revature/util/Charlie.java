package com.revature.util;
import com.revature.models.Alpha;
import com.revature.models.Circle;
import com.revature.models.Shape;

public class Charlie extends Alpha {
    @Override
    protected double protectedDoubleGetter() {
        return 3.14;
    }
    @Override
    public Circle getShape() {
        return new Circle();
    }
}