package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.CoffeeDto;
import dto.CoffeeMenuDto;
import singleton.Singleton;

public class CoffeeOrderHistoryView extends JFrame implements MouseListener, ActionListener{
	JButton backToOrderView = null;
	JButton payment = null;
	
	JTable jtable = null;
	
	JScrollPane jscrPane = null;
	
	String columnNames[] = { "ESPRESSO_BEVERAGES",
							 "시럽",
							 "크기",
							 "샷추가",
							 "휘핑크림",
							 "잔",
							 "총액"
	};
	
	Object rowData[][];
	
	DefaultTableModel model;
	
	List<CoffeeDto> list = null;
	
	public CoffeeOrderHistoryView(List<CoffeeDto> list) {
		super("주문내역");
		
		setLayout(null);
		
		JLabel label = new JLabel("주문내역");
		label.setBounds(10, 10, 120, 15);
		add(label);
		
		// dao를 통해서 list를 취득
		this.list = list;
		
		// jtable row를 생성
		rowData = new Object[list.size()][7];
		
		// list에서 테이블로 데이터를 삽입하기 위한 처리
		for (int i = 0; i < list.size(); i++) {
			CoffeeDto dto = list.get(i);
			
			rowData[i][0] = dto.getCoffeeName(); // 커피 이름
			rowData[i][1] = dto.getSize(); // 사이즈
			rowData[i][2] = dto.getCyrup(); // 시럽
			rowData[i][3] = dto.getAddShot(); // 샷추가
			rowData[i][4] = dto.getCream(); // 휘핑크림
			rowData[i][5] = dto.getAmount(); // 잔
			rowData[i][6] = dto.getTotal_price(); // 총액
		}
		
		// 테이블 관련
		// 테이블 폭을 설정하기 위한 Model
		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);
		
		// 테이블 생성
		jtable = new JTable(model);
		jtable.addMouseListener(this);
		
		// column의 폭을 설정
		jtable.getColumnModel().getColumn(0).setMaxWidth(400); // 커피 이름
		jtable.getColumnModel().getColumn(1).setMaxWidth(70); // 시럽
		jtable.getColumnModel().getColumn(2).setMaxWidth(70); // 사이즈
		jtable.getColumnModel().getColumn(3).setMaxWidth(70); // 샷추가
		jtable.getColumnModel().getColumn(4).setMaxWidth(70); // 휘핑크림
		jtable.getColumnModel().getColumn(5).setMaxWidth(70); // 잔
		jtable.getColumnModel().getColumn(6).setMaxWidth(70); // 총액
		
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);
		
		// 돌아가기 버튼
		backToOrderView = new JButton("돌아가기");
		backToOrderView.addActionListener(this);
		backToOrderView.setBounds(20, 400, 100, 20);
		add(backToOrderView);
		
		//결제하기 버튼
		payment = new JButton("결제하기");
		payment.addActionListener(this);
		payment.setBounds(400, 400, 100, 20);
		add(payment);
		
		
		
		setBounds(100, 100, 640, 480);
		setVisible(true);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Singleton s = Singleton.getInstance();
		if(btn == backToOrderView) {
			new CoffeeOrderMenu();
			this.dispose();
		} else if(btn == payment) {
			s.cfeCtrl.totalList();
		}
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
