package sound;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MenuDzwieki extends JFrame {

	private JPanel contentPane;
	private JCheckBox chckbxWyciszDz;
	private JCheckBox chckbxWyciszMu;
	private JSlider sliderdz;
	private JSlider slidermu;

	/**
	 * Launch the application.
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuDzwieki frame = new MenuDzwieki();
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
	public MenuDzwieki() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblUstawDzw = new JLabel("Ustawienia Dźwięku");
		lblUstawDzw.setFont(new Font("Dialog", Font.BOLD, 28));
		lblUstawDzw.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblUstawDzw, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblGonoDwikw = new JLabel("Głośność dźwięków:");
		panel.add(lblGonoDwikw);
		
		chckbxWyciszDz = new JCheckBox("Wycisz dźwięki");
		chckbxWyciszDz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxWyciszDz.isSelected())	//wyciszony
				{
					SoundButton.zapiszWyciszony();
					sliderdz.setValue(0);
				}
				else								//niewyciszony
				{
					sliderdz.setValue(SoundButton.wczytajWyciszony());
				}
			}
		});
		panel.add(chckbxWyciszDz);
		
		JLabel lblGonoMuzyki = new JLabel("Głośność muzyki:");
		panel.add(lblGonoMuzyki);
		
		chckbxWyciszMu = new JCheckBox("Wycisz muzykę");
		panel.add(chckbxWyciszMu);
		
		JButton btnPowrt = new SoundButton("Powrót");
		panel.add(btnPowrt);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		sliderdz = new JSlider();
		sliderdz.setValue(SoundButton.getGlosnosc());
		sliderdz.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				SoundButton.setGlosnosc(sliderdz.getValue());
				if(chckbxWyciszDz.isSelected() && sliderdz.getValue()!=0)
					chckbxWyciszDz.setSelected(false);
			}
		});
		panel_1.add(sliderdz);
		
		JLabel label = new JLabel("");
		panel_1.add(label);
		
		slidermu = new JSlider();
		panel_1.add(slidermu);
		
		JLabel label_1 = new JLabel("");
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("");
		panel_1.add(label_2);
	}
}
