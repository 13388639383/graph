package com.graph.Controller;

import com.graph.Domain.User;
import com.graph.Service.UserService;
import com.graph.Util.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    private final UserService userService;

    private static Logger userLogger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseResult<User> userLogin(@RequestBody User user, HttpServletRequest httpServletRequest){
        ResponseResult<User> userResponseResult = new ResponseResult<>();
        HttpSession httpSession = httpServletRequest.getSession();
        userLogger.info("用户登录->["+user+"]");
        try {
            httpSession.setAttribute("user",user);
            httpSession.setAttribute("username",user.getUsername());
            userResponseResult.setMessage("登录成功");
            userResponseResult.setData(userService.UserLogin(user.getUsername(),user.getPassword()));
            userResponseResult.setStatus(ResponseResult.STATE_OK);

        }catch (Exception e){
            e.printStackTrace();
            userResponseResult.setStatus(ResponseResult.STATE_ERROR);
            userResponseResult.setData(null);
            userResponseResult.setMessage("用户名或密码不正确");
        }
        return userResponseResult;
    }

    @PostMapping("/regist")
    public ResponseResult<Boolean> userRegist(@RequestBody User user){
        ResponseResult<Boolean> responseResult = new ResponseResult<>();
        System.out.println("用户注册"+user);
        try {
            boolean result = userService.userRegist(user.getUsername(),user.getEmail(),user.getPassword(),user.getPhone());
            if (result){
                System.out.println("注册成功");
                responseResult.setMessage("注册成功");
                responseResult.setData(true);
                responseResult.setStatus(ResponseResult.STATE_OK);
            }else{
                System.out.println("该账户已被注册");
                responseResult.setStatus(ResponseResult.STATE_ERROR);
                responseResult.setData(false);
                responseResult.setMessage("该账号已被注册");
            }

        }catch (Exception e){
            e.printStackTrace();
            responseResult.setStatus(ResponseResult.STATE_ERROR);
            responseResult.setData(false);
            responseResult.setMessage("异常");
        }
        return responseResult;
    }
    @GetMapping("/show")
    public User getUserMessage( HttpServletRequest httpServletRequest){
        HttpSession httpSession = httpServletRequest.getSession();
        String username = (String)httpSession.getAttribute("username");
        User user = userService.getMessage(username);
        userLogger.info("["+user+"]");
        return user;
    }
    @PostMapping("/change")
    public ResponseResult<Boolean> userChange(@RequestBody User user, HttpServletRequest httpServletRequest){
        ResponseResult<Boolean> userResponseResult = new ResponseResult<>();
        HttpSession httpSession = httpServletRequest.getSession();
        userLogger.info("用户修改->["+user+"]");
        try {
            boolean result = userService.userChange(user.getUsername(),user.getEmail(),user.getPassword(),user.getPhone());
            if(result) {
                httpSession.setAttribute("user", user);
                httpSession.setAttribute("username", user.getUsername());
                userResponseResult.setMessage("修改成功");
                userResponseResult.setData(true);
                userResponseResult.setStatus(ResponseResult.STATE_OK);
            }else{
                userResponseResult.setMessage("修改失败");
                userResponseResult.setData(false);
                userResponseResult.setStatus(ResponseResult.STATE_ERROR);
            }

        }catch (Exception e){
            e.printStackTrace();
            userResponseResult.setStatus(ResponseResult.STATE_ERROR);
            userResponseResult.setData(false);
            userResponseResult.setMessage("用户名或密码不正确");
        }
        return userResponseResult;
    }
    @PostMapping("/logout")
    public ResponseResult<Boolean> userlogout(HttpServletRequest httpServletRequest){
        System.out.println("用户注销");
        HttpSession httpSession = httpServletRequest.getSession();
        ResponseResult<Boolean> responseResult = new ResponseResult<>();
        httpSession.removeAttribute("user");
        httpSession.removeAttribute("username");
        httpSession.invalidate();
        responseResult.setMessage("注销成功");
        responseResult.setStatus(ResponseResult.STATE_OK);
        responseResult.setData(true);
        return responseResult;
    }
}
