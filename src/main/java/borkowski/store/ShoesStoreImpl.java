package borkowski.store;
import borkowski.domain.Shoes;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ShoesStoreImpl implements ShoesStoreInterface {
    public ShoesStoreImpl(){}   //konstr. bezparametrowy

    @Override
    public Shoes create(Shoes createShoes) throws IllegalArgumentException {   //CREATE
        for (Shoes sh:shoes){   //Sprawdzenie w bazie czy dane ID już w bazie istnieje
            if(createShoes.getId().equals(sh.getId())){
                throw new IllegalArgumentException("In your Database exist domain in this Id");
            }
        }
        shoes.add(createShoes); //Jesli nie to stwórz
        return createShoes;
    }

    @Override
    public ArrayList<Shoes> readAll(){  //ReadAll
        return shoes;   //Zwroc wszystkie buty
    }

    @Override
    public Shoes read(Long id){      //READ
        for (Shoes sh: shoes){      //Przejdz po liscie i jak jest to zwroc
            if(id.equals(sh.getId())){
                return sh;
            }
        }
        throw new NoSuchElementException("In your Database doesn't exist domain in this Id");
    }

    @Override
    public Shoes update(Shoes updateShoes){     //UPDATE
        if(shoes.contains(updateShoes)){
            shoes.set(shoes.indexOf(updateShoes), updateShoes);
            return updateShoes;
        }
        throw new NoSuchElementException("In your Database doesn't exist domain in this Id");
    }

    @Override
    public void delete(Long id){
        Shoes shoe = read(id);
        shoes.remove(shoe);
    }
}


