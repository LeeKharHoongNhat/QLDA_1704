<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<html xmlns:th="http://www.thymeleaf.org">

<body>
    <h1 th:text="${msg}"></h1>
</body>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />