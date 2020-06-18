<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>考拉兼职</title>

  <!-- Favicons -->
  <link href="/img/favicon.png" rel="icon">
  <link href="/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="/lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="/css/style.css" rel="stylesheet">
  <link href="/css/style-responsive.css" rel="stylesheet">
</head>
<body>
<aside>
  <div id="sidebar" class="nav-collapse ">
    <!-- sidebar menu start-->
    <ul class="sidebar-menu" id="nav-accordion">
      <p class="centered"><a href="profile.html"><img src="/img/kaola.jpg" class="img-circle" width="80"></a></p>
      <h5 class="centered">Manager</h5>
      <li class="sub">
        <a href="/koala/jh">
          <i class="fa fa-briefcase"></i>
          <span>人才信息</span>
        </a>
      </li>
      <li class="sub">
        <a href="/koalabao/jo">
          <i class="fa fa-group"></i>
          <span>工作信息</span>
        </a>
      </li>
      <li class="sub">
        <a href="/koalait/log">
          <i class="fa fa-group"></i>
          <span>查看日志</span>
        </a>
      <li class="sub-menu">
        <a href="javascript:;">
          <i class="fa fa-envelope"></i>
          <span>审核</span>
          <span class="label label-theme pull-right mail-info">3</span>
        </a>
        <ul class="sub">
          <li><a href="/koalabao/boss">招聘审核</a></li>
          <li><a href="/koala/hunter">人才审核</a></li>
        </ul>
    </li>
      <li class="sub">
        <a href="/koalait/us">
          <i class="fa fa-group"></i>
          <span>关于我们 </span>
        </a>
      </li>
      <!-- sidebar menu end-->
    </ul>
  </div>
</aside>

<section id="main-content">
<!--  <section class="wrapper">-->
<!--    <h3><i class="fa fa-angle-right"></i>欢迎来到工作信息管理页面</h3>-->
<form class="form-inline col-lg-8" method="post" th:action="@{/koalabao/jo}">
  <div class="form-group">
    <label for="exampleInputName">招聘id</label>
    <input type="text" name="boss_id" class="form-control" id="exampleInputName" >
  </div>
  <button type="submit" class="btn btn-info">查询</button>
  <br/><br/>

<!--  <table class="table table-hover">-->
    <table class="table table-bordered table-striped table-condensed">
    <tr>
      <th>用户名</th>
      <th>工作要求</th>
      <th>期限</th>
      <th>岗位</th>
      <th>查看详情</th>
      <th>操作</th>

    </tr>
    <tr th:each="BossInfo,bossStat:${boss.list}">
      <td th:text="${BossInfo.user_name}" width="20"> abc</td>
      <td th:text="${BossInfo.boss_detail}"> abc</td>
      <td th:text="${BossInfo.limited_time}" width="30"> abc</td>
      <td th:text="${BossInfo.boss_title}" width="20"> abc</td>
      <td>
        <a th:href="@{'det/'+${BossInfo.boss_id}}" title="招聘详情">招聘详情</a>
      </td>
      <td>
        <a th:href="@{'del/'+${BossInfo.boss_id}}">删除</a>
      </td>
    </tr>
  </table>

  <nav aria-label="Page navigation">
    <ul class="pagination">
      <li>
        <a href="@{/koalabao/jo(pageIndex=${boss.pageNum-1},pageSize=8)}" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
        </a>
      </li>
      <th:block th:each="nav :${boss.navigatepageNums}">
        <li th:class="${nav==boss.pageNum}?'active':''">
          <a th:href="@{/koalabao/jo(pageIndex=${nav},pageSize=8,boss_id=${boss_id})}"
             th:text="${nav}"></a>
        </li>
      </th:block>
      <li>
        <a href="@{/koalabao/jo(pageIndex=${boss.pageNum+1},pageSize=8)}" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
        </a>
      </li>
    </ul>
  </nav>
</form>
  </section>
  </section>
</form>
<script src="/lib/jquery/jquery.min.js"></script>
<script src="/lib/bootstrap/js/bootstrap.min.js"></script>
<script src="/lib/jquery-ui-1.9.2.custom.min.js"></script>
<script src="/lib/jquery.ui.touch-punch.min.js"></script>
<script class="include" type="text/javascript" src="/lib/jquery.dcjqaccordion.2.7.js"></script>
<script src="/lib/jquery.scrollTo.min.js"></script>
<script src="/lib/jquery.nicescroll.js" type="text/javascript"></script>
<!--common script for all pages-->
<script src="/lib/common-scripts.js"></script>
<!--script for this page-->
</body>
</html>

