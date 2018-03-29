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

public class FamilyActivity extends AppCompatActivity {
MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "әpә", R.mipmap.family_father, "family_father"));
        words.add(new Word("mother", "әṭa", R.mipmap.family_mother, "family_mother"));
        words.add(new Word("son", "angsi", R.mipmap.family_son, "family_son"));
        words.add(new Word("daughter", "tune", R.mipmap.family_daughter, "family_daughter"));
        words.add(new Word("older brother", "taachi", R.mipmap.family_older_brother, "family_older_brother"));
        words.add(new Word("younger brother", "chalitti", R.mipmap.family_younger_brother, "family_younger_brother"));
        words.add(new Word("older sister", "teṭe", R.mipmap.family_older_sister,"family_older_sister"));
        words.add(new Word("younger sister", "kolliti", R.mipmap.family_younger_sister,"family_younger_sister"));
        words.add(new Word("grandmother ", "ama", R.mipmap.family_grandmother,"family_grandmother"));
        words.add(new Word("grandfather", "paapa", R.mipmap.family_grandfather,"family_grandfather"));

        //list view
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                int ids = getResources().getIdentifier(words.get(position).getVoice(),"raw", getPackageName());
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this,ids);
                mMediaPlayer.start();
                Toast.makeText(FamilyActivity.this,words.get(position).getMiwokWord(),Toast.LENGTH_LONG).show();
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {

                    }
                });

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
