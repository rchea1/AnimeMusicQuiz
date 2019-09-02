'use strict';

var $userRegistration = $("#userRegistration");
var $animeQuiz = $("#animeQuiz");
var $usernameForm = $("#usernameForm");
var $usernameInput = $("#username");

var username;
var stompClient;

function connect(event) {
	username = $usernameInput.val().trim();
	
	if(username) {
		$userRegistration.hide();
		$animeQuiz.show();
		
		var socket = new SockJS("/ws");
		stompClient = Stomp.over(socket);
		
		stompClient.connect({}, onConnected, onError);
		startGame();
	}
	
	event.preventDefault();
}

function onConnected() {
	stompClient.subscribe('/topic/public', onMessageReceived);
	
	stompClient.send("/quiz/quiz.register", {}, username);
}

function onMessageReceived(payload) {
	console.log(payload);
}

function sendMessage(event) {
	var userAnswer = $("#userAnswer").val().trim();
	if(userAnswer && stompClient) {
		stompClient.send("/quiz/quiz.send", {}, userAnswer);
		$("#userAnswer").val("");
	}
	event.preventDefault();
}

function onError(error) {
	alert("Could not connect to WebSocket server.");
}

document.querySelector("#usernameForm").addEventListener("submit", connect, true);

$("#userAnswer").keypress(function(e) {
	if(e.keyCode == 13) {
		console.log("press");
		sendMessage(e);
	}
})