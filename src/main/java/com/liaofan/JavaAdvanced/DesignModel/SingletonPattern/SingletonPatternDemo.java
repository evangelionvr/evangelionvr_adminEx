package com.liaofan.JavaAdvanced.DesignModel.SingletonPattern;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        SingletonObject instance = SingletonObject.getInstance();
        instance.showMessage();

        SingletonObject_Lazy instance1_lazy = SingletonObject_Lazy.getInstance();
        instance1_lazy.showMessage();

    }
}
