package codigo;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Vidas extends GRect{
	//Declaraci�n de Sistema de vidas:
	GLabel auxiliarvida = new GLabel("");
	static int numvidas= 3;
	GLabel textovida = new GLabel("");

	public Vidas(double width, double height)
	{
		super(width, height);
		setFilled (true);
		setFillColor(Color.WHITE);
		textovida.setLabel("3");
		textovida.setFont(new Font ("Times New Roman", Font.BOLD, 11));
	}
	public void dibuja(Arkanoid _arkanoid)
	{
		_arkanoid.add(this, _arkanoid.getWidth() -115, getY() +60);
		_arkanoid.add(auxiliarvida, _arkanoid.getWidth() -111, getY()+150);
	}		
	public void actualizaMarcadorVidas(int vida)
	{
		numvidas += vida;
		textovida.setLabel("Vidas: " + -vida);
	}


}