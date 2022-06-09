package com.liaofan.JavaAdvanced.DesignModel.AbstractFactoryPattern;

public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if("".equalsIgnoreCase(color)) {
            return null;
        }

        if ("Red".equalsIgnoreCase(color)) {
            return new Red();
        }

        if ("Blue".equalsIgnoreCase(color)) {
            return new Blue();
        }

        if ("Green".equalsIgnoreCase(color)) {
            return new Green();
        }

        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
