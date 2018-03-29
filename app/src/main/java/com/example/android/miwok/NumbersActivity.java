/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        //change from array to arraylist
        final ArrayList<Word> words = new ArrayList<Word>();

            words.add(new Word("one 1","lutti ",R.mipmap.number_one,"number_one"));
            words.add(new Word("two 2","otiiko",R.mipmap.number_two,"number_two" ));
            words.add(new Word("three 3","tolookosu",R.mipmap.number_three,"number_three" ));
            words.add(new Word("four 4","oyyisa",R.mipmap.number_four ,"number_four"));
            words.add(new Word("five 5","massokka",R.mipmap.number_five,"number_five" ));
            words.add(new Word("six 6","ستة ",R.mipmap.number_six,"number_six" ));
            words.add(new Word("seven 7","سبعة",R.mipmap.number_seven,"number_seven" ));
            words.add(new Word("eight 8","ثمانيه",R.mipmap.number_eight ));
            words.add(new Word("nine 9","تسعة ",R.mipmap.number_nine ));
            words.add(new Word("ten 10","عشرة",R.mipmap.number_ten ));



        //list view
        WordAdapter itemsAdapter = new WordAdapter(this , words,R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                int ids = getResources().getIdentifier(words.get(i).getVoice(),"raw",getPackageName());
               mMediaPlayer = MediaPlayer.create(NumbersActivity.this,ids);
               mMediaPlayer.start();
                Toast.makeText(NumbersActivity.this,words.get(i).getMiwokWord(),Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
