package nsu.fit.databases.zookeeper.controller;

import lombok.AllArgsConstructor;
import nsu.fit.databases.zookeeper.dto.WorkerDto;
import nsu.fit.databases.zookeeper.entity.Worker;
import nsu.fit.databases.zookeeper.exception.ServerException;
import nsu.fit.databases.zookeeper.service.WorkerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor

@RestController
@RequestMapping("/api/v1/worker")
public class WorkerController {

    private WorkerService workerService;
    private ModelMapper workerMapper;

    @GetMapping("/all")
    @ResponseBody
    public List<WorkerDto> getWorkers() {
        return workerService.getAllWorkers().stream().map(this::convertToDto).toList();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public WorkerDto getWorker(@PathVariable("id") Long id) {
        return convertToDto(workerService.getWorkerById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public WorkerDto addWorker(@RequestBody WorkerDto workerDto) {
        return convertToDto(workerService.addWorker(convertToEntity(workerDto)));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public WorkerDto updateWorker(@PathVariable("id") Long id,
                                @RequestBody WorkerDto workerDto) {
        if (!Objects.equals(id, workerDto.getId()))
        {
            throw new ServerException(HttpStatus.BAD_REQUEST, "IDs don't match");
        }
        return convertToDto(workerService.updateWorker(id, convertToEntity(workerDto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWorker(@PathVariable("id") Long id) {
        workerService.deleteWorkerById(id);
    }

    private WorkerDto convertToDto(Worker worker) {
        return workerMapper.map(worker, WorkerDto.class);
    }

    private Worker convertToEntity(WorkerDto workerDto) {
        return workerMapper.map(workerDto, Worker.class);
    }
}
