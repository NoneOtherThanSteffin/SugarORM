package steff.com.sugarorm.repository;

import java.util.ArrayList;
import java.util.Iterator;

import steff.com.sugarorm.Interface.FruitRepositoryInterface;
import steff.com.sugarorm.model.Fruit;

/**
 * Created by steffin.joseph on 1/27/2017.
 */

public class FruitRepository implements FruitRepositoryInterface{

    @Override
    public void addFruit(Fruit mFruit) {
        mFruit.save();
    }

    @Override
    public Fruit getFruit(long id) {
        return Fruit.findById(Fruit.class,id);
    }

    @Override
    public boolean deleteFruit(long id) {
        Fruit deleteFruit = Fruit.findById(Fruit.class,id);
        if(deleteFruit !=null) {
            return deleteFruit.delete();
        }
        return false;
    }

    @Override
    public void updateFruit(Fruit mFruit) {
        Fruit oldFruit = Fruit.findById(Fruit.class,mFruit.getId());
        oldFruit.delete();
        mFruit.save();
    }

    @Override
    public ArrayList<Fruit> getAllFruits() {
        Iterator<Fruit> allFruits = Fruit.findAll(Fruit.class);
        ArrayList<Fruit> fruitArrayList = new ArrayList<>();
        while (allFruits.hasNext()){
            fruitArrayList.add(allFruits.next());
        }
        return fruitArrayList;
    }
}
