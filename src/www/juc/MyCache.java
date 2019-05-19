package www.juc;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wangchong
 * @date 2019/5/15 20:54
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe
 */
public class MyCache<K,V> {
    private HashMap<K,V> hashMap;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();
    public V get(K k) {
        readLock.lock();
        return hashMap.get(k);
    }

    public void put(K k, V v) {
        writeLock.lock();
        hashMap.put(k,v);
    }
}
