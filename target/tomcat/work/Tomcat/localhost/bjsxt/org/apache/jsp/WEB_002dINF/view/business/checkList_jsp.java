/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-11-10 04:59:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.business;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class checkList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>业务管理--租车单据管理</title>\r\n");
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
      out.write("<div class=\"easyui-panel\" style=\"margin-bottom: 2px;text-align: left;padding: 0px;width:'100%';heigth:'70px'\" data-options=\"title:'查询条件',iconCls:'icon-search'\">\r\n");
      out.write("\t\t<form action=\"#\" method=\"post\" id=\"searchFrm\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<input class=\"easyui-textbox\"  name=\"checkid\"  labelAlign=\"left\" label=\"检查单号:\" labelPosition=\"left\" style=\"width:33%;margin: 6px;margin-bottom: 2px\">\t\t\r\n");
      out.write("\t\t\t<input class=\"easyui-textbox\"  name=\"rentid\"  labelAlign=\"left\"  label=\"出租单号:\" labelPosition=\"left\" style=\"width:33%;margin: 6px;margin-bottom: 2px\">\r\n");
      out.write("\t\t\t<input class=\"easyui-textbox\"  name=\"problem\"  labelAlign=\"left\"  label=\"存在问题::\" labelPosition=\"left\" style=\"width:33%;margin: 6px;margin-bottom: 2px\">\t\t\r\n");
      out.write("\t\t\t<input class=\"easyui-datebox\"  name=\"startDate\"   labelAlign=\"left\"  label=\"开始时间:\" labelPosition=\"left\" style=\"width:33%;\">\t\t\r\n");
      out.write("\t\t\t<input class=\"easyui-datebox\"  name=\"endDate\"   labelAlign=\"left\"  label=\"结束时间:\" labelPosition=\"left\" style=\"width:33%;\">\t\r\n");
      out.write("\t\t\t<input class=\"easyui-textbox\"  name=\"checkdesc\"   labelAlign=\"left\"  label=\"问题描述:\" labelPosition=\"left\" style=\"width:33%;\">\t\r\n");
      out.write("\t\t\t<div style=\"height: 5px\"></div>\r\n");
      out.write("\t\t\t<div style=\"text-align: center;margin-bottom: 2px;\">\r\n");
      out.write("\t\t\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"doSearch()\" iconCls=\"icon-search\">查询</a>\r\n");
      out.write("\t\t\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"javascript:$('#searchFrm').form('clear')\" iconCls=\"icon-reload\">重置</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("<!-- 搜索结束-->\r\n");
      out.write("    <!-- 数据表格开始 -->\r\n");
      out.write("\t\t<table id=\"dg\" class=\"easyui-datagrid\"></table>\r\n");
      out.write("     <!-- 数据表格结束 -->\r\n");
      out.write(" \r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("    //加载表格数据\r\n");
      out.write("    $(\"#dg\").datagrid({\r\n");
      out.write("    \ttitle:'车辆检查单列表',//标题\r\n");
      out.write("\t\twidth:'100%',//宽度\r\n");
      out.write("\t\theight:'342px',//高度\r\n");
      out.write("\t\ticonCls:'icon-save',//图标\r\n");
      out.write("\t\tpagination:true,//是否打开分页\r\n");
      out.write("\t\tfitColumns:true,// 是否动分配列宽\r\n");
      out.write("\t\t//singleSelect:true,// 是否支持单行选中\r\n");
      out.write("\t\trownumbers:true,// 是否显示行号\r\n");
      out.write("\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/rent/checkList.action',//json数据地址\r\n");
      out.write("\t\t//toolbar:'#toolbar',//工具栏\r\n");
      out.write("\t    columns:[[\r\n");
      out.write("\t              {field:'checkid',title:'检查单号',width:100,align:'center'},\r\n");
      out.write("\t\t           {field:'checkdate',title:'检查日期',width:100,align:'center'},\r\n");
      out.write("\t\t           {field:'problem',title:'存在问题',width:100,align:'center'},\r\n");
      out.write("\t\t           {field:'checkdesc',title:'问题描述',width:100,align:'center'},\r\n");
      out.write("\t\t           {field:'paymoney',title:'赔付金额',width:100,align:'center'},\r\n");
      out.write("\t\t           {field:'rentid',title:'出租单号',width:100,align:'center'},\r\n");
      out.write("\t\t           {field:'opername',title:'操作员',width:100,align:'center'}\r\n");
      out.write("\t              ]],\r\n");
      out.write("    });\r\n");
      out.write("  //查询车辆信息\r\n");
      out.write("    function doSearch(){\r\n");
      out.write("    \tvar params=$(\"#searchFrm\").serialize();\r\n");
      out.write("    \t$(\"#dg\").datagrid({\r\n");
      out.write("    \t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/rent/checkList.action?'+params\r\n");
      out.write("    \t});\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
