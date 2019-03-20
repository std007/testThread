package com.testthread.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class Test {

    public static void main(String[] args) {
        Map<String, Object> resultMap = new HashMap<>();
        int count = 10;
        ExecutorService executorService = newFixedThreadPool(10);
        long start = System.currentTimeMillis();
        try {
            List<FutureTask> list = new ArrayList();
            for (int i = 0; i < count; i++) {
                FutureTask<Map<String, Object>> result = new FutureTask<Map<String, Object>>(myCall(i + ""));
                executorService.submit(result);
                list.add(result);
            }
            for (int i = 0; i < count; i++) {
                Map<String, Object> resultMapShow = (Map<String, Object>) list.get(i).get();
                System.out.println("resultMapShow = " + resultMapShow);
                Map<String, Object> body = (Map<String, Object>) resultMapShow.get("body");
                resultMap.put("aa" + i, body.get("aa"));
            }
            System.out.println("====>took:" + (System.currentTimeMillis() - start));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        System.out.println("resultMap = " + resultMap);
        System.out.println("==>took:" + (System.currentTimeMillis() - start));
    }


    public static Callable<Map<String, Object>> myCall(String taskId) {
        Callable<Map<String, Object>> callable = new Callable<Map<String, Object>>() {
            @Override
            public Map<String, Object> call() throws Exception {
                return queryMethod(taskId);
            }
        };
        return callable;
    }

    private static Map<String, Object> queryMethod(String taskId) {
        try {
            System.out.println(" ==>任务启动" + taskId);
            long startI = System.currentTimeMillis();
            Thread.sleep(500);
//            System.out.println("   sleep:500ms");
            System.out.println(" ==>任务终止" + taskId + " 任务时间:" + (System.currentTimeMillis() - startI));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> head = new HashMap<>();
        head.put("retFlag", "0000");
        head.put("retMsg", "成功");
        Map<String, Object> body = new HashMap<>();
        body.put("aa", "11");
        resultMap.put("head", head);
        resultMap.put("body", body);
        return resultMap;
    }
}