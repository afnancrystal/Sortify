# 📱 Sortify

## Overview

Sortify is a native Android application developed in **Kotlin** using **Jetpack Compose**. This project demonstrates effective data fetching, filtering, sorting, and a clean, user-friendly UI.

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
