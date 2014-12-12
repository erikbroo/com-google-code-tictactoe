import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import topdesk.Field;
import topdesk.FieldStatus;
import topdesk.SmartField;
import topdesk.Table;

public class TicTacToeFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel buttonPanel, mainPanel, gamePanel;
	private JButton[][] buttons = new JButton[3][3];
	private int counter = 0;
	//HashMap(Key(Button),Value(Table))
	
	//Table to store the game state
	Table gameTable = new Table();

	public TicTacToeFrame() {
		mainPanel = new JPanel(new BorderLayout());
		gamePanel = new JPanel(new GridLayout(3, 3));
		super.add(mainPanel);
		mainPanel.setPreferredSize(new Dimension(325, 425));
		gamePanel.setPreferredSize(new Dimension(300, 300));

		mainPanel.add(gamePanel, BorderLayout.CENTER);

		buttonPanel = new JPanel();
		addButton(buttonPanel, "Start", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Start the Game
				System.out.println("Start button pushed!");
				gameTable= new Table();
				counter=0;
				
				for(JButton[] JButtonElement : Arrays.asList(buttons)){
					for(JButton jbelement: Arrays.asList(JButtonElement)){
						jbelement.setEnabled(true);
						jbelement.setText("");
						}
					}
			}
		});

		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		
		Field fields[]=Field.values();
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
				
				buttons[i][j] = addButton(gamePanel, "", new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
									
						
						// Kezelni X|O kiirni a kockakra
						for (JButton[] elementArray : Arrays.asList(buttons)) {
							for (JButton element : Arrays.asList(elementArray)) {
								if (e.getSource() == element) {
									if (counter % 2 == 0) {
										element.setText("X");
										gameTable.makeMove(new SmartField(element.getName(), FieldStatus.X));
									} else {
										element.setText("0");
										gameTable.makeMove(new SmartField(element.getName(), FieldStatus.O));
									}System.out.println(element.getName());
									counter++;
									element.setEnabled(false);
									if(gameTable.isGameOver()){
										for(JButton[] JButtonElement : Arrays.asList(buttons)){
											for(JButton jbelement: Arrays.asList(JButtonElement)){
												jbelement.setEnabled(false);
												}
											}
										JOptionPane.showMessageDialog(null, "Vége a játéknak!");
										System.out.println("GAME OVER");
									}
								}
								
							}
						}

					}
				}); 
				buttons[i][j].setName(fields[(3*i)+j].toString());
				
				
			}
		}

	pack();
	}

	private JButton addButton(Container c, String title, ActionListener listener) {
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		// TODO Auto-generated method stub
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
		return button;
	}
	
	
}
