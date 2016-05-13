<div class="container">
<%
	if (request.getAttribute("error") != null && request.getAttribute("error").equals("noInteger")) {
%>
<div class="alert alert-danger">The number is null or not valide</div>
<%
	} else if (request.getAttribute("error") != null && request.getAttribute("error").equals("noValidNum")) {
%>
<div class="alert alert-danger">The number must be between 10 and 1 000 000</div>
<%
	}
	if (request.getAttribute("error") != null && request.getAttribute("error").equals("noCollection")) {
%>
<div class="alert alert-danger">You must select Collection(s) and/or Map(s)</div>
<%
	}
%>
</div>