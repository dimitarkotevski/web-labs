package mk.finki.ukim.mk.lab1.repository;

import mk.finki.ukim.mk.lab1.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab1.model.Balloon;
import mk.finki.ukim.mk.lab1.model.Manufacture;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public  class BalloonRepository {
    public List<Balloon> findAllBalloons(){
        return DataHolder.balloons;
    }
    public List<Balloon> findAllByNameOrDescription(String text){
        return DataHolder.balloons.stream()
                .filter(b->
                        b.getName().contains(text) || b.getDescription().contains(text) )
                .collect(Collectors.toList());
    }
    public void deleteById(Long id){
        Balloon balloon=DataHolder.balloons.stream().filter(b->b.getId().equals(id)).findFirst().get();
        DataHolder.balloons.remove(balloon);
    }
    public Balloon save(String name, String description, Manufacture manufacture){
        DataHolder.balloons.removeIf(b->b.getName().equals(name));
        Balloon balloon=new Balloon(name,description, manufacture);
        DataHolder.balloons.add(balloon);
        return balloon;
    }
    public Balloon findById(Long id){
        return DataHolder.balloons.stream().filter(b->b.getId().equals(id)).findFirst().get();
    }

    public void changeBalloon(Long id,String name,String description, Manufacture manufacture) {
        DataHolder.balloons.stream().filter(b->b.getId().equals(id)).findFirst().get().setDescription(description);
        DataHolder.balloons.stream().filter(b->b.getId().equals(id)).findFirst().get().setName(name);
        DataHolder.balloons.stream().filter(b->b.getId().equals(id)).findFirst().get().setManufacture(manufacture);
    }
}
