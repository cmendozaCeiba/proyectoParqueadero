package co.com.parqueadero.aplicacion.rest.unitaria;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import co.com.parqueadero.aplicacion.rest.ConsultaVehiculoController;
import co.com.parqueadero.dominio.repositorio.RepositorioParqueadero;
import co.com.parqueadero.persistencia.entidad.ParqueaderoEntity;

@RunWith(SpringRunner.class)
@WebMvcTest(value= ConsultaVehiculoController.class, secure = false)
public class ConsultarVehiculoControllerTest {
	
	private String URI = "/listarVehiculos";
	
	@Mock
	private RepositorioParqueadero repositorioParqueadero;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void consultarVehiculos() throws Exception {
		
		ParqueaderoEntity parqueaderoEntity = new ParqueaderoEntity(LocalDateTime.of(2018,04,28, 10,15),"Carro", null, 0.0, "I", "FRE378");
		List<ParqueaderoEntity> listaParqueos = new ArrayList<>();
		listaParqueos.add(parqueaderoEntity);
		Mockito.when(repositorioParqueadero.listarParqueos()).thenReturn(listaParqueos);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
		
		MvcResult resul =  mockMvc.perform(requestBuilder).andReturn();
		
		String expect = "{tipoVehiculo:Carro}";
		
		Assert.assertTrue(resul.getResponse().getContentAsString().contains(expect));
	}
	
}
