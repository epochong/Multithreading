package www.designmode;

/**
 * @author wangchong
 * @date 2019/5/10 18:28
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe
 */

/**
 * 饿汉式单例
 *
 */

class Singleton {
    private static Singleton singleton = new Singleton();
    private Singleton(){}
    public static Singleton getInstance() {
        return singleton;
    }
}

/**
 * 懒汉式单例
 * 存在线程安全问题
 */
class HungrySingleton {
    private static HungrySingleton singleton;
    private HungrySingleton() {};
    public static HungrySingleton getInstance() {
        //线程1、2同时进来都是null，所以new出来布置一个对象
        if (singleton == null) {
            singleton = new HungrySingleton();
        }
        return singleton;
    }
}
/**
 * singleton = new Singleton();
 * 1-在堆上分配空间
 * 2-属性初始化
 * 3-引用指向对象(singleton已经不为null)
 * i = 0;
 *
 * 会进行指令重排,因为可以先指向对象再初始化对程序结果没有任何影响
 * 但是在多线程情况下如果先执行3
 * singleton已经不为null,这个时候线程2调用getInstance直接return singleton这个时候没有初始化,出现没有赋值的情况
 * 正常情况是1-2-3
 * 可能变为1-3-2
 */

/**
 * 最完整的懒汉式单例模式(双重加锁单例模式)
 * 线程安全的懒汉单例模式，写单例直接写这个
 */
class ThreadSafeHungrySingleton {
    private String str;
    /**
     * 加上volatile是最完整的懒汉式单例模式
     * 第二层锁,禁止指令重排
     * 第二层保证不管多少线程拿到singleton对象，一定是完全初始化好的对象
     */
    private static volatile ThreadSafeHungrySingleton singleton;
    private ThreadSafeHungrySingleton() {
        str = "hello";
    };

    public ThreadSafeHungrySingleton(String str) {
        this.str = str;
    }

    public static ThreadSafeHungrySingleton getInstance() {
        //线程1、2同时进来都是null，所以new出来布置一个对象
        //双重检查
        //single checked
        if (singleton == null) {
            /**
             * 不在single checked外加synchronized 是因为力度要轻，我们还需在单立中干一些事情
             * 第一层锁保证,拿到的一定是同一个对象
             */
            synchronized (ThreadSafeHungrySingleton.class) {
                //double checked 防止第一次进入上一个single checked 继续产生对象
                if (singleton == null) {
                    singleton = new ThreadSafeHungrySingleton();
                }
            }

        }
        return singleton;
    }
}
public class Hungry {
}
