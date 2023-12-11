<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>스타벅스</title>
	</head>
	<body>
	
		<%-- <div>
			<ul>
				<c:forEach var="order" items="${orderList }">
					<li>
						<c:out value = "${order.seq }" />				
						<c:out value = "${order.menu }" />				
						<c:out value = "${order.amount }" />				
						<c:out value = "${order.sum }" />				
						<c:out value = "${order.user_id }" />				
						<c:out value = "${order.create_date }" />				
					</li>
				</c:forEach>
			</ul>
		</div> --%>
		<div>
		    <table border="1">
		        <thead>
		            <tr>
		                <th>주문번호</th>
		                <th>메뉴</th>
		                <th>수량</th>
		                <th>합계</th>
		                <th>User ID</th>
		                <th>주문일시</th>
		            </tr>
		        </thead>
		        <tbody>
		            <c:forEach var="order" items="${orderList}">
		                <tr>
		                    <td><c:out value="${order.seq}" /></td>
		                    <td><c:out value="${order.menu}" /></td>
		                    <td><c:out value="${order.amount}" /></td>
		                    <td><c:out value="${order.sum}" /></td>
		                    <td><c:out value="${order.user_id}" /></td>
		                    <td><c:out value="${order.create_date}" /></td>
		                </tr>
		            </c:forEach>
		        </tbody>
		    </table>
		</div>
		
	</body>
</html>