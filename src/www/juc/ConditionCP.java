package www.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangchong
 * @date 2019/5/15 21:12
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe 基于Lock + Condition 的生产消费者模型
 */
public class ConditionCP {
    private String name;
    private int maxSize;
    private int currentSize;
    private Lock lock = new ReentrantLock();
}
