/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-11-10 04:59:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.business;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class rentCar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>业务管理--汽车出租</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/easyui/themes/default/easyui.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/easyui/themes/icon.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/easyui/themes/color.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/icon.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/wu.css\" />\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/easyui/jquery.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/js/jquery-1.8.0.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/easyui/datagrid-detailview.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- 查询条件 -->\r\n");
      out.write("<div class=\"easyui-panel\" style=\"margin-bottom: 2px;text-align: center;padding: 10px\" data-options=\"title:'查询条件',iconCls:'icon-search',width:'100%'\">\r\n");
      out.write("\t\t<form action=\"#\" method=\"post\" id=\"searchFrm\">\r\n");
      out.write("\t\t\t<input id = \"search_identity\" class=\"easyui-searchbox\" data-options=\"prompt:'请输入有效的身份证号：',searcher:doSearch\" style=\"width:40%;\">\r\n");
      out.write("\t\t\t <input type=\"hidden\" name=\"isrenting\" id=\"isrenting\" value=\"0\">\r\n");
      out.write("\t\t</form>\t\r\n");
      out.write("</div>\r\n");
      out.write("\t\t  <!-- 搜索结束-->\r\n");
      out.write("    <!-- 数据表格开始 -->\r\n");
      out.write("    \t<div id=\"content\">\r\n");
      out.write("\t\t<table id=\"dg\" class=\"easyui-datagrid\"></table>\r\n");
      out.write("\t\t<div id=\"toolbar\">\r\n");
      out.write("        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\" onclick=\"newRentCar()\">选择出租车辆</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    <!-- 数据表格结束 -->    \r\n");
      out.write("    <!-- 弹出层开始 -->\r\n");
      out.write("     <div id=\"dlg\" class=\"easyui-dialog\" style=\"width:800px;height:95%\" data-options=\"closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'\">\r\n");
      out.write("        <form id=\"fm\" method=\"post\" novalidate style=\"margin:0;padding:20px 50px;\">\r\n");
      out.write("            \r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"rentid\" id=\"rentid\" class=\"easyui-textbox\" readonly=true labelAlign=\"center\"  required=\"true\" label=\"出租单号:\" style=\"width:60%\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"identity\" id=\"identity\" class=\"easyui-textbox\" labelAlign=\"center\"  readonly=true required=\"true\" label=\"身份证号:\" style=\"width:60%\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"carnumber\" id=\"carnumber\" class=\"easyui-textbox\" labelAlign=\"center\" readonly=true required=\"true\" label=\"车辆牌照:\" style=\"width:60%\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"price\" id=\"price\" class=\"easyui-textbox\" labelAlign=\"center\"  required=\"true\"  label=\"出租价格:\" style=\"width:60%\">\r\n");
      out.write("            </div>\r\n");
      out.write("             <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"begindate\" id=\"begindate\" class=\"easyui-datebox\" labelAlign=\"center\" required=\"true\"  label=\"开始时间:\" style=\"width:60%\">\r\n");
      out.write("            </div>\r\n");
      out.write("             <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"returndate\" id=\"returndate\" class=\"easyui-datebox\" labelAlign=\"center\" required=\"true\"  label=\"还车时间:\" style=\"width:60%\">\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("             <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"opername\" id=\"opername\" class=\"easyui-textbox\" labelAlign=\"center\" readonly=true required=\"true\"  label=\"操作人员:\" style=\"width:60%\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <img id=\"carimg_img\" style=\"position: absolute;left: 60%;top: 50px;border-radius:10px\" width=\"38%\" height=\"265px\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/images/default.png\">\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"dlg-buttons\">\r\n");
      out.write("        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton c6\" iconCls=\"icon-ok\" onclick=\"saveRentCar()\" style=\"width:90px\">保存</a>\r\n");
      out.write("        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" iconCls=\"icon-cancel\" onclick=\"javascript:$('#dlg').dialog('close')\" style=\"width:90px\">取消</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("    $('#content').hide();\r\n");
      out.write("    function initTable(){\r\n");
      out.write("    \tvar params=$(\"#searchFrm\").serialize();\r\n");
      out.write("    //加载表格数据\r\n");
      out.write("     $(\"#dg\").datagrid({\r\n");
      out.write("    \t//title:'车辆列表',//标题\r\n");
      out.write("\t\twidth:'100%',//宽度\r\n");
      out.write("\t\theight:'342px',//高度\r\n");
      out.write("\t\ticonCls:'icon-save',//图标\r\n");
      out.write("\t\tpagination:true,//是否打开分页\r\n");
      out.write("\t\tfitColumns:true,// 是否动分配列宽\r\n");
      out.write("\t\tsingleSelect:true,// 是否支持单行选中\r\n");
      out.write("\t\trownumbers:true,// 是否显示行号\r\n");
      out.write("\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/car/queryAllCar.action?'+params,//json数据地址\r\n");
      out.write("\t\ttoolbar:'#toolbar',//工具栏\r\n");
      out.write("\t    columns:[[\r\n");
      out.write("{field:'carnumber',title:'车牌号牌',width:100,align:'center'},\r\n");
      out.write("{field:'cartype',title:'车辆类型',width:100,align:'center'},\r\n");
      out.write("{field:'color',title:'车辆颜色',width:100,align:'center'},\r\n");
      out.write("{field:'price',title:'购买价格',width:100,align:'center'},\r\n");
      out.write("{field:'rentprice',title:'出租价格',width:100,align:'center'},\r\n");
      out.write("{field:'deposit',title:'出租押金',width:100,align:'center'},\r\n");
      out.write("{field:'isrenting',title:'是否出租',width:100,align:'center',formatter:function(value){\r\n");
      out.write("\t   return value==1?'已出租':'未出租';\r\n");
      out.write("}},\r\n");
      out.write("{field:'description',title:'车辆描述',width:100,align:'center'}\r\n");
      out.write("\t              \r\n");
      out.write("\t              ]],\r\n");
      out.write("\t              view: detailview,    \r\n");
      out.write("\t         \t detailFormatter:function(index,row){    \r\n");
      out.write("\t         \t   return \"<img width=100px height=100px src=\"+row.carimg+\"></img>\";    \r\n");
      out.write("\t         \t    \t        }\r\n");
      out.write("\r\n");
      out.write("    });\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("  //查询车辆信息\r\n");
      out.write("    function doSearch(value){\r\n");
      out.write("    \t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/rent/queryCustomer.action\",{identity:value},function(men){\r\n");
      out.write("    \t\tif(men){\r\n");
      out.write("    \t\t\t$(\"#content\").show();//显示table\r\n");
      out.write("    \t\t\tinitTable();//初始化表格里面的数据\r\n");
      out.write("    \t\t}else{\r\n");
      out.write("    \t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\t\ttitle:'提示',\r\n");
      out.write("\t\t\t\t\tmsg:'身份证号不存在，请检查身份证是否正确'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(\"#content\").hide();//隐藏table\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t},\"json\");\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t\r\n");
      out.write("    \t\r\n");
      out.write("    \r\n");
      out.write("  //打开添加车辆的页面\r\n");
      out.write("   /* 新增车辆 */\r\n");
      out.write("   var url;\r\n");
      out.write("  /* 选择车型 */\r\n");
      out.write("    function newRentCar(){\r\n");
      out.write("\t  /* 先得到行 */\r\n");
      out.write("\t  var identity =$('#search_identity').val();\r\n");
      out.write("\t  var row = $('#dg').datagrid('getSelected');\r\n");
      out.write("    \t if(row){\r\n");
      out.write("\t     $('#dlg').dialog('open').dialog('center').dialog('setTitle','租车信息');\r\n");
      out.write("\t     //禁用车牌号的编辑功能\r\n");
      out.write("         $('rentid').textbox('readonly',true);\r\n");
      out.write("\t     $('identity').textbox('readonly',true);\r\n");
      out.write("\t     $('carnumber').textbox('readonly',true);\r\n");
      out.write("\t     $('opername').textbox('readonly',true);\r\n");
      out.write("\t     //清空数据\r\n");
      out.write("\t     $('fm').form('clear');\r\n");
      out.write("\t     $(\"#carimg_img\").attr({src:row.carimg});\r\n");
      out.write("         //请求后台，得到有效数据，在编辑框中加载显示\r\n");
      out.write("         $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/rent/initRentFormData.action\",{carnumber:row.carnumber,identity:identity,price:row.rentprice},\r\n");
      out.write("        \t\t function(rentsListVo){\r\n");
      out.write("        \t $('#fm').form('load',rentsListVo);\r\n");
      out.write("        \t },\"json\");\r\n");
      out.write("         \r\n");
      out.write("    \t }else{\r\n");
      out.write("    \t\t $.messager.show({    \r\n");
      out.write("                 title: '提示：',\r\n");
      out.write("                 msg: '请先选择要修改的车辆信息行！'\r\n");
      out.write("             });\r\n");
      out.write("    \t }\r\n");
      out.write("  }\r\n");
      out.write("  \r\n");
      out.write("    /* 保存（新增或修改的车辆） */\r\n");
      out.write("  function saveRentCar(){\r\n");
      out.write("\t  $('#fm').form('submit',{\r\n");
      out.write("\t\t  url :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/rent/addRentRecord.action',\r\n");
      out.write("          onSubmit: function(){\r\n");
      out.write("          \t//做验证\r\n");
      out.write("              return $(this).form('validate');\r\n");
      out.write("          },\r\n");
      out.write("          success: function(result){\r\n");
      out.write("        \t  if (result){\r\n");
      out.write("              \t$.messager.show({    \r\n");
      out.write("                      title: '提示：',\r\n");
      out.write("                      msg: '操作成功！'\r\n");
      out.write("                  });\r\n");
      out.write("              \t  $('#dlg').dialog('close');//关闭弹出层\r\n");
      out.write("              \t  $(\"#content\").hide();//隐藏table\r\n");
      out.write("              } else {\r\n");
      out.write("                  $.messager.show({    \r\n");
      out.write("                      title: '提示：',\r\n");
      out.write("                      msg: '操作失败！'\r\n");
      out.write("                  });\r\n");
      out.write("                  $('#dlg').dialog('close');//关闭弹出层\r\n");
      out.write("              }\r\n");
      out.write("                          \r\n");
      out.write("                      \r\n");
      out.write("          }\r\n");
      out.write("\t  });\r\n");
      out.write("\t  \r\n");
      out.write("  }\r\n");
      out.write("    \r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}