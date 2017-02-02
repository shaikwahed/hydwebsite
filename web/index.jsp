<%-- 
    Document   : index
    Created on : Jan 30, 2017, 12:49:23 PM
    Author     : Shaik Wahed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hyderabad Manpower</title>
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    </head> 
    <body style="background: #00B4CC">
        <jsp:include page="include/header.jsp"/>
        <div class="col-md-offset-1 container" style="color:#fff;font-weight: bold;">
            <h3 >Welcome To Hyderabad Manpower Registration</h3>
            <h5><span class="glyphicon glyphicon-chevron-right"></span> Please note Your Applicant ID for future reference</h5>
            <h5><span class="glyphicon glyphicon-chevron-right"></span> Please provide accurate details</h5>
            <h5><span class="glyphicon glyphicon-chevron-right"></span> Passport No is mandatory for registration</h5>
            <h5><span class="glyphicon glyphicon-chevron-right"></span> Please mail your Updated CV,Educational Certiificates,Experience Letter, Certifications if any along with Passport Size Photograph (ignore this if already mailed) <br><br> at <b>gulf@hydmanpower.com</b> </h5>
            <a class="btn btn-primary" href="${pagContext.request.contextPath}/hydwebsite/to-index"><span class="glyphicon glyphicon-play"></span> Begin</a>
        </div>
        <jsp:include page="include/footer.jsp"/>
    </body>
</html>
