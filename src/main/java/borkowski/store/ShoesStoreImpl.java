package borkowski.store;
import borkowski.domain.Shoes;

import java.util.ArrayList;
import java.util.NoSuchElementException;


public class ShoesStoreImpl implements ShoesStoreInterface, TimeStampInterface {

    public static ArrayList<Shoes> shoes = new ArrayList<>();
    private long time;
    private boolean readTimeEnabled = true;
    private boolean addTimeEnabled = true;
    private boolean updateTimeEnabled = true;

    public ShoesStoreImpl(){}   //konstr bezparametrowy

    @Override
    public Shoes create(Shoes createShoes) throws IllegalArgumentException {   //CREATE
        for (Shoes sh:shoes){   //Sprawdzenie w bazie czy dane ID już w bazie istnieje
            if(createShoes.getId().equals(sh.getId())){
                throw new IllegalArgumentException("In your Database exist domain in this Id");
            }
        }
        if(addTimeEnabled){
            createShoes.setAddTime(getTimeNow());
        }
        //createShoes.setAddTime(getTimeNow());
        shoes.add(createShoes); //Jesli nie to stwórz
        return createShoes;
    }

    @Override
    public ArrayList<Shoes> readAll(){  //ReadAll
        for (Shoes sh:shoes){
            sh.setReadTime(getTimeNow());
        }
        return shoes;   //Zwroc wszystkie buty
    }

    @Override
    public Shoes read(Long id){      //READ
        for (Shoes sh: shoes){
            if(id.equals(sh.getId())){
                sh.setReadTime(getTimeNow());
                return sh;
            }
        }
        throw new NoSuchElementException("In your Database doesn't exist domain in this Id");
    }

    @Override
    public Shoes update(Shoes updateShoes){     //UPDATE
        if(shoes.contains(updateShoes)){
            shoes.set(shoes.indexOf(updateShoes), updateShoes);
            updateShoes.setUpdateTime(getTimeNow());
            return updateShoes;
        }
        throw new NoSuchElementException("In your Database doesn't exist domain in this Id");
    }

    @Override
    public void delete(Long id){
        Shoes shoe = read(id);
        shoes.remove(shoe);
    }


    @Override
    public long getTimeNow() {
        return this.time;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }


    //Method for getting times for shoes by id

    public ArrayList<Long> getAllTimesForShoes(Long id){
        ArrayList<Long> allTime = new ArrayList<Long>();
        for(Shoes sh: shoes){
            if(id.equals(sh.getId())){
                allTime.add(0, sh.getAddTime());
                allTime.add(1, sh.getReadTime());
                allTime.add(2, sh.getUpdateTime());
                return allTime;
            }
        }
        throw new NoSuchFieldError();
    }

    public boolean setCreateTimeEnabled() {
        return this.readTimeEnabled = true;
    }

    public boolean setCreateTimeDisabled() {
        return this.readTimeEnabled = false;
    }

    public boolean setAddTimeEnabled() {
        return this.addTimeEnabled = true;
    }

    public boolean setAddTimeDisabled() {
        return this.addTimeEnabled= false;
    }

    public boolean setUpdateTimeEnabled() {
        return this.updateTimeEnabled = true;
    }

    public boolean setUpdateTimeDisabled() {
        return this.updateTimeEnabled = false;
    }
}


