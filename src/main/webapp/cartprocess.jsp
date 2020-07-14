<%@page import="com.cgtcorp.project1.JSONCartUtil"%>   

<jsp:useBean id="cart" class="com.cgtcorp.project1.JSONCartUtil" scope="session"/>
<jsp:setProperty name="cart" property="jsonclnt"/>

<% cart.process();%>

<jsp:getProperty name="cart" property="jsonsrvr"/>