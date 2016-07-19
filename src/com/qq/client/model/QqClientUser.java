package com.qq.client.model;
import com.qq.common.*;
public class QqClientUser {
	
	public boolean CheckUser(User u){
		return new QqClientConServer().sendLoginInfoToServer(u);
	}
}
