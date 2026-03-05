package com.yuta.sentiment;

public class BeanDefinition {
    private Class<?> clazz;
    private String initMethodName;
    private String destructionMethodName;

    public Class<?> getClazz() {
        return clazz;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public String getDestructionMethodName() {
        return destructionMethodName;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public void setDestructionMethodName(String destructionMethodName) {
        this.destructionMethodName = destructionMethodName;
    }
}
