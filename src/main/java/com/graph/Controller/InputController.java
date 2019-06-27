package com.graph.Controller;

import com.graph.Domain.Input;
import com.graph.Domain.Result;
import com.graph.Service.InputService;
import com.graph.Util.ResponseResult;
import com.graph.Util.UseCMD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class InputController {
    @Autowired
    private InputService inputService;
    @PostMapping("/input")
    public ResponseResult InputText(@RequestBody Input input, HttpServletRequest httpServletRequest,Result ret) {
        ResponseResult<Result> roleResult = new ResponseResult<>();
        try {
            boolean result = inputService.inputText(input.getInput());
            Runtime.getRuntime().exec("cmd /c start /b java");
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
