package nsu.fit.databases.zookeeper.controller;

import lombok.AllArgsConstructor;
import nsu.fit.databases.zookeeper.dto.VetCardDto;
import nsu.fit.databases.zookeeper.entity.VetCard;
import nsu.fit.databases.zookeeper.exception.ServerException;
import nsu.fit.databases.zookeeper.service.VetCardService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@AllArgsConstructor

@RestController
@RequestMapping("/api/v1/vetcard")
public class VetCardController {

    private VetCardService vetCardService;
    private ModelMapper vetCardMapper;

    @GetMapping("/{id}")
    @ResponseBody
    public VetCardDto getVetCard(@PathVariable("id") Long id) {
        VetCard vetCard = vetCardService.getVetCardById(id);
        return convertVetCardToDto(vetCard);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public VetCardDto addVetCard(@RequestBody VetCardDto vetCardDto) {
        return convertVetCardToDto(vetCardService.addVetCard(convertVetCardDtoToEntity(vetCardDto)));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public VetCardDto updateVetCard(@PathVariable("id") Long id,
                                  @RequestBody VetCardDto vetCardDto) {
        if (!Objects.equals(id, vetCardDto.getId()))
        {
            throw new ServerException(HttpStatus.BAD_REQUEST, "IDs don't match");
        }
        return convertVetCardToDto(vetCardService.updateVetCard(id, convertVetCardDtoToEntity(vetCardDto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVetCard(@PathVariable("id") Long id) {
        vetCardService.deleteVetCardAndAllInfoById(id);
    }

    // check how to convert to dto correctly
    private VetCardDto convertVetCardToDto(VetCard vetCard) {
        return vetCardMapper.map(vetCard, VetCardDto.class);
    }

    private VetCard convertVetCardDtoToEntity(VetCardDto vetCardDto) {
        return vetCardMapper.map(vetCardDto, VetCard.class);
    }
}
