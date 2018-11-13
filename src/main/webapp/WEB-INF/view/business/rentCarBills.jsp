<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
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
			
			<input class="easyui-textbox"  name="rentid"  labelAlign="left" label="出租单号:" labelPosition="left" style="width:33%;margin: 6px;margin-bottom: 2px">		
			<input class="easyui-textbox"  name="identity"  labelAlign="left"  label="身份证号:" labelPosition="left" style="width:33%;margin: 6px;margin-bottom: 2px">
			<input class="easyui-textbox"  name="carnumber"  labelAlign="left"  label="车辆牌照:" labelPosition="left" style="width:33%;margin: 6px;margin-bottom: 2px">		
			<input class="easyui-textbox"  name="begindate"   labelAlign="left"  label="起租时间:" labelPosition="left" style="width:33%;">		
			<input class="easyui-textbox"  name="returndate"   labelAlign="left"  label="还车时间:" labelPosition="left" style="width:33%;">	
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
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editRentBills()">修改租车单</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyRentBills()">删除租车单</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-page-excel" plain="true" onclick="newCar()">导出租车单</a>
        </div>
        
     <!-- 数据表格结束 -->
    
    
    <!-- 弹出层开始 -->
     <div id="dlg" class="easyui-dialog" style="width:500px;height:500px;position: relative;" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
        <form id="fm" method="post" novalidate style="margin-right:0px;padding:10px 50px;">
           <!--  <div style="width:38%;height:210px;margin-bottom:10px;position: absolute;left: 61%;top:16px">
                </div> -->
                <div style="margin-bottom:10px">
                <input name="rentid" id="rentid" class="easyui-textbox"  labelAlign="center"  required="true" label="出租单号:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="identity" id="identity" class="easyui-textbox"   labelAlign="center"  required="true" label="身份证号:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="carnumber" id="carnumber" class="easyui-textbox" labelAlign="center"   required="true" label="车辆牌照:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="price" class="easyui-numberbox" labelAlign="center"   required="true"  label="出租价格:" style="width:100%">
            </div>
             <div style="margin-bottom:10px">
                <input name="begindate" id="begindate" class="easyui-datebox" labelAlign="center" readonly="true" required="true"  label="开始时间:" style="width:100%">
            </div>
             <div style="margin-bottom:10px">
                <input name="returndate" id="returndate" class="easyui-datebox" labelAlign="center"  required="true"  label="还车时间:" style="width:100%">
            </div>
            
             <div style="margin-bottom:10px;">
             	<select class="easyui-combobox" id="rentflag" name="rentflag" label="出租状况:" readonly="true" labelPosition="right" style="width:60%;">
                <option value="0">未出租</option>
                <option value="1">已出租</option>
            </select>
            </div>
           <div style="margin-bottom:5px">
                <input name="opername" id="opername" class="easyui-textbox"  readonly="true" labelAlign="center" required="true"  label="操作人:" style="width:100%">
                
            </div>
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
		url:'${ctx}/rent/queryAllRentBills.action',//json数据地址
		toolbar:'#toolbar',//工具栏
	    columns:[[
{field:'rentid',title:'出租车单号',width:170,align:'center'},
{field:'identity',title:'身份证号',width:120,align:'center'},
{field:'carnumber',title:'车辆牌照',width:80,align:'center'},
{field:'price',title:'出租价格',width:60,align:'center'},
{field:'begindate',title:'起租时间',width:70,align:'center'},
{field:'returndate',title:'还车时间',width:70,align:'center'},
{field:'rentflag',title:'是否出租',width:60,align:'center',formatter:function(value){
	   return value==1?'已出租':'未出租';
}},
{field:'opername',title:'操作员',width:90,align:'center'}
	              
	              ]],
    });
  //查询车辆信息
    function doSearch(){
    	var params=$("#searchFrm").serialize();
    	$("#dg").datagrid({
    		url:'${ctx}/rent/queryAllRentBills.action?'+params
    	});
    }

  /* 修改出租车单 */
    var data;
    function editRentBills(){
	  /* 先得到行 */
	  var row = $('#dg').datagrid('getSelected');
	      data=row;
    	 if(row){
	     $('#dlg').dialog('open').dialog('center').dialog('setTitle','修改租车信息');
         $('#fm').form('load',row);
         /* 禁用修改车牌照功能,readonly两种方式：一种是直接加在属性列上，一种是加在这里 */
         /* 如果想要禁用后，输入框里面字体变成灰色，直接用disable; 只要能通过id找得到，不管你什么box，都可以。*/
         $('#identity').textbox('disable',true);
         $('#carnumber').textbox('disable',true);
         $('#begindate').datebox('disable',true);
         $('#rentid').textbox('disable',true);
         $('#opername').textbox('disable',true);
         $('#rentflag').textbox('disable',true);
         
    	 }else{
    		 $.messager.show({    
                 title: '提示：',
                 msg: '请先选择要修改的租车信息行！'
             });
    	 }
  }
  
    /* 保存（新增或修改的车辆） */
  function saveCar(){
	  var params=$("#fm").serialize();
	  params=params+"&rentid="+data.rentid;
	  $('#fm').form('submit',{
		  url: "${ctx}/rent/updateRentBills.action?"+params,
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

    /* 删除车辆 */
     function destroyRentBills(){
         var row = $('#dg').datagrid('getSelected');
         if (row){
             $.messager.confirm('警告：','你确定就这样放弃我么？',function(r){
                 if (r){
                     $.post('${ctx}/rent/delRentBills.action',{rentid:row.rentid},function(result){
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