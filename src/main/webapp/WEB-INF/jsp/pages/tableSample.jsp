<%@ taglib prefix="s" uri="/struts-tags"%>

<table id="appDataTable" class="display dataTable cell-border nowrap" style="width:100%">
    <thead>
        <tr>
        	<th></th>
            <th>Name</th>
            <th>Position</th>
            <th>Office</th>
            <th>Age</th>
            <th>Start date</th>
            <th>Salary</th>
        </tr>
    </thead>
    <tfoot>
        <tr>
        	<th class="no_search"></th>
            <th class="search_required">Name</th>
            <th class="search_required">Position</th>
            <th class="search_required">Office</th>
            <th>Age</th>
            <th>Start date</th>
            <th>Salary</th>
        </tr>
    </tfoot>
    <tbody>
    	<s:iterator begin="1" end="100" status="stat">
	        <tr>
	        	<td>${stat.index+1}</td>
	            <td class="dt-body-center"><button class="btn waves-effect waves-light" type="button">Tiger Nixon
	            	<i class="material-icons right">create</i>
	            </button></td>
	            <td>System Architect</td>
	            <td>Edinburgh</td>
	            <td>61</td>
	            <td>2011/04/25</td>
	            <td>$320,800</td>
	        </tr>
		</s:iterator>
    </tbody>
</table>