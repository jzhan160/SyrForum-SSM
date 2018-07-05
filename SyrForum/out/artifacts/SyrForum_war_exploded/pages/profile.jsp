<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <script src="/js/jquery.min.js"></script>
  <script src="/js/myprofile.js"></script>
  <link rel="icon" href="/images/ddd.ico">
  <link rel="stylesheet" href="/style/myprofile.css">
  <title>My Profile</title>
</head>
<script>
    function onClick() {
        document.getElementById("messageClick").action ="/notification?username=${user.userName}";
        ;
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
          <li class="user_console"><img src="/images/user.svg" >
            <ul>
              <li><a href="/user/profile?username=${user.userName}">My Profile</a></li>
              <li><a href="/showFavorite?username=${user.userName}">My Favorites</a></li>
              <li><a href="/logout">Log Out</a></li>
            </ul>
          </li>
          <li class="user_console">
            <div class="notification_button">
              <form class="button" id="messageClick" action="#"
                    method="post">
                <img src="/images/notifications-bell-button.svg" id="messages" onclick="onClick()"/>
              </form>
            </div>
          </li>

          <li class="user_console"><img src="/images/magnifier.svg" >
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
    <!-- <div class="clearfix"></div > -->

    <section>
      <div class="profile_frame">
        <div class="containner">
          <div class="profile">
            <!-- profile section -->
            <img id="profileImage" src="/images/sampleprofile.jpg" alt="myprofile">
            <input type="button" id="editProfileBtn" value="Edit profile image" name="edit_profile">
            <a href="/editPassword?username=${user.userName}"><input type="button" id="editPasswordBtn" value="Edit password" name="edit_password"></a>
          </div>

          <!--personal info <section>

          </section>  -->
          <div class="personal_info">
            <div>
              <p><b>Personal Info:</b></p>
            </div>
            <div>
              <p>Username:</p><span>${user.userName}</span>
            </div>
            <div>
              <p>Joined:</p><span>${user.createTime}</span>
            </div>
            <div>
              <p>Born:</p><span>${user.userBirthday}</span>
            </div>
            <div>
              <p>Email:</p><span>${user.email}</span>
            </div>
          </div>

          <!-- recent posts section -->
          <div class="recent_posts">
            <p><b>Recent Posts:</b></p>

              <c:forEach items="${itemsInfo}" var="temp">
                  <div>
                      <p>${temp.getItem().getItemName()}</p>
                      <a  href="/item?username=${user.userName}&itemId=${temp.getItem().getItemID()}"
                         name="recent_post1">Open</a>
                      <a href="/deleteItem?username=${user.userName}&itemId=${temp.getItem().getItemID()}">Delete</a>
                  </div>
              </c:forEach>
          </div>
        </div>
      </div>
    </section>

    <!-- hidden popup window -->
    <div id="interface">
      <p>Select your profile image:</p>
      <div>
        <img class="profileselection" src="/images/profile1.jpg">
        <img class="profileselection" src="/images/profile2.jpg">
        <img class="profileselection" src="/images/profile3.jpg">
        <img class="profileselection" src="/images/profile4.jpg">
        <img class="profileselection" src="/images/profile5.jpg">
        <img class="profileselection" src="/images/profile6.jpg">
      </div>
      <div>
        <input type="radio"  name="profile" value="1" checked>
        <input type="radio"  name="profile" value="2">
        <input type="radio"  name="profile" value="3">
        <input type="radio"  name="profile" value="4">
        <input type="radio"  name="profile" value="5">
        <input type="radio"  name="profile" value="6">
      </div>

      <input type="button" value="Cancel">
      <input type="button" value="Select">


    </div>

    <!-- <div class="clearfix"></div > -->
    <footer>
      <p>Copyright (c) 2018 Copyright Holder All Rights Reserved.</p>
    </footer>
  </div>
  </body>
  </html>
