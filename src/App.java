import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.beans.PropertyChangeEvent;

import TestingTool.Analyzer;

public class App {
	/**
	 * TOTI: Auto generated code:
	 */

	private JFrame frmToolingtest;
	private JTextField txtHalsteadOperators;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmToolingtest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmToolingtest = new JFrame();
		frmToolingtest.setTitle("ToolingTest");
		frmToolingtest.setBounds(100, 100, 731, 468);
		frmToolingtest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmToolingtest.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo fuente");
		lblNewLabel.setBounds(20, 11, 135, 14);
		frmToolingtest.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(378, 11, 327, 407);
		frmToolingtest.getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Estadisticas");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_2 = new JLabel("Lineas Totales:");
		
		JLabel lblNewLabel_2_1 = new JLabel("Lineas de codigo:");
		
		JLabel lblNewLabel_2_2 = new JLabel("Lineas de codigo comentadas:");
		
		JLabel lblNewLabel_2_3 = new JLabel("Porcentaje Lineas Comentadas:");
		
		JLabel lblNewLabel_2_4 = new JLabel("Complejidad Ciclomatica:");
		
		JLabel lblNewLabel_2_5 = new JLabel("Halstead Longitud:");
		
		JLabel lblNewLabel_2_5_1 = new JLabel("Halstead Volumen:");
		
		JLabel lblNewLabel_2_5_1_1 = new JLabel("Operadores Halstead ");
		
		JLabel lblNewLabel_2_5_1_2 = new JLabel("Fan In:");
		
		JLabel lblNewLabel_2_5_1_3 = new JLabel("Fan Out:");
		
		txtHalsteadOperators = new JTextField();
		txtHalsteadOperators.setText("+, -, /, *, int, double, float, ;, :, public, static, void, &&, ||, <=, >=, <, >");
		txtHalsteadOperators.setColumns(10);
		
		final JLabel lblLinesTotal = new JLabel("N/A");
		
		final JLabel lblCodeLines = new JLabel("N/A");
		
		final JLabel lblCommentedLines = new JLabel("N/A");
		
		final JLabel lblCommentedPercentage = new JLabel("N/A");
		
		JLabel lblCycleComplexity = new JLabel("N/A");
		
		JLabel lblHalsteadLongitude = new JLabel("N/A");
		
		JLabel lblHalsteadVolume = new JLabel("N/A");
		
		JLabel lblFanIn = new JLabel("N/A");
		
		JLabel lblFanOut = new JLabel("N/A");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblLinesTotal, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCodeLines, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCommentedLines, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCycleComplexity, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCommentedPercentage, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(135)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2_5_1_3, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFanOut, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2_5_1_2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFanIn, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2_5_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtHalsteadOperators, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2_5_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblHalsteadVolume, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblHalsteadLongitude, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblLinesTotal))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1)
						.addComponent(lblCodeLines))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_2)
						.addComponent(lblCommentedLines))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_3)
						.addComponent(lblCommentedPercentage))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_4)
						.addComponent(lblCycleComplexity))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_5)
						.addComponent(lblHalsteadLongitude))
					.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_5_1)
						.addComponent(lblHalsteadVolume))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_5_1_1)
						.addComponent(txtHalsteadOperators, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_5_1_2)
						.addComponent(lblFanIn))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_5_1_3)
						.addComponent(lblFanOut))
					.addGap(75))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 358, 382);
		frmToolingtest.getContentPane().add(scrollPane);
		
		final JTextArea txtSourceCode = new JTextArea();
		scrollPane.setViewportView(txtSourceCode);
		
		/*
		 * TOTI: Actual code here
		 */
		txtSourceCode.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
				final String sourceCode = txtSourceCode.getText();
				final int totalLines = Analyzer.getTotalLines(sourceCode);
				final int totalCodeLines = Analyzer.getTotalCodeLines(sourceCode);
				final int totalCommentLines = Analyzer.getTotalCommentLines(sourceCode);
				final float commentPercentage = Math.round((float) totalCommentLines / totalLines * 100);
				Analyzer.calculateHalstead(sourceCode, Arrays.asList(txtHalsteadOperators.getText().split(",")));
				lblLinesTotal.setText("" + totalLines);
				lblCodeLines.setText("" + totalCodeLines);
				lblCommentedLines.setText("" + totalCommentLines);
				if (totalLines > 0) {
					lblCommentedPercentage.setText(commentPercentage + "%");
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				final String sourceCode = txtSourceCode.getText();
				final int totalLines = Analyzer.getTotalLines(sourceCode);
				final int totalCodeLines = Analyzer.getTotalCodeLines(sourceCode);
				final int totalCommentLines = Analyzer.getTotalCommentLines(sourceCode);
				final float commentPercentage = Math.round((float) totalCommentLines / totalLines * 100);
				Analyzer.calculateHalstead(sourceCode, Arrays.asList(txtHalsteadOperators.getText().split(",")));
				lblLinesTotal.setText("" + totalLines);
				lblCodeLines.setText("" + totalCodeLines);
				lblCommentedLines.setText("" + totalCommentLines);
				if (totalLines > 0) {
					lblCommentedPercentage.setText(commentPercentage + "%");
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				final String sourceCode = txtSourceCode.getText();
				final int totalLines = Analyzer.getTotalLines(sourceCode);
				final int totalCodeLines = Analyzer.getTotalCodeLines(sourceCode);
				final int totalCommentLines = Analyzer.getTotalCommentLines(sourceCode);
				final float commentPercentage = Math.round((float) totalCommentLines / totalLines * 100);
				Analyzer.calculateHalstead(sourceCode, Arrays.asList(txtHalsteadOperators.getText().split(",")));
				lblLinesTotal.setText("" + totalLines);
				lblCodeLines.setText("" + totalCodeLines);
				lblCommentedLines.setText("" + totalCommentLines);
				if (totalLines > 0) {
					lblCommentedPercentage.setText(commentPercentage + "%");
				}
			}
		});
	}
}
