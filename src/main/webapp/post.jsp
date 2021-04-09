
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post</title>
    <link href="resources/formstyle.css" rel="stylesheet">
</head>
<body>
<a href="index.jsp">Home</a>
<form action="post" method="POST">
    <div class="container">
        <h2>Post creation</h2>
        <div classs="field">
            <label for="tittle">Tittle</label>
            <input type="text" placeholder="Enter the tittle of post" id="tittle" name="tittle" required>
        </div>
        <div classs="field">
            <label for="pContent">Content</label>
            <input type="text" placeholder="Enter the content of post" id="pContent" name="pContent" required>
        </div>
        <div classs="field">
            <label for="comment">Comment</label>
            <input type="text" placeholder="Enter the comment" id="comment" name="comment" required>
        </div>
        <hr>
        <button type="submit" class="btn">Post</button>
    </div>
</form>
</body>
</html>
