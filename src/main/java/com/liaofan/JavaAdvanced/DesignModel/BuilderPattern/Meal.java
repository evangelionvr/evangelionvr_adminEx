package com.liaofan.JavaAdvanced.DesignModel.BuilderPattern;

import java.util.ArrayList;
import java.util.List;

/** 定义一个套餐对象
 * @author 廖钒
 * @ClassName Meal 套餐类
 * @description: TODO
 * @datetime 2022年 06月 13日 18:31
 * @version: 1.0
 * 套餐的类对象
 */
public class Meal {
    /**
     * 初始化食物列表
     */
    private List<Food> items = new ArrayList<>();

    /**
     * 添加食物到套餐
     *
     * @param item  食物对象
     */
    public void addItem(Food item) {
        items.add(item);
    }

    /**
     * 套餐价钱
     *
     * @return
     */
    public float getCost() {
        float cost = 0.0f;

        for (Food item : items) {
            cost += item.price();
        }

        return cost;

    }

    /**
     * 展示套餐
     */
    public void showItem() {
        for(Food item:items) {
            System.out.println("Item:" + item.name());
            System.out.println(",Packing" + item.packing());
            System.out.println(",Price:" + item.price());
        }
    }

}
