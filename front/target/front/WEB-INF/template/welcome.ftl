<!DOCTYPE html>
<html>
<head>
    <#include "/common/header.ftl"/>
    <title></title>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <link rel="stylesheet" href="../css/pageStyle.css">
    <style>
        .layui-table thead  th{
            font-size:15px
        }

        .layui-table td{
            font-size: 15px;
            text-align: center;
        }

        #table1 table tr:nth-child(even){
            background: #707070;
        }

    </style>
</head>

<body bgcolor="#353F58">
<div style="width: 100%;height: 50px;background-color:#353F58 "></div>
<div style="float:left;width: 20%;height: 800px;background-color:#232532;border-radius: 5px;margin-left: 0.5%">
    <br>
    <form class="layui-form" id="form" action="">
        <div class="text">出行日期:</div>
        <br>
        <div class="layui-input-block INPUT">
            <input type="text"  name="rdateStr" style="font-size: 12px" placeholder="请选择日期" class="layui-input" id="rdateStr">
        </div>
        <br>

        <div class="text">价格范围:</div>
        <br>
        <input type="radio" name="priceStr" value="0~1000" lay-ignore id="checkbox-2-1" class="regular-checkbox" />
        <label for="checkbox-2-1" class="label-box" style="background-color: #3083C5;color: black;margin-left: 5%;">0~1000元</label>
        <br>
        <br>
        <input type="radio" name="priceStr" value="1000~3000" lay-ignore id="checkbox-2-2" class="regular-checkbox" />
        <label for="checkbox-2-2" class="label-box" style="background-color: #BBB350;color: black;margin-left: 5%;">1000~3000元</label>
            <br>
            <br>
        <input type="radio" name="priceStr" value="3000~5000" lay-ignore id="checkbox-2-3" class="regular-checkbox" />
        <label for="checkbox-2-3" class="label-box" style="background-color: #434042;color: white;margin-left: 5%;">3000~5000元</label>
            <br>
            <br>
        <input type="radio" name="priceStr" value="5000~10000" lay-ignore id="checkbox-2-4" class="regular-checkbox" />
        <label for="checkbox-2-4" class="label-box" style="background-color: #BAB5B7;color: black;margin-left: 5%;">5000~10000元</label>
        <br>
        <br>
        <input type="radio" name="priceStr" value="10000+" lay-ignore id="checkbox-2-5" class="regular-checkbox" />
        <label for="checkbox-2-5" class="label-box"style="background-color: #65AF5A;color: black;margin-left: 5%;">10000元以上</label>
        <br>
        <br>
        <div class="layui-form-item">
            <button  class="layui-btn colorStyle1" type="button" id="find" style="margin-left: 20%;">
                <i class="layui-icon layui-icon-search"></i> 查询</button>
        </div>

    </form>

</div>
<div style="float:left; width: 77%; height:800px;background-color:#232532;border-radius: 5px;margin-left: 1%;">
    <div style="width:98%;margin: auto" id="table1" >
        <table style="margin: auto" lay-filter="demo" >
            <thead>
            <tr>
                <th lay-data="{field:'rname', sort:true}">旅游路线</th>
                <th lay-data="{field:'price',width:200, sort:true}">价 格</th>
                <th lay-data="{field:'rflagStr', sort:true}">是否有效</th>
                <th lay-data="{field:'rdateStr',sort:true}">出行日期</th>
                <th lay-data="{field:'count',sort:true}">剩余票数</th>
                <th lay-data="{field:'cname',sort:true}">旅游种类</th>
                <th lay-data="{field:'sname',sort:true}">旅行社</th>
                <th lay-data="{field:'rimage',sort:true}">宣传图片</th>
                <th lay-data="{field:'rid', hide:true}">线路Id</th>
                <th lay-data="{field:'routeintroduce', hide:true}">线路介绍</th>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
    <div style="float: right" class="page"></div>
</div>
</body>

<script src = '../libs/jquery-3.4.1.min.js'></script>
<script src = '../layui/layui.js'></script>
<script src="../libs/xm-select.js"></script>
<script src="../script/common.js"></script>

<script>
    var globalArray = [];

    function fullfillTable1(data) {
        var str = '';
        var Items = data;
        globalArray = data;

        $.each(Items, function (i, item) {
            str =
                '<tr>' +
                '<td>' + item.rname + '</td>' +
                '<td>' + item.price + '</td>' +
                '<td>' + item.rflagStr +'</td>' +
                '<td>' + item.rdateStr + '</td>' +
                '<td>' + item.count + '</td>' +
                '<td>' + item.cname + '</td>' +
                '<td>' + item.sname + '</td>' +
                '<td>' + item.rimage + '</td>' +
                '<td>' + item.rid + '</td>' +
                '<td>' + item.routeintroduce + '</td>' +
                '</tr>';

            $('#table1 tbody').append(str);
        });
    }

    layui.use(['form','table','layer','laydate','laypage'], function() {
        var form = layui.form;
        var table = layui.table;
        var laydate = layui.laydate;
        var laypage = layui.laypage;
        var layer = layui.layer;

        //执行一个laydate实例
        laydate.render({
            elem: '#rdateStr' //指定元素
            ,type: 'datetime'
            ,range: '~' //或 range: '~' 来自定义分割字符
            ,theme: '#232532'
        });
        changePage(1,15);

        setInterval(function() {
            changePage(1,15);
        },10000);

        table.on('row(demo)',function(obj) {
            layer.open({
                type:1
                ,title: ''
                ,content:
                    '<div style="width: 650px;height: 600px;">'+
                    '<img src="${base!}/image/imagePath1?rid='+obj.data.rid+'" height="200" width="650"/>'+
                    ' <div style="width: 98%;height:400px;">\n' +
                    '  <div style="width:100%;height:auto;border-radius: 5px 5px 0 0;" class="colorStyle1">\n' +
                    '     <div style="font-size: 16px;margin-left:10px;font-weight:bold;">线路详细信息</div>\n' +
                    '   </div>\n' +
                    '<div style="background-color:#232532;padding:5px;font-size: 14px;color:white;">\n' +
                    '   <div style="margin-left:5px;font-weight:bold;">旅游路线:</div>\n' +
                    '   <div style="margin-left:5px;">' + (obj.data.rname) + '</div>\n' +
                    '   <div style="margin-left:5px;font-weight:bold;">价 格：</div>\n' +
                    '   <div style="margin-left:5px;">'+(obj.data.price) +' 元</div>\n' +
                    '   <div style="margin-left:5px;font-weight:bold;">出发日期：</div>\n' +
                    '   <div style="margin-left:5px;">'+(obj.data.rdateStr)+'</div>\n' +
                    '   <div style="margin-left:5px;font-weight:bold;">旅游种类:</div>\n' +
                    '   <div style="margin-left:5px;">'+(obj.data.cname)+'</div>\n' +
                    '   <div style="margin-left:5px;font-weight:bold;">旅行社:</div>\n' +
                    '   <div style="margin-left:5px;">'+(obj.data.sname)+'</div>\n' +
                    '   <div style="margin-left:5px;font-weight:bold;">剩余票数:</div>\n' +
                    '   <div style="margin-left:5px;">'+ (obj.data.count) +'</div>\n' +
                    '   <div style="margin-left:5px;font-weight:bold;">是否有效:</div>\n' +
                    '   <div style="margin-left:5px;">'+ (obj.data.rflagStr) +'</div>\n' +
                    '   <div style="margin-left:5px;font-weight:bold;">线路介绍:</div>\n' +
                    '   <div style="margin-left:5px;">'+ (obj.data.routeintroduce) +'</div>\n' +
                    '</div>' +
                '</div></div>'
                ,area: ['650px', '600px']
                ,closeBtn:1
                ,shadeClose:true
                ,btn: ['关闭']
            });
        });

        //监听提交
        $("#find").click(function () {
            var loading = layer.load(1, {
                shade: [0.3, '#000000']
                , offset: '500px'
            });
            //把数据集中到一个页面上并全部清空
            $('#table1 tbody').empty();

            var curPage = 1;
            var itemForm = $('#form');
            var content = itemForm.serialize();
            var param = content;
            param += '&pageSize=15&pageNum=1&noPage=false';

            $.get('${base!}/hunter/findhunter.json' , function (res) {
                layer.close(loading); //必须在第一行关闭

                if (status == 'success') {
                    if (typeof(res.rows) != 'undefined' && res.rows != null) {
                        fullfillTable1(res.rows);

                        //指出当前页是那一页
                        table.init('demo', {
                            height: 700//设置高度
                            , limit: 15
                            ,curr:curPage
                            , done: function () {
                                layer.close(loading);
                            }
                        });

                        //分页操作
                        $(".page").each(function(i,the){
                            laypage.render({
                                theme: '#353F58 ',
                                elem: the //注意，这里的 test1 是 ID，不用加 # 号
                                ,count: res.pageAmount
                                ,limit:15
                                //跳转页码时调用
                                , jump: function (obj, first) { //obj为当前页的属性和方法，第一次加载first为true
                                    //非首次加载 do something
                                    if (!first) {
                                        curPage = obj.curr;
                                        changePage(obj.curr, obj.limit);
                                    }
                                }
                            });
                        });
                    } else {
                        console.log("Error: " + res);
                        layer.close(loading);
                    }
                } else {
                    console.log("Error: " + res);
                    layer.close(loading);
                }
            });
            return false;

        });
    });

    function changePage(cur,size){
        var loading = layer.load(1, {
            shade: [0.3, '#000000']
            , offset: '500px'
        });
        $('#table1 tbody').empty();

        /*var param = {pageSize:size,pageNum:cur,noPage:false};*/

        $.get('http://localhost:8080/front/hunter/findhunter.json',  function (res) {
            layer.close(loading);

            if (typeof(res.rows) != 'undefined') {
                if (res.rows instanceof Array) {
                    fullfillTable1(res.rows);
                    var table = layui.table;
                    table.init('demo', {
                        height:700//设置高度
                        ,limit: size //注意：请务必确保 limit 参数（默认：15）是与你服务端限定的数据条数一致
                        ,curr:cur
                        //支持所有基础参数
                        , done: function () {
                            layer.close(loading);
                        }
                    });
                }
            } else {
                console.log("Error: " + res);
                layer.close(loading);
            }
        });
    }
    
</script>

</html>