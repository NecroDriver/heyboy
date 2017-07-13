package com.basic.single;

/**
 * Created by mafh on 2017/6/28 0028.13:31
 * 单例模式
 */
public class SingleTon {

    /**
     * 饿汉式 单例模式
     * 类在加载时就实例化，提供一个公共的方法获取实例化的类
     * <p> 优点：线程安全</p>
     * <p>缺点：类被加载时就实例化，有可能在整个代码周期都没有使用，且不会被回收会一直存在</p>
     */
    private static class Hunger{
        /*
        实例化自身
         */
        private static Hunger hunger = new Hunger();
        /*
        私有构造方法
         */
        private Hunger(){}
        /*
        获取自身实例化的类
         */
        static Hunger getHunger(){
            return hunger;
        }
    }

    /**
     * 懒汉式 单例模式
     * 只有在真正使用的时候，才实例化
     * <p>优点：只有在真正使用的时候才实例化</p>
     * <p>缺点：线程不安全</p>
     */
    private static class Lazy{
        /*
        声明一个对象
         */
        private static Lazy lazy;
        /*
        私有构造方法
         */
        private Lazy(){}
        /*
        synchronized锁
         */
        static synchronized Lazy getLazy(){
            if(null == lazy){
                lazy = new Lazy();
            }
            return lazy;
        }
    }

    /**
     * 枚举式 单例模式
     * 与饿汉式相似
     */
    private enum Enum{
        Enum;
        /*
        枚举就是单例
         */
        public Enum getEnum(){
            return Enum;
        }
    }

    public static void main(String[] args){
        SingleTon.Hunger hunger = SingleTon.Hunger.getHunger();
        if(hunger == SingleTon.Hunger.getHunger()){
            System.out.println("懒汉式--单例生效");
        }

        SingleTon.Lazy lazy = SingleTon.Lazy.getLazy();
        if(lazy == SingleTon.Lazy.getLazy()){
            System.out.println("饿汉式--单例生效");
        }

        if(Enum.Enum.getEnum() == Enum.Enum.getEnum()){
            System.out.println("枚举式--单例生效");
        }
    }
}
