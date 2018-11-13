<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>系统管理--日志管理</title>
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
<div class="easyui-panel" style="text-align: center;height:480px" data-options="title:'查询条件',iconCls:'icon-search',width:'100%'">
 <div style="width:100%;height:30%;">
 <form action="#" method="post" id="searchFrm">
<div style="margin-bottom:5px;margin-top: 10px;">
            <input class="easyui-textbox" name="loginname" label="登录名称:" labelAlign="center"  labelPosition="left" style="width:40%;">
            <input class="easyui-textbox" name="loginip" label="登录地址:" labelAlign="center" labelPosition="left" style="width:40%;">
        </div>	
<div style="margin-bottom:5px;margin-top:10px">
            <input class="easyui-datebox" name="startDate" label="开始时间:" labelAlign="center"  labelPosition="left" style="width:40%;">
        <input class="easyui-datebox" name="endDate" label="结束时间:" labelAlign="center"  labelPosition="left" style="width:40%;">
        </div>
        <div style="height: 5px;text-align: center;margin-top: 15px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="doSearch()" iconCls="icon-search">查询</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#searchFrm').form('clear')" iconCls="icon-reload">重置</a>
        </div>
        </form>
</div>
   <table id="dg" class="easyui-datagrid" style="width:100%;height:68%"
            url="${ctx }/LogInfo/LogInfo.action"
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
                <th field="id" align="center" width="45">ID</th>
                <th field="loginname" align="center" width="45">登录名称</th>
                <th field="loginip" align="center" width="45">登录地址</th>
                <th field="logintime" align="center" width="45">登录时间</th>
                
            </tr>
        </thead>
    </table>
    <div id="toolbar">
        
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteLog()">单行选中删除</a>
    </div>
</div>

    
    
    <script type="text/javascript">
    function doSearch(){
    	var prams=$("#searchFrm").serialize();
    	$("#dg").datagrid({
    		url:'${ctx }/LogInfo/LogInfo.action?'+prams,
    		
    	});
    }
    
        function deleteLog(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('警告：','你确定就这样放弃我么？',function(r){
                    if (r){
                        $.post('${ctx }/LogInfo/deleteLog.action',{id:row.id},function(result){
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