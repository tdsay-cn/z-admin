package com.z.admin.design.factory;

/**
 * @author tdsay
 * @description
 */
public class WindowsFactory implements SoftwareFactory {
    @Override
    public OperateSystem createOperateSystem() {
        return new Windows();
    }

    @Override
    public Command open() {
        return new Dos();
    }
}
