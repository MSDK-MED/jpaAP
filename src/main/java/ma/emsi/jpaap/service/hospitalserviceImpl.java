package ma.emsi.jpaap.service;

import jakarta.transaction.Transactional;
import ma.emsi.jpaap.entities.Consultation;
import ma.emsi.jpaap.entities.Medecin;
import ma.emsi.jpaap.entities.Patient;
import ma.emsi.jpaap.entities.RendezVous;
import ma.emsi.jpaap.repositories.ConsultationRepository;
import ma.emsi.jpaap.repositories.MedecinRepository;
import ma.emsi.jpaap.repositories.PatientRepository;
import ma.emsi.jpaap.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class hospitalserviceImpl implements hospital {

    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;

    public hospitalserviceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;
    @Override
    public Patient savePatient(Patient p) {
        return patientRepository.save(p);
    }

    @Override
    public Medecin saveMedecin(Medecin m) {
        return medecinRepository.save(m);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous r) {

        return rendezVousRepository.save(r);
    }

    @Override
    public Consultation saveConsultation(Consultation cl) {
        return consultationRepository.save(cl);
    }
}
