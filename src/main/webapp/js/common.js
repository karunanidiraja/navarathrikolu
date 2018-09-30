$(document).ready(function() {
	/*$('#appDataTable tfoot th').each( function () {
		var title = $(this).text();
		if(!$(this).hasClass('no_search')) {
			$(this).html( '<input type="text" placeholder="Search '+title+'" />' );
		}
	} );*/

	// DataTable
	var table = $('#appDataTable').DataTable( {
		//"scrollY": 200,
		//"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
		"lengthChange": false
		
	} );

	$('.dataTable').wrap('<div class="dataTables_scroll" />');
	
	$('#appDataTable_wrapper input').addClass('browser-default');

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
	
	$('select').formSelect();
	modal();
	$('textarea').characterCounter();
} );

function modal() {
	var elems = document.querySelectorAll('.modal');
	var options = {opacity: 0.9, dismissible: false};
    var instances = M.Modal.init(elems, options);
    //instances.open();
}

function ajaxCall(url, resultObj) {
	$.ajax({
		url: url,
		beforeSend: function() {
			onLoader();
		},
		success: function(result) {
			resultObj.html(result);
			reInitFields();
		},
		complete: function() {
			onLoaderComplete();
		}
	});
}

function ajaxCallModal(modalId, resultId, url) {
	$('#' + modalId).modal('open');
	$.ajax({
		url: url,
		beforeSend: function() {
			$('#' + resultId).hide();
			onModalLoader();
		},
		success: function(result) {
			$('#' + resultId).html(result);
			reInitFields();
		},
		complete: function() {
			onModalLoaderComplete();
			$('#' + resultId).show();
		}
	});
}

function ajaxCallInModal(resultId, url) {
	$.ajax({
		url: url,
		beforeSend: function() {
			$('#modalContent').hide();
			onModalLoader();
		},
		success: function(result) {
			$('#' + resultId).html(result);
			reInitFields();
		},
		complete: function() {
			onModalLoaderComplete();
			$('#modalContent').show();
		}
	});
}

function ajaxFormSubmitInModal(formId, resultId, url) {
	var form = $('#' + formId);
	$.ajax({
		type: "POST",
		url: url,
		data: form.serializeArray(),
		beforeSend: function() {
			$('#modalContent').hide();
			onModalLoader();
		},
		success: function(result) {
			$('#' + resultId).html(result);
			reInitFields();
		},
		complete: function() {
			onModalLoaderComplete();
			$('#modalContent').show();
		}
	});
}

function reInitFields() {
	$('select').formSelect();
	$('textarea').characterCounter();
	M.updateTextFields();
}