<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<body>
	<main role="main">
		<section class="recommend-items_cate">
			<h2>검색 상품 목록</h2>
			<c:choose>
				<c:when test="${not empty searchList}">
					<div class="recommend-slide">
						<div class="recommend-slide-items">
							<c:forEach items="${searchList}" var="item">
								<div class="recommend-slide-item">
									<div class="item-img-container">
										<span style="display: none;">{$item.pr_key}</span>
										<c:url var="path" value="/shopping/goods.do">
											<c:param name="pr_key" value="${item.pr_key}" />
										</c:url>
										<a href="${path}"> <img class="item-img"
											src="${item.pr_thumbnail}" alt="추천 상품" />
										</a> <span style="display: none;">{$item.pr_key}</span>
									</div>
									<a href="${path}">
										<h3 class="item-name">${item.pr_name}</h3>
									</a> <a href="${path}">
										<p class="current-price">
											<span class="discount-rate"> <fmt:formatNumber
													type="percent" value="${item.pr_dcper}" />
											</span>
											<fmt:formatNumber type="number" value="${item.pr_dcprice}" />
											원
										</p>
									</a> <a href="${path}">
										<p class="regular-price">
											<fmt:formatNumber type="number" value="${item.pr_price}" />
											원
										</p>
									</a>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="no-result-message">
						<p>검색 결과가 없습니다.</p>
					</div>
				</c:otherwise>
			</c:choose>
</body>
</html>