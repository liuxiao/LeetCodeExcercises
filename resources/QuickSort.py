Last login: Fri Jul 14 14:56:58 on ttys002
MacBook-Air-de-Xiao:~ xiao$ 
  [Restored Jul 25, 2017, 11:43:30]
Last login: Mon Jul 24 21:19:18 on console
MacBook-Air-de-Xiao:~ xiao$ cd /tmp
MacBook-Air-de-Xiao:tmp xiao$ vi test.py
MacBook-Air-de-Xiao:tmp xiao$ 
MacBook-Air-de-Xiao:tmp xiao$ cp /Users/xiao/Documents/workspace/LeetCode/resources/quicksort.txt .
MacBook-Air-de-Xiao:tmp xiao$ vi test.py 
MacBook-Air-de-Xiao:tmp xiao$ mv quicksort.txt IntegerArray.txt
MacBook-Air-de-Xiao:tmp xiao$ 
MacBook-Air-de-Xiao:tmp xiao$ 
MacBook-Air-de-Xiao:tmp xiao$ ./te
MacBook-Air-de-Xiao:tmp xiao$ chmod +x test.py 
MacBook-Air-de-Xiao:tmp xiao$ ./test.py 
-bash: ./test.py: usr/bin/env: bad interpreter: No such file or directory
MacBook-Air-de-Xiao:tmp xiao$ chmod +x test.py 
MacBook-Air-de-Xiao:tmp xiao$ vi test.py 
MacBook-Air-de-Xiao:tmp xiao$ 
MacBook-Air-de-Xiao:tmp xiao$ which python
/usr/bin/python
MacBook-Air-de-Xiao:tmp xiao$ vi test.py 
MacBook-Air-de-Xiao:tmp xiao$ ./test.py 
138382
MacBook-Air-de-Xiao:tmp xiao$ vi test.py 
MacBook-Air-de-Xiao:tmp xiao$ ./test.py 
162085
MacBook-Air-de-Xiao:tmp xiao$ vi test.py 
MacBook-Air-de-Xiao:tmp xiao$ ./test.py 
164123
MacBook-Air-de-Xiao:tmp xiao$ vi test.py 






















#!/usr/bin/python

"""
This is a program which implements the quicksort algorithm
in three different ways.  The first takes the pivot element
to always be the first element of the array, while the second
takes the pivot to always be the last element.  The third
way is to consider the first, last, and middle element of
the array and letting the pivot be the median of the three.
This saves time in arrays that are nearly sorted or nearly
reverse sorted.  This program also calculates the number of
comparisons quicksort uses while sorting.
"""

firstcomparison = 0
lastcomparison = 0
mediancomparison = 0

#A method for partition around the first element of the array
def partition_first(array, leftend, rightend):
    pivot = array[leftend]
    i = leftend + 1
    for j in range(leftend + 1, rightend):
        if array[j] < pivot:
            temp = array[j]
            array[j] = array[i]
            array[i] = temp
            i += 1

    leftendval = array[leftend]
    array[leftend] = array[i-1]
    array[i-1] = leftendval
    return i - 1

#A method for partitioning around the last element of the array
def partition_last(array, leftend, rightend):

    pivot = array[rightend-1]

    array[rightend-1] = array[leftend]
    array[leftend] = pivot

    i = leftend + 1
    for j in range(leftend + 1, rightend):
        if array[j] < pivot:
            temp = array[j]
            array[j] = array[i]
            array[i] = temp
            i += 1

    leftendval = array[leftend]
    array[leftend] = array[i-1]
"test.py" 160L, 4308C
