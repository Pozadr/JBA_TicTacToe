# Tic Tac Toe 
[JetBrains Academy](https://hyperskill.org) / Java Developer project.
[My profile -> Pozadr](https://hyperskill.org/profile/17362185 "Pozadr")

Source code: *JBA_TicTacToe/Tic-Tac-Toe with AI/task/src/tictactoe/*

## Description
TicTacToe game with 3 levels of AI. 

There are two implementation on two branches:
* master --> two-dimensional array used
* OneDimArray --> one-dimensional array used



There is possibility to play:
* user vs user
* user vs AI ( easy / medium / hard ) 
* AI vs AI

#### User
User uses rotated two-dimensional array with coordinates ( 1 - 3 ) - request of the task.
```
(1 3) (2 3) (3 3)
(1 2) (2 2) (3 2)
(1 1) (2 1) (3 1)
```
It needs to type (x y) coordinates for each move:
```
---------
|       |
|       |
|       |
---------
Enter the coordinates: 2 3
---------
|   X   |
|       |
|       |
---------
```
#### Easy
Easy AI level does random moves if field of the board is empty.

#### Medium
Medium AI level logic:
1. Check can you win.
2. Check can your opponent win. Block its move.
3. If not 1. and not 2. then do a random move.
#### Hard
Hard AI level uses "minimax" algorithm. It simulates all possibilities until 
game finish. Then it checks best possible movement. 
There is no possibility to win with minimax algorithm. 
Can be only the draw or lose..

#### Example game:

To run the game type: *start player1 player2*



```
Input command: 
start easy hard 
---------
|       |
|       |
|       |
---------
Making move level "easy"
---------
|       |
|       |
|   X   |
---------
Making move level "hard"
---------
|       |
|       |
|   X O |
---------
.
.
. skipped part 
.
.
Making move level "medium"
---------
|   O X |
| X O O |
| O X X |
---------
Making move level "hard"
---------
| X O X |
| X O O |
| O X X |
---------
Draw
Input command: 
exit
```
