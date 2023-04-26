package ma.emsi.jpaap.service;

import ma.emsi.jpaap.entities.Consultation;
import ma.emsi.jpaap.entities.Medecin;
import ma.emsi.jpaap.entities.Patient;
import ma.emsi.jpaap.entities.RendezVous;

public interface hospital {
    Patient savePatient(Patient p);
    Medecin saveMedecin(Medecin m );
    RendezVous saveRendezVous(RendezVous r);
    Consultation saveConsultation(Consultation cl);

}
