package com.inspur.incloud.common.util.lock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMultiLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreV2;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.inspur.incloud.common.util.SpringContextUtil;

/**
 * The Class LockUtil.
 */
@EnableConfigurationProperties(ZkLockUtil.class)
public class ZkLockUtil {
	
	private CuratorFramework client = (CuratorFramework)SpringContextUtil.getBean("curatorFramework");
	protected static final String LOCK_BASE_PATH = "/com/inspur/inCloudManager/locks/lock";
    /**
     * Instantiates a new lock util.
     */
    private ZkLockUtil() {
    }


    /**
     * The Class LockUtilHolder.
     */
    private static class LockUtilHolder {
        /** The instance. */
        static ZkLockUtil instance = new ZkLockUtil();
        
    }

    /**
     * Gets the single instance of LockUtil.
     * @return single instance of LockUtil
     */
    public static ZkLockUtil getInstance() {

        return LockUtilHolder.instance;

    }

    /** 可重入锁(在一个线程中多次调用acquire,在线程拥有锁时它总是返回true). */
    private final Map<String, InterProcessLock> interProcessMutexMap = new HashMap<String, InterProcessLock>();
    
    /** 不可重入锁(在一个线程中多次调用acquire,会阻塞在第二次调用acquire). */
    private final Map<String, InterProcessLock> interProcessSemaphoreMutexMap = new HashMap<String, InterProcessLock>();
    
    /** 可重入读写锁(在一个线程中多次调用acquire,在线程拥有锁时它总是返回true). */
    private final Map<String, InterProcessReadWriteLock> interProcessReadWriteLockMap = new HashMap<String, InterProcessReadWriteLock>();
    
    /** 信号量. */
    private final Map<String, InterProcessSemaphoreV2> interProcessSemaphoreV2Map = new HashMap<String, InterProcessSemaphoreV2>();
    
    /** 多锁对象(当调用acquire， 所有的锁都会被acquire，如果请求失败，所有的锁都会被release。 同样调用release时所有的锁都被release). */
    private final Map<String, InterProcessLock> interProcessMultiLockMap = new HashMap<String, InterProcessLock>();
    
    /**
     * 可重入锁(在一个线程中多次调用acquire,在线程拥有锁时它总是返回true).
     *
     * @param lockType the lock type
     * @param id the id
     * @return the inter process mutex
     */
    public InterProcessLock getInterProcessMutex(Enum lockType, String id){
    	InterProcessLock lock;
    	synchronized(interProcessMutexMap){
	    	String path = LOCK_BASE_PATH + lockType.toString()+"-"+id;
	    	lock = interProcessMutexMap.get(path);
	    	if(lock == null){
	    		lock = new InterProcessMutex(client,path);
	    		interProcessMutexMap.put(path, lock);
	    	}
    	}
    	
    	return lock;
    }
    
    /**
     * 不可重入锁(在一个线程中多次调用acquire,会阻塞在第二次调用acquire).
     *
     * @param lockType the lock type
     * @param id the id
     * @return the inter process semaphore mutex
     */
    public InterProcessLock getInterProcessSemaphoreMutex(Enum lockType, String id){
    	InterProcessLock lock;
    	synchronized(interProcessSemaphoreMutexMap){
    		String path = LOCK_BASE_PATH + lockType.toString()+"-"+id;
    		lock = interProcessSemaphoreMutexMap.get(path);
    		if(lock == null){
    			lock = new InterProcessSemaphoreMutex(client,path);
    			interProcessSemaphoreMutexMap.put(path, lock);
    		}
    	}
    	
    	return lock;
    }
    
    /**
     * 可重入读写锁(在一个线程中多次调用acquire,在线程拥有锁时它总是返回true).
     *
     * @param lockType the lock type
     * @param id the id
     * @return the inter process read write lock
     */
    public InterProcessReadWriteLock getInterProcessReadWriteLock(Enum lockType, String id){
    	InterProcessReadWriteLock lock;
    	synchronized(interProcessReadWriteLockMap){
    		String path = LOCK_BASE_PATH + lockType.toString()+"-"+id;
    		lock = interProcessReadWriteLockMap.get(path);
    		if(lock == null){
    			lock = new InterProcessReadWriteLock(client,path);
    			interProcessReadWriteLockMap.put(path, lock);
    		}
    	}
    	
    	return lock;
    }
    
    /**
     * 信号量.
     *
     * @param lockType the lock type
     * @param id the id
     * @param count the count
     * @return the inter process semaphore v2
     */
    public InterProcessSemaphoreV2 getInterProcessSemaphoreV2(Enum lockType, String id, int count){
    	InterProcessSemaphoreV2 lock;
    	synchronized(interProcessSemaphoreV2Map){
    		String path = LOCK_BASE_PATH + lockType.toString()+"-"+id;
    		lock = interProcessSemaphoreV2Map.get(path);
    		if(lock == null){
    			lock = new InterProcessSemaphoreV2(client,path, count);
    			interProcessSemaphoreV2Map.put(path, lock);
    		}
    	}
    	
    	return lock;
    }
    
    /**
     * 多锁对象(当调用acquire， 所有的锁都会被acquire，如果请求失败，所有的锁都会被release。 同样调用release时所有的锁都被release).
     *
     * @param lockType the lock type
     * @param id the id
     * @param locks the locks
     * @return the inter process multi lock
     */
    public InterProcessLock getInterProcessMultiLock(Enum lockType, String id,List<InterProcessLock> locks){
    	InterProcessLock lock;
    	synchronized(interProcessMultiLockMap){
    		String path = LOCK_BASE_PATH + lockType.toString()+"-"+id;
    		lock = interProcessMultiLockMap.get(path);
    		if(lock == null){
    			lock = new InterProcessMultiLock(locks);
    			interProcessMultiLockMap.put(path, lock);
    		}
    	}
    	
    	return lock;
    }
    
}
