<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 어떤 요청이든 요청이 정상 처리되고 다음 페이지로 이동하는 코드는 공통적이기 때문이다. -->
<script type="text/javascript">
	//컨트롤러에서 보낸 메세지가 있을 경우
	window.onload = function(e){ 
		var resultMsg = '${resultMsg}';
		var resultCode = '${resultCode}';
		if(resultMsg.length > 0){
			alert(resultMsg);
		}
		if(resultCode == 'ok') {
			window.location.href = '<c:url value="${nextUri}"/>';
		}
	}
</script>
<body>

</body>
</html>