package com.company.base.chapter14;

import java.io.File;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.*;

public class BlockingQueue {
    private static final int SEARCH_THREAD = 10;
    private static final String Keyword = "getProperty";
    private static final File Search_Dir = new File("X:\\Workspace\\Java\\src");
    private static LinkedBlockingQueue<File> queue = new LinkedBlockingQueue();
    private static final File DUMMY = new File("");
//    private static volatile boolean done = false;  // 不适合用volatile修饰，因为有多个线程读，跟书上的  1写1读有区别

    public static void main(String[] args) {
        // 阻塞队列的操作分类
        // 满队或者空队将阻塞   put 添加 take 移出
        // 满队或者空队将报异常 add 添加 element 返回头元素 remove 移出并返回头元素
        // 满队或者空队将不报异常，知识返回null或false offer 添加  peek 返回头元素 poll 移出并返回

        // 阻塞队列
//        LinkedBlockingQueue 默认不限大小，可以设置大小
//        LinkedBlockingDeque 双端队列
//        ArrayBlockingQueue 需要指定容量大小，可以设置公平性
//        PriorityQueue 带优先级的队列，容量无上限
//        DelayQueue 延迟队列，只有延迟 <0 时才能移出
//        LinkedTransferQueue 生产者消费者队列

        long start = System.currentTimeMillis();

        // 搜索文件
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    enumerate(Search_Dir);
                    queue.put(DUMMY);
                    System.out.println("thread death:" + Thread.currentThread().getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for (int i=0;i<SEARCH_THREAD;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 每个线程都有一个done变量
                    // 缺点是多了 SEARCH_THREAD 个空file插入queue，造成浪费
                    boolean done = false;
                    while(!done){
                        try {
                            File file = queue.take();
                            if (file == DUMMY){
                                queue.put(file);
                                done = true;
                            }else{
                                Search(file,Keyword);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    System.out.println("thread death:" + Thread.currentThread().getId());
                }
            }).start();
        }
    }

    // 递归
    private static void enumerate(File dir) throws InterruptedException {
        File[] files = dir.listFiles();
        for (File file : files){
            if (file.isDirectory()){
                enumerate(file);
            }else{
                queue.put(file);
            }
        }
    }

    private static void Search(File file, String keyword){
        try (Scanner in = new Scanner(file, "UTF-8")){
            int lineNumber = 0;
            while (in.hasNext()){
                String line = in.nextLine();
                if (line.contains(keyword)){
                    System.out.printf("%s--line:%s\r\n", file.getPath(), lineNumber);
                }
                lineNumber++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
