<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<c:import url="head.jsp" />

<body>
<c:import url="header.jsp" />

<div>
    <h4><b>Search Results:</b></h4>

    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Year</th>
            <th>Make</th>
            <th>Model</th>
        </tr>

        <c:forEach var="car" items="${cars}" >
            <tr>
                <td>${car.id}</td>
                <td>${car.year}</td>
                <td>${car.make}</td>
                <td>${car.model}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<c:import url="footer.jsp" />

</body>
</html>
