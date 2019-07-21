<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="left-menu">
    <ul>
        <li><a href="/welcome">Home</a></li>
        <li><a href="/newPost">Add Status</a></li>
        <li><a href="/personalPosts">My Status</a></li>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <form id="logoutForm" method="POST" action="${contextPath}/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>

            <li> <a onclick="document.forms['logoutForm'].submit()">Logout</a></li>
        </c:if>
    </ul>
</div>