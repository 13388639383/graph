package com.graph.Service.Impl;

import com.graph.Domain.Result;
import com.graph.Service.InputService;
import com.graph.Util.ReadCSV;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


@Service
public class InputServiceImpl implements InputService {

    @Override
    public boolean inputText(String text) throws IOException{
        try {
            String path = "D:\\test.txt";
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            // write
            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.flush();
            bw.close();
            fw.close();
            return true;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Result showMessage(String artname, String artinfo, String artclass) {
        Result result = new Result();
        ReadCSV readCSV = new ReadCSV();
        result.setArtname(readCSV.read(3,2));
        result.setArtinfo(readCSV.read(3,3));
        result.setArtclass(readCSV.read(3,4));
        return result;
    }
}
