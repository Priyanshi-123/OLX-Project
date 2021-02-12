<%-- 
    Document   : register
    Created on : 11 Feb, 2021, 12:20:28 AM
    Author     : HP
--%>

<%@page import="mysite.DbConnector"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String bvid=request.getParameter("bvid");
            String sname=request.getParameter("sname");
            String course=request.getParameter("course");
            String eid=request.getParameter("emailid");
            String p=request.getParameter("password");
            DbConnector obj=new DbConnector();
            PreparedStatement ps=obj.c.prepareStatement("insert into seller values(?,?,?,?,?)");
            ps.setString(1, sname);
            ps.setString(2, bvid);
            ps.setString(3, p);
            ps.setString(4, course);
            ps.setString(5, eid);
            int i=ps.executeUpdate();
            if(i==1)
                out.println("Welcome "+sname);
            else
                response.sendRedirect("error.jsp");
        %>
    </body>
</html>
