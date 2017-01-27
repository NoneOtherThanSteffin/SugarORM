package steff.com.sugarorm.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import steff.com.sugarorm.Interface.FruitRepositoryInterface;
import steff.com.sugarorm.R;
import steff.com.sugarorm.model.Fruit;
import steff.com.sugarorm.repository.FruitRepository;

/**
 * Created by steffin.joseph on 1/27/2017.
 */

public class SugarActivity extends AppCompatActivity {

    @BindView(R.id.buttonSaveFruit) Button mButtonSaveFruit;
    @BindView(R.id.buttonGetFruitById) Button mButtonGetFruitById;
    @BindView(R.id.buttonDeleteFruitByID) Button mButtonDeleteFruitById;
    @BindView(R.id.editTextName) EditText mNameEditText;
    @BindView(R.id.editTextColor) EditText mColourEditText;
    @BindView(R.id.editTextGetfruitByID) EditText mEditTextGetFruitById;
    @BindView(R.id.editTextDeleteFruitById)EditText mEditTextDeleteFruitById;
    @BindView(R.id.textViewGetFruitById) TextView mTextViewGetFruit;
    @BindView(R.id.textViewDeleteFruitById) TextView mTextViewDeleteFruit;
    @BindView(R.id.textViewSavedFruit) TextView mTextViewSavedFruit;

    FruitRepositoryInterface mFruitRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugar);
        mFruitRepository = new FruitRepository();
        System.out.print(mFruitRepository.toString());
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonSaveFruit)
    public void saveFruit() {
        String fruitName = mNameEditText.getText().toString();
        String fruitColor = mColourEditText.getText().toString();
        if (fruitName == null || fruitColor == null) {
            Toast.makeText(getApplication(), "Enter All the values", Toast.LENGTH_SHORT).show();
        } else {
            Fruit mFruit = new Fruit(fruitName, fruitColor);
            mFruitRepository.addFruit(mFruit);
            mTextViewSavedFruit.setText("Saved Fruit:\nID: " + mFruit.getId() + " Name: " + mFruit.getmName() + " Colour: " + mFruit.getmColour());
        }
    }

    @OnClick(R.id.buttonDeleteFruitByID)
    public void deleteFruit() {
        Long fruitID = Long.parseLong(mEditTextDeleteFruitById.getText().toString());
        if (fruitID == null) {
            Toast.makeText(getApplication(), "Enter ID", Toast.LENGTH_SHORT).show();
        } else {
            Fruit mFruit = mFruitRepository.getFruit(fruitID);
            if(mFruitRepository.deleteFruit(fruitID)) {
                mTextViewDeleteFruit.setText("Deleted Fruit:\n"+ "ID: " + mFruit.getId() + " Name: " + mFruit.getmName() + " Colour: " + mFruit.getmColour());
            }
        }
    }

    @OnClick(R.id.buttonGetFruitById)
    public void getFruit() {
        Long fruitID = Long.parseLong(mEditTextGetFruitById.getText().toString());
        Fruit getFruit = null;
        if (fruitID == null) {
            Toast.makeText(getApplication(), "Enter ID", Toast.LENGTH_SHORT).show();
        } else {
            getFruit = mFruitRepository.getFruit(fruitID);
        }
        if (getFruit != null) {
            mTextViewGetFruit.setText("ID: " + getFruit.getId() + " Name: " + getFruit.getmName() + " Colour: " + getFruit.getmColour());
        }
    }

}
