# CP-Question
# I am stuck at this Question, i have coded something but its not time efficient, any sort of help is appreciable.

Markov takes out his Snakes and Ladders game, stares at the board and wonders: "If I can always roll the die to whatever number I want, what would be the least number of rolls to reach the destination?"


Rules The game is played with a cubic die of 6 faces numbered 1 to 6.

1. Starting from square 1, land on square 100 with the exact roll of the die. If moving the number rolled would place the player beyond square 100 , no move is made.

2. If a player lands at the base of a ladder, the player must climb the ladder. Ladders go up only.

3. If a player lands at the mouth of a snake, the player must go down the snake and come out through the tail. Snakes go down only.

# Function Description :

Complete the quickestWayUp function in the editor below. It should return an integer that represents the minimum number of moves required.

quickestWayUp has the following parameter(s):

ladders: a 2D integer array where each ladders[i] contains the start and end cell numbers of a ladder
snakes: a 2D integer array where each snakes[i] contains the start and end cell numbers of a snake

# Input Format

The first line contains the number of tests, .

For each testcase:
- The first line contains , the number of ladders.
- Each of the next  lines contains two space-separated integers, the start and end of a ladder.
- The next line contains the integer , the number of snakes.
- Each of the next  lines contains two space-separated integers, the start and end of a snake.

# Sample Input

2
3
32 62
42 68
12 98
7
95 13
97 25
93 37
79 27
75 19
49 47
67 17
4
8 52
6 80
26 42
2 72
9
51 19
39 11
37 29
81 3
59 5
79 23
53 7
43 33
77 21 

# Sample Output

3
5

Just create a folder named #the_lang you are submiting and submit your ans
