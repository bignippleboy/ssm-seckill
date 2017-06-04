<%--
  Created by IntelliJ IDEA.
  User: huangken
  Date: 3/6/17
  Time: 上午10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <title>秒杀详情页</title>
  <%--静态包含--%>
  <%@include file="common/header.jsp"%>
</head>
<body>
  <div class="container">
    <div class="panel panel-default text-center">
      <h1><div class="panel-heading">${seckill.name}</div></h1>
      <div class="panel-body">
        <h2 class="text-danger">
          <%--显示time图标--%>
          <span class="glyphicon glyphicon-time"></span>
          <%--展示倒计时--%>
          <span class="glyphicon" id="seckill-box"></span>
        </h2>
      </div>
    </div>
  </div>
  <%--登录弹出层 输入电话--%>
  <div id="killPhoneModal" class="modal fade">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h3 class="modal-title text-center">
            <span class="glyphicon glyphicon-phone">秒杀电话：</span>
          </h3>
        </div>

        <div class="modal-body">
          <div class="row">
            <div class="col-xs-8 col-xs-offset-2">
              <input type="text" name="killPhone" id="killPhoneKey"
                     placeholder="填写手机号：" class="form-control">
            </div>
          </div>
        </div>

        <div class="modal-footer">
          <%--验证信息--%>
          <span id="killPhoneMessage" class="glyphicon"></span>
          <button type="button" id="killPhoneBtn" class="btn btn-success">
            <span class="glyphicon glyphicon-phone">Submit</span>
          </button>
        </div>

      </div>
    </div>
  </div>
</body>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<%--jQuery Cookie操作插件--%>
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<%--jQuery countDown倒计时插件--%>
<script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>

<script src="/js/seckill.js" type="text/javascript"></script>

<script type="text/javascript">
  $(function() {
    seckill.detail.init({
      seckillId: ${seckill.seckillId},
      startTime: ${seckill.startTime.time},
      endTime: ${seckill.endTime.time}
    })
  })
</script>

</html>