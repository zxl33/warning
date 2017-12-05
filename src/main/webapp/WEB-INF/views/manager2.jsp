<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>仓库管理系统|warehouse manage system</title>

    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/resources/mc/css/bootstrap.min.css" rel="stylesheet">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
    <script src="<%=request.getContextPath()%>/resources/mc/js/hf_hotel.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>

      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
 <body onLoad="manager_onload()">
    
  <!--   <div class="container"> -->  
    <div class="row">
         <div class="col-lg-10 col-md-10 col-sm-10 ">
         <h2>管理员管理</h2>
         <div class="form-group">
          <div class="">
            <button class="btn btn-primary" type="button"  id="ware_supply_add1" >新增</button>
          </div>
        </div>
         <div style="cursor:pointer" >
         <table class="table table-bordered table-hover" id = "ware_supply_table">
            	<tr >
            		<th>ID</th>
                	<th>姓名</th>
					<th>邮箱</th>
					<th>操作</th>
				</tr>

          </table>
          </div>
         </div>
    </div>
    </div>

<!--模态框1 -->
<div class="modal fade" id="ware_supply_m1">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
        	<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<h4 class="modal-title">新增管理员</h4>
			</div>
			<div class="modal-body" style="height:260px">
            <form class="form-horizontal" method="post" action="Supplier_Add.php" id="manager_add_form">
            <div class="form-group">
            <label for="inputEmail3" class="col-sm-4 control-label">姓名</label>
      			<div class="col-sm-8">
            	<input id="manager_add_name" name="name" class="form-control"  />
                </div>
            </div>
            <div class="form-group">
            <label for="inputEmail3" class="col-sm-4 control-label">邮箱</label>
      			<div class="col-sm-8">
            	<input id="manager_add_email" name="email" class="form-control"  />
                </div>
            </div>
            <div class="form-group">
            <label for="inputEmail3" class="col-sm-4 control-label">密码</label>
      			<div class="col-sm-8">
            	<input id="manager_add_password" type="password" name="password" class="form-control"  />
                </div>
            </div>
            <div class="form-group">
            <label for="inputEmail3" class="col-sm-4 control-label">再次输入密码</label>
      			<div class="col-sm-8">
            	<input id="manager_add_password_again" type="password" name="password_again" class="form-control"  />
                </div>
            </div>
            </form>
			<button id="manager_add_btn" class="form-control  btn btn-primary">提交</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!--模态框2 -->
<div class="modal fade" id="ware_supply_m2">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
        	<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<h4 class="modal-title">删除管理员</h4>
			</div>
			<div class="modal-body" style="height:380px">
            <form class="form-horizontal" method="post" action="update_supplier.php">
              <div class="form-group">
              <label for="inputEmail3" class="col-sm-4 control-label">ID</label>
                  <div class="col-sm-8">
                  <input id="ware_supply_find_id2" name = "id" class="form-control" readonly />
                  </div>
              </div>
              <div class="form-group">
              <label for="inputEmail3" class="col-sm-4 control-label">姓名</label>
                  <div class="col-sm-8">
                  <input id="ware_supply_find_sup2" name = "name" class="form-control" readonly/>
                  </div>
              </div>
              <div class="form-group">
              <label for="inputEmail3" class="col-sm-4 control-label">邮箱</label>
                  <div class="col-sm-8">
                  <input id="ware_supply_find_name2" name = "people" class="form-control" readonly/>
                  </div>
              </div>
              </form>
			  	<button id="manager_delete_btn" type = "submit" class="form-control  btn btn-primary">确认删除</button>
			
			</div>

		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>
