<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Update Post</title>

    <link href="/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h5>Update Post</h5>
            <form action = "/updatePost" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="hidden" name="postId" value="${postId}">
                <div class="form-group">
                    <label for="post">Post</label>
                    <textarea class="form-control" type="text" name="post" id="post">${post}</textarea>
                    <%--<span class="alert-danger">${nullPost}</span>--%>
                </div>

                <input type="submit" value="Update Post" name="updatePost" id="updatePost">
            </form>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript" src="/js/lib/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
