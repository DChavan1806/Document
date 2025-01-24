- **GEEKSFORGEEKS**

1. Initialize an empty hash map (or dictionary) to store the frequency of each character.
2. Traverse the string and update the frequency of each character in the hash map.
3. Traverse the string again and keep track of how many non-repeated characters (characters with a frequency of 1) have been encountered.
4. When the second non-repeated character is found, return it.


    function findSecondNonRepeatedChar(string):
    # Step 1: Initialize a frequency map
    freq_map = empty hash map     
    # Step 2: Traverse the string and update the frequency map
    for each char in string:
        if char exists in freq_map:
            freq_map[char] = freq_map[char] + 1
        else:
            freq_map[char] = 1
    
    # Step 3: Traverse the string again and find the second non-repeated character
    count = 0  # To keep track of how many non-repeated characters have been found
    for each char in string:
        if freq_map[char] == 1:
            count = count + 1
            if count == 2:
                return char  # Return the second non-repeated character
    
    # Step 4: If no second non-repeated character exists, return null
    return null

- [SecondNonRepeatedChar.java](../../topic/SecondNonRepeatedChar.java)
            