# 🐍 Snake Game – Java Swing

A classic **Snake Game** built using **Java Swing** with graphics, sound effects, keyboard controls, and score tracking. This project was created as a beginner-friendly desktop game to understand core Java concepts, event handling, and basic game logic.

---
## Game Demo

(https://github.com/RikitaRoy3/JAVA_Snake_Game/blob/main/Visual%20Demonstration%20of%20the%20Game.mp4)

---

## 📌 Features

* Classic Snake gameplay
* Keyboard controls (Arrow Keys)
* Score tracking system
* Game Over detection
* Snake grows on eating food
* Background music and game-over sound effects
* Grid-based movement system
* Simple and clean UI using Java Swing

---

## 🛠️ Technologies Used

* **Java**
* **Java Swing (GUI)**
* **AWT Graphics**
* **Event Handling (KeyListener, ActionListener)**
* **Java Sound API**

---

## 🎮 Controls

* ⬆️ Up Arrow – Move Up
* ⬇️ Down Arrow – Move Down
* ⬅️ Left Arrow – Move Left
* ➡️ Right Arrow – Move Right

---

## 🧠 Game Logic Overview

* The snake moves in fixed grid steps using a timer
* Food appears randomly on the grid
* When the snake eats food:

  * Score increases
  * Snake body length increases
* Game ends when:

  * Snake hits the wall
  * Snake collides with its own body

---

## 📂 Project Structure

```
Snake-Game/
│
├── src/
│   ├── App.java
│   ├── Snake.java
│   ├── backimg.png
│   ├── frog.png
│   ├── snakeHead.png
│   ├── song.wav
│   └── gameoversong.wav
│
└── README.md
```

---

## ▶️ How to Run the Project

1. Clone the repository

   ```bash
   git clone <your-repo-link>
   ```
2. Open the project in any Java IDE (IntelliJ IDEA / Eclipse / VS Code)
3. Make sure all image and sound files are in the correct paths
4. Run `App.java`

---

## 🚀 Future Improvements

* Add pause and restart functionality
* Multiple difficulty levels
* Improved snake and food graphics
* High score saving system
* Menu screen before game start

---

## 📸 Screenshots / Demo

(Add screenshots or a short gameplay GIF here)

---

## 📌 Notes

* This is a **desktop-based Java Swing application**
* It is **not deployable on web platforms like Vercel** without rewriting it for the browser

---

## 👤 Author

**Rikita Roy**

---

## ⭐ Acknowledgement

This project was built for learning purposes and to strengthen understanding of Java GUI programming and basic game development concepts.

---
⭐ If you like this project, feel free to star the repository!
