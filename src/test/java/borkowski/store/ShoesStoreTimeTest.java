package borkowski.store;
import borkowski.store.TimeStampInterface;
import borkowski.domain.Shoes;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class ShoesStoreTimeTest {

    private ShoesStoreImpl service = new ShoesStoreImpl();
   // private ArrayList<Shoes> expectedShoes = new ArrayList<>();
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Mock
    TimeStampInterface timeStamp;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    private void assertNotNull(long readTime) {
    }

    @Test   //test dla metody read
    public void testOfReadTimeOnReadMethod(){
        long time = 222222;
        when(timeStamp.getTimeNow()).thenReturn((long)222222);
        Shoes shoes = new Shoes(100L,35,"Puma","grey");
        service.create(shoes);
        service.setTime(timeStamp.getTimeNow());
        service.read(100L);
        assertEquals(time, service.read(100L).getReadTime());
    }
    @Test
    public void testOfReadTimeOnReadAllMethod(){
        long time = 222222;
        when(timeStamp.getTimeNow()).thenReturn(time);
        Shoes shoes1 = new Shoes(101L,39,"Puma","grey");
        Shoes shoes2 = new Shoes(102L,36,"Nike","red");
        Shoes shoes3 = new Shoes(103L,42,"Adidas","white");

        service.create(shoes1);
        service.create(shoes2);
        service.create(shoes3);
        service.setTime(timeStamp.getTimeNow());

        assertEquals(time, service.readAll().get(0).getReadTime());
        assertEquals(time, service.readAll().get(1).getReadTime());
        assertEquals(time, service.readAll().get(2).getReadTime());
    }

    @Test
    public void testOfAddTimeOnCreateMethod() {
        long time = 1234567891;
        when(timeStamp.getTimeNow()).thenReturn(time);
        Shoes shoes = new Shoes(104L,42,"Adidas","white");
        service.setTime(timeStamp.getTimeNow());
        service.create(shoes);
        assertEquals(time, service.read(104L).getAddTime());
    }

}

