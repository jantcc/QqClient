package com.qq.client.view;
import java.awt.*;

import com.qq.client.model.*;
import com.qq.common.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

import com.qq.common.Message;
public class QqChat extends JFrame implements ActionListener,Runnable{
	JTextArea jta;
	JPanel jp1;
	JComboBox jcb;
	JTextField jft;
	JButton jb;
	JScrollPane jsp;
	String owerid;
	String friend;

	public QqChat(String owerid,String friend){
		this.owerid=owerid;
		this.friend=friend;
		jp1 = new JPanel();
		jta = new JTextArea();
		jft = new JTextField(10);
		jb = new JButton("发送");
		jb.addActionListener(this);
		jsp = new JScrollPane(jta);
		
		jp1.add(jft);
		jp1.add(jb);
		this.add(jsp);
		this.add(jp1,BorderLayout.SOUTH);
		
		this.setIconImage(new ImageIcon("images/QQ.jpg").getImage());
		this.setTitle("QQ号:"+owerid+"正在和"+friend+"聊天");
		this.setSize(400,200);
		this.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==jb){
			//如果用户点击了发送按钮
			Message ms = new Message();
			ms.setSender(owerid);
			ms.setGetter(friend);
			ms.setCon(jft.getText());
			ms.setSenttime(new java.util.Date().toString());
			//发送给服务器
			try {
				ObjectOutputStream oos =new ObjectOutputStream(QqClientConServer.s.getOutputStream());
				oos.writeObject(ms);
			} catch (Exception e1) {
				e1.printStackTrace();
				// TODO: handle exception
			}
			
			
		}
	}

	public void run() {
		// TODO 自动生成的方法存根
		while(true){
			try {
				ObjectInputStream ois = new ObjectInputStream(QqClientConServer.s.getInputStream());
				Message m = (Message) ois.readObject();
				String info = m.getSender()+" 对"+m.getGetter()+" 说"+m.getCon()+"\r\n";
				this.jta.append(info);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
		}
	}
}
