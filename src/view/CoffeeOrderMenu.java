package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dto.CoffeeDto;
import singleton.Singleton;

public class CoffeeOrderMenu extends JFrame implements ActionListener {
	JRadioButton _short, _tall, _grande, _vanilla, _caramel, _hazelnuts, _no;
	JCheckBox _add_shot, _whip_cream;

	JButton coffeeMenuBtn = null;
	JButton orderBtn = null;

	JPanel sizePanel = null;
	JPanel cyrupPanel = null;
	JPanel etcPanel = null;

	JLabel sizeLabel = null;
	JLabel cyrupLabel = null;
	JLabel etcLabel = null;

	JTextField amount = null;

	String selects[] = null;

	private JComboBox<String> choiceList;

	public CoffeeOrderMenu() {
		super("주문");

		setLayout(null);

		// 메뉴 보기 버튼
		coffeeMenuBtn = new JButton("메뉴 보기");
		coffeeMenuBtn.addActionListener(this);
		coffeeMenuBtn.setBounds(500, 10, 100, 35);
		add(coffeeMenuBtn);

		// 커피 선택 콤보박스
		selects = new String[] { "선택", "헤이즐넛 카라멜 모카", "카라멜 마끼아또", "화이트 초콜릿 모카", "카라멜 모카", "카페 모카", "카라멜 라떼", "카페 라떼",
				"카푸치노", "아메리카노", "오늘의 커피" };
		choiceList = new JComboBox<String>(selects);
		choiceList.addActionListener(this);
		choiceList.setBounds(150, 100, 300, 20);
		add(choiceList);

		// 사이즈 패널
		sizePanel = new JPanel();
		sizePanel.setLayout(new GridLayout(3, 1));
		sizePanel.setBounds(70, 210, 150, 150);
		add(sizePanel);
		// 사이즈 패널 라디오 버튼
		_short = new JRadioButton("SHORT");// JRadioButton 생성
		_tall = new JRadioButton("TALL");
		_grande = new JRadioButton("GRANDE");
		// 사이즈 패널 버튼 그룹
		ButtonGroup size_group = new ButtonGroup();
		size_group.add(_short);
		size_group.add(_tall);
		size_group.add(_grande);
		// 사이즈 패널 추가
		sizeLabel = new JLabel("사이즈");
		sizeLabel.setBounds(60, 180, 50, 20);
		add(sizeLabel);
		sizePanel.add(_short);
		sizePanel.add(_tall);
		sizePanel.add(_grande);

		// 시럽패널
		cyrupPanel = new JPanel();
		cyrupPanel.setLayout(new GridLayout(4, 1));
		cyrupPanel.setBounds(250, 210, 150, 150);
		add(cyrupPanel);
		// 시럽 패널 라디오 버튼
		_vanilla = new JRadioButton("바닐라");// JRadioButton 생성
		_caramel = new JRadioButton("카라멜");
		_hazelnuts = new JRadioButton("헤이즐넛");
		_no = new JRadioButton("없음");

		// 시럽 패널 버튼 그룹
		ButtonGroup cyrup_group = new ButtonGroup();
		cyrup_group.add(_vanilla);
		cyrup_group.add(_caramel);
		cyrup_group.add(_hazelnuts);
		cyrup_group.add(_no);
		// 시럽 패널 추가
		cyrupLabel = new JLabel("시럽");
		cyrupLabel.setBounds(240, 180, 50, 20);

		add(cyrupLabel);
		cyrupPanel.add(_vanilla);
		cyrupPanel.add(_caramel);
		cyrupPanel.add(_hazelnuts);
		cyrupPanel.add(_no);

		// 기타 패널
		etcPanel = new JPanel();
		etcPanel.setLayout(new GridLayout(2, 1));
		etcPanel.setBounds(430, 210, 150, 150);
		etcPanel.setBackground(Color.yellow);
		add(etcPanel);
		// 기타 패널 체크박스
		_add_shot = new JCheckBox("샷 추가");
		_whip_cream = new JCheckBox("휘핑 크림");
		// 시럽 패널 추가
		etcLabel = new JLabel("기타");
		etcLabel.setBounds(415, 180, 50, 20);

		add(etcLabel);
		etcPanel.add(_add_shot);
		etcPanel.add(_whip_cream);

		// 0잔
		amount = new JTextField("1");
		amount.setBounds(200, 380, 30, 25);
		add(amount);

		JLabel cup = new JLabel("잔");
		cup.setBounds(240, 380, 50, 25);
		add(cup);
		
		// 주문하기 버튼
		orderBtn = new JButton("주문하기");
		orderBtn.setBounds(280, 370, 100, 40);
		orderBtn.addActionListener(this);
		add(orderBtn);

		setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 640, 480);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		JButton btn = null;
		JComboBox<String> jcBox = null;
		JRadioButton rBtn = null;
		JCheckBox jBox = null;

		if (source instanceof JButton) {
			btn = (JButton) e.getSource();
		} else if (source instanceof JComboBox) {
			jcBox = (JComboBox<String>) e.getSource();
		} else if (source instanceof JRadioButton) {
			rBtn = (JRadioButton) e.getSource();
		} else if (source instanceof JCheckBox) {
			jBox = (JCheckBox) e.getSource();
		}
		// 메뉴보기
		if (btn == coffeeMenuBtn) {
			Singleton s = Singleton.getInstance();
			s.cfeCtrl.getCoffeeList();
				
		// 주문하기 버튼
		} else if(btn == orderBtn) {
			Singleton s = Singleton.getInstance();
			CoffeeDto dto = new CoffeeDto();
				
			//아이디 세팅
			dto.setId(s.getLoginID());
			//커피명 세팅
			dto.setCoffeeName((String)choiceList.getSelectedItem());
			
			//사이즈 세팅
			if (_short.isSelected()) {
				dto.setSize(_short.getLabel());
			} else if (_tall.isSelected()) {
				dto.setSize(_tall.getLabel());
			} else if (_grande.isSelected()) {
				dto.setSize(_grande.getLabel());
			}
			//시럽세팅
			if(_vanilla.isSelected()) {
				dto.setCyrup(_vanilla.getLabel());
			} else if(_caramel.isSelected()) {
				dto.setCyrup(_caramel.getLabel());
			} else if(_hazelnuts.isSelected()) {
				dto.setCyrup(_hazelnuts.getLabel());
			} else if(_no.isSelected()) {
				dto.setCyrup(_no.getLabel());
			}
			//크림세팅
			if (_whip_cream.isSelected()) {
				dto.setCream(_whip_cream.getLabel());
			} else {
				dto.setCream("추가안함");
			}
			
			// 샷추가 세팅
			if (_add_shot.isSelected()) {
				dto.setAddShot(_add_shot.getLabel());
			} else {
				dto.setAddShot("추가안함");
			}
			
			// 잔 세팅
			dto.setAmount(Integer.parseInt(amount.getText()));
			System.out.println(dto.toString());
			
			//주문내역 실행
			s.cfeCtrl.OrderAf(dto);
			this.dispose();
			
			
			// 주문 내역 보기
			
			
			
			
			
			
		}
		
		// 커피 선택
		if (choiceList.isShowing()) {
			System.out.println("선택한 커피: " + choiceList.getSelectedItem());
		}
		
		// 사이즈 선택
		if (_short.isSelected()) {
			System.out.println("사이즈 : " + _short.getLabel());
		} else if (_tall.isSelected()) {
			System.out.println("사이즈 : " + _tall.getLabel());
		} else if (_grande.isSelected()) {
			System.out.println("사이즈 : " + _grande.getLabel());
		}

		//시럽 선택
		if(_vanilla.isSelected()) {
			System.out.println("시럽 : " + _vanilla.getLabel());
		} else if(_caramel.isSelected()) {
			System.out.println("시럽 : " + _caramel.getLabel());
		} else if(_hazelnuts.isSelected()) {
			System.out.println("시럽 : " + _hazelnuts.getLabel());
		} else if(_no.isSelected()) {
			System.out.println("시럽 : " + _no.getLabel());
		}
		
		// 샷추가 선택
		if (_add_shot.isSelected()) {
			System.out.println("기타 : " + _add_shot.getLabel());
		}
		
		// 휘핑크림 선택
		if (_whip_cream.isSelected()) {
			System.out.println("기타 : " + _whip_cream.getLabel());
		}

	}

}
	
