package com.example.android.miwok;

import android.support.v4.content.ContextCompat;

/**
 * Created by Moustafa on 2/4/2018.
 */

public class Word {
    String defaultW;
    String miwokWord;
    String voice = "-1";
    int resource_id = -1;

    public Word(String mdefault,String mmiwokword){
        defaultW = mdefault;
        miwokWord = mmiwokword;
    }
    public Word(String mdefault,String mmiwokword , int img){
        defaultW = mdefault;
        miwokWord = mmiwokword;
        resource_id = img;

    }
    public Word(String mdefault,String mmiwokword , int img,String voi){
        defaultW = mdefault;
        miwokWord = mmiwokword;
        resource_id = img;
        voice = voi;

    }
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
