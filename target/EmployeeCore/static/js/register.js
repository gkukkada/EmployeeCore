/**
 * 
 */
(function($) {
	var register = $('.register')
		uname = register.find('#username')
		pwd = register.find('#password')
		pwd_confirm = register.find('#password_confirm')
	;
	uname.on('change', function(){
		console.log($(this).val());
	});
	pwd.on('change', function() {
		var target = $(this);
		if (target.val().length < 6) {
			target.parent().parent().addClass('has-warning');
			register.find('.reg').addClass('disabled');
			target.focus();
		} else {
			target.parent().parent().removeClass('has-warning');
			register.find('.reg').removeClass('disabled');
		}
	});

	pwd_confirm.on('change', function() {
		var target = $(this);
		if (target.val() == pwd.val()) {
			target.parent().parent().removeClass('has-warning');
			target.siblings('.alert').addClass('hidden');
			register.find('.reg').removeClass('disabled');
		} else {
			target.parent().parent().addClass('has-warning');
			target.siblings('.alert').removeClass('hidden');
			target.focus();
			register.find('.reg').addClass('disabled');
		}
	});
	
	register
	.on('submit', 'form', function(event){
		if(uname.val().length==0){
			alert("Oops!!. You have missed Username");
			uname.focus();
			event.preventDefault();
			
		} else if(pwd.val().length==0){
			alert("Oops!!. You forgot to enter Password.");
			pwd.focus();
			event.preventDefault();
		} else if(pwd_confirm.val().length==0){
			alert("Oops!!. You forgot to confirm Password.");
			pwd_confirm.focus();
			event.preventDefault();
		}
	});

})(jQuery);