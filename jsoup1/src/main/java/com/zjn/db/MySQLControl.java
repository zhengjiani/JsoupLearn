package com.zjn.db;

import com.zjn.model.SModel;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class MySQLControl {
    //根据自己的数据库地址修改
    static DataSource ds = MyDataSource.getDataSource("jdbc:mysql://localhost:3306/db_ssq");
    static QueryRunner qr = new QueryRunner(ds);

    public static void executeInsert(List<SModel> data) throws SQLException {
        Object[][] params = new Object[data.size()][9];
        for (int i = 0; i < params.length; i++) {
            params[i][0] = data.get(i).getQiHao();
            params[i][1] = data.get(i).getRedNum1();
            params[i][2] = data.get(i).getRedNum2();
            params[i][3] = data.get(i).getRedNum3();
            params[i][4] = data.get(i).getRedNum4();
            params[i][5] = data.get(i).getRedNum5();
            params[i][6] = data.get(i).getRedNum6();
            params[i][7] = data.get(i).getBlueNum();
            params[i][8] = data.get(i).getKJDate();
        }
        qr.batch("insert into ssq (qiHao, redNum1, redNum2, redNum3, redNum4, redNum5, redNum6, blueNum, " +
                "kjDate)" + "values (?,?,?,?,?,?,?,?,?)", params);
        System.out.println("执行数据库完毕！" + "成功插入数据：" + data.size() + "条");

    }
}
