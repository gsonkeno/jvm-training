package com.gsonkeno.jvmtraining.btrace;

import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

/**
 * 调试脚本
 */
@BTrace
public class TracingScript {
    @OnMethod(
            clazz = "com.gsonkeno.jvmtraining.btrace.BTraceTest",
            method = "add",
            location = @Location(Kind.RETURN)
    )

    public static void func(@Self com.gsonkeno.jvmtraining.btrace.BTraceTest instance,
                            int a, int b, @Return int result){
        println("调用堆栈:");
        jstack();
        println(strcat("方法参数A:", str(a)));
        println(strcat("方法参数B:", str(b)));
        println(strcat("方法结果:", str(result)));
    }

//    最终在jvisualvm工具面板BTrace一栏中打印出来的内容，类似如下:
//    调用堆栈:
//            com.gsonkeno.jvmtraining.btrace.BTraceTest.add(BTraceTest.java:9)
//            com.gsonkeno.jvmtraining.btrace.BTraceTest.main(Unknown Source)
//    方法参数A:754
//    方法参数B:584
//    方法结果:1338
//    调用堆栈:
//            com.gsonkeno.jvmtraining.btrace.BTraceTest.add(BTraceTest.java:9)
//            com.gsonkeno.jvmtraining.btrace.BTraceTest.main(Unknown Source)
//    方法参数A:106
//    方法参数B:309
//    方法结果:415
}
