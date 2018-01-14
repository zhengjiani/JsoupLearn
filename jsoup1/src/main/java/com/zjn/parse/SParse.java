package com.zjn.parse;

import com.zjn.model.SModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class SParse {
    private static final String url = "http://datachart.500.com/ssq/history/history.shtml";
    public static List<SModel> getData (String html) throws Exception{
        //获取的数据，存放在集合中
        List<SModel> data = new ArrayList<SModel>();

        Document document = Jsoup.connect(url).timeout(5000).get();
        Elements elements=document.select(".t_tr1");

        for (Element ele:elements) {
            String qiHao = ele.select("td").get(0).text();
            String redNum1 = ele.select(".t_cfont2").get(0).text();
            String redNum2 = ele.select(".t_cfont2").get(1).text();
            String redNum3 = ele.select(".t_cfont2").get(2).text();
            String redNum4 = ele.select(".t_cfont2").get(3).text();
            String redNum5 = ele.select(".t_cfont2").get(4).text();
            String redNum6 = ele.select(".t_cfont2").get(5).text();
            String blueNum = ele.select(".t_cfont4").text();
            String kjDate = ele.select("td").get(15).text();
            SModel sModel=new SModel();
            sModel.setQiHao(qiHao);
            sModel.setRedNum1(redNum1);
            sModel.setRedNum2(redNum2);
            sModel.setRedNum3(redNum3);
            sModel.setRedNum4(redNum4);
            sModel.setRedNum5(redNum5);
            sModel.setRedNum6(redNum6);
            sModel.setBlueNum(blueNum);
            sModel.setKJDate(kjDate);


            data.add(sModel);
        }
        //返回数据
        return data;
    }

}
