package com.aisino.util;

import org.apache.log4j.Logger;

import java.io.File;

/**
 * Created by zhangjianghong on 2017-3-7.
 */
public class BatchUnzip  {

    private static Logger logger = Logger.getLogger(BatchUnzip.class);
    /**
     * 批量解压缩
     * @param
     */

    public static void run(String path,String desPath) {
        //首先获得全部的文件;
        try {
            BatchUnzip.unzipFile(path,desPath);
        } catch (Exception e) {
            logger.error("日志解压缩失败",e);
        }

    }

    public static void unzipFile(String path,String desPath)  {
       try {
            File[] files = FileUtils.getFile(path);

            if (files == null){
                logger.error("空文件夹");
                return ;
            }
            for (File file : files) {
                byte[] bytes = GzipUtils.getBytes(file.getPath());
                byte[] unGZip = GzipUtils.unGZip(bytes);
                GzipUtils.getFile(unGZip,desPath,file.getName().replace(".gz",""));
                logger.info(file.getName()+":解压缩并更改文件名");
            }
        } catch (Exception e){

           logger.error("解压缩失败",e);
        }

    }
}
