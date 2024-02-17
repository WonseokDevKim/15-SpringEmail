<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	//컨트롤러에서 보낸 메세지가 있을 경우
	window.onload = function(e){ 
		var resultMsg = '${resultMsg}';
		var resultCode = '${resultCode}';
		if(resultMsg.length > 0){
			alert(resultMsg);
		}
	}
</script>
<title>게시판</title>
</head>
<body>
</body>
</html>