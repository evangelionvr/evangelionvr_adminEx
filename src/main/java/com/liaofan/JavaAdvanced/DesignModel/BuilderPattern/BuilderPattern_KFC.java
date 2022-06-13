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
        //初始化建造者方法
        MealBuild mealBuild = new MealBuild();

        /**
         * 调用建造者构建素食套餐
         */
        Meal vegMeal = mealBuild.preparVegMeal();
        /**
         * 展示套餐内容
         */
        vegMeal.showItem();
        System.out.println("Total Cost:" + vegMeal.getCost());

        /**
         * 调用建造者构建非素食套餐
         */
        Meal nonVegMeal = mealBuild.preparNonVegMeal();
        /**
         * 展示套餐内容
         */
        nonVegMeal.showItem();
        /**
         *
         */
        System.out.println("Total Cost:" + nonVegMeal.getCost());


    }
}
