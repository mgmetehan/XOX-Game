package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.print.DocFlavor.STRING;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;
import java.awt.Rectangle;

public class XOXGUI extends JFrame {

	protected JPanel w_panel;
	protected JTextField txtOyuncuAdi;
	protected JPanel panelPlayerData = new JPanel();
	protected JLabel lblOyuncuBilgi = new JLabel("Oyuncu Bilgileri");
	protected JLabel lblOyuncuAdi = new JLabel("Oyuncu Bilgileri:");
	protected JButton btnBasla = new JButton("Baslat");
	protected JPanel panelGameBoard = new JPanel();
	protected JLabel lblOyunAlani = new JLabel("Oyun Alani");
	protected JPanel panelBtn = new JPanel();
	protected JButton btn_1 = new JButton("");
	protected JButton btn_2 = new JButton("");
	protected JButton btn_3 = new JButton("");
	protected JButton btn_4 = new JButton("");
	protected JButton btn_5 = new JButton("");
	protected JButton btn_6 = new JButton("");
	protected JButton btn_7 = new JButton("");
	protected JButton btn_8 = new JButton("");
	protected JButton btn_9 = new JButton("");
	protected JPanel panelCondition = new JPanel();
	protected JLabel lblDurum = new JLabel("Durum");
	protected JLabel lblOyuncu = new JLabel("Oyuncu");
	protected JLabel lblBilgisayar = new JLabel("Dona");
	protected JButton btnYenidenOyna = new JButton("Yeniden Oyna");
	protected JLabel lblOyuncuPuan = new JLabel("0");
	protected JLabel lblBilgisayarPuan = new JLabel("0");
	protected JPanel panelSkor = new JPanel();
	protected JLabel lblSkor = new JLabel("Skorlar");
	protected JList listSkorlar = new JList();
	protected JButton btnCikis = new JButton("Cik");
	protected JButton btnOyunuSfrla = new JButton("Oyunu Sifirla");
	protected static String[] box = new String[9];
	protected static int Sayac = 0;
	protected static boolean OyunDurumu = false;
	protected String[] SkorData = new String[10];
	protected int WinPlayer = 0, WinBilgisayar = 0;
	int i = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XOXGUI frame = new XOXGUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void WinVeri() {
		lblOyuncuPuan.setText(String.valueOf(WinPlayer));
		lblBilgisayarPuan.setText(String.valueOf(WinBilgisayar));

	}

	public void OyunKapali() {
		panelGameBoard.setVisible(false);
		panelSkor.setVisible(false);
		panelCondition.setVisible(false);
		panelBtn.setVisible(false);

		btnOyunuSfrla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelSifirlama();
				String str = lblOyuncu.getText() + "  " + lblOyuncuPuan.getText() + " \n" + lblBilgisayar.getText()
						+ " " + lblBilgisayarPuan.getText();
				SkorData[i++] = str;
				listSkorlar.setListData(SkorData);
				WinPlayer = 0;
				WinBilgisayar = 0;
				lblOyuncuPuan.setText(String.valueOf(WinPlayer));
				lblBilgisayarPuan.setText(String.valueOf(WinBilgisayar));
				OyunKapali();

			}
		});
		btnOyunuSfrla.setVisible(false);
	}

	public void OyunBaslat() {
		panelGameBoard.setVisible(true);
		panelSkor.setVisible(true);
		panelCondition.setVisible(true);
		panelBtn.setVisible(true);
		btnOyunuSfrla.setVisible(true);
		PanelSifirlama();
	}

	public void UyariMesaji(String str) {
		String msg = "";
		switch (str) {
		case "name":
			msg = "Lutfen Kullanici Adi Giriniz!!";
			break;
		case "draw":
			msg = "Oyun Berabere!!";
			break;
		case "win":
			msg = "Tebrikler " + lblOyuncu.getText().toUpperCase() + " Oyunu Kazandin!!";
			break;
		case "lose":
			msg = "Uzgunum " + lblOyuncu.getText().toUpperCase() + " Oyunu Dona Kazandi!!";
			break;
		}
		JOptionPane.showMessageDialog(null, msg, "Uyarý", JOptionPane.INFORMATION_MESSAGE);
	}

	public void Kontroll() {
		if ((box[0] == "x" && box[1] == "x" && box[2] == "x") || (box[3] == "x" && box[4] == "x" && box[5] == "x")
				|| (box[6] == "x" && box[7] == "x" && box[8] == "x")
				|| (box[0] == "x" && box[3] == "x" && box[6] == "x")
				|| (box[1] == "x" && box[4] == "x" && box[7] == "x")
				|| (box[2] == "x" && box[5] == "x" && box[8] == "x")
				|| (box[0] == "x" && box[4] == "x" && box[8] == "x")
				|| (box[2] == "x" && box[4] == "x" && box[6] == "x")) {
			UyariMesaji("win");
			WinPlayer++;
			WinVeri();
			OyunDurumu = true;
		} else if ((box[0] == "o" && box[1] == "o" && box[2] == "o")
				|| (box[3] == "o" && box[4] == "o" && box[5] == "o")
				|| (box[6] == "o" && box[7] == "o" && box[8] == "o")
				|| (box[0] == "o" && box[3] == "o" && box[6] == "o")
				|| (box[1] == "o" && box[4] == "o" && box[7] == "o")
				|| (box[2] == "o" && box[5] == "o" && box[8] == "o")
				|| (box[0] == "o" && box[4] == "o" && box[8] == "o")
				|| (box[2] == "o" && box[4] == "o" && box[6] == "o")) {
			UyariMesaji("lose");
			WinBilgisayar++;
			WinVeri();
			OyunDurumu = true;
		} else if (Sayac == 9) {
			UyariMesaji("draw");
			OyunDurumu = true;
		}
	}

	public void PlayerHamle(int i) {// Oyuncu Hamle
		if (i == 1) {
			btn_1.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/X.png")));
			btn_1.setEnabled(false);
			box[0] = "x";
			Sayac++;
			Kontroll();
			BilgisayarHamle();
		} else if (i == 2) {
			btn_2.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/X.png")));
			btn_2.setEnabled(false);
			box[1] = "x";
			Sayac++;
			Kontroll();
			BilgisayarHamle();
		} else if (i == 3) {
			btn_3.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/X.png")));
			btn_3.setEnabled(false);
			box[2] = "x";
			Sayac++;
			Kontroll();
			BilgisayarHamle();
		} else if (i == 4) {
			btn_4.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/X.png")));
			btn_4.setEnabled(false);
			box[3] = "x";
			Sayac++;
			Kontroll();
			BilgisayarHamle();
		} else if (i == 5) {
			btn_5.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/X.png")));
			btn_5.setEnabled(false);
			box[4] = "x";
			Sayac++;
			Kontroll();
			BilgisayarHamle();
		} else if (i == 6) {
			btn_6.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/X.png")));
			btn_6.setEnabled(false);
			box[5] = "x";
			Sayac++;
			Kontroll();
			BilgisayarHamle();
		} else if (i == 7) {
			btn_7.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/X.png")));
			btn_7.setEnabled(false);
			box[6] = "x";
			Sayac++;
			Kontroll();
			BilgisayarHamle();
		} else if (i == 8) {
			btn_8.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/X.png")));
			btn_8.setEnabled(false);
			box[7] = "x";
			Sayac++;
			Kontroll();
			BilgisayarHamle();
		} else if (i == 9) {
			btn_9.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/X.png")));
			btn_9.setEnabled(false);
			box[8] = "x";
			Sayac++;
			Kontroll();
			BilgisayarHamle();
		}
	}

	public void BilgisayarHamle() {// Bilgisayar Hamle
		if (OyunDurumu == true) {
		} else {
			if (Sayac == 9) {
			} else {
				boolean btnDoluMu = false;
				int random;
				do {
					random = (int) (Math.random() * 9);
					if (box[random] == "x")
						btnDoluMu = false;
					else if (box[random] == "o")
						btnDoluMu = false;
					else
						btnDoluMu = true;
				} while (btnDoluMu == false);
				if (random == 0) {
					btn_1.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/O.png")));
					btn_1.setEnabled(false);
					box[0] = "o";
					Sayac++;
				} else if (random == 1) {
					btn_2.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/O.png")));
					btn_2.setEnabled(false);
					box[1] = "o";
					Sayac++;
				} else if (random == 2) {
					btn_3.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/O.png")));
					btn_3.setEnabled(false);
					box[2] = "o";
					Sayac++;
				} else if (random == 3) {
					btn_4.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/O.png")));
					btn_4.setEnabled(false);
					box[3] = "o";
					Sayac++;
				} else if (random == 4) {
					btn_5.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/O.png")));
					btn_5.setEnabled(false);
					box[4] = "o";
					Sayac++;
				} else if (random == 5) {
					btn_6.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/O.png")));
					btn_6.setEnabled(false);
					box[5] = "o";
					Sayac++;
				} else if (random == 6) {
					btn_7.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/O.png")));
					btn_7.setEnabled(false);
					box[6] = "o";
					Sayac++;
				} else if (random == 7) {
					btn_8.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/O.png")));
					btn_8.setEnabled(false);
					box[7] = "o";
					Sayac++;
				} else if (random == 8) {
					btn_9.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/O.png")));
					btn_9.setEnabled(false);
					box[8] = "o";
					Sayac++;
				}
				Kontroll();
			}
		}

	}

	public void PanelSifirlama() {
		btn_1.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/simsek.png")));
		btn_2.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/simsek.png")));
		btn_3.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/simsek.png")));
		btn_4.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/simsek.png")));
		btn_5.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/simsek.png")));
		btn_6.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/simsek.png")));
		btn_7.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/simsek.png")));
		btn_8.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/simsek.png")));
		btn_9.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/simsek.png")));
		btn_1.setEnabled(true);
		btn_2.setEnabled(true);
		btn_3.setEnabled(true);
		btn_4.setEnabled(true);
		btn_5.setEnabled(true);
		btn_6.setEnabled(true);
		btn_7.setEnabled(true);
		btn_8.setEnabled(true);
		btn_9.setEnabled(true);
		for (int i = 0; i < 9; i++) {
			box[i] = "";
		}
		Sayac = 0;
		OyunDurumu = false;
		txtOyuncuAdi.setEnabled(true);
	}

	public XOXGUI() {
		setResizable(false);
		setTitle("Xox Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 800);
		w_panel = new JPanel();
		w_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_panel);
		w_panel.setLayout(null);

		OyunKapali();

		panelPlayerData.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPlayerData.setBounds(10, 10, 582, 147);
		w_panel.add(panelPlayerData);
		panelPlayerData.setLayout(null);

		lblOyuncuBilgi.setForeground(new Color(255, 20, 147));
		lblOyuncuBilgi.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		lblOyuncuBilgi.setBounds(10, 10, 181, 36);
		panelPlayerData.add(lblOyuncuBilgi);

		lblOyuncuAdi.setForeground(new Color(0, 0, 0));
		lblOyuncuAdi.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblOyuncuAdi.setBounds(10, 78, 127, 36);
		panelPlayerData.add(lblOyuncuAdi);

		txtOyuncuAdi = new JTextField();
		txtOyuncuAdi.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		txtOyuncuAdi.setBounds(147, 78, 194, 31);
		panelPlayerData.add(txtOyuncuAdi);
		txtOyuncuAdi.setColumns(10);
		btnBasla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtOyuncuAdi.getText().length() == 0) {
					UyariMesaji("name");
				} else {
					OyunBaslat();
					lblOyuncu.setText(txtOyuncuAdi.getText());
					txtOyuncuAdi.setText("");
					txtOyuncuAdi.setEnabled(false);
				}
			}
		});

		btnBasla.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnBasla.setForeground(new Color(30, 144, 255));
		btnBasla.setBounds(388, 65, 181, 69);
		panelPlayerData.add(btnBasla);

		panelGameBoard.setBorder(new MatteBorder(2, 2, 7, 2, (Color) new Color(0, 0, 0)));
		panelGameBoard.setBounds(10, 179, 582, 568);
		w_panel.add(panelGameBoard);
		panelGameBoard.setLayout(null);

		lblOyunAlani.setForeground(new Color(0, 0, 128));
		lblOyunAlani.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		lblOyunAlani.setBounds(10, 10, 181, 36);
		panelGameBoard.add(lblOyunAlani);

		panelBtn.setBounds(34, 59, 516, 487);
		panelGameBoard.add(panelBtn);
		panelBtn.setLayout(new GridLayout(3, 3, 10, 10));
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerHamle(1);
			}
		});
		btn_1.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/simsek.png")));

		btn_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelBtn.add(btn_1);
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerHamle(2);
			}
		});
		btn_2.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/simsek.png")));

		btn_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelBtn.add(btn_2);
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerHamle(3);
			}
		});
		btn_3.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/simsek.png")));

		btn_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelBtn.add(btn_3);
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerHamle(4);
			}
		});
		btn_4.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/simsek.png")));

		btn_4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelBtn.add(btn_4);
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerHamle(5);
			}
		});
		btn_5.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/simsek.png")));

		btn_5.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelBtn.add(btn_5);
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerHamle(6);
			}
		});
		btn_6.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/simsek.png")));

		btn_6.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelBtn.add(btn_6);
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerHamle(7);
			}
		});
		btn_7.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/simsek.png")));

		btn_7.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelBtn.add(btn_7);
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerHamle(8);
			}
		});
		btn_8.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/simsek.png")));

		btn_8.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelBtn.add(btn_8);
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerHamle(9);
			}
		});
		btn_9.setIcon(new ImageIcon(XOXGUI.class.getResource("/Img/simsek.png")));

		btn_9.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelBtn.add(btn_9);

		panelCondition.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCondition.setBounds(602, 10, 289, 234);
		w_panel.add(panelCondition);
		panelCondition.setLayout(null);

		lblDurum.setForeground(new Color(106, 90, 205));
		lblDurum.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		lblDurum.setBounds(10, 10, 181, 36);
		panelCondition.add(lblDurum);

		lblOyuncu.setForeground(Color.BLACK);
		lblOyuncu.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblOyuncu.setBounds(10, 54, 63, 36);
		panelCondition.add(lblOyuncu);

		lblBilgisayar.setForeground(Color.BLACK);
		lblBilgisayar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblBilgisayar.setBounds(10, 100, 78, 36);
		panelCondition.add(lblBilgisayar);
		btnYenidenOyna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelSifirlama();
			}
		});

		btnYenidenOyna.setForeground(Color.BLACK);
		btnYenidenOyna.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnYenidenOyna.setBounds(10, 169, 269, 55);
		panelCondition.add(btnYenidenOyna);

		lblOyuncuPuan.setForeground(Color.BLACK);
		lblOyuncuPuan.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblOyuncuPuan.setBounds(100, 54, 78, 36);
		panelCondition.add(lblOyuncuPuan);

		lblBilgisayarPuan.setForeground(Color.BLACK);
		lblBilgisayarPuan.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblBilgisayarPuan.setBounds(100, 100, 78, 36);
		panelCondition.add(lblBilgisayarPuan);

		panelSkor.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSkor.setBounds(602, 310, 289, 368);
		w_panel.add(panelSkor);
		panelSkor.setLayout(null);

		lblSkor.setForeground(new Color(0, 255, 0));
		lblSkor.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		lblSkor.setBounds(10, 10, 181, 36);
		panelSkor.add(lblSkor);

		listSkorlar.setBounds(10, 40, 269, 274);
		panelSkor.add(listSkorlar);
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btnCikis.setBounds(602, 701, 289, 46);
		w_panel.add(btnCikis);

		btnCikis.setForeground(new Color(255, 0, 0));
		btnCikis.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));

		btnOyunuSfrla.setForeground(Color.MAGENTA);
		btnOyunuSfrla.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnOyunuSfrla.setBounds(612, 254, 267, 46);
		w_panel.add(btnOyunuSfrla);
	}

}
