package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Juego_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_s_hidden_value_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_s_textarea_value_id_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_s_hidden_value_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_s_textarea_value_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_s_hidden_value_id_nobody.release();
    _jspx_tagPool_s_textarea_value_id_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("      \n");
      out.write("        <style>\n");
      out.write("        canvas {\n");
      out.write("            border:1px solid black;\n");
      out.write("        }\n");
      out.write("        </style>\n");
      out.write("        <script src=\"fabric.js\"></script>\n");
      out.write("        <script src=\"Juego.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <input type=\"text\" value=\"0\" id=\"Cont\">\n");
      out.write("        <input type=\"text\" value=\"0\" id=\"Cont2\">\n");
      out.write("        <input type=\"text\" value=\"0\" id=\"Cont3\">\n");
      out.write("        \n");
      out.write("        <canvas id=\"c\" width=\"600\" height=\"400\" >\n");
      out.write("            \n");
      out.write("        </canvas>\n");
      out.write("        ");
      if (_jspx_meth_s_textarea_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        \n");
      out.write("        This shit es de la base y la determina el profe\n");
      out.write("       \n");
      out.write("        los value de lo seleccionado son el dato 1\n");
      out.write("        ");
      if (_jspx_meth_s_hidden_0(_jspx_page_context))
        return;
      out.write(" unidades\n");
      out.write("        ");
      if (_jspx_meth_s_hidden_1(_jspx_page_context))
        return;
      out.write(" x\n");
      out.write("        ");
      if (_jspx_meth_s_hidden_2(_jspx_page_context))
        return;
      out.write(" x^2\n");
      out.write("        ");
      if (_jspx_meth_s_hidden_3(_jspx_page_context))
        return;
      out.write("misma mierda\n");
      out.write("        ");
      if (_jspx_meth_s_hidden_4(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_s_hidden_5(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        Aqui terminan las que se necesitan para solve \n");
      out.write("        Faltan aun por las otras interfaces\n");
      out.write("     \n");
      out.write("        <button onclick=\"inicio.serializa()\"></button>\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            var canvas = this.__canvas = new fabric.Canvas('c');\n");
      out.write("          fabric.Object.prototype.transparentCorners = false;\n");
      out.write("            inicio(canvas);\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_s_textarea_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:textarea
    org.apache.struts2.views.jsp.ui.TextareaTag _jspx_th_s_textarea_0 = (org.apache.struts2.views.jsp.ui.TextareaTag) _jspx_tagPool_s_textarea_value_id_nobody.get(org.apache.struts2.views.jsp.ui.TextareaTag.class);
    _jspx_th_s_textarea_0.setPageContext(_jspx_page_context);
    _jspx_th_s_textarea_0.setParent(null);
    _jspx_th_s_textarea_0.setId("log");
    _jspx_th_s_textarea_0.setValue("");
    int _jspx_eval_s_textarea_0 = _jspx_th_s_textarea_0.doStartTag();
    if (_jspx_th_s_textarea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_textarea_value_id_nobody.reuse(_jspx_th_s_textarea_0);
      return true;
    }
    _jspx_tagPool_s_textarea_value_id_nobody.reuse(_jspx_th_s_textarea_0);
    return false;
  }

  private boolean _jspx_meth_s_hidden_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:hidden
    org.apache.struts2.views.jsp.ui.HiddenTag _jspx_th_s_hidden_0 = (org.apache.struts2.views.jsp.ui.HiddenTag) _jspx_tagPool_s_hidden_value_id_nobody.get(org.apache.struts2.views.jsp.ui.HiddenTag.class);
    _jspx_th_s_hidden_0.setPageContext(_jspx_page_context);
    _jspx_th_s_hidden_0.setParent(null);
    _jspx_th_s_hidden_0.setId("SolveIz1");
    _jspx_th_s_hidden_0.setValue("1");
    int _jspx_eval_s_hidden_0 = _jspx_th_s_hidden_0.doStartTag();
    if (_jspx_th_s_hidden_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_hidden_value_id_nobody.reuse(_jspx_th_s_hidden_0);
      return true;
    }
    _jspx_tagPool_s_hidden_value_id_nobody.reuse(_jspx_th_s_hidden_0);
    return false;
  }

  private boolean _jspx_meth_s_hidden_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:hidden
    org.apache.struts2.views.jsp.ui.HiddenTag _jspx_th_s_hidden_1 = (org.apache.struts2.views.jsp.ui.HiddenTag) _jspx_tagPool_s_hidden_value_id_nobody.get(org.apache.struts2.views.jsp.ui.HiddenTag.class);
    _jspx_th_s_hidden_1.setPageContext(_jspx_page_context);
    _jspx_th_s_hidden_1.setParent(null);
    _jspx_th_s_hidden_1.setId("SolveIz2");
    _jspx_th_s_hidden_1.setValue("2");
    int _jspx_eval_s_hidden_1 = _jspx_th_s_hidden_1.doStartTag();
    if (_jspx_th_s_hidden_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_hidden_value_id_nobody.reuse(_jspx_th_s_hidden_1);
      return true;
    }
    _jspx_tagPool_s_hidden_value_id_nobody.reuse(_jspx_th_s_hidden_1);
    return false;
  }

  private boolean _jspx_meth_s_hidden_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:hidden
    org.apache.struts2.views.jsp.ui.HiddenTag _jspx_th_s_hidden_2 = (org.apache.struts2.views.jsp.ui.HiddenTag) _jspx_tagPool_s_hidden_value_id_nobody.get(org.apache.struts2.views.jsp.ui.HiddenTag.class);
    _jspx_th_s_hidden_2.setPageContext(_jspx_page_context);
    _jspx_th_s_hidden_2.setParent(null);
    _jspx_th_s_hidden_2.setId("SolveIz3");
    _jspx_th_s_hidden_2.setValue("3");
    int _jspx_eval_s_hidden_2 = _jspx_th_s_hidden_2.doStartTag();
    if (_jspx_th_s_hidden_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_hidden_value_id_nobody.reuse(_jspx_th_s_hidden_2);
      return true;
    }
    _jspx_tagPool_s_hidden_value_id_nobody.reuse(_jspx_th_s_hidden_2);
    return false;
  }

  private boolean _jspx_meth_s_hidden_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:hidden
    org.apache.struts2.views.jsp.ui.HiddenTag _jspx_th_s_hidden_3 = (org.apache.struts2.views.jsp.ui.HiddenTag) _jspx_tagPool_s_hidden_value_id_nobody.get(org.apache.struts2.views.jsp.ui.HiddenTag.class);
    _jspx_th_s_hidden_3.setPageContext(_jspx_page_context);
    _jspx_th_s_hidden_3.setParent(null);
    _jspx_th_s_hidden_3.setId("SolveDer1");
    _jspx_th_s_hidden_3.setValue("1");
    int _jspx_eval_s_hidden_3 = _jspx_th_s_hidden_3.doStartTag();
    if (_jspx_th_s_hidden_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_hidden_value_id_nobody.reuse(_jspx_th_s_hidden_3);
      return true;
    }
    _jspx_tagPool_s_hidden_value_id_nobody.reuse(_jspx_th_s_hidden_3);
    return false;
  }

  private boolean _jspx_meth_s_hidden_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:hidden
    org.apache.struts2.views.jsp.ui.HiddenTag _jspx_th_s_hidden_4 = (org.apache.struts2.views.jsp.ui.HiddenTag) _jspx_tagPool_s_hidden_value_id_nobody.get(org.apache.struts2.views.jsp.ui.HiddenTag.class);
    _jspx_th_s_hidden_4.setPageContext(_jspx_page_context);
    _jspx_th_s_hidden_4.setParent(null);
    _jspx_th_s_hidden_4.setId("SolveDer2");
    _jspx_th_s_hidden_4.setValue("2");
    int _jspx_eval_s_hidden_4 = _jspx_th_s_hidden_4.doStartTag();
    if (_jspx_th_s_hidden_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_hidden_value_id_nobody.reuse(_jspx_th_s_hidden_4);
      return true;
    }
    _jspx_tagPool_s_hidden_value_id_nobody.reuse(_jspx_th_s_hidden_4);
    return false;
  }

  private boolean _jspx_meth_s_hidden_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:hidden
    org.apache.struts2.views.jsp.ui.HiddenTag _jspx_th_s_hidden_5 = (org.apache.struts2.views.jsp.ui.HiddenTag) _jspx_tagPool_s_hidden_value_id_nobody.get(org.apache.struts2.views.jsp.ui.HiddenTag.class);
    _jspx_th_s_hidden_5.setPageContext(_jspx_page_context);
    _jspx_th_s_hidden_5.setParent(null);
    _jspx_th_s_hidden_5.setId("SolveDer3");
    _jspx_th_s_hidden_5.setValue("3");
    int _jspx_eval_s_hidden_5 = _jspx_th_s_hidden_5.doStartTag();
    if (_jspx_th_s_hidden_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_hidden_value_id_nobody.reuse(_jspx_th_s_hidden_5);
      return true;
    }
    _jspx_tagPool_s_hidden_value_id_nobody.reuse(_jspx_th_s_hidden_5);
    return false;
  }
}
