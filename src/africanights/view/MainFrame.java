package africanights.view;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import africanights.model.Pool;
import africanights.model.Resume;

public class MainFrame extends JFrame{
	
	//组件及其资源
	private ImageIcon bgIcon = new ImageIcon("image\\pool1.png");
	private JLabel bgLabel = new JLabel();
	private ImageIcon singleShotIcon = new ImageIcon("image\\singleShot.png");
	private JButton singleShotButton = new JButton();
	
	//卡池
	private Pool m_pool = new Pool(); 
	
	
	
	public MainFrame() {
		setTitle("明日非舟干员寻访模拟");
		
		Container c =getContentPane();
		
		//背景图片
		bgLabel.setIcon(bgIcon);
		bgLabel.setBounds(0, 0, bgIcon.getIconWidth(), bgIcon.getIconHeight());
		c.add(bgLabel);
		
		//寻访按钮
		singleShotButton.setBounds(1205, 910, singleShotIcon.getIconWidth(), singleShotIcon.getIconHeight());
		singleShotButton.setIcon(singleShotIcon);
		singleShotButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Resume resume = m_pool.randomResume();
				resume.show();
				bgLabel.setIcon(new ImageIcon(resume.getPortrayal()));
			}
		});
		bgLabel.add(singleShotButton);
		
		setSize(bgIcon.getIconWidth()+100, bgIcon.getIconHeight()+100);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		MainFrame mFrame= new MainFrame();
		
		
		
	}

}
