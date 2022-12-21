package mk.finki.ukim.mk.lab1;

import mk.finki.ukim.mk.lab1.model.Balloon;
import mk.finki.ukim.mk.lab1.repository.BalloonRepository;
import mk.finki.ukim.mk.lab1.repository.UserRepository;
import mk.finki.ukim.mk.lab1.service.impl.BalloonServiceImpl;
import mk.finki.ukim.mk.lab1.service.impl.UserServiceIml;
import mk.finki.ukim.mk.lab1.service.interfaces.BalloonService;
import mk.finki.ukim.mk.lab1.service.interfaces.ManufacturerService;
import mk.finki.ukim.mk.lab1.service.interfaces.OrderService;
import mk.finki.ukim.mk.lab1.service.interfaces.UserService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BalloonControllerTest {
    @Mock
    private  BalloonRepository balloonRepository;
    @Mock
    private  UserRepository userRepository;

    private BalloonServiceImpl balloonService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        Balloon balloon=new Balloon("balloon","Big",null);
        Mockito.when(this.balloonRepository.save(Mockito.any(Balloon.class))).thenReturn(balloon);

        //balloonService=Mockito.spy(new UserService(null));
    }

}
