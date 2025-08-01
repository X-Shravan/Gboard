package com.example.gboard;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GeminiKeyboard extends InputMethodService {

    private EditText geminiInput;
    private Button generateBtn;

    @Override
    public View onCreateInputView() {
        View view = getLayoutInflater().inflate(R.layout.keyboard_layout, null);
        geminiInput = view.findViewById(R.id.geminiInput);
        generateBtn = view.findViewById(R.id.generateBtn);

        generateBtn.setOnClickListener(v -> {
            String prompt = geminiInput.getText().toString();
            if (!prompt.isEmpty()) callGeminiAPI(prompt);
        });

        return view;
    }

    private void callGeminiAPI(String prompt) {
        GeminiService service = ApiClient.getClient().create(GeminiService.class);
        GeminiRequest request = new GeminiRequest(prompt);

        Call<GeminiResponse> call = service.generateContent("models/gemini-2.0-flash", "AIzaSyBfGBCk3RUqYzU7sgvyhCm4Vc7wbmYYRQE", request);
        call.enqueue(new Callback<GeminiResponse>() {
            @Override
            public void onResponse(Call<GeminiResponse> call, Response<GeminiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    String reply = response.body()
                            .getCandidates().get(0)
                            .getContent().getParts().get(0).getText();

                    InputConnection ic = getCurrentInputConnection();
                    if (ic != null) {
                        ic.commitText(reply, 1);
                    }
                }
            }

            @Override
            public void onFailure(Call<GeminiResponse> call, Throwable t) {
                // Optional: log error
            }
        });
    }
}
