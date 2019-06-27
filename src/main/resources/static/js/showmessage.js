$(function(){
    var username;
    $.ajax({
        url: '/show',
        type: 'GET',
        dataType: 'json',
        success: function(root){
            var json=root;
            var id = json.id;
            username = json.username;
            var password = json.password;
            var email = json.email;
            var phone = json.phone;
            $("a.nav-link").append(username);
            $("h3.fs-subtitle").append(username);
            $("h4.fs-subtitle").append(password);
            $("h5.fs-subtitle").append(email);
            $("h6.fs-subtitle").append(phone);
        },
        error: function() {
            alert('异常！');
        },
    });
    $('#change').click(function(){
        var password = $('#password').val();
        var email = $('#email').val();
        var phone = $('#phone').val();
        if(email==''||password==''||phone==''){
            layer.msg('用户信息不能为空');
        }else{
            var userdata = {
                username:username,
                password:password,
                email:email,
                phone:phone
            };

            $.ajax({
                url: '/change',
                type: 'POST',
                dataType:'json',
                data:JSON.stringify(userdata),
                contentType: "application/json",
                success:function(result){
                        alert(result.message);
                },
                error:function(){
                    alert("error");
                    layer.msg('登陆失败，请检查网络连接');
                }
            });
        }
    });
});