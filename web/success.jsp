<%-- 
    Document   : success
    Created on : Jan 30, 2017, 12:11:47 PM
    Author     : Shaik Wahed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hyderabad Manpower</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    </head>
    <body style="background: #00B4CC">
        <jsp:include page="include/header.jsp"/>
        <s:if test="addstatus==true">
            <div class="col-md-3 col-md-offset-5 alert alert-success fade in w3-animate-right" style="">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Registered Successfully !</strong> 
            </div>
        </s:if>
        <div class="clearfix"></div>
        <div class="col-md-offset-5 col-md-2">
            <a class="btn btn-primary" href="http://hyderabadmanpower.com/">Go To Website</a>
        </div>
        <jsp:include page="include/footer.jsp"/>
    </body>
</html>
