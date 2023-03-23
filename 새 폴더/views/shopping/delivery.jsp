<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>0칼로리 :: 디저트는 빵칼로리</title>

    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@300;400;700;900&display=swap"
      rel="stylesheet"
    />

    <!-- CSS -->
    <link rel="stylesheet" href="./CSS/header.css" />
    <link rel="stylesheet" href="./CSS/footer.css" />
    <link rel="stylesheet" href="./CSS/style.css" />
    <link rel="stylesheet" href="./CSS/navbar.css" />
    <link rel="stylesheet" href="./CSS/slider.css" />
    <link rel="stylesheet" href="./CSS/main.css" />
    <link rel="stylesheet" href="./CSS/search.css" />
    <link rel="stylesheet" href="./CSS/category.css" />
    <link rel="stylesheet" href="./CSS/goods.css" />
    <link rel="stylesheet" href="./CSS/cart.css" />
    <link rel="stylesheet" href="./CSS/wish.css" />
    <link rel="stylesheet" href="./CSS/order.css" />
    <link rel="stylesheet" href="<c:url value="/resources/CSS/delivery.css"/>" >

    <!-- Script -->
    <script
      src="https://kit.fontawesome.com/43fd0ad460.js"
      crossorigin="anonymous"
    ></script>
    <script src="./JavaScript/img-slider.js" defer></script>
    <script src="./JavaScript/menu.js" defer></script>
    <script src="./JavaScript/recommend-slider.js" defer></script>
    <script src="./JavaScript/advertisement.js" defer></script>
    <script src="./JavaScript/cartcount.js" defer></script>
    <script src="./JavaScript/cartselectdelete.js" defer></script>
    <script src="./JavaScript/cartselectchoose.js" defer></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <script>
    $(document).ready(function() {
    	  $(".delete_address_btn").on("click",function(e) {
    		  e.preventDefault();
    		  //let del_key = $(".del_key").val();
    		  const del_key = parseInt($(this).data("del_key"));
    		  //const del_key = document.getElementsByClassName(".delete_address_btn").val();
    		  $(".del_key").val(del_key);
    		  parseInt($(this).parent("div").find(".del_key").val(del_key));
				console.log(goods_price);

    			console.log(del_key);
    			//console.log("del_key:" +del_key);
    	   
    	    //$(this).closest("form").find("input[name=del_key]").val(delKey);
    	    $(".del_form").submit();
    	  });
    	});
</script>
  </head>

  <body style="background-color: #f2e6d9">
    <hr class="container" />
    <div class="delivery-heading">
      <h2 style="color: #444444">배송지</h2>
      <span style="color: #777777"
        >배송지에 따라 상품정보 및 배송유형이 달라질 수 있습니다.</span
      >
    </div>
    <table class="delivery-table" style="background-color: #f9f6f0">
      <thead>
        <tr>
          <th class="del_check">선택</th>
          <th class="recevier_name">배송지명</th>
          <th class="del_phone">연락처</th>
          <th class="del_address">주소</th>
          <th class="del_delete">삭제</th>
          <th class="del_update">수정</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${aList}" var="dto">
         <tr>
           <td class="del_check_td" style="text-align: center">
             <input type="radio" name="delivery" value="1" />
          </td>
         <input type="hidden"  value="${dto.del_key}"/>
           <td class="recevier_name_td">${dto.receiver_name}</td>
           <td class="del_phone_td">${dto.del_phone }</td>
           <td class="del_address_td">${dto.del_address }</td>
           <td class="del_delete_td">
             <form method="post" action="${pageContext.request.contextPath}/shopping/delivery.do" class ="del_form">
               <input type="hidden" name="del_key" class="del_key" value="${dto.del_key}">
             <button type="button" class="btn btn-danger delete_address_btn" data-del_key="${dto.del_key}" data-testid="delete" value="${dto.del_key}">삭제</button>
             </form>
           </td>
           <td class="del_update_td">
             <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editModal" data-delkey="${delivery.del_key}">수정</button>
           </td>
         </tr>
      </c:forEach>

      </tbody>
    </table>
    <div class="no-delivery-info" style="color: #777777">
      <p>상품 구매를 위한 배송지를 설정해주세요.</p>
      <button
        class="btn-add-delivery"
        style="cursor: pointer"
        onclick="window.open('http://localhost:8090/myapp/shopping/post.do', 'btn-add-delivery', 'width=600, height=400')"
        style="background-color: #cccccc; color: #444444"
      >
        + 새 배송지 추가
      </button>
    </div>
  </body>
</html>
