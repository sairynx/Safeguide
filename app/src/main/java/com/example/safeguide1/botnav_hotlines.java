package com.example.safeguide1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;


public class botnav_hotlines extends Fragment {

    private static final int REQUEST_CALL = 1;
    private TextView callText, callText1, callText2, callText3, callText4, callText5, callText6, callText7, callText8, callText9;
    private Button callBtn, callBtn1, callBtn2, callBtn3, callBtn4, callBtn5, callBtn6, callBtn7, callBtn8, callBtn9;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_hotlines, container, false);
        callText = view.findViewById(R.id.hotlines_txt3);
        callText1 = view.findViewById(R.id.hotlines_txt6);
        callText2 = view.findViewById(R.id.hotlines_txt7);
        callText3 = view.findViewById(R.id.hotlines_txt10);
        callText4 = view.findViewById(R.id.hotlines_txt112);
        callText5 = view.findViewById(R.id.hotlines_txt113);
        callText6 = view.findViewById(R.id.hotlines_txt114);
        callText7 = view.findViewById(R.id.hotlines_txt115);
        callText8= view.findViewById(R.id.hotlines_txt116);
        callText9 = view.findViewById(R.id.hotlines_txt117);


        callBtn = view.findViewById(R.id.button);
        callBtn1 = view.findViewById(R.id.button1);
        callBtn2 = view.findViewById(R.id.button2);
        callBtn3 = view.findViewById(R.id.button3);
        callBtn4 = view.findViewById(R.id.button4);
        callBtn5 = view.findViewById(R.id.button5);
        callBtn6 = view.findViewById(R.id.button6);
        callBtn7 = view.findViewById(R.id.button7);
        callBtn8 = view.findViewById(R.id.button8);
        callBtn9 = view.findViewById(R.id.button9);



        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                CallButton();
            }
        });
        callBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                CallButton1();
            }
        });
        callBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                CallButton2();
            }
        });
        callBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                CallButton3();
            }
        });
        callBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                CallButton4();
            }
        });
        callBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                CallButton5();
            }
        });
        callBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                CallButton6();
            }
        });
        callBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                CallButton7();
            }
        });
        callBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                CallButton8();
            }
        });
        callBtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                CallButton9();
            }
        });


        return view;
    }


    private void CallButton() {
        String number = callText.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(requireActivity(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    private void CallButton1() {
        String number = callText1.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(requireActivity(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void CallButton2() {
        String number = callText2.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(requireActivity(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    private void CallButton3() {
        String number = callText3.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(requireActivity(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void CallButton4() {
        String number = callText4.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(requireActivity(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void CallButton5() {
        String number = callText5.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(requireActivity(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void CallButton6() {
        String number = callText6.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(requireActivity(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void CallButton7() {
        String number = callText7.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(requireActivity(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void CallButton8() {
        String number = callText8.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(requireActivity(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void CallButton9() {
        String number = callText9.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(requireActivity(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                CallButton();
                CallButton1();
                CallButton2();
                CallButton3();
                CallButton4();
                CallButton5();
                CallButton6();
                CallButton7();
                CallButton8();
                CallButton9();
            } else {
                Toast.makeText(requireActivity(), "permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}



