package www.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author wangchong
 * @date 2019/5/15 19:06
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe
 */

class Task2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("T2:洗茶壶");
        TimeUnit.SECONDS.sleep(1);
        TimeUnit.SECONDS.sleep(1);
        TimeUnit.SECONDS.sleep(1);

        return null;
    }
}
public class TeaTest {

}
