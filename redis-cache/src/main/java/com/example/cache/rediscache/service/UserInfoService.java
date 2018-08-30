package com.example.cache.rediscache.service;

import com.example.cache.rediscache.mapper.UserMapper;
import com.example.cache.rediscache.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author haijun
 * @create 2018 - 08 - 22 - 11:03
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "user")
public class UserInfoService {

    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "getUserInfo", key = "#root.targetClass.getName()", unless = "#result eq null")
    public UserInfo getUserInfo() {
        log.info("准备访问数据库");
        return userMapper.getUserInfo(1);
    }

//    @Cacheable(value = "getUserListInfo", key = "#root.targetClass.getName()", unless = "#result eq null")
//    public List<UserInfo> getUserListInfo() {
//        log.info("准备访问数据库");
//        return userMapper.getUserListInfo();
//    }

    public Integer getCountUser() {

        List<String> mobile = new ArrayList<>();//2002
        int i = 1000;

        int countThread = (mobile.size() - mobile.size() % i) / i;
        for (int j = 0; j < countThread; j++) {

            new Runnable() {
                Integer begin = 0;
                Integer end = i;

                @Override
                public void run() {
                    Integer c2 = userMapper.getUserListInfoV1(begin, end);
                }
            };
            if (mobile.size() % i != 0) {

            }

        }

        return null;
    }

    /**
     * 将一组数据平均分成n组
     *
     * @param source 要分组的数据源
     * @param n      平均分成n组
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> averageAssign(List<T> source, int n) {
        List<List<T>> result = new ArrayList<List<T>>();
        int remainder = source.size() % n;  //(先计算出余数)
        int number = source.size() / n;  //然后是商
        int offset = 0;//偏移量
        for (int i = 0; i < n; i++) {
            List<T> value = null;
            if (remainder > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remainder--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }
        return result;
    }


    public static void t1() throws Exception {
        // 开始时间
        long start = System.currentTimeMillis();
        // 模拟数据List
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= 3000; i++) {
            list.add(i + "");
        }
        // 每500条数据开启一条线程
        int threadSize = 500;
        // 总数据条数
        int dataSize = list.size();
        // 线程数
        int threadNum = dataSize / threadSize + 1;
        // 定义标记,过滤threadNum为整数
        boolean special = dataSize % threadSize == 0;
        // 创建一个线程池
        ExecutorService exec = Executors.newFixedThreadPool(threadNum);
        // 定义一个任务集合
        List<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>();
        Callable<Integer> task = null;
        List<String> cutList = null;
        // 确定每条线程的数据
        for (int i = 0; i < threadNum; i++) {
            if (i == threadNum - 1) {
                if (special) {
                    break;
                }
                cutList = list.subList(threadSize * i, dataSize);
            } else {
                cutList = list.subList(threadSize * i, threadSize * (i + 1));
            }
            // System.out.println("第" + (i + 1) + "组：" + cutList.toString());
            final List<String> listStr = cutList;
            task = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    System.out.println(Thread.currentThread().getName() + "线程：" + listStr);
                    return 1;
                }
            };
            // 这里提交的任务容器列表和返回的Future列表存在顺序对应的关系
            tasks.add(task);
        }
        List<Future<Integer>> results = exec.invokeAll(tasks);
        for (Future<Integer> future : results) {
            System.out.println(future.get());
        }
        // 关闭线程池
        exec.shutdown();
        System.out.println("线程任务执行结束");
        System.err.println("执行任务消耗了 ：" + (System.currentTimeMillis() - start) + "毫秒");
    }

    public static void main(String[] args) throws Exception {
        t1();
    }
}
