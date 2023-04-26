package ma.emsi.jpaap;

import ma.emsi.jpaap.entities.*;
import ma.emsi.jpaap.repositories.ConsultationRepository;
import ma.emsi.jpaap.repositories.MedecinRepository;
import ma.emsi.jpaap.repositories.PatientRepository;
import ma.emsi.jpaap.repositories.RendezVousRepository;
import ma.emsi.jpaap.service.UserService;
import ma.emsi.jpaap.service.hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class JpaApApplication {
    @Autowired

    public static void main(String[] args) {

        SpringApplication.run(JpaApApplication.class, args);

    }

    @Bean
    CommandLineRunner start(hospital hospitalService,
                            PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository,
                            ConsultationRepository consultationRepository,
                            UserService userSer) {
        return args -> {
            Stream.of("mohamed", "hassan", "aea")
                    .forEach(
                            name -> {
                                Patient p = new Patient();
                                p.setNom(name);
                                p.setScore(232);
                                p.setMalade(false);
                                p.setDateNaissance(new Date());
                                p.setRendezVous(null);
                                hospitalService.savePatient(p);
                            }
                    );
            Stream.of("Dr.med", "Dr.mahdi", "Dr.amine")
                    .forEach(
                            name -> {
                                Medecin p = new Medecin();
                                p.setNom(name);
                                p.setEmail("m@gmail.com");
                                p.setSpecialite("dentiste");
                                hospitalService.saveMedecin(p);
                            }
                    );
            Patient pp = patientRepository.findByNom("mohamed");
            Medecin m = medecinRepository.findByNom("Dr.med");
            RendezVous rendezVous = new RendezVous();
            rendezVous.setPatient(pp);
            rendezVous.setAnnule(StatuRV.DONE);
            rendezVous.setDate(new Date());
            rendezVous.setMedecin(m);
            rendezVousRepository.save(rendezVous);

            RendezVous rendezVous1 = rendezVousRepository.getById(1L);
            Consultation cl = new Consultation();
            cl.setDateConsultation(new Date());
            cl.setRapport("rapport");
            cl.setRendezVous(rendezVous1);
            consultationRepository.save(cl);

            Page<Patient> patients = patientRepository.findAll(PageRequest.of(0, 5));
            System.out.println("total pages : " + patients.getTotalPages());
            System.out.println("total elements : " + patients.getTotalElements());
            System.out.println("num page : " + patients.getNumber());
            List<Patient> content = patients.getContent();
            patients.forEach(p -> {
                System.out.println("--------------------");
                System.out.print(p.getId() + " ");
                System.out.print(p.getNom() + " ");
                System.out.print(p.getScore() + " ");
                System.out.print(p.isMalade() + " ");
                System.out.print(p.getDateNaissance() + " ");
            });
            System.out.println("**");
            Patient p = patientRepository.findById(1L).orElse(null);
            if (p != null) {
                System.out.print(p.getNom() + " ");
                System.out.print(p.isMalade() + " ");
            }
            p.setScore(29);
            patientRepository.save(p);
            //patientRepository.deleteById(1L);

            List<Patient> malades = patientRepository.findByMalade(true);
            malades.forEach(pa -> {
                System.out.println("--------------------");
                System.out.print(p.getId() + " ");
                System.out.print(p.getNom() + " ");
                System.out.print(p.getScore() + " ");
                System.out.print(p.isMalade() + " ");
                System.out.print(p.getDateNaissance() + " ");
            });
            Page<Patient> maladess = patientRepository.findByMalade(true, PageRequest.of(0, 5));
            maladess.forEach(pa -> {
                System.out.println("--------------------");
                System.out.print(p.getId() + " ");
                System.out.print(p.getNom() + " ");
                System.out.print(p.getScore() + " ");
                System.out.print(p.isMalade() + " ");
                System.out.print(p.getDateNaissance() + " ");
            });
            User u1 = new User();
            u1.setUsername("SIMO");
            u1.setPassword("22222");
            userSer.addUser(u1);
            Role r1 = new Role();
            r1.setRoleName("admin");
            userSer.addRole(r1);
            userSer.addRoleToUser("SIMO","admin");
        };

    }}