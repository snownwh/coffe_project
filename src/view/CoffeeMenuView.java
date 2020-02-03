package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dto.CoffeeMenuDto;
import singleton.Singleton;

public class CoffeeMenuView extends JFrame implements MouseListener, ActionListener {

	private JTable jtable;
	private JScrollPane jscrPane;
	private JTextField selectField;

	private JButton writeBtn;
	private JButton selectBtn;
	private JButton logoutBtn;

	private JComboBox<String> choiceList;
	private JTextField selectFields;
	private JButton selectBtns;

	String columnNames[] = { "ESPRESSO_BEVERAGES", "SHORT", "TALL", "GRANDE" };

	Object rowData[][];

	DefaultTableModel model; // table의 넓이를 설정

	List<CoffeeMenuDto> list = null;

	public CoffeeMenuView(List<CoffeeMenuDto> list) {
		super("커피 메뉴");

		setLayout(null);

		JLabel label = new JLabel("커피 가격표");
		label.setBounds(10, 10, 120, 15);
		add(label);

		// dao를 통해서 list를 취득
//		Singleton s = Singleton.getInstance();
		this.list = list;

		// jtable row를 생성
		rowData = new Object[list.size()][4];

		// list에서 테이블로 데이터를 삽입하기 위한 처리
		for (int i = 0; i < list.size(); i++) {
			CoffeeMenuDto dto = list.get(i);

			rowData[i][0] = dto.getcName(); // 커피 이름
			rowData[i][1] = dto.get_short(); // 숏
			rowData[i][2] = dto.get_tall(); // 톨
			rowData[i][3] = dto.get_grande(); // 그란데
		}

		// 테이블 관련
		// 테이블 폭을 설정하기 위한 Model
		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);

		// 테이블 생성
		jtable = new JTable(model);
		jtable.addMouseListener(this);

		// column의 폭을 설정
		jtable.getColumnModel().getColumn(0).setMaxWidth(300); // 커피 이름
		jtable.getColumnModel().getColumn(1).setMaxWidth(100); // 숏
		jtable.getColumnModel().getColumn(2).setMaxWidth(100); // 톨
		jtable.getColumnModel().getColumn(3).setMaxWidth(100); // 그란데

		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);

		setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 640, 480);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
