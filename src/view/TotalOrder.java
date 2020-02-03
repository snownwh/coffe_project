package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.CoffeeDto;
import singleton.Singleton;

public class TotalOrder extends JFrame implements MouseListener {
	
	JLabel sumAll = null;
	
	JTable jtable = null;
	
	JScrollPane jscrPane = null;
	
	String columnNames[] = { "ESPRESSO_BEVERAGES",
							 "주문일자",
							 "사이즈",
							 "잔",
							 "총액"
	};
	
	Object rowData[][];
	
	DefaultTableModel model;
	
	List<CoffeeDto> list = null;
	
	public TotalOrder(List<CoffeeDto> list) {
		super("주문한 커피");
		
		setLayout(null);
		
		JLabel label = new JLabel("주문한 커피");
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
			rowData[i][1] = dto.getDate(); // 주문일자
			rowData[i][2] = dto.getSize(); // 사이즈
			rowData[i][3] = dto.getAmount(); // 잔
			rowData[i][4] = dto.getTotal_price(); // 총액
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
		jtable.getColumnModel().getColumn(1).setMaxWidth(70); // 주문일자
		jtable.getColumnModel().getColumn(2).setMaxWidth(70); // 사이즈
		jtable.getColumnModel().getColumn(3).setMaxWidth(70); // 잔
		jtable.getColumnModel().getColumn(4).setMaxWidth(70); // 총액
				
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);
		
		
		Singleton s = Singleton.getInstance();
		int sum = s.cfeCtrl._sumAll();
		sumAll = new JLabel("총금액: " + sum);
		sumAll.setBounds(450, 400, 100, 20);
		add(sumAll);
				
				
		setBounds(100, 100, 640, 480);
		setVisible(true);
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
