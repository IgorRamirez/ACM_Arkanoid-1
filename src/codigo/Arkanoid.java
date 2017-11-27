package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GLabel;
import acm.graphics.GRect;

/*
 * Autor: Alberto Goujon Guti�rrez
 * 
 * El Arkanoid pero orientado a objetos
 */

public class Arkanoid extends acm.program.GraphicsProgram{

	Pelota pelota1 = new Pelota(7, Color.GREEN);													//Pelota 1
	Barra barra1 = new Barra(70, 7, Color.RED);														//Barra
	int anchoLadrillo = 25;																			//Ancho del ladrillo
	int altoLadrillo = 15;																			//Alto del ladrillo
	int espacioMenu = 130;																			//Barra del men�

	//Marcador del arkanoid
	Marcador marcador = new Marcador(100, 40);														//Caja del marcador
	Vidas vidaAbajo = new Vidas (20,40);															//Caja de las vidas
	GLabel hasPerdido = new GLabel("GAME OVER");													//Texto de has perdido
	public void init(){
		addMouseListeners();
		setSize(550, 600);																			//tama�o de la pantalla
		GRect lateral = new GRect(3, getWidth());													//l�nea del men�
		lateral.setFilled(true);																	//l�nea del men�
		add(lateral, getWidth()- espacioMenu - lateral.getWidth()- pelota1.getWidth(), 0);			//lo a�ade a la pantalla la l�nea del men�
		add(pelota1, 50, getHeight()*0.60 - pelota1.getHeight());									//a�ade a la pelota en la pantalla
		add(barra1, 0 , getHeight()*0.80);															//a�ade la barra del juego



	}

	public void run()
	{
		dibujaNivel01();
		marcador.dibuja(this);																	//a�ade el marcador en la pantalla
		vidaAbajo.dibuja(this);																	//a�ade el las vidas en la pantalla
		while (vidaAbajo.numvidas >=1 && vidaAbajo.numvidas <= 3)
		{
			pelota1.muevete(this);																//hace que la pelota se mueva
			barra1.mueveBarra((int)pelota1.getX(), getWidth()- espacioMenu);					//truco para seguir a  la pelota
			pause(0);
			if(marcador.puntuacion >= 1680)
			{
				dibujaNivel02(); 
				pelota1.setLocation( 50, getHeight()*0.60 - pelota1.getHeight());
				while (vidaAbajo.numvidas >=1 && vidaAbajo.numvidas <= 3)
				{
					pelota1.muevete(this);																//hace que la pelota se mueva
					barra1.mueveBarra((int)pelota1.getX(), getWidth()- espacioMenu);					//truco para seguir a  la pelota
					pause(0);
					if(marcador.puntuacion >= 3780)
					{
						dibujaNivel03();
						pelota1.setLocation( 50, getHeight()*0.60 - pelota1.getHeight());
						while (vidaAbajo.numvidas >=1 && vidaAbajo.numvidas <= 3)
						{
							pelota1.muevete(this);																//hace que la pelota se mueva
							barra1.mueveBarra((int)pelota1.getX(), getWidth()- espacioMenu);					//truco para seguir a  la pelota
							pause(0);
						}
					}
				}				
			}
			if(vidaAbajo.numvidas <= 0)
			{
				add(hasPerdido, getWidth()/3.5, getHeight()/2.5);
			}
			
		}
	}

	public void mouseMoved (MouseEvent evento)													//condici�n que la barra hace para qu no se pase del espacio del men�
	{
		barra1.mueveBarra(evento.getX(), getWidth()- espacioMenu);
	}

	private void dibujaNivel01()																//nivel de l�neas de ladrillos
	{
		int numLadrillos = 7; 	
		for (int i=0; i < numLadrillos; i++)
		{
			for(int j=0; j < 12; j++)
			{
				Ladrillo miLadrillo =
						new Ladrillo(j * anchoLadrillo + 50, i * altoLadrillo + 60, anchoLadrillo, altoLadrillo,
								Color.BLUE);

				add(miLadrillo);
				pause(7);
			}
		}

	}

	private void dibujaNivel02()																//nivel pir�mide																		
	{
		int numLadrillos = 14; 	
		for (int j=0; j < numLadrillos; j++)
		{
			for(int i=j; i < numLadrillos; i++)
			{
				Ladrillo miLadrillo =
						new Ladrillo((anchoLadrillo* i - anchoLadrillo*j/2 + ((getWidth()- 100) - anchoLadrillo * numLadrillos)/2),
								altoLadrillo*j,
								anchoLadrillo, 
								altoLadrillo, 
								Color.BLUE);

				add(miLadrillo);
				pause(7);
			}
		}
	}	

	private void dibujaNivel03()																//nivel pir�mide																		
	{
		int numLadrillos = 14; 	
		for (int j=0; j < numLadrillos; j++)
		{
			for(int i=j; i < numLadrillos; i++)
			{
				Ladrillo miLadrillo =
						new Ladrillo((anchoLadrillo* i - anchoLadrillo*j + ((getWidth() -180) - anchoLadrillo * numLadrillos)/2),
								altoLadrillo*j,
								anchoLadrillo, 
								altoLadrillo, 
								Color.BLUE);

				add(miLadrillo);
				pause(7);
			}
		}
	}
}












