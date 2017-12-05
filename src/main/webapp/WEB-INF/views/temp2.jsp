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
  <body onLoad="temp_onload()">
    

    <div class="row">
         <div class="col-lg-10 col-md-10 col-sm-10 ">
         <h2>模板管理</h2>
            <button class="btn btn-primary" type="button"  id="ware_io_add2" >新增</button>
          <br>
          <div style="cursor:pointer; margin-top:20px;" >
          <table class="table table-bordered table-hover " id="ware_io_find_table" >
            <tr >
            		<th>ID</th>
                	<th>名称</th>
					<th>类型</th>
					<th>内容</th>
          <th>操作</th>
				</tr>
               
          </table>
          </div>
         </div>
    </div>

    

<!--模态框1 -->
<div class="modal fade" id="ware_io_m1">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
        	<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<h4 class="modal-title">新增模板</h4>
			</div>
			<div class="modal-body" style="height:260px;">
            	<form class="form-horizontal" method="post" action="Note.php">
				<div class="form-group">
                	<label for="inputEmail3" class="col-sm-4 control-label">名称</label>
                    <div class="col-sm-8">
                    <input type="text" name="type" class="form-control" id="ware_io_add_type2" />
                    </div>
                 </div>
                 <div class="form-group">
                    <label for="inputEmail3" class="col-sm-4 control-label">类型</label>
                    <div class="col-sm-8">
                    <select class="form-control" id="ware_io_add_type1">
                      <option value="0">邮箱</option>
                      <option value="1">短信</option>
                    </select>
                    </div>
                 </div>
                 <div class="form-group">
                    <label for="inputEmail3" class="col-sm-4 control-label">内容</label>
                    <div class="col-sm-8">
                    <textarea name="num" class="form-control" id="ware_io_add_num2"></textarea>
                    </div>
                 </div>
				</form>
				<button id="temp_add_btn" class="form-control brn btn-primary">确定新增</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!--模态框2 -->
<div class="modal fade" id="ware_io_m2">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
        	<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<h4 class="modal-title">查看模板详情</h4>
			</div>
			<div class="modal-body" style="height:450px">
            <form class="form-horizontal" method="post" action="update_ware.php">
            <div class="form-group">
            <label for="inputEmail3" class="col-sm-4 control-label">ID</label>
      			<div class="col-sm-8">
            	<input id="ware_io_find_id2" name = "id" class="form-control" readonly />
                </div>
            </div>
            <div class="form-group">
            <label for="inputEmail3" class="col-sm-4 control-label">名称</label>
      			<div class="col-sm-8">
            	<input id="ware_io_find_type2" name="type" class="form-control" readonly/>
                </div>
            </div>
            <div class="form-group">
            <label for="inputEmail3" class="col-sm-4 control-label">类型</label>
      			<div class="col-sm-8">
            	<input id="ware_io_find_name2" name="name" class="form-control" readonly/>
                </div>
            </div>
            <div class="form-group">
            <label for="inputEmail3" class="col-sm-4 control-label">内容</label>
      			<div class="col-sm-8">
            	<input id="ware_io_find_num2" name = "num" class="form-control" readonly/>
                </div>
            </div>
            </form>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!--模态框3 -->
<div class="modal fade" id="ware_io_m3">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
        	<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<h4 class="modal-title">删除模板</h4>
			</div>
			<div class="modal-body" style="height:450px">
            <form class="form-horizontal" method="post" action="update_ware.php">
            <div class="form-group">
            <label for="inputEmail3" class="col-sm-4 control-label">ID</label>
      			<div class="col-sm-8">
            	<input id="temp_delete_id" name = "id" class="form-control" readonly />
                </div>
            </div>
            <div class="form-group">
            <label for="inputEmail3" class="col-sm-4 control-label">名称</label>
      			<div class="col-sm-8">
            	<input id="temp_delete_name" name="type" class="form-control" readonly/>
                </div>
            </div>
            </form>
			<button id="temp_delete_btn" class="form-control btn btn-primary" >确认删除</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
  </body>
</html>