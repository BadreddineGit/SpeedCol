		<!-- start content -->
<div class="container">
		<div class="jumbotron">
			<form class="" action="AppServlet" method="post">
				<div class="text-center">
					<h1 style="margin-bottom : 20px;">Collection and Map</h1>
					<p>Test and compare Collections and/or Maps in JAVA</p>
					<div class="row">
						<div class="col-md-4 col-md-offset-4">
							<div class="input-group">
								<span class="input-group-addon">Integer</span> <input
									type="text" class="form-control" name="nbr"
									placeholder="size of collection" /> 
									<span class="input-group-btn"><button
										type="submit" class="btn btn-success">Start Test</button></span>
							</div>
						</div>
					</div>
				</div>

				<div class="row" style="margin-top: 15px;">
					<div class="col-md-3 col-md-offset-3">
						<div class="form-group">
							<label for="cols">Collections</label> <select
								class="form-control" name="listCollections" id="cols" multiple>
								<option value="arraylist">ArrayList</option>
								<option value="linkedlist">Linkedlist</option>
								<option value="vector">Vector</option>
								<option value="hashSet">HashSet</option>
								<option value="linkedhashSet">LinkedhashSet</option>
								<!-- <option value="treeSet">TreeSet</option>-->
							</select>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<label for="maps">Maps</label> <select class="form-control"
								name="listMaps" id="maps" multiple>
								<option value="LinkedHashMap">LinkedHashMap</option>
								<option value="hashMap">HashMap</option>
								<option value="hashTable">HashTable</option>
								<option value="treeMap">TreeMap</option>
							</select>
						</div>
					</div>
				</div>
			</form>
		</div>	
	</div>