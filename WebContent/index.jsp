<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link href="css/bind.css" rel="stylesheet" type="text/css" />
    <link href="css/notice.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="modernizr.js"></script>
</head>
<body>
    <header id="header">
        <div class="content-wrapper">
            <h1 id="logo"><a href="../index.html"><img src="images/logo.png" alt="뉴렉처 온라인" /></a></h1>
            <section class="header-item-container">
                <h1 class="hidden">머리말</h1>
                <nav id="main-menu">
                    <h1 class="hidden">메인메뉴</h1>
                    <ul class="clearfix">
                        <li class="main-menu-item"><a class="main-menu-item-text" href="">학습가이드</a></li>
                        <li class="main-menu-item"><a class="main-menu-item-text" href="">뉴렉과정</a></li>
                        <li class="main-menu-item"><a class="main-menu-item-text" href="">강좌선택</a></li>
                    </ul>
                </nav>

                <div id="lecture-search-form">
                    <h3 class="hidden">강좌검색 폼</h3>
                    <form>
                        <fieldset>
                            <legend class="hidden">검색필드</legend>
                            <label id="lecture-search-input-label" for="subject">과정검색</label>
                            <input id="lecture-search-input" class="g1" type="text" name="subject" />
                            <input id="lecture-search-button" type="submit" value="검색" />
                        </fieldset>
                    </form>
                </div>

                <nav id="member-menu">
                    <h1 class="hidden">회원메뉴</h1>
                    <ul class="clearfix">
                        <li class="member-menu-item"><a class="member-menu-item-text" href="../index.html">홈</a></li>
                        <li class="member-menu-item"><a class="member-menu-item-text" href="joinus/login.html">로그아웃</a></li>
                        <li class="member-menu-item"><a class="member-menu-item-text" href="joinus/join.html">회원가입</a></li>
                    </ul>
                </nav>

                <nav id="my-menu">
                    <h1 class="hidden">고객센터메뉴</h1>
                    <ul class="clearfix">
                        <li class="my-menu-item"><a class="my-menu-item-text" href=""><img src="images/txt-mypage.png" alt="마이페이지" /></a></li>
                        <li class="my-menu-item"><a class="my-menu-item-text" href="customer/notice.html"><img src="images/txt-customer.png" alt="고객센터" /></a></li>
                    </ul>
                </nav>
            </section>
        </div>
    </header>

    <div id="visual">
        <div class="content-wrapper">

        </div>
    </div>

    <div id="body">
        <div class="content-wrapper clearfix">
            index 페이지
        </div>
    </div>

    <footer id="footer">
        <div class="content-wrapper clearfix">
            <div id="logo-footer-container">
                <h2 id="logo-footer"><img src="images/logo-footer.png" alt="회사정보" /></h2>
            </div>
            <div id="company-info-container">
                <div id="company-info">
                    <h3 class="hidden">소유자정보</h3>
                    <dl class="clearfix">
                        <dt class="company-info-item item-title item-newline">주소</dt>
                        <dd class="company-info-item item-data">서울특별시 동대문구</dd>
                        <dt class="company-info-item item-title item-newline">관리자메일</dt>
                        <dd class="company-info-item item-data">admin@newlecture.com</dd>
                        <dt class="company-info-item item-title">전화번호</dt>
                        <dd class="company-info-item item-data">02-111-0000</dd>
                        <dt class="company-info-item item-title item-newline">상호</dt>
                        <dd class="company-info-item item-data">뉴렉처</dd>
                    </dl>
                </div>

                <div id="copyright">
                    <h3 class="hidden">저작권정보</h3>
                    <p>Copyright@newlecture.com 2013-2015 ....</p>
                </div>
            </div>
        </div>
    </footer>

    <!--<aside id="quick-menu">
        <h1>QUICK MENU</h1>
        <nav>
            <h1>자주가는 메뉴</h1>
            <ul>
                <li>강의실</li>
                <li>채팅방</li>
                <li>스케줄</li>
            </ul>
        </nav>

        <nav>
            <h1>관리자 메뉴</h1>
            <p>QUICK MENU 관리하기</p>
        </nav>

        <nav>
            <h1>스크롤 메뉴</h1>
            <p>top</p>
        </nav>
    </aside>-->
</body>
</html>

