# Swim Set Planner Backend (Old)

This project is a quick Spring app I spun up.

The purpose it served was to provide a backend that I could use to learn to make an Angular frontend before I took on 
the challenge of learning NodeJS.

## Setup Instructions

Under /src/main/resources create "application-default.properties". Add a single property named "url" (you can copy it
from application.properties). Change the path to point to your SQLite database.

To build,
```
gradlew build
```

To run,
```
gradlew bootRun
```