<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="copyright" content="All Rights Reserved, Copyright (C) 2013, Wuyeguo, Ltd." />
<title>菜单管理</title>
<link rel="stylesheet" href="${ctx }/resources/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" type="text/css" href="${ctx }/resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${ctx }/resources/css/wu.css" />
<link rel="stylesheet" type="text/css" href="${ctx }/resources/css/icon.css" />
<script type="text/javascript" src="${ctx }/resources/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery.ztree.core.js"></script>

</head>
<body class="easyui-layout">
<div class="easyui-layout" style="width: 100%;height: 550px">
		<div class="easyui-panel" data-options="region:'west',title:'菜单树',width:'25%',height:'100%',iconCls:'icon-save'">
			<div id="treeMenus" class="ztree"></div>
		</div>
		<div class="easyui-panel" data-options="region:'center',title:'菜单列表',width:'25%',height:'100%',iconCls:'icon-save'">
			<table id = "dg" class="easyui-datagrid" ></table>
			<div id="toolbar">
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newMenu()">添加菜单</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editMenu()">修改菜单</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyMenu()">删除菜单</a>
		    </div>
		</div>
</div>	
<!-- 新增菜单弹出层开始 --> 
<div id="dlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
        <form id="fm" method="post" novalidate style="padding:20px 50px">
             <div style="margin-bottom:10px">
            	<input name="id" type="hidden">
                <input name="pid" class="easyui-combotree" url="${ctx}/menu/loadMenusForAdd.action?available=1" method="get" labelAlign="center"  required="true" label="父节点:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="name" id ="name" class="easyui-textbox" required="true" label="菜单名称:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="href" class="easyui-textbox" required="true" label="菜单地址:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="target" class="easyui-textbox" required="true" label="TARGET" style="width:100%">
            </div>
             <div style="margin-bottom:10px">
                <input name="icon" class="easyui-textbox" required="true" label="菜单图标" style="width:100%">
            </div>
             <div style="margin-bottom:10px">
                <input name="tabicon" class="easyui-textbox" required="true" label="TAB图标" style="width:100%">
            </div>
             <div style="margin-bottom:10px">
                <select class="easyui-combobox" name="open" label="是否展开:" labelPosition="left" style="width:100%;margin-bottom:10px">
                <option value="1">是</option>
                <option value="0">否</option>
            </select>
            </div>
            <div style="margin-bottom:10px">
            <select class="easyui-combobox" name="parent" label="是否是父结点:" labelPosition="left" style="width:100%;margin-bottom:10px">
                <option value="1">是</option>
                <option value="0">否</option>
            </select>
            </div>
            <div style="margin-bottom:10px">
            <select class="easyui-combobox" name="available" label="是否有效菜单:" labelPosition="left" style="width:100%;margin-bottom:10px">
                <option value="1">是</option>
                <option value="0">否</option>
            </select>
            </div>
        </form>
        <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c2" iconCls="icon-ok" onclick="saveMenu()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>
    </div>
<!-- 新增菜单弹出层结束 -->
    <SCRIPT type="text/javascript">

	/* 加载表格数据datagrid */
	$("#dg").datagrid({
	//title:'菜单列表',//标题
	border:false,//边框
	width:'100%',//宽度
	height:'470px',//高度
	iconCls:'icon-save',//图标
	pagination:true,//是否打开分页
	fitColumns:true,// 是否动分配列宽
	singleSelect:true,// 是否支持单行选中
	//rownumbers:true,// 是否显示行号
	url:'${ctx}/menu/queryAllMenu.action',//json数据地址
	toolbar:'#toolbar',//工具栏
    columns:[[
{field:'id',title:'菜单ID',width:100,align:'center'},
{field:'pid',title:'父节点ID',width:100,align:'center'},
{field:'name',title:'菜单名称',width:100,align:'center'},
{field:'href',title:'菜单链接',width:100,align:'center'},
{field:'open',title:'是否打开',width:100,align:'center',formatter:function(value){
   return value==1?'<font color=blue>打开</font>':'<font color=red>不打开</font>';
}},
{field:'parent',title:'是否是父节点',width:100,align:'center',formatter:function(value){
   return value==1?'<font color=blue>父节点</font>':'<font color=red>非父节点</font>';
}},
{field:'target',title:'	Target',width:100,align:'center'},
{field:'icon',title:'菜单图标',width:100,align:'center',formatter:function(value){
var html = "<img src='"+value+"'/>"+value;
return html;
}},
{field:'tabicon',title:'Tab图标',width:100,align:'center'},
{field:'available',title:'是否可用',width:100,align:'center',formatter:function(value){
   return value==1?'<font color=blue>可用</font>':'<font color=red>不可用</font>';
}},
              ]]

});
	
    /* 加载左边的菜单树 */
    function zTreeOnClick(event, treeId, treeNode) {
    	$("#dg").datagrid({
    		url:'${ctx}/menu/queryAllMenu.action?id='+ treeNode.id,
    	});
    };
		var setting = {
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: zTreeOnClick
			}
		};
/* 再查询数据加载 */
    $(document).ready(function(){
    	initData();
		});
		//因为添加完成这后，要刷新左边的菜单树，所以可以把这个数据加载独立成一个方法，添加完成之后，调用这个方法刷新数据
		function initData(){
			var url="${ctx}/menu/loadMunusForLeft.action";
			$.post(url,function(json){
				$.fn.zTree.init($("#treeMenus"), setting, json);
		});
		}	
    /* 添加菜单 */
    /* 这个url在添加和保存的页面上都有，所以提出来做个共用的变量，当需要添加菜单时，把方法里的url传给
            这个url变量。这样Save方法就可以重复使用了。 */
            //添加菜单
     var url;
    function newMenu(){
         $('#dlg').dialog('open').dialog('center').dialog('setTitle','添加菜单');
         $('#fm').form('clear');
         $('#fm').form("load",{open:0,parent:0,available:1});//解决单选按钮的默认选中 */
         url="${ctx}/menu/addMenu.action";
    }	
           
    
    /* 修改菜单 */
    function editMenu(){
	  /* 先得到行 */
	  var row = $('#dg').datagrid('getSelected');
    	 if(row){
	     $('#dlg').dialog('open').dialog('center').dialog('setTitle','修改菜单信息');
         $('#fm').form('load',row);
         url="${ctx}/menu/updateMenu.action";
    	 }else{
    		 $.messager.show({    
                 title: '提示：',
                 msg: '请先选择要修改的菜单信息行！'
             });
    	 }
  }
  
    /* 保存（新增或修改的菜单） */
  function saveMenu(){
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
                  initData();
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
      
    /* 删除菜单 */
     function destroyMenu(){
         var row = $('#dg').datagrid('getSelected');
         if (row){
             $.messager.confirm('警告：','你确定就这样放弃我么？',function(r){
                 if (r){
                     $.post('${ctx}/menu/delMenu.action',{id:row.id},function(result){
                         if (result){
                        	 initData();
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
    
    
    
    
    
    
    
    
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	</SCRIPT>
</body>
</html>
