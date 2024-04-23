package nsu.fit.databases.zookeeper.controller;

import lombok.AllArgsConstructor;
import nsu.fit.databases.zookeeper.dto.MedicalHistoryRecordDto;
import nsu.fit.databases.zookeeper.dto.VaccinationHistoryRecordDto;
import nsu.fit.databases.zookeeper.dto.VetCardDto;
import nsu.fit.databases.zookeeper.entity.MedicalHistoryRecord;
import nsu.fit.databases.zookeeper.entity.VaccinationHistoryRecord;
import nsu.fit.databases.zookeeper.entity.VetCard;
import nsu.fit.databases.zookeeper.exception.ServerException;
import nsu.fit.databases.zookeeper.service.VetCardService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor

@RestController
@RequestMapping("/api/v1/vetcard")
public class VetCardController {

    private VetCardService vetCardService;
    private ModelMapper vetCardMapper;

    @GetMapping("/{id}")
    @ResponseBody
    public VetCardDto getVetCardAndAllInfo(@PathVariable("id") Long id) {
        VetCard vetCard = vetCardService.getVetCardById(id);
        List<VaccinationHistoryRecordDto> vaccinationHistoryRecordDtos =
                vetCardService.getVaccinationHistoryRecordsByVetCardId(id).stream().map(this::convertVaccinationHistoryRecordToDto).toList();
        List<MedicalHistoryRecordDto> medicalHistoryRecordDtos =
                vetCardService.getMedicalHistoryRecordsByVetCardId(id).stream().map(this::convertMedicalHistoryRecordToDto).toList();

        return convertVetCardToDto(vetCard, vaccinationHistoryRecordDtos, medicalHistoryRecordDtos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public VetCardDto addVetCard(@RequestBody VetCardDto vetCardDto) {
        List<VaccinationHistoryRecordDto> vaccinationHistoryRecordDtos = vetCardDto.getVaccinationHistoryRecords();
        List<MedicalHistoryRecordDto> medicalHistoryRecordDtos = vetCardDto.getMedicalHistoryRecords();
        return convertVetCardToDto(vetCardService.addVetCard(convertVetCardDtoToEntity(vetCardDto)), vaccinationHistoryRecordDtos, medicalHistoryRecordDtos);
    }

    @PostMapping("/{id}/vaccination")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public VaccinationHistoryRecordDto addVaccinationHistoryRecordToVetCard(@RequestBody VaccinationHistoryRecordDto vaccinationHistoryRecordDto) {
        return convertVaccinationHistoryRecordToDto(vetCardService.addVaccinationHistoryRecord(convertVaccinationHistoryRecordDtoToEntity(vaccinationHistoryRecordDto)));
    }

    @PostMapping("/{id}/history")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public MedicalHistoryRecordDto addMedicalHistoryRecordToVetCard(@RequestBody MedicalHistoryRecordDto medicalHistoryRecordDto) {
        return convertMedicalHistoryRecordToDto(vetCardService.addMedicalHistoryRecord(convertMedicalHistoryRecordDtoToEntity(medicalHistoryRecordDto)));
    }

    // сделай проверку чтобы случайно не затереть id и не потерять historyRecords
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public VetCardDto updateVetCard(@PathVariable("id") Long id,
                                  @RequestBody VetCardDto vetCardDto) {
        if (!Objects.equals(id, vetCardDto.getId()))
        {
            throw new ServerException(HttpStatus.BAD_REQUEST, "IDs don't match");
        }
        List<VaccinationHistoryRecordDto> vaccinationHistoryRecordDtos = vetCardDto.getVaccinationHistoryRecords();
        List<MedicalHistoryRecordDto> medicalHistoryRecordDtos = vetCardDto.getMedicalHistoryRecords();
        return convertVetCardToDto(vetCardService.updateVetCard(id, convertVetCardDtoToEntity(vetCardDto)), vaccinationHistoryRecordDtos, medicalHistoryRecordDtos);
    }

    @PutMapping("/{id}/vaccination")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public VaccinationHistoryRecordDto updateVaccinationHistoryRecord(@PathVariable("id") Long id,
                                                     @RequestBody VaccinationHistoryRecordDto vaccinationHistoryRecordDto) {
        if (!Objects.equals(id, vaccinationHistoryRecordDto.getId()))
        {
            throw new ServerException(HttpStatus.BAD_REQUEST, "IDs don't match");
        }
        return convertVaccinationHistoryRecordToDto(vetCardService.updateVaccinationHistoryRecord(id, convertVaccinationHistoryRecordDtoToEntity(vaccinationHistoryRecordDto)));
    }

    @PutMapping("/{id}/history")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public MedicalHistoryRecordDto updateMedicalHistoryRecord(@PathVariable("id") Long id,
                                                 @RequestBody MedicalHistoryRecordDto medicalHistoryRecordDto) {
        if (!Objects.equals(id, medicalHistoryRecordDto.getId()))
        {
            throw new ServerException(HttpStatus.BAD_REQUEST, "IDs don't match");
        }
        return convertMedicalHistoryRecordToDto(vetCardService.updateVetCardMedicalHistoryRecord(id, convertMedicalHistoryRecordDtoToEntity(medicalHistoryRecordDto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVetCard(@PathVariable("id") Long id) {
        vetCardService.deleteVetCardAndAllInfoById(id);
    }

    @DeleteMapping("/{id}/vaccination")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVaccinationHistoryRecord(@PathVariable("id") Long id) {
        vetCardService.deleteVaccinationHistoryRecordById(id);
    }

    @DeleteMapping("/{id}/history")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMedicalHistoryRecord(@PathVariable("id") Long id) {
        vetCardService.deleteMedicalHistoryRecordById(id);
    }


    // check how to convert to dto correctly
    private VetCardDto convertVetCardToDto(VetCard vetCard,
                                           List<VaccinationHistoryRecordDto> vaccinationHistoryRecords,
                                           List<MedicalHistoryRecordDto> medicalHistoryRecords) {

        return vetCardMapper.map(vetCard, VetCardDto.class);
        //here
    }

    private VetCard convertVetCardDtoToEntity(VetCardDto vetCardDto) {
        return vetCardMapper.map(vetCardDto, VetCard.class);
    }

    private VaccinationHistoryRecordDto convertVaccinationHistoryRecordToDto(VaccinationHistoryRecord vaccinationHistoryRecord) {
        return vetCardMapper.map(vaccinationHistoryRecord, VaccinationHistoryRecordDto.class);
    }

    private VaccinationHistoryRecord convertVaccinationHistoryRecordDtoToEntity(VaccinationHistoryRecordDto vaccinationHistoryRecordDto) {
        return vetCardMapper.map(vaccinationHistoryRecordDto, VaccinationHistoryRecord.class);
    }

    private MedicalHistoryRecordDto convertMedicalHistoryRecordToDto(MedicalHistoryRecord medicalHistoryRecord) {
        return vetCardMapper.map(medicalHistoryRecord, MedicalHistoryRecordDto.class);
    }

    private MedicalHistoryRecord convertMedicalHistoryRecordDtoToEntity(MedicalHistoryRecordDto medicalHistoryRecordDto) {
        return vetCardMapper.map(medicalHistoryRecordDto, MedicalHistoryRecord.class);
    }
}
