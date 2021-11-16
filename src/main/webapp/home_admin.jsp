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
		var uid = document.getElementById("input_selectUserByid").value;
		if (uid === "" || uid === null || uid === undefined) {
			alert("请输入学号！");
		}
		else {
			$.post("selecetUserByid", {
				"uid": uid
			}, function (data, status) {
				if(data=="null"){
					document.getElementById("res_selectUserByid").innerHTML="";
					alert("无匹配此学号的记录！");
				}else{
					var response = JSON.parse(data);
					document.getElementById("res_selectUserByid").innerHTML='<table class="table table-hover">'
						+'<thead>'
							+'<tr>'
							+'<th>学号</th>'
							+'<th>姓名</th>'
							+'<th>邮箱</th>'
							+'<th>寝室地点</th>'
							+'<th>点击按钮修改寝室</th>'
							+'</tr>'
						+'</thead>'
						+'<tbody>'
							+'<tr>'
							+'<td>'+response["id"]+'</td>'
							+'<td>'+response["username"]+'</td>'
							+'<td>'+response["email"]+'</td>'
							+'<td>'+response["location"]+'</td>'
							+'<td>'
							+'<button type="button" id="uid_'+response["id"]+'" onclick="promptUpdateLoc(this)">点击修改</button>'
							+'</td>'
							+'</tr>'
						+'</tbody>'
					+'</table>';

				}
			})
		}
	}

	function getUserByLoc() {
		var loc = document.getElementById("input_selectUserByLoc").value;
		if (loc === "" || loc === null || loc === undefined) {
			alert("请输入寝室编号！");
		}
		else{
			$.post("SelectUsersByLoc", {
				"loc": loc
			}, function (data, status) {
				if(data=="-1"){
					alert("不存在该寝室！");
					document.getElementById("res_selectUserByLoc").innerHTML="";
				}else{
					var response = JSON.parse(data);
					var resHtml=
						'<p class="small mb-5 pb-lg-2">目前入住：'+response.length+'/4</p>';
					if(response.length!=0){
						resHtml+=
						'<table class="table table-hover">'
						+'<thead>'
						+'<tr>'
						+'<th>学号</th>'
						+'<th>姓名</th>'
						+'<th>邮箱</th>'
						+'<th>寝室地点</th>'
						+'<th>点击按钮，将该用户移出该寝室</th>'
						+'</tr>'
						+'</thead>'
						+'<tbody>';
						for (i in response) {
							resHtml+='<tr>'
							+'<td>'+response[i]["id"]+'</td>'
							+'<td>'+response[i]["username"]+'</td>'
							+'<td>'+response[i]["email"]+'</td>'
							+'<td>'+response[i]["location"]+'</td>'
							+'<td> <button type="button" id="uid_t_'+response[i]["id"]+'" onclick="deleteThisPerson(this)">点击删除</button> </td>'
							+'</tr>';
						}
						
						if(response.length<4){
							resHtml+='<tr>'
								+'<td></td>'
								+'<td></td>'
								+'<td></td>'
								+'<td></td>'
								+'<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalLong" onclick="addMember()">添加成员</button></td>'
								+'</tr>'
						}

						resHtml+='</tbody>'
						+'</table>';
					}

					document.getElementById("res_selectUserByLoc").innerHTML=resHtml;
				}
			})
		}
	}
	

	function promptUpdateLoc(elem){
		var newloc=prompt("请输入新的寝室编号：","");

		$.post("updateLocByid", {
			"parsedid":elem.id,
			"newloc":newloc
		},function(data,status){
			if(data=="1"){
				alert("修改成功！");
			}else if(data=="-1"){
				alert(newloc+"寝室人数已满，修改失败！");
			}else{
				alert("修改失败！");
			}
			getUserByUid();
		})
	}

	function deleteThisPerson(elem){
		$.post("deletePersonById", {
			"parsedid":elem.id,
		},function(data,status){
			if(data=="1"){
				alert("删除成功！");
			}else{
				alert("删除失败！");
			}

			getUserByLoc();
		})
	}
	
	function changeModalbody(){
		$.post("getAllUsersNotIn",{
			
		},function(data,status){
			var response = JSON.parse(data);
			var resHtml="";
			
			for(i in response){
				resHtml+=
					'<div class="radio">'
						+'<label>'
							+'<input type="radio" name="optionsRadios"  value="'+response[i]["id"]+'" checked>'+response[i]["username"]
						+'</label>'
					+'</div>';
			}
			
			document.getElementById("modal-body").innerHTML=resHtml
		})
	}
	
	function addMember(){
		$('#exampleModalLong').on('show.bs.modal', function () {
			changeModalbody();
		})
		
		$('#exampleModalLong').on('hide.bs.modal', function () {
			var obj = document.getElementsByTagName("optionsRadios");
			var checkedId=$("input[name='optionsRadios']:checked").val();

			$.post("addUserInLoc",{
				"id":checkedId,
				"loc":document.getElementById("input_selectUserByLoc").value
			},function(data,status){
				if(data=="1"){
					alert("插入成功");
				}
				else{
					alert("插入失败");
				}
				
				getUserByLoc();
			})
			
			
		})
		
	}
	

</script>


</head>

<body>


	<div class="container-fluid">
		<div class="row">
			<div class="col-md-7"></div>
			<div class="pull-right col-md-3">
				管理员用户：${adminUser.username} <a href="logout">点击以注销</a>
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
												<button href="#" type="button" class="btn "
													onclick="getUserByUid()">点击以查询</button>
											</div>
										</div>
									</form>

									<div id="res_selectUserByid"></div>
								</div>

								<div class="tab-pane fade" id="dor">
									<!-- 根据寝室编号进行查询 -->
									<form role="form">
										<div class="row">
											<div class="col-md-2"></div>
											<div class="col-md-6">
												<div class="form-group">
													<input type="text" id="input_selectUserByLoc"
														class="form-control" name="loc" placeholder="请输入寝室编号">
												</div>
											</div>
											<div class="col-md-2">
												<button href="#" type="button" class="btn "
													onclick="getUserByLoc()">点击以查询</button>
											</div>
										</div>
									</form>

									<div id="res_selectUserByLoc"></div>
								</div>
							</div>
						</div>
						<div class="col-md-2"></div>
					</div>
				</div>
				<div class="tab-pane fade" id="handle">message to handle</div>

			</div>
		</div>
	</div>
	
	<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle"
	    aria-hidden="true">
	    <div class="modal-dialog" role="document">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="exampleModalLongTitle">请选择将要入住的学生</h5>
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                    <span aria-hidden="true">&times;</span>
	                </button>
	            </div>
	            <div id="modal-body" class="modal-body">

	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
	            </div>
	        </div>
	    </div>
	</div>
	
</body>

</html>