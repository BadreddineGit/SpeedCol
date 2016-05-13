<%@ include file="header.jsp"%>
<div class="container">

<div class="jumbotron">
<h1 class="text-center"> This is How We Test Collections And Maps</h1>
  <p></p>
</div>

        <div class="row">
            <!-- Row of Insert Speed-->
            <div class="col-lg-6">
                <h3>
                        <kbd>Speed Of Collections</kbd>
                    </h3>
                <kbd>Insert</kbd>
                <pre>
 public double insertSpeed(Collection&lt;Model&gt; collection, Collection&lt;Model&gt; colToAdd) {

      double start = System.nanoTime();
      collection.addAll(colToAdd);
      double end = System.nanoTime();

      return difference(start, end);
}
</pre>
<kbd>Find</kbd>
              <pre>
 public double findSpeed(Collection&lt;Model&gt; collection, Model model) {

        double diff = 0;

        double start = System.nanoTime();
        if (collection.contains(model)) {
            double end = System.nanoTime();
            diff = difference(start, end);
          }
        return diff;
  }
</pre>
<kbd>Remove</kbd>
                <pre>
 public double removeSpeed(Collection&lt;Model&gt; collection, int position) {

        double start = 0;
        double end = 0;
        int i = 0;

        Iterator&lt;Model&gt; itr = collection.iterator();

        while (itr.hasNext()) {
            itr.next();
            if (i == position) {
                start = System.nanoTime();
                itr.remove();
                end = System.nanoTime();
                }
            i++;
          }
        return difference(start, end);
  }
</pre>


<h3><kbd>Order Of Collections</kbd></h3>
<kbd>order</kbd>
<pre>
public boolean verifieOrderCol(Collection&lt;Model&gt; collection, Model[] models){

	boolean order = true;
	int i = 0;
  	Iterator&lt;Model&gt; itr = collection.iterator();
  	while (itr.hasNext()) {
	    if (!models[i].equals(itr.next())) {
	      order = false;
	      break;
	    }
    	i++;
  	}
  	return order;
 }
</pre>


<h3><kbd>Allowing Duplicate And Null in Collections</kbd></h3>
<kbd>Duplicate And Null</kbd>
<pre>
 public Collection&lt;Boolean&gt; duplicateAndNullCollections(Map&lt;String, Collection&lt;Model&gt;&gt; collections) {

	Iterator&lt;Entry&lt;String, Collection&lt;Model&gt;&gt;&gt; itr = collections.entrySet().iterator();

	while (itr.hasNext()) {

		dupliacteNull = new ArrayList&lt;Boolean&gt;();
		boolean acceptDoublon;
		boolean acceptNull;

		Entry&lt;String, Collection&lt;Model&gt;&gt; map = itr.next();
		Collection&lt;Model&gt; collection = map.getValue();
		int initialSize = collection.size();

		collection.addAll(data.addDuplicateDataCollection(collection));

		if (initialSize != collection.size()) {
			acceptDuplicate = true;
		} else {
			acceptDuplicate = false;
		}

		try {
			collection.add(null);
			acceptNull = true;
		} catch (Exception e) {
			acceptNull = false;
		}

		duplicateNull.add(acceptDoublon);
		duplicateNull.add(acceptNull);
		}
		
	return doublonNull;
}
</pre>

</div><!-- End col-6 collection -->

<div class="row">

            <div class="col-lg-6">
                <h3>
                        <kbd>Speed Of Maps</kbd>
                    </h3>
                <kbd>Insert</kbd>
                <pre>
 public double insertSpeed(Map&lt;Integer, Model&gt; map, Map&lt;Integer, Model&gt; mapToAdd) {

      double start = System.nanoTime();
      map.putAll(mapToAdd);
      double end = System.nanoTime();

      return difference(start, end);
}
</pre>


                <kbd>Find</kbd>
                <pre>
 public double findSpeed(Map&lt;Integer, Model&gt; map, Model model) {

      double diff = 0;

      double start = System.nanoTime();
      if (map.containsValue(model)) {
          double end = System.nanoTime();
          diff = difference(start, end);
        }
      return diff;
}
</pre>


            <kbd>Remove</kbd>
            <pre>
 public double removeSpeed(Map&lt;Integer, Model&gt; map, int position) {

      double start = 0;
      double end = 0;
      int i = 0;

      Iterator&lt;Entry&lt;Integer, Model&gt;&gt; itr = map.entrySet().iterator();

      while (itr.hasNext()) {
        itr.next();
        if (i == position) {
            start = System.nanoTime();
            itr.remove();
            end = System.nanoTime();
            }
        i++;
        }
      return difference(start, end);
}
</pre>


<h3><kbd>Order of Maps</kbd></h3>
<kbd>order</kbd>
<pre>
 public boolean verifieOrderMap(Map&lt;Integer, Model&gt; map, Model[] models) {

	boolean order = true;
	int i = 0;
	Iterator&lt;Entry&lt;Integer, Model&gt;&gt; itr = map.entrySet().iterator();
	while (itr.hasNext()) {
		if (!models[i].equals(itr.next().getValue())) {
			order = false;
      break;
    }
    i++;
  }
  return order;
}
</pre>

<h3><kbd>Allowing Duplicate And Null in Maps</kbd></h3>
<kbd>Duplicate And Null</kbd>
<pre>
public Collection&lt;Boolean&gt; duplicateAndNullMaps(Map&lt;String, Map&lt;Integer, Model&gt;&gt; maps) {

	Iterator&lt;Entry&lt;String, Map&lt;Integer, Model&gt;&gt;&gt; itr = maps.entrySet().iterator();

	while (itr.hasNext()) {
	
		duplicateNull = new ArrayList&lt;Boolean&gt;();
		boolean acceptDuplicate;
		boolean acceptNull;

		Entry&lt;String, Map&lt;Integer, Model&gt;&gt; m = itr.next();
		Map&lt;Integer, Model&gt; map = m.getValue();
		int initialSize = map.size();

		map.putAll(data.addDoubleDataMap(map));

		if (initialSize != map.size()) {
			acceptDuplicate = true;
		} else {
			acceptDuplicate = false;
		}

		try {
			map.put(map.size() + 1, null);
			acceptNull = true;
		} catch (Exception e) {
			acceptNull = false;
		}
			
		duplicateNull.add(acceptDuplicate);
		duplicateNull.add(acceptNull);
		}
		
	return duplicateNull;
}
</pre>


            </div>
        </div>

    </div>
    </div>
<%@ include file="footer.jsp"%>