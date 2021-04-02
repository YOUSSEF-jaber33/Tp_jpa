package Ma.emsi.TpJPA;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import Ma.emsi.TpJPA.Repositories.PatientRepository;
import Ma.emsi.TpJPA.entities.Patient;

@SpringBootApplication
public class TpJpaApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(TpJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"youssef",new Date(),2300,false));
		patientRepository.save(new Patient(null,"jaber",new Date(),200,false));
		patientRepository.save(new Patient(null,"toto",new Date(),2500,false));
		patientRepository.save(new Patient(null,"hassan",new Date(),3400,true));
		patientRepository.save(new Patient(null,"yassine",new Date(),340,true));
		
		System.out.println("***************************");
		
		patientRepository.findAll().forEach(p->{
			  
			System.out.println(p.toString());
		});
		
		System.out.println("***************************");
		
		 Patient patient=patientRepository.findById(4L).get();
		 System.out.println(patient.getNom());
		 
		 System.out.println("***************************");
		 
		 List<Patient> patients=patientRepository.findByNomContains("a");
		 patients.forEach(p->{
			 System.out.println(p.toString());
		 });
		 
         System.out.println("***************************");
		 
		 List<Patient> patients2=patientRepository.findByMalade(true);
		 patients2.forEach(p->{
			 System.out.println(p.toString());
		 });
		 
		 System.out.println("***************************");
		 
		 List<Patient> patients3=patientRepository.findByNomContainsAndMalade("y",true);
		 patients3.forEach(p->{
			 System.out.println(p.toString());
		 });
		 
		patientRepository.deleteById(5L);
 /*System.out.println("***************************");
		 
		 List<Patient> patients4=patientRepository.findAll();
		 patients4.forEach(p->{
			 System.out.println(p.toString());
		 });
		*/
		System.out.println("***************************");
		 Page<Patient> pagePatients=patientRepository.findAll(PageRequest.of(0, 2));
		 System.out.println("Nombre de pages :"+pagePatients.getTotalPages());
		 List<Patient> listPatients=pagePatients.getContent();
		 listPatients.forEach(p->{
			 System.out.println(p.toString());
		 });
	}

}
