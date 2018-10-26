import javax.swing.JFrame;
import javax.swing.JOptionPane;

import processing.core.PApplet;

public class Main extends PApplet {	
	boolean rectOver = false;
	boolean joueur = false;
	int win = 0;
	
	int tabBoolean[][] = new int[3][3] ; 
	
	public static void main(String[] args) {
		PApplet.main("Main");
	}

	// Settings fenêtre
	public void settings() {
		size(600, 600);
	}

	// Charger au démarrage du programme
	public void setup() {
		background(255);
		for (int i = 0; i != 3; i++)
			for (int y = 0; y != 3; y++) {
				tabBoolean[i][y] = 0;
				
				fill(160 + i * 20, 160, 240);
				rect((200 * y),(200 * i), 200, 200);
			}		
		strokeWeight(4);  // Thicker
		JOptionPane.showMessageDialog(new JFrame(), "Le joueur 1 jouera les ronds.\nLe joueur 2 jouera les croix.", "Bienvenue...", JOptionPane.INFORMATION_MESSAGE);
	}

	// Charger continuellement
	public void draw() {
		CheckWin();
	}

	public void mousePressed() {
		checkButtons();
	}

	public void checkButtons() {
		for (int i = 0; i != 3; i++)
			for (int y = 0; y != 3; y++) {
				if (mouseX > 0 + (200 * y) && mouseX < 200 + (200 * y) && mouseY > 0 + (200 * i) && mouseY < 200 + (200 * i)) {
					{
						if(!joueur && tabBoolean[y][i] == 0)	
						{
							fill(255);
							ellipse(100 + (200 * y), 100 + (200 * i), 115, 115);	
							tabBoolean[y][i] = 1;
							
							joueur = true;
						}				
						else if(joueur && tabBoolean[y][i] == 0)
						{
							fill(255);
							line(50+ (200 * y), 50+ (200 * i), 150+ (200 * y), 150+ (200 * i));
							line(150+ (200 * y), 50+ (200 * i), 50+ (200 * y), 150+ (200 * i));
							tabBoolean[y][i] = 2;
							
							joueur = false;
						}
					}
				}
				else {
					rectOver = false;
				}
			}
//		CheckWin();
	}
	
	public void CheckWin() {
		int Compteur = 0;
		for (int i = 0; i != 3; i++) {
			for (int y = 0; y != 3; y++) {
				if (tabBoolean[y][i] != 0)
					Compteur++;
				if (tabBoolean[0][i] == 1 && tabBoolean[1][i] == 1 && tabBoolean[2][i] == 1)
				{
					win = 1;
					stroke(220,20,60);
					line(0+ (200 * y), 100+ (200 * i), 200+ (200 * y), 100+ (200 * i));
				}
				else if (tabBoolean[0][i] == 2 && tabBoolean[1][i] == 2 && tabBoolean[2][i] == 2)
				{
					win = 2;
					stroke(220,20,60);
					line(0+ (200 * y), 100+ (200 * i), 200+ (200 * y), 100+ (200 * i));
				}
				if (tabBoolean[y][0] == 1 && tabBoolean[y][1] == 1 && tabBoolean[y][2] == 1)
				{
					win = 1;
					stroke(220,20,60);
					line(100+ (200 * y), 0+ (200 * i), 100+ (200 * y), 200+ (200 * i));
				}
				else if (tabBoolean[y][0] == 2 && tabBoolean[y][1] == 2 && tabBoolean[y][2] == 2)
				{
					win = 2;
					stroke(220,20,60);
					line(100+ (200 * y), 0+ (200 * i), 100+ (200 * y), 200+ (200 * i));		
				}
				if (tabBoolean[0][0] == 1 && tabBoolean[1][1] == 1 && tabBoolean[2][2] == 1)
				{
					win = 1;
					stroke(220,20,60);
					line(0+ (200 * i), 0+ (200 * i), 200+ (200 * i), 200+ (200 * i));		
				}
				else if (tabBoolean[0][0] == 2 && tabBoolean[1][1] == 2 && tabBoolean[2][2] == 2)
				{
					win = 2;
					stroke(220,20,60);
					line(0+ (200 * i), 0+ (200 * i), 200+ (200 * i), 200+ (200 * i));	
				}
			}		
		}
				if (tabBoolean[0][2] == 1 && tabBoolean[1][1] == 1 && tabBoolean[2][0] == 1)
				{
					win = 1;
					stroke(220,20,60);
					line(600, 0, 400, 200);	
					line(400, 200, 200, 400);	
					line(200, 400, 0, 600);	
				}
				else if (tabBoolean[0][2] == 2 && tabBoolean[1][1] == 2 && tabBoolean[2][0] == 2)
				{
					win = 2;
					stroke(220,20,60);
					line(600, 0, 400, 200);	
					line(400, 200, 200, 400);	
					line(200, 400, 0, 600);		
				}
		
		if (win == 0 &&Compteur == 9)
			win = 3;
		
		if (win == 1)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Le joueur 1 à gagné.", "Félicitations !", JOptionPane.INFORMATION_MESSAGE);
			noLoop();
		}
		else if (win == 2)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Le joueur 2 à gagné.", "Félicitations !", JOptionPane.INFORMATION_MESSAGE);
			noLoop();
		}
		else if (win == 3)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Egalité !", "Dommage !", JOptionPane.INFORMATION_MESSAGE);
			noLoop();
		}
	}
	
}