package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class object extends JPanel {


	//---------------------Oyun Tahtasý-------------------//	
	ImageIcon board = new ImageIcon("res//board.png");
	ImageIcon bg = new ImageIcon("res//bg2.png");
	ImageIcon score = new ImageIcon("res//score.png");
	
	public void board(Graphics g, int para1, int para2, double kitty) {
		bg.paintIcon(this, g, 0, 0);
		board.paintIcon(this, g, 0, 0);
		score.paintIcon(this, g, 820, 150);
		g.drawString("Oyuncu 1; " + String.valueOf(para1) + "TL", 825, 170);
		g.drawString("Oyuncu 2; " + String.valueOf(para2) + "TL", 825, 280);
		g.drawString("Kitty Coin oraný = " + String.valueOf(kitty), 850, 225);
		


	}

//---------------------Nesneler-----------------------//
	// ----- iflas------//"
	Rectangle2D.Double[] iflas = new Rectangle2D.Double[12];

	public void iflas(int sira, int konumX, int konumY) {

		iflas[sira] = new Rectangle2D.Double(konumX, konumY, 90, 71);

	}

	// -----Para Eventi-----//
	Rectangle2D.Double[] paracik = new Rectangle2D.Double[12];

	public void paracik(int sira, int konumX, int konumY) {

		paracik[sira] = new Rectangle2D.Double(konumX, konumY, 90, 71);

	}

	// ------Kripto Borsasý-----//

	Rectangle2D.Double[] borsa = new Rectangle2D.Double[12];

	public void borsa(int sira, int konumX, int konumY) {

		borsa[sira] = new Rectangle2D.Double(konumX, konumY, 90, 71);

	}
	// -------------------------//

	// ------Kader--------//
	ImageIcon kader = new ImageIcon("res//etki.png");
	public void kaderim(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		kader.paintIcon(this, g, 165, 100);
		g.setColor(Color.black);
		g2.setStroke(new BasicStroke(5f));
		g2.drawRect(150,200,330,50);
		g2.setColor(Color.white);
		g2.fillRect(150,200,330,50);
		g.setColor(Color.black);
		g2.drawLine(310,200,310,250);
		
	}
	Rectangle2D.Double[] kader2 = new Rectangle2D.Double[12];

	public void kader2(int sira, int konumX, int konumY) {

		kader2[sira] = new Rectangle2D.Double(konumX, konumY, 90, 71);
		
	}

	// -----Geri-Ýleri------//
	Rectangle2D.Double[] teklif = new Rectangle2D.Double[12];

	public void teklif(int sira, int konumX, int konumY) {

		teklif[sira] = new Rectangle2D.Double(konumX, konumY, 90, 71);

	}
	// -----Geri-Ýleri------//
		Rectangle2D.Double[] move = new Rectangle2D.Double[12];

		public void move(int sira, int konumX, int konumY) {

			move[sira] = new Rectangle2D.Double(konumX, konumY, 90, 71);

		}
}
