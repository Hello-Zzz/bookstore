<%--
  Created by IntelliJ IDEA.
  User: zhao1
  Date: 2021/5/27
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="page_nav">
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>

    <c:choose>
        <c:when test="${requestScope.page.totalPage <= 5}">
            <c:set var="begin" value="1" />
            <c:set var="end" value="${requestScope.page.totalPage}" />

        </c:when>
        <c:when test="${requestScope.page.totalPage > 5}">
            <c:choose>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:set var="begin" value="1" />
                    <c:set var="end" value="5" />

                </c:when>
                <c:when test="${requestScope.page.pageNo > requestScope.page.totalPage-3}">
                    <c:set var="begin" value="${requestScope.page.totalPage-4}" />
                    <c:set var="end" value="${requestScope.page.totalPage}" />

                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNo-2}" />
                    <c:set var="end" value="${requestScope.page.pageNo+2}" />

                </c:otherwise>
            </c:choose>
        </c:when>


    </c:choose>

    <c:forEach var="i" begin="${begin}" end="${end}">
        <c:if test="${requestScope.page.pageNo == i}">
            【${i}】
        </c:if>
        <c:if test="${requestScope.page.pageNo != i}">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>




    <c:if test="${requestScope.page.pageNo < requestScope.page.totalPage}" >
        <a href="${requestScope.page.url}&pageNo=
				${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.totalPage}">末页</a>
    </c:if>

    共${requestScope.page.totalPage}页，${requestScope.page.totalCount}条记录
    到第<input value="${empty param.pageNo ? 1: param.pageNo}" name="pn" id="pn_input"/>页
    <input id = "confirmBtn" type="button" value="确定">

    <script type="text/javascript">
        $(function (){
            $("#confirmBtn").click( function (){
                var pageNo = $("#pn_input").val();
                var totalPage = ${requestScope.page.totalPage};
                if(pageNo < 1) pageNo = 1;
                if(pageNo > totalPage) pageNo = totalPage;

                location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo=" + pageNo;
            } );
        });
    </script>
</div>
