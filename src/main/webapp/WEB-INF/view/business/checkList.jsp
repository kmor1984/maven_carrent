<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
    <meta charset="UTF-8">
    <title>业务管理--租车单据管理</title>
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
<div class="easyui-panel" style="margin-bottom: 2px;text-align: left;padding: 0px;width:'100%';heigth:'70px'" data-options="title:'查询条件',iconCls:'icon-search'">
		<form action="#" method="post" id="searchFrm">
			
			<input class="easyui-textbox"  name="checkid"  labelAlign="left" label="检查单号:" labelPosition="left" style="width:33%;margin: 6px;margin-bottom: 2px">		
			<input class="easyui-textbox"  name="rentid"  labelAlign="left"  label="出租单号:" labelPosition="left" style="width:33%;margin: 6px;margin-bottom: 2px">
			<input class="easyui-textbox"  name="problem"  labelAlign="left"  label="存在问题::" labelPosition="left" style="width:33%;margin: 6px;margin-bottom: 2px">		
			<input class="easyui-datebox"  name="startDate"   labelAlign="left"  label="开始时间:" labelPosition="left" style="width:33%;">		
			<input class="easyui-datebox"  name="endDate"   labelAlign="left"  label="结束时间:" labelPosition="left" style="width:33%;">	
			<input class="easyui-textbox"  name="checkdesc"   labelAlign="left"  label="问题描述:" labelPosition="left" style="width:33%;">	
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
     <!-- 数据表格结束 -->
 
    <script type="text/javascript">
    //加载表格数据
    $("#dg").datagrid({
    	title:'车辆检查单列表',//标题
		width:'100%',//宽度
		height:'342px',//高度
		iconCls:'icon-save',//图标
		pagination:true,//是否打开分页
		fitColumns:true,// 是否动分配列宽
		//singleSelect:true,// 是否支持单行选中
		rownumbers:true,// 是否显示行号
		url:'${ctx}/rent/checkList.action',//json数据地址
		//toolbar:'#toolbar',//工具栏
	    columns:[[
	              {field:'checkid',title:'检查单号',width:100,align:'center'},
		           {field:'checkdate',title:'检查日期',width:100,align:'center'},
		           {field:'problem',title:'存在问题',width:100,align:'center'},
		           {field:'checkdesc',title:'问题描述',width:100,align:'center'},
		           {field:'paymoney',title:'赔付金额',width:100,align:'center'},
		           {field:'rentid',title:'出租单号',width:100,align:'center'},
		           {field:'opername',title:'操作员',width:100,align:'center'}
	              ]],
    });
  //查询车辆信息
    function doSearch(){
    	var params=$("#searchFrm").serialize();
    	$("#dg").datagrid({
    		url:'${ctx}/rent/checkList.action?'+params
    	});
    }

    </script>
</body>
</html>