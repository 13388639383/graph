$(function(){

    $('#register').click(function(){

        var username = $('#username').val();
        var password = $('#password').val();
        var phone = $('#phone').val();
        var password0 = $('#password0').val();
        var email = $('#email').val();
        if(username==''||password==''||email==''||phone==''){
            layer.msg('信息不能为空');
        }else if(password!=password0) {
           layer.msg('两次密码输入不一致');
        }else{
            var registerData = {
                username:username,
                password:password,
                phone:phone,
                email:email
            }
            $.ajax({
                url: '/regist',
                type: 'POST',
                dataType:'json',
                data:JSON.stringify(registerData),
                contentType: "application/json",
                success:function(result){
                    if(result.status==1){
                        layer.msg(result.message);
                        setTimeout(function(){
                            window.location.href="graph.html";
                        },1500);
                    }else{
                        layer.msg(result.message);
                    }
                },
                error:function(){
                    layer.msg('注册失败，请检查网络连接');
                }
            });
        }
        

    })

})