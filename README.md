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

## Usage

To use this solution, clone the repository and run the implementation on your input array, specifying the target sum, minimum and maximum length, and element value range.

```bash
git clone https://github.com/AlbinArifaj/Dynamic-Subarray-Sum-Target-with-Variable-Constraints
cd src
# Run the program
javac Main.java
