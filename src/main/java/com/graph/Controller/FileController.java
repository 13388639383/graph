package com.graph.Controller;

import com.graph.Domain.Result;
import com.graph.Util.ResponseResult;
import com.graph.Util.ThreadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FileController {

    private List<String> stdoutList = new ArrayList<String>();
    private List<String> erroroutList = new ArrayList<String>();
    Process p1 = null;
    Process p2 = null;
    Process p3 = null;
    Process p4 = null;
    Process p5 = null;
    @GetMapping("/getfile")
    public ResponseResult GetFile() {
        ResponseResult<Result> Result = new ResponseResult<>();
        try {
//            stdoutList.clear();
//            erroroutList.clear();
//            System.out.println("0");
//            p1 = Runtime.getRuntime().exec("cmd /c python D:/pythonworkspace/testb_preprocess.py");
//            p1.waitFor();
//            System.out.println("1");
//            p2 = Runtime.getRuntime().exec("cmd /c python D:/Downloads/tf_ner-master/data/example/build_vocab.py");
//            p2.waitFor();
//            System.out.println("2");
//            p3 = Runtime.getRuntime().exec("cmd /c python D:/Downloads/tf_ner-master/data/example/build_glove.py");
//            p3.waitFor();
//            System.out.println("3");
//            p4 = Runtime.getRuntime().exec("cmd /c python D:/Downloads/tf_ner-master/models/lstm_crf/main.py");
//            // 创建2个线程，分别读取输入流缓冲区和错误流缓冲区
//            ThreadUtil stdoutUtil = new ThreadUtil(p4.getInputStream(), stdoutList);
//            ThreadUtil erroroutUtil = new ThreadUtil(p4.getErrorStream(), erroroutList);
//            //启动线程读取缓冲区数据
//            stdoutUtil.start();
//            erroroutUtil.start();
//            p4.waitFor();
//            System.out.println("4");
//            p5 = Runtime.getRuntime().exec("cmd /c python D:/pythonworkspace/testb_process.py");
//            p5.waitFor();
//            System.out.println("5");
            Result.setMessage("成功");
            Result.setData(null);
            Result.setStatus(ResponseResult.STATE_OK);

        } catch (Exception e) {
            e.printStackTrace();
            Result.setStatus(ResponseResult.STATE_ERROR);
            Result.setData(null);
            Result.setMessage("异常");
        }
        return Result;

    }
}
