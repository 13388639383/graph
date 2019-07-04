$(function(){
    $('#getfile').click(function() {
        $.ajax({
            url: '/download', /*接口域名地址*/
            type: 'get',
            contentType: false,
            processData: false,
            success: function (result) {
                if (result == 1) {
                    alert('下载成功');
                } else {
                    alert('下载失败');
                }
            },
            error:function(){
                alert('出现问题');
            }
        })
    })
})