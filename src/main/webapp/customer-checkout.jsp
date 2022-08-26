<%@page import="Model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import= "Dao.ProductDao"%>
    <%@ page import="Model.Product" %>
    <%@page import= "Dao.ProductDao" %>
    <%@ page import="Model.Customer" %> 
    <%@ page import="java.util.*" %>
    <%@ page import="Model.Cart" %> 
  <%@page import= "Dao.CartDao" %>
  <%@page import="java.sql.*" %>
  <%@ page import="connection.DBConnection" %>
 <%@page import= "java.text.DateFormat" %> 
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
  


<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Male_Fashion Template">
    <meta name="keywords" content="Male_Fashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Male-Fashion | Template</title>
    <link rel="stylesheet" href=
"https://unpkg.com/purecss@2.0.6/build/pure-min.css"
         integrity=
"sha384-Uu6IeWbM+gzNVXJcM9XV3SohHtmWE+3VGi496jvgX1jyvDTXfdK+rfZc8C1Aehk5" 
         crossorigin="anonymous">
          <style>
      .menu-custom {
         height: 150px;
      }
   </style>
  

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
    rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>

<%
Customer c = null;
if(session.getAttribute("data")!=null){
	c= (Customer)session.getAttribute("data");
}
else{
	response.sendRedirect("customer-login.jsp");
}
%>

    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Offcanvas Menu Begin -->
    <div class="offcanvas-menu-overlay"></div>
    <div class="offcanvas-menu-wrapper">
        <div class="offcanvas__option">
            <div class="offcanvas__links">
                <a href="#">Sign in</a>
                <a href="#">FAQs</a>
            </div>
            <div class="offcanvas__top__hover">
                <span>Usd <i class="arrow_carrot-down"></i></span>
                <ul>
                    <li>USD</li>
                    <li>EUR</li>
                    <li>USD</li>
                </ul>
            </div>
        </div>
        <div class="offcanvas__nav__option">
            <a href="#" class="search-switch"><img src="img/icon/search.png" alt=""></a>
            <a href="#"><img src="img/icon/heart.png" alt=""></a>
            <a href="#"><img src="img/icon/cart.png" alt=""> <span>0</span></a>
            <div class="price">$0.00</div>
        </div>
        <div id="mobile-menu-wrap"></div>
        <div class="offcanvas__text">
            <p>Free shipping, 30-day return or refund guarantee.</p>
        </div>
    </div>
    <!-- Offcanvas Menu End -->

    <!-- Header Section Begin -->
    <header class="header">
                <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-3">
                    <div class="header__logo">
                        <a href="./customer-index.jsp"><img src="img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <nav class="header__menu mobile-menu">
                        <ul>
                            <li class="active"><a href="customer-index.jsp">Home</a></li>
                            <li><a href="#">Your Activity</a>
                                <ul class="dropdown"> 
                                    <li><a href="shop.jsp">Shop Details</a></li>
                                    <li><a href="./customer-add-cart.jsp">Shopping Cart</a></li>
                                    <li><a href="./checkout.jsp">Check Out</a></li>
                                    
                                    
                                </ul>
                            </li>
                             <li><a href="#"><%=c.getName() %></a>
                                <ul class="dropdown">
                                    <li><a href="customer-profile.jsp">Profile</a></li>
                                    <li><a href="customer-change-password.jsp">Change Password</a></li>
                                    <li><a href="logout.jsp">Logout</a></li>
                                </ul>
                            </li>
                             <li>
                            <a href="#">Our Group</a>
                            	<ul class="dropdown">
                            		<li><a href="./blog.jsp">Blog</a></li>
                            		<li><a href="./contact.jsp">Contact</a></li>
                            		<li><a href="./about.jsp">About Us</a></li>
                            		</ul>
                           	</li>
                           	
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3 col-md-3">
                    <div class="header__nav__option">
                        <a href="#" class="search-switch"><img src="img/icon/search.png" alt=""></a>
                        <a href="#"><img src="img/icon/heart.png" alt=""></a>
                        <a href="#"><img src="img/icon/cart.png" alt=""> <span>0</span></a>
                        <div class="price">$0.00</div>
                    </div>
                </div>
            </div>
            <div class="canvas__open"><i class="fa fa-bars"></i></div>
        </div>
    </header>
    <!-- Header Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__text">
                        <h4>Check Out</h4>
                        <div class="breadcrumb__links">
                            <a href="./index.html">Home</a>
                            <a href="./shop.html">Shop</a>
                            <span>Check Out</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">
                <form action="CheckOutController" method="post">
                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                            <h6 class="checkout__title">Billing Details</h6>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>First Name<span>*</span></p>
                                        <input type="text" name="fname" Placeholder="Enter First Name" required="">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Last Name<span>*</span></p>
                                        <input type="text" name="lname" Placeholder="Enter Last Name" required="">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Phone<span>*</span></p>
                                        <input type="text" name="contact" placeholder="Enter Contact">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Email<span>*</span></p>
                                        <input type="email" name="email" Placeholder="Enter Email" required>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="checkout__input">
                                <p>Country<span>*</span></p>
                                <input type="text" name="country"  value="India" >
                            </div>
                            <div class="checkout__input">
                                <p>State<span>*</span></p>
                                <!--- India states -->

								  <div class="pure-menu pure-menu-scrollable menu-custom">
								      <select id="country-state" name="state" >
								    <option value="AN">Andaman and Nicobar Islands</option>
								    <option value="AP">Andhra Pradesh</option>
								    <option value="AR">Arunachal Pradesh</option>
								    <option value="AS">Assam</option>
								    <option value="BR">Bihar</option>
								    <option value="CH">Chandigarh</option>
								    <option value="CT">Chhattisgarh</option>
								    <option value="DN">Dadra and Nagar Haveli</option>
								    <option value="DD">Daman and Diu</option>
								    <option value="DL">Delhi</option>
								    <option value="GA">Goa</option>
								    <option value="GJ" selected>Gujarat</option>
								    <option value="HR">Haryana</option>
								    <option value="HP">Himachal Pradesh</option>
								    <option value="JK">Jammu and Kashmir</option>
								    <option value="JH">Jharkhand</option>
								    <option value="KA">Karnataka</option>
								    <option value="KL">Kerala</option>
								    <option value="LA">Ladakh</option>
								    <option value="LD">Lakshadweep</option>
								    <option value="MP">Madhya Pradesh</option>
								    <option value="MH">Maharashtra</option>
								    <option value="MN">Manipur</option>
								    <option value="ML">Meghalaya</option>
								    <option value="MZ">Mizoram</option>
								    <option value="NL">Nagaland</option>
								    <option value="OR">Odisha</option>
								    <option value="PY">Puducherry</option>
								    <option value="PB">Punjab</option>
								    <option value="RJ">Rajasthan</option>
								    <option value="SK">Sikkim</option>
								    <option value="TN">Tamil Nadu</option>
								    <option value="TG">Telangana</option>
								    <option value="TR">Tripura</option>
								    <option value="UP">Uttar Pradesh</option>
								    <option value="UT">Uttarakhand</option>
								    <option value="WB">West Bengal</option>
								</select>
								   </div>

                            </div>
                           <div class="checkout__input">
                                <p>Town/City<span>*</span></p>
                                <input type="text" name="city" placeholder="Enter City" required="">
                            </div>
                            
                            
                            <div class="checkout__input">
                                <p>Address<span>*</span></p>
                                <input type="text" placeholder="Street Address" name="staddr"class="checkout__input__add">
                                <input type="text" placeholder="Apartment, suite, unite ect (optinal)" name="apmt" required="">
                            </div>
                             <div class="checkout__input">
                                <p>Postcode / ZIP<span>*</span></p>
                                <input type="text" name="pincode" required="">
                                <input type="hidden" name="cusid" value="<%=c.getId()%>">
                            </div>
                            <div class="checkout__input__checkbox">
                                <label for="diff-acc">
                                    Note about your order, e.g, special noe for delivery
                                 
                                </label>
                            </div>
                            <div class="checkout__input">
                                <p>Order notes<span>*</span></p>
                                <input type="text"
                                placeholder="Notes about your order, e.g. special notes for delivery." name="notes">
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6">
                         <%int id=c.getId(); %>
                            <%double total=0; %>
                            
                           <%List<Cart> list=CartDao.getAllProductsById(id); %>
                       
                            <div class="checkout__order">
                                <h4 class="order__title">Your order</h4>
                                <div class="checkout__order__products">Product <span>Total</span></div>
                                <ul class="checkout__total__products">
                               <%   Connection conn=DBConnection.createConnection();
                                %>
									 <%for(Cart c1:list){   %>                         
                                    <li><%=c1.getPname() %><span><%=c1.getPprice()%></span></li>
                                    <%total=total+c1.getPprice(); %>
                                    
                                    <%DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");	

										Date currentDate = new Date();
										System.out.println(dateFormat.format(currentDate));
										
										// convert date to calendar
										Calendar c2 = Calendar.getInstance();
										c2.setTime(currentDate);
										
										// manipulate date
										
										c2.add(Calendar.DATE, 5); //same with c.add(Calendar.DAY_OF_MONTH, 1);
										
										// convert calendar to date
										 String deliverydate = c2.getTime().toString();
										
                                     int cusid=c.getId();
                                    Cart ca=new Cart();
                        			String sql="insert into delivery(cusid,pid,pprice,deliverydate) values(?,?,?,?)";
                        			PreparedStatement pst = conn.prepareStatement(sql);
                        			pst.setInt(1,id );
                        			pst.setInt(2, c1.getPid());
                        			pst.setDouble(3, c1.getPprice());
                        			pst.setString(4,deliverydate);
                        			pst.executeUpdate();
                        			System.out.println("Data  delivery");
                        	 
                                    
                                     
                                    %>
                                    
                                 <%} %> 
                                    </ul>
                                <ul class="checkout__total__all">
                                    <li>Subtotal <span><i class="fa fa-rupee"></i><%=total%></span></li>
                                    <input type="hidden" name="total" value="<%=total%>">
                                    <li>Total <span><i class="fa fa-rupee"></i><%=total%></span></li>
                                </ul>
                                <div class="checkout__input__checkbox">
                                   
                                </div>
                                <div class="checkout__input__checkbox">
                                    <label for="payment">
                                                                       </label>
                                </div>
                                <div class="checkout__input__checkbox">
                                    <label for="paypal">
                                         </label>
                                </div>
                                <button type="submit" class="site-btn" name="action" value="Place Order">PLACE ORDER</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <!-- Checkout Section End -->

    <!-- Footer Section Begin -->
    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__logo">
                            <a href="#"><img src="img/footer-logo.png" alt=""></a>
                        </div>
                        <p>The customer is at the heart of our unique business model, which includes design.</p>
                        <a href="#"><img src="img/payment.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-2 offset-lg-1 col-md-3 col-sm-6">
                    <div class="footer__widget">
                        <h6>Shopping</h6>
                        <ul>
                            <li><a href="#">Clothing Store</a></li>
                            <li><a href="#">Trending Shoes</a></li>
                            <li><a href="#">Accessories</a></li>
                            <li><a href="#">Sale</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-2 col-md-3 col-sm-6">
                    <div class="footer__widget">
                        <h6>Shopping</h6>
                        <ul>
                            <li><a href="#">Contact Us</a></li>
                            <li><a href="#">Payment Methods</a></li>
                            <li><a href="#">Delivary</a></li>
                            <li><a href="#">Return & Exchanges</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-3 offset-lg-1 col-md-6 col-sm-6">
                    <div class="footer__widget">
                        <h6>NewLetter</h6>
                        <div class="footer__newslatter">
                            <p>Be the first to know about new arrivals, look books, sales & promos!</p>
                            <form action="#">
                                <input type="text" placeholder="Your email">
                                <button type="submit"><span class="icon_mail_alt"></span></button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="footer__copyright__text">
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        <p>Copyright ©
                            <script>
                                document.write(new Date().getFullYear());
                            </script>2020
                            All rights reserved | This template is made with <i class="fa fa-heart-o"
                            aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                        </p>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Search Begin -->
    <div class="search-model">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-switch">+</div>
            <form class="search-model-form">
                <input type="text" id="search-input" placeholder="Search here.....">
            </form>
        </div>
    </div>
    <!-- Search End -->

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery.nicescroll.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/jquery.countdown.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>
</body>

</html>