package co.gov.igac.ciaf.especializacion.poo.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.gov.igac.ciaf.especializacion.poo.cbo.Bicicleta;
import co.gov.igac.ciaf.especializacion.poo.cbo.Persona;
import co.gov.igac.ciaf.especializacion.poo.dal.IMiAccesoDatosPOO;

@Service
public class MiLogicaPOO implements IMiLogicaPOO {
	@Autowired
	private IMiAccesoDatosPOO miAccesoDatosPOO;

	@Override
	public boolean createPersona(Persona persona) {
		if (miAccesoDatosPOO.existePersona(persona.getNombre(), persona.getLugar())) {
			return false;
		} else {
			miAccesoDatosPOO.createPersona(persona);
			return true;
		}
	}

	@Override
	public List<Persona> readPersonas() {
		return miAccesoDatosPOO.readPersonas();
	}

	@Override
	public Persona readPersona(int id) {
		return miAccesoDatosPOO.readPersona(id);
	}

	@Override
	public void updatePersona(Persona persona) {
		miAccesoDatosPOO.updatePersona(persona);
	}

	@Override
	public void deletePersona(int id) {
		miAccesoDatosPOO.deletePersona(id);

	}

	@Override
	public boolean createBicicleta(Bicicleta bicicleta) {
		if (miAccesoDatosPOO.existeBicicleta(bicicleta.getNombre(), bicicleta.getLugar(), bicicleta.getMarca())) {
			return false;
		} else {
			miAccesoDatosPOO.createBicicleta(bicicleta);
			return true;
		}
	}

	@Override
	public List<Bicicleta> readBicicletas() {
		return miAccesoDatosPOO.readBicicletas();
	}

	@Override
	public Bicicleta readBicicleta(int id) {
		return miAccesoDatosPOO.readBicicleta(id);
	}

	@Override
	public void updateBicicleta(Bicicleta bicicleta) {
		miAccesoDatosPOO.updateBicicleta(bicicleta);
	}

	@Override
	public void deleteBicicleta(int id) {
		miAccesoDatosPOO.deleteBicicleta(id);

	}
}
