package com.zq.multithread1.method.demo;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/9/5 20:25
 * @Version 1.0
 **/
public class PrintProcess extends Thread implements RequestProcessor {
    LinkedBlockingQueue<Request> linkedBlockingQueue = new LinkedBlockingQueue<>();

    private  RequestProcessor nextProcessor;

    public PrintProcess(RequestProcessor requestProcessor) {
        this.nextProcessor = requestProcessor;
    }

    @Override
    public void run() {
        while (true){
            try {
                Request take = linkedBlockingQueue.take();
                System.out.println(take+"打印");
                nextProcessor.processRequest(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }

    @Override
    public void processRequest(Request request) {
        linkedBlockingQueue.add(request);
    }
}
