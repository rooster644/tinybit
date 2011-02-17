//coming soon.
$('#progress').center();
	$(window).bind('resize', function() {
		$('#progress').center({transition:300});
	});
$.ajax({
	url: "/session"
})

