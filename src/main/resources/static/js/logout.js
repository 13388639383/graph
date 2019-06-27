$(function(){

    $('#user').html(window.sessionStorage.getItem('user'));
    $('#User').html(window.sessionStorage.getItem('user'));

    $('#logout').click(function(){

        $.ajax({
            url: '/logout',
            type: 'POST',
            dataType:'json',
            contentType: "application/json",
            success:function(result){
                if(result.status==1){
                    window.sessionStorage.clear();
                    setTimeout(function(){
                        window.location.href="login.html";
                    },1500);
                }else{
                    alert('无数据');
                }
            },
            error:function(){
                alert('请检查网络连接');
            }
        });
    })
})