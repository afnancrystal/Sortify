# 📱 Sortify

## Overview

Sortify is a native Android application developed in **Kotlin** using **Jetpack Compose**. This project demonstrates effective data fetching, filtering, sorting, and a clean, user-friendly UI.

<p align="center">
  <img src="https://github.com/user-attachments/assets/0a59be55-1382-4dd0-a23f-5b816d20dad0" width="200"/>
  <img src="https://github.com/user-attachments/assets/8e159818-97a3-4882-b645-8d37ba581b91" width="200"/>
  <img src="https://github.com/user-attachments/assets/656ec648-e1b5-4d55-aa64-5ab3ea69132b" width="200"/>
  <img src="https://github.com/user-attachments/assets/87788dea-a681-441d-8063-1485d9d46a41" width="200"/>
  <img src="https://github.com/user-attachments/assets/cc630691-1c31-402a-b622-17389859afbf" width="200"/>
</p>

---

## ✅ Features

* 📦 Fetches data from: [https://hiring.fetch.com/hiring.json](https://hiring.fetch.com/hiring.json)
* 📚 Groups items by `listId`.
* 📌 Filters out items where `name` is blank or null.
* 🔢 Sorts data by `listId` first, then alphabetically by `name`.
* 🗂️ Clean tab-based UI: Each `listId` group appears in a separate tab.
* 📱 Built using the latest Android SDK (API 34) and Jetpack Compose.

---

## 🚀 How to Run

1. **Clone the Repository**

   ```bash
   git clone <your-repo-link>
   cd Sortify
   ```

2. **Open in Android Studio**

   * Use Android Studio Meerkat or newer.
   * Ensure JDK 17+ is configured.

3. **Build & Run**

   * Connect an emulator or physical device.
   * Hit "Run" or use Gradle command:

     ```bash
     ./gradlew build
     ```

---

## 📂 Project Structure

```
com.example.sortify/
├── MainActivity.kt           # App entry point  
├── ApiService.kt             # Retrofit API service  
├── ItemRepository.kt         # Data repository layer  
├── Item.kt                   # Data model  
├── ItemViewModel.kt          # MVVM ViewModel  
└── ui/ItemListScreen.kt      # Compose UI with Tab Layout  
```

---

## 🛠️ Tech Stack

* **Language:** Kotlin
* **UI Framework:** Jetpack Compose (Material3)
* **Networking:** Retrofit & Gson
* **Architecture:** MVVM (Model-View-ViewModel)
* **Dependency Management:** Gradle

---

## 📑 Notes

* The app gracefully handles empty or null item names by excluding them from the display.
* Tabs ensure easy navigation between different `listId` groups.
* Uses modern Android APIs and libraries to ensure smooth performance and compatibility.
