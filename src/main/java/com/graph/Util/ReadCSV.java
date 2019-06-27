package com.graph.Util;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCSV {
    private String last;
    public  String  read(int row,int col){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\test.csv"));//换成你的文件名
            // reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;
            int index=0;
            while((line=reader.readLine())!=null){
                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                if(index==row-1){
                    if(item.length>=col-1){
                        last = item[col-1];//这就是你要的数据了
                        System.out.println(last);
                    }
                }
                //int value = Integer.parseInt(last);//如果是数值，可以转化为数值
                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return last;
    }
}
