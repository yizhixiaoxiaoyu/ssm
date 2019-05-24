<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/5/23
  Time: 11:54
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>

    <title>员工列表页面</title>

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<%--显示页面--%>
<div class="container">
    <%--标题--%>
    <div class="row">
        <div class="col-md-12">
            <h1>小小鱼SSMdemo</h1>
        </div>
    </div>
    <%--按钮--%>
    <div class="row">
        <div class="col-md-2 col-md-offset-11">
            <button class="btn btn-primary btn-sm" value="添加">添加</button>
            <button class="btn btn-danger btn-sm" value="删除">删除</button>
        </div>
    </div>
    <%--表格--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>#</th>
                    <th>lastname</th>
                    <th>email</th>
                    <th>gender</th>
                    <th>deptName</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="emp">
                    <tr>
                        <th>${emp.empId}</th>
                        <th>${emp.empName}</th>
                        <th>${emp.email}</th>
                        <th>${emp.gender=="M"?"男":"女"}</th>
                        <th>${emp.department.deptName}</th>
                        <th>
                            <button class="btn btn-primary btn-sm">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                编辑
                            </button>
                            <button class="btn btn-danger btn-sm">
                                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                删除
                            </button>
                        </th>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
    <%--分页--%>
    <div class="row">
        <div class="col-md-6">
            当前第${pageInfo.pageNum}页，共有${pageInfo.pages}页，总计${pageInfo.total}条记录
        </div>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="${pageContext.request.contextPath}/emps?pn=1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/emps?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                        <c:if test="${pageInfo.pageNum==page_Num}">
                            <li class="active"><a href="#">${page_Num}</a></li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum!=page_Num}">
                            <li><a href="${pageContext.request.contextPath}/emps?pn=${page_Num}">${page_Num}</a></li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/emps?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <li><a href="${pageContext.request.contextPath}/emps?pn=${pageInfo.pages}">尾页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>

</body>
</html>
