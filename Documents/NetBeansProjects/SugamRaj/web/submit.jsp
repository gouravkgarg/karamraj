<!DOCTYPE html>

<html>

  <head> 
  <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
   <title>Application Received</title>
   <style>
     body {
  margin: 0 0;
  font-family: 'Raleway';
  background-color: #E0F7FA;
  color: #006064;
}
form  { 
    display: table;
    box-shadow: 0 5px 25px 0 rgba(0, 0, 0, 0.4);
    padding: 30px;
    margin: 0 auto;
    margin-bottom: 40px;
    transition: 2s ease all;
}
p     { display: table-row;  }
label, input, select, button, form p span  { display: table-cell; }
button {
  margin-left: 55%;
  width: 200px;
  height: 50px;
  font-size: 115%;
  background-color: #006064;
  border: 0px;
  border-radius: 7px;
  color: white;
  transition: 2s ease all;
}
button img {
  height: 22px; 
}
.boxed:hover, button:hover {
-webkit-transition: 2s ease all;
  transition: 2s ease all;
  box-shadow: 0 15px 35px 0 rgba(0, 0, 0, 0.7);
  -webkit-transform: translateY(-1px);
          transform: translateY(-1px);
}       
  form label {
    font-size:16px;
  }

  input[type="text"], input[type="number"], input[type="password"], select {
    width: 200px;
    height: 30px;
    margin-left: 20px;
    padding: 3px;
    padding-left:6px;
    border-radius: 5px;
  font-size: 14px;
  box-shadow: inset 0 1px 3px rgba(0,0,0, .455), 0px 1px 1px rgba(255,255,255,.5);
  border: 1px solid #4DD0E1;
  background-color: rgb(239,252,251);
  }
  .foot {
    position: absolute;
    bottom: 0;
  background-color: #006064;
  width: 100%;
  color: white;
  }

a {
  color: #006064;
  font-weight: bold;
}
  .centered {
    padding: 10px;
    margin: 0 auto;
    text-align:center;
  }
  .heading {
    margin: 20px;
  }
  .boxed { 
    display: table;
    box-shadow: 0 5px 25px 0 rgba(0, 0, 0, 0.4);
    width: 50%;
    padding: 30px;
    margin: 0 auto;
    margin-top:180px;
    margin-bottom: 40px;
    transition: 2s ease all;
}
   </style>
  </head>

  <body>
      <div>
    <img src="karamraj.png" width="125" style="padding: 10px; position: absolute; left:0; top:0;">
  </div> 
  <div class="container boxed">
  <h2 class="heading centered">Thank You</h2><br>
    <p>
     
           <%
            Integer reqId=null;
            reqId=(Integer)session.getAttribute("reqId");
            
            System.out.println(""+reqId);
           %>
       
            
        We have received your application. Your Request id is <%= reqId %>. You can use <a href="userTracking.jsp?tid=<%= reqId %>">this link</a> to track your application status (or manually enter your tracking id here).
    </p>
    </div>
    <div class="foot"> 
            <ul style="list-style-type:none" class="centered">
            <li>DroidiserGang @ Rajasthan Hackathon</li>
            </ul>
    </div>
  </body>
  
</html>

