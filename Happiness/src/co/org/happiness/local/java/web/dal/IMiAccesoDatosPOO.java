package co.gov.igac.ciaf.especializacion.poo.dal;

import java.util.List;

import co.gov.igac.ciaf.especializacion.poo.cbo.Bicicleta;
import co.gov.igac.ciaf.especializacion.poo.cbo.Persona;

public interface IMiAccesoDatosPOO {
	void createPersona(Persona person);

	List<Persona> readPersonas();

	Persona readPersona(int id);

	void updatePersona(Persona persona);

	void deletePersona(int id);

	boolean existePersona(String nombre, String lugar);

	void createBicicleta(Bicicleta bicicleta);

	List<Bicicleta> readBicicletas();

	Bicicleta readBicicleta(int id);

	void updateBicicleta(Bicicleta bicicleta);

	void deleteBicicleta(int id);

	boolean existeBicicleta(String nombre, String lugar, String marca);

}
