package nsu.fit.databases.zookeeper.controller;

import lombok.AllArgsConstructor;
import nsu.fit.databases.zookeeper.dto.VetCardDto;
import nsu.fit.databases.zookeeper.entity.VetCard;
import nsu.fit.databases.zookeeper.entity.VetCard;
import nsu.fit.databases.zookeeper.exception.ServerException;
import nsu.fit.databases.zookeeper.service.VetCardService;
import nsu.fit.databases.zookeeper.service.VetCardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor

@RestController
@RequestMapping("/api/v1/vetcard")
public class VetCardController {

    private VetCardService vetCardService;
    private ModelMapper vetCardMapper;

    @GetMapping("/all")
    @ResponseBody
    public List<VetCardDto> getVetCards() {
        return vetCardService.getAllVetCards().stream().map(this::convertToDto).toList();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public VetCardDto getVetCard(@PathVariable("id") Long id) {
        return convertToDto(vetCardService.getVetCardById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public VetCardDto addVetCard(@RequestBody VetCardDto vetCardDto) {
        return convertToDto(vetCardService.addVetCard(convertToEntity(vetCardDto)));
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
        return convertToDto(vetCardService.updateVetCard(id, convertToEntity(vetCardDto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVetCard(@PathVariable("id") Long id) {
        vetCardService.deleteVetCardById(id);
    }

    private VetCardDto convertToDto(VetCard vetCard) {
        return vetCardMapper.map(vetCard, VetCardDto.class);
    }

    private VetCard convertToEntity(VetCardDto vetCardDto) {
        return vetCardMapper.map(vetCardDto, VetCard.class);
    }
}
