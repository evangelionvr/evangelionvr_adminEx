package com.liaofan.JavaAdvanced.DesignModel.FactoryPattern;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        //1.创建形状工厂
        ShapeFactory shapeFactory = new ShapeFactory();

        /**
         * 2.从工厂中获取创建好的对象,利用接口来接收
         */
        Shape shape_square = shapeFactory.getShape("Square");

        /**
         * 3.接口执行方法
         */
        shape_square.draw();

        Shape circie = shapeFactory.getShape("Circle");
        circie.draw();



    }
}
