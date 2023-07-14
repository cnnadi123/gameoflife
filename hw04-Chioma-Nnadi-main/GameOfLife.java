package hw04;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.Timer;

import hw04.CellGrid;
import hw04.LifePanel;

public class GameOfLife {
	private JFrame graph = new JFrame();
	private Dimension screenSize;
	private JDialog dialog;
	private boolean running = false;
	private LifePanel lifePanel;
	private CellGrid cellGrid;
	private Timer t = new Timer(100, e -> {
		if (running) {
			cellGrid.applyUpdate();
			graph.repaint();
		}
	});

	private final int NUM_BLOCKS_HORIZ = 200;
	private final int NUM_BLOCKS_VERT = 150;

	public GameOfLife() {
		t.start();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		graph.setSize(screenSize.width - 100, screenSize.height - 100);
		graph.setUndecorated(true);
		double blockWidth = screenSize.getWidth() / NUM_BLOCKS_HORIZ;
		double blockHeight = screenSize.getHeight() / NUM_BLOCKS_VERT;

		cellGrid = new CellGrid(NUM_BLOCKS_VERT, NUM_BLOCKS_HORIZ);
		lifePanel = new LifePanel(blockWidth, blockHeight, NUM_BLOCKS_HORIZ, NUM_BLOCKS_VERT,
				screenSize.getWidth(), screenSize.getHeight(), cellGrid);
		graph.add(lifePanel);
		graph.setVisible(true);
		dialog = new JDialog((Frame) null, "Control", true);
		dialog.setLayout(new GridLayout(0, 2));
		JButton setupButton = new JButton("Setup");
		setupButton.addActionListener(new SetupListener());
		dialog.add(setupButton);
		JButton stepButton = new JButton("Step");
		stepButton.addActionListener(e -> {
			cellGrid.applyUpdate();
			graph.repaint();
		});
		dialog.add(stepButton);
		JButton pauseButton = new JButton("Pause/Run");
		pauseButton.addActionListener(e -> running = !running);
		dialog.add(pauseButton);
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(e -> System.exit(0));
		dialog.add(exitButton);
		dialog.setTitle("Control: " + NUM_BLOCKS_HORIZ + "x" + NUM_BLOCKS_VERT);
		dialog.pack();
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		dialog.addWindowListener(new ExitWindowListener());
		dialog.setLocation((int) (screenSize.getWidth() - dialog.getWidth()),
				(int) (screenSize.getHeight() - dialog.getHeight()));
		dialog.setVisible(true);
	}

	public static void main(String[] args) {
		GameOfLife gameOfLife = new GameOfLife();
	}

	private class SetupListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JDialog setupDialog = new JDialog(dialog, "Setup Options");
			setupDialog.setLayout(new GridLayout(0, 1));
			JButton randomButton = new JButton("Random");
			randomButton.addActionListener(e -> {
				cellGrid.randomStart();
				setupDialog.dispose();
				graph.repaint();
			});
			setupDialog.add(randomButton);
			JButton gosperButton = new JButton("Gosper Gun");
			gosperButton.addActionListener(e -> {
				cellGrid.gosperStart();
				setupDialog.dispose();
				graph.repaint();
			});
			setupDialog.add(gosperButton);
			JButton gliderButton = new JButton("Glider");
			gliderButton.addActionListener(e -> {
				cellGrid.gliderStart();
				setupDialog.dispose();
				graph.repaint();
			});
			setupDialog.add(gliderButton);
			setupDialog.pack();
			setupDialog.setLocationRelativeTo(dialog);
			setupDialog.setVisible(true);
		}
	}

	private class ExitWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent arg0) {
			System.exit(0);
		}
	}
}
