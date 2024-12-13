# Dynamic Subarray Sum Target with Variable Constraints
**University of Prishtina**  
**Faculty of Electrical and Computer Engineering**  

This project is for the **Design and Analysis of Algorithms** course in **Computer and Software Engineering**.

## Introduction

The **Dynamic Subarray Sum Target with Variable Constraints** problem involves finding subarrays within an input array that meet specific target sum, length, and element value constraints. This project implements a solution using the sliding window algorithm, offering an efficient O(n) time complexity.

### Usage of Sliding Window

The sliding window technique is used to optimize the search process. It maintains a window of elements within the array and iteratively adjusts its size and position to identify potential subarrays.

### Key Constraints 
- **Target Sum:** The subarray's elements must sum up to the specified target value.
- **Minimum and Maximum Length:** The subarray's length must be within the defined minimum and maximum limits.
- **Element Value Range:** Individual elements within the subarray should be within a specified minimum and maximum value range.

## Implementation

### 1. Initialization
Initialize variables to track the current sum, window size, start and end indices, and an array to store the results.

### 2. Sliding Window Iteration

1. **Expand the Window:** If the current sum is less than the target and the window size is below the maximum, add elements from the right end of the array to the window.
2. **Shrink the Window:** If the current sum exceeds the target or the window size exceeds the maximum, remove elements from the left end of the array.
3. **Check for Target Sum:** If the current sum matches the target and the window size meets the constraints, add the subarray to the result list.  
    - **Base Case:** Continue shrinking the window until it reaches the minimum allowed size for the subarray.

### 3. Handle Edge Cases
- Consider cases where the target sum is negative.
- Handle arrays containing negative or zero elements.

## Demo

First, the array is initialized, and the following constraints are provided:
target, which is the value that needs to be achieved;
min, which is the minimum size of the window; max, which is the maximum size the window can have; minValue, which is the minimum value that can be part of the window; and maxValue, which is the maximum value that can be part of the window. 
![image](https://github.com/user-attachments/assets/dd756861-d70a-49ae-a5d3-ca3800cc9ab8)
First, we start adding values to the window until we reach the minimum required size so that the array is valid. In this case, it’s only 1, but it can be more.
After adding the minimum number of values needed, we check if the sum is equal to the target. It’s not. 
![image](https://github.com/user-attachments/assets/4b632695-fb72-493d-a3b5-6fe0ba2ac6a4)
We add another value and check if the sum is equal to the target. It's not. 
![image](https://github.com/user-attachments/assets/f3fae797-945a-44ab-ba2b-45b29c81632b)
We add another value and check if the sum is equal to the target. In this case, it exceeds the target.
![image](https://github.com/user-attachments/assets/86582ae0-ade3-4eba-9632-af63a4f75de0)
We need to remove a value. In the sliding window, we remove the value from the beginning. We then check if the sum is equal to the target. If it is, we add the first index, the last index, and all the values within the subarray. Additionally, we made a change to ensure that we can capture all subarrays, including those that contain 0 values or others that don’t affect the window.
![image](https://github.com/user-attachments/assets/aec69df9-059b-4cf6-ae1a-61ddb8e80c22)
Now, we add another value to continue the array and check if it equals the target. In this case, it exceeds the target. 
![image](https://github.com/user-attachments/assets/3e26d47c-7a93-4e84-a727-4f6744265106)
We remove the value from the beginning and check if the sum equals the target. In this case, it exceeds the target. 
![image](https://github.com/user-attachments/assets/de2450c2-1400-42be-a2eb-77f60bd9bd13)
We remove a value, and now we have reached the base case, which is the minimum size of the window. We check if the sum equals the target, but it is less. 
![image](https://github.com/user-attachments/assets/1cadce96-8a9f-4b81-9d8d-d4994d1eba9e)
We add another value and check if it equals the target sum. In this case, it exceeds the target. 
![image](https://github.com/user-attachments/assets/3abc87a5-c2e3-4ccf-bed6-d8a6160d6a8c)
We remove a value from the beginning and check if the sum equals the target. If it does, we add the indices and the values. Additionally, we have reached arr.length - min. We do this to determine when we have reached the position where the subarray can still be valid. 
![image](https://github.com/user-attachments/assets/cf9714f7-b74f-4d2b-99c3-5bb08ffe6042)




## Usage


To use this solution, clone the repository and run the implementation on your input array, specifying the target sum, minimum and maximum length, and element value range.

```bash
git clone https://github.com/AlbinArifaj/Dynamic-Subarray-Sum-Target-with-Variable-Constraints
cd src
# Run the program
javac Main.java
```

## Contributors
Adea Gerguri
Albin Arifaj
Bleron Mujaj
Ermira Gashi
Urtina Deskaj

