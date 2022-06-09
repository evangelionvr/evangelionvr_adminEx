package com.liaofan.JavaAdvanced.DesignModel.FactoryPattern;

/**
 * 形状工厂
 * 此类专门用于产生新的对象
 */
public class ShapeFactory {
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
