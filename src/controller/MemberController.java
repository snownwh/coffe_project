package controller;

import javax.swing.JOptionPane;

import dto.MemberDto;
import service.MemberService;
import service.impl.MemberSeriveImpl;
import singleton.Singleton;
import view.AccountView;
import view.LoginView;

public class MemberController {
	MemberService memServ = new MemberSeriveImpl();

	public void login() {
		new LoginView();
	}

	public void regi() {
		new AccountView();
	}

	public boolean idCheck(String id) {
		return memServ.idCheck(id);
	}

	public void regiAf(String id, String pwd, String name, String email) { // memberDTO로 넘겨받아도 된다.
		boolean b = memServ.addMember(new MemberDto(id, pwd, name, email, 3));
		if (b) {
			// jOptionpane을 여기서 띄워줄수 있다.
			JOptionPane.showMessageDialog(null, "회원가입 성공!");
			login(); // 로그인창을 띄움
		} else {
			JOptionPane.showMessageDialog(null, "회원가입 실패!");
			regi(); // 회원가입창을 띄움
		}
	}

	public void loginAf(String id, String pwd) {
		MemberDto dto = memServ.login(id, pwd);
		if (dto == null) {
			JOptionPane.showMessageDialog(null, "id나 password가 틀렸습니다.");
			login();
		} else {
			JOptionPane.showMessageDialog(null, dto.getId() + "님 환영합니다.");
			// id저장 -> session
			Singleton s = Singleton.getInstance();
			s.setLoginID(dto.getId());

			// bbs controller list로 이동
			s.cfeCtrl.OrderMenu();
		}
	}
}
