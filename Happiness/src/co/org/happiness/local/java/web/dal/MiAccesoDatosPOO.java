package co.gov.igac.ciaf.especializacion.poo.dal;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import co.gov.igac.ciaf.especializacion.poo.cbo.Bicicleta;
import co.gov.igac.ciaf.especializacion.poo.cbo.Persona;

@Transactional
@Repository
public class MiAccesoDatosPOO implements IMiAccesoDatosPOO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void createPersona(Persona person) {
		hibernateTemplate.save(person);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> readPersonas() {
		return (List<Persona>) hibernateTemplate.find("FROM Persona as p ORDER BY p.id");
	}

	@Override
	public Persona readPersona(int id) {
		return hibernateTemplate.get(Persona.class, id);
	}

	@Override
	public void updatePersona(Persona persona) {
		Persona p = readPersona(persona.getId());
		p.setNombre(persona.getNombre());
		p.setLugar(persona.getLugar());
		hibernateTemplate.update(p);
	}

	@Override
	public void deletePersona(int id) {
		hibernateTemplate.delete(readPersona(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean existePersona(String nombre, String lugar) {
		List<Persona> persons = (List<Persona>) hibernateTemplate
				.find("FROM Persona as p WHERE p.nombre = ? and p.lugar = ?", nombre, lugar);
		return persons.size() > 0 ? true : false;
	}

	@Override
	public void createBicicleta(Bicicleta bicicleta) {
		hibernateTemplate.save(bicicleta);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bicicleta> readBicicletas() {
		return (List<Bicicleta>) hibernateTemplate.find("FROM Bicicleta as p ORDER BY p.id");
	}

	@Override
	public Bicicleta readBicicleta(int id) {
		return hibernateTemplate.get(Bicicleta.class, id);
	}

	@Override
	public void updateBicicleta(Bicicleta bicicleta) {
		Bicicleta p = readBicicleta(bicicleta.getId());
		p.setNombre(bicicleta.getNombre());
		p.setLugar(bicicleta.getLugar());
		hibernateTemplate.update(p);
	}

	@Override
	public void deleteBicicleta(int id) {
		hibernateTemplate.delete(readBicicleta(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean existeBicicleta(String nombre, String lugar, String marca) {
		List<Bicicleta> persons = (List<Bicicleta>) hibernateTemplate
				.find("FROM Bicicleta as p WHERE p.nombre = ? and p.lugar = ? and p.marca=?", nombre, lugar, marca);
		return persons.size() > 0 ? true : false;
	}

}
