$("#login-btn").click(function() {
	var lc = $("#lc");
	lc.fadeIn(300);
	lc.find('.login-content').addClass('bounceIn');

	return false;
});
$(".close").click(function(event) {
	var lc = $("#lc");
	lc.fadeOut(300);
	lc.find('.login-content').removeClass('bounceIn');

	return false;
});