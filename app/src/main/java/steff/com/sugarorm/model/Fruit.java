package steff.com.sugarorm.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by Steffin.Joseph on 06-Jan-17.
 */

public class Fruit extends SugarRecord{

    @Unique
    private Long id;
    private String mName;
    private String mColour;

    public Fruit() {

    }

    public Fruit(/*Long mId, */String mName, String mColour) {
        //this.id = mId;
        this.mName = mName;
        this.mColour = mColour;
    }


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmColour() {
        return mColour;
    }

    public void setmColour(String mColour) {
        this.mColour = mColour;
    }
}
