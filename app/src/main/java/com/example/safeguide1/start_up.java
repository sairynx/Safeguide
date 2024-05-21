package com.example.safeguide1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class start_up extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String KEY_FIRST_TIME = "first_time";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if it's the first time the app is opened
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        boolean firstTime = settings.getBoolean(KEY_FIRST_TIME, true);

        if (!firstTime) {
            // If not the first time, go directly to main_dash
            proceedToHomePage();
            return;
        }

        // Otherwise, show the start_up activity
        setContentView(R.layout.activity_start_up);

        TextView textView1 = findViewById(R.id.textViewDescription1);
        TextView textView2 = findViewById(R.id.textViewDescription2);
        TextView textView3 = findViewById(R.id.textViewDescription3);

        // Set the paragraphs
        String paragraph1 = getString(R.string.Paragraph_1);
        String paragraph2 = getString(R.string.Paragraph_2);
        String paragraph3 = getString(R.string.Paragraph_3);

        // Indentation for the first sentence
        int indentSize = getResources().getDimensionPixelSize(R.dimen.indentation_size); // Define your indentation size in dimensions.xml

        // Apply indentation to the first sentence of each paragraph
        textView1.setText(getIndentedText(paragraph1, indentSize));
        textView2.setText(getIndentedText(paragraph2, indentSize));
        textView3.setText(getIndentedText(paragraph3, indentSize));

        // Set up button click listener
        LinearLayout button = findViewById(R.id.str_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mark the app as opened before
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean(KEY_FIRST_TIME, false);
                editor.apply();

                // Proceed to main_dash activity
                proceedToHomePage();
            }
        });
    }

    private void proceedToHomePage() {
        startActivity(new Intent(start_up.this, main_dash.class));
        finish();
    }

    // Method to apply indentation to the first sentence of a paragraph
    private SpannableString getIndentedText(String text, int indentSize) {
        SpannableString spannableString = new SpannableString(text);

        // Find the end index of the first sentence
        int firstSentenceEnd = text.indexOf('.') + 1;

        // Apply LeadingMarginSpan to indent the first sentence
        spannableString.setSpan(new LeadingMarginSpan.Standard(indentSize, 0), 0, firstSentenceEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }
}
