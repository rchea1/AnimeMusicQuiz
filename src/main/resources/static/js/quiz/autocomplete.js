var input = document.getElementById("userAnswer");

var awesomplete = new Awesomplete(input, {
	minChars: 2,
	maxItems: 25,
	autoFirst: true
});

$(input).on("keyup", function() {
	$.ajax({
		url: '/api/retrieveTitles',
		type: 'GET',
		dataType: 'json',
		success: function(data) {
			var titles = [];
			$.each(data, function(key, value) {
				titles.push(value);
			})
			awesomplete.list = titles;
		}
	})
})