<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Main page</title>
    <style>
        *
        {
            margin: auto;
        }
      .banner {
        background-image: url("https://www.southindiaeshop.com/pub/media/wysiwyg/Mens_wear.jpg");
        color: rgb(222, 217, 235);
        text-align: center;
        font-size: 290%;
        font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;   
        background-position: bottom;
        background-size: cover;
      }
      .homescreen {
        background-image: url("https://cms.bigbazaarstore.com/cms/model/Fa2/H7b/TOOe/Mobil2copy.jpg");
        padding: 19%;
        padding-left: 24%;
        padding-top: 12%;
        padding-bottom: 27%;
        background-size: cover;
      }
      .foot-imgs {
        padding-left: 8%;
      }
      .footer-text11 {
        display: flex;
        justify-content: space-between;
        margin: 0%;
      }
      .footer-text12 {
        display: flex;
        margin-left: 10px;
      }
      .lang-btn22 {
        text-decoration: none;
        font-size: 100%;
        color: currentcolor;
      }
      .ab {
        padding-top: 1%;
      }
      .footer-imges1 {
        display: flex;
      }
      .hr-link-1 {
        margin-top: 2%;
      }
      .butns
      {
          padding: 1%;
          color: white;
          background-color: blueviolet;
      }
    </style>
  </head>
  <body>
  
  <script type="text/javascript">
  	${message}
  </script>
    <div class="banner">
        <h1>
            Exclusive sales
        </h1>     
    </div>
<!-- buttons -->
<div class="homescreen">
    <a href="lform"><button class = 'butns'>Login</button></a>
    <a href="new_user"><button class = 'butns'>Register </button></a>
</div>
    <!-- footer -->
    <hr class="hr-link-1" />
    <br />
    <div class="footer-text11">
      <div class="footer-text12">
        <div class="footer-text12 ab">
          <a>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              viewBox="0 0 50 50"
              style="width: 20px"
            >
              <path
                d="M50 23.8c-0.2-3.3-1-6.5-2.4-9.5l0 0C43.7 5.9 35.4 0.4 26.2 0h-2.4C14.6 0.4 6.3 5.9 2.4 14.3l0 0c-1.4 3-2.2 6.2-2.4 9.5l0 0v2.4l0 0c0.2 3.3 1 6.5 2.4 9.5l0 0c4 8.4 12.2 13.9 21.4 14.3h2.4c9.2-0.4 17.5-5.9 21.4-14.3l0 0c1.4-3 2.2-6.2 2.4-9.5l0 0V23.8zM47.6 23.8h-9.5c0-3.2-0.4-6.4-1.2-9.5H45C46.6 17.2 47.5 20.5 47.6 23.8zM33.6 11.9h-7.4V2.6C29.3 3.3 31.9 7.1 33.6 11.9zM23.8 2.6v9.3h-7.4C18.1 7.1 20.7 3.3 23.8 2.6zM23.8 14.3v9.5h-9.5c0.1-3.2 0.6-6.4 1.4-9.5H23.8zM23.8 26.2v9.5h-8.1c-0.8-3.1-1.3-6.3-1.4-9.5H23.8zM23.8 38.1v9.3c-3.1-0.7-5.7-4.5-7.4-9.3H23.8zM26.2 47.4v-9.3h7.4C31.9 42.9 29.3 46.7 26.2 47.4zM26.2 35.7v-9.5h9.5c-0.1 3.2-0.6 6.4-1.4 9.5H26.2zM26.2 23.8v-9.5h8.1c0.8 3.1 1.3 6.3 1.4 9.5H26.2zM43.3 11.9h-7.1c-0.9-3.1-2.4-6.1-4.5-8.6C36.4 4.8 40.5 7.8 43.3 11.9zM18.6 3.3c-2.2 2.5-3.8 5.4-4.8 8.6H6.7C9.6 7.8 13.8 4.8 18.6 3.3zM5 14.3h8.1c-0.7 3.1-1.1 6.3-1.2 9.5H2.4C2.5 20.5 3.4 17.2 5 14.3zM2.4 26.2h9.5c0 3.2 0.4 6.4 1.2 9.5H5C3.4 32.8 2.5 29.5 2.4 26.2zM6.4 38.1h7.4c0.9 3.1 2.4 6.1 4.5 8.6 -4.7-1.5-8.8-4.5-11.7-8.6H6.4zM31.4 46.7c2.2-2.5 3.8-5.4 4.8-8.6h7.4C40.6 42.2 36.3 45.3 31.4 46.7zM45 35.7h-8.1c0.7-3.1 1.1-6.3 1.2-9.5h9.5C47.5 29.5 46.6 32.8 45 35.7z"
              ></path></svg></a>
          <a href="/" class="lang-btn22">change language</a>
        </div>
        <div class="footer-imges1">
          <img
            alt="Adobe on Facebook"
            src="https://www.adobe.com/content/dam/cc/icons/social-icon-facebook.svg"
            width="20px"
            class="foot-imgs"
          />
          <img
            alt="Adobe on Twitter"
            src="https://www.adobe.com/content/dam/cc/icons/social-icon-twitter.svg"
            width="20px"
            class="foot-imgs"
          />
          <img
            alt="Adobe on LinkedIn"
            src="https://www.adobe.com/content/dam/cc/icons/social-icon-linkedin.svg"
            width="20px"
            class="foot-imgs"
          />
          <img
            alt="Adobe on Instagram"
            src="https://www.adobe.com/content/dam/cc/icons/social-icon-instagram.svg"
            width="20px"
            class="foot-imgs"
          />
        </div>
      </div>
      <div>
        <p class="footer-text11">
          Copyright ? 2022 Yogesh. All rights reserved./Privacy /Terms of Use
          /Cookie preferences /Do not sell my personal information / AdChoices
        </p>
      </div>
    </div>
    <br/>
  </body>
</html>
