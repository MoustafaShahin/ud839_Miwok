package com.example.android.miwok;

import android.support.v4.content.ContextCompat;

/**
 * Created by Moustafa on 2/4/2018.
 */

public class Word {
    //english word
    String defaultW;
    //miwok word
    String miwokWord;
    //voice file
    String voice = "-1";
    //image id
    int resource_id = -1;

    //default conatructor
    public Word(String mdefault,String mmiwokword){
        defaultW = mdefault;
        miwokWord = mmiwokword;
    }
    // add img
    public Word(String mdefault,String mmiwokword , int img){
        defaultW = mdefault;
        miwokWord = mmiwokword;
        resource_id = img;
    }
    // add img voi
    public Word(String mdefault,String mmiwokword , int img,String voi){
        defaultW = mdefault;
        miwokWord = mmiwokword;
        resource_id = img;
        voice = voi;

    }
    // add voice only
    public Word(String mdefault,String mmiwokword ,String voi){
        defaultW = mdefault;
        miwokWord = mmiwokword;
        voice = voi;
    }

    public String getDefaultTranslation() {
               return defaultW;
           }
    public String getMiwokWord() {
                return miwokWord;
        }
    public int getResource_id() {return resource_id;}
    public String getVoice() {return voice;}
}
