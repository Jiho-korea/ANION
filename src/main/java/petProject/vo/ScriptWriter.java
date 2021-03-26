/*
========================================================================
파    일    명 : ScriptWriter.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.03.20
작  성  내  용 : Alert창을 띄우기 위한 메서드 선언
========================================================================
*/
package petProject.vo;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScriptWriter {

	public static boolean write(String message, String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('" + message + "');");
		out.println("location.href='" + request.getContextPath() + "/" + path + "';");
		out.println("</script>");
		out.flush();
		
		return false;
	}
	
	public static boolean write(String message, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('" + message + "');");
		out.println("</script>");
		out.flush();
		
		return false;
	}
}
