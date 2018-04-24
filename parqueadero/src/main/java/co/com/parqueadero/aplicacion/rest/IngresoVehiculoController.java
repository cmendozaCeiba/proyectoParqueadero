package co.com.parqueadero.aplicacion.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngresoVehiculoController {
	
	@RequestMapping(value="/ingresarVehiculo",
			consumes="application/json",
			method = RequestMethod.POST)
	public void ingresarVehiculo(@RequestBody String json) {
		System.out.println(json);
	}

	@RequestMapping(value="/hola")
	public String metodoInicialHola() {
		return "Hola Mundo";
	}
	
}
