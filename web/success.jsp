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
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    </head>
    <body>
        <s:if test="addstatus==true">
            <div class="col-md-3 alert alert-success fade in w3-animate-right" style="">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Registered Successfully !</strong> 
            </div>
        </s:if>
        <div class="col-md-offset-5 col-md-2">
            <a class="btn btn-success" href="http://hyderabadmanpower.com/">Go To Home Page</a>
        </div>
    </body>
</html>
