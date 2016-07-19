/**
 * 这是客户端连接服务器的后台
 */
package com.qq.client.model;
import java.util.*;
import java.net.*;
import java.awt.event.*;
import java.io.*;

import com.qq.common.Message;
public class QqClientConServer {

	public static Socket s;
	public boolean sendLoginInfoToServer(Object o){
		 boolean b = false;
		try {
			 s = new Socket("127.0.0.1",9999);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			Message ms = (Message) ois.readObject();
			if(ms.getMesType().equals("1")){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return b;
	}	
	
}
