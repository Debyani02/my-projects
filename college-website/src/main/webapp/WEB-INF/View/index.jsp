<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="icon" href="image/logo.jpg" type="image/x-icon">
        
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/stylesheet.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
    integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />


</head>
<body>
	 <nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top" style="height: 100px;">
            <a class="navbar-brand" href="#"><img src="image/logo.jpg" height="50px"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
              aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                  <li class="nav-item active">
                    <a class="nav-link" href="#">About <span class="sr-only">(current)</span></a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">Admissions</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">Academics</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="contactus">Contact Us</a>
                  </li>         
                </ul>          
              </div>
              <div class="right-navbar">
                <ul class="right-menu">
                <li class="nav-item">
                  <a class="nav-link" href="studentregister">Student Register</a>
                  </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" 
                    aria-expanded="false">
                      Login
                    </a>
                    <div class="dropdown-menu">
                      <a class="dropdown-item" href="studentloginpage">Student </a>
                      <a class="dropdown-item" href="facultyloginpage">Faculty </a>
                      <a class="dropdown-item" href="adminlogin">Admin </a>
                    </div>
                  </li>
                  
                </ul>
              </div>
            </nav>

            <div class="notice-area">
              <marquee bgcolor="blue" loop="-1" behavior="scroll">
                <a href="#">Click here for Admission 2024-25</a>
                <a href="#">Apply for scholarship</a>
              </marquee>
            </div>

            <section class="carousel-content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div id="carouselExampleInterval" class="carousel slide" data-ride="carousel">
                                <div class="carousel-inner">
                                  <div class="carousel-item active" data-interval="10000">
                                    <img src="image/University1.jpg" class="d-block w-100" alt="...">
                                  </div>
                                  <div class="carousel-item" data-interval="2000">
                                    <img src="image/UNiversity_Studentsjpg.jpg" class="d-block w-100" alt="...">
                                  </div>
                                  <div class="carousel-item">
                                    <img src="image/University_library.jpg" class="d-block w-100" alt="...">
                                  </div>
                                </div>
                                <button class="carousel-control-prev" type="button" data-target="#carouselExampleInterval" data-slide="prev">
                                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                  <span class="sr-only">Previous</span>
                                </button>
                                <button class="carousel-control-next" type="button" data-target="#carouselExampleInterval" data-slide="next">
                                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                  <span class="sr-only">Next</span>
                                </button>
                              </div>
                        </div>
                    </div>
                </div>
            </section>

            <section class="below-carousel">
                <div class="badge">
                    Unlock your Potential: Scholarship for CUET Aspirants.
                    <button href="#" type="button" class="btn-btn-primary">Click here</button>
                </div>
            </section>

            <section class="banner">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="col-md-3">
                                <div class="banner-heading">
                                    Together We Have Achieved Excellence
                                </div>
                            </div>
                            <div class="col-md-9">

                            </div>
                        </div>
                        <div class="col-md-12">
                            <img src="image/Grade.jpg" width="100%">
                        </div>
                    </div>
                </div>
            </section>


            <section id="events">
              <div class="container-fluid">
                <div class="row">
                  <div class="banner-heading">
                    <h2>Events </h2>
                  </div>
                  <div class="col-md-12">
                    <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                      <ol class="carousel-indicators">
                        <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                        <!-- <li data-target="#carouselExampleCaptions" data-slide-to="2"></li> -->
                      </ol>
                      <div class="carousel-inner">
                        <div class="carousel-item active">
                          <img src="image/event1.jpeg" class="d-block w-100" alt="...">
                          <div class="carousel-caption d-none d-md-block">
                            <h5>First slide label</h5>
                            <p>Some representative placeholder content for the first slide.</p>
                          </div>
                        </div>
                        <div class="carousel-item">
                          <img src="image/event2.jpg" class="d-block w-100" alt="...">
                          <div class="carousel-caption d-none d-md-block">
                            <h5>Second slide label</h5>
                            <p>Some representative placeholder content for the second slide.</p>
                          </div>
                        </div>
                      </div>
                      <button class="carousel-control-prev" type="button" data-target="#carouselExampleCaptions" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                      </button>
                      <button class="carousel-control-next" type="button" data-target="#carouselExampleCaptions" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </section>


        

            <section class="footer">
              <div class="container">
                <div class="row bottom-content">
                  <div class="col-md-3">
                    <div class="university-contact">
                      <div class="footer-logo">
                        <img src="image/logo.jpg" alt="logo" height="50px">
                      </div>
                      <div class="footer-contact">
                        <h3>UCIT </h3>
                      </div>
                      <div class="footer-address">
                        Dhurwa Sector-II ByPass Road,
                        Ranchi, Jharkhand
                        (INDIA)-834002
                      </div>
                      <div class="phone">
                        <a href="tel:09876543211"><p><i class="fa-solid fa-phone"></i>   Tel: +91-1820-1122236</p></a>
                        <a href="tel:09876543211"><p><i class="fa-solid fa-phone"></i>   Tel: +91-1820-1378836</p></a>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-3">
                      <div class="social">
                        <div class="footer-top">
                          <h3>Follow us</h3>
                        </div>
                        <div class="social-icon">
                          <a href="https://www.facebook.com"><i class="fa-brands fa-facebook"></i></a>
                          <a href="https://www.twitter.com"><i class="fa-brands fa-twitter"></i></a>
                          <a href="https://www.instagram.com"><i class="fa-brands fa-instagram"></i></a>
                        </div>
                      </div>
                    </div>
                    <div class="col-md-3">
                      <h3>Admissions</h3>
                      <div class="more-links">
                        <ul>
                          <li><a href="#">Admission 2024-25</a>
                          <li><a href="#">Distance Education Admission 2024-25</a></li>
                          <li><a href="#">Online Education Admission 2024-25</a></li>
                          <li><a href="#">Scholarship & Aid</a></li>
                          <li><a href="#">Fee Deposits</a></li>
                        </ul>
                    </div>
                  </div>
                    <div class="col-md-3">
                      <div class="academic-links">
                        <div class="footer-top">
                          <h3>Academics</h3>
                        </div>
                        <div class="more-links">
                          <ul>
                            <li><a href="#">Joint Placement Drive</a>
                            <li><a href="#">Education Award</a></li>
                            <li><a href="#">Alumni</a></li>
                            <li><a href="#">Recognition Application(ODL)</a></li>
                            <li><a href="#">Summer School</a></li>
                          </ul>
                        </div>
                      </div>
                    </div>
                </div>
              </div>
            </section>

            <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous"></script>
	
</body>
</html>