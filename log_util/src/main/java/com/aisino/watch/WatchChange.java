package com.aisino.watch;

import com.aisino.util.GzipUtils;
import com.aisino.util.SpringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by zhangjianghong on 2017-3-7.
 */
public class WatchChange implements Runnable {


    //private static Logger logger = LoggerFactory.getLogger(WatchChange.class);
    private static Logger logger = Logger.getLogger(WatchChange.class);
    private String path;
    private WatchService watchService;
    private Map retRet;


    public WatchChange(String path ,WatchService watchService,Map retMap) {
        this.watchService = watchService;
        this.path = path;
        this.retRet = retMap;
    }

    public void run(){
        // watchService = FileSystems.getDefault().newWatchService();
        logger.info("文件系统开始监控"+path);
        try {

            Paths.get(path).register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        }catch (Exception e){
            throw new RuntimeException("文件初始化系统注册失败");
        }

        File file = new File(path);
        LinkedList<File> flist = new LinkedList<File>();
        flist.add(file);
        while (flist.size() > 0){
            File f = flist.removeFirst(); //取到第一个文件夹
            if (f.listFiles() == null){
                continue;
            }
            //喜闻乐见
            for (File file1 : f.listFiles()) {
               if(file1.isDirectory()){
                    flist.add(file1);
                    //依次注册子目录
                   try {
                       Paths.get(file1.getAbsolutePath()).register(watchService,StandardWatchEventKinds.ENTRY_CREATE);
                   } catch (IOException e) {
                       logger.error(file1+"{}文件监控失败",e);
                   }
               }
            }

        }
        while (true){
           // final
            WatchKey key = null;
            try {
                key = watchService.take();
            } catch (InterruptedException e) {
                throw new RuntimeException("监控失败");
            }
            for (WatchEvent<?> watchEvent : key.pollEvents()) {
                final WatchEvent.Kind<?> kind = watchEvent.kind();
                if (kind == StandardWatchEventKinds.ENTRY_CREATE){
                    final WatchEvent<Path> watchEventPath = (WatchEvent<Path>) watchEvent;

                    final Path filename = watchEventPath.context();
                    if (!filename.toString().endsWith(".gz"))
                        break;
                    retRet.put("ischange",true);
                    retRet.put("filename",filename);
                    retRet.put("path",path.substring(8));
                    logger.info("文件系统有更新"+filename);
                    //准备
                    //System.out.println(SpringUtils.judge(filename.toString())+filename);
                    byte[] bytes = GzipUtils.getBytes(SpringUtils.judge(filename.toString())+filename);
                    byte[] unGZip = GzipUtils.unGZip(bytes);
                    String desPath = SpringUtils.judgeDes(filename.toString());
                    GzipUtils.getFile(unGZip,desPath,filename.toString().replace(".gz",""));
                    logger.info(file.getName()+":解压缩并更改文件名");

                    //准备入库
                    //SpringUtils.judgePosition(filename.toString()).getClass().getMethod()
                    SpringUtils.getMethod(filename.toString()).getAll(desPath);

                }
                boolean valid = key.reset();
                if (!valid){
                    break;
                }
            }

        }
    }

    //辨別文件夾來源

  /*  public static void main(String[] args) throws Exception {

    }*/

}
