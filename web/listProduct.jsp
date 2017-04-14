<%@ page language = "java" contentType = "text/html; charset = UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<script src="./js/jquery/2.0.0/jquery.min.js"></script>

<script type="text/javascript">
$(function(){
	$("input.addCartButton").removeAttr("disabled");
	$("input.addCartButton").click(function(){
		$(this).attr("disabled", "disabled");
		var button = $(this);
		var pid = $(this).attr("pid");
		var number = $("input.number[pid="+pid+"]").val();
		var page = "addOrderItem";
		
		$.post(
			page,
			{"num":number,"pid":pid},
			function(result){
				$("#addCartSuccessMessage").fadeIn(1200);
				$("#addCartSuccessMessage").fadeOut(1200,function(){
					button.removeAttr("disabled");
				});
			}
		);
	});
	$("#addCartSuccessMessage").hide();
});

</script>


<c:if test="${ !empty user }">
	<div align="center">
		当前用户：${ user.name }
	</div>
</c:if>

<div align="center" style="height:30px; margin:20px; ">
	<span style="color:Chartreuse" id="addCartSuccessMessage">加入购物车成功</span>
</div>

<table align = "center" border = '2' cellspacing = '1'>
	<tr>
		<th>编号</th>
		<th>名称</th>
		<th>价格</th>
		<th>购买</th>
	</tr>
	
	<c:forEach items="${ products }" var = "product" varStatus = "st">
		<tr>
			<td>${ product.id }</td>
			<td>${ product.name }</td>
			<td>${ product.price }</td>
			<td>
<%/*				
					<form action="addOrderItem" method="post">
					数量：<input type = "text" value = "1" name = "num">
					<input type = "hidden" name = "pid" value = "${ product.id }">
					<input type = "submit" value = "购买"> 
				</form>
*/%>
				数量：<input type = "text" pid="${ product.id }" class="number" value = "1" name = "num">
					<input class="addCartButton" pid="${ product.id }" type = "submit" value = "加入购物车">
			</td>
		</tr>
	</c:forEach>
		<tr>
			<td colspan="4"><a href="listOrderItem">查看购物车</a></td>
		</tr>
	
</table>     