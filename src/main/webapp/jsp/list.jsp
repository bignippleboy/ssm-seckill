<%--
  Created by IntelliJ IDEA.
  User: huangken
  Date: 3/6/17
  Time: 上午10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<html lang="en">
<head>
  <title>秒杀列表页</title>
  <%--静态包含--%>
  <%@include file="common/header.jsp"%>
</head>
<body>
  <div class="container">
    <div class="panel panel-default">
      <div class="panel-heading text-center">
        <h2>秒杀列表</h2>
      </div>
      <div class="panel-body">
        <table class="table table-hover">
          <thead>
            <tr>
              <th>名称</th>
              <th>库存</th>
              <th>开始时间</th>
              <th>结束时间</th>
              <th>创建时间</th>
              <th>详情页</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="sk" items="${list}">
              <tr>
                <td>${sk.name}</td>
                <td>${sk.number}</td>
                <td><fmt:formatDate value="${sk.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><fmt:formatDate value="${sk.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                <td><fmt:formatDate value="${sk.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                <td>
                  <a class="btn btn-info" href="/seckill/${sk.seckillId}/detail" target="_blank">link</a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</body>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="/vendors/bootstrap3/js/bootstrap.min.js"></script>
</html>