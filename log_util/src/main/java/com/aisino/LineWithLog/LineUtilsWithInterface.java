package com.aisino.LineWithLog;

import com.aisino.entity.Log;
import com.aisino.mapper.LogMapper;
import com.aisino.util.SpringUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by zhangjianghong on 2017-2-24.
 */
public class LineUtilsWithInterface implements MethodWithLine {

    private static Logger logger = Logger.getLogger(LineUtilsWithInterface.class);
    private static Log log = new Log();

    private static LineUtilsWithInterface instance = new LineUtilsWithInterface();

    public LineUtilsWithInterface(){};

    public static LineUtilsWithInterface getInstance(){
        return instance;
    }




    public  void readByLine(String path){
        File file = new File(path);

        BufferedReader bf = null;

        String tempString = null;

        Log log = new Log();

        try {
            bf = new BufferedReader(new FileReader(file));


            while ((tempString = bf.readLine()) != null ){

                LineUtilsWithInterface.getInstance().doWithLine(tempString);
            }
            if((tempString = bf.readLine()) == null){
                bf.close();
            }
        } catch (Exception e) {
            logger.error("文件读取失败",e);
        }
    }

    public  void doWithLine(String line){
        String time = "";
        String content = "";
        String logType = "";
        String ip = "";

        if (line.startsWith("Time")){
            //System.out.println(line);
            String[] info = line.split("\\|\\|");
            time = info[0].split("=")[1].trim();
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long ltime = Long.parseLong(time);
            Timestamp ts = new Timestamp(ltime);
            content = info[2].substring(9);
            //System.out.println(content.trim());
            if(info.length >= 4 ){
                ip = info[3].split("=")[1];
                //System.out.println(ip);
            }

            logType = info[1].split("=")[1].trim();
            log.setContent(content);
            log.setIp(ip);
            log.setInserttime(ts);
            log.setLogtype(Integer.valueOf(logType));
            //log.setContent("--");

            LogMapper mapper = SpringUtils.logMapper;
            mapper.insert(log);

        }

    }
    public  void getAll(String path){

        File file  = new File(path);
        File[] files = file.listFiles();
        if (files != null && files.length != 0){
            for (File file1 : files) {

                LineUtilsWithInterface.getInstance().readByLine(file1.getPath());
                file1.delete();


            }
        }
        //return null;
    }




}
