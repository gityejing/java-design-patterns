package com.iluwatar.proxy3;

import com.iluwatar.proxy.IvoryTower;
import com.iluwatar.proxy.Wizard;

import net.sf.cglib.proxy.Enhancer;

public class App3 {
	
	public static void main(String[] args) {
		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(IvoryTower.class);
		enhancer.setCallback(new WizardTowerMethodInterceptor());

		IvoryTower ivoryTower = (IvoryTower) enhancer.create();

		Wizard wizard = new Wizard("yejing");
		Wizard wizard2 = new Wizard("liuyouyi");
		Wizard wizard3 = new Wizard("qinyexing");
		Wizard wizard4 = new Wizard("chengshiming");

		ivoryTower.enter(wizard);
		ivoryTower.enter(wizard2);
		ivoryTower.enter(wizard3);
		ivoryTower.enter(wizard4);
	}
}
