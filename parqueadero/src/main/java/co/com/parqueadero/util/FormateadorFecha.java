package co.com.parqueadero.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormateadorFecha {

	private static final String FORMATO = "yyyy-MM-dd HH:mm:ss";
	
	public static LocalDateTime formatearFecha(LocalDateTime fecha) {
//		fecha.
		DateTimeFormatter forma = DateTimeFormatter.ofPattern(FORMATO);
//		forma.
		System.out.println(LocalDateTime.parse(fecha.format(forma), forma));
		fecha.parse(fecha.toString(),forma );
		return LocalDateTime.now().parse(fecha.format(forma));
	}
	
}
