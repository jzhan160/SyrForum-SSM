<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width">
        <script src="/js/jquery-3.3.1.js"></script>
        <script src="/js/newpost.js"></script>
        <link rel="stylesheet" href="/style/styles1.css">
        <link rel="stylesheet" type="text/css" href="/style/common.css" />
        <title>Create New Post</title>
    </head>
    <script>
        function onClick() {
            document.getElementById("messageClick").action = "/notification?username=${user.userName}";
            document.getElementById("messageClick").submit();
        }
    </script>
    <body>
        <header>
            <div>
                <h1>Syracuse Forum</h1>
                <h2>An Online Community of Second Hand Market</h2>
            </div>
        </header>
    
        <section class="navi">
            <div class="nav-bar">
                <ul class="nav-menu">
                    <li><a href="/home?username=${user.userName}"
                           class="active">Home</a></li>
                    <li><a href="">Section</a>
                        <ul>
                            <li><a href="/topics?username=${user.userName}&category=books">Used Books</a></li>
                            <li><a href="/topics?username=${user.userName}&category=cars">Used Cars</a></li>
                            <li><a href="/topics?username=${user.userName}&category=furniture">Used Furniture</a></li>
                        </ul>
                    </li>
                    </li>
                    <li class="userconsole"><img src="/images/user.svg" >
                        <ul>
                            <li><a href="/user/profile?username=${user.userName}">My Profile</a></li>
                            <li><a href="/showFavorite?username=${user.userName}">My Favorites</a></li>
                            <li><a href="/logout">Log Out</a></li>
                        </ul>
                    </li>
                    <li class="userconsole"><form class="button" id="messageClick" action="#"
                                                  method="post">
                        <img src="/images/notifications-bell-button.svg" id="messages" onclick="onClick()"/>
                    </form></li>


                </ul>
            </div>
        </section>

        <section class="userinput">

              <form action="/postSubmit?username=${user.userName}" enctype="multipart/form-data" method="post">
                <div>
                    <span>Title</span>
                    <input type="text" name="Title">
                    <span>Address</span>
                    <input type="text" name="Address">
                    <span>Contact</span>
                    <input type="text" name="Contact">
                </div>
                <div id="plus">
                    <Button type="button" id="plusitem" >+</Button>
                    <label for="plusitem">Add a new Item.</label>
                </div>

                <div class="buttons">
                    <input type="submit" id = "submitbtn" value="Submit" >
                    <input action="action" type="Button" id = "calcenlbtn" value="Cancel" onclick="window.history.go(-1); return false;" />
                </div >
            </form>
        </section>

        <footer>
	        <p>Zhihui Hong Design <span>|</span>
    		    <a target="_blank" href="http://www.syr.edu/" rel="nofollow">SU Home Page</a>
    	    </p>
        </footer>
	    
    </body>
</html>
