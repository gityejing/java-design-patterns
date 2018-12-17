package com.iluwatar.proxy3;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iluwatar.proxy.WizardTowerProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 *  	用来动态的生成代理类
 * @author 30000133
 *
 */
public class WizardTowerMethodInterceptor implements MethodInterceptor {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WizardTowerProxy.class);

	private static final int NUM_WIZARDS_ALLOWED = 3;
	private int numWizards;

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		if (numWizards < NUM_WIZARDS_ALLOWED) {
			proxy.invokeSuper(obj, args);// 动态的回调被代理类的方法
			numWizards++;
		} else {
			LOGGER.info("{} is not allowed to enter!", obj);
		}
		return null;
	}

}
