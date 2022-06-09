package com.liaofan.JavaAdvanced.DesignModel.AbstractFactoryPattern;

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFacotry("shape");
        Shape circle = shapeFactory.getShape("Circle");
        circle.draw();

        Shape square = shapeFactory.getShape("Square");
        square.draw();

        Shape rectangle = shapeFactory.getShape("Rectangle");
        ;
        rectangle.draw();

        AbstractFactory colorFactory = FactoryProducer.getFacotry("color");
        Color blue = colorFactory.getColor("Blue");
        blue.fill();

        Color red = colorFactory.getColor("red");
        red.fill();

        Color green = colorFactory.getColor("green");
        green.fill();

    }


}
