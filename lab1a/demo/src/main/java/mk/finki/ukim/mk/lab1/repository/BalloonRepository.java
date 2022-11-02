package mk.finki.ukim.mk.lab1.repository;

import mk.finki.ukim.mk.lab1.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab1.model.Balloon;
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

}
