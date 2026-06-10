package com.z.admin.design.factory;

/**
 * @author tdsay
 * @description 普通工厂模式
 */
public class FactoryWindows {

    public static Command getApp() {
        return new Dos();
    }
}
