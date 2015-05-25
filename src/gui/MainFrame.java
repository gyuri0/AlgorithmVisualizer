package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import selectionsort.SelectionSort;
import xml.XmlInputReader;
import bubblesort.BubbleSort;
import logic.SortAlgorithm;
import logic.SortAlgorithmInput;
import logic.State;
import logic.Step;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private List<Step<? extends State>> stepList;
	private int stepIndex = 0;
	private PaintPanel<?> paintPanel;
	private JTextPane textPane;
	private JTextField inputTextField;
	private SortAlgorithm currentSortAlgorithm = null;
	private JComboBox<String> algorithmCombo;
	private SortAlgorithmInput sortAlgorithmInput;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 600);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		textPane = new JTextPane();
		contentPane.add(textPane);
		textPane.setBounds(300, 0, 300, 500);

		JButton previousButton = new JButton();
		contentPane.add(previousButton);
		previousButton.setText("Previous step");
		previousButton.setBounds(20, 350,120, 30);
		
		JButton nextButton = new JButton();
		contentPane.add(nextButton);
		nextButton.setText("Next step");
		nextButton.setBounds(160, 350,120, 30);
		
		inputTextField = new JTextField();
		contentPane.add(inputTextField);
		inputTextField.setBounds(50, 400, 200, 30);
		inputTextField.setText("10;9;8;7;6;5;4;3;2;1");
		
		JButton loadInputButton = new JButton();
		contentPane.add(loadInputButton);
		loadInputButton.setBounds(20, 450, 120, 30);
		loadInputButton.setText("Textbox load");
		
		JFileChooser fileChooser = new JFileChooser();
		
		JButton loadInputXmlButton = new JButton();
		contentPane.add(loadInputXmlButton);
		loadInputXmlButton.setBounds(160, 450, 120, 30);
		loadInputXmlButton.setText("Xml load");
		
		algorithmCombo = new JComboBox<String>();    
		algorithmCombo.addItem("bubblesort");
		algorithmCombo.addItem("selectsort");
		algorithmCombo.setSelectedIndex(0);
		
		JScrollPane algorithmListScrollPane = new JScrollPane(algorithmCombo);    
		algorithmListScrollPane.setBounds(100, 500, 100, 30);
		contentPane.add(algorithmListScrollPane); 
		
		algorithmCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				init();
			}
		});
		
		previousButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(stepIndex>0){
					stepIndex--;
					paintPanel.setState(stepList.get(stepIndex).getState());
					paintPanel.repaint();
					textPane.setText(AlgorithmTextHelper.getAsText(currentSortAlgorithm, stepList.get(stepIndex).getInstruction()));
				}
			}
		});
		
		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (stepIndex < stepList.size() - 1) {
					stepIndex++;
					paintPanel.setState(stepList.get(stepIndex).getState());
					paintPanel.repaint();
					textPane.setText(AlgorithmTextHelper.getAsText(currentSortAlgorithm, stepList.get(stepIndex).getInstruction()));
				}
			}
		});
		
		loadInputButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				sortAlgorithmInput = getSortAlgorithmInputFromTextBox();
				init();
			}
		});
		
		loadInputXmlButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int returnVal = fileChooser.showOpenDialog(MainFrame.this);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	sortAlgorithmInput = XmlInputReader.getSortAlgorithmInputFromXml(fileChooser.getSelectedFile().getAbsolutePath());
			    }
			    init();
			}
		});
		
		init();
	}
	
	public void init()
	{
		int algorithmIndex = algorithmCombo.getSelectedIndex();
		
		if(algorithmIndex == 0)
		{	
			this.currentSortAlgorithm = new BubbleSort();			
			this.paintPanel = new BubbleSortPaintPanel(0,0,300,300);
		}
		else if(algorithmIndex == 1)
		{
			this.currentSortAlgorithm = new SelectionSort();
			this.paintPanel = new SelectionSortPaintPanel(0,0,300,300);
		}
		
		if(sortAlgorithmInput==null)
		{
			this.sortAlgorithmInput = getSortAlgorithmInputFromTextBox();
		}
		
		this.currentSortAlgorithm.setInput(this.sortAlgorithmInput);
		this.stepList = this.currentSortAlgorithm.run();
		this.textPane.setText(AlgorithmTextHelper.getAsText(this.currentSortAlgorithm, stepList.get(0).getInstruction()));
		this.stepIndex = 0;
		this.paintPanel.setState(this.stepList.get(stepIndex).getState());
		this.contentPane.add(paintPanel);
		this.paintPanel.repaint();
	}
	
	public SortAlgorithmInput getSortAlgorithmInputFromTextBox()
	{
		String text = inputTextField.getText();
		String[] tokens = text.split(";");
		int[] inputArray = new int[tokens.length];
		
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = Integer.parseInt(tokens[i]);
		}
		
		return new SortAlgorithmInput(inputArray);
	}
}
