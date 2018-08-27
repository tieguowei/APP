$(function () {
    //浏览器不支持 placeholder 时才执行
    if (!('placeholder' in document.createElement('input'))) {
        $('[placeholder]').each(function () {
            var $tag = $(this); //当前 input
            var $copy = $tag.clone();   //当前 input 的复制
            if ($copy.val() == "") {
                $copy.css("color", "#999");
                $copy.val($copy.attr('placeholder'));
            }
            $copy.focus(function () {
                if (this.value == $copy.attr('placeholder')) {
                    this.value = '';
                    this.style.color = '#000';
                }
            });
            $copy.blur(function () {
                if (this.value=="") {
                    this.value = $copy.attr('placeholder');
                    $tag.val("");
                    this.style.color = '#999';
                } else {
                    $tag.val(this.value);
                }
            });
            $tag.hide().after($copy.show());    //当前 input 隐藏 ，具有 placeholder 功能js的input显示
        });
    }

    //点击登录添加高亮
    function iptFocus(){
        $('.loginBox ul li div').removeClass('border focus');
        $('.loginBox ul li').each(function(){
            if($(this).find('input').not('input[type="submit"],input[type="button"]').val()==""){
                $(this).find('input').not('input[type="submit"],input[type="button"]').focus();
                $(this).find('div').addClass('border focus');
                return false;
            }
        })
    }

    //清空输入框
    $('.del').click(function () {
        $('#username').val('').focus();
    })

    //遍历输入框 添加高亮
    $('.login li').each(function(){
        $(this).click(function(){
            if($(this).find('div').length>0){
                $(this).children('div').addClass('border focus');
                $(this).siblings('li').find('div').removeClass('border focus');
            }
        })
    })

    //密码显示隐藏
    $('.eye').click(function () {
        var pwd = $('#password').val();
        if($(this).hasClass('eyek')){
            $(this).removeClass('eyek');
            $('#password').prop('type','password').val(pwd).focus();
        }else {
            $(this).addClass('eyek')
            $('#password').prop('type','text').val(pwd).focus();
        }
    })

    //登录
    $('.loginBtn').click(function(){
        iptFocus();
    })
})