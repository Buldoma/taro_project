package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import jdbc.oracle.TaroDAO;
import jdbc.oracle.TaroVO;

public class Final extends JPanel{
	JButton btn1,btn2,btn3;
	JPanel pan1,pan2,pan3;
	JLabel nl1,nl2,nl3;
	JLabel ml1,ml2,ml3;
	Random ra=new Random();
	TaroDAO tdao=new TaroDAO();
	Font f=new Font("맑은 고딕",Font.BOLD,20);
	public Final() {
		setPreferredSize(new Dimension(1300,465));
		this.setLayout(new GridLayout(1,3,30,5));
		this.setBorder(new LineBorder(Color.WHITE,3));
		this.setBackground(Color.DARK_GRAY);
		int re1=ra.nextInt(21)+0;
		int re2=re1;
		while(re2==re1) {
			re2=ra.nextInt(21)+0;
		}
		int re3=re2;
		while(re3==re2 || re3==re1) {
			re3=ra.nextInt(21)+0;
		}
		System.out.println(re1+" "+re2+" "+re3);
		btn1=new JButton();
		btn2=new JButton();
		btn3=new JButton();
		btn1.setIcon(new ImageIcon("./taro/"+re1+".jpg"));
		btn2.setIcon(new ImageIcon("./taro/"+re2+".jpg"));
		btn3.setIcon(new ImageIcon("./taro/"+re3+".jpg"));
		btn1.setContentAreaFilled(false);
		btn2.setContentAreaFilled(false);
		btn3.setContentAreaFilled(false);
		btn1.setBorderPainted(false);
		btn2.setBorderPainted(false);
		btn3.setBorderPainted(false);
		btn1.addActionListener(new Event());
		btn2.addActionListener(new Event());
		btn3.addActionListener(new Event());
		List<TaroVO> li1=tdao.CardList(re1);
		for(TaroVO tv:li1) {
			nl1=new JLabel(tv.getCard_name(),JLabel.CENTER);
			ml1=new JLabel(tv.getMean(),JLabel.CENTER);
			nl1.setForeground(Color.white);
			ml1.setForeground(Color.WHITE);
			nl1.setFont(f);
			ml1.setFont(f);
		}
		List<TaroVO> li2=tdao.CardList(re2);
		for(TaroVO tv:li2) {
			nl2=new JLabel(tv.getCard_name(),JLabel.CENTER);
			ml2=new JLabel(tv.getMean(),JLabel.CENTER);
			nl2.setForeground(Color.white);
			ml2.setForeground(Color.WHITE);
			nl2.setFont(f);
			ml2.setFont(f);
		}
		List<TaroVO> li3=tdao.CardList(re3);
		for(TaroVO tv:li3) {
			nl3=new JLabel(tv.getCard_name(),JLabel.CENTER);
			ml3=new JLabel(tv.getMean(),JLabel.CENTER);
			nl3.setForeground(Color.white);
			ml3.setForeground(Color.WHITE);
			nl3.setFont(f);
			ml3.setFont(f);
		}
		pan1=new JPanel();
		pan1.setBackground(Color.DARK_GRAY);
		pan1.setLayout(new BorderLayout());
		pan1.add(nl1,BorderLayout.NORTH);pan1.add(btn1,BorderLayout.CENTER);pan1.add(ml1,BorderLayout.SOUTH);
		pan2=new JPanel();
		pan2.setBackground(Color.DARK_GRAY);
		pan2.setLayout(new BorderLayout());
		pan2.add(nl2,BorderLayout.NORTH);pan2.add(btn2,BorderLayout.CENTER);pan2.add(ml2,BorderLayout.SOUTH);
		pan3=new JPanel();
		pan3.setBackground(Color.DARK_GRAY);
		pan3.setLayout(new BorderLayout());
		pan3.add(nl3,BorderLayout.NORTH);pan3.add(btn3,BorderLayout.CENTER);pan3.add(ml3,BorderLayout.SOUTH);
		add(pan1);add(pan2);add(pan3);
	}
	class Event implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(Desktop.isDesktopSupported()) {
				try {
					URI uri=new URI("https://namu.wiki/w/%ED%83%80%EB%A1%9C%20%EC%B9%B4%EB%93%9C?"
							+ "from=%ED%83%80%EB%A1%9C%EC%B9%B4%EB%93%9C#s-2.1");
					Desktop.getDesktop().browse(uri);
				}catch(Exception er) {
					er.printStackTrace();
				}
			}
		}
		
	}
}
