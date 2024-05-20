package com.example.safeguide1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class start_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                startActivity(new Intent(start_up.this, main_dash.class));
            }
        });
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

