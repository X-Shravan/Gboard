package com.example.gboard;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Spinner modeSpinner;
    private EditText userInput;
    private Button generateButton;
    private TextView replyText;

    private final String API_KEY = "AIzaSyBfGBCk3RUqYzU7sgvyhCm4Vc7wbmYYRQE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modeSpinner = findViewById(R.id.modeSpinner);
        userInput = findViewById(R.id.userInput);
        generateButton = findViewById(R.id.generateButton);
        replyText = findViewById(R.id.replyText);

        // ✅ Enable scrolling on the reply TextView
        replyText.setMovementMethod(new ScrollingMovementMethod());

        String[] modes = {"casual", "funny", "professional", "flirty"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, modes);
        modeSpinner.setAdapter(adapter);

        generateButton.setOnClickListener(v -> generateReply());
    }

    private void generateReply() {
        String userMessage = userInput.getText().toString();
        String mode = modeSpinner.getSelectedItem().toString();
        String prompt = "Reply to this in a " + mode + " tone: " + userMessage;

        GeminiService service = ApiClient.getClient().create(GeminiService.class);
        GeminiRequest request = new GeminiRequest(prompt);

        replyText.setText("Typing...");

        Call<GeminiResponse> call = service.generateContent("models/gemini-2.0-flash", API_KEY, request);

        call.enqueue(new Callback<GeminiResponse>() {
            @Override
            public void onResponse(Call<GeminiResponse> call, Response<GeminiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        String reply = response.body()
                                .getCandidates()
                                .get(0)
                                .getContent()
                                .getParts()
                                .get(0)
                                .getText();
                        replyText.setText(reply);
                    } catch (Exception e) {
                        replyText.setText("Error parsing reply");
                        Log.e("ParseError", e.toString());
                    }
                } else {
                    replyText.setText("Failed to get a reply.\nCode: " + response.code());
                    try {
                        Log.e("GeminiAPI", "Error body: " + response.errorBody().string());
                    } catch (Exception e) {
                        Log.e("GeminiAPI", "Error parsing errorBody");
                    }
                }
            }

            @Override
            public void onFailure(Call<GeminiResponse> call, Throwable t) {
                replyText.setText("Request Failed: " + t.getMessage());
                Log.e("GeminiAPI", "onFailure: ", t);
            }
        });
    }
}
