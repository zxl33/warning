<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    
    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/resources/mc/css/bootstrap.min.css" rel="stylesheet">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
    <script src="<%=request.getContextPath()%>/resources/mc/js/hf_hotel.js"></script>

</head>
<body onLoad="message_onload()">
   
    <div class="row">
         <div class="col-lg-10 col-md-10 col-sm-10 ">
         <h2>告警信息列表</h2>
         <form class="form-inline col-lg-10">
         	<div class="form-group">
            <label for="inputEmail3" class="control-label">组件名</label>
            <input type="text" name="num" class="form-control" id="ware_item_add_price1" placeholder="">
          </div>
            <div class="form-group">
              <label for="exampleInputEmail2">&nbsp;&nbsp;有效期</label>
              <input type="date" class="form-control" id="ware_item_find_date3" placeholder="XXXX-XX-XX">
            </div>
            <div class="form-group">
              <label for="exampleInputEmail2">至</label>
              <input type="date" class="form-control" id="ware_item_find_date4" placeholder="XXXX-XX-XX">
            </div>
			</form>
            <button class="btn btn-primary" id="ware_item_find1">确定查询</button>
          <br>
          <div style="cursor:pointer; margin-top:20px;" >
          <table class="table table-bordered table-hover" id="ware_item_find_table">
            <tr >
            			<th>告警号</th>
            		    <th>组件名</th>
                	  <th>持续时间</th>
          					<th>最后时间</th>
          					<th>次数</th>
          					<th>参数</th>
                    <th>服务器类型</th>
                    <th>服务类型</th>
					          <th>所在机房</th>
                    <th>所属组</th>
                    <th>操作</th>
				</tr>
               
          </table>
          </div>
         </div>
     </div>
     


<!--模态框2 -->
<div class="modal fade" id="ware_item_m2">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
        	<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<h4 class="modal-title">操作处理</h4>
			</div>
			<div class="modal-body" style="height:600px;">
            	<form class="form-horizontal" method="post" action="update_item.php">
                <div class="form-group">
                	<label for="inputEmail3" class="col-sm-4 control-label">组件名</label>
                    <div class="col-sm-8">
                    <input type="text" name="id" class="form-control" id="ware_item_find_id2" readonly />
                    </div>
                 </div>
                 <div class="form-group">
                    <label for="inputEmail3" class="col-sm-4 control-label">原因</label>
                    <div class="col-sm-8">
                    <input type="text" name="price" class="form-control" id="ware_item_find_price2" />
                    </div>
                 </div>
                 <div class="form-group">
                    <label for="inputEmail3" class="col-sm-4 control-label">描述</label>
                    <div class="col-sm-8">
                    <input type="text" name="standard" class="form-control" id="ware_item_find_standard2" />
                    </div>
                 </div>
                 <div class="form-group">
                    <label for="inputEmail3" class="col-sm-4 control-label">解决</label>
                    <div class="col-sm-8">
                    	是<input type="radio" name="ware_item_find_dw2" class="" id="ware_item_find_dw2" value="true" />
                    	否<input type="radio" name="ware_item_find_dw2" class="" id="ware_item_find_dw2" value="false" />
                    </div>
                </div>
                </form>
                <button id="ware_supply_add_add3" class="form-control btn btn-primary">保存</button>
			</div>

		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>
