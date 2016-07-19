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
		jb = new JButton("����");
		jb.addActionListener(this);
		jsp = new JScrollPane(jta);
		
		jp1.add(jft);
		jp1.add(jb);
		this.add(jsp);
		this.add(jp1,BorderLayout.SOUTH);
		
		this.setIconImage(new ImageIcon("images/QQ.jpg").getImage());
		this.setTitle("QQ��:"+owerid+"���ں�"+friend+"����");
		this.setSize(400,200);
		this.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getSource()==jb){
			//����û�����˷��Ͱ�ť
			Message ms = new Message();
			ms.setSender(owerid);
			ms.setGetter(friend);
			ms.setCon(jft.getText());
			ms.setSenttime(new java.util.Date().toString());
			//���͸�������
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
		// TODO �Զ����ɵķ������
		while(true){
			try {
				ObjectInputStream ois = new ObjectInputStream(QqClientConServer.s.getInputStream());
				Message m = (Message) ois.readObject();
				String info = m.getSender()+" ��"+m.getGetter()+" ˵"+m.getCon()+"\r\n";
				this.jta.append(info);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
		}
	}
}
