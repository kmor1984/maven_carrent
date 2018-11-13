<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页--一鸣汽车出租系统</title>
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/easyui/themes/icon.css">
   
    <script type="text/javascript" src="${ctx }/resources/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx }/resources/easyui/jquery.easyui.min.js"></script>
</head>
<body>
    <div style="margin:0px 0;"></div>
    <div class="easyui-layout" style="width:100%;height:350px;border:false;" >
        <div data-options="region:'east',split:true" title="当前日历" style="width:25%;border:false">
        <div class="easyui-calendar" style="width:100%;height:100%;border:false"></div>
        </div>
        <div data-options="region:'center',title:'系统公告',iconCls:'icon-ok'">
            <table class="easyui-datagrid"
                    data-options="url:'${ctx }/desk/mainData.action',method:'get',pagination:true,border:false,singleSelect:true,rownumbers:true,fit:true,fitColumns:true">
                <thead>
                    <tr>
                        <th data-options="field:'title',align:'center'" style="width:20%">新闻标题</th>
                        <th data-options="field:'content',align:'center'" style="width:43%">新闻内容</th>
                        <th data-options="field:'createtime',align:'center'" style="width:20%">发布时间</th>
                        <th data-options="field:'opername',align:'center'" style="width:20%">发布人</th>
                    </tr>
                </thead>	
            </table>
        </div>
    </div>
 
</body>
</html>