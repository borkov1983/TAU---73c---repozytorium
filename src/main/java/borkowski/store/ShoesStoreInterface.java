package borkowski.store;

import borkowski.domain.Shoes;

import java.time.LocalDate;
import java.util.List;

public interface ShoesStoreInterface {

    public Shoes create(Shoes shoes);

    public List<Shoes> readAll();

    public Shoes read(Long id);

    public Shoes update(Shoes shoes);

    public void delete(Long id);

    public LocalDate getTimeNow();
}
