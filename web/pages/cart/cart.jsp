<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function (){
			$("a.deleteItem").click(function (){
				return confirm("你确定要删除" + $(this).parent().parent().find("td:first").text() + "吗")
			});

			$("#clear").click(function (){
				return confirm("你确定要清空购物车吗")
			});

			$(".updateCount").change(function (){
				var name = $(this).parent().parent().find("td:first").text();
				var count = this.value;
				var id = $(this).attr("bookId");
				if(confirm("你确定要修改" + name + "的数量为"
						+ count + "吗")){
					location.href = "http://localhost:8080/book/cartServlet?action=updateCount&count="
							+ count + "&id=" + id;
				}else{
					this.value = $(this).defaultValue;
				}
			});
		});
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<%@ include file="/pages/common/welcome.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.items}">
				<td colspan="5"><a href="http://localhost:8080/book/index.jsp">亲，请返回首页加购商品</a></td>
			</c:if>
			<c:if test="${not empty sessionScope.cart.items}">
				<c:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>${entry.value.name}</td>
						<td>
							<input style="width: 60px" class="updateCount" type="text"
								   bookId = ${entry.value.id} value="${entry.value.count}">
						</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>
						<td><a class="deleteItem" href="cartServlet?action=deleteItem&bookId=${entry.value.id}">删除</a></td>
					</tr>
				</c:forEach>

			</c:if>
			
		</table>
		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span" ><a id = "clear" href="cartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>
	
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>