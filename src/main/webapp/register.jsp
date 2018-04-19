<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>

<c:import url="head.jsp" />

<html>

<body>

<form id="rendered-form">
    <div class="rendered-form">
        <div class="fb-text form-group field-email">
            <label for="email" class="fb-text-label">Email<span class="fb-required">*</span></label>
            <input type="email" class="form-control" name="email" maxlength="50" id="email" required="required" aria-required="true">
        </div>
        <div class="fb-text form-group field-password">
            <label for="password" class="fb-text-label">Password<span class="fb-required">*</span></label>
            <input type="password" class="form-control" name="password" maxlength="25" id="password" required="required" aria-required="true">
        </div>
        <div class="fb-text form-group field-confirm">
            <label for="confirm" class="fb-text-label">Password<span class="fb-required">*</span></label>
            <input type="password" class="form-control" name="confirm" maxlength="25" id="confirm" required="required" aria-required="true">
        </div>
    </div>
</form>

<c:import url="footer.jsp" />


<script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.js"></script>
<script type="text/javascript" src="source/js/myscript.js"></script> <script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="source/js/myscript.js"></script>
<script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.1.11.js"></script>
</body>
</html>