<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Hyderabad Manpower</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>
        <link href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css" rel="stylesheet" type="text/css" />
        <script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>
        <script type="text/javascript">
            $(function() {
                $("#datepicker").datepicker({
                    autoclose: true,
                    todayHighlight: true
                }).datepicker('update', new Date());
                ;
            });

        </script>
        <script type="text/javascript">
            $(function() {
                $("#datepicker1").datepicker({
                    autoclose: true,
                    todayHighlight: true
                }).datepicker('update', new Date());
                ;
            });

        </script>
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
        <script src="js/location.js"></script>
        <script type="text/javascript">

            $(document).ready(function() {
                $('#reg_form').bootstrapValidator({
                    // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    fields: {
                        firstname: {
                            validators: {
                                stringLength: {
                                    min: 2,
                                },
                                notEmpty: {
                                    message: 'Please enter your first name'
                                }
                            }
                        },
                        lastname: {
                            validators: {
                                stringLength: {
                                    min: 2,
                                },
                                notEmpty: {
                                    message: 'Please enter your last name'
                                }
                            }
                        },
                        mobileno: {
                            validators: {
                                stringLength: {
                                    min: 10,
                                    max: 10,
                                },
                                notEmpty: {
                                    message: 'Please enter your phone number'
                                },
                                mobileno: {
                                    country: 'IND',
                                    message: 'Please enter a vaild phone number with Country code'
                                }
                            }

                        },
                        emailid: {
                            validators: {
                                notEmpty: {
                                    message: 'Please enter your email address'
                                },
                                emailAddress: {
                                    message: 'Please enter a valid email address'
                                }
                            }
                        },
                        passportno: {
                            validators: {
                                notEmpty: {
                                    message: 'Please enter your Passport No'
                                }
                            }
                        },
                        religion: {
                            validators: {
                                notEmpty: {
                                    message: 'Please enter your religion '
                                }
                            }
                        },
                        totalexp: {
                            validators: {
                                stringLength: {
                                    min: 0,
                                },
                                notEmpty: {
                                    message: 'Please enter your total exp'
                                }
                            }
                        },
                        gulfexp: {
                            validators: {
                                stringLength: {
                                    min: 0,
                                },
                                notEmpty: {
                                    message: 'Please supply your gulf exp'
                                }
                            }
                        },
                        indianexp: {
                            validators: {
                                stringLength: {
                                    min: 0,
                                },
                                notEmpty: {
                                    message: 'Please supply your indian exp'
                                }
                            }
                        },
                        address: {
                            validators: {
                                stringLength: {
                                    min: 8,
                                },
                                notEmpty: {
                                    message: 'Please supply your street address'
                                }
                            }
                        },
                        city: {
                            validators: {
                                notEmpty: {
                                    message: 'Please select your city'
                                }
                            }
                        },
                        state: {
                            validators: {
                                notEmpty: {
                                    message: 'Please select your state'
                                }
                            }
                        },
                        country: {
                            validators: {
                                notEmpty: {
                                    message: 'Please select your country'
                                }
                            }
                        },
                        password: {
                            validators: {
                                identical: {
                                    field: 'confirmPassword',
                                    message: 'Confirm your password below - type same password please'
                                }
                            }
                        },
                        confirmPassword: {
                            validators: {
                                identical: {
                                    field: 'password',
                                    message: 'The password and its confirm are not the same'
                                }
                            }
                        },
                    }
                })


                        .on('success.form.bv', function(e) {
                            $('#success_message').slideDown({opacity: "show"}, "slow") // Do something ...
                            $('#reg_form').data('bootstrapValidator').resetForm();

                            // Prevent form submission
                            e.preventDefault();

                            // Get the form instance
                            var $form = $(e.target);

                            // Get the BootstrapValidator instance
                            var bv = $form.data('bootstrapValidator');

                            // Use Ajax to submit form data
                            $.post($form.attr('action'), $form.serialize(), function(result) {
                                console.log(result);
                            }, 'json');
                        });
            });

        </script>

    </head>

    <body style="background: #eee;">
        <jsp:include page="include/header.jsp"/>
        <form class="form-horizontal" action="${pagContext.request.contextPath}/hydwebsite/add-candidate" method="post"  id="reg_form">
            <s:if test="addstatus==false">
                <div class="col-md-6 alert alert-warning fade in w3-animate-right" style="">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Registration Failed!</strong> Candidate already registered with same Passport No.
                </div>
            </s:if>
            <div class="clearfix"></div>
            <fieldset>

                <!-- Form Name -->
                <legend> Registration Form </legend>

                <!-- Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label">First Name</label>
                    <div class="col-md-4  inputGroupContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input  name="firstname" placeholder="First Name" class="form-control"  type="text">
                        </div>
                    </div>
                </div>

                <!-- Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label" >Last Name</label>
                    <div class="col-md-4  inputGroupContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="lastname" placeholder="Last Name" class="form-control"  type="text">
                        </div>
                    </div>
                </div>


                <!-- Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label">Mobile No: </label>
                    <div class="col-md-4  inputGroupContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                            <input name="mobileno" placeholder="Ex:9876543210" class="form-control" type="text">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-4" for="pwd">Gender</label>
                    <div class="col-md-4">          
                        <div class="radios">
                            <label class="radio-inline"> 
                                <input  type="radio"  value="male" name="gender"> Male
                            </label>
                            <label class="radio-inline"> 
                                <input  type="radio"  value="female" name="gender"> Female
                            </label>
                        </div>
                    </div>
                </div>
                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label">E-Mail</label>
                    <div class="col-md-4  inputGroupContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                            <input name="emailid" placeholder="E-Mail Address" class="form-control"  type="text">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-4" for="pwd">Date of Birth</label>
                    <div class="col-md-4">          
                        <div id="datepicker" class="input-group date" data-date-format="dd-mm-yyyy">
                            <input required="true" class="form-control" type="text" name="dateofbirth" readonly />
                            <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label">Passport No</label>
                    <div class="col-md-4  inputGroupContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-book"></i></span>
                            <input name="passportno" placeholder="Passport No" class="form-control" type="text">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label">Religion</label>
                    <div class="col-md-4  inputGroupContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-edit"></i></span>
                            <input name="religion" placeholder="Religion" class="form-control" type="text">
                        </div>
                    </div>
                </div>  
                <div class="form-group">
                    <label class="col-md-4 control-label">Qualification</label>
                    <div class="col-md-4 selectContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                            <select required="true" class="form-control" name="qualificationstring" >
                                <option value="">Select One</option>
                                <s:iterator value="qualificationlist" var="ql">
                                    <option value="${ql.id}">${ql.qualificationname}</option>
                                </s:iterator>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label">Designation</label>
                    <div class="col-md-4 selectContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                            <select required="true" class="form-control" name="designationstring" >
                                <option value="">Select One</option>
                                <s:iterator value="designationlist" var="dl">
                                    <option value="${dl.id}">${dl.designationame}</option>
                                </s:iterator>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label">Total Experience</label>
                    <div class="col-md-4  inputGroupContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-edit"></i></span>
                            <input name="totalexp" placeholder="Total Experience" class="form-control" type="text">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label">Gulf Experience</label>
                    <div class="col-md-4  inputGroupContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-edit"></i></span>
                            <input name="gulfexp" placeholder="Gulf Experience" class="form-control" type="text">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label">Indian Experience</label>
                    <div class="col-md-4  inputGroupContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-edit"></i></span>
                            <input name="indianexp" placeholder="Indian Experience" class="form-control" type="text">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label">Address</label>
                    <div class="col-md-4  inputGroupContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                            <input name="address" placeholder="Address" class="form-control" type="text">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4" for="pwd">Country</label>
                    <div class="col-md-4 selectContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                            <select  name="country" class="form-control input-sm countries" id="countryId">
                                <option value="">Select Country:</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-4" for="pwd">State</label>
                    <div class="col-md-4 selectContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                            <select name="state" class="form-control input-sm states" id="stateId">
                                <option value="">Select State:</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-4" for="pwd">City</label>
                    <div class="col-md-4 selectContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                            <select name="city" class="form-control input-sm cities" id="cityId">
                                <option value="">Select City</option>
                            </select>
                        </div>
                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label"></label>
                    <div class="col-md-4">
                        <a class="btn btn-primary" href="index.jsp"><span class="glyphicon glyphicon-arrow-left"></span> Back</a>
                        <button type="submit" class="btn btn-primary" >Submit <span class="glyphicon glyphicon-send"></span></button>
                    </div>
                </div>
            </fieldset>
        </form><br><br><br>
        <jsp:include page="include/footer.jsp"/>
    </body>
</html>