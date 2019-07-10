package com.graph.Controller;

import com.graph.Domain.Result;
import com.graph.Util.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {
    @GetMapping("/getfile")
    public ResponseResult GetFile() {
        ResponseResult<Result> Result = new ResponseResult<>();
        try {
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
