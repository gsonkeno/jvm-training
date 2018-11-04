## 说明
文中示例代码一部分来自《深入理解JAVA虚拟机》，主要用来学习、训练，掌握巩固jvm相关知识
## jvm参数
-XX:+UseSerialGC 新生代常用的一种垃圾回收，串行回收，client模式下的默认GC方式
-XX:+HeapDumpOnOutOfMemoryError 
-XX:HeapDumpPath=d:/a.dump  内存溢出时，生成堆转储快照