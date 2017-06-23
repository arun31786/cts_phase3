package com.domshom.webSocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/websocket")
public class WebSocketTest {

  private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
  
  @OnMessage
  public String onMessage(String message, Session session) throws IOException {
    
    synchronized(clients){
      // Iterate over the connected sessions
      // and broadcast the received message
      for(Session client : clients){
        if (!client.equals(session)){
/*        	
        	System.out.println("Server received message");
        	System.out.println("Server sending message : Hello "+message);
*/        	
        	
        	System.out.println("received message : "+message);
        	
        	// write to other clients
          client.getBasicRemote().sendText(message +" received by server");
        }
      }
    }
    return message;	// returns to current client
  }
  
  @OnOpen
  public void onOpen (Session session) {
  // Add session to the connected sessions set
    clients.add(session);
    System.out.println("new session is added");
  }

  @OnClose
  public void onClose (Session session) {
    // Remove session from the connected sessions set
    clients.remove(session);
    System.out.println("Session is removed");
  }
  

}