package com.iluwatar.proxy2;

import java.lang.reflect.Proxy;

import com.iluwatar.proxy.IvoryTower;
import com.iluwatar.proxy.Wizard;
import com.iluwatar.proxy.WizardTower;

public class App2 {
	public static void main(String[] args) {
		IvoryTower ivoryTower = new IvoryTower();
		WizardTower wizardTower = (WizardTower) Proxy.newProxyInstance(
				IvoryTower.class.getClassLoader(), // 类加载器
				new Class[] {WizardTower.class}, // 接口
				new WizardTowerInvocationHandler(ivoryTower));// 代理
		Wizard wizard = new Wizard("yejing");
		Wizard wizard2 = new Wizard("liuyouyi");
		Wizard wizard3 = new Wizard("qinyexing");
		Wizard wizard4 = new Wizard("chengshiming");
		wizardTower.enter(wizard);
		wizardTower.enter(wizard2);
		wizardTower.enter(wizard3);
		wizardTower.enter(wizard4);
	}
}
