function startGame() {
	$("#startButton").hide();
	if(themesList.length === 0) {
		window.location.pathname = "/quiz/";
	}
	
	var game = roundSetup();

	var theme = game.theme;
	var url = game.url;
	var animeTitle = game.animeTitle;

	$("#container").show();
	loadVideoPlayer(url);
	
	setTimeout(function() {
		checkAnswer(animeTitle);
		restartPlayback(0, animeTitle);
		
		setTimeout(function() {
			startGame();
		}, 15000);
		
	}, 15000);	
}

function restartPlayback(time, animeTitle) {
	$("#videoBlock").hide();
	$("#videoPlayer").show();
	$("#userAnswer").prop("disabled", true);
	$("#animeTitle").html(animeTitle);

	var video = document.getElementById('videoPlayer');
	videoPlayer.pause();
	videoPlayer.currentTime = time;
	video.load();
}

function loadVideoPlayer(videoUrl) {
	$("#videoPlayer").attr('src', videoUrl);
	$("#videoPlayer")[0].load();
}

function retrieveRandomTheme(themes) {
	return themes[Math.floor(Math.random()*themes.length)];
}

function checkAnswer(animeTitle) {
	var userAnswer = $("#userAnswer").val();
	if(userAnswer === "") {
		$("#animeTitle").css("color", "red");
	}
	if(userAnswer.toLowerCase() === animeTitle.toLowerCase()) {
		$("#animeTitle").css("color", "green");
	}
	else {
		$("#animeTitle").css("color", "red");
	}
}

function roundSetup() {
	$("#userAnswer").prop("disabled", false);
	$("#videoPlayer").hide();
	$("#videoBlock").show();
	$("#userAnswer").val("");
	$("#animeTitle").css("color", "black");
	$("#animeTitle").html("Guessing Phase...");

	var theme = themesList.pop();
	var url = theme.url;
	var animeTitle = theme.anime.title;
	
	var game = {
		theme: theme,
		url: url,
		animeTitle: animeTitle
	};
	
	return game;
}