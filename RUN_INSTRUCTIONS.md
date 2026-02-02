# 🚀 How to Run VocalCanvas

## Quick Start (Recommended: Android Studio)

### Step 1: Open Project in Android Studio
1. **Launch Android Studio** (download from https://developer.android.com/studio if needed)
2. Click **"Open"** or **"File > Open"**
3. Navigate to `/Users/yugpatel/Desktop/Mobile-app`
4. Click **"OK"**

### Step 2: Let Android Studio Sync
- Android Studio will automatically:
  - Download Gradle wrapper (if needed)
  - Sync project files
  - Download dependencies
  - Index the codebase
- **Wait for sync to complete** (first time may take 5-10 minutes)

### Step 3: Set Up Android SDK (if prompted)
- If you see SDK errors, go to **Tools > SDK Manager**
- Install:
  - Android SDK Platform 34
  - Android SDK Build-Tools
  - Android Emulator (if you want to use emulator)

### Step 4: Create/Start an Emulator (or connect device)
**Option A: Use Emulator**
1. Click **Tools > Device Manager**
2. Click **"Create Device"**
3. Choose a device (e.g., Pixel 6)
4. Download a system image (API 34 recommended)
5. Click **"Finish"**
6. Click the **Play button** next to your device to start it

**Option B: Use Physical Device**
1. Enable **Developer Options** on your Android device
2. Enable **USB Debugging**
3. Connect device via USB
4. Accept the debugging prompt on your device

### Step 5: Run the App
1. Click the **green "Run" button** (▶️) in the toolbar
2. Or press **Shift+F10** (Windows/Linux) or **Cmd+R** (Mac)
3. Select your device/emulator
4. The app will build, install, and launch automatically!

## What You'll See

When the app launches:
- ✅ A **draggable canvas** with grid background
- ✅ Messages appearing automatically (financial data + AI responses)
- ✅ **Tap and drag** any message card to move it around
- ✅ A **refresh button** (FAB) in the bottom right

## Troubleshooting

### "SDK not found" Error
- Go to **File > Project Structure > SDK Location**
- Set Android SDK location (usually `~/Library/Android/sdk` on Mac)

### "Gradle sync failed"
- Click **File > Invalidate Caches / Restart**
- Select **"Invalidate and Restart"**
- Wait for re-indexing

### "DaggerAppComponent not found"
- This is normal on first build
- Dagger generates code during compilation
- Just build the project: **Build > Make Project**

### Build Errors
- Ensure **JDK 17** is installed and configured
- In Android Studio: **File > Project Structure > SDK Location**
- Set **JDK location** to JDK 17

## Alternative: Command Line (Advanced)

If you have Java and Android SDK installed:

```bash
# Set Android SDK path
export ANDROID_HOME=~/Library/Android/sdk
export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools

# Build the project
./gradlew assembleDebug

# Install on connected device
./gradlew installDebug
```

---

**💡 Tip**: Android Studio is the easiest way to run Android projects. It handles all the setup automatically!

