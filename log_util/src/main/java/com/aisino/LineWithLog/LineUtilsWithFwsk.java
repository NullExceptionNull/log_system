package com.aisino.LineWithLog;

import com.aisino.entity.Invoiceerror;
import com.aisino.entity.Log;
import com.aisino.mapper.InvoiceerrorMapper;
import com.aisino.util.SpringUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangjianghong on 2017-2-28.
 */
public class LineUtilsWithFwsk implements MethodWithLine {
    private static Logger logger = Logger.getLogger(LineUtilsWithFwsk.class);
    private static Invoiceerror invoiceerror = new Invoiceerror();

    private static LineUtilsWithFwsk instance = new LineUtilsWithFwsk();

    private LineUtilsWithFwsk() {
    }

    public static LineUtilsWithFwsk getInstance() {
        return instance;
    }

    public void readByLine(String path) {
        File file = new File(path);

        BufferedReader bf = null;

        String tempString = null;

        Log log = new Log();

        try {
            bf = new BufferedReader(new FileReader(file));


            while ((tempString = bf.readLine()) != null) {

                LineUtilsWithFwsk.getInstance().doWithLine(tempString);
            }
            if ((tempString = bf.readLine()) == null) {
                bf.close();
            }
        } catch (Exception e) {
            logger.error("文件读取失败", e);
        }
    }

    public void doWithLine(String line) {
        //System.out.println(line);
        String taxcode = "";
        String module = "";
        String content = "";
        String code = "";
        String extension = "";
        String inserttime = "";
        short machineno = -1;
        String[] strings = line.split("\t");
        try {
            taxcode = strings[0];
            machineno = Short.parseShort(strings[1]);
            inserttime = strings[2];
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(inserttime);
            module = strings[3];
            content = strings[4];
            code = strings[6];
            extension = strings[7];
            invoiceerror.setModule(module);
            invoiceerror.setInserttime(date);
            invoiceerror.setCode(code);
            invoiceerror.setContent(content);
            invoiceerror.setTaxcode(taxcode);
            //invoiceerror.setEid(Long.valueOf(eid));
            invoiceerror.setExtension(extension);
            invoiceerror.setMachineno(machineno);
            InvoiceerrorMapper mapper = SpringUtils.invoiceerrorMapper;
            mapper.insert(invoiceerror);

        } catch (Exception e) {
            logger.error("插入错误", e);
        }


    }

    public void getAll(String path) {

        File file = new File(path);
        File[] files = file.listFiles();
        if (files != null && files.length != 0) {
            for (File file1 : files) {

                LineUtilsWithFwsk.getInstance().readByLine(file1.getPath());
                file1.delete();
            }
        }
        //return null;
    }

   /* public static void main(String[] args) {
        new LineUtilsWithFwsk().getAll("C:\\Users\\zhangjianghong\\Desktop\\新建文件夹\\log1484269521880\\log1484269521880");
    }*/


}
