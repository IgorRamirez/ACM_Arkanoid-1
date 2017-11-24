package codigo;

import java.awt.Color;

import acm.graphics.GRect;

/**
 * 
 * @author Alberto Goujon
 *
 * La clase Ladrillo sirve para dibujar los ladrillos
 * del juego
 */
public class Ladrillo extends GRect{

	/**
	 * construye un ladrillo
	 * @param -> x
	 * @param -> y
	 * @param -> width
	 * @param -> height
	 * @param -> _color
	 * 
	 * futuros cambios: que admita n�mero de golpes
	 */
	public Ladrillo(double x, double y, double width,
			double height, Color _color) {
		super(x, y, width, height);
		setFilled(true);
		setFillColor(_color);
	}

}
