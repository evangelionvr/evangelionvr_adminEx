package com.liaofan.JavaAdvanced.DesignModel.BuilderPattern;

/**
 * @author 廖钒
 * @ClassName MealBuild 建造类,负责创建对象
 * @description: TODO
 * @datetime 2022年 06月 13日 18:38
 * @version: 1.0
 */
public class MealBuild {
    /**
     * 构造素食套餐的方法
     * @return
     */
    public Meal preparVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new CokeCola());
        return meal;
    }

    /**
     * 构造非素食套餐
     * @return
     */
    public Meal preparNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
