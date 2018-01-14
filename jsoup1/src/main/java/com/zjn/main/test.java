package com.zjn.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {
   private static final String url = "http://datachart.500.com/ssq/history/history.shtml";
    public static void main(String[] args) {
       try {
          //获取整个网站的根节点，也就是html开头部分一直到结束
           Document document = Jsoup.connect(url).timeout(50000).get();
          Elements elements=document.select(".t_tr1");
           List<String> qiHao=new ArrayList<String>();
          for(Element e:elements){
              String qiHao1=e.select("td").get(0).text();
              qiHao.add(qiHao1);
              }

               System.out.println(qiHao);


       } catch (IOException e) {
          e.printStackTrace();
        }
 }

    }

