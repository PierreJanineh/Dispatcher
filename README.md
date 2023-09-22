# Dispatcher

Dispatcher is an Android application designed to manage and display articles fetched from a remote API. The application provides a user-friendly interface to view articles, their details, and offers functionalities like displaying a splash screen and navigating through different sections of the app.

## Features

- **Dashboard**: View a list of articles with their titles, descriptions, and images.
- **Splash Screen**: A visually appealing splash screen displayed when the app is launched.
- **Navigation**: Navigate through different sections of the app using the bottom navigation bar.
- **Network Management**: Efficiently fetch articles from a remote API and handle network responses.

## Architecture & Components

- **ViewModel**: The app uses the ViewModel component to manage UI-related data in a lifecycle-conscious way.
- **Data Models**: Define the structure of articles and their attributes.
- **Network Management**: Utilizes Retrofit for API calls and manages network configurations.
- **UI Components**: Custom views and fragments to display the app's content.

## Installation

1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the application on an emulator or a physical device.

## Usage

Upon launching the app, users are greeted with a splash screen. After a short delay, the main dashboard displaying a list of articles is presented. Users can navigate through different sections of the app using the bottom navigation bar.

## Contributing

Contributions are welcome! If you have any improvements, features, or bug fixes, feel free to create a pull request.
