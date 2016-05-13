<%@ include file="header.jsp"%>
<%@ include file="form.jsp"%>
<%@ include file="valideInput.jsp"%>


<div class="container">

	<div class="row ">

		<%
			if (request.getAttribute("error") != null && request.getAttribute("error").equals("newTest")) {
		%>
		<div class="alert alert-success">Valide input</div>
		<%
			} else {
		%>
		<div class="alert alert-info">Set the size and choice
			Collection(s) and/or Map(s) you want to compare</div>
		<%
			}
		%>

	</div>

	<%
		if (request.getAttribute("model") != null) {

			boolean col = false;
			boolean map = false;

			AdapterModel model = (AdapterModel) request.getAttribute("model");
			if (request.getParameterValues("listCollections") != null) {
				col = true;
			}
			if (request.getParameterValues("listMaps") != null) {
				map = true;
			}
	%>

	<div class="row ">
		<div class="col-md-12">
			<h2>Info</h2>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Collection</th>
						<th>Implementation</th>
						<th>Interface</th>
						<th>Sub Class</th>
					</tr>
				</thead>
				<tbody>



					<%
						if (col) {
								Iterator<String> itr = model.getColInfoResult().iterator();
								while (itr.hasNext()) {
					%>
					<tr>
						<td><%=itr.next()%></td>
						<td><%=itr.next()%></td>
						<td><%=itr.next()%></td>
						<td><%=itr.next()%></td>
					</tr>
					<%
						}
							}
					%>
					<%
						if (map) {
								Iterator<String> itrMap = model.getMapInfoResult().iterator();
								while (itrMap.hasNext()) {
					%>
					<tr>
						<td><%=itrMap.next()%></td>
						<td><%=itrMap.next()%></td>
						<td><%=itrMap.next()%></td>
						<td><%=itrMap.next()%></td>
					</tr>
					<%
						}
							}
					%>
				</tbody>
			</table>
		</div>
	</div>



	<div class="row ">
		<div class="col-md-12">
			<h2>Methods</h2>
			<ul class="nav nav-pills">
				<%
					if (col) {
							Iterator<Entry<String, Collection<String>>> itrMethod = model.getColMethodResult().entrySet()
									.iterator();
							while (itrMethod.hasNext()) {
								Entry<String, Collection<String>> mapMethod = itrMethod.next();
				%>
				<li><a href="#<%=mapMethod.getKey()%>" data-toggle="tab"><%=mapMethod.getKey()%></a></li>
				<%
					}
						}
				%>
				<%
					if (map) {
							Iterator<Entry<String, Collection<String>>> itrMethod = model.getMapMethodResult().entrySet()
									.iterator();
							while (itrMethod.hasNext()) {
								Entry<String, Collection<String>> mapMethod = itrMethod.next();
				%>
				<li><a href="#<%=mapMethod.getKey()%>" data-toggle="tab"><%=mapMethod.getKey()%></a></li>
				<%
					}
						}
				%>
			</ul>
			<div class="tab-content">

				<%
					if (col) {
							Iterator<Entry<String, Collection<String>>> itrMethod2 = model.getColMethodResult().entrySet()
									.iterator();
							while (itrMethod2.hasNext()) {
								int i = 1;
								Entry<String, Collection<String>> mapMethod2 = itrMethod2.next();
				%>

				<div class="tab-pane" id="<%=mapMethod2.getKey()%>">
					<div class="row well">
						<%
							for (String method : mapMethod2.getValue()) {
						%>
						<div class="col-sm-3">
							<%=i%>-
							<%=method%>
						</div>


						<%
							i++;
										}
						%>

					</div>
				</div>
				<%
					}
						}
				%>
				<%
					if (map) {
							Iterator<Entry<String, Collection<String>>> itrMethod2 = model.getMapMethodResult().entrySet()
									.iterator();
							while (itrMethod2.hasNext()) {
								int i = 1;
								Entry<String, Collection<String>> mapMethod2 = itrMethod2.next();
				%>

				<div class="tab-pane" id="<%=mapMethod2.getKey()%>">
					<div class="row well">
						<%
							for (String method : mapMethod2.getValue()) {
						%>
						<div class="col-sm-3">
							<%=i%>-
							<%=method%>
						</div>


						<%
							i++;
										}
						%>

					</div>
				</div>
				<%
					}
						}
				%>
			</div>
		</div>
	</div>


	<div class="row ">
		<div class="col-md-12">
			<h2>Speed</h2>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Collection/Map</th>
						<th>Insert (ms)</th>
						<th>Find (ms)</th>
						<th>Remove (ms)</th>
						<th>Size (ini-find-rmv)</th>
					</tr>
				</thead>
				<tbody>

					<%
						if (col) {
								Iterator<String> itrColSpeed = model.getFinaleColSpeedSizeResult().iterator();
								while (itrColSpeed.hasNext()) {
					%>
					<tr>
						<td><%=itrColSpeed.next()%></td>
						<td><%=itrColSpeed.next()%></td>
						<td><%=itrColSpeed.next()%></td>
						<td><%=itrColSpeed.next()%></td>
						<td>(<%=itrColSpeed.next()%>-<%=itrColSpeed.next()%>-<%=itrColSpeed.next()%>)
						</td>
					</tr>
					<%
						}
							}
					%>
					<%
						if (map) {
								Iterator<String> itrMapSpeed = model.getFinaleMapSpeedSizeResult().iterator();
								while (itrMapSpeed.hasNext()) {
					%>
					<tr>
						<td><%=itrMapSpeed.next()%></td>
						<td><%=itrMapSpeed.next()%></td>
						<td><%=itrMapSpeed.next()%></td>
						<td><%=itrMapSpeed.next()%></td>
						<td>(<%=itrMapSpeed.next()%>-<%=itrMapSpeed.next()%>-<%=itrMapSpeed.next()%>)
						</td>
					</tr>
					<%
						}
							}
					%>
				</tbody>
			</table>
		</div>
	</div>



	<div class="row ">
		<div class="col-md-6">
			<h2>Order</h2>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Collection</th>
						<th>Order</th>
					</tr>
				</thead>
				<tbody>


					<%
						if (col) {
								Iterator<String> itrColOrder = model.getFinaleColOrderResult().iterator();
								while (itrColOrder.hasNext()) {
					%>
					<tr>
						<td><%=itrColOrder.next()%></td>
						<td><%=itrColOrder.next()%></td>
					</tr>
					<%
						}
							}
					%>

					<%
						if (map) {
								Iterator<String> itrMapOrder = model.getFinaleMapOrderResult().iterator();
								while (itrMapOrder.hasNext()) {
					%>
					<tr>
						<td><%=itrMapOrder.next()%></td>
						<td><%=itrMapOrder.next()%></td>
					</tr>
					<%
						}
							}
					%>
				</tbody>
			</table>
		</div>
		<div class="col-md-6">
			<h2>Allowing Duplicate & Null</h2>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Collection/Map</th>
						<th>Duplicate</th>
						<th>Null</th>
					</tr>
				</thead>
				<tbody>


					<%
						if (col) {
								Iterator<String> itrColDup = model.getFinaleColDuplicateNullResult().iterator();
								while (itrColDup.hasNext()) {
					%>
					<tr>
						<td><%=itrColDup.next()%></td>
						<td><%=itrColDup.next()%></td>
						<td><%=itrColDup.next()%></td>
					</tr>
					<%
						}
							}
					%>
					<%
						if (map) {
								Iterator<String> itrMapDup = model.getFinaleMapDuplicateNullResult().iterator();
								while (itrMapDup.hasNext()) {
					%>
					<tr>
						<td><%=itrMapDup.next()%></td>
						<td><%=itrMapDup.next()%></td>
						<td><%=itrMapDup.next()%></td>
					</tr>
					<%
						}
							}
					%>
				</tbody>
			</table>
		</div>
	</div>

	<%
		}
	%>

</div>

<!-- end row content -->

<%@ include file="footer.jsp"%>
