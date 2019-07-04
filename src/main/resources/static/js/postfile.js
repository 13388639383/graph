$(function(){
    $('#postfile').click(function() {
        var formData = new FormData();
        formData.append("file", $("#file")[0].files[0]);
        $.ajax({
            url: '/upload', /*接口域名地址*/
            type: 'post',
            data: formData,
            contentType: false,
            processData: false,
            success: function (result) {
                if (result == 1) {
                    alert('上传成功');
                } else {
                    alert('上传失败');
                }
            }
        })
    })
})