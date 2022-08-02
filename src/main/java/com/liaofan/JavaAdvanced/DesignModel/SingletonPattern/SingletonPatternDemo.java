package com.liaofan.JavaAdvanced.DesignModel.SingletonPattern;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        SingletonObject instance = SingletonObject.getInstance();
        instance.showMessage();

        SingletonObject_LazyMan instance1_lazy = SingletonObject_LazyMan.getInstance();
        instance1_lazy.showMessage();

        SingetonObject_HungryMan_Recommend instatance2_HungryMan = SingetonObject_HungryMan_Recommend.getInstance();
        instatance2_HungryMan.showMessage();

    }
}
