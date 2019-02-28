package co.gov.igac.ciaf.especializacion.poo.bll;

import java.util.List;

import co.gov.igac.ciaf.especializacion.poo.cbo.Bicicleta;
import co.gov.igac.ciaf.especializacion.poo.cbo.Persona;

public interface IMiLogicaPOO {
	boolean createPersona(Persona persona);

	List<Persona> readPersonas();

	Persona readPersona(int id);

	void updatePersona(Persona persona);

	void deletePersona(int id);

	boolean createBicicleta(Bicicleta bicicleta);

	List<Bicicleta> readBicicletas();

	Bicicleta readBicicleta(int id);

	void updateBicicleta(Bicicleta bicicleta);

	void deleteBicicleta(int id);

}
