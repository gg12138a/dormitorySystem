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
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script>
	
		<!-- 模态框点开时触发 -->
		$(function () {
			$('#exampleModalLong').on('show.bs.modal', function () {
				$.post("listFreeDormitories", {
					
				},function(data,status){
					var response = JSON.parse(data);
					var resHtml=
						'<table class="table table-hover">'
						+'<thead>'
						+'<tr>'
						+'<th>寝室地点</th> <th>已入住人数</th> <th></th>'
						+'</tr>'
						+'</thead>'
						+'<tbody>';
					for (i in response) {
						if(response[i]["peopleCounts"]!=4){
							resHtml+='<tr>'
								+'<td>'+response[i]["location"]+'</td>'
								+'<td>'+response[i]["peopleCounts"]+'</td>'
								+'<td> <input type="radio" name="optionsRadios"  value="'+response[i]["location"]+'" checked> </td>'
								+'</tr>';
						}
					}
					resHtml+='</tbody>';
					document.getElementById("modal-body").innerHTML=resHtml
				})
				
			})
		});
		
		<!-- 模态框关闭时触发 -->
		$(function(){
			$('#exampleModalLong').on('hide.bs.modal', function () {
				var checkedLoc=$("input[name='optionsRadios']:checked").val();
				if(typeof checkedLoc != 'undefined'){
					$.post("generateApply", {
						"toLoc":checkedLoc,
						"id":"${user.id}"
					},function(data,status){
						if(data=="1"){
							alert("申请提交成功!");
						}
						else if(data=="-1"){
							alert("申请提交失败!已存在未审核的申请");	
						}
						else{
							alert("申请提交失败！");
						}
					})
					
				}
			})
		});
		
		
		function showAppliesList(){
			$.post("listAppliesById", {
				"id":"${user.id}"
			},function(data,status){
				if(data=="[]"){
					document.getElementById("handle").innerHTML="<p>无历史记录</p>";
				}
				else{
					var response = JSON.parse(data);
					var resHtml=
						'<table class="table table-hover">'
						+'<thead>'
						+'<tr>'
						+'<th>申请编号</th>'
						+'<th>搬出地</th>'
						+'<th>搬入地</th>'
						+'<th>是否通过</th>'
						+'<th>该记录是否审批过</th>'
						+'<th>记录生成时间</th>'
						+'<th>记录审批时间</th>'
						+'</tr>'
						+'</thead>'
						+'<tbody>';
					for(i in response){
						resHtml+='<tr>'
								+'<td>'+response[i]["aid"]+'</td>'
								+'<td>'+response[i]["fromLoc"]+'</td>'
								+'<td>'+response[i]["toLoc"]+'</td>';
						if(response[i]["passed"]=="1")
							resHtml+='<td>是</td>';
						else
							resHtml+='<td>否</td>';
						if(response[i]["reviewed"]=="1")
							resHtml+='<td>是</td>';
						else
							resHtml+='<td>否</td>';
						if(response[i]["generateTime"] === undefined)
							resHtml+="<td>无记录</td>";
						else
							resHtml+='<td>'+response[i]["generateTime"]+'</td>';
						if(response[i]["reviewedTime"] === undefined)
							resHtml+="<td>无记录</td>";
						else
							resHtml+='<td>'+response[i]["reviewedTime"]+'</td>';
						resHtml+='</tr>';
					}
					resHtml+='</tbody>'
							+'</table>';
						
					document.getElementById("handle").innerHTML=resHtml;
				}
			})
		}
		
	</script>

</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-7"></div>
			<div class="pull-right col-md-3">
				管理员用户：${user.username} <a href="logout">点击以注销</a>
			</div>
			<div class="col-md-2"></div>
		</div>
	
		<div style="background: #ddd col-md-10 col-lg-10">
			<ul id="main-nav " class="nav nav-tabs nav-stacked ">
				<li><a href="#info" data-toggle="tab">个人信息</a></li>
				<li><a href="#handle" data-toggle="tab"  onclick="showAppliesList()">寝室调动申请记录</a></li>
			</ul>
		</div>
	
		<div class="row">
			<div id="myTabContent" class="tab-content">
				<!-- info标签页 -->
				<div class="tab-pane fade in active" id="info">
					<div class="col-md-2"></div>
					<div class="col-md-8 text-center">
						<table class="table table-condensed">
							<caption>您的个人信息</caption>
							<thead>
								<tr>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>用户名</td>
									<td>${user.username}</td>
								</tr>
								<tr>
									<td>邮箱</td>
									<td>${user.email}</td>
								</tr>
								<tr>
									<td>寝室地点</td>
									<td>${user.location}</td>
								</tr>
							</tbody>
						</table>
						
						<button href="#" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalLong"  >申请调动</button>
					</div>
					<div class="col-md-2"></div>
				</div>
				
				<!-- handle标签页 -->
				<div class="tab-pane fade" id="handle">
					
				</div>				
			</div>
		</div>
	</div>
	
	<!-- 模态框 -->
	<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle"
	    aria-hidden="true">
	    <div class="modal-dialog" role="document">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="exampleModalLongTitle">选择想要调入的寝室</h5>
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                    <span aria-hidden="true">&times;</span>
	                </button>
	            </div>
	            <div id="modal-body" class="modal-body" >
	                ...
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
	            </div>
	        </div>
	    </div>
	</div>
</body>
</html>