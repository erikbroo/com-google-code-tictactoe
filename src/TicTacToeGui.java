import java.awt.EventQueue;

import javax.swing.JFrame;


public class TicTacToeGui {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new TicTacToeFrame();
				frame.setTitle("TicTacToe");
				frame.setSize(350, 450);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				}
		});

	}

}
