import os
import re

# Extended Master Mapping for Easy & Medium Stragglers
master_mapping = {
    # --- Previous Fixes ---
    "0002rangesumquerydimmutable": (304, "Range Sum Query 2D - Immutable"),
    "00153sum": (15, "3Sum"),
    "0107binarytreelevelordertraversal2": (107, "Binary Tree Level Order Traversal II"),
    "0274hindex": (274, "H-Index"),
    "0435nonoverlappingintervals": (435, "Non-overlapping Intervals"),
    "1011capacitytoshippackageswithinddays": (1011, "Capacity To Ship Packages Within D Days"),
    "0424longestrepeatingcharacterreplacement": (424, "Longest Repeating Character Replacement"),
    
    # --- The Easy Folder Stragglers ---
    "0001convertdarrayinto2darray": (2022, "Convert 1D Array Into 2D Array"),
    "0001numberofbits": (191, "Number of 1 Bits"),
    "addbinary": (67, "Add Binary"),
    "arrangingcoins": (441, "Arranging Coins"),
    "backspacestringcompare": (844, "Backspace String Compare"),
    "balancedbinarytree": (110, "Balanced Binary Tree"),
    "besttimetobuyandsellstock": (121, "Best Time to Buy and Sell Stock"),
    "binarynumberwithalternatingbits": (693, "Binary Number with Alternating Bits"),
    "calculatemoneyinleetcodebank": (1716, "Calculate Money in Leetcode Bank"),
    "concatenationofarray": (1929, "Concatenation of Array"),
    "containsduplicateii": (219, "Contains Duplicate II"),
    "countelementswithmaximumfrequency": (3005, "Count Elements With Maximum Frequency"),
    "countoddnumbersinanintervalrange": (1523, "Count Odd Numbers in an Interval Range"),
    "faultykeyboard": (2810, "Faulty Keyboard"),
    "fibonaccinumber": (509, "Fibonacci Number"),
    "findallnumbersdisappearedinanarray": (448, "Find All Numbers Disappeared in an Array"),
    "findgreatestcommondivisorofarray": (1979, "Find Greatest Common Divisor of Array"),
    "findnuniqueintegerssumuptozero": (1304, "Find N Unique Integers Sum up to Zero"),
    "firstbadversion": (278, "First Bad Version"),
    "firstuniquecharacterstring": (387, "First Unique Character in a String"),
    "gcdofoddandevensums": (None, "GCD of Odd and Even Sums"), # Unnumbered or Non-LC standard
    "guessnumberhigherorlower": (374, "Guess Number Higher or Lower"),
    "happynumber": (202, "Happy Number"),
    "howmanynumbersaresmallerthanthecurrentnumber": (1365, "How Many Numbers Are Smaller Than the Current Number"),
    "implementqueueusingstacks": (232, "Implement Queue using Stacks"),
    "implementstackusingqueues": (225, "Implement Stack using Queues"),
    "intersectionoftwolinkedlists": (160, "Intersection of Two Linked Lists"),
    "kthlargestelementinastream": (703, "Kth Largest Element in a Stream"),
    "laststoneweight": (1046, "Last Stone Weight"),
    "linkedlistcycle": (141, "Linked List Cycle"),
    "longestcommonprefix": (14, "Longest Common Prefix"),
    "longestpalindrome": (409, "Longest Palindrome"),
    "majorityelement": (169, "Majority Element"),
    "maxconsecutiveones": (485, "Max Consecutive Ones"),
    "maximumdepthbinarytree": (104, "Maximum Depth of Binary Tree"),
    "maximumproductdifferencebetweentwopairs": (1913, "Maximum Product Difference Between Two Pairs"),
    "maximumsumofsubarraysofsizek": (None, "Maximum Sum of Subarrays of Size K"), # Unnumbered or Non-LC standard
    "mergesortedarray": (88, "Merge Sorted Array"),
    "mergetwosortedlists": (21, "Merge Two Sorted Lists"),
    "minimumoperationstoexceedthresholdvaluei": (3065, "Minimum Operations to Exceed Threshold Value I"),
    "missingnumber": (268, "Missing Number"),
    "mostfrequentevenelement": (2404, "Most Frequent Even Element"),
    "movezeroes": (283, "Move Zeroes"),
    "nextgreaterelementi": (496, "Next Greater Element I"),
    "numberofrecentcalls": (933, "Number of Recent Calls"),
    "palindromelinkedlist": (234, "Palindrome Linked List"),
    "palindromenumber": (9, "Palindrome Number"),
    "pascalstriangle": (118, "Pascal's Triangle"),
    "poweroffour": (342, "Power of Four"),
    "powerofthree": (326, "Power of Three"),
    "poweroftwo": (231, "Power of Two"),
    "rangesumqueryimmutable": (303, "Range Sum Query - Immutable"),
    "ransomnote": (383, "Ransom Note"),
    "removeduplicatesfromsortedarrayii": (80, "Remove Duplicates from Sorted Array II"),
    "removeduplicatesfromsortedarray": (26, "Remove Duplicates from Sorted Array"),
    "removeelement": (27, "Remove Element"),
    "removelinkedlistelements": (203, "Remove Linked List Elements"),
    "removenthnode": (19, "Remove Nth Node From End of List"),
    "reversebits": (190, "Reverse Bits"),
    "reverselinkedlist": (206, "Reverse Linked List"),
    "reversestringii": (541, "Reverse String II"),
    "reversestring": (344, "Reverse String"),
    "reversewordsinastringiii": (557, "Reverse Words in a String III"),
    "setmismatch": (645, "Set Mismatch"),
    "shufflethearray": (1470, "Shuffle the Array"),
    "singlenumber": (136, "Single Number"),
    "snakeinmatrix": (3248, "Snake in Matrix"),
    "sortarraybyparityii": (922, "Sort Array By Parity II"),
    "sortarraybyparity": (905, "Sort Array By Parity"),
    "sortevenandoddindicesindependently": (2164, "Sort Even and Odd Indices Independently"),
    "sqrtx": (69, "Sqrt(x)"),
    "squaresofasortedarray": (977, "Squares of a Sorted Array"),
    "symmetrictree": (101, "Symmetric Tree"),
    "twosum": (1, "Two Sum"),
    "validanagram": (242, "Valid Anagram"),
    "validpalindrome": (125, "Valid Palindrome"),
    "validparentheses": (20, "Valid Parentheses"),
    "validperfectsquare": (367, "Valid Perfect Square")
}

target_dir = "LeetCode_Problems/Java"
changes = 0

if os.path.exists(target_dir):
    for root, dirs, files in os.walk(target_dir):
        for filename in files:
            if not filename.endswith('.java'): 
                continue
            
            filepath = os.path.join(root, filename)
            base_name = filename[:-5]
            
            # Normalize the current filename to match our dictionary keys
            normalized = re.sub(r'[^a-z0-9]', '', base_name.lower())
            
            new_name = filename
            
            # 1. Override with the exact Master Mapping if it exists
            if normalized in master_mapping:
                prob_num, exact_title = master_mapping[normalized]
                if prob_num:
                    new_name = f"{str(prob_num).zfill(4)}. {exact_title}.java"
                else:
                    new_name = f"{exact_title}.java"
            
            # 2. Rename the file if the Master Mapping updated it
            if new_name != filename:
                new_filepath = os.path.join(root, new_name)
                print(f"RENAME: '{filename}' -> '{new_name}'")
                os.rename(filepath, new_filepath)
                changes += 1

print(f"Total files renamed: {changes}")
