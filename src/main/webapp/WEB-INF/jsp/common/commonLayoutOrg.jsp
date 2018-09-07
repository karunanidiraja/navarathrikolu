<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%-- Show usage; Used in Header --%>
<tiles:importAttribute name="title" scope="request" />
<html>
<head>
	<title><tiles:getAsString name="appName" /> - <tiles:getAsString name="title" /></title>
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/materialize-1.0.0-rc.2/css/materialize.css" media="screen,projection" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<s:head theme="simple" />
	
	
	<link type="text/css" rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" />
</head>
<body>
	<div>
		<tiles:insertAttribute name="header" />
	</div>
	<div>
		<tiles:insertAttribute name="body" />
	</div>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/materialize-1.0.0-rc.2/js/materialize.js"></script>
	
	
	
	
	
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	<script src="https://code.highcharts.com/modules/export-data.js"></script>


	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	
	
	
	
	
	<script type="text/javascript">
	Highcharts.chart('container', {
	    chart: {
	        type: 'column'
	    },
	    title: {
	        text: 'Stacked column chart'
	    },
	    credits: {
	        enabled: false
	    },
	    exporting: {
	    	enabled: false
	    },
	    xAxis: {
	        categories: ['Apples', 'Oranges', 'Pears', 'Grapes', 'Bananas']
	    },
	    yAxis: {
	        min: 0,
	        title: {
	            text: 'Total fruit consumption'
	        }
	    },
	    tooltip: {
	        pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b> ({point.percentage:.0f}%)<br/>',
	        shared: true
	    },
	    plotOptions: {
	        column: {
	            stacking: 'percent'
	        }
	    },
	    series: [{
	        name: 'John',
	        data: [5, 3, 4, 7, 2]
	    }, {
	        name: 'Jane',
	        data: [2, 2, 3, 2, 1]
	    }, {
	        name: 'Joe',
	        data: [3, 4, 4, 2, 5]
	    }]
	});


	Highcharts.chart('container-pie', {

	    title: {
	        text: 'Pie point CSS'
	    },
	    credits: {
	        enabled: false
	    },
	    exporting: {
	    	enabled: false
	    },
	    xAxis: {
	        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
	    },
	    series: [{
	        type: 'pie',
	        allowPointSelect: true,
	        keys: ['name', 'y', 'selected', 'sliced'],
	        data: [
	            ['Apples', 29.9, false],
	            ['Pears', 71.5, false],
	            ['Oranges', 106.4, false],
	            ['Plums', 129.2, false],
	            ['Bananas', 144.0, false],
	            ['Peaches', 176.0, false],
	            ['Prunes', 135.6, true, true],
	            ['Avocados', 148.5, false]
	        ],
	        showInLegend: true
	    }]
	});


	Highcharts.chart('container-combined', {
	    title: {
	        text: 'Combination chart'
	    },
	    credits: {
	        enabled: false
	    },
	    exporting: {
	    	enabled: false
	    },
	    xAxis: {
	        categories: ['Apples', 'Oranges', 'Pears', 'Bananas', 'Plums']
	    },
	    labels: {
	        items: [{
	            html: 'Total fruit consumption',
	            style: {
	                left: '50px',
	                top: '18px',
	                color: (Highcharts.theme && Highcharts.theme.textColor) || 'black'
	            }
	        }]
	    },
	    series: [{
	        type: 'column',
	        name: 'Jane',
	        data: [3, 2, 1, 3, 4]
	    }, {
	        type: 'column',
	        name: 'John',
	        data: [2, 3, 5, 7, 6]
	    }, {
	        type: 'column',
	        name: 'Joe',
	        data: [4, 3, 3, 9, 0]
	    }, {
	        type: 'spline',
	        name: 'Average',
	        data: [3, 2.67, 3, 6.33, 3.33],
	        marker: {
	            lineWidth: 2,
	            lineColor: Highcharts.getOptions().colors[3],
	            fillColor: 'white'
	        }
	    }, {
	        type: 'pie',
	        name: 'Total consumption',
	        data: [{
	            name: 'Jane',
	            y: 13,
	            color: Highcharts.getOptions().colors[0] // Jane's color
	        }, {
	            name: 'John',
	            y: 23,
	            color: Highcharts.getOptions().colors[1] // John's color
	        }, {
	            name: 'Joe',
	            y: 19,
	            color: Highcharts.getOptions().colors[2] // Joe's color
	        }],
	        center: [100, 80],
	        size: 100,
	        showInLegend: false,
	        dataLabels: {
	            enabled: false
	        }
	    }]
	});
	
	$(document).ready(function() {
		$('#example tfoot th').each( function () {
	        var title = $(this).text();
	        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
	    } );
	 
	    // DataTable
	    var table = $('#example').DataTable( {
	        //"scrollY": 200,
	        //"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
	        "lengthChange": false,
	        //"searching": false,
	        "scrollX": true
	    } );
	 
	    $('#example_wrapper input').addClass('browser-default');
	    
	    // Apply the search
	    table.columns().every( function () {
	        var that = this;
	 
	        $( 'input', this.footer() ).on( 'keyup change', function () {
	            if ( that.search() !== this.value ) {
	                that
	                    .search( this.value )
	                    .draw();
	            }
	        } );
	    } );
		
	    
	} );

	</script>
</body>
</html>