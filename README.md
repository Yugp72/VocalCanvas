# VocalCanvas - Android Interview Project

A non-linear, interactive Android application that demonstrates innovative UI/UX design and modern Android architecture patterns. Built specifically to showcase technical skills for Android development positions, particularly at companies like Robinhood that value innovative UI/UX and a "builder" mentality.

## 🎯 Project Overview

VocalCanvas breaks away from traditional linear chat interfaces by presenting messages in a **2D draggable canvas** where users can spatially arrange and interact with financial data and AI responses. This demonstrates:

- **Innovative UI/UX**: Non-linear, interactive canvas instead of standard vertical lists
- **Modern Android Architecture**: MVVM with clean separation of concerns
- **Production-Ready Tech Stack**: Dagger 2, RxJava 2, Retrofit, Room
- **Reactive Programming**: Real-time data streaming with RxJava
- **Offline Support**: Local caching with Room database

## 🏗️ Architecture

### Architecture Pattern: MVVM (Model-View-ViewModel)

```
┌─────────────────────────────────────────────────────────┐
│                      UI Layer                            │
│  ┌──────────────┐  ┌─────────────────────────────────┐ │
│  │ MainActivity │  │  DraggableCanvasView (Custom)    │ │
│  └──────┬───────┘  └─────────────────────────────────┘ │
│         │                                                 │
│         ▼                                                 │
│  ┌─────────────────────────────────────────────────────┐ │
│  │         VocalCanvasViewModel                         │ │
│  └──────┬──────────────────────────────────────────────┘ │
└─────────┼─────────────────────────────────────────────────┘
          │
          ▼
┌─────────────────────────────────────────────────────────┐
│                   Repository Layer                      │
│  ┌─────────────────────────────────────────────────────┐ │
│  │         VocalCanvasRepository                       │ │
│  └──────┬───────────────────────┬─────────────────────┘ │
│         │                       │                         │
│         ▼                       ▼                         │
│  ┌──────────────┐      ┌──────────────┐                 │
│  │ VocalCanvasApi│      │ VocalMessageDao│               │
│  │  (Retrofit)   │      │    (Room)     │                 │
│  └──────────────┘      └──────────────┘                 │
└─────────────────────────────────────────────────────────┘
```

### Key Components

#### 1. **Dependency Injection: Dagger 2**
- **Why Dagger 2 over Hilt?** Demonstrates hands-on understanding of DI configuration and manual setup, which is valuable for understanding the underlying principles.
- **Modules:**
  - `AppModule`: Provides application-level dependencies (Database, Repository, API)
  - `NetworkModule`: Provides Retrofit and OkHttp instances (ready for production API integration)

#### 2. **Reactive Programming: RxJava 2**
- **Streaming Data**: Uses `Observable.interval()` to simulate real-time financial data streams
- **Error Handling**: Graceful fallback to cached data when network fails
- **Threading**: Proper use of `subscribeOn()` and `observeOn()` for background/UI thread separation
- **Operators**: Demonstrates `flatMap`, `onErrorResumeNext`, `delay`, and more

#### 3. **Network Layer: Retrofit**
- Configured with RxJava 2 adapter for reactive API calls
- OkHttp with logging interceptor for debugging
- Gson converter for JSON serialization
- Currently uses `MockVocalCanvasApi` for demonstration, but easily switchable to real endpoints

#### 4. **Local Storage: Room Database**
- Caches messages locally for offline support
- RxJava 2 integration for reactive database queries
- Automatic position persistence for draggable messages
- DAO pattern for clean data access

#### 5. **UI: Custom Draggable Canvas**
- **Non-Linear Design**: Messages can be dragged and arranged in 2D space
- **Custom View**: `DraggableCanvasView` extends `View` with custom drawing and touch handling
- **Material Design**: Uses Material Components for consistent theming
- **Visual Feedback**: Color-coded cards based on message type (Financial, AI, User, System)

## 📁 Project Structure

```
app/src/main/java/com/vocalcanvas/android/
├── di/                          # Dagger 2 Dependency Injection
│   ├── AppComponent.kt         # Main Dagger component
│   ├── AppModule.kt            # Application-level dependencies
│   └── NetworkModule.kt        # Network configuration
├── data/
│   ├── local/                  # Room Database
│   │   ├── VocalCanvasDatabase.kt
│   │   └── VocalMessageDao.kt
│   ├── remote/                 # Retrofit API
│   │   ├── VocalCanvasApi.kt
│   │   └── MockVocalCanvasApi.kt
│   └── repository/             # Repository pattern
│       └── VocalCanvasRepository.kt
├── model/                      # Data models
│   └── VocalMessage.kt
├── ui/                         # UI components
│   ├── MainActivity.kt
│   └── DraggableCanvasView.kt  # Custom draggable canvas
├── viewmodel/                  # ViewModels
│   ├── VocalCanvasViewModel.kt
│   └── VocalCanvasViewModelFactory.kt
└── VocalCanvasApplication.kt   # Application class
```

## 🛠️ Tech Stack

| Component | Technology | Version | Purpose |
|-----------|-----------|---------|---------|
| Language | Kotlin | 1.9.20 | Modern, concise Android development |
| DI | Dagger 2 | 2.48 | Dependency injection |
| Reactive | RxJava 2 | 2.2.21 | Reactive programming & streaming |
| Network | Retrofit | 2.9.0 | REST API calls |
| Database | Room | 2.6.1 | Local data persistence |
| UI | Material Design | 1.11.0 | Modern UI components |
| Architecture | MVVM | - | Clean architecture pattern |

## 🚀 Getting Started

### Prerequisites
- Android Studio Hedgehog (2023.1.1) or later
- JDK 17 or later
- Android SDK 24+ (minimum), 34 (target)

### Setup
1. Clone the repository
2. Open in Android Studio
3. Sync Gradle files
4. Run on emulator or device

### Building
```bash
./gradlew assembleDebug
```

### Running Tests
```bash
./gradlew test
```

## 💡 Key Features

### 1. Real-Time Data Streaming
- Simulates live financial data updates using RxJava `Observable.interval()`
- Demonstrates reactive programming patterns
- Shows proper error handling and fallback mechanisms

### 2. Draggable Canvas Interface
- **Innovation**: Breaks from traditional linear chat UI
- Users can drag messages around a 2D canvas
- Position persistence in Room database
- Visual grid background for spatial reference

### 3. Offline Support
- All messages cached locally using Room
- Automatic fallback to cached data when network unavailable
- Position updates saved to database

### 4. Material Design
- Consistent theming with Material Components
- Color-coded message types
- Smooth animations and transitions

## 🎨 Design Decisions

### Why Dagger 2?
- **Learning Value**: Understanding manual DI setup provides deeper insight into dependency injection principles
- **Interview Value**: Demonstrates knowledge beyond convenience libraries
- **Production Ready**: Dagger 2 is battle-tested and widely used in production apps

### Why RxJava 2?
- **Streaming Data**: Perfect for real-time financial data streams
- **Error Handling**: Robust error handling with operators like `onErrorResumeNext`
- **Threading**: Clean separation of background and UI threads
- **Industry Standard**: Still widely used in production Android apps

### Why Custom Canvas View?
- **Innovation**: Demonstrates ability to build custom UI components
- **User Experience**: Non-linear interface provides unique interaction model
- **Technical Depth**: Shows understanding of custom drawing, touch handling, and view lifecycle

## 📊 Interview Talking Points

### Architecture
- "I chose MVVM to separate business logic from UI, making the code testable and maintainable."
- "The Repository pattern abstracts data sources, allowing easy switching between network and local storage."

### Dependency Injection
- "Dagger 2 provides compile-time safety and makes dependencies explicit, improving code quality."
- "I structured modules by concern (App, Network) to keep the dependency graph clear and maintainable."

### Reactive Programming
- "RxJava 2 handles the complexity of asynchronous data streams elegantly."
- "I used operators like `flatMap` to chain network calls with database operations."
- "Error handling with `onErrorResumeNext` ensures the app gracefully falls back to cached data."

### UI/UX Innovation
- "The draggable canvas breaks from traditional linear interfaces, allowing users to spatially organize information."
- "Custom view implementation demonstrates understanding of Android's drawing and touch systems."

### Offline Support
- "Room database provides offline-first architecture, ensuring the app works without network."
- "Position persistence means users' spatial arrangements are preserved across app restarts."

## 🔮 Future Enhancements

- [ ] Real API integration (replace MockVocalCanvasApi)
- [ ] Unit tests for ViewModels and Repository
- [ ] UI tests for draggable canvas interactions
- [ ] Message grouping and clustering
- [ ] Pinch-to-zoom on canvas
- [ ] Export canvas as image
- [ ] Multi-user collaboration
- [ ] Dark mode support

## 📝 License

This project is created for interview/portfolio purposes.

## 👤 Author

Built to demonstrate Android development skills with focus on:
- Modern architecture patterns
- Reactive programming
- Custom UI development
- Production-ready code structure

---

**Note**: This project uses mock data for demonstration. In production, replace `MockVocalCanvasApi` with actual Retrofit API calls by updating `AppModule` and `NetworkModule`.

