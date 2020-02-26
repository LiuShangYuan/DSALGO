package concurrent;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class SimpleDateFormatTest {
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Test
    public void test(){
        for (int i=0;i<10000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {//(3)使用单例日期实例解析文本
                        System.out.println(dateTimeFormatter.parse("2017-12-13 15:17:27"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    // 循环依赖
    @Test
    public void testCycleDep(){
        A a = new A();
    }
}

class A{
    B b;
    A(){
        b = new B();
    }
}

class B{
    A a;
    B(){
        a = new A();
    }
}