package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class event extends JPanel {
	public static int player1_money = 10000;
	public static int player2_money = 10000;
	public static int mouseX;
	public static int mouseY;
	public static boolean turn = false;
	ImageIcon bg = new ImageIcon("res//event//blur1.png");

	public static int sure = 2000;

	// --------Kripto Borsa Event---------//
	ImageIcon borsa = new ImageIcon("res//event//kittyCoin.png");
	public static int yuzde1;
	public static int yuzde2;
	public static double kitty;
	public static boolean p1_kitty = false;
	public static boolean p2_kitty = false;

	public void borsa(Graphics g, int sure2) {
		g.setColor(Color.black);
		g.drawString("Kalan sure = " + sure, 100, 100);
		sure -= sure2;
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 17));
		bg.paintIcon(this, g2, 0, 0);
		borsa.paintIcon(this, g, 378, 180);
		g.drawString("Servetinin y�zde ka��n� \nKitty Coin'e yat�r�yorsun?", 410, 340);
		g.drawString("      y�zde 10", 410, 380);
		g.drawString("      y�zde 20", 410, 430);
		g.drawString("      y�zde 40", 410, 470);
		g.drawString("      y�zde 50", 410, 510);

		Rectangle mouse = new Rectangle(mouseX - 10, mouseY - 30, 5, 5);
		
		Rectangle a1 = new Rectangle(405, 370, 25, 25);
		g2.drawRect(405, 370, 25, 25);
		Rectangle a2 = new Rectangle(405, 410, 25, 25);
		g2.drawRect(405, 410, 25, 25);
		Rectangle a3 = new Rectangle(405, 450, 25, 25);
		g2.drawRect(405, 450, 25, 25);
		Rectangle a4 = new Rectangle(405, 490, 25, 25);
		g2.drawRect(405, 490, 25, 25);

		if (turn == false) {

			if (a1.intersects(mouse)) {
				p1_kitty = true;
				g.setColor(Color.RED);
				g2.fillRect(405, 370, 25, 25);
				yuzde1 = 10;
				g.drawString("Servetinin y�zde " + String.valueOf(yuzde1) + " se�tin.", 600, 360);

				if (sure <= 1000) {

				} else {
					sure = 1000;

				}
				if (sure <= 0) {
					mouseX = 0;
					mouseY = 0;
				}

			}
			if (a2.intersects(mouse)) {
				p1_kitty = true;
				g.setColor(Color.RED);
				g2.fillRect(405, 410, 25, 25);
				yuzde1 = 20;
				g.drawString("Servetinin y�zde " + String.valueOf(yuzde1) + " kadar�n� se�tin.", 600, 360);

				if (sure <= 1000) {

				} else {
					sure = 1000;

				}
				if (sure <= 0) {
					mouseX = 0;
					mouseY = 0;
				}

			}
			if (a3.intersects(mouse)) {
				p1_kitty = true;
				g.setColor(Color.RED);
				g2.fillRect(405, 450, 25, 25);
				yuzde1 = 40;
				g.drawString("Servetinin y�zde " + String.valueOf(yuzde1) + " kadar�n� se�tin.", 600, 360);

				if (sure <= 1000) {

				} else {
					sure = 1000;

				}
				if (sure <= 10) {
					mouseX = 0;
					mouseY = 0;
				}

			}
			if (a4.intersects(mouse)) {
				p1_kitty = true;
				g.setColor(Color.RED);
				g2.fillRect(405, 490, 25, 25);
				yuzde1 = 50;
				g.drawString("Servetinin y�zde " + String.valueOf(yuzde1) + " kadar�n� se�tin.", 600, 360);

				if (sure <= 1000) {

				} else {
					sure = 1000;

				}
				if (sure <= 10) {
					mouseX = 0;
					mouseY = 0;
				}

			}
		} else {
			if (a1.intersects(mouse)) {
				p2_kitty = true;
				g.setColor(Color.RED);
				g2.fillRect(405, 370, 25, 25);
				yuzde2 = 10;
				g.drawString("Servetinin y�zde " + String.valueOf(yuzde2) + " kadar�n� se�tin.", 600, 360);

				if (sure <= 1000) {

				} else {
					sure = 1000;

				}
				if (sure <= 10) {
					mouseX = 0;
					mouseY = 0;
				}

			}
			if (a2.intersects(mouse)) {
				p2_kitty = true;
				yuzde2 = 20;
				g.setColor(Color.RED);
				g2.fillRect(405, 410, 25, 25);
				g.drawString("Servetinin y�zde " + String.valueOf(yuzde2) + " kadar�n� se�tin.", 600, 360);

				if (sure <= 1000) {

				} else {
					sure = 1000;

				}
				if (sure <= 10) {
					mouseX = 0;
					mouseY = 0;
				}

			}
			if (a3.intersects(mouse)) {
				p2_kitty = true;
				g.drawString("Servetinin y�zde " + String.valueOf(yuzde2) + " kadar�n� se�tin.", 600, 360);
				yuzde2 = 40;
				g.setColor(Color.RED);
				g2.fillRect(405, 450, 25, 25);

				if (sure <= 1000) {

				} else {
					sure = 1000;

				}
				if (sure <= 10) {
					mouseX = 0;
					mouseY = 0;
				}

			}
			if (a4.intersects(mouse)) {
				p2_kitty = true;
				g.setColor(Color.RED);
				g2.fillRect(405, 490, 25, 25);
				yuzde2 = 50;
				g.drawString("Servetinin y�zde " + String.valueOf(yuzde2) + " kadar�n� se�tin.", 600, 360);
				if (sure <= 1000) {

				} else {
					sure = 1000;

				}
				if (sure <= 10) {
					mouseX = 0;
					mouseY = 0;
				}

			}

		}

	}

//-----------------Para eventi ---------------------//
	// --------Kader Event---------//
	public static boolean[] kaderi1 = new boolean[17];
	public static boolean[] kaderi2 = new boolean[17];
	public static String durum = "";
	public static Random random = new Random();
	static ImageIcon kaderKart1 = new ImageIcon("res//event//kader.png");
	public static ImageIcon[] kaderEvent = new ImageIcon[17];

	private void drawString(Graphics g, String text, int x, int y) {
		for (String line : text.split("\n"))
			g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}

	public static int kaderX = -100;
	static int a = 0;
	static int b = 0;
	String dr = "";
	static int c = 0;
	public static String[] kaderim = new String[17];
	int rr = random.nextInt(0, kaderim.length - 1);
	public static int ifSure;

	public void kader(Graphics g, int sure2) {

		
		bg.paintIcon(this, g, 0, 0);
		kaderEvent[0] = new ImageIcon("res//event//kaderBosan.png");
		kaderEvent[1] = new ImageIcon("res//event//kaderHizir.png");
		kaderEvent[2] = new ImageIcon("res//event//kaderCek.png");
		kaderEvent[3] = new ImageIcon("res//event//kaderVarim.png");
		kaderEvent[4] = new ImageIcon("res//event//kaderYokum.png");
		kaderEvent[5] = new ImageIcon("res//event//kaderVarim.png");
		kaderEvent[6] = new ImageIcon("res//event//kaderYokum.png");
		kaderEvent[7] = new ImageIcon("res//event//kaderKilit.png");
		kaderEvent[8] = new ImageIcon("res//event//kaderIflas.png");
		kaderEvent[9] = new ImageIcon("res//event//kaderDegis.png");
		kaderEvent[10] = new ImageIcon("res//event//kaderH1.png");
		kaderEvent[11] = new ImageIcon("res//event//kaderH2.png");
		kaderEvent[12] = new ImageIcon("res//event//kaderUc.png");
		kaderEvent[13] = new ImageIcon("res//event//kaderUc2.png");
		kaderEvent[14] = new ImageIcon("res//event//kaderMetres.png");
		kaderEvent[15] = new ImageIcon("res//event//kaderZar.png");
		kaderEvent[16] = new ImageIcon("res//event//kaderZar2.png");
		Graphics2D g2 = (Graphics2D) g;
		kaderKart1.paintIcon(this, g, 378, kaderX);
		super.paint(g);

		if (kaderX <= 180) {
			kaderX += 5;

		} else {
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(6f));
			g2.drawRect(419, 213, a, b);
			g2.setColor(Color.LIGHT_GRAY);

			g2.fillRect(419, 213, a, b);

			if (a <= 452) {
				a += 24;
				b += 16;
			} else {
				g2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 17));
				g2.setColor(Color.black);
				g2.drawString("�u anki kaderin", 553, 250);
				if (c <= kaderim(rr).length() - 1) {

					dr = dr + kaderim(rr).charAt(c);
					c++;

				} else {

					kaderEvent[rr].paintIcon(this, g2, 674, 316);
					if (turn == false) {

						kaderi1[rr] = true;

						sure = sure - sure2;
						g.drawString(String.valueOf(sure), 10, 10);

					} else {

						kaderi2[rr] = true;

						sure = sure - sure2;
						g.drawString(String.valueOf(sure), 10, 10);

					}

				}
				drawString(g, dr, 434, 260);

			}

		}

	}

	public String kaderim(int a) {
		kaderim[0] = "Kar�n�z sizi bo�ad�. Nafaka olarak her ay\n2500 TL istiyor.";
		kaderim[1] = "H�z�r gibi bir adam imdad�na yeti�ip sana\n12.000 TL verdi.";
		kaderim[2] = "Yolda giderken bir �ek buldun. Yakla��k\n5.000 TL kazand�n bedavadan.";
		kaderim[3] = "Var m�s�n, yok musun?\nVar�m dedin ve 3000 TL kaybettin.";
		kaderim[4] = "Var m�s�n, yok musun?\nYokum dedin ve 2000 TL kazand�n.";
		kaderim[5] = "Var m�s�n, yok musun?\nVar�m dedin ve 4000 TL kazand�n.";
		kaderim[6] = "Var m�s�n, yok musun?\nYokum dedin ve 5000 TL kaybettin.";
		kaderim[7] = "�ki el boyunca kilitlendin.";
		kaderim[8] = "�flas ettin";
		kaderim[9] = "Rakibin serveti art�k senin,\nsenin �nceki servetinde art�k onun.";
		kaderim[10] = "Bu h�rs�z karde�imiz, rakipten\n5000 TL �ald�.";
		kaderim[11] = "Bu ahlaks�z h�rs�z, senden\n5000 TL �ald�";
		kaderim[12] = "�� ka��t�� gibi g�r�nen bir adam, sana i� teklifi\nediyor.\nKabul ettin\n2000 TL Kazand�n.";
		kaderim[13] = "�� ka��t�� gibi g�r�nen bir adam, sana i� teklifi\nediyor.\nKabul ettin\n2000 TL Kaybettin.";
		kaderim[14] = "Metresin ahlaks�z ��kt�.\nSenden 7000 TL �al�p ka�t�.";
		kaderim[15] = "Tek mi, �ift mi?\nTek dedin ve 8000 TL kazand�n.";
		kaderim[16] = "Tek mi, �ift mi?\n�ift dedin ve 8000 TL kaybettin.";

		return kaderim[a];

	}

	public static int sureParacik = 0;

	public void paracik(Graphics g, int a, int para) {
		Graphics2D g2 = (Graphics2D) g;
		bg.paintIcon(this, g, 0, 0);
		g2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 40));
		if (a == 0 || a == 2 || a == 3 || a == 4 || a == 6 || a == 8 || a == 10) {
			g2.setStroke(new BasicStroke(6f));
			g2.setColor(Color.black);
			g2.drawRect(480, 300, 300, 90);
			g2.setColor(Color.white);
			g2.fillRect(480, 300, 300, 90);
			g2.setColor(Color.green);
			if (a == 5) {
				g2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 37));
				g2.drawString(para + " Kaybettin", 490, 365);
			} else {
				g2.drawString(para + " Kazand�n", 490, 360);
			}

		}
		if (a == 1 || a == 5 || a == 7 || a == 9) {
			g2.setStroke(new BasicStroke(6f));
			g2.setColor(Color.black);
			g2.drawRect(480, 300, 305, 90);
			g2.setColor(Color.white);
			g2.fillRect(480, 300, 305, 90);
			g2.setColor(Color.red);
			if (a == 5) {
				g2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 37));
				g2.drawString(para + " Kaybettin", 490, 365);
			}
			g2.drawString(para + " Kaybettin", 490, 365);
		}
	}

	public static int aa = 0;
	public static int tekGec;
	ImageIcon teklif1 = new ImageIcon("res//event//teklif.png");
	public static String[] teklifler = new String[8];
	public static int teklifX = -100;
	public static boolean[] tekliff = new boolean[8];
	public static int rt = random.nextInt(0,teklifler.length-1);
	
	public void teklif(Graphics g) {
		
		Rectangle kutu = new Rectangle(580, 380, 30, 30);
		Rectangle kutu2 = new Rectangle(680, 380, 30, 30);
		Rectangle mouse = new Rectangle(mouseX - 10, mouseY - 30, 5, 5);
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 17));
		
		bg.paintIcon(this, g, 0, 0);
		teklif1.paintIcon(this, g, 378, teklifX);

		if (teklifX <= 180) {
			teklifX += 5;
		} else {
			drawString(g, teklifler(rt), 500, 260);
			
			//---- teklif ------//
			if (rt == 0) {

				g.drawString("Tek", 580, 360);
				g2.draw(kutu);
				g.drawString("�ift", 680, 360);
				g2.draw(kutu2);
				if (kutu.intersects(mouse)) {

					g.setColor(Color.red);
					g.fillRect(580, 380, 30, 30);
					if (tekGec <= 500) {
						tekGec += 10;
						g.setColor(Color.MAGENTA);
						g.drawString("5000 TL kazand�n", 500, 340);
						tekliff[rt] = true;

					}

				}
				if (kutu2.intersects(mouse)) {
					g.setColor(Color.red);
					g.fillRect(680, 380, 30, 30);
					if (tekGec <= 500) {
						tekGec += 10;
						g.setColor(Color.red);
						g.drawString("Bir �ey kazanmad�n", 500, 340);
						tekliff[rt] = false;

					}
				}
			}
			
			
			//---------- teklif 1 ---------------///
			
			if (rt == 1) {

				g.drawString("Tek", 580, 360);
				g2.draw(kutu);
				g.drawString("�ift", 680, 360);
				g2.draw(kutu2);
				if (kutu.intersects(mouse)) {

					g.setColor(Color.red);
					g.fillRect(580, 380, 30, 30);
					if (tekGec <= 500) {
						tekGec += 10;
						g.setColor(Color.MAGENTA);
						g.drawString("Bir �ey kazanmad�n", 500, 340);
						tekliff[rt] = false;

					}

				}
				if (kutu2.intersects(mouse)) {
					g.setColor(Color.red);
					g.fillRect(680, 380, 30, 30);
					if (tekGec <= 500) {
						tekGec += 10;
						g.setColor(Color.red);
						g.drawString("5000 TL kazand�n", 500, 340);
						tekliff[rt] = true;

					}
				}
			}
			
			//------- teklif 2 ---------------//
			if (rt == 2) {

				g.drawString("Evet", 575, 360);
				g2.draw(kutu);
				g.drawString("Hay�r", 675, 360);
				g2.draw(kutu2);
				if (kutu.intersects(mouse)) {

					g.setColor(Color.red);
					g.fillRect(580, 380, 30, 30);
					if (tekGec <= 500) {
						tekGec += 10;
						g.setColor(Color.MAGENTA);
						g.drawString("Dilenci aksakall� dede ��kt�. 10.000 TL Kazand�n", 420, 340);
						
						tekliff[rt] = true;

					}

				}
				if (kutu2.intersects(mouse)) {
					g.setColor(Color.red);
					g.fillRect(680, 380, 30, 30);
					if (tekGec <= 500) {
						tekGec += 10;
						g.setColor(Color.red);
						g.drawString("Dilenci aksakall� dede ��kt�. Bir �ey kazanmad�n", 420, 340);
						
						tekliff[rt] = false;

					}
				}
			}
			if (rt == 3) {

				g.drawString("Evet", 575, 360);
				g2.draw(kutu);
				g.drawString("Hay�r", 675, 360);
				g2.draw(kutu2);
				if (kutu.intersects(mouse)) {

					g.setColor(Color.red);
					g.fillRect(580, 380, 30, 30);
					if (tekGec <= 500) {
						tekGec += 10;
						g.setColor(Color.MAGENTA);
						g.drawString("Dilenciye 3000 TL verdin.", 500, 340);
						
						tekliff[rt] = true;

					}

				}
				if (kutu2.intersects(mouse)) {
					g.setColor(Color.red);
					g.fillRect(680, 380, 30, 30);
					if (tekGec <= 500) {
						tekGec += 10;
						g.setColor(Color.red);
						g.drawString("Dilenciye para vermedin.", 500, 340);
						
						tekliff[rt] = false;

					}
				}
			}
			if (rt == 4) {

				g.drawString("Evet", 575, 360);
				g2.draw(kutu);
				g.drawString("Hay�r", 675, 360);
				g2.draw(kutu2);
				if (kutu.intersects(mouse)) {

					g.setColor(Color.red);
					g.fillRect(580, 380, 30, 30);
					if (tekGec <= 500) {
						tekGec += 10;
						g.setColor(Color.MAGENTA);
						g.drawString("Gittin", 500, 340);
						
						tekliff[rt] = true;

					}

				}
				if (kutu2.intersects(mouse)) {
					g.setColor(Color.red);
					g.fillRect(680, 380, 30, 30);
					if (tekGec <= 500) {
						tekGec += 10;
						g.setColor(Color.red);
						g.drawString("Gitmedin", 500, 340);
						
						tekliff[rt] = false;

					}
				}
			}
			if (rt == 5) {

				g.drawString("Evet", 575, 360);
				g2.draw(kutu);
				g.drawString("Hay�r", 675, 360);
				g2.draw(kutu2);
				if (kutu.intersects(mouse)) {

					g.setColor(Color.red);
					g.fillRect(580, 380, 30, 30);
					if (tekGec <= 500) {
						tekGec += 10;
						g.setColor(Color.MAGENTA);
						g.drawString("Gittin", 500, 340);
						
						tekliff[rt] = true;

					}

				}
				if (kutu2.intersects(mouse)) {
					g.setColor(Color.red);
					g.fillRect(680, 380, 30, 30);
					if (tekGec <= 500) {
						tekGec += 10;
						g.setColor(Color.red);
						g.drawString("Gitmedin", 500, 340);
						
						tekliff[rt] = false;

					}
				}
			}
			if (rt == 6) {

				g.drawString("Var�m", 570, 360);
				g2.draw(kutu);
				g.drawString("Yokum", 670, 360);
				g2.draw(kutu2);
				if (kutu.intersects(mouse)) {

					g.setColor(Color.red);
					g.fillRect(580, 380, 30, 30);
					if (tekGec <= 500) {
						tekGec += 10;
						g.setColor(Color.MAGENTA);
						g.drawString("Var�m dedin ve 5000 TL kazand�n.", 500, 340);
						
						tekliff[rt] = true;

					}

				}
				if (kutu2.intersects(mouse)) {
					g.setColor(Color.red);
					g.fillRect(680, 380, 30, 30);
					if (tekGec <= 500) {
						tekGec += 10;
						g.setColor(Color.red);
						g.drawString("Bir �ey kazanmad�n.", 500, 340);
						
						tekliff[rt] = false;

					}
				}
			}
			if (rt == 7) {

				g.drawString("Var�m", 570, 360);
				g2.draw(kutu);
				g.drawString("Yokum", 670, 360);
				g2.draw(kutu2);
				if (kutu.intersects(mouse)) {

					g.setColor(Color.red);
					g.fillRect(580, 380, 30, 30);
					if (tekGec <= 500) {
						tekGec += 10;
						g.setColor(Color.MAGENTA);
						g.drawString("Var�m dedin ve bir �ey kazanmad�n.", 500, 340);
						
						tekliff[rt] = false;

					}

				}
				if (kutu2.intersects(mouse)) {
					g.setColor(Color.red);
					g.fillRect(680, 380, 30, 30);
					if (tekGec <= 500) {
						tekGec += 10;
						g.setColor(Color.red);
						g.drawString("Yokum dedin ve 5000 TL kazand�n.", 500, 340);
						
						tekliff[rt] = true;

					}
				}
				
			}
		}
	

	}

	public String teklifler(int a) {
		teklifler[0] = "Birisi seninle kumar oynamak istiyor.\n\"Tek mi, �ift mi?\" diye soruyor.";
		teklifler[1] = "Birisi seninle kumar oynamak istiyor.\n\"Tek mi, �ift mi?\" diye soruyor.";
		teklifler[2] = "Bir dilenci senden 500 TL istiyor.\nVeriyor musun?";
		teklifler[3] = "Bir dilenci senden 500 TL istiyor.\nVeriyor musun?";
		teklifler[4] = "4 ad�m ileri gitmeyi ister misin?";
		teklifler[5] = "4 ad�m geri gitmeyi ister misin?";
		teklifler[6] = "Var m�s�n, yok musun?";
		teklifler[7] = "Var m�s�n, yok musun?";
		return teklifler[a];
	}

	// ---------------------Move------------------------//
	public static int sureMove = 0;

	public void move(Graphics g, int a) {
		Graphics2D g2 = (Graphics2D) g;
		bg.paintIcon(this, g, 0, 0);
		g2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 40));
		if (a == 1 && sureMove <= 1000) {
			g2.setStroke(new BasicStroke(6f));
			g2.setColor(Color.black);
			g2.drawRect(410, 300, 400, 90);
			g2.setColor(Color.white);
			g2.fillRect(410, 300, 400, 90);
			g2.setColor(Color.green);

			g2.drawString(a + " ADIM ileri gittin", 430, 360);

		}
		if (a == 3 && sureMove <= 1000) {
			g2.setStroke(new BasicStroke(6f));
			g2.setColor(Color.black);
			g2.drawRect(410, 300, 400, 90);
			g2.setColor(Color.white);
			g2.fillRect(410, 300, 400, 90);
			g2.setColor(Color.green);

			g2.drawString(a + " ADIM ileri gittin", 430, 360);

		}
		if (a == 2 && sureMove <= 1000) {

			g2.setStroke(new BasicStroke(6f));
			g2.setColor(Color.black);
			g2.drawRect(410, 300, 400, 90);
			g2.setColor(Color.white);
			g2.fillRect(410, 300, 400, 90);
			g2.setColor(Color.red);

			g2.drawString(a + " ADIM geri gittin", 430, 360);

		}

	}

	public void iflas(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		bg.paintIcon(this, g, 0, 0);
		g2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 40));
		g2.setStroke(new BasicStroke(6f));
		g2.setColor(Color.black);
		g2.drawRect(480, 300, 300, 90);
		g2.setColor(Color.red);
		g2.fillRect(480, 300, 300, 90);
		g2.setColor(Color.white);
		g2.drawString("�FLAS ettin", 530, 365);

	}
}
