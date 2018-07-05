<%--
////////////////////////////////////////////////////////////////////
// login.jsp   login page page for this website                   //
// ver 1.0                                                        //
// Author: Group Work                                             //
////////////////////////////////////////////////////////////////////
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/style/styles.css">
    <script src="/js/jquery.min.js"></script>

    <script
            src="/js/bootstrap.min.js"></script>
</head>
<body>
<div id="login_frame">
    <h1>Syracuse Forum </h1>

    <!------------------------- Login Form --------------------------->

    <div>
        <button name = "login_button" onclick="document.getElementById('LogIn').style.display='block'" style="width:200px;">Login</button>
    </div>

    <div id="LogIn" class="login_modal">
        <form id ="login_form" class="login_modal-content login_animate"
              action="/user/login" method="post">
            <div class="login_imgcontainer">
                <span onclick="document.getElementById('LogIn').style.display='none'" class="login_close"
                      title="Close Modal">&times;</span>
            </div>

            <div class="login_container">
                <div class="form-group">
                    <div id="loginInfo"></div>
                </div>
                <label><b>Username</b></label>
                <input type="login_text" placeholder="Enter Username" id = "userName" name="username" required>

                <label><b>Password</b></label>
                <input type="password" placeholder="Enter Password" id = "userPassword" name="userPassword" required>
                <span class="login_psw">Forgot <a href="#">password?</a></span>
                <label>
                    <input type="checkbox" checked="checked" name="remember"> Remember me
                </label>

                <div class="login_container">
                    <%--id of button cannot be submit, otherwise it will conflict with submissoion of form--%>
                    <button id="submitBtn" type="button" onclick="validatePassword()" class="login_subbtn">Login</button>
                    <button type="button" onclick="document.getElementById('LogIn').style.display='none'"
                            class="login_cancelbtn">Cancel
                    </button>
                </div>
            </div>
        </form>
    </div>

    <script type="text/javascript">
        // Get the modal
        var modal = document.getElementById('LogIn');

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function (event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }

        function validatePassword() {
            var username = $("#userName").val();
            var password = $("#userPassword").val();
           /* if (username == "") {
                $("#loginInfo").html(
                    "<b style='color:red;font-size:15px;'>The user name cannot be null!</b>");
                $("#userName").focus();
                return;
            }
            if (password == "") {
                $("#loginInfo").html(
                    "<b style='color:red;font-size:15px;'>The password cannot be null!</b>");
                $("#password").focus();
                return;
            }*/
            $
                .ajax({
                    type: "GET",
                    url: "validatePassword",
                    data: {
                        "username": username
                    },
                    async: true,
                    success: function (data) {
                        if (password == data) {
                         /*   $("#loginInfo")
                                .html(
                                    "<b style='color:red;font-size:15px;'>The user name or password is correct!</b>");*/

                            $("#login_form").submit();
                        } else {
                            $("#loginInfo")
                                .html(
                                    "<b style='color:red;font-size:15px;'>The user name or password is wrong!</b>");
                        }
                    }
                })
        }

      /*  /!* Enter提交 *!/
        $(document).ready(
            function () {
                $("body").keydown(
                    function (e) {
                        var curKey = e.which;
                        if (curKey == 13) {
                            /!* 这里一定不能为“sunbmit”详情见官方api文档 *!/
                            $("#submit").click();
                            return false;
                        }
                    });
            });*/
    </script>


    <!--------------------- Signup Form ------------------------------>
    <div style="text-align:center;">
        <button onclick="document.getElementById('SignUp').style.display='block'" style="width:200px;">Sign Up</button>
    </div>
    <div id="SignUp" class="login_modal">
        <form class="login_modal-content login_animate" id="regForm"
              action="/user/register" method="post">
            <div class="signup_imgcontainer">
                <span onclick="document.getElementById('SignUp').style.display='none'" class="signup_close" title="Close Modal">&times;</span>
            </div>
        <div class="login_container ">
            <div class="form-group">
                <div id="spanUsername"></div>
            </div>
            <label><b>UserName</b></label>
            <input type="signup_text" placeholder="Enter UserName: only letters and numbers" onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9]/g,'')" 
            onpaste="value=value.replace(/[^\a-\z\A-\Z0-9]/g,'')"
                   oncontextmenu="value=value.replace(/[^\a-\z\A-\Z0-9]/g,'')" name="userName" id="newUserName" required>

            <label><b>Email</b></label>
            <input type="signup_text" placeholder="Enter Email" name="email" required>

            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="userPassword" required>

            <label><b>Repeat Password</b></label>
            <input type="password" placeholder="Repeat Password" name="psw-repeat" required>
            <label><b>Gender</b></label> <br />
			<select id="gender" name="gender" required>
			<option>Select one</option> 
			<option>Male</option>
			<option>Female</option>
			<option>Not specified</option>
			</select>

            <div>
         <%--   <label>
                <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
            </label>--%>
            </div>

            <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

            <div class="signup_clearfix">
                <button type="button" id="regBtn" class="signup_signupbtn" onclick="validateUsername()">Sign Up</button>
                <button type="button" onclick="document.getElementById('SignUp').style.display='none'"
                        class="signup_cancelbtn">Cancel
                </button>

            </div>
        </div>
        </form>
    </div>
    <script>
        // Get the modal
        var modal = document.getElementById('SignUp');
        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function (event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }

        function validateUsername() {
            var username = $("#newUserName").val();
            $.ajax({
                type : "GET",
                url : "/user/checkUser",
                data: {
                    "username": username
                },
                async : true,
                success : function(res) {
                    if (res == "true") {
                        $("#spanUsername")
                            .html(
                                "<b style='color:red;font-size:15px;margin:5px auto;text-align:left'>The user name has already existed！</b>");
                        $("#userName").focus();
                    } else {
                        $("#spanUsername")
                            .html(
                                "<div class='glyphicon glyphicon-ok' style='float:left'></div>");
                        $("#regForm").submit();
                    }
                }
            })
        }
    </script>

</div>

</body>
</html>
