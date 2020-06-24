<!DOCTYPE html>
<html >
<head>
    <#include "/common/header.ftl"/>
    <title>用户注册界面</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <style>
        #a{
            margin-left: auto;
            margin-right: auto;
            margin-top: 50px;
            border-radius: 5px;
            width: 500px;
            height: 240px;
        }

        input[type=text],input[type=password]{
            width: 100%;
            padding: 12px 20px;
            height: 100%;
            display: inline-block;
            border: 0px solid #ccc;
            border-radius: 5px 5px 0  0 ;
            box-sizing: border-box;
            font-size: 25px;
            background-color: #232532;
            color: white;

            padding-left: 60px;
        }
        input[type=text]:focus,input[type=password]:focus{

            border: 2px solid #ccc;
        }

        input[type=submit] {
            width: 100%;
            background-color:#3399CC;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 25px;
        }

        input[type=submit]:hover {
            background-color: deepskyblue;
        }
        .div-bor{
            position: relative;
            height: 80px;
        }

        .icon-user{
            position: absolute;
            top:25%;
            left:10px;
            font-size: 35px;
            z-index:5;
            color: gray;
        }

    </style>
</head>

<body bgcolor="#353F58" style="text-align: center">
<br>
<br>
<img src="../libs/loginIcon.png" style="font-size: 200px;">
<div id="a">
    <form id='loginFrm'  autocomplete="off">
        <div class="div-bor">
            <i class="layui-icon layui-icon-friends icon-user" ></i>
            <input   id="userAccount" type="text" name="username" placeholder="用户名">
        </div>
        <div class="div-bor" >
            <i class="layui-icon layui-icon-password icon-user" ></i>
            <input style="border-radius: 0px 0px 0px 0px;" id="password" type="password"  name="password" placeholder="密码">
        </div>
        <div class="div-bor " style="float:left;width:300px;">
            <i class="layui-icon layui-icon-tips icon-user" ></i>
            <input   style="border-radius: 0px 0px 5px 5px;" id="cc" type="text"  name="cc" placeholder="验证码">
        </div>
        <img   class="layui-inline" id="ccImage" src="${base!}/login/ccImg" onclick="getCC($(this));" title="看不清，换一组" style="cursor: pointer;float:left;height: 80px;width:200px;"/>


    </form>

    <input  onclick="submit()" type="submit" value="注册" >
</div>

</body>
<script src="../script/jquery.min.js"></script>
<script src="../layui/layui.js"></script>
<script>
    var $userAccount = $('#userAccount');

    $(document).ready(function(){
        $("#userAccount").focus();
        var $inp=$('input');
        $inp.keypress(function(e){
            var key=e.which;
            if(key==13){
                submit()
            }
        })
    });

    function submit() {
        $userAccount.val($userAccount.val());

        var $password = $('#password');
        $userAccount.val($userAccount.val());


        var param = $('#loginFrm').serialize();
        var url = '${base!}/login/register.json';

        $.post(url,param,function(result) {
            if (result.success != null) {
                window.location.href = "${base!}/login/login.html"
            } else {
                layui.use('layer',function(){
                    var layer = layui.layer;
                    layer.msg(result.error);
                    // getCC(document.getElementById("ccImage"));
                    getCC($('#ccImage'));
                })

            }
        });

        $userAccount.val('');
        $password.val('');

    }
    function getCC(imgObj) {
        <#--imgObj.src = '${base!}/login/ccImg?'+ new Date().getTime();-->
        imgObj.attr('src','${base!}/login/ccImg?'+ new Date().getTime());
    }

</script>

</html>