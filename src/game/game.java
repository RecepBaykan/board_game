package game;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class game extends JPanel implements ActionListener {
	Timer timer = new Timer(20, this);
	static JFrame frame = new JFrame("Kaderimin Oyunu");
	static int level;
	static int width = 1296;
	static int height = 759;
//-----------Player1-----------------//
	static int player1_para = 10000;
	static boolean player1_yon = false;
//-----------Player2-----------------//
	static int player2_para = 10000;
	static boolean player2_yon = false;
//------------Zar Hareketi-----------//
	static int zar = 0;
	static int zar_top = 0;
	static int zar_top2 = 0;
	static boolean zar_lock = false;
	public static int sure = 5000;
	public int sure2 = timer.getDelay();
	static game game = new game();
	static object obj = new object();
	static event ev = new event();
	static boolean oyuncu_durumu = false;
	static ImageIcon icon = new ImageIcon("res//card.png");
	static int[] konumX = new int[66];
	static int[] konumY = new int[66];
	static Rectangle2D.Double player1;
	static Rectangle2D.Double player2;
	static Point p = MouseInfo.getPointerInfo().getLocation();
	static int mouseX;
	static int mouseY;
	public static int temp;
	static Random random = new Random();
	static double r;
	public static int stack;
	public static int min = 1;

	public static int max = 30;
	public static int a = 0;
	public static int b = 0;
	public static int intro;
	public static ImageIcon in = new ImageIcon("res//intro.png");
	public static float alpha = 1f;
	public static int kilit;
	public static int kilit2;
	public static int tempMoney;
	public static int sureMove = 1000;
	public static boolean main = false;
	public static int title = -100;
	public static ImageIcon bga = new ImageIcon("res//bg.png");
	public static ImageIcon tit = new ImageIcon("res//title1.png");
	public static boolean comp = false;
	public static boolean dd = false;
	public static boolean d1 = false;
	public static int d2;

	public static void main(String[] args) {

		konum();

		@SuppressWarnings("unused")
		screen screen = new screen(frame, width, height);

		frame.add(game);

		frame.setIconImage(icon.getImage());
		frame.addMouseListener((MouseListener) new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				ev.mouseY = e.getY();
				ev.mouseX = e.getX();

			}

			@Override
			public void mouseReleased(MouseEvent e) {
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

		});

		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {

					if (comp == true) {
						zar2();
					} else {
						zar();
					}

				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

	}

	// Noktalar ve konumlar
	private static void konum() {
		for (int i = 0; i <= 8; i++) {
			konumX[i] = 30;
			konumY[i] = 636 - i * 77;

		}
		for (int i = 1; i <= 12; i++) {
			konumX[i + 8] = konumX[8] + (i) * 95;
			konumY[i + 8] = konumY[8];

		}
		for (int i = 1; i <= 8; i++) {
			konumX[i + 20] = konumX[20];
			konumY[i + 20] = konumY[20] + i * 77;

		}
		for (int i = 1; i <= 2; i++) {
			konumX[i + 28] = konumX[28] - i * 95;
			konumY[i + 28] = konumY[28];
		}

		for (int i = 1; i <= 4; i++) {
			konumX[30 + i] = konumX[30];
			konumY[30 + i] = konumY[30] - i * 77;

		}
		for (int i = 1; i <= 3; i++) {
			konumX[34 + i] = konumX[34] - i * 95;
			konumY[34 + i] = konumY[34];
		}
		for (int i = 1; i <= 2; i++) {
			konumX[37 + i] = konumX[37];
			konumY[37 + i] = konumY[37] - i * 77;
		}
		for (int i = 1; i <= 2; i++) {
			konumX[39 + i] = konumX[39] - i * 95;
			konumY[39 + i] = konumY[39];
		}
		for (int i = 1; i <= 4; i++) {
			konumX[41 + i] = konumX[41];
			konumY[41 + i] = konumY[41] + i * 77;
		}
		for (int i = 1; i <= 3; i++) {
			konumX[45 + i] = konumX[45] + i * 95;
			konumY[45 + i] = konumY[45];
		}
		for (int i = 1; i <= 2; i++) {
			konumX[48 + i] = konumX[48];
			konumY[48 + i] = konumY[48] + i * 77;
		}
		for (int i = 1; i <= 7; i++) {
			konumX[50 + i] = konumX[50] - i * 95;
			konumY[50 + i] = konumY[50];
		}

		for (int i = 0; i <= 57; i++) {

		}
		for (int i = 1; i <= 8; i++) {
			konumX[57 + i] = -300;
			konumY[57 + i] = -300;
		}

	}

	public void paintComponent(Graphics g) {
		if (ev.player2_money <= 0) {
			ev.player2_money = 0;
		}
		if (ev.player1_money <= 0) {
			ev.player1_money = 0;
		}

		if (dd == true) {

			if (zar_lock == false) {
				zar = random.nextInt(1, 6);

				if (ev.kaderi2[0] == true) {
					ev.player2_money = ev.player2_money - 2500;
				}

				zar_top2 += zar;

				// -----------------------------------------------------------------------------------------//

				if (ev.p2_kitty == true) {

					temp = (int) (ev.player2_money * ev.yuzde2 / 100 * ev.kitty / 10);

					ev.player2_money = (int) (ev.player2_money * (100 - ev.yuzde2) / 100 + temp);

				}
				zar_lock = true;
				dd = false;
			}

		}

		Graphics2D g2 = (Graphics2D) g;

		super.paintComponent(g);

		if (intro <= timer.getDelay() * 125) {
			if (intro >= timer.getDelay() * 76) {
				alpha -= 0.02f;
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, alpha));
			} else {
				main = true;

			}
			in.paintIcon(this, g2, 0, 0);
			intro += timer.getDelay();

		} else {
			if (main == true) {
				bga.paintIcon(this, g2, 0, 0);
				if (title <= -40) {
					title += 2;
				} else {
					g2.setColor(Color.LIGHT_GRAY);
					g2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 37));
					Rectangle mouse = new Rectangle(ev.mouseX, ev.mouseY, 10, 10);
					Rectangle p2 = new Rectangle(535, 320, 146, 33);
					Rectangle compp = new Rectangle(535, 360, 214, 33);
					g.drawString("1P VS 2P", 535, 320);
					g.drawString("1P VS COMP", 535, 360);
					g.drawString("Hakkýnda", 540, 400);
					g.drawString("Çýkýþ", 540, 440);

					if (mouse.intersects(p2)) {
						main = false;
					}
					if (mouse.intersects(compp)) {

					}

				}

				tit.paintIcon(this, g2, 360, title);

			} else {
				tahta(g);
				player1 = new Rectangle2D.Double(konumX[zar_top], konumY[zar_top], 30, 30);
				player2 = new Rectangle2D.Double(konumX[zar_top2] + 58, konumY[zar_top2] + 38, 30, 30);

				g.drawString("Nafaka", 154, 220);
				g.drawString("Nafaka", 320, 220);
				g.drawString("Kilitli", 154, 240);
				g.drawString("Kilitli", 320, 240);
				if (ev.kaderi1[0] == true) {
					g.setColor(Color.red);
					g.drawString(": Ödüyor", 195, 220);
				}
				if (ev.kaderi2[0] == true) {
					g.setColor(Color.red);
					g.drawString(": Ödüyor", 195 + 164, 220);
				}

				if (ev.kaderi1[7] == true) {
					g.setColor(Color.red);
					g.drawString(": Evet", 195, 240);
				}
				if (ev.kaderi2[7] == true) {
					g.setColor(Color.red);
					g.drawString(": Evet", 195 + 164, 240);
				}
				g.setColor(Color.BLACK);

				if (ev.turn == false) {
					g.setColor(Color.BLUE);
					g.fillRect(konumX[zar_top], konumY[zar_top], 30, 30);

				}
				g.setColor(Color.black);
				if (ev.turn == true) {
					g.setColor(Color.BLUE);
					g.fillRect(konumX[zar_top2] + 58, konumY[zar_top2] + 38, 30, 30);
				}
				g.setColor(Color.black);

				g2.draw(player1);
				g2.draw(player2);
			}
			if (ev.kaderi1[7] == true) {
				g.setColor(Color.red);
				g2.draw(player1);
			}
			if (ev.kaderi2[7] == true) {
				g.setColor(Color.red);
				g2.draw(player2);
			}

			if (zar_lock == true) {

				etkilesim(g);

			}

		}

		timer.start();

	}

	public static void tahta(Graphics g) {

		// ---------Oyun Tahtasý--------///

		obj.board(g, ev.player1_money, ev.player2_money, r);
		obj.kaderim(g);
		// ------------------------Borsa Kutularý----------------------------//
		if (ev.turn == true) {
			a = 58;
			b = 38;
		} else {
			a = 0;
			b = 0;
		}

		// --------------- Teklif Kutularý -------------//
		obj.teklif(0, konumX[8] + a, konumY[8] + b);
		obj.teklif(1, konumX[19] + a, konumY[19] + b);
		obj.teklif(2, konumX[25] + a, konumY[25] + b);
		obj.teklif(3, konumX[36] + a, konumY[36] + b);
		obj.teklif(4, konumX[31] + a, konumY[31] + b);
		obj.teklif(5, konumX[55] + a, konumY[55] + b);
		obj.teklif(6, -100, -100);
		obj.teklif(7, -100, -100);
		obj.teklif(8, -100, -100);
		obj.teklif(9, -100, -100);
		obj.teklif(10, -100, -100);
		obj.teklif(11, -100, -100);

		// ---------------Borsa kutular --------------//
		obj.borsa(0, konumX[6] + a, konumY[6] + b);
		obj.borsa(1, konumX[16] + a, konumY[16] + b);
		obj.borsa(2, konumX[22] + a, konumY[22] + b);
		obj.borsa(3, konumX[27] + a, konumY[27] + b);
		obj.borsa(4, konumX[32] + a, konumY[32] + b);
		obj.borsa(5, konumX[38] + a, konumY[38] + b);
		obj.borsa(6, konumX[44] + a, konumY[44] + b);
		obj.borsa(7, konumX[49] + a, konumY[49] + b);
		obj.borsa(8, konumX[54] + a, konumY[54] + b);
		obj.borsa(9, -1000, -1000);
		obj.borsa(10, -1000, -1000);
		obj.borsa(11, -1000, -1000);

		// -------------------------iflas kutularý----------------------------//
		obj.iflas(0, konumX[4], konumY[4]);
		obj.iflas(1, konumX[9], konumY[9]);
		obj.iflas(2, konumX[14], konumY[14]);
		obj.iflas(3, konumX[23], konumY[23]);
		obj.iflas(4, konumX[37], konumY[37]);
		obj.iflas(5, konumX[52], konumY[52]);
		obj.iflas(6, konumX[57], konumY[57]);
		obj.iflas(7, -333, -333);
		obj.iflas(8, -333, -333);
		obj.iflas(9, -333, -333);
		obj.iflas(10, -333, -333);
		obj.iflas(11, -333, -333);
		// ------------------------Para kutularý-----------------------------//

		obj.paracik(0, konumX[1], konumY[1]);
		obj.paracik(1, konumX[5], konumY[5]);
		obj.paracik(2, konumX[7], konumY[7]);
		obj.paracik(3, konumX[13], konumY[13]);
		obj.paracik(4, konumX[18], konumY[18]);
		obj.paracik(5, konumX[20], konumY[20]);
		obj.paracik(6, konumX[24], konumY[24]);
		obj.paracik(7, konumX[29], konumY[29]);
		obj.paracik(8, konumX[30], konumY[30]);
		obj.paracik(9, konumX[39], konumY[39]);
		obj.paracik(10, konumX[47], konumY[47]);
		obj.paracik(11, konumX[53], konumY[53]);

		// ------------------------Move kutularý-----------------------------//
		obj.move(0, konumX[3], konumY[3]);
		obj.move(1, konumX[41], konumY[41]);
		obj.move(2, konumX[11], konumY[11]);
		obj.move(3, konumX[17], konumY[17]);
		obj.move(4, konumX[26], konumY[26]);
		obj.move(5, konumX[42], konumY[42]);
		obj.move(6, konumX[50], konumY[50]);
		obj.move(7, konumX[48], konumY[48]);
		obj.move(8, konumX[34], konumY[34]);
		obj.move(9, konumX[45], konumY[45]);
		obj.move(10, konumX[30], konumY[2]);
		obj.move(11, konumX[12], konumY[12]);

		// ------------------------Kader kutularý-----------------------------//
		obj.kader2(0, konumX[2] + a, konumY[2] + b);
		obj.kader2(1, konumX[10] + a, konumY[10] + b);
		obj.kader2(2, konumX[15] + a, konumY[15] + b);
		obj.kader2(3, konumX[21] + a, konumY[21] + b);
		obj.kader2(4, konumX[28] + a, konumY[28] + b);
		obj.kader2(5, konumX[35] + a, konumY[35] + b);
		obj.kader2(6, konumX[40] + a, konumY[40] + b);
		obj.kader2(7, konumX[43] + a, konumY[43] + b);
		obj.kader2(8, konumX[46] + a, konumY[46] + b);
		obj.kader2(9, konumX[51] + a, konumY[51] + b);
		obj.kader2(10, konumX[56] + a, konumY[56] + b);
		obj.kader2(11, -333, -333);

	}

	public void etkilesim(Graphics g) {
System.out.println(ev.turn);
System.out.println("a" + ev.tekliff[4]);
		
		for (int a = 0; a <= 11; a++) {

			if (ev.turn == false) {
				// teklif 0 //
				if (obj.teklif[a].intersects(player1)) {

					ev.teklif(g);
					if (ev.tekGec <= 500) {

					} else {

						if (ev.tekliff[0] == true) {
							ev.player1_money += 5000;

							ev.tekliff[0] = false;
						}

						if (ev.tekliff[1] == true) {
							ev.player1_money += 5000;
							ev.tekliff[1] = false;

						}

						if (ev.tekliff[2] == true) {
							ev.player1_money += 10000;
							
							
							ev.tekliff[2] = false;
						}

						if (ev.tekliff[3] == true) {
							ev.player1_money -= 3000;
							ev.tekliff[3] = false;
						}

						if (ev.tekliff[4] == true) {

							zar_top += 4;
							
							ev.rt = random.nextInt(0, ev.teklifler.length - 1);
							
							
							
							
							

						}

						if (ev.tekliff[5] == true) {

							zar_top -= 4;
						
							ev.rt = random.nextInt(0, ev.teklifler.length - 1);
							
							
							

						}

						if (ev.tekliff[6] == true) {
							ev.player1_money += 5000;
							ev.tekliff[6] = false;

						}
						if (ev.tekliff[7] == true) {
							ev.player1_money += 5000;
							ev.tekliff[7] = false;

						}

						if (ev.tekliff[ev.rt] == false) {

							zar_lock = false;
							ev.turn = true;
							ev.tekGec = 0;
							ev.rt = random.nextInt(0, ev.teklifler.length - 1);

						}

					}
				}

				if (obj.iflas[a].intersects(player1)) {
					ev.ifSure += 10;
					if (ev.ifSure <= 500) {
						ev.iflas(g);

					} else {
						ev.ifSure = 0;
						ev.player1_money = 0;
						zar_lock = false;
						ev.turn = true;
					}

				}

				if (obj.paracik[a].intersects(player1)) {

					if (a == 0) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 2000);
						if (ev.sureParacik >= 500) {
							ev.player1_money = ev.player1_money + 2000;
							zar_lock = false;
							ev.turn = true;
							ev.sureParacik = 0;

						}

					}
					if (a == 1) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 3000);
						if (ev.sureParacik >= 500) {
							ev.player1_money = ev.player1_money - 3000;
							zar_lock = false;
							ev.turn = true;
							ev.sureParacik = 0;

						}

					}
					if (a == 2) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 4000);
						if (ev.sureParacik >= 500) {
							ev.player1_money = ev.player1_money + 4000;
							zar_lock = false;
							ev.turn = true;
							ev.sureParacik = 0;

						}

					}
					if (a == 3) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 6000);
						if (ev.sureParacik >= 500) {
							ev.player1_money = ev.player1_money + 6000;
							zar_lock = false;
							ev.turn = true;
							ev.sureParacik = 0;

						}

					}
					if (a == 4) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 8000);
						if (ev.sureParacik >= 500) {
							ev.player1_money = ev.player1_money + 8000;
							zar_lock = false;
							ev.turn = true;
							ev.sureParacik = 0;

						}

					}
					if (a == 5) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 20000);
						if (ev.sureParacik >= 500) {
							ev.player1_money = ev.player1_money - 20000;
							zar_lock = false;
							ev.turn = true;
							ev.sureParacik = 0;

						}

					}
					if (a == 6) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 9000);
						if (ev.sureParacik >= 500) {
							ev.player1_money = ev.player1_money + 9000;
							zar_lock = false;
							ev.turn = true;
							ev.sureParacik = 0;

						}

					}
					if (a == 7) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 6000);
						if (ev.sureParacik >= 500) {
							ev.player1_money = ev.player1_money - 6000;
							zar_lock = false;
							ev.turn = true;
							ev.sureParacik = 0;

						}

					}
					if (a == 8) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 10000);
						if (ev.sureParacik >= 500) {
							ev.player1_money = ev.player1_money + 10000;
							zar_lock = false;
							ev.turn = true;
							ev.sureParacik = 0;

						}

					}
					if (a == 9) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 2000);
						if (ev.sureParacik >= 500) {
							ev.player1_money = ev.player1_money - 2000;
							zar_lock = false;
							ev.turn = true;
							ev.sureParacik = 0;

						}

					}
					if (a == 10) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 3000);
						if (ev.sureParacik >= 500) {
							ev.player1_money = ev.player1_money + 3000;
							zar_lock = false;
							ev.turn = true;
							ev.sureParacik = 0;

						}

					}
					if (a == 11) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 1000);
						if (ev.sureParacik >= 500) {
							ev.player1_money = ev.player1_money - 1000;
							zar_lock = false;
							ev.turn = true;
							ev.sureParacik = 0;

						}

					}

				}

				// --------- Move ------------//
				if (obj.move[a].intersects(player1)) {

					if (a == 11) {
						ev.sureMove += 10;
						ev.move(g, a - 8);
						if (ev.sureMove >= 500) {
							zar_top += a - 8;
							ev.sureMove = 0;
							etkilesim(g);

						}

					}

					if (a == 3) {
						ev.sureMove += 10;
						ev.move(g, a);
						if (ev.sureMove >= 500) {
							zar_top += a;
							ev.sureMove = 0;
							etkilesim(g);

						}

					}
					if (a == 9) {
						ev.sureMove += 10;
						ev.move(g, 9 - 6);
						if (ev.sureMove >= 500) {
							zar_top += 9 - 6;
							ev.sureMove = 0;
							etkilesim(g);

						}

					}
					if (a == 8) {
						ev.sureMove += 10;
						ev.move(g, a - 5);
						if (ev.sureMove >= 500) {
							zar_top += a - 5;
							ev.sureMove = 0;
							etkilesim(g);

						}

					}
					if (a == 0) {
						ev.sureMove += 10;
						ev.move(g, a + 1);
						if (ev.sureMove >= 500) {
							zar_top += a + 1;
							ev.sureMove = 0;
							etkilesim(g);

						}

					}
					if (a == 7) {
						ev.sureMove += 10;
						ev.move(g, a - 6);
						if (ev.sureMove >= 500) {
							zar_top += a - 6;
							ev.sureMove = 0;
							etkilesim(g);

						}

					}
					if (a == 1) {
						ev.sureMove += 10;
						ev.move(g, a);
						if (ev.sureMove >= 500) {
							zar_top += a;
							ev.sureMove = 0;
							etkilesim(g);

						}

					}
					if (a == 4) {
						ev.sureMove += 10;
						ev.move(g, a - 2);
						if (ev.sureMove >= 500) {
							zar_top -= a - 2;
							ev.sureMove = 0;
							etkilesim(g);

						}
					}
					if (a == 6) {
						ev.sureMove += 10;
						ev.move(g, a - 4);
						if (ev.sureMove >= 500) {
							zar_top -= a - 4;
							ev.sureMove = 0;
							etkilesim(g);

						}
					}
					if (a == 5) {
						ev.sureMove += 10;
						ev.move(g, a - 3);
						if (ev.sureMove >= 500) {
							zar_top -= a - 3;
							ev.sureMove = 0;
							etkilesim(g);

						}
					}

					if (a == 2) {
						ev.sureMove += 10;
						ev.move(g, a);
						if (ev.sureMove >= 500) {
							zar_top -= a;
							ev.sureMove = 0;
							etkilesim(g);
						}
					}
				}
				// --------Kader Nesnesi ----------------//
				// ----Kader P1----//
				if (obj.kader2[a].intersects(player1)) {

					ev.kader(g, sure2);
					if (ev.sure <= 0) {
						ev.turn = true;
						zar_lock = false;

						// ---- Kader[1]------//
						if (ev.kaderi1[1] == true) {
							ev.player1_money = ev.player1_money + 12000;
							ev.kaderi1[1] = false;
						}
						// ---- Kader[1]------//
						if (ev.kaderi1[2] == true) {
							ev.player1_money = ev.player1_money + 5000;
							ev.kaderi1[2] = false;
						}
						// ---- Kader[3]------//
						if (ev.kaderi1[3] == true) {
							ev.player1_money = ev.player1_money - 3000;
							ev.kaderi1[3] = false;
						}
						// ---- Kader[4]------//
						if (ev.kaderi1[4] == true) {
							ev.player1_money = ev.player1_money + 2000;
							ev.kaderi1[4] = false;
						}
						// ---- Kader[5]------//
						if (ev.kaderi1[5] == true) {
							ev.player1_money = ev.player1_money + 4000;
							ev.kaderi1[5] = false;
						}
						// ---- Kader[6]------//
						if (ev.kaderi1[6] == true) {
							ev.player1_money = ev.player1_money - 5000;
							ev.kaderi1[6] = false;
						}
						// --------Kader[8]--------//
						if (ev.kaderi1[8] == true) {
							ev.player1_money = 0;
							ev.kaderi1[8] = false;
						}
						// --------Kader[9]--------//
						if (ev.kaderi1[9] == true) {
							tempMoney = ev.player1_money;
							ev.player1_money = ev.player2_money;
							ev.player2_money = tempMoney;
							ev.kaderi1[9] = false;
						}
						if (ev.kaderi1[10] == true) {

							ev.player2_money = ev.player2_money - 5000;
							ev.kaderi1[10] = false;
						}
						if (ev.kaderi1[11] == true) {

							ev.player1_money = ev.player1_money - 5000;
							ev.kaderi1[11] = false;
						}
						if (ev.kaderi1[12] == true) {

							ev.player1_money = ev.player1_money + 2000;
							ev.kaderi1[12] = false;
						}
						if (ev.kaderi1[13] == true) {

							ev.player1_money = ev.player1_money - 2000;
							ev.kaderi1[13] = false;
						}
						if (ev.kaderi1[14] == true) {

							ev.player1_money = ev.player1_money - 7000;
							ev.kaderi1[14] = false;
						}
						if (ev.kaderi1[15] == true) {

							ev.player1_money = ev.player1_money + 8000;
							ev.kaderi1[15] = false;
						}
						if (ev.kaderi1[16] == true) {

							ev.player1_money = ev.player1_money - 8000;
							ev.kaderi1[16] = false;
						}
						ev.c = 0;
						ev.dr = "";
						ev.a = 0;
						ev.b = 0;
						ev.kaderX = -100;
						ev.rr = ev.rr = random.nextInt(0, ev.kaderim.length - 1);
						if (ev.kaderi1[0] == true) {
							ev.rr = random.nextInt(0, ev.kaderim.length - 1);
							while (ev.rr == 0) {
								ev.rr = random.nextInt(0, ev.kaderim.length - 1);
							}
						}
						if (ev.kaderi1[7] == true) {
							ev.rr = random.nextInt(0, ev.kaderim.length - 1);
							while (ev.rr == 7) {
								ev.rr = random.nextInt(0, ev.kaderim.length - 1);
							}
						}
						ev.sure = 5000;
					}
				}
				// ----Borsa P1----//
				if (obj.borsa[a].intersects(player1)) {

					ev.borsa(g, sure2);
					if (ev.sure <= 0) {

						zar_lock = false;
						ev.sure = 5000;
						ev.turn = true;

					}

				}

			} else {
				if (obj.teklif[a].intersects(player2)) {

					ev.teklif(g);
					if (ev.tekGec <= 500) {
						if (comp == true) {
							ev.tekGec += 10;
							if (d1 == false) {
								d2 = 1;
								d1 = true;
							}
							if (d2 == 1) {
								ev.tekliff[ev.rt] = true;
							} else {
								ev.tekliff[ev.rt] = false;
							}

						}

					} else {

						if (ev.tekliff[0] == true) {
							ev.player2_money += 5000;
							ev.tekliff[0] = false;

						}

						if (ev.tekliff[1] == true) {
							ev.player2_money += 5000;
							ev.tekliff[1] = false;
							

						}

						if (ev.tekliff[2] == true) {
							
							ev.player2_money += 10000;
							ev.tekliff[2] = false;

						}

						if (ev.tekliff[3] == true) {
							ev.player2_money -= 3000;

							ev.tekliff[3] = false;
						}

						if (ev.tekliff[4] == true) {

							zar_top2 += 4;
							ev.rt = random.nextInt(0, ev.teklifler.length - 1);
							ev.tekliff[4] = false;
							
						

						}

						if (ev.tekliff[5] == true) {

							zar_top2 -= 4;
							ev.rt = random.nextInt(0, ev.teklifler.length - 1);
							ev.tekliff[4] = false;
							
						
							

						}

						if (ev.tekliff[6] == true) {
							ev.player2_money += 5000;
							ev.tekliff[6] = false;
							

						}
						if (ev.tekliff[7] == true) {
							ev.player2_money += 5000;
							ev.tekliff[7] = false;
							

						}

						if (ev.tekliff[ev.rt] == false) {

							zar_lock = false;
							ev.turn = false;
							ev.tekGec = 0;
							ev.rt = random.nextInt(0, ev.teklifler.length - 1);

						}

					}
				}

				if (obj.iflas[a].intersects(player2)) {
					ev.ifSure += 10;
					if (ev.ifSure <= 500) {
						ev.iflas(g);

					} else {
						ev.ifSure = 0;
						ev.player2_money = 0;
						zar_lock = false;
						ev.turn = false;
					}

				}
				if (obj.paracik[a].intersects(player2)) {

					if (a == 0) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 2000);
						if (ev.sureParacik >= 500) {
							ev.player2_money = ev.player2_money + 2000;
							zar_lock = false;
							ev.turn = false;
							ev.sureParacik = 0;

						}

					}
					if (a == 1) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 3000);
						if (ev.sureParacik >= 500) {
							ev.player2_money = ev.player2_money - 3000;
							zar_lock = false;
							ev.turn = false;
							ev.sureParacik = 0;

						}

					}
					if (a == 2) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 4000);
						if (ev.sureParacik >= 500) {
							ev.player2_money = ev.player2_money + 4000;
							zar_lock = false;
							ev.turn = false;
							ev.sureParacik = 0;

						}

					}
					if (a == 3) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 6000);
						if (ev.sureParacik >= 500) {
							ev.player2_money = ev.player2_money + 6000;
							zar_lock = false;
							ev.turn = false;
							ev.sureParacik = 0;

						}

					}
					if (a == 4) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 8000);
						if (ev.sureParacik >= 500) {
							ev.player2_money = ev.player2_money + 8000;
							zar_lock = false;
							ev.turn = false;
							ev.sureParacik = 0;

						}

					}
					if (a == 5) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 20000);
						if (ev.sureParacik >= 500) {
							ev.player2_money = ev.player2_money - 20000;
							zar_lock = false;
							ev.turn = false;
							ev.sureParacik = 0;

						}

					}
					if (a == 6) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 9000);
						if (ev.sureParacik >= 500) {
							ev.player2_money = ev.player2_money + 9000;
							zar_lock = false;
							ev.turn = false;
							ev.sureParacik = 0;

						}

					}
					if (a == 7) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 6000);
						if (ev.sureParacik >= 500) {
							ev.player2_money = ev.player2_money - 6000;
							zar_lock = false;
							ev.turn = false;
							ev.sureParacik = 0;

						}

					}
					if (a == 8) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 10000);
						if (ev.sureParacik >= 500) {
							ev.player2_money = ev.player2_money + 10000;
							zar_lock = false;
							ev.turn = false;
							ev.sureParacik = 0;

						}

					}
					if (a == 9) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 2000);
						if (ev.sureParacik >= 500) {
							ev.player2_money = ev.player2_money - 2000;
							zar_lock = false;
							ev.turn = false;
							ev.sureParacik = 0;

						}

					}
					if (a == 10) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 3000);
						if (ev.sureParacik >= 500) {
							ev.player2_money = ev.player2_money + 3000;
							zar_lock = false;
							ev.turn = false;
							ev.sureParacik = 0;

						}

					}
					if (a == 11) {
						ev.sureParacik += 10;
						ev.paracik(g, a, 1000);
						if (ev.sureParacik >= 500) {
							ev.player2_money = ev.player2_money - 1000;
							zar_lock = false;
							ev.turn = false;
							ev.sureParacik = 0;

						}

					}

				}

				// -------- Move --------------//

				if (obj.move[a].intersects(player2)) {

					if (a == 11) {
						ev.sureMove += 10;
						ev.move(g, a - 8);
						if (ev.sureMove >= 500) {
							zar_top2 += a - 8;
							ev.sureMove = 0;
							etkilesim(g);

						}

					}
					if (a == 3) {
						ev.sureMove += 10;
						ev.move(g, a);
						if (ev.sureMove >= 500) {
							zar_top2 += a;
							ev.sureMove = 0;
							etkilesim(g);

						}

					}
					if (a == 9) {
						ev.sureMove += 10;
						ev.move(g, 9 - 6);
						if (ev.sureMove >= 500) {
							zar_top2 += 9 - 6;
							ev.sureMove = 0;
							etkilesim(g);

						}

					}
					if (a == 8) {
						ev.sureMove += 10;
						ev.move(g, a - 5);
						if (ev.sureMove >= 500) {
							zar_top2 += a - 5;
							ev.sureMove = 0;
							etkilesim(g);

						}

					}
					if (a == 0) {
						ev.sureMove += 10;
						ev.move(g, a + 1);
						if (ev.sureMove >= 500) {
							zar_top2 += a + 1;
							ev.sureMove = 0;
							etkilesim(g);

						}

					}
					if (a == 7) {
						ev.sureMove += 10;
						ev.move(g, a - 6);
						if (ev.sureMove >= 500) {
							zar_top2 += a - 6;
							ev.sureMove = 0;
							etkilesim(g);

						}

					}
					if (a == 1) {
						ev.sureMove += 10;
						ev.move(g, a);
						if (ev.sureMove >= 500) {
							zar_top2 += a;
							ev.sureMove = 0;
							etkilesim(g);

						}

					}
					if (a == 4) {
						ev.sureMove += 10;
						ev.move(g, a - 2);
						if (ev.sureMove >= 500) {
							zar_top2 -= a - 2;
							ev.sureMove = 0;
							etkilesim(g);

						}
					}
					if (a == 5) {
						ev.sureMove += 10;
						ev.move(g, a - 3);
						if (ev.sureMove >= 500) {
							zar_top2 -= a - 3;
							ev.sureMove = 0;
							etkilesim(g);

						}
					}
					if (a == 2) {
						ev.sureMove += 10;
						ev.move(g, a);
						if (ev.sureMove >= 500) {
							zar_top2 -= a;
							ev.sureMove = 0;
							etkilesim(g);

						}
					}
				}

				// ----Kader P1----//
				if (obj.kader2[a].intersects(player2)) {
					ev.kader(g, sure2);
					if (ev.sure <= 0) {
						zar_lock = false;
						ev.turn = false;
						// ---- Kader[1]------//
						if (ev.kaderi2[1] == true) {
							ev.player2_money = ev.player2_money + 12000;
							ev.kaderi2[1] = false;
						}
						// ---- Kader[2]------//
						if (ev.kaderi2[2] == true) {
							ev.player2_money = ev.player2_money + 5000;
							ev.kaderi2[2] = false;
						}
						// ---- Kader[3]------//
						if (ev.kaderi2[3] == true) {
							ev.player2_money = ev.player2_money - 3000;
							ev.kaderi2[3] = false;
						}
						// ---- Kader[4]------//
						if (ev.kaderi2[4] == true) {
							ev.player2_money = ev.player2_money + 2000;
							ev.kaderi2[4] = false;
						}
						// ---- Kader[5]------//
						if (ev.kaderi2[5] == true) {
							ev.player2_money = ev.player2_money + 4000;
							ev.kaderi2[5] = false;
						}
						// ---- Kader[6]------//
						if (ev.kaderi2[6] == true) {
							ev.player2_money = ev.player2_money - 5000;
							ev.kaderi2[6] = false;
						}
						if (ev.kaderi2[8] == true) {
							ev.player2_money = 0;
							ev.kaderi2[8] = false;
						}
						if (ev.kaderi2[9] == true) {
							tempMoney = ev.player2_money;
							ev.player2_money = ev.player1_money;
							ev.player1_money = tempMoney;
							ev.kaderi1[9] = false;
						}
						if (ev.kaderi2[10] == true) {
							ev.player1_money = ev.player1_money - 5000;
							ev.kaderi2[10] = false;
						}
						if (ev.kaderi2[11] == true) {

							ev.player2_money = ev.player2_money - 5000;
							ev.kaderi2[11] = false;
						}
						if (ev.kaderi2[12] == true) {

							ev.player2_money = ev.player2_money + 2000;
							ev.kaderi2[12] = false;
						}
						if (ev.kaderi2[13] == true) {

							ev.player2_money = ev.player2_money - 2000;
							ev.kaderi2[13] = false;
						}
						if (ev.kaderi2[14] == true) {

							ev.player2_money = ev.player2_money - 7000;
							ev.kaderi2[14] = false;
						}
						if (ev.kaderi2[15] == true) {

							ev.player2_money = ev.player2_money + 8000;
							ev.kaderi2[15] = false;
						}
						if (ev.kaderi2[16] == true) {

							ev.player2_money = ev.player2_money - 8000;
							ev.kaderi2[16] = false;
						}
						ev.a = 0;
						ev.b = 0;
						ev.c = 0;
						ev.dr = "";
						ev.kaderX = -100;
						ev.rr = random.nextInt(0, ev.kaderim.length - 1);
						if (ev.kaderi2[0] == true) {
							ev.rr = random.nextInt(0, ev.kaderim.length - 1);
							while (ev.rr == 0) {
								ev.rr = random.nextInt(0, ev.kaderim.length - 1);
							}
						}
						if (ev.kaderi2[7] == true) {
							ev.rr = random.nextInt(0, ev.kaderim.length - 1);
							while (ev.rr == 7) {
								ev.rr = random.nextInt(0, ev.kaderim.length - 1);
							}
						}

						ev.sure = 5000;

					}
				}
				// ----Borsa P2----//
				if (obj.borsa[a].intersects(player2)) {

					ev.borsa(g, sure2);
					if (ev.sure <= 0) {
						zar_lock = false;
						ev.sure = 5000;
						ev.turn = false;

					}

				}

			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		repaint();

	}

	public static int para(int para, int miktar) {
		para = para + miktar;
		return para;

	}

	public static void zar() {
		ev.rt = 5;
		ev.teklifX = -100;
		ev.sureMove = 0;
		ev.ifSure = 0;
		ev.mouseX = 0;
		ev.mouseY = 0;
		System.out.println(zar);
		if (ev.player2_money <= 0) {
			ev.player2_money = 0;
		}
		if (ev.player1_money <= 0) {
			ev.player1_money = 0;
		}

		if (zar_lock == false) {
			zar = random.nextInt(1, 6);
			// ---------Borsa Oran Ayarý --------//
			ev.kitty = random.nextInt(min, max);

			if (ev.kitty >= 20) {
				stack += 1;
			}
			if (stack >= 3) {
				stack += 1;
				max = 11;
				if (stack >= 7) {
					max = 30;
					stack = 0;
				}
			}
			r = ev.kitty / 10;

			// ----- Player 1 -----//
			if (ev.turn == false) {

				// ------------------------------Kaderler---------------------------------------------------//
				// ---- Kader[0]------//
				if (ev.kaderi1[0] == true) {
					ev.player1_money = ev.player1_money - 2500;

				}

				// ---- Kader[6]------//

				zar_top += 2;

				// -----------------------------------------------------------------------------------------//

				if (ev.p1_kitty == true) {

					temp = (int) (ev.player1_money * ev.yuzde1 / 100 * ev.kitty / 10);

					ev.player1_money = (int) (ev.player1_money * (100 - ev.yuzde1) / 100 + temp);

				}

				// ----- Player 2 -----//
			} else {

				// ------------------------------Kaderler---------------------------------------------------//
				// ---- Kader[0]------//
				if (ev.kaderi2[0] == true) {
					ev.player2_money = ev.player2_money - 2500;
				}

				zar_top2 += 2;

				// -----------------------------------------------------------------------------------------//

				if (ev.p2_kitty == true) {

					temp = (int) (ev.player2_money * ev.yuzde2 / 100 * ev.kitty / 10);

					ev.player2_money = (int) (ev.player2_money * (100 - ev.yuzde2) / 100 + temp);

				}

			}
			if (ev.player2_money <= 0) {
				ev.player2_money = 0;
			}
			if (ev.player1_money <= 0) {
				ev.player1_money = 0;
			}
			zar_lock = true;

		} else {

		}

	}

	public static void zar2() {
		ev.mouseX = 0;
		ev.mouseY = 0;

		if (ev.player2_money <= 0) {
			ev.player2_money = 0;
		}
		if (ev.player1_money <= 0) {
			ev.player1_money = 0;
		}

		if (zar_lock == false) {
			zar = random.nextInt(1, 6);
			// ---------Borsa Oran Ayarý --------//
			ev.kitty = random.nextInt(min, max);

			if (ev.kitty >= 20) {
				stack += 1;
			}
			if (stack >= 3) {
				stack += 1;
				max = 11;
				if (stack >= 7) {
					max = 30;
					stack = 0;
				}
			}
			r = ev.kitty / 10;

			// ----- Player 1 -----//
			if (ev.turn == false) {

				// ------------------------------Kaderler---------------------------------------------------//
				// ---- Kader[0]------//
				if (ev.kaderi1[0] == true) {
					ev.player1_money = ev.player1_money - 2500;

				}

				// ---- Kader[6]------//

				zar_top += 1;

				// -----------------------------------------------------------------------------------------//

				if (ev.p1_kitty == true) {

					temp = (int) (ev.player1_money * ev.yuzde1 / 100 * ev.kitty / 10);

					ev.player1_money = (int) (ev.player1_money * (100 - ev.yuzde1) / 100 + temp);

				}

				// ----- Player 2 -----//
			}
			zar_lock = true;
			dd = true;
		}

	}
}
