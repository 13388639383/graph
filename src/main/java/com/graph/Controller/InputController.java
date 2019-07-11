package com.graph.Controller;

import com.graph.Domain.Input;
import com.graph.Domain.Result;
import com.graph.Service.InputService;
import com.graph.Util.ResponseResult;
import com.graph.Util.ThreadUtil;
import com.graph.Util.UseCMD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class InputController {
    @Autowired
    private InputService inputService;
    private List<String> stdoutList = new ArrayList<String>();
    private List<String> erroroutList = new ArrayList<String>();
    Process p1 = null;
    Process p2 = null;
    Process p3 = null;
    Process p4 = null;
    Process p5 = null;
    @PostMapping("/input")
    public ResponseResult InputText(@RequestBody Input input, HttpServletRequest httpServletRequest,Result ret) {
        ResponseResult<Result> roleResult = new ResponseResult<>();
        try {
            boolean result = inputService.inputText(input.getInput());
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
            HttpSession httpSession = httpServletRequest.getSession();
            if(null == httpSession.getAttribute("user")){
                roleResult.setMessage("请先登录");
                roleResult.setData(null);
                roleResult.setStatus(ResponseResult.STATE_ERROR);
            }else {
                if (result) {
                    roleResult.setMessage("成功");
                    roleResult.setData(inputService.showMessage(ret.getArtname(),ret.getArtinfo(),ret.getArtclass()));
                    roleResult.setStatus(ResponseResult.STATE_OK);
                } else {
                    System.out.println("失败");
                    roleResult.setStatus(ResponseResult.STATE_ERROR);
                    roleResult.setData(null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            roleResult.setStatus(ResponseResult.STATE_ERROR);
            roleResult.setData(null);
            roleResult.setMessage("异常");
        }
        return roleResult;

    }
}

