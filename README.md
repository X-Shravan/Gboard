# 🤖 GBoard AI – Powered by Gemini API

**GBoard AI** is an intelligent custom Android keyboard powered by Google's Gemini API. It works like an automated AI assistant embedded directly into your keyboard—meaning **you can ask any question from any app (like WhatsApp, Instagram, Gmail, etc.)** and get instant AI-generated responses directly in the input text field. 

Just open your keyboard, type or tap to ask, and watch it respond!

---

## 🔍 Features

- 💬 **AI-powered typing**: Ask any question in the keyboard and get instant answers.
- ⚡ **App-independent**: Works across **any app** that uses keyboard input — WhatsApp, Messenger, Instagram, Notes, etc.
- 🧠 **Powered by Gemini API**: Uses Google’s Gemini 1.5+ large language model for fast and accurate responses.
- 🎯 **Real-time Input Replacement**: Replaces your typed question with the AI’s response directly in the text field.
- ✨ **Modes Supported**: Choose AI reply tone like Casual, Funny, Professional, or Flirty.
- 🌙 **Beautiful UI**: Clean, dark-themed keyboard interface with easy-to-use "Ask Gemini" button.

---

## 🧠 How it Works

1. Open any app with a text input field (like WhatsApp or Notes).
2. Launch the **GBoard AI** keyboard.
3. Type your question or tap the "💡 Gemini" button.
4. The keyboard sends your query to the **Gemini API**.
5. The response is automatically inserted into the text field — no need to copy/paste.

✅ All of this happens seamlessly inside the keyboard.

---

## 🛠 Tech Stack

| Component | Technology |
|----------|------------|
| Language | Java (Android), Kotlin (UI support) |
| ML API   | Google Gemini API (generative language) |
| Layouts  | Android XML |
| Deployment | APK / Android Studio |

---

## 📸 Screenshots

| Ask Any Question | AI Reply in Any App |
|------------------|---------------------|
| ![ask](screenshots/ask_question.png) | ![reply](screenshots/ai_response.png) |

---

## 📦 Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/X-Shravan/GBoard-AI.git
cd GBoard-AI
2. Add Gemini API Key
Replace YOUR_API_KEY_HERE in GeminiService.java with your actual Gemini API key:

java
Copy
Edit
String apiKey = "YOUR_API_KEY_HERE";
🔐 You can obtain a key from Google AI Studio

3. Build & Run in Android Studio
Open the project in Android Studio

Connect your Android device or use emulator

Run the app and enable GBoard AI as your default keyboard from settings

🧪 Testing
Open WhatsApp, Instagram, Gmail, or any app.

Tap a text field to bring up GBoard AI.

Type: Who is the current Prime Minister of India?

Tap "Generate Reply"

Watch the AI respond in the same input field ✨

⚠️ Permissions Required
Input Method Editor (IME) permission to function as a custom keyboard

Internet Access for sending prompts to the Gemini API

📁 Project Structure
pgsql
Copy
Edit
GBoard-AI/
├── app/
│   ├── java/com/example/gboardai/
│   │   ├── KeyboardService.java
│   │   ├── GeminiService.java
│   │   └── utils/
│   ├── res/
│   │   ├── layout/keyboard_layout.xml
│   │   └── xml/qwerty.xml
├── AndroidManifest.xml
└── README.md
📜 License
This project is licensed under the MIT License. See LICENSE for more details.

🙌 Credits
Google Gemini API

Android Developers Community

🚀 Future Enhancements
🔊 Voice Input with Gemini response

🌐 Multilingual response generation

💬 Contextual memory for chat-like history

📱 Theme customization and emoji support

💡 Demo Video (Optional)
Watch it in action! (Replace with your YouTube link)

👨‍💻 Developed By
Shravan Wargantiwar
🔗 GitHub Profile
📧 shravanwargantiwar@gmail.com

Empowering every keyboard with the brain of Gemini ✨

yaml
Copy
Edit

---

Let me know if you'd like a `.docx` or `.pdf` version of this `README.md` or want it customized with visuals or 
