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
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "minto wuksus","phrase_where_are_you_going"));
        words.add(new Word("What is your name?", "tinnә oyaase'nә","phrase_what_is_your_name"));
        words.add(new Word("My name is...", "oyaaset...","phrase_my_name_is"));
        words.add(new Word("How are you feeling?", "michәksәs?","phrase_how_are_you_feeling"));
        words.add(new Word("I’m feeling good.", "kuchi achit","phrase_im_feeling_good"));
        words.add(new Word("Are you coming?", "әәnәs'aa?","phrase_are_you_coming"));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm","phrase_yes_im_coming"));
        words.add(new Word("I’m coming.", "әәnәm","phrase_im_coming"));
        words.add(new Word("Let’s go.", "yoowutis","phrase_lets_go"));
        words.add(new Word("Come here.", "әnni'nem","phrase_come_here"));

        WordAdapter itemadapter = new WordAdapter(this,words,R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                int ids = getResources().getIdentifier(words.get(i).getVoice(),"raw",getPackageName());
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this,ids);
                mMediaPlayer.start();
                Toast.makeText(PhrasesActivity.this,words.get(i).getMiwokWord(),Toast.LENGTH_SHORT).show();
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
