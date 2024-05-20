package com.example.safeguide1;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.media.MediaPlayer;

public class manualvids11 extends Fragment {

    private static final int REQUEST_EXTERNAL_STORAGE_PERMISSION = 1;
    private VideoView videoView;
    private SeekBar seekBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_manualvids11, container, false);

        videoView = rootView.findViewById(R.id.videoView);
        seekBar = rootView.findViewById(R.id.seekBar); // Initialize the SeekBar

        // Check if permission is granted
        if (ContextCompat.checkSelfPermission(requireContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted, request it
            ActivityCompat.requestPermissions(requireActivity(),
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_EXTERNAL_STORAGE_PERMISSION);
        } else {
            // Permission is granted, proceed with video playback
            playVideo();
        }

        // Set up video view click listener to toggle video playback
        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()) {
                    videoView.pause();
                } else {
                    videoView.start();
                }
            }
        });

        return rootView;
    }

    private void playVideo() {
        // Set the path of the video file
        String videoPath = "android.resource://" + requireContext().getPackageName() + "/" + R.raw.openfracture;

        // Parse the video Uri
        Uri uri = Uri.parse(videoPath);

        // Set the Uri to the VideoView
        videoView.setVideoURI(uri);

        // Start playing the video
        videoView.start();

        // Set up a listener to update seekbar progress as the video plays
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                // Update seekbar max duration to match video duration
                seekBar.setMax(videoView.getDuration());

                // Create a handler to update seekbar progress every second
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (videoView != null) {
                            // Update seekbar progress
                            seekBar.setProgress(videoView.getCurrentPosition());
                            // Call this runnable again after 1 second
                            new Handler(Looper.getMainLooper()).postDelayed(this, 1000);
                        }
                    }
                }, 1000);

                // Set up a handler to hide the seek bar after a delay when it's not being touched
                final Runnable hideSeekBarRunnable = new Runnable() {
                    @Override
                    public void run() {
                        seekBar.setVisibility(View.GONE);
                    }
                };

                // Set up a listener to detect user interaction with the seek bar
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser) {
                            // Seek video to the specified progress
                            videoView.seekTo(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        // Cancel the hide seek bar runnable when the seek bar is touched
                        seekBar.removeCallbacks(hideSeekBarRunnable);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        // Schedule hiding the seek bar after a delay when the seek bar is released
                        seekBar.postDelayed(hideSeekBarRunnable, 2000); // Adjust the delay as needed
                    }
                });

                // Hide the seek bar initially
                seekBar.setVisibility(View.GONE);

                // Show/hide the seek bar when the video view is clicked
                videoView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (seekBar.getVisibility() == View.VISIBLE) {
                            seekBar.setVisibility(View.GONE);
                        } else {
                            seekBar.setVisibility(View.VISIBLE);
                        }

                        // Toggle video playback
                        if (videoView.isPlaying()) {
                            videoView.pause();
                        } else {
                            videoView.start();
                        }
                    }
                });
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_EXTERNAL_STORAGE_PERMISSION) {
            // If request is cancelled, the result arrays are empty
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, proceed with video playback
                playVideo();
            } else {
                // Permission denied, inform the user
                Toast.makeText(requireContext(), "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}