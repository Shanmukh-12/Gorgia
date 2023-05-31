<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ page import="jdbc.model.Employee,java.util.*" %>
<!DOCTYPE html>
<html style="height: 314px; ">
<head>
<style>
TABLE{
display:flex;
align:center;
justify:center;
min-height:100vh;
width:100%;
margin:10px;

}</style>
<meta charset="UTF-8">
<title>Employees List through Spring JDBC Template</title>
</head>
 <BODY BGCOLOR="yellow">
      <H1>Employees List through Spring JDBC Template </H1>
       
      <TABLE BORDER="1">
      <TR>
      <TH>Emp No</TH>
      <TH>Name</TH>
      <TH>Job</TH>
      <TH>Salary</TH>
      <TH>Dept No</TH>
      </TR>
      <% 
      	
        List<Employee> elist=(List<Employee>)request.getAttribute("elist");
		for(Employee e:elist){
	  %>
      	<TR>
       		  <TD> <%= e.getEmpNo() %></td>
     		  <TD style="width: 166px; "> <%= e.getEName() %></TD>
      		  <TD style="width: 218px; "> <%= e.getJob() %></TD>
     		  <TD style="height: 49px; "> <%= e.getSalary() %></TD>
     		  <TD style="width: 79px; "> <%= e.getDeptNo() %></TD>
      </TR>
      <% 
      	} 
      %>
     </TABLE>
     <input type="submit" name="add" value="Add" onclick="newemp">
     </BODY>
</html>