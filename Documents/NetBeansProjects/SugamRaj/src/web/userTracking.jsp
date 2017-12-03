<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>

<html>

  <head> 
      <script src="jquery-1.11.1.js"></script>
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
    margin-top: 10%;
  margin-left: 8%;
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
    width: 60%;
    padding: 30px;
    margin: 0 auto;
    margin-top: 80px;
    margin-bottom: 40px;
    transition: 2s ease all;
}
/*Radial CSS starts*/

/**
 * Define variables
 */
/**
 * Style default tags
 */
*, *:before, *:after {
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}

html, body {
  height: 100%;
}

body {
  font-size: 14px;
  text-align: center;
}

/**
 * Utility styles
 */
.inliner {
  height: 100%;
}

.inliner,
.inliner + .inlined {
  display: inline-block;
  vertical-align: middle;
}

.inlined {
  width: 90%;
}

/**
 * Component styles
 */
.progress-meter {
  margin: 20px auto 40px;
  padding: 40px;
}

.progress-meter {
  counter-reset: point;
}
.progress-meter .progress-point:before {
  -moz-transition: all 1s;
  -o-transition: all 1s;
  -webkit-transition: all 1s;
  transition: all 1s;
  -moz-border-radius: 24px;
  -webkit-border-radius: 24px;
  border-radius: 24px;
  -moz-box-shadow: 0 0 0 2px black;
  -webkit-box-shadow: 0 0 0 2px black;
  box-shadow: 0 0 0 2px white;
  content: "\2713";
  display: block;
  width: 24px;
  margin: 0 auto 12px;
  border: 2px solid #aaa;
  text-align: center;
  background-color: white;
  color: white;
}
.progress-meter .track {
  position: relative;
  height: 4px;
  background: #ddd;
}
.progress-meter .progress {
  -moz-transition: width 1s;
  -o-transition: width 1s;
  -webkit-transition: width 1s;
  transition: width 1s;
  display: block;
  position: absolute;
  left: 0;
  top: 0;
  width: 0;
  height: 4px;
  background: #006064;
}
.progress-meter .progress-points {
  position: relative;
  margin: -14px 0 0;
  padding: 0;
  list-style: none;
}
.progress-meter .progress-points .progress-point:nth-child(1) {
  left: 0%;
}
.progress-meter .progress-points .progress-point:nth-child(2) {
  left: 25%;
}
.progress-meter .progress-points .progress-point:nth-child(3) {
  left: 50%;
}
.progress-meter .progress-points .progress-point:nth-child(4) {
  left: 75%;
}
.progress-meter .progress-points .progress-point:nth-child(5) {
  left: 100%;
}
.progress-meter .progress-point {
  -moz-transition: color 1s;
  -o-transition: color 1s;
  -webkit-transition: color 1s;
  transition: color 1s;
  position: absolute;
  display: block;
  width: 100px;
  margin-left: -50px;
  text-align: center;
  cursor: pointer;
  color: #999;
}
.progress-meter .progress-point.completed, .progress-meter .progress-point.active {
  color: #777;
}
.progress-meter .progress-point.completed:before {
  border-color: #006064;
  background-color: #006064;
}
.progress-meter .progress-point.active:before {
  -moz-transition-delay: 1s;
  -o-transition-delay: 1s;
  -webkit-transition-delay: 1s;
  transition-delay: 1s;
  border-color: #777;
}
.progress-meter .progress-point .label:before {
  counter-increment: point;
  content: counter(point) ". ";
  /* Display the counter */
}
/*Radial CSS ends*/
   </style>
  </head>

  <body>
       <div>
    <img src="karamraj.png" width="125" style="padding: 10px; position: absolute; left:0; top:0;">
  </div>
      <form style="margin-top: 5%;" method='POST' action='userTracking.jsp'>
      <input type='text' style="height: 40px; width: 420px" name='searchBar' value='' placeholder='Input your request ID here....'>
      <br>
      <button type='submit' name='Search'>Search</button>
      </form>
      <%
          String reqid=request.getParameter("tid");
          if(request.getParameter("searchBar")==null){
              System.out.println("Enter an valid id");
          } else {
              int id=0;
              if(request.getParameter("tid")!=null ){
                  id= Integer.parseInt(request.getParameter("tid"));
              } else if(request.getParameter("searchBar")!=null){
                  id=Integer.parseInt(request.getParameter("searchBar"));
              }
          
//String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "sugamkaram";
String userId = "root";
String password = "";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
PreparedStatement statement = null;
ResultSet resultSet = null;
String stageId="";
String username="";
try{ 
    
    connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
    
statement=connection.prepareStatement("SELECT * FROM stages where reqId=? ");
statement.setInt(1, id);
resultSet = statement.executeQuery();
Connection connect=null;
PreparedStatement pst = null;
ResultSet rs=null;
if(resultSet.next()){
    stageId=resultSet.getString(2);
    System.out.println("Stage is "+stageId);
}
connect = DriverManager.getConnection(connectionUrl+dbName, userId, password);
pst=connect.prepareStatement("SELECT * FROM userdetails where reqId=? ");
pst.setInt(1, id);
rs=pst.executeQuery();
if(rs.next()){
    username=rs.getString(2);
}
%>
<div class="container boxed">
    <span style="font-size: 120%; text-align: left !important;">Hello, <i><%=username %></i>. Your pension application request viz tracking id <i><%=id %></i> has reached stage <i><%=stageId %> - Document Verification</i>, and will be processed by <i>27th December, 2017.</i></span><br>

  
    <!-- Radial progress starts -->
    <div class="inliner"></div>
<div class="inlined">
  
  <!-- Start component -->
  <div class="progress-meter">
    <div class="track">
      <span class="progress"></span>
    </div>
      <ol class="progress-points" data-current="<%=stageId %>">
      <li class="progress-point completed" >
        <span class="label">Application received</span>
      </li>
      <li class="progress-point">
        <span class="label">Documents verification</span>
      </li>
      <li class="progress-point">
        <span class="label">Address verification</span>
      </li>
      <li class="progress-point">
        <span class="label">Pension card issued</span>
      </li>
      <li class="progress-point">
        <span class="label">Pension card dispatched</span>
      </li>
    </ol>
  </div>
  <!-- End component -->
  
  <!-- Demo only -->
</div>
    <!-- Radial progress ends -->
    </div>
    <div class="foot"> 
            <ul style="list-style-type:none" class="centered">
            <li>DroidiserGang @ Rajasthan Hackathon</li>
            </ul>
    </div>
<% 

} catch (Exception e) {
e.printStackTrace();
}
}
%>
    <script>
      (function() {  
  var $point_arr, $points, $progress, $trigger, active, max, tracker, val;

  $trigger   = $('.trigger').first();
  $points    = $('.progress-points').first();
  $point_arr = $('.progress-point');
  $progress  = $('.progress').first();

  val     = +$points.data('current') - 1;
  max     = $point_arr.length - 1;
  tracker = active = 0;

  function activate(index) {
    if (index !== active) {
      active       = index;
      var $_active = $point_arr.eq(active)
      
      $point_arr
        .removeClass('active')
        .slice(0, active).addClass('completed')
      
      $_active.addClass('active');
      $_active.addClass('completed');
      
      return $progress.css('width', (index / max * 100) + "%");
    }
  };

  setTimeout((function() {
    return activate(val);
  }), 1000);

}).call(this);

    </script>
  </body>
</html>