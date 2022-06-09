package com.liaofan.JavaAdvanced.DesignModel.AbstractFactoryPattern;

import javax.xml.bind.SchemaOutputResolver;

public class Red implements Color{
    @Override
    public void fill() {
        System.out.println("现在要填充红色");
    }
}
