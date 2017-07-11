# Tic Tac Toe game

## To run the project:
1. Download the project sources
2. Run mvn install inside the project folder
3. Go to the target folder
4. Run tictactoe-1.0-SNAPSHOT.jar

## General todo:
1. Finish implementing client/server architecture and merge to master
2. Move messages in languages to files


## Requirements list:
1. It is "best of three", though I can quit mid-way through. ☑
2. Characters: O (naught) and X (cross) ☑
3. Players have names and scores. ☑
4. Winner has better score. Draw is possible. ☑
5. Interactive:
6. it should accept players instructions about each move ☑
7. it should ask who begins ☑
8. it informs about session result, who’s turn it is now and the like ☑
9. Match gives points: win 3, draw 1, loss 0. 3 matches == game. ☑
10. Game works with square or rectangular board. ☑
11. Player wins, if he has unbroken line of his characters, in a row, in a column or diagonally. ☑
12. Winning is announced in a message: Wygrywa O. O: 1 X: 0 (numbers are current points). ☑
13. Game is configurable:
14. Board dimensions: 3x3, 4x4, 99x101, etc. (user provides) ☑ (size must be between 3 and 1000)
15. Winning condition has variable number of characters: 3, 4, 5, etc. (user provides) ☑
16. Game messages should have configurable target: console (System.out) or logs (for the sake of this exercise it’s OK to make it System.err), or external printer. There is difference on errors and messages, but all errors are in english
17. before game starts it asks who goes first, O or X ☑
18. We are bi-lingual: Polish and English are fine. In future we want to add more languages: messages are to be read from a file for chosen language. Choosing the language depends on configuration variable. User can choose language, but messages are hardcoded in classes
19. Client/Server architecture
