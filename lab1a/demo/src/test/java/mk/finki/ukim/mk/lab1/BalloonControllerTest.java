package mk.finki.ukim.mk.lab1;

import mk.finki.ukim.mk.lab1.model.Balloon;
import mk.finki.ukim.mk.lab1.model.Manufacture;
import mk.finki.ukim.mk.lab1.model.User;
import mk.finki.ukim.mk.lab1.repository.BalloonRepository;
import mk.finki.ukim.mk.lab1.repository.ManufactureRepository;
import mk.finki.ukim.mk.lab1.repository.UserRepository;
import mk.finki.ukim.mk.lab1.service.impl.BalloonServiceImpl;
import mk.finki.ukim.mk.lab1.service.impl.UserServiceIml;
import mk.finki.ukim.mk.lab1.service.interfaces.BalloonService;
import mk.finki.ukim.mk.lab1.service.interfaces.ManufacturerService;
import mk.finki.ukim.mk.lab1.service.interfaces.OrderService;
import mk.finki.ukim.mk.lab1.service.interfaces.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BalloonControllerTest {
    Manufacture manufacturer = new Manufacture("manufacturer1", "country1", "address1");
    Long BALLOON_ID = Integer.toUnsignedLong(1000);
    @Mock
    private BalloonRepository balloonRepository;
    @Mock
    private ManufactureRepository manufacturerRepository;
    private BalloonService service;
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);


        Balloon balloon = new Balloon("name", "description", manufacturer);
        balloon.setId(BALLOON_ID);

        Mockito.when(this.balloonRepository.save(Mockito.any(Balloon.class))).thenReturn(balloon);
        Mockito.when(this.manufacturerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(manufacturer));

        this.service = Mockito.spy(new BalloonServiceImpl(this.balloonRepository));
    }
    @Test
    public void testSuccessBalloonAdd() {
        Balloon balloon = this.service.save("name", "description", manufacturer);

        Mockito.verify(this.service).save("name", "description", manufacturer);

        Assert.assertNotNull("User is null", balloon);
        Assert.assertEquals("Name doesn't match", "name", balloon.getName());
        Assert.assertEquals("Description doesn't match", "description", balloon.getDescription());
        Assert.assertEquals("Manufacturer doesn't match", manufacturer, balloon.getManufacture());
        //Assert.assertEquals("BalloonType doesn't match", balloonType, balloon.getName());
    }


}
