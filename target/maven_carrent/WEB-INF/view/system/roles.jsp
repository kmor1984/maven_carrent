<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>系统管理--角色管理</title>
    <link rel="stylesheet" href="${ctx }/resources/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/css/icon.css" />
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/css/wu.css" />
    <script type="text/javascript" src="${ctx }/resources/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx }/resources/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="${ctx }/resources/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx }/resources/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${ctx }/resources/zTree/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="${ctx }/resources/zTree/js/jquery.ztree.excheck.js"></script>

</head>
<body>
<!-- 查询条件 -->
<div class="easyui-panel" style="margin-bottom: 2px;text-align: center;padding: 0px" data-options="title:'查询条件',iconCls:'icon-search',width:'100%' ">
		<form action="#" method="post" id="searchFrm">
		<div style="height: 5px"></div>
			<input class="easyui-textbox"  name="rolename"  labelAlign="center" label="角色名称:" labelPosition="left" style="width:40%;">		
			<input class="easyui-textbox"  name="roledesc"  labelAlign="center"  label="角色备注:" labelPosition="left" style="width:40%;">	
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
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newRoles()">新增角色</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editRoles()">修改角色</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyRoles()">删除角色</a>
         <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-tip" plain="true" onclick="invokeRoles()">角色权限分配</a>
        </div>
        
    <!-- 添加角色的弹出层 -->
    <div id="dlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
        <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
            <h3>角色信息</h3>
            <div style="margin-bottom:10px">
             <input type="hidden" name="roleid" id="roleid">
                <input name="rolename" id ="rolename" class="easyui-textbox" required="true" label="角色名称:" style="width:100%" >
            </div>
            <div style="margin-bottom:10px">
                <input name="roledesc" class="easyui-textbox" required="true" label="角色备注:" style="width:100%">
            </div>
        </form>
        <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c2" iconCls="icon-ok" onclick="saveRoles()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
        </div>
    </div>
  <!-- 给角色分配权限的弹出层 -->
  <div id="ddg" class="easyui-dialog" style="width:400px;height:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#ddg-buttons'">
            <div id="treeMenus" class="ztree"></div>
            <div id="ddg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c2" iconCls="icon-ok" onclick="saveInvokeRoles()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#ddg').dialog('close')" style="width:90px">取消</a>
            </div>
    </div>
 </div>
<script type="text/javascript">
    //加载表格数据
    $("#dg").datagrid({
    	//title:'角色列表',//标题
		width:'100%',//宽度
		height:'380px',//高度
		iconCls:'icon-save',//图标
		pagination:true,//是否打开分页
		fitColumns:true,// 是否动分配列宽
		singleSelect:true,// 是否支持单行选中
		rownumbers:true,// 是否显示行号
		url:'${ctx}/role/queryAllRoles.action',//json数据地址
		toolbar:'#toolbar',//工具栏
	    columns:[[
                   {field:'roleid',title:'角色ID',width:100,align:'center'}, 
                   {field:'rolename',title:'角色名称',width:100,align:'center'},
                   {field:'roledesc',title:'角色备注',width:100,align:'center'},
	              ]]
    });
  //查询角色信息
    function doSearch(){
    	var params=$("#searchFrm").serialize();
    	$("#dg").datagrid({
    		url:'${ctx}/role/queryAllRoles.action?'+params
    	});
    }
  //打开添加角色的页面
   /* 新增角色 */
   var url;
  function newRoles(){
    	 $('#dlg').dialog('open').dialog('center').dialog('setTitle','添加角色信息');
    	 $('#fm').form('clear');
         url='${ctx}/role/addRoles.action';
  }
  /* 修改角色 */
    function editRoles(){
	  /* 先得到行 */
	  var row = $('#dg').datagrid('getSelected');
    	 if(row){
	     $('#dlg').dialog('open').dialog('center').dialog('setTitle','修改角色信息');
         $('#fm').form('load',row);
         url='${ctx}/role/updateRoles.action';
    	 }else{
    		 $.messager.show({    
                 title: '提示：',
                 msg: '请先选择要修改的角色信息行！'
             });
    	 }
  }
  
    /* 保存（新增或修改的角色） */
  function saveRoles(){
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
    
    
    /* 删除角色 */
     function destroyRoles(){
         var row = $('#dg').datagrid('getSelected');
         if (row){
             $.messager.confirm('警告：','你确定就这样放弃我么？',function(r){
                 if (r){
                     $.post('${ctx}/role/delRoles.action',{roleid:row.roleid},function(result){
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
    
    
    
    
    /* 初始化菜单树，准备给角色进行分配 */
    var setting = {
			data: {
				simpleData: {
					enable: true
				}
			},
          check:{
        	  enable: true
          }
		};
    //给角色分配权限
     function invokeRoles(){
    	 var row = $('#dg').datagrid('getSelected');
         if (row){
        	 $('#ddg').dialog('open').dialog('center').dialog('setTitle','给角色分配权限');
        	 $('#fm').form('load',row);
        	 var url="${ctx}/role/invokeRoles.action?roleid="+row.roleid;
     		$.post(url,function(json){
     			$.fn.zTree.init($("#treeMenus"), setting, json);
     	});
         }else {
             $.messager.show({    // show error message
                 title: '错误提示：',
                 msg: '请先选择要分配的角色，然后再分配！',
             });
         }
     }
    
    //保存角色权限分配
     function saveInvokeRoles(){
	            //先选择要修改权限的角色行
	            var row = $('#dg').datagrid('getSelected');
	            //拿到这个角色ID
	            var roleid =row.roleid;
	            //把这个角色ID封装到参数中
	            var param ="?roleid="+roleid;
	            //得到zTree的树(easyui上面有参考)
	             var treeObj = $.fn.zTree.getZTreeObj("treeMenus");
	            //得到被选择中的节点集合(easyui上面有参考)
	            var nodes = treeObj.getCheckedNodes(true);
	            //循环这个集合，得到被选中的每个集合的节点ID
	            for(var i = 0;i<nodes.length;i++){
	            	var node = nodes[i];
	            	param+="&ids="+node.id;//把这个集合节点的ID都封装到参数中 
	            };
	            
	            //调用post请求传给后台
	            $.post("${ctx}/role/saveInvokeRoles.action"+param,function(map){
	            	$.messager.show({
	            		title:'提示：',
	            		msg: map.msg
	            		
	            	});
	            });
              	  $('#ddg').dialog('close');//关闭弹出层
    }
    </script>
</body>
</html>