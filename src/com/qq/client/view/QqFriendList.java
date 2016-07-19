package com.qq.client.view;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class QqFriendList extends JFrame implements ActionListener,MouseListener {
	CardLayout card = new CardLayout();
	//处理第一张卡片
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2,jb3;
	JScrollPane jsp;
	JLabel jl[]= new JLabel[20];
	//处理第二组卡片(陌生人)
	JPanel jp21,jp22,jp23;
	JButton jb21,jb22,jb23;
	JScrollPane jsp2;
	JLabel jl2[]= new JLabel[20];
	String owerid;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	//	QqFriendList qfl = new QqFriendList();
	}
	public QqFriendList(String owerid) {
		this.owerid=owerid;
		//处理第一张卡片
		//处理jp1
		jp1 = new JPanel();
		jp1.setLayout(new BorderLayout());
		//jp1北面
		jb1 = new JButton("我的好友");
		//jp1中间
		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(20,1));
		
		for(int i=0;i<20;i++){
			jl[i] = new JLabel(i+1+"",new ImageIcon("images/mm.jpg"),JLabel.LEFT);
			jl[i].addMouseListener(this);
		    jp2.add(jl[i]);
		}
		jsp = new JScrollPane(jp2);
		//jp1南部
		jp3 = new JPanel();
		jp3.setLayout(new GridLayout(2,1));
		jb2 = new JButton("陌生人");
		jb2.addActionListener(this);
		jb3 = new JButton("黑名单");
		jp3.add(jb2);
		jp3.add(jb3);
		jp1.add(jb1,"North");
		jp1.add(jsp,"Center");
		jp1.add(jp3,"South");
		//处理第二张卡片
		//处理jp21
		jp21 = new JPanel();
		jp21.setLayout(new BorderLayout());
		//jp21北面
		jp23 = new JPanel(new GridLayout(2,1));
		jb21 = new JButton("我的好友");
		jb21.addActionListener(this);
		jb22 = new JButton("陌生人");
		jp23.add(jb21);
		jp23.add(jb22);
		//jp21中间
		jp22 = new JPanel();
		jp22.setLayout(new GridLayout(20,1));
				
		for(int i=0;i<20;i++){
			jl2[i] = new JLabel(i+1+"",new ImageIcon("images/mm.jpg"),JLabel.LEFT);
		    jp22.add(jl2[i]);
		}
		jsp2 = new JScrollPane(jp22);
		//jp21南部
		jb23 = new JButton("黑名单");
		jp21.add(jp23,"North");
		jp21.add(jsp2,"Center");
		jp21.add(jb23,"South");
		this.setLayout(card);
		this.add(jp1,"1");
		this.add(jp21,"2");
		this.setSize(200, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(owerid);
		Image img = new ImageIcon("images/QQ.jpg").getImage();
		this.setIconImage(img);
		this.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==jb21){
			card.show(this.getContentPane(), "1");
		}
		else if(e.getSource()==jb2){
			card.show(this.getContentPane(), "2");
		}
	}
	public void mouseClicked(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		if(arg0.getClickCount()==2){
			String FriendNo=((JLabel)arg0.getSource()).getText();
			QqChat qc =new QqChat(owerid,FriendNo);
			Thread t = new Thread(qc);
			t.start();
		}
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		JLabel jl =(JLabel)arg0.getSource();
		jl.setForeground(Color.red);
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		JLabel jl =(JLabel)arg0.getSource();
		jl.setForeground(Color.black);
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
}
