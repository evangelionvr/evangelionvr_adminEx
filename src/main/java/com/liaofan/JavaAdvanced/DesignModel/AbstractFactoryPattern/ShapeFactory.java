package com.liaofan.JavaAdvanced.DesignModel.AbstractFactoryPattern;



public class ShapeFactory extends AbstractFactory{
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            //
            return null;
        }

        if ("Circle".equalsIgnoreCase(shapeType)) {
            return new Circle();
        }

        if ("Rectangle".equalsIgnoreCase(shapeType)) {
            return new Rectangle();
        }

        if ("Square".equalsIgnoreCase(shapeType)) {
            return new Square();
        }

        return null;
    }
}
