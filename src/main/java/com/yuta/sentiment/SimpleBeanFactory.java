package com.yuta.sentiment;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SimpleBeanFactory {

    private Map<String, BeanDefinition> registryBeanStorage;

    private Map<String, Object> alreadyCreatedBeanStorage;


    public SimpleBeanFactory() {
        this.registryBeanStorage = new HashMap<>();
        this.alreadyCreatedBeanStorage = new HashMap<>();
    }

    public void registerBeanDefinition(String beanName, BeanDefinition definition) {
        this.registryBeanStorage.put(beanName, definition);
    }

    public Object getBean(String beanName) {
        if(this.alreadyCreatedBeanStorage.containsKey(beanName)) {
            return this.alreadyCreatedBeanStorage.get(beanName);
        } else {
            if(!this.registryBeanStorage.containsKey(beanName)) {
                throw new RuntimeException("Key not found!");
            } else {
                try {
                    BeanDefinition beanDefinition = this.registryBeanStorage.get(beanName);
                    Class<?> clazz = beanDefinition.getClazz();
                    Object newInstance = clazz.getDeclaredConstructor().newInstance();

                    // trigger lifecycle hook
                    String initName = beanDefinition.getInitMethodName();
                    if(initName != null && !initName.isEmpty()) {
                        Method initMethod = clazz.getMethod(initName);
                        initMethod.invoke(newInstance);

                    }
                    this.alreadyCreatedBeanStorage.put(beanName, newInstance);
                    return newInstance;
                } catch (Exception e) {
                    throw new RuntimeException("Failed to instantiate bean: " + beanName, e);
                }
            }
        }
    }
}
