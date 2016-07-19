/**
 * QQ客户端登录界面
 */
package com.qq.client.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.qq.client.model.QqClientUser;
import com.qq.common.User;
public class QqClientLogin extends JFrame implements ActionListener{
	//北部区域
	JLabel jl1;
	//南部区域
	JButton jb1,jb2,jb3;
	JPanel jp4;
	//中间区域
	JTabbedPane jtp;//选项卡
	JPanel jp1,jp2,jp3;
	JLabel jl2,jl3,jl4,jl5;
	JTextField jtf;
	JPasswordField jpf;
	JButton jb4;
	JCheckBox jcb1,jcb2;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		QqClientLogin login = new QqClientLogin();
	}
	public QqClientLogin(){
		//北部区域
		jl1 = new JLabel(new ImageIcon("images/tou.gif"));
		//南部区域
		jp4 = new JPanel();
		jb1 = new JButton(new ImageIcon("images/denglu.gif"));
		jb1.addActionListener(this);
		jb2 = new JButton(new ImageIcon("images/quxiao.gif"));
		jb3 = new JButton(new ImageIcon("images/xiangdao.gif"));
		//中间区域
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jl2 = new JLabel("QQ号码",JLabel.CENTER);
		jl3 = new JLabel("QQ密码",JLabel.CENTER);
		jl4 = new JLabel("忘记密码",JLabel.CENTER);
		jl4.setForeground(Color.blue);
		jl5 = new JLabel("申请密码保护",JLabel.CENTER);
		jtf = new JTextField(10);
		jpf = new JPasswordField(10);
		jb4 = new JButton(new ImageIcon("images/clear.gif"));
		jcb1= new JCheckBox("隐身登陆");
		jcb2= new JCheckBox("记住密码");
		//add组件
		jp1.add(jl2);
		jp1.add(jtf);
		jp1.add(jb4);
		jp1.add(jl3);
		jp1.add(jpf);
		jp1.add(jl4);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jl5);
		jtp = new JTabbedPane();
		jtp.add("QQ号码",jp1);
		jtp.add("手机号码",jp2);
		jtp.add("邮箱登陆",jp3);
		jp4.add(jb1);
		jp4.add(jb2);
		jp4.add(jb3);
		jp4.setLayout(new FlowLayout());
		this.add(jl1,"North");
		this.add(jtp);
		this.add(jp4,"South");
		
		jp1.setLayout(new GridLayout(3,3));
		this.setIconImage(new ImageIcon("images/qq.gif").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(350,240);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==jb1){
			
			QqClientUser qcu= new QqClientUser();
			User u = new User();
			u.setUserId(jtf.getText().trim());
			u.setPasswd(new String(jpf.getPassword()));
			if(qcu.CheckUser(u)){
				new QqFriendList(u.getUserId());
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this, "用户名或者密码错误");
				
			}
		}
	}
}

