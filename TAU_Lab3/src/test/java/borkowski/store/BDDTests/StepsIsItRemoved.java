package borkowski.store.BDDTests;

import borkowski.domain.Shoes;
import borkowski.domain.TimeStamp;
import borkowski.store.ShoesStoreImpl;
import borkowski.store.TimeStampInterface;
import cucumber.api.java.en.*;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StepsIsItRemoved {

    ShoesStoreImpl shoes;
    private int counter;
    private String choosenBrand;
    private Integer choosenSize;

    private ShoesStoreImpl service = new ShoesStoreImpl();  //Baza główna butów
    private List<Shoes> listOfShoes = new ArrayList<>();    //Baza pomocnicza butów

    @Given("Customer chooses a shoes from list and buy")
    public void customer_chooses_a_shoes_from_list_and_buy() {
        shoes = new ShoesStoreImpl();
        ShoesStoreImpl.shoes = new ArrayList<>();
        //TimeStampInterface timesource = new TimeStamp();
        //shoes.setTimeSource(timesource);
        Collections.addAll(ShoesStoreImpl.shoes,
                new Shoes(10L, 41, "Puma", "orange"),
                new Shoes(11L, 42, "Puma", "black"),
                new Shoes(12L, 43, "Puma", "blue"),
                new Shoes(13L, 44, "Puma", "blue"),
                new Shoes(14L, 45, "Nike", "pink"));
        counter = ShoesStoreImpl.shoes.size();
    }

    @When("Customer choose model \"([^\"]*)\"$")
    public void customer_choose_model(String brand) {
        choosenBrand = brand;
    }

    @When("Customer choose size equal {int}")
    public void customer_choose_size_equal(Integer size) {
        choosenSize = size;
    }

    @Then("shoes has been bought and removed from list of shoes")
    public void shoes_has_been_bought_and_removed_from_list_of_shoes() {
        Shoes choosedSchoes = shoes.readAll().stream().filter(shoes -> shoes.getBrand().equals(choosenBrand) && shoes.getSize() == choosenSize).findFirst().get();
        assertEquals(choosedSchoes, shoes.read(choosedSchoes.getId()));
        shoes.delete(choosedSchoes);
        assertEquals(4, ShoesStoreImpl.shoes.size());
    }


}
