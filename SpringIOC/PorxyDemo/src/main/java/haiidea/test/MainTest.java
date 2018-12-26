package haiidea.test;


import haiidea.service.UserService;
import haiidea.service.impl.UserServiceImpl;
import haiidea.service.impl.UserServiceImpl02;
import haiidea.util.Logger;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MainTest {
    public static void main(String[] args) {
//        UserService us = new UserServiceImpl();
//        us.save();

        //使用动态代理扩展功能 JDK方式
//        UserService us = new UserServiceImpl();
//        UserService proxyUserService = (UserService) Proxy.newProxyInstance(us.getClass().getClassLoader(),
//                us.getClass().getInterfaces(),
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        method.invoke(us,args);
//                        Logger.log();
//                        return null;
//                    }
//                });
//        proxyUserService.save();
        UserServiceImpl02 us = new UserServiceImpl02();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl02.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                method.invoke(us,args);
                Logger.log();
                return null;
            }
        });
        UserServiceImpl02 enhancerUS = (UserServiceImpl02) enhancer.create();
        enhancerUS.save();
    }
}
