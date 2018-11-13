<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>业务管理--汽车入库</title>
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/css/icon.css" />
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/css/wu.css" />
    <script type="text/javascript" src="${ctx }/resources/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx }/resources/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="${ctx }/resources/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx }/resources/easyui/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${ctx }/resources/easyui/locale/easyui-lang-zh_CN.js"></script>


</head>
<body>
<!-- 查询条件 -->
<div class="easyui-panel" style="margin-bottom: 2px;text-align: center;padding: 0px" data-options="title:'查询条件',iconCls:'icon-search',width:'100%'">
		<form action="#" method="post" id="searchFrm">
			<input id = "search_carBills" name="rentid" class="easyui-searchbox" label='租车单号:' data-options="prompt:'请输入有效的租车单号：',searcher:doSearch" style="width:40%;">
		</form>	
</div>
 <!-- 搜索结束-->
 <!-- 生成检查单开始 -->
 <div id="content">
 <div class="easyui-panel" style="margin-bottom: 2px;text-align: left;padding: 9px" data-options="title:'生成检查单',iconCls:'icon-search',width:'100%'">
		<form action="#" method="post" id="fm">
			<div style="margin-left:30px"> 
			<input class="easyui-textbox"  id = "checkid" name="checkid"   labelAlign="center" label="检查单号:" labelPosition="left" style="width:33%;">		
			<input class="easyui-textbox" id="form_rentid" name="rentid"   labelAlign="left"  label="出租单号:" labelPosition="left" style="width:33%;">
			<input class="easyui-textbox"  id = "opername" name="opername"   labelAlign="left"   label="检查人员:" labelPosition="left" style="width:33%;">	
			<input class="easyui-datebox"  name="checkdate"   labelAlign="left" required="true"  label="归还日期:" labelPosition="left" style="width:33%;">		
			<input class="easyui-textbox"  name="problem"   labelAlign="left"  required="true" label="存在问题:" labelPosition="left" style="width:33%;">	
			<input class="easyui-textbox"  name="paymoney"   labelAlign="left"  required="true" label="赔付金额:" labelPosition="left" style="width:33%;">	
			<div style="margin-bottom:5px">
                <input name="checkdesc" class="easyui-textbox" multiline="true" labelAlign="center" required="true"  label="问题描述:" style="width:100%;height: 50px">
                
            </div>	
			<div style="height: 5px"></div>
			<div style="text-align: center;margin-bottom: 2px;">
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="checkSave()" iconCls="icon-save">保存</a>
			</div>
			</div>
		</form>	
		</div>
<!-- 生成检查单结束 -->
    <!-- 租车各类信息开始 -->
   <div class="easyui-layout" style="width: 100%;height: 200px">
    	 <div class="easyui-panel" data-options="region:'west',split:true,title:'车辆信息',iconCls:'icon-ok',width:'33%'">
    	<!--  tr在表格中代表行thead在表格中代表表头table代表表格的主题部分td在表格中代表列 -->
    	 <table width="100%" cellspacing="5px">
    	  <tr>	
    	    <td width="20%" align="center">车辆号牌:</td>
    	    <td width="50%" id="car_carnumber"></td>
    	  </tr>
    	  <tr>
    	    <td width="20%" align="center">车辆颜色:</td>
    	    <td width="50%" id="car_color"></td>
    	  </tr>
    	  <tr>
    	    <td width="20%" align="center">车辆类型:</td>
    	    <td width="50%" id="car_cartype"></td>
    	  </tr>
    	  <tr>
    	    <td width="20%" align="center">车辆价格:</td>
    	    <td width="50%" id="car_price"></td>
    	  </tr>
    	  <tr>
    	    <td width="20%" align="center">车辆押金:</td>
    	    <td width="50%" id="car_deposit"></td>
    	  </tr>
    	  <tr>
		    <td align="right">车辆图片:</td>
		   	    <td align="left">
		   	<img alt="未找到图片" id="car_carimg" width="150" height="130" src="../resources/images/default.png" >
		   		</td>
		   </tr>
    	</table>
    	</div>
    	<div class="easyui-panel" data-options="region:'center',split:true,title:'租车单信息',iconCls:'icon-ok',width:'33%'">
    	<table width="100%" cellspacing="5px">
    	  <tr>	
    	    <td width="20%" align="center">出租单号:</td>
    	    <td width="50%" id="rent_rentid"></td>
    	  </tr>
    	  <tr>
    	    <td width="20%" align="center">出租价格:</td>
    	    <td width="50%" id="rent_price"></td>
    	  </tr>
    	  <tr>
    	    <td width="20%" align="center">开始时间:</td>
    	    <td width="50%" id="rent_begindate"></td>
    	  </tr>
    	  <tr>
    	    <td width="20%" align="center">还车时间:</td>
    	    <td width="50%" id="rent_returndate"></td>
    	  </tr>
    	  <tr>
    	    <td width="20%" align="center">操作人员:</td>
    	    <td width="50%" id="rent_opername"></td>
    	  </tr>
    	</table>
    	
    	
    	
    	</div>
    	<div class="easyui-panel" data-options="region:'east',split:true,title:'客户信息',iconCls:'icon-ok',width:'33%'">
    	
    	<table width="100%" cellspacing="5px">
    	  <tr>	
    	    <td width="20%" align="center">身份证号:</td>
    	    <td width="50%" id="customer_identity"></td>
    	  </tr>
    	  <tr>
    	    <td width="20%" align="center">客户姓名:</td>
    	    <td width="50%" id="customer_custname"></td>
    	  </tr>
    	  <tr>
    	    <td width="20%" align="center">客户地址:</td>
    	    <td width="50%" id="customer_address"></td>
    	  </tr>
    	  <tr>
    	    <td width="20%" align="center">客户电话:</td>
    	    <td width="50%" id="customer_phone"></td>
    	  </tr>
    	   <tr>
    	    <td width="20%" align="center">客户性别:</td>
    	    <td width="50%" id="customer_sex"></td>
    	  </tr>
    	</table>
    	</div>
    	</div>
    <!-- 租车各类信息结束 -->    

    <script type="text/javascript">
 $(function(){
	 $('#content').hide();
 });
  //查询车辆是否已归还
    function doSearch(value){
    	$.post("${ctx}/rent/checkRentBills.action",{rentid:value},function(result){
    		if(result.obj){
    			$("#content").show();//显示table
    			Checklist(value);//初始化表格里面的数据
    		}else{
    			$.messager.show({
                    title: '提示',
                    msg: result.msg
                });
				$("#content").hide();//隐藏table
			}
		},"json");
    		}
    	
   /* 检查完成出租单后，页面加载租车，车辆，客户的详细信息 */
   var cd;
   var rd;
   var oa;
    function Checklist(value){
         //请求后台，得到有效数据，在编辑框中加载显示
         $.post("${ctx}/rent/checkCreateBills.action",{rentid:value},
        		 function(map){
        	 /* 设置表单参数 */
        	 var m=map.checkListVo;
        	 cd=m.checkid;
        	 rd=m.rentid;
        	 oa=m.opername;
        	 $('#checkid').textbox('disable',true);
        	 $('#form_rentid').textbox('disable',true);
        	 $('#opername').textbox('disable',true);
        	 $('#fm').form('load',m);
        	//设置车辆信息
				var car=map.car;
				$("#car_carnumber").html(car.carnumber);
				$("#car_color").html(car.color);
				$("#car_cartype").html(car.cartype);
				$("#car_price").html(car.price);
				$("#car_deposit").html(car.deposit);
				$("#car_carimg").attr({src:car.carimg});
				//设置出租单信息
				var rent=map.rent;
				$("#rent_rentid").html(rent.rentid);
				$("#rent_price").html(rent.price);
				$("#rent_begindate").html(rent.begindate);
				$("#rent_returndate").html(rent.returndate);
				$("#rent_opername").html(rent.opername);
				//设置客户信息
				var customer=map.customer;
				$("#customer_identity").html(customer.identity);
				$("#customer_custname").html(customer.custname);
				$("#customer_address").html(customer.address);
				$("#customer_phone").html(customer.phone);
				$("#customer_sex").html(customer.sex==1?'男':'女');
			},"json");
  }
  
    /* 保存（新增或修改的车辆） */
  function checkSave(){
	  $('#fm').form('submit',{
		  url :'${ctx}/rent/checkSaveBills.action?'+"&checkid="+cd+"&rentid="+rd+"&opername="+oa,
          onSubmit: function(){
          	//做验证
              return $(this).form('validate');
          },
          success: function(map){
        	
        		var map = eval('('+map+')');
              	$.messager.show({    
                      title: '提示：',
                      msg: map.msg
                  });
              	  $('#dlg').dialog('close');//关闭弹出层
              	  $("#content").hide();//隐藏table
              	 $('#searchFrm').form('clear');
          }
	  });
	  
  }
    
    </script>
</body>
</html>
