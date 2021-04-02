package Ma.emsi.TpJPA.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import Ma.emsi.TpJPA.Repositories.PatientRepository;
import Ma.emsi.TpJPA.entities.Patient;

@RestController
public class PatientsController {
	@Autowired
	private PatientRepository PatientRepository;
	@GetMapping("/patients")
	public List<Patient> patients(){
		return PatientRepository.findAll();
	}

}
