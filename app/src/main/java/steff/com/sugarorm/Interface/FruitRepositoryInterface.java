package steff.com.sugarorm.Interface;

import java.util.ArrayList;

import steff.com.sugarorm.model.Fruit;

/**
 * Created by steffin.joseph on 1/27/2017.
 */

public interface FruitRepositoryInterface {

    void addFruit(Fruit mFruit);

    Fruit getFruit(long id);

    boolean deleteFruit(long id);

    void updateFruit(Fruit mFruit);

    ArrayList<Fruit> getAllFruits();

}
