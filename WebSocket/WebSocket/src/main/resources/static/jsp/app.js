 	var stompClient = null;
 	
 	function connect() {
        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function(frame) {
        	setConnected(true)
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/greetings', function(greeting) {
            	showGreeting(JSON.parse(greeting.body).content);
            });

        });
    }
 	
		function setConnected(connected){
			$("#connect").prop("disabled", connected);
			if(connected){
				console.log('connected');
				alert('connected!');
			}
			else{
				console.log('disconnected');
				alert('disconnected')
			}
			$("#greetings").html("");
		}

	    
	    function disconnect() {
	    	if(stompClient !== null){
	    		stompClient.disconnect();		       
	    	}
	        setConnected(false);
	        console.log("Disconnected");
	    }
		    
	    
	    function sendName(){
	    	stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
	    }
	    
	    function showGreeting(message){
	    	$("#greetings").append("<tr><td>" + message + "</td></tr>");
	    }
	    
	    $(function(){
	    	$("form").on('submit', function(e) {
	    		e.preventDefault();
	    	});
	    	$("#disconnect" ).click(function(){
	    		connect();
	    	});
	    	$("#connect" ).click(function(){
	    		disconnect();
	    	});
	    	$("#send" ).click(function(){
	    		sendName();
	    	});
	    });
















/*
function printOnConsole(){	
	console.log('Hello World');
}

function printHelloWorld(name ){
	document.write('Hello world: from ' +  name);
}
//printHelloWorld('Bremen');



//On the browser side, a client might connect as follows using stomp.js and the sockjs-client:
	/*var socket = new SockJS("/spring-websocket-portfolio/portfolio");
	var stompClient = Stomp.over(socket);

	stompClient.connect({}, function(frame) {
		
	}*/
	
	
	//Or if connecting via WebSocket (without SockJS):
	/*var socket = new WebSocket("ws://localhost:8090/portfolio");
	var stompClient = Stomp.over(socket);

	stompClient.connect({}, function(frame) {
		
	}*/
	/*
	
	 function WebSocketTest() {
         document.write('Entered');
         if ("WebSocket" in window) {
            alert("WebSocket is supported by your Browser!");
            
            // Let us open a web socket
            var ws = new WebSocket("http://localhost:8090/portfolio");
				
            ws.onopen = function() {
               
               // Web Socket is connected, send data using send()
               ws.send("Message to send"); // to "/topic/greeting" pass through the "clientInboundChannel" and are forwarded to the broker.
               alert("Message is sent..."); // "/app/greeting" pass through the "clientInboundChannel" and are forwarded to the GreetingController
            };
				
            ws.onmessage = function (evt) { 
               var received_msg = evt.data;
               alert("Message is received...");
            };
				
            ws.onclose = function() {                
               // websocket is closed.
               alert("Connection is closed..."); 
            };
         } else {
           
            // The browser doesn't support WebSocket
            alert("WebSocket NOT supported by your Browser!");
         }
      }
	
	
	 
	 function connect_Ex() {
	        var socket = new SockJS('http://localhost:8090/portfolio');
	        stompClient = Stomp.over(socket);
	        console.log('attempt to connect: ' +stompClient!=null);
	        console.log('session id: '+ "${pageContext.session.id}");

	        stompClient.connect('', '', function(frame) {
	            console.log('Connected: ' + frame);
	            stompClient.subscribe('/topic/greetings/', function(result) {
	                getResult(result);
	            });

	        });
	    }

	    function getResult(result) {
	       var isControlable= JSON.parse(greeting.body).isControlable;
	        if (isControlable) {
	            alert('Control was already gained')
	        } else {
	            $("#control_mode").prop("checked", true);
	        }
	    }*/


	    
	    //starts here
	
	
	
/*
function sayHelloToThisPerson(name){
	alert('hello : ' + name);
}

//run above js function when this js is loaded
sayHelloToThisPerson('mkyong');*/
