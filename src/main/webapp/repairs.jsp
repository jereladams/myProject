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
            <th>ServiceDate</th>
            <th>Invoice#</th>
            <th>ServiceProvider</th>
            <th>LaborCost</th>
            <th>CurrentMileage</th>
            <th>Warranty</th>
            <th>ServicePerformed</th>
            <th>Description</th>
            <th>CreateTime</th>
            <th>UpdateTime</th>
        </tr>

        <c:forEach var="repair" items="${repairs}" >
            <tr>
                <td>${repair.id}</td>
                <td>${repair.serviceDate}</td>
                <td>${repair.invoiceNumber}</td>
                <td>${repair.serviceProvider}</td>
                <td>${repair.laborCost}</td>
                <td>${repair.currentMileage}</td>
                <td>${repair.warranty}</td>
                <td>${repair.servicePerformed}</td>
                <td>${repair.description}</td>
                <td>${repair.createTime}</td>
                <td>${repair.updateTime}</td>
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
