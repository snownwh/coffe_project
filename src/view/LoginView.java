package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dto.MemberDto;
import singleton.Singleton;

public class LoginView extends JFrame implements ActionListener {

	private JTextField idTextF;
	private JPasswordField pwTextF;

	private JButton logBtn;
	private JButton accountBtn;

	public LoginView() {
		super("로그인");
		setLayout(null);

		JLabel loginLabel = new JLabel("커피 주문 프로그램");
		loginLabel.setBounds(90, 10, 120, 15);
		add(loginLabel);

		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(31, 60, 67, 25);
		add(idLabel);

		idTextF = new JTextField(10);
		idTextF.setBounds(80, 60, 100, 25);
		add(idTextF);

		JLabel passLabel = new JLabel("PW:");
		passLabel.setBounds(31, 95, 67, 25);
		add(passLabel);

		pwTextF = new JPasswordField();
		pwTextF.setBounds(80, 95, 100, 25);
		add(pwTextF);

		logBtn = new JButton("log-in");
		logBtn.setBounds(190, 60, 70, 58);
		logBtn.addActionListener(this);
		add(logBtn);

		accountBtn = new JButton("회원가입");
		accountBtn.setBounds(31, 150, 228, 40);
		accountBtn.addActionListener(this);
		add(accountBtn);

		setBounds(100, 100, 310, 270);
		setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Singleton s = Singleton.getInstance();
		if (btn == logBtn) { // log in
			s.memCtrl.loginAf(idTextF.getText(), pwTextF.getText());
			this.dispose();
		} else if(btn == accountBtn) {
			s.memCtrl.regi();
			this.dispose();
		}
	}

}
//		MemberDao dao = MemberDao.getInstance();
//		if(btn == logBtn){	// log in
//			MemberDto mem = dao.login(idTextF.getText(), pwTextF.getText()); 
//			if(mem == null) {
//				JOptionPane.showMessageDialog(null, "id나 password가 틀렸습니다");
//			}else {
//				JOptionPane.showMessageDialog(null, mem.getId() + "님 환영합니다");
//				this.dispose();
//				
//				// login한 id를 저장	-> Session(Web)
//				dao.setLoginID(mem.getId());
//				
//				new bbsListView();
//			}			
//		}
//		else if(btn == accountBtn){ // 회원가입
//			new accountView();
//			this.dispose();
//		}
