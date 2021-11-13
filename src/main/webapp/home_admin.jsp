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

<script>
        function getUserByUid() {
            uid = document.getElementById("input_selectUserByid").value;
            if (uid === "" || uid === null || uid === undefined) {
                alert("请输入学号！");
            }
            else {
                $.post("selecetUserByid", {
                    "uid": uid
                }, function (data, status) {
                	alert(data);
                	var response = JSON.parse(data);

                })
            }
        }
    </script>


</head>

<body>


	<div class="container-fluid">
		<div class="row">
			<div class="col-md-7"></div>
			<div class="pull-right col-md-3">
				管理员用户：${user.username} <a href="zhuxiao">点击以注销</a>
			</div>
			<div class="col-md-2"></div>
		</div>

		<div style="background: #ddd col-md-10 col-lg-10">
			<ul id="main-nav " class="nav nav-tabs nav-stacked ">
				<li><a href="#info" data-toggle="tab">个人信息</a></li>
				<li class="dropdown nav-header collapsed" data-toggle="collapse">
					<a href="#" id="myTabDrop1" class="dropdown-toggle"
					data-toggle="dropdown">住宿信息管理<b class="caret"></b>
				</a>
					<ul class="dropdown-menu " role="menu" aria-labelledby="myTabDrop1">
						<li><a href="#insert" tabindex="-1" data-toggle="tab"> 增</a>
						</li>
						<li><a href="#delete" tabindex="-1" data-toggle="tab"> 删</a>
						</li>
						<li><a href="#update" tabindex="-1" data-toggle="tab"> 改</a>
						</li>
						<li><a href="#select" tabindex="-1" data-toggle="tab"> 查</a>
						</li>
					</ul>

				</li>

				<li><a href="#handle" data-toggle="tab">申请处理</a></li>
			</ul>
		</div>


		<div class="row">
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="info">
					</br> </br> </br>
					<div class="col-md-2"></div>
					<div class="col-md-8 text-center">
						<table class="table table-condensed">
							<caption>您的个人信息</caption>
							<thead>
								<tr>
									<th></th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>用户名</td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>邮箱</td>
									<td>Mumbai</td>
									<td></td>
								</tr>
								<tr>
									<td>个人认证</td>
									<td>Pune</td>
									<td>fsaf</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="col-md-2"></div>
				</div>
				<div class="tab-pane fade" id="insert">增</div>
				<div class="tab-pane fade" id="delete">删</div>
				<div class="tab-pane fade" id="update">改</div>
				<div class="tab-pane fade" id="select">

					</br> </br> </br>
					<div class="row">
						<div class="col-md-2"></div>
						<div class="col-md-8 text-center">
							<ul id="selectTab" class="nav nav-tabs">
								<li class="active"><a href="#selectByUid" data-toggle="tab">根据学号进行查询</a></li>
								<li><a href="#dor" data-toggle="tab">根据寝室编号进行查询</a></li>
							</ul>
							<div id="selectTabContent" class="tab-content">

								<div class="tab-pane fade in active" id="selectByUid">
									<form role="form">
										<div class="row">
											<div class="col-md-2"></div>
											<div class="col-md-6">
												<div class="form-group">
													<input type="text" id="input_selectUserByid"
														class="form-control" name="uid" placeholder="请输入学号">
												</div>
											</div>
											<div class="col-md-2">
												<button href="#"   type="button" class="btn "
													onclick="getUserByUid()">点击以查询</button>



											</div>
										</div>
									</form>


								</div>
								<div class="tab-pane fade" id="dor">根据寝室编号进行查询</div>
							</div>
						</div>
						<div class="col-md-2"></div>
					</div>
				</div>
				<div class="tab-pane fade" id="handle">message to handle</div>

			</div>
		</div>


	</div>
</body>

</html>