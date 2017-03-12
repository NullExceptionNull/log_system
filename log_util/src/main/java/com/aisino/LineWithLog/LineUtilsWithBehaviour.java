package com.aisino.LineWithLog;

import com.aisino.entity.Behavior;
import com.aisino.mapper.BehaviorMapper;
import com.aisino.util.SpringUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangjianghong on 2017-2-27.
 */
public class LineUtilsWithBehaviour implements MethodWithLine {
    //private static Logger logger = LoggerFactory.getLogger(LineUtilsWithBehaviour.class);
    private static Logger logger = Logger.getLogger(LineUtilsWithBehaviour.class);

    private static LineUtilsWithBehaviour instance = new LineUtilsWithBehaviour();

    private LineUtilsWithBehaviour(){}

    public static LineUtilsWithBehaviour getInstance() {
        return instance;
    }


    private static Behavior behavior = new Behavior();

    public  void readByLine(String path){
        File file = new File(path);

        BufferedReader bf = null;

        String tempString = null;


        try {
            bf = new BufferedReader(new FileReader(file));


            while ((tempString = bf.readLine()) != null ){

                LineUtilsWithBehaviour.getInstance().doWithLine(tempString);
            }
            if((tempString = bf.readLine()) == null){
                bf.close();
            }
        } catch (Exception e) {
            logger.error("文件读取失败",e);
        }
    }

    public  void doWithLine(String line){
       if(line != null && !line.trim().equals("")){
           String[] strings = line.split("\\t");
           String taxcode = "";
           Integer machineNo = 0;
           String module = "";
           String moduletype = "";
           String modulefather = "";
           String time = "";
           String action = "";

           try {
               taxcode = strings[0];
               machineNo = Integer.valueOf(strings[1]);
               moduletype = strings[3];
               module = strings[4];
               action = strings[5];
               time = strings[6];
               if (strings.length > 7){
                   modulefather = strings[7];
               }

               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
               Date date = sdf.parse(time);
               behavior.setAction(action);
               behavior.setModule(module);
               behavior.setMachineno(machineNo);
               behavior.setModulefather(modulefather);
               behavior.setTime(date);
               behavior.setTaxcode(taxcode);
               behavior.setModulefather(modulefather);
               behavior.setModuletype(moduletype);
               BehaviorMapper behaviorMapper = SpringUtils.behaviorMapper;
               behaviorMapper.insert(behavior);

           }catch (Exception e){
               logger.error("插入失败",e);
           }
       }
    }
    public  void getAll(String path){

        File file  = new File(path);
        File[] files = file.listFiles();
        if (files != null && files.length != 0){
            for (File file1 : files) {

                LineUtilsWithBehaviour.getInstance().readByLine(file1.getPath());
               file1.delete();

            }

        }
        //return null;
    }
/*
    public static void main(String[] args) {
        LineUtilsWithBehaviour.getAll("C:\\Users\\zhangjianghong\\Desktop\\TEST\\Log\\log_behavior\\afterUnZip");
    }*/




}
