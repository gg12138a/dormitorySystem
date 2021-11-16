<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
<!--bootstrap-->
<link
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>
	<section class="vh-100 gradient-custom">
		<div class="container py-5 ">


			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-6 col-xl-5 col-md-offset-3">
					<div class="card bg-dark text-white" style="border-radius: 1rem;">
						<div class="card-body p-5 text-center">

							<div class="mb-md-5 mt-md-4 pb-5">
								<form role="form" action="loginCheck" method="post">

									<h2 class="fw-bold mb-2 text-uppercase">登录</h2>
									<p class="text-white-50 mb-5">请输入您的邮箱和密码！</p>

									<div class="form-outline form-white mb-4">
										<input type="email" id="mail"
											class="form-control form-control-lg" name="mail"
											value="${mail}" /> <label class="form-label" for="mail">邮箱</label>
									</div>

									<div class="form-outline form-white mb-4">
										<input type="password" id="password"
											class="form-control form-control-lg" name="password" /> <label
											class="form-label" for="password">密码</label>
									</div>

									<p class="small mb-5 pb-lg-2">
										<div class="radio">
  											<label><input type="radio" name="isAdminUser">管理员登录</label>
										</div>
									</p>

									<button class="btn btn-outline-light btn-lg px-5" type="submit">点击登录</button>

									<div
										class="d-flex justify-content-center text-center mt-4 pt-1">
										<a href="#!" class="text-white"><i
											class="fab fa-facebook-f fa-lg"></i></a> <a href="#!"
											class="text-white"><i
											class="fab fa-twitter fa-lg mx-4 px-2"></i></a> <a href="#!"
											class="text-white"><i class="fab fa-google fa-lg"></i></a>
									</div>
								</form>
							</div>

							<div>
						

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>

