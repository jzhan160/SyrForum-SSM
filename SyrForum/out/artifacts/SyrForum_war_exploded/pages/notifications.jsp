<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <script src="/js/jquery-3.3.1.js"></script>
  <script src="/js/message.js"></script>
  <link rel="icon" href="/images/ddd.ico">
  <link rel="stylesheet" href="/style/message.css">
  <title>Messages</title>
</head>

<script>
    function onClick() {
        document.getElementById("messageClick").action ="/notification?username=${user.userName}";
        document.getElementById("messageClick").submit();
    }
</script>

<body>
    <!-- title and header background -->
      <header>
        <div>
          <h1>Syracuse Forum</h1>
          <h2>An Online Community of Second Hand Market</h2>
        </div>
      </header>

    <!-- navigation part -->
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
            <%--  <li><a href="message.jsp">Message Box</a>--%>
            </li>
            <li class="userconsole"><img src="/images/user.svg" >
              <ul>
                  <ul>
                      <li><a href="/user/profile?username=${user.userName}">My Profile</a></li>
                      <li><a href="/showFavorite?username=${user.userName}">My Favorites</a></li>
                      <li><a href="/logout">Log Out</a></li>
                  </ul>
              </ul>
            </li>
            <!-- <li class="userconsole"><img src="img/notifications-bell-button.svg" ></li> -->
            <li class="userconsole">

              	<div class="button">
                <form class="button" id="messageClick" action="#"
                      method="post">
                    <img src="/images/notifications-bell-button.svg" id="messages" onclick="onClick()"/>
                </form>
            </div>
              </a>
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
      <section class="message">

          <div class="message_section">
              <p>My Message Box</p>
          <%--<ul>
          <li id="comments_iframe"><a >Comments</a></li>
          <li id="messages_iframe"><a >Messages</a></li>
          </ul>--%>
          </div>
          <div class="message_content">

                  <div class="title_line">
                      <p>Comments received:</p>
                  </div>

                  <c:if test="${empty messages}">
                      <h1>No new message!</h1>

                  </c:if>

                  <c:forEach items="${messages}" var="message">

                      <div class=message_wraper>
                          <!-- link to the post -->
                                          <a  href="/item&itemId=${message.itemId}&username=${user.userName}}"
                                              name="recent_post1"></a>
                          <div class="comments_received">
                              <div class="profile_img">
                                  <img src="/images/profile1.jpg" />
                              </div>
                              <div class="sender_info">
                                  <p>${message.notification.author}</p>
                                  <p>${message.createTime}</p>
                              </div>
                              <div class="content_box">
                                  <p class="commnet_content">${message.commentContent}</p>
                                  <p class="original_post">Item: ${message.itemName}</p>
                              </div>
                          </div>
                      </div>
                  </c:forEach>

          </div>


      </section>
      <div class="clearfix"></div >


  <footer>
    <p>Copyright (c) 2018 Copyright Holder All Rights Reserved.</p>
  </footer>

</body>
</html>
