package co.gov.igac.ciaf.especializacion.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import co.gov.igac.ciaf.especializacion.poo.bll.IMiLogicaPOO;
import co.gov.igac.ciaf.especializacion.poo.cbo.Bicicleta;
import co.gov.igac.ciaf.especializacion.poo.cbo.Persona;

@Controller
@RequestMapping("/info")
public class MiServicioPOO {
	@Autowired
	private IMiLogicaPOO miLogicaPOO;

	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
	public ResponseEntity<Persona> readPersona(@PathVariable("id") Integer id) {

		Persona persona = miLogicaPOO.readPersona(id);
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public ResponseEntity<List<Persona>> readPersonas() {
		List<Persona> list = miLogicaPOO.readPersonas();
		return new ResponseEntity<List<Persona>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public ResponseEntity<Void> createPersona(@RequestBody Persona person, UriComponentsBuilder builder) {
		boolean flag = miLogicaPOO.createPersona(person);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/person/{id}").buildAndExpand(person.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Persona> updatePersona(@RequestBody Persona person) {
		miLogicaPOO.updatePersona(person);
		return new ResponseEntity<Persona>(person, HttpStatus.OK);
	}

	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePersona(@PathVariable("id") Integer id) {
		miLogicaPOO.deletePersona(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/biciclet/{id}", method = RequestMethod.GET)
	public ResponseEntity<Bicicleta> readBicicleta(@PathVariable("id") Integer id) {
		Bicicleta bicicleta = miLogicaPOO.readBicicleta(id);
		return new ResponseEntity<Bicicleta>(bicicleta, HttpStatus.OK);
	}

	@RequestMapping(value = "/biciclet", method = RequestMethod.GET)
	public ResponseEntity<List<Bicicleta>> readBicicletas() {
		List<Bicicleta> list = miLogicaPOO.readBicicletas();
		return new ResponseEntity<List<Bicicleta>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/biciclet", method = RequestMethod.POST)
	public ResponseEntity<Void> createBicicleta(@RequestBody Bicicleta biciclet, UriComponentsBuilder builder) {
		boolean flag = miLogicaPOO.createBicicleta(biciclet);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/biciclet/{id}").buildAndExpand(biciclet.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/biciclet/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Bicicleta> updateBicicleta(@RequestBody Bicicleta biciclet) {
		miLogicaPOO.updateBicicleta(biciclet);
		return new ResponseEntity<Bicicleta>(biciclet, HttpStatus.OK);
	}

	@RequestMapping(value = "/biciclet/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBicicleta(@PathVariable("id") Integer id) {
		miLogicaPOO.deletePersona(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}