<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%@ include file="/pages/common/head.jsp"%>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>

	<script type="text/javascript">
		$(function (){

			$("#username").blur(function (){
				var username = this.value;
				var userPatt = /^\w{3,12}$/;
				if(!userPatt.test(username)){
					$("span.errorMsg").text("用户名不合法！")
					return;
				}

				$.getJSON("http://localhost:8080/book/userServlet", "action=ajaxExistsUsername&username=" + username,
				function (data){
					console.log(data)

					if(data.exists){
						$("span.errorMsg").text("用户名已存在，请重新输入！");
					}else{
						$("span.errorMsg").text("用户名可用！")
					}

				});
			});

		    $("#sub_btn").click(function (){
                var userText = $("#username").val();
                // var userPatt = /^\w{3,12}$/;
                var errorText = $("span.errorMsg");
                // if(!userPatt.test(userText)){
                //     errorText.text("用户名不合法");
                //     return false;
                // }

                var passwordText = $("#password").val();
                if(!userPatt.test(passwordText)){
                    errorText.text("密码设置不合法");
                    return false;
                }

                var passwordText2 = $("#repwd").val();
			    if(passwordText !== passwordText2){
                    errorText.text("两次输入密码不一致");
                    return false;
			    }

			    var emailText = $("#email").val();
			    var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
			    if(!emailPatt.test(emailText)){
			        errorText.text("邮箱格式不正确");
			        return false;
			    }

			    var codeText = $("#code").val();
			    codeText = $.trim(codeText);
			    if(codeText == null || codeText === ""){
                    errorText.text("验证码错误");
                    return false;
			    }

                errorText.text();

            })

			$("#code_img").click(function () {
				this.src = "${basePath}kaptcha.jpg?id=" + new Date();  // new Date()目的是跳过缓存 每次生成不同的验证码下·
			})

		})
	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
<%--									<%= (request.getAttribute("msg")) == null ? "": request.getAttribute("msg") %>--%>
									${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name = "action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off"
									       tabindex="1" name="username" id="username"
										   value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off"
									       tabindex="1" name="password" id="password"
										   value="${requestScope.password}"/>
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off"
									       tabindex="1" name="repwd" id="repwd"
										   value="${requestScope.password}" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off"
									       tabindex="1" name="email" id="email"
										   value="${requestScope.email}"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" name = "code" type="text" style="width: 100px;" id="code"/>
									<img alt="" id = "code_img" src="kaptcha.jpg" style="float: right; margin-right: 40px; width: 100px; height: 32px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>