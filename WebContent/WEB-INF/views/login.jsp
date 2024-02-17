<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- Coding By CodingNepal - codingnepalweb.com -->
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- ===== Iconscout CSS ===== -->
<link rel="stylesheet"
	href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">

<!-- ===== CSS 주의할점 : /resources/css/style.css resource안에 css파일 안에 style.css를 넣는다.  ===== -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<script type="text/javascript">
	//컨트롤러에서 보낸 메세지가 있을 경우
	window.onload = function(e){ 
		var resultMsg = '${resultMsg}';
		var resultCode = '${resultCode}';
		if(resultMsg.length > 0){
			alert(resultMsg);
		}
		if(resultCode == 'loginOk') {
			window.location.href = '<c:url value="/list.do"/>?offset=1&limit=20';
		}
	}
</script>

<title>Login & Registration Form</title>
</head>
<body>

	<div class="container">
		<div class="forms">
			<div class="form login">
				<span class="title">Login</span>

				<form action="<c:url value='/login.do'/>" method="post"
					onsubmit="return formCheck(this);">
					<div class="input-field">
						<input type="text" name="memberId" placeholder="Enter your email"
							required> <i class="uil uil-envelope icon"></i>
					</div>
					<div class="input-field">
						<input type="password" name="passwd" class="password"
							placeholder="Enter your password" required> <i
							class="uil uil-lock icon"></i> <i
							class="uil uil-eye-slash showHidePw"></i>
					</div>

					<div class="checkbox-text">
						<div class="checkbox-content">
							<input type="checkbox" id="logCheck"> <label
								for="logCheck" class="text">Remember me</label>
						</div>

						<a href="#" class="text">Forgot password?</a>
					</div>

					<div class="input-field button">
						<input type="submit" value="Login">
					</div>
					<script>
						function formCheck(frm) {
							let msg = '';

							if (frm.id.value.length == 0) {
								setMessage('id를 입력해주세요.', frm.id);
								return false;
							}

							if (frm.pwd.value.length == 0) {
								setMessage('password를 입력해주세요.', frm.pwd);
								return false;
							}

							return true;
						}

						function setMessage(msg, element) {
							document.getElementById("msg").innerHTML = ` ${'${msg}'}`;

							if (element) {
								element.select();
							}
						}
					</script>
				</form>

				<div class="login-signup">
					<span class="text">Not a member? <a href="#"
						class="text signup-link">Signup Now</a>
					</span>
				</div>
			</div>

			<!-- Registration Form -->
			<div class="form signup">
				<span class="title">Registration</span>

				<form action="<c:url value='/join.do'/>" method="post">
					<div class="input-field">
						<input type="text" name="memberId"  placeholder="Enter your name" required>
						<i class="uil uil-user"></i>
					</div>
					<div class="input-field">
						<input type="text" name="email" placeholder="Enter your email" required>
						<i class="uil uil-envelope icon"></i>
					</div>
					<div class="input-field">
						<input type="password" name="passwd" class="password"
							placeholder="Create a password" required> <i
							class="uil uil-lock icon"></i>
					</div>
					<div class="input-field">
						<input type="password" class="password"
							placeholder="Confirm a password" required> <i
							class="uil uil-lock icon"></i> <i
							class="uil uil-eye-slash showHidePw"></i>
					</div>

					<div class="checkbox-text">
						<div class="checkbox-content">
							<input type="checkbox" id="termCon"> <label for="termCon"
								class="text">I accepted all terms and conditions</label>
						</div>
					</div>

					<div class="input-field button">
						<input type="submit" value="Signup">
					</div>
				</form>

				<div class="login-signup">
					<span class="text">Already a member? <a href="#"
						class="text login-link">Login Now</a>
					</span>
				</div>
			</div>
		</div>
	</div>
	<!-- 주의할점 : /resources/js/script.js설정시 resources안에 js파일안에 script.js 넣을 것 -->
	<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>

</body>
</html>