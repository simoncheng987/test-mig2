# SOFTENG 206 Assignment 3

Instructions provided by Jeff Peng & Simon Cheng

## Folder Info

The zip folder will contain a **Quinzical** directory, a **src** directory and this **README**.md file.

## Source Code

The source code can be found inside **src** directory

## How to run

1. Unzip Quinzical.zip

2. Navigate inside the folder (Quinzical) containing the Quinzical.jar file using terminal. OR, double left click on the Quinzical folder, right click on the blank area once, left click **"open in terminal"**.

3. Add executable permissions to the jar by using the code below. Copy and paste them into the terminal and press enter.

    ```bash
    chmod +x ./Quinzical.jar
    ```

4. Run the jar from the terminal by using the code below

    ```bash
    java --module-path /home/se2062020/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.media,javafx.base,javafx.fxml -jar Quinzical.jar
    
    ```

where **--module-path** and **--add-modules** is the VM argument, you may change to yours regarding to different location.

## How to play

**Start Menu**

Once you successfully launch the Quinzical program, a nice and neat layout of a main page with three functional buttons “Game”, “Practice” and “Quit” representing three main functions will come into your sights. 

**Practice Mode**

Once you press the “Practice” button, you have started the practice mode of Quinzical. Nine radio buttons will appear showing the nice categories that you could choose to attend. After you have selected one of the buttons and pressed the “go” button, you will see the clue which is randomly selected from the category you’ve chosen, and the clue will be read out to you. You could adjust the speed of the Text-to-Speak system by clicking the “speed up” and “speed down” buttons. Once you hand in your answer the system will let you know whether you are correct or not. You will have three attempts to answer the question. In the third attempt they are given the first letter of the answer as a hint. If you have submitted the incorrect answer for three times, the correct answer will be displayed. You could go back to the main menu anytime by just clicking on the “back to menu” button. 

**Game Mode**

After doing some practice, you may want to play a real game. You could click on the “game” button at the main page to access a real game. Five categories from the New Zealand Question Set are randomly selected. There are five clues in each category. These clues are randomly selected from the list. You can only click the lowest money value for each category, but you can choose any category in the grid. The clue will only be read out by the Text-to-Speck system and not be printed out one the screen. When you type in the correct answer, their worth increases accordingly. If you does not type in the correct answer or clicks the “Don’t know” the clue disappears off the grid, but your worth does not increase.
