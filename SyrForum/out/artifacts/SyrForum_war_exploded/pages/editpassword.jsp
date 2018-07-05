<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
  <script src="${pageContext.request.contextPath}/js/edit_password.js"></script>
  <link rel="shortcut icon" href="">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style/newpost.css">
  <title>Edit Personal Profile</title>
</head>
<script>
    function onClick() {
        document.getElementById("messageClick").action = "/notification?username=${user.userName}";
        document.getElementById("messageClick").submit();
    }
</script>

<body>
  <div class="frame">
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
          <li class="userconsole"><img src="${pageContext.request.contextPath }/images/user.svg" >
            <ul>
              <li><a href="/user/profile?username=${user.userName}">My Profile</a></li>
              <li><a href="/showFavorite?username=${user.userName}">My Favorites</a></li>
              <li><a href="/logout">Log Out</a></li>
            </ul>
          </li>
          <!-- <li class="userconsole"><img src="img/notifications-bell-button.svg" ></li> -->
          <li class="userconsole">
            <div class="notification_button">
              <form class="button" id="messageClick" action="#"
                    method="post">
                <img src="/images/notifications-bell-button.svg" id="messages" onclick="onClick()"/>
              </form>
            </div>
          </li>
          <li class="userconsole"><img src="/images/magnifier.svg" >
            <ul>
              <li>
                    <div class="w_search">
                      <form class="w_searchbox" method="post" action="/search?username=${user.userName}">
                        <input type="text" placeholder="search" name="keyword"/>
                        <button type="submit">Search</button>
                      </form>
                    </div>
              </li>
          </ul>
          </li>
        </ul>
      </div>
    </section>

    <section class="edit_password">
      <form id="pw_form" action="/changePassword?username=${user.userName}" method = "post">
        <div>

          <div>
            <span>New password:</span>
            <input type="password" name="password" >

          </div>
          <div>
          <span></span>
          <span id="first_warning" >Please provide your password.</span>
        </div>
          <div>
            <span>Retype new password:</span>
            <input type="password" name="retypepwd" >

            </div>
            <div>
              <span></span>
              <span id="second_warning" >Please confirm your password.</span>
            </div>
          </div>

          <div class="buttons">
            <input type="submit" id = "submitbtn" value="Submit" >
            <input type="button" id = "calcenlbtn" value="Cancel">
          </a>
          </div >
        </form>
      </section>


      <footer>
        <p>Copyright (c) 2018 Copyright Holder All Rights Reserved.</p>
      </footer>
    </div>
  </body>
  </html>