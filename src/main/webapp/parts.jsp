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
            <th>Part</th>
            <th>Manufacturer#</th>
            <th>Part#</th>
            <th>Warranty</th>
            <th>Supplier</th>
            <th>Price</th>
            <th>Description</th>
        </tr>

        <c:forEach var="part" items="${parts}" >
            <tr>
                <td>${part.id}</td>
                <td>${part.partName}</td>
                <td>${part.manufacturer}</td>
                <td>${part.partNumber}</td>
                <td>${part.warranty}</td>
                <td>${part.supplier}</td>
                <td>${part.price}</td>
                <td>${part.description}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<c:import url="footer.jsp" />

<script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.js"></script>
<script type="text/javascript" src="source/js/myscript.js"></script> <script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="source/js/myscript.js"></script>
<script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.1.11.js"></script>
</body>
</html>

