<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>业务管理--汽车出租</title>
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
<div class="easyui-panel" style="margin-bottom: 2px;text-align: center;padding: 10px" data-options="title:'查询条件',iconCls:'icon-search',width:'100%'">
		<form action="#" method="post" id="searchFrm">
			<input id = "search_identity" class="easyui-searchbox" data-options="prompt:'请输入有效的身份证号：',searcher:doSearch" style="width:40%;">
			 <input type="hidden" name="isrenting" id="isrenting" value="0">
		</form>	
</div>
		  <!-- 搜索结束-->
    <!-- 数据表格开始 -->
    	<div id="content">
		<table id="dg" class="easyui-datagrid"></table>
		<div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newRentCar()">选择出租车辆</a>
        </div>
        </div>
    <!-- 数据表格结束 -->    
    <!-- 弹出层开始 -->
     <div id="dlg" class="easyui-dialog" style="width:800px;height:95%" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
        <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px;">
            
            <div style="margin-bottom:10px">
                <input name="rentid" id="rentid" class="easyui-textbox" readonly=true labelAlign="center"  required="true" label="出租单号:" style="width:60%">
            </div>
            <div style="margin-bottom:10px">
                <input name="identity" id="identity" class="easyui-textbox" labelAlign="center"  readonly=true required="true" label="身份证号:" style="width:60%">
            </div>
            <div style="margin-bottom:10px">
                <input name="carnumber" id="carnumber" class="easyui-textbox" labelAlign="center" readonly=true required="true" label="车辆牌照:" style="width:60%">
            </div>
            <div style="margin-bottom:10px">
                <input name="price" id="price" class="easyui-textbox" labelAlign="center"  required="true"  label="出租价格:" style="width:60%">
            </div>
             <div style="margin-bottom:10px">
                <input name="begindate" id="begindate" class="easyui-datebox" labelAlign="center" required="true"  label="开始时间:" style="width:60%">
            </div>
             <div style="margin-bottom:10px">
                <input name="returndate" id="returndate" class="easyui-datebox" labelAlign="center" required="true"  label="还车时间:" style="width:60%">
            </div>
            
             <div style="margin-bottom:10px">
                <input name="opername" id="opername" class="easyui-textbox" labelAlign="center" readonly=true required="true"  label="操作人员:" style="width:60%">
            </div>
            <div style="margin-bottom:10px">
            </div>
            <img id="carimg_img" style="position: absolute;left: 60%;top: 50px;border-radius:10px" width="38%" height="265px" src="${ctx }/resources/images/default.png">
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveRentCar()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>
    <script type="text/javascript">
    $('#content').hide();
    function initTable(){
    	var params=$("#searchFrm").serialize();
    //加载表格数据
     $("#dg").datagrid({
    	//title:'车辆列表',//标题
		width:'100%',//宽度
		height:'342px',//高度
		iconCls:'icon-save',//图标
		pagination:true,//是否打开分页
		fitColumns:true,// 是否动分配列宽
		singleSelect:true,// 是否支持单行选中
		rownumbers:true,// 是否显示行号
		url:'${ctx}/car/queryAllCar.action?'+params,//json数据地址
		toolbar:'#toolbar',//工具栏
	    columns:[[
{field:'carnumber',title:'车牌号牌',width:100,align:'center'},
{field:'cartype',title:'车辆类型',width:100,align:'center'},
{field:'color',title:'车辆颜色',width:100,align:'center'},
{field:'price',title:'购买价格',width:100,align:'center'},
{field:'rentprice',title:'出租价格',width:100,align:'center'},
{field:'deposit',title:'出租押金',width:100,align:'center'},
{field:'isrenting',title:'是否出租',width:100,align:'center',formatter:function(value){
	   return value==1?'已出租':'未出租';
}},
{field:'description',title:'车辆描述',width:100,align:'center'}
	              
	              ]],
	              view: detailview,    
	         	 detailFormatter:function(index,row){    
	         	   return "<img width=100px height=100px src="+row.carimg+"></img>";    
	         	    	        }

    });
    }
    
    
  //查询车辆信息
    function doSearch(value){
    	$.post("${ctx}/rent/queryCustomer.action",{identity:value},function(men){
    		if(men){
    			$("#content").show();//显示table
    			initTable();//初始化表格里面的数据
    		}else{
    			$.messager.show({
					title:'提示',
					msg:'身份证号不存在，请检查身份证是否正确'
				});
				$("#content").hide();//隐藏table
			}
		},"json");
    		}
    	
    	
    
  //打开添加车辆的页面
   /* 新增车辆 */
   var url;
  /* 选择车型 */
    function newRentCar(){
	  /* 先得到行 */
	  var identity =$('#search_identity').val();
	  var row = $('#dg').datagrid('getSelected');
    	 if(row){
	     $('#dlg').dialog('open').dialog('center').dialog('setTitle','租车信息');
	     //禁用车牌号的编辑功能
         $('rentid').textbox('readonly',true);
	     $('identity').textbox('readonly',true);
	     $('carnumber').textbox('readonly',true);
	     $('opername').textbox('readonly',true);
	     //清空数据
	     $('fm').form('clear');
	     $("#carimg_img").attr({src:row.carimg});
         //请求后台，得到有效数据，在编辑框中加载显示
         $.post("${ctx}/rent/initRentFormData.action",{carnumber:row.carnumber,identity:identity,price:row.rentprice},
        		 function(rentsListVo){
        	 $('#fm').form('load',rentsListVo);
        	 },"json");
         
    	 }else{
    		 $.messager.show({    
                 title: '提示：',
                 msg: '请先选择要修改的车辆信息行！'
             });
    	 }
  }
  
    /* 保存（新增或修改的车辆） */
  function saveRentCar(){
	  $('#fm').form('submit',{
		  url :'${ctx}/rent/addRentRecord.action',
          onSubmit: function(){
          	//做验证
              return $(this).form('validate');
          },
          success: function(result){
        	  if (result){
              	$.messager.show({    
                      title: '提示：',
                      msg: '操作成功！'
                  });
              	  $('#dlg').dialog('close');//关闭弹出层
              	  $("#content").hide();//隐藏table
              } else {
                  $.messager.show({    
                      title: '提示：',
                      msg: '操作失败！'
                  });
                  $('#dlg').dialog('close');//关闭弹出层
              }
                          
                      
          }
	  });
	  
  }
    
    </script>
</body>
</html>
