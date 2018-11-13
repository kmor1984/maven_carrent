<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>业务管理--检查单管理</title>
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/css/icon.css" />
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/css/wu.css" />
    <script type="text/javascript" src="${ctx }/resources/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx }/resources/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="${ctx }/resources/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx }/resources/easyui/locale/easyui-lang-zh_CN.js"></script>


</head>
<body>
<!-- 查询条件 -->
<div class="easyui-panel" style="margin-bottom: 2px;text-align: center;padding: 0px" data-options="title:'查询条件',iconCls:'icon-search',width:'100%'">
		<form action="#" method="post" id="searchFrm">
			<input class="easyui-textbox"  name="identity"  labelAlign="center" label="身份证号:" labelPosition="left" style="width:40%;">		
			<input class="easyui-textbox"  name="custname"  labelAlign="center"  label="客户姓名:" labelPosition="left" style="width:40%;">	
			<div style="height: 5px"></div>
			<input class="easyui-textbox"  name="address"  labelAlign="center"  label="客户地址:" labelPosition="left" style="width:40%;">		
			<input class="easyui-textbox"  name="phone"   labelAlign="center"  label="客户电话:" labelPosition="left" style="width:40%;">		
			<div style="height: 5px"></div>
			<div style="text-align: center;margin-bottom: 2px;">
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="doSearch()" iconCls="icon-search">查询</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#searchFrm').form('clear')" iconCls="icon-reload">重置</a>
			</div>
		</form>	
		  <!-- 搜索结束-->
    <!-- 数据表格开始 -->
		<table id="dg" class="easyui-datagrid"></table>
		<div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newCustomer()">新增客户</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editCustomer()">修改客户</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyCustomer()">删除客户</a>
        </div>
        
    
    
    
    <div id="dlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
        <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
            <h3>用户信息</h3>
            <div style="margin-bottom:10px">
                <input name="identity" id ="identity" class="easyui-textbox" required="true" label="身份证号:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="custname" class="easyui-textbox" required="true" label="客户姓名:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="career" class="easyui-textbox" required="true" label="客户职业:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
            <select class="easyui-combobox" name="sex" label="客户性别:" labelPosition="left" style="width:100%;margin-bottom:10px">
                <option value="1">男</option>
                <option value="0">女</option>
            </select>
            </div>
            <div style="margin-bottom:10px">
                <input name="address" class="easyui-textbox" required="true" label="客户住址:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="phone" class="easyui-textbox" required="true"  label="客户电话:" style="width:100%">
            </div>
        </form>
    </div>
  
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c2" iconCls="icon-ok" onclick="saveCustomer()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>
    <script type="text/javascript">
    //加载表格数据
    $("#dg").datagrid({
    	//title:'客户列表',//标题
		width:'100%',//宽度
		height:'342px',//高度
		iconCls:'icon-save',//图标
		pagination:true,//是否打开分页
		fitColumns:true,// 是否动分配列宽
		singleSelect:true,// 是否支持单行选中
		rownumbers:true,// 是否显示行号
		url:'${ctx}/customer/queryAllCustomer.action',//json数据地址
		toolbar:'#toolbar',//工具栏
	    columns:[[
                   {field:'identity',title:'身份证号',width:100,align:'center'}, 
                   {field:'custname',title:'姓名',width:100,align:'center'},
                   {field:'sex',title:'性别',width:100,align:'center',formatter:function(value){
                	   return value==1?'男':'女';
                   }},
                   {field:'career',title:'职业',width:100,align:'center'},
                   {field:'address',title:'地址',width:100,align:'center'},
                   {field:'phone',title:'联系方式',width:100,align:'center'},
	              
	              ]]
    });
  //查询客户信息
    function doSearch(){
    	var params=$("#searchFrm").serialize();
    	$("#dg").datagrid({
    		url:'${ctx}/customer/queryAllCustomer.action?'+params
    	});
    }
    
    
    
  //打开添加客户的页面
   /* 新增用户 */
   var url;
  function newCustomer(){
    	 $('#dlg').dialog('open').dialog('center').dialog('setTitle','添加用户信息');
    	//恢复身份证号的编辑功能
    	 $('#identity').textbox('readonly',false);
    	 $('#fm').form('clear');
         url='${ctx}/customer/addCustomer.action';
  }
  /* 修改用户 */
    function editCustomer(){
	  /* 先得到行 */
	  var row = $('#dg').datagrid('getSelected');
    	 if(row){
	     $('#dlg').dialog('open').dialog('center').dialog('setTitle','修改用户信息');
	   //禁用身份证号的编辑功能
         $('#identity').textbox('readonly',true);
         $('#fm').form('load',row);
         url='${ctx}/customer/updateCustomer.action';
    	 }else{
    		 $.messager.show({    
                 title: '提示：',
                 msg: '请先选择要修改的客户信息行！'
             });
    	 }
  }
  
    /* 保存（新增或修改的用户） */
  function saveCustomer(){
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
    /* 删除用户 */
     function destroyCustomer(){
         var row = $('#dg').datagrid('getSelected');
         if (row){
             $.messager.confirm('警告：','你确定就这样放弃我么？',function(r){
                 if (r){
                     $.post('${ctx}/customer/delCustomer.action',{identity:row.identity},function(result){
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
		
				
	</div>
</body>
</html>