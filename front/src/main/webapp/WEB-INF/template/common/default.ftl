<#macro head>
    <#assign layout_head>
        <#nested />
    </#assign>
</#macro>
<#macro body>
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta http-equiv=X-UA-Compatible content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-cache,no-store">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="-1">

    <link rel="stylesheet" type="text/css" href="${base!}/script/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${base!}/script/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css"  href="${base!}/css/main.css"/>
    <script type="text/javascript" src="${base!}/script/jquery.min.js"></script>
    <script type="text/javascript" src="${base!}/script/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${base!}/script/easyui/jEasyUI_formvalidator.js"></script>
    <script type="text/javascript" src="${base!}/script/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${base!}/script/common/common_dateutil.js"></script>
    <script type="text/javascript" src="${base!}/script/datePicker/WdatePicker.js"></script>
    
    <script type="text/javascript" src="${base!}/script/base64.js"></script>
    <script type="text/javascript" src="${base!}/script/captcha.js"></script>
    <script type="text/javascript" src="${base!}/script/cloud.js"></script>
    <script type="text/javascript" src="${base!}/script/cookie.js"></script>
    <script type="text/javascript" src="${base!}/script/queryParam.js"></script>
    <script type="text/javascript" src="${base!}/script/queryObj.js"></script>
    <script type="text/javascript" src="${base!}/script/encrypt.js"></script>
    <script type="text/javascript" src="${base!}/script/event.js"></script>
    <script type="text/javascript" src="${base!}/script/postData.js"></script>
    <script type="text/javascript" src="${base!}/script/addObject.js"></script>
    <script type="text/javascript" src="${base!}/script/editObject.js"></script>
    <script type="text/javascript" src="${base!}/script/detailObject.js"></script>
    <script type="text/javascript" src="${base!}/script/password_window.js"></script>
    <script type="text/javascript" src="${base!}/script/resetPwd.js"></script>
    
    ${layout_head}
</head>
<body>
    <#nested />
</body>

</html>
</#macro>

