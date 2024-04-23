package nsu.fit.databases.zookeeper.service;

import lombok.AllArgsConstructor;
import nsu.fit.databases.zookeeper.entity.MedicalHistoryRecord;
import nsu.fit.databases.zookeeper.entity.VaccinationHistoryRecord;
import nsu.fit.databases.zookeeper.entity.VetCard;
import nsu.fit.databases.zookeeper.exception.ServerException;
import nsu.fit.databases.zookeeper.repository.MedicalHistoryRecordRepository;
import nsu.fit.databases.zookeeper.repository.VaccinationHistoryRecordRepository;
import nsu.fit.databases.zookeeper.repository.VetCardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VetCardService {

    private VetCardRepository vetCardRepository;
    private VaccinationHistoryRecordRepository vaccinationHistoryRecordRepository;
    private MedicalHistoryRecordRepository medicalHistoryRecordRepository;

    public VetCard getVetCardByIdOrThrow(Long id) {
        return vetCardRepository.findById(id).orElseThrow(() ->
                new ServerException(HttpStatus.NOT_FOUND,
                        "VetCard with id " + id + " does not exist")
        );
    }

    public List<VaccinationHistoryRecord> getVaccinationHistoryRecordsByVetCardIdOrThrow(Long id) {
        List<VaccinationHistoryRecord> vaccinationHistoryRecords = vaccinationHistoryRecordRepository.findAllByVetCardId(id);
        if (vaccinationHistoryRecords.isEmpty()) {
            throw new ServerException(HttpStatus.NOT_FOUND,
                    "Vaccination history records for vet card with id " + id + " do not exist");
        }
        return vaccinationHistoryRecords;
    }

    public List<MedicalHistoryRecord> getMedicalHistoryRecordsByVetCardIdOrThrow(Long id) {
        List<MedicalHistoryRecord> medicalHistoryRecords = medicalHistoryRecordRepository.findAllByVetCardId(id);
        if (medicalHistoryRecords.isEmpty()) {
            throw new ServerException(HttpStatus.NOT_FOUND,
                    "Medical history records for vet card with id " + id + " do not exist");
        }
        return medicalHistoryRecords;
    }

    public void vetCardExistsOrThrow(VetCard vetCard) {
        vetCardRepository.findById(vetCard.getId()).ifPresent(usr -> {
            throw new ServerException(HttpStatus.BAD_REQUEST,
                    "VetCard with id " + usr.getId() + " already exists");
        });
    }

    public void vaccinationHistoryRecordExistsOrThrow(VaccinationHistoryRecord vaccinationHistoryRecord) {
        vaccinationHistoryRecordRepository.findById(vaccinationHistoryRecord.getId()).ifPresent(usr -> {
            throw new ServerException(HttpStatus.BAD_REQUEST,
                    "Vaccination history record with id " + usr.getId() + " already exists");
        });
    }

    public void medicalHistoryRecordExistsOrThrow(MedicalHistoryRecord medicalHistoryRecord) {
        medicalHistoryRecordRepository.findById(medicalHistoryRecord.getId()).ifPresent(usr -> {
            throw new ServerException(HttpStatus.BAD_REQUEST,
                    "Medical History Record with id " + usr.getId() + " already exists");
        });
    }

    public VetCard getVetCardById(Long id) {
        return getVetCardByIdOrThrow(id);
    }

    public List<VaccinationHistoryRecord> getVaccinationHistoryRecordsByVetCardId(Long id) {
        return getVaccinationHistoryRecordsByVetCardIdOrThrow(id);
    }

    public List<MedicalHistoryRecord> getMedicalHistoryRecordsByVetCardId(Long id) {
        return getMedicalHistoryRecordsByVetCardIdOrThrow(id);
    }

    public VetCard addVetCard(VetCard vetCard) {
        vetCardExistsOrThrow(vetCard);
        return vetCardRepository.save(vetCard);
    }

    public VaccinationHistoryRecord addVaccinationHistoryRecord(VaccinationHistoryRecord vaccinationHistoryRecord) {
        vaccinationHistoryRecordExistsOrThrow(vaccinationHistoryRecord);
        return vaccinationHistoryRecordRepository.save(vaccinationHistoryRecord);
    }

    public MedicalHistoryRecord addMedicalHistoryRecord(MedicalHistoryRecord medicalHistoryRecord) {
        medicalHistoryRecordExistsOrThrow(medicalHistoryRecord);
        return medicalHistoryRecordRepository.save(medicalHistoryRecord);
    }

    public VetCard updateVetCard(Long id, VetCard vetCard) {
        vetCardExistsOrThrow(vetCard);
        List<VaccinationHistoryRecord> vaccinationHistoryRecords = vaccinationHistoryRecordRepository.findAllByVetCardId(id);
        List<MedicalHistoryRecord> medicalHistoryRecords = medicalHistoryRecordRepository.findAllByVetCardId(id);
        vaccinationHistoryRecords.stream().map(record -> {
            record.setVetCard(vetCard);
            vaccinationHistoryRecordRepository.save(record);
            return record;
        });
        medicalHistoryRecords.stream().map(record -> {
            record.setVetCard(vetCard);
            medicalHistoryRecordRepository.save(record);
            return record;
        });
        return vetCardRepository.save(vetCard);
    }

    public VaccinationHistoryRecord updateVaccinationHistoryRecord(Long id, VaccinationHistoryRecord vaccinationHistoryRecord) {
        vaccinationHistoryRecordExistsOrThrow(vaccinationHistoryRecord);
        vetCardExistsOrThrow(vaccinationHistoryRecord.getVetCard());
        return vaccinationHistoryRecordRepository.save(vaccinationHistoryRecord);
    }

    public MedicalHistoryRecord updateVetCardMedicalHistoryRecord(Long id, MedicalHistoryRecord medicalHistoryRecord) {
        medicalHistoryRecordExistsOrThrow(medicalHistoryRecord);
        vetCardExistsOrThrow(medicalHistoryRecord.getVetCard());
        return medicalHistoryRecordRepository.save(medicalHistoryRecord);
    }

    public void deleteVetCardAndAllInfoById(Long id) {
        vaccinationHistoryRecordRepository.deleteAll(vaccinationHistoryRecordRepository.findAllByVetCardId(id));
        medicalHistoryRecordRepository.deleteAll(medicalHistoryRecordRepository.findAllByVetCardId(id));
        vetCardRepository.deleteById(id);
    }

    public void deleteVaccinationHistoryRecordById(Long id) {
        vaccinationHistoryRecordRepository.deleteById(id);
    }

    public void deleteMedicalHistoryRecordById(Long id) {
        medicalHistoryRecordRepository.deleteById(id);
    }
}
