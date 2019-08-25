package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import jdbc.oracle.TaroDAO;

public class CardPanel extends JPanel{
	TaroDAO tdao=new TaroDAO();
	int i=1;
	public int count=0;
	public CardPanel() {
		this.setPreferredSize(new Dimension(1300,400));
		this.setLayout(new GridLayout(2,11,10,5));
		this.setBorder(new LineBorder(Color.WHITE,3));
		this.setBackground(Color.DARK_GRAY);
		while(i<=22) {
			String num=""+i;
			Card ca=new Card(i);
			ca.setPreferredSize(new Dimension(110,200));
			ca.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(count!=3) {
					ca.setIcon(new ImageIcon("./taro/coverBIG.jpg"));
					count++;
					ca.removeActionListener(this);
					ca.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							JOptionPane.showMessageDialog(null, "한번 선택한 카드는 되돌리실 수 없습니다.");
						}
						
					});
					}else {
						JOptionPane.showMessageDialog(null, "이미 3개를 선택하셨으므로 더 이상 선택하실 수 없습니다.");
					}
				}
				
			});
			this.add(ca);
			i++;
		}
	}
}
