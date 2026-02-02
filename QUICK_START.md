# Quick Start Guide

## 🚀 Getting the Project Running

### Step 1: Open in Android Studio
1. Open Android Studio
2. Select "Open an Existing Project"
3. Navigate to the `Mobile-app` directory
4. Click "OK"

### Step 2: Sync Gradle
- Android Studio will automatically prompt to sync Gradle files
- Click "Sync Now" if prompted
- Wait for dependencies to download (first time may take a few minutes)

### Step 3: Configure SDK (if needed)
- If you see SDK errors, go to `File > Project Structure > SDK Location`
- Ensure Android SDK is properly configured
- Minimum SDK: 24 (Android 7.0)
- Target SDK: 34 (Android 14)

### Step 4: Build the Project
- Click `Build > Make Project` or press `Ctrl+F9` (Windows/Linux) or `Cmd+F9` (Mac)
- Wait for the build to complete

### Step 5: Run the App
- Connect an Android device or start an emulator
- Click the "Run" button (green play icon) or press `Shift+F10`
- Select your device/emulator
- The app will install and launch

## 📱 What to Expect

When the app launches:
1. You'll see a **draggable canvas** with a grid background
2. Messages will start appearing automatically (simulated financial data and AI responses)
3. **Tap and drag** any message card to move it around the canvas
4. Message positions are **saved automatically** to the Room database
5. Use the **refresh FAB** (floating action button) to reload data

## 🎯 Key Features to Demonstrate

### For Interviews:
1. **Non-Linear UI**: Show how messages can be arranged spatially
2. **Real-Time Streaming**: Point out the RxJava streaming implementation
3. **Offline Support**: Turn off network and show cached data
4. **Custom View**: Explain the `DraggableCanvasView` implementation
5. **Architecture**: Walk through MVVM, Repository pattern, Dagger DI

## 🔧 Troubleshooting

### Build Errors
- **"SDK not found"**: Configure Android SDK in `File > Project Structure`
- **"Gradle sync failed"**: Check internet connection, try `File > Invalidate Caches / Restart`
- **"Dagger compilation errors"**: Run `Build > Clean Project`, then `Build > Rebuild Project`

### Runtime Errors
- **App crashes on launch**: Check logcat for errors, ensure minimum SDK 24+
- **No messages appearing**: Check that RxJava streams are working (see logcat)
- **Database errors**: Clear app data and reinstall

### Dagger Issues
- If you see "Cannot find symbol: DaggerAppComponent", run:
  ```
  ./gradlew clean build
  ```
  This will generate Dagger components.

## 📚 Code Navigation

### Key Files to Review:
- `DraggableCanvasView.kt` - Custom canvas implementation
- `VocalCanvasViewModel.kt` - MVVM ViewModel with RxJava
- `VocalCanvasRepository.kt` - Repository pattern
- `AppModule.kt` - Dagger 2 dependency injection
- `MockVocalCanvasApi.kt` - RxJava streaming demo

## 🎨 Customization

### Change Message Colors
Edit `DraggableCanvasView.kt` → `drawMessageCard()` method

### Modify Stream Frequency
Edit `MockVocalCanvasApi.kt` → `streamMessages()` → Change `interval(2, TimeUnit.SECONDS)`

### Add Real API
1. Update `NetworkModule.kt` with your API base URL
2. Replace `MockVocalCanvasApi` in `AppModule.kt` with Retrofit instance
3. Update `VocalCanvasApi.kt` interface with your endpoints

## 📝 Notes

- The app uses **mock data** by default (see `MockVocalCanvasApi`)
- All messages are cached in **Room database** for offline access
- **Dagger 2** generates code at compile time - look for `DaggerAppComponent` in build folder
- **RxJava 2** handles all async operations and data streams

---

**Ready for your interview!** 🎉

