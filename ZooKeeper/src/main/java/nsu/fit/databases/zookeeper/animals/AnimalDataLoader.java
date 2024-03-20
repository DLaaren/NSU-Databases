//package nsu.fit.databases.zookeeper.animal;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class AnimalDataLoader {
//    private final AnimalRepository animalRepository;
//
//    public AnimalDataLoader(AnimalRepository animalRepository) {
//        this.animalRepository = animalRepository;
//    }
//
//    @PostConstruct
//    private void loadData() {
//        animalRepository.deleteAll();
//        animalRepository.saveAll(List.of(
//                new Animal("Jack",0,0,0,0, false),
//                new Animal("Alice", 0,0,1,0,false),
//                new Animal("SAM", 0,1,2,0,false)
//        ));
//    }
//}
