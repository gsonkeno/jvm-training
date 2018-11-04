package com.gsonkeno.jvmtraining;

import com.gsonkeno.jvmtraining.utils.HttpUtils;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JvisualVMControllerTest {

    @Test
    public void test() throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 20; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        HttpUtils.get("http://127.0.0.1:8080/jVisualVM",null,5000,5000);
                    }
                }
            });
        }
        Thread.sleep(600*1000);

    }
}
