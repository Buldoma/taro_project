package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Main extends JFrame{
	JLabel lab;
	JButton btn,howto;
	JPanel mainpan,ttpan;
	CardPanel ca=new CardPanel();
	public Main() {
		setTitle("타로 점 보기");
		setSize(1300,650);
		this.setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(this);
		setLayout(new BorderLayout());
		ttpan=new JPanel();
		ttpan.setBackground(Color.DARK_GRAY);
		lab=new JLabel("Taro",JLabel.CENTER);
		lab.setFont(new Font("맑은 고딕",Font.ITALIC,100));
		lab.setForeground(Color.WHITE);
		ttpan.add(lab);
		btn=new JButton("다음으로 진행");
		btn.setPreferredSize(new Dimension(150,80));
		btn.setFont(new Font("맑은 고딕",Font.BOLD,68));
		btn.setBackground(Color.LIGHT_GRAY);
		btn.setBorder(new LineBorder(Color.WHITE,2));
		btn.addActionListener(new Event());
		mainpan=new JPanel();
		mainpan.setBackground(Color.DARK_GRAY);
		howto=new JButton();
		howto.setIcon(new ImageIcon("./taro/howto.jpg"));
		howto.setContentAreaFilled(false);
		howto.setBorderPainted(false);
		mainpan.add(howto);
		add(ttpan,BorderLayout.NORTH);
		add(mainpan,BorderLayout.CENTER);
		add(btn,BorderLayout.SOUTH);
		setVisible(true);
	}
	
	class Event implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btn)
			if(btn.getText().equals("다음으로 진행")) {
				btn.setText("카드 확인");
				mainpan.removeAll();
				mainpan.add(ca);
				mainpan.revalidate();
				mainpan.repaint();
			}else if(btn.getText().equals("카드 확인")){
				if(ca.count==3) {
				btn.setVisible(false);
				mainpan.removeAll();
				mainpan.add(new Final());
				mainpan.revalidate();
				mainpan.repaint();
				}else {
					JOptionPane.showMessageDialog(null, "카드 3장을 모두 선택하지 않았습니다.");
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Main();
	}//main()

}
