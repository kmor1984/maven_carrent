<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>业务管理--车辆管理</title>
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
<div class="easyui-panel" style="margin-bottom: 2px;text-align: left;padding: 0px" data-options="title:'查询条件',iconCls:'icon-search',width:'100%'">
		<form action="#" method="post" id="searchFrm">
			
			<input class="easyui-textbox"  name="carnumber"  labelAlign="left" label="车牌号牌:" labelPosition="left" style="width:30%;margin: 6px;">		
			<input class="easyui-textbox"  name="cartype"  labelAlign="left"  label="车辆类型:" labelPosition="left" style="width:30%;margin: 6px;">
			<div style="width:60%;height: 5px"></div>	
			
			<input class="easyui-textbox"  name="color"  labelAlign="left"  label="车辆颜色:" labelPosition="left" style="width:30%;">		
			<input class="easyui-textbox"  name="description"   labelAlign="left"  label="车辆描述:" labelPosition="left" style="width:30%;">		
			<select class="easyui-combobox" name="isrenting" label="是否已出租:" labelPosition="left" style="width:30%;">
                <option value="">请选择</option>
                <option value="0">未出租</option>
                <option value="1">已出租</option>
                
            </select>
			<div style="height: 5px"></div>
			<div style="text-align: center;margin-bottom: 2px;">
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="doSearch()" iconCls="icon-search">查询</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#searchFrm').form('clear')" iconCls="icon-reload">重置</a>
			</div>
		</form>	
		</div>
<!-- 搜索结束-->
    <!-- 数据表格开始 -->
		<table id="dg" class="easyui-datagrid"></table>
		<div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newCar()">新增车辆</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editCar()">修改车辆</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyCar()">删除车辆</a>
        </div>
        
     <!-- 数据表格结束 -->
    
    
    <!-- 弹出层开始 -->
     <div id="dlg" class="easyui-dialog" style="width:700px;height:500px;position: relative;" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
        <form id="fm" method="post" novalidate style="margin-right:0px;padding:10px 20px;">
            <div style="width:38%;height:210px;margin-bottom:10px;position: absolute;left: 61%;top:16px">
             <input type="hidden" name="carimg" id="carimg" value="${ctx }/resources/images/default.jpg">
             <img id="carimg_img" style="border-radius:10px" width="90%" height="230px" src="${ctx }/resources/images/default.png">
                </div>
                <div style="margin-bottom:10px">
                <input name="carnumber" id="carnumber" class="easyui-textbox" labelAlign="center"  required="true" label="车牌号牌:" style="width:60%">
            </div>
            <div style="margin-bottom:10px">
                <input name="cartype" class="easyui-textbox" labelAlign="center"  required="true" label="车辆类型:" style="width:60%">
            </div>
            <div style="margin-bottom:10px">
                <input name="color" class="easyui-textbox" labelAlign="center"  required="true" label="车辆颜色:" style="width:60%">
            </div>
            <div style="margin-bottom:10px">
                <input name="price" class="easyui-numberbox" labelAlign="center"  required="true"  label="购买价格:" style="width:60%">
            </div>
             <div style="margin-bottom:10px">
                <input name="rentprice" class="easyui-numberbox" labelAlign="center" required="true"  label="出租价格:" style="width:60%">
            </div>
             <div style="margin-bottom:10px">
                <input name="deposit" class="easyui-numberbox" labelAlign="center" required="true"  label="出租押金:" style="width:60%">
            </div>
            <div style="margin-bottom:5px">
                <input name="description" class="easyui-textbox" multiline="true" labelAlign="center" required="true"  label="车辆描述:" style="width:80%;height: 50px">
                
            </div>
             <div style="margin-left:16px">
             	<select class="easyui-combobox" name="isrenting" label="出租状况:" labelPosition="center" style="width:40%;">
                <option value="0">未出租</option>
                <option value="1">已出租</option>
            </select>
            </div>
           
        </form>
        <form action="" id="imgFrm" enctype="multipart/form-data" method="post" novalidate style="margin:0;padding:0px 20px">
        	
                <input class="easyui-filebox" name="mf" style="width:80%"
				data-options="label:'选择图片:',required:true,labelAlign:'center',
				labelPosition:'left'
				,accept:'image/*'">
			<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-add'"
			onclick="uploadCarImg()">上传</a>
            
        </form>
        
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveCar()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>
    <script type="text/javascript">
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
		url:'${ctx}/car/queryAllCar.action',//json数据地址
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
  //查询车辆信息
    function doSearch(){
    	var params=$("#searchFrm").serialize();
    	$("#dg").datagrid({
    		url:'${ctx}/car/queryAllCar.action?'+params
    	});
    }
    
    
    
  //打开添加车辆的页面
   /* 新增车辆 */
   var url;
  function newCar(){
    	 $('#dlg').dialog('open').dialog('center').dialog('setTitle','添加车辆信息');
    	 $('#fm').form('clear');
    	 $('#imgFrm').form('clear');
    	 $("#carimg_img").attr({src:"${ctx }/resources/images/default.png"});
         url='${ctx}/car/addCar.action';
  }
  /* 修改车辆 */
    function editCar(){
	  /* 先得到行 */
	  var row = $('#dg').datagrid('getSelected');
    	 if(row){
	     $('#dlg').dialog('open').dialog('center').dialog('setTitle','修改车辆信息');
         $('#fm').form('load',row);
         /* 禁用修改车牌照功能 */
         $('#carnumber').textbox('readonly',true);
         $("#carimg_img").attr({src:row.carimg}),
         url='${ctx}/car/updateCar.action';
    	 }else{
    		 $.messager.show({    
                 title: '提示：',
                 msg: '请先选择要修改的车辆信息行！'
             });
    	 }
  }
  
    /* 保存（新增或修改的车辆） */
  function saveCar(){
	  $('#fm').form('submit',{
		  url: url,
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
                  $('#dg').datagrid('reload');    // 刷新数据表格
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
    /* 图片上传 */
    function uploadCarImg(){
    	var formData = new FormData($("#imgFrm")[0]);//转成js对象  $("#imgFrm")[0],文件上传的相关参数
    	$.ajax({
    		url:'${ctx }/car/uploadCarImg.action',
    		type:'POST',
    		data:formData,
    		async:false,
    		cache:false,
    		contentType:false,
    		processData:false,
    		success:function(obj){
    		carImgPath = obj.carImgPath;
    			$("#carimg_img").attr({src:carImgPath}),
    			$("#carimg").val(carImgPath);
    		},
    		error:function(rv){alert(rv);}
    	});
    }
    
  
    /* 删除车辆 */
     function destroyCar(){
         var row = $('#dg').datagrid('getSelected');
         if (row){
             $.messager.confirm('警告：','你确定就这样放弃我么？',function(r){
                 if (r){
                     $.post('${ctx}/car/delCar.action',{carnumber:row.carnumber},function(result){
                         if (result){
                         	$.messager.show({    // show error message
                                 title: '提示：',
                                 msg: '删除成功！'
                             });
                             $('#dg').datagrid('reload');    // reload the user data
                         } else {
                             $.messager.show({    // show error message
                                 title: '提示：',
                                 msg: '删除失败！'
                             });
                         }
                     },'json');
                 } 
             });
         }else {
             $.messager.show({    // show error message
                 title: '错误提示：',
                 msg: '请先选择要删除的行，然后再删除！',
             });
         }
     }
    </script>
</body>
</html>