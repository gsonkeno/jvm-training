package com.gsonkeno.jvmtraining.jconsole;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试jvisualVM的profiler功能
 * 分析cpu或内存，但是在“校准”时一直超时，未能真正测试
 */
@RestController
public class JvisualVMController {

    @RequestMapping(value = "/jVisualVM")
    public Map jvisualVm() throws InterruptedException {
        Thread.sleep(Math.round(Math.random()*1000));
        Map map = new HashMap();
        map.put("name","gs");
        map.put("age","25");

        return map;
    }
}
