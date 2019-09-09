package com.zq.multithread1.method.demo;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/9/5 20:50
 * @Version 1.0
 **/
public class Enter {
    PrintProcess printProcess;

    public Enter() {
        SaveProcess saveProcess = new SaveProcess();
        saveProcess.start();
         printProcess = new PrintProcess(saveProcess);
        printProcess.start();
        }

    public static void main(String[] args) {
        Request request = new Request();
        request.setName("zq");

        new Enter().doTest(request);

    }

    public void doTest(Request request){
        printProcess.processRequest(request);
    }
}
