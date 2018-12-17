package com.iluwatar.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iluwatar.proxy.WizardTower;
import com.iluwatar.proxy.WizardTowerProxy;

/**
 *  用来生成具体代理类的，动态代理类，生成的代理类，具备限制进入巫师塔人数的功能
 * @author 30000133
 *
 */
public class WizardTowerInvocationHandler implements InvocationHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(WizardTowerProxy.class);

	private WizardTower wizardTower;
	private static final int NUM_WIZARDS_ALLOWED = 3;
	private int numWizards;

	public WizardTowerInvocationHandler(WizardTower wizardTower) {
		super();
		this.wizardTower = wizardTower;
	}

	/**
	 *   用来动态的调用被代理类的方法
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String mn = method.getName();
		if(mn.equals("enter")) {
			if (numWizards < NUM_WIZARDS_ALLOWED) {
				method.invoke(wizardTower, args);// 动态的回调被代理类的方法
				numWizards++;
			} else {
				LOGGER.info("{} is not allowed to enter!", wizardTower);
			}
		}
		return null;
	}

}
