package borkowski.store;

import borkowski.domain.Shoes;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
//@RunWith(JUnit4.class)

public class ShoesStoreTimeTest {

    private ShoesStoreImpl service = new ShoesStoreImpl();

    //private ArrayList<Shoes> expectedShoes = new ArrayList<>();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Mock
    long time, addTime, readTime, updateTime;

    @Mock
    TimeStampInterface timeStamp;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }
    //testy na NotNull
    @Test
    public void testOfReadTimeNotNull() {
        assertNotNull(readTime);
    }


    @Test   //test dla metody read
    public void testOfReadTimeOnReadMethod(){
        Shoes shoes = new Shoes(100L,35,"Puma","grey");
        service.create(shoes);
        service.setTime(timeStamp.getTimeNow());
        service.read(100L);
        when(timeStamp.getTimeNow()).thenReturn((long)222222);
        long time = 222222;
        assertEquals(service.read(100L).getReadTime(), time);
    }
    @Test
    public void testOfReadTimeOnReadAllMethod(){
        Shoes shoes1 = new Shoes(100L,39,"Puma","grey");
        Shoes shoes2 = new Shoes(101L,36,"Nike","red");
        Shoes shoes3 = new Shoes(102L,42,"Adidas","white");

        service.create(shoes1);
        service.create(shoes2);
        service.create(shoes3);
        service.setTime(timeStamp.getTimeNow());

        long time = 222222;

        when(timeStamp.getTimeNow()).thenReturn(time);
        assertEquals(service.readAll().get(0).getReadTime(),time);
        assertEquals(service.readAll().get(1).getReadTime(),time);
        assertEquals(service.readAll().get(2).getReadTime(),time);
    }
}

