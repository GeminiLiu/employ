package com.jagt.employ.common.tools;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * 提供些获取系统信息相关的工具方法
 * 
 * @version  1.0
 * @author   gotanks
 * @since     2019-04-02
 * 
 */
public class System_ {

    /**
     * JVM的版本
     */
    public static final String JVM_VERSION = System.getProperty("java.version");
    /**
     * JVM的编码
     */
    public static final String JVM_ENCODING = System.getProperty("file.encoding");
    /**
     * JVM默认的临时目录
     */
    public static final String JVM_TEMPDIR = System.getProperty("java.io.tmpdir");
    public static final String HTTP_PROXY_HOST = "http.proxyHost";
    public static final String HTTP_PROXY_PORT = "http.proxyPort";
    ;
    public static final String HTTP_PROXY_USER = "http.proxyUser";
    ;
    public static final String HTTP_PROXY_PASSWORD = "http.proxyPassword";
    /**
     * 主机IP
     */
    public static String HOST_IP;
    /**
     * 主机名
     */
    public static String HOST_NAME;

    /**
     * 主机架构
     */
    public static String OS_ARCH = System.getProperty("os.arch");
    /**
     * 主机类型
     */
    public static String OS_NAME = System.getProperty("os.name");
    /**
     * 主机类型版本
     */
    public static String OS_VERSION = System.getProperty("os.version");
    /**
     * 操作系统类型
     */
    public static String SUN_DESKTOP = System.getProperty("sun.desktop");
    /**
     * 当前用户
     */
    public static String CURRENT_USER = System.getProperty("user.name");
    /**
     * 当前用户的家目录
     */
    public static String CURRENT_USER_HOME = System.getProperty("user.home");
    /**
     * 当用用户的工作目录
     */
    public static String CURRENT_USER_DIR = System.getProperty("user.dir");
    public static String FILE_SEPARATOR = System.getProperty("file.separator");
    public static String PATH_SEPARATOR = System.getProperty("path.separator");
    public static String LINE_SEPARATOR = System.getProperty("line.separator");
    /**
     * 总的物理内存
     */
    public static long TotalMemorySize;
    private static int kb = 1024;

    static {

        try {

            InetAddress addr = InetAddress.getLocalHost();
            HOST_NAME = addr.getHostName();
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface netint : Collections.list(nets)) {
                if (null != netint.getHardwareAddress()) {
                    List<InterfaceAddress> list = netint.getInterfaceAddresses();
                    for (InterfaceAddress interfaceAddress : list) {
                        InetAddress ip = interfaceAddress.getAddress();
                        if (ip instanceof Inet4Address) {
                            HOST_IP += interfaceAddress.getAddress().toString();
                        }
                    }
                }
            }
            HOST_IP = HOST_IP.replaceAll("null", "");
        } catch (Exception e) {
            System.out.println("获取服务器IP出错");
        }

    }

    /**
     * 获取JVM内存总量
     */
    public final static long JVMtotalMem() {
        return Runtime.getRuntime().totalMemory() / kb;
    }

    /**
     * 虚拟机空闲内存量
     */
    public final static long JVMfreeMem() {
        return Runtime.getRuntime().freeMemory() / kb;
    }

    /**
     * 虚拟机使用最大内存量
     */
    public final static long JVMmaxMem() {
        return Runtime.getRuntime().maxMemory() / kb;
    }

    /**
     * Sets HTTP proxy settings.
     */
    public final static void setHttpProxy(String host, String port, String username, String password) {
        System.getProperties().put(HTTP_PROXY_HOST, host);
        System.getProperties().put(HTTP_PROXY_PORT, port);
        System.getProperties().put(HTTP_PROXY_USER, username);
        System.getProperties().put(HTTP_PROXY_PASSWORD, password);
    }

    /**
     * Sets HTTP proxy settings.
     */
    public final static void setHttpProxy(String host, String port) {
        System.getProperties().put(HTTP_PROXY_HOST, host);
        System.getProperties().put(HTTP_PROXY_PORT, port);
    }

    /**
     * 高并发场景下System.currentTimeMillis()的性能问题的优化
     * <p>
     * <p>
     * System.currentTimeMillis()的调用比new一个普通对象要耗时的多（参加https://www.jianshu.com/p/3fbe607600a5）
     * <p>
     * System.currentTimeMillis()之所以慢是因为去跟系统打了一次交道
     * <p>
     * 后台定时更新时钟，JVM退出时，线程自动回收
     * <p>
     * 10亿：43410,206,210.72815533980582%
     * <p>
     * 1亿：4699,29,162.0344827586207%
     * <p>
     * 1000万：480,12,40.0%
     * <p>
     * 100万：50,10,5.0%
     * <p>
     *
     */
    private final long period;
    private final AtomicLong now;

    private System_(long period) {
        this.period = period;
        this.now = new AtomicLong(System.currentTimeMillis());
        scheduleClockUpdating();
    }

    private static class InstanceHolder {
        public static final System_ INSTANCE = new System_(1);
    }

    private static System_ instance() {
        return System_.InstanceHolder.INSTANCE;
    }

    private void scheduleClockUpdating() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "System Clock");
                thread.setDaemon(true);
                return thread;
            }
        });
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                now.set(System.currentTimeMillis());
            }
        }, period, period, TimeUnit.MILLISECONDS);
    }

    private long currentTimeMillis() {
        return now.get();
    }

    public static long now() {
        return instance().currentTimeMillis();
    }

    public static String nowDate() {
        return new Timestamp(instance().currentTimeMillis()).toString();
    }
}
