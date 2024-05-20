package com.example.safeguide1;

import android.content.Context;
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
import android.Manifest;
import android.content.pm.PackageManager;

public class manualvids extends Fragment {

    private static final int REQUEST_EXTERNAL_STORAGE_PERMISSION = 1;
    private VideoView videoView;
    private SeekBar seekBar;
    private OnManualVidsBackPressedListener backPressedListener;

    public interface OnManualVidsBackPressedListener {
        void onManualVidsBackPressed();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnManualVidsBackPressedListener) {
            backPressedListener = (OnManualVidsBackPressedListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnManualVidsBackPressedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        backPressedListener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_manualvids, container, false);

        videoView = rootView.findViewById(R.id.videoView);
        seekBar = rootView.findViewById(R.id.seekBar);

        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_EXTERNAL_STORAGE_PERMISSION);
        } else {
            playVideo();
        }

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
        String videoPath = "android.resource://" + requireContext().getPackageName() + "/" + R.raw.clothes_fire;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar.setMax(videoView.getDuration());
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (videoView != null) {
                            seekBar.setProgress(videoView.getCurrentPosition());
                            new Handler(Looper.getMainLooper()).postDelayed(this, 1000);
                        }
                    }
                }, 1000);

                final Runnable hideSeekBarRunnable = new Runnable() {
                    @Override
                    public void run() {
                        seekBar.setVisibility(View.GONE);
                    }
                };

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser) {
                            videoView.seekTo(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        seekBar.removeCallbacks(hideSeekBarRunnable);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        seekBar.postDelayed(hideSeekBarRunnable, 2000);
                    }
                });

                seekBar.setVisibility(View.GONE);

                videoView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (seekBar.getVisibility() == View.VISIBLE) {
                            seekBar.setVisibility(View.GONE);
                        } else {
                            seekBar.setVisibility(View.VISIBLE);
                        }

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
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                playVideo();
            } else {
                Toast.makeText(requireContext(), "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
