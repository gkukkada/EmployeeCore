/**
 * 
 */
(function($) {
	var report = $('.report');
	var modal = $('#modal');
	var form = $('form');
	form.on('submit',function(event){
		form.find('#empid').val($('table tbody td:nth-child(3)').text().trim());
	});
	modal
	.on('shown.bs.modal', function(event){
		console.log($(this));
	})
	.on('click','.yes', function(event){
		event.preventDefault();
	})
	.on('click','.no', function(event){
		console.log($(this));
		event.preventDefault();
	});
	
})(jQuery);