# AlgoDs
Algorithms and data structures programs practiced by me

DP:
https://www.geeksforgeeks.org/top-20-dynamic-programming-interview-questions/

Notes:
-----
Bitwise operations:
------------------
& => both true
| => either or both true
~ => negation
^ => either true
<< => yields double [x << y is x*2^y  ex1: 6<<1 is 6*2  ex2: 6<<3 is 6*2 pow(3)]
>> => yields half [x >> y is x/2^y  ex1: 6>>1 is 6/2^1]

int a = -1020;
a = a >> 1; // division
System.out.println(a);
// Prints -510. Great!
int b = -1021;
b = b >> 1;
System.out.println(b);
// Prints -511. Ugghh.

The solution is to add 1 before doing the bit-shift on a negative number. This way, it'll be "correct" regardless of whether the number was odd or even.

int a = -1020;
a = (a + 1) >> 1;
System.out.println(a);
// Prints -510. Great!
int b = -1021;
b = (b + 1) >> 1;
System.out.println(b);
// Prints -510. Yay!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
tricks:-
1. if num is even
    if x & 1 == 0 then x is even
   
2. to uppercase/lowercase
    xor with 32 (c ^ 32)
   
3. Find the element in an array that is not repeated.
    do xor of all elements in array
   
4. Get First Set Bit
   we first check if the rightmost significant bit is the set bet using bit & 1. 
   If not, we keep shifting left and checking until we find the bit that makes our AND operation yield 1

How to represent -ve number?
~~~~~~~~~~~~~~~~~~~~~~~~~~~
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

````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
Bit masking:-
Masking means to keep/change/remove a desired part of information. 
