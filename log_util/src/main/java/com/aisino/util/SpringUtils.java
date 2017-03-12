package com.aisino.util;

import com.aisino.LineWithLog.LineUtilsWithBehaviour;
import com.aisino.LineWithLog.LineUtilsWithFwsk;
import com.aisino.LineWithLog.LineUtilsWithInterface;
import com.aisino.LineWithLog.MethodWithLine;
import com.aisino.mapper.BehaviorMapper;
import com.aisino.mapper.InvoiceerrorMapper;
import com.aisino.mapper.LogMapper;
import com.aisino.watch.WatchChange;
import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by zhangjianghong on 2017-2-24.
 */
public class SpringUtils {
    private static Logger logger = Logger.getLogger(FileUtils.class);
    public static LogMapper logMapper;
    public static BehaviorMapper behaviorMapper;
    public static InvoiceerrorMapper invoiceerrorMapper;

    private  static boolean flag = false;

    static Properties p = new Properties();
    static InputStream inputStream = FileUtils.class.getResourceAsStream("/xml/File.properties");
    static String errorpath = "";
    static String errorPathdes = "";
    static String Behaviorlogpath = "";
    static String Behaviorlogpathdes = "";
    static String interfacelogpath = "";
    static String interfacePathdes = "";
    static String parentpath = "";
    static WatchService watchService;
    static Map retMap = new HashMap();


    static {
        p = new Properties();
        inputStream = FileUtils.class.getResourceAsStream("/xml/File.properties");
        try {
            p.load(inputStream);
            errorpath = p.getProperty("errorpath");
            errorPathdes = p.getProperty("errorPathdes");
            Behaviorlogpath = p.getProperty("Behaviorlogpath");
            Behaviorlogpathdes = p.getProperty("Behaviorlogpathdes");
            interfacelogpath = p.getProperty("interfacelogpath");
            interfacePathdes = p.getProperty("interfacePathdes");
            parentpath = p.getProperty("parentpath");
            watchService = FileSystems.getDefault().newWatchService();

            logger.info("加载文件位置信息成功");

            GenericXmlApplicationContext context = new GenericXmlApplicationContext();
            context.setValidating(false);

            context.load("classpath:xml/spring-dao.xml");
            context.refresh();
            logMapper = context.getBean(LogMapper.class);
            behaviorMapper = context.getBean(BehaviorMapper.class);
            invoiceerrorMapper = context.getBean(InvoiceerrorMapper.class);
            logger.info("SPRING 配置加载成功");
        } catch (Exception e) {
            throw new RuntimeException("加载配置文件失败");
        }
    }


    public static String judge(String name){
        String changePath  = "";
        if (name.startsWith("l")){
            changePath = errorpath;
        }else if (name.startsWith("b")){
            changePath = Behaviorlogpath;
        }else {
            changePath = interfacelogpath;
        }
        return changePath;
    }

    public static String judgeDes(String name){
        String desPath  = "";
        if (name.startsWith("l")){
            desPath = errorPathdes;
        }else if (name.startsWith("b")){
            desPath = Behaviorlogpathdes;
        }else {
            desPath = interfacePathdes;
        }
        return desPath;
    }

    public static MethodWithLine getMethod(String name){
        MethodWithLine changeMethd  = null;
        if (name.startsWith("l")){
            changeMethd = LineUtilsWithFwsk.getInstance();
        }else if (name.startsWith("b")){
            changeMethd = LineUtilsWithBehaviour.getInstance();
        }else {
            changeMethd = LineUtilsWithInterface.getInstance();
        }
        return changeMethd;
    }



    public static void main(String[] args) throws IOException, InterruptedException {
         new Thread(new WatchChange(parentpath,watchService,retMap),"watch").start();




//        Path error = Paths.get(errorpath);
//        Path behavior = Paths.get(Behaviorlogpath);
//        Path interfacePath = Paths.get(interfacelogpath);
//        List pathList = new ArrayList();
//        Map pathMap = new HashMap();
//        pathMap.put(errorpath,errorPathdes);
//        pathMap.put(Behaviorlogpath,Behaviorlogpathdes);
//        pathMap.put(interfacelogpath,interfacePathdes);
//        pathList.add(error);
//        pathList.add(behavior);
//        pathList.add(interfacePath);

        //迭代

//        while (true) {
//            Map retMap = null;
//            for (int i = 0; i < pathList.size(); i++) {
//                logger.info("新增文件--");
//                /*if((retMap = WatchChange.watchDir((Path)pathList.get(i))) != null){
//                    String path = String.valueOf((retMap.get("path")));
//                    new Thread(new BatchUnzip(path.substring(8), pathMap.get(path.substring(8)).toString())).start();
//                }*/
//            }
//
//        }




            //开始解压缩
           /* Thread errorThread =
            errorThread.start();*/

        /*Thread unzipThread = new Thread(new BatchUnzip(), "unzip");
        unzipThread.start();*/
      /*  GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.setValidating(false);

        context.load("classpath:xml/spring-dao.xml");
        context.refresh();
        logMapper = context.getBean(LogMapper.class);
        behaviorMapper = context.getBean(BehaviorMapper.class);
        invoiceerrorMapper = context.getBean(InvoiceerrorMapper.class);
        //
        while (true){
            if (isExit())
                //LineUtilsWithInterface.getAll(desPath);
                //LineUtilsWithBehaviour.getAll(desPath);
                LineUtilsWithFwsk.getAll(desPath);
        }*/

    }


}