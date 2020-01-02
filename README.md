# AlgoDs
Algorithms and data structures programs practiced by me

DP:
https://www.geeksforgeeks.org/top-20-dynamic-programming-interview-questions/

Notes:
-----
Bitwise operations:
------------------
How to represent -ve number?

Typically -ve integer gets stored in 2's compliment form. That means very first bit is used to represent the sign.
0 means +ve and 1 means -ve.
remaining bits filled with 2's compliment

Ex: 18 and -18

18 -> 0010010

find ~ of the number

  1101101

add +1 for the outcome

  1101110

add 1 to the most significant position

so -18 => 11101110
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

left and right shit:

+ve number right shift -> add 0 to the left most and remove right most bit

-ve number left shift ->  add 1 to the left most and remove right most bit

left shift has effect of multipying number by 2 and right shift of dividing number by 2 with some truncation
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


x >>= 1 nothing but x = x/2;
x <<= 1 nothing but x = x*2;


````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
Bit masking:-

