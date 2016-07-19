/**
 * QQ�ͻ��˵�¼����
 */
package com.qq.client.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.qq.client.model.QqClientUser;
import com.qq.common.User;
public class QqClientLogin extends JFrame implements ActionListener{
	//��������
	JLabel jl1;
	//�ϲ�����
	JButton jb1,jb2,jb3;
	JPanel jp4;
	//�м�����
	JTabbedPane jtp;//ѡ�
	JPanel jp1,jp2,jp3;
	JLabel jl2,jl3,jl4,jl5;
	JTextField jtf;
	JPasswordField jpf;
	JButton jb4;
	JCheckBox jcb1,jcb2;
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		QqClientLogin login = new QqClientLogin();
	}
	public QqClientLogin(){
		//��������
		jl1 = new JLabel(new ImageIcon("images/tou.gif"));
		//�ϲ�����
		jp4 = new JPanel();
		jb1 = new JButton(new ImageIcon("images/denglu.gif"));
		jb1.addActionListener(this);
		jb2 = new JButton(new ImageIcon("images/quxiao.gif"));
		jb3 = new JButton(new ImageIcon("images/xiangdao.gif"));
		//�м�����
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jl2 = new JLabel("QQ����",JLabel.CENTER);
		jl3 = new JLabel("QQ����",JLabel.CENTER);
		jl4 = new JLabel("��������",JLabel.CENTER);
		jl4.setForeground(Color.blue);
		jl5 = new JLabel("�������뱣��",JLabel.CENTER);
		jtf = new JTextField(10);
		jpf = new JPasswordField(10);
		jb4 = new JButton(new ImageIcon("images/clear.gif"));
		jcb1= new JCheckBox("�����½");
		jcb2= new JCheckBox("��ס����");
		//add���
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
		jtp.add("QQ����",jp1);
		jtp.add("�ֻ�����",jp2);
		jtp.add("�����½",jp3);
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
		// TODO �Զ����ɵķ������
		if(e.getSource()==jb1){
			
			QqClientUser qcu= new QqClientUser();
			User u = new User();
			u.setUserId(jtf.getText().trim());
			u.setPasswd(new String(jpf.getPassword()));
			if(qcu.CheckUser(u)){
				new QqFriendList(u.getUserId());
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this, "�û��������������");
				
			}
		}
	}
}

