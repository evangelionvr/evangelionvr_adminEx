package com.liaofan.JavaAdvanced.DesignModel.BuilderPattern;

/**
 * @author 廖钒
 * @ClassName BuilderPattern_KFC  KFC的建造者模式
 * @description: TODO
 * @datetime 2022年 06月 13日 18:42
 * @version: 1.0
 */
public class BuilderPattern_KFC {
    public static void main(String[] args) {
        MealBuild mealBuild = new MealBuild();

        Meal vegMeal = mealBuild.preparVegMeal();
        vegMeal.showItem();
        System.out.println("Total Cost:" + vegMeal.getCost());

        Meal nonVegMeal = mealBuild.preparNonVegMeal();
        nonVegMeal.showItem();
        System.out.println("Total Cost:" + nonVegMeal.getCost());

    }
}
