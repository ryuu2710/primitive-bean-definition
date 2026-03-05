package com.yuta.sentiment;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // 1. Setup Phase: Open the Coffee Shop
        SimpleBeanFactory beanFactory = new SimpleBeanFactory();

        // 2. Write the Recipe
        BeanDefinition coffeeBeanDefinition = new BeanDefinition();
        coffeeBeanDefinition.setClazz(CoffeeService.class);
        coffeeBeanDefinition.setInitMethodName("startBrewing");

        // 3. Register Phase: Put recipe in the registryBeanStorage
        beanFactory.registerBeanDefinition("coffeeService", coffeeBeanDefinition);
        System.out.println("System: Coffee Bean Definition registered.");

        // 4. Execution Phase - Call 1
        System.out.println("\n--- Customer 1 orders coffeeService ---");
        Object bean1 = beanFactory.getBean("coffeeService");

        // 5. Execution Phase - Call 2
        System.out.println("\n--- Customer 2 orders coffeeService ---");
        Object bean2 = beanFactory.getBean("coffeeService");

        // 6. Verification: Are they the EXACT same instance?
        System.out.println("\nVerification: Are bean1 and bean2 the exact same object? " + (bean1 == bean2));
    }
}