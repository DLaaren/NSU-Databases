package nsu.fit.databases.zookeeper.service;

import lombok.AllArgsConstructor;
import nsu.fit.databases.zookeeper.entity.Worker;
import nsu.fit.databases.zookeeper.exception.ServerException;
import nsu.fit.databases.zookeeper.repository.WorkerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class WorkerService {

    private WorkerRepository workerRepository;

    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    public Worker getWorkerByIdOrThrow(Long id) {
        return workerRepository.findById(id).orElseThrow(() ->
                new ServerException(HttpStatus.NOT_FOUND,
                        "Worker with id " + id + " does not exist")
        );
    }

    public void nonExistOrThrow(Worker worker) {
        workerRepository.findById(worker.getId()).ifPresent(usr -> {
            throw new ServerException(HttpStatus.BAD_REQUEST,
                  "Worker with id " + usr.getId() + " already exists");
        });
    }

    public Worker getWorkerById(Long id) {
        return getWorkerByIdOrThrow(id);
    }

    public Worker addWorker(Worker worker) {
        nonExistOrThrow(worker);
        return workerRepository.save(worker);
    }

    public Worker updateWorker(Long id, Worker worker) {
        nonExistOrThrow(worker);
        return workerRepository.save(worker);
    }

    public void deleteWorkerById(Long id) {
        workerRepository.deleteById(id);
    }
}
