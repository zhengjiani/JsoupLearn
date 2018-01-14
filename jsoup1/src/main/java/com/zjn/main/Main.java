package com.zjn.main;

import com.zjn.Utils.URLFecter;
import com.zjn.db.MySQLControl;
import com.zjn.model.SModel;

import com.zjn.parse.SParse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static final Log logger = LogFactory.getLog(Main.class);

    public static void main(String[] args) throws Exception {
        HttpClient client = new DefaultHttpClient();
         String url = "http://datachart.500.com/ssq/history/history.shtml";
        List<SModel> datas= URLFecter.URLParser(client, url);
         for(SModel ss:datas){
            logger.info("qiHao:"+ss.getQiHao()+"\t"+"redNum1"+ss.getRedNum1()
            +"redNum2"+ss.getRedNum2()+"redNum3"+ss.getRedNum3()+"redNum4"+ss.getRedNum4()
            +"redNum5"+ss.getRedNum5()+"redNum6"+ss.getRedNum6()+"blueNum"+ss.getBlueNum()
                    +"kjDate"+ss.getKJDate());
        }
        MySQLControl.executeInsert(datas);
    }
}
