package com.z.admin.design.factory;

/**
 * @author tdsay
 * @description
 */
public interface SoftwareFactory {

    OperateSystem createOperateSystem();

    Command open();

}
