package com.websocket.controller;

import java.security.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
public class WebSocketController {
	
	//private SimpMessagingTemplate template;
	private Timestamp time;

	/*@Autowired
	public WebSocketController(SimpMessagingTemplate template) {
		this.template = template;
	}*/
	
	 @MessageMapping("/game/{id}")
	    public void onMessage(@DestinationVariable String id,Message<SockJsJavaClient> message) {
	        System.out.println("reached");
	        System.out.println(id);
	        System.out.println(message);
	    }
	
	@MessageMapping("/greeting")
	//@RequestMapping(path="/greeting", method=RequestMethod.GET)
		public String handle(String greeting) {
			greeting = "Hello from Java";
			return "[" + time.getTimestamp() + ": " + greeting;
		}
	
	//the return value of handle() is passed through the "brokerChannel" as a message to "/topic/greeting"
	
	//@SendTo("/topic") if oone wants to change the destination of the resply to another url other the the one it came in from e.g. /greeting
	

/*	@RequestMapping(path="/greetings", method=RequestMethod.POST)
	public void greet(String greeting) {
		greeting = "Hello from DB";
		String text = "[" + time.getTimestamp() + "]:" + greeting;
		this.template.convertAndSend("/topic/greetings", text);
	}	
	
	//@MessageMapping("/portfolio")
	@MessageMapping("/greetings")
	@SendTo("/topic")
	public String message() {
		return "Added";
	}*/
	
	@GetMapping("/client")
	public void home() {
		//mod.addAttribute("id", "client");
	}
}
