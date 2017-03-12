package com.aisino.util;


import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileFilter;


/**
 * Created by zhangjianghong on 2017-2-24.
 */
public class FileUtils {
    private static Logger logger = Logger.getLogger(FileUtils.class);
    //获取到文件夹下面所有的文件

    /**
     *
     * @param path
     * @return 所有文件数组
     */
    public static File[] getFile(String path){
        if (path == null || path.equals("")){

            return null;
        }


        return  new File(path).listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (!pathname.getPath().endsWith(".gz"))
                    return false;
                return true;
            }
        });

    }
    /**
     * 判断文件夹下面文件是否有更新
     */


}
