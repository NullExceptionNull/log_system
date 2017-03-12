package com.aisino.logtest;

import com.aisino.entity.Log;
import com.aisino.mapper.LogMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by zhangjianghong on 2017-2-24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:xml/spring-dao.xml")
public class LogTest implements Serializable {
    @Autowired
    private LogMapper logMapper;
    @Test
    public void test(){
        Log log = new Log();
        log.setIp("192.168.0.1");
        log.setLogtype(100);
        //log.setInserttime("1481873847391");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long l = Long.parseLong("1481873847391");
        Timestamp ts = new Timestamp(l);

        log.setInserttime(ts);
        int ret = logMapper.insert(log);
        System.out.println(ret);
    }
}