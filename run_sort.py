import os
import re

# Master Mapping: Fixes all unnumbered files and anomalies perfectly.
# Keys are the filename stripped of all spaces, dots, and caps.
master_mapping = {
    # --- Fixes for artifacts from the last run ---
    "0002rangesumquerydimmutable": (304, "Range Sum Query 2D - Immutable"),
    "00153sum": (15, "3Sum"),
    "0107binarytreelevelordertraversal2": (107, "Binary Tree Level Order Traversal II"),
    "0274hindex": (274, "H-Index"),
    "0435nonoverlappingintervals": (435, "Non-overlapping Intervals"),
    "1011capacitytoshippackageswithinddays": (1011, "Capacity To Ship Packages Within D Days"),
    "0424longestrepeatingcharacterreplacement": (424, "Longest Repeating Character Replacement"),
    
    # --- The Unnumbered Stragglers ---
    "dailytemperatures": (739, "Daily Temperatures"),
    "deletenodeinalinkedlist": (237, "Delete Node in a Linked List"),
    "designbrowserhistory": (1472, "Design Browser History"),
    "designcirculardeque": (641, "Design Circular Deque"),
    "equalsumarrayswithminimumnumberofoperations": (1775, "Equal Sum Arrays With Minimum Number of Operations"),
    "evaluatereversepolishnotation": (150, "Evaluate Reverse Polish Notation"),
    "findminimuminrotatedsortedarray": (153, "Find Minimum in Rotated Sorted Array"),
    "findtheduplicatenumber": (287, "Find the Duplicate Number"),
    "generateparentheses": (22, "Generate Parentheses"),
    "groupanagrams": (49, "Group Anagrams"),
    "incrementsubmatricesbyone": (2536, "Increment Submatrices by One"),
    "intersectionoftwoarraysii": (350, "Intersection of Two Arrays II"),
    "linkedlistcycleii": (142, "Linked List Cycle II"),
    "longestconsecutivesequence": (128, "Longest Consecutive Sequence"),
    "longestcontinuoussubarraywithabsolutedifflessthanorequaltolimit": (1438, "Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit"),
    "majorityelementii": (229, "Majority Element II"),
    "minstack": (155, "Min Stack"),
    "nextgreaterelementii": (503, "Next Greater Element II"),
    "onlinestockspan": (901, "Online Stock Span"),
    "partitionarrayaccordingtogivenpivot": (2161, "Partition Array According to Given Pivot"),
    "partitiontokequalsumsubsets": (698, "Partition to K Equal Sum Subsets"),
    "permutations": (46, "Permutations"),
    "powxn": (50, "Pow(x, n)"),
    "rangeaddition": (370, "Range Addition"),
    "reverselinkedlistii": (92, "Reverse Linked List II"),
    "rotatearray": (189, "Rotate Array"),
    "sortcolors": (75, "Sort Colors"),
    "spiralmatrix": (54, "Spiral Matrix"),
    "stringcompression": (443, "String Compression"),
    "subarraysumequalsk": (560, "Subarray Sum Equals K"),
    "swapnodesinpairs": (24, "Swap Nodes in Pairs"),
    "topkfrequentwords": (692, "Top K Frequent Words"),
    "topkfrequentelements": (347, "Top K Frequent Elements"),
    "twosumiiinputarrayissorted": (167, "Two Sum II - Input Array Is Sorted")
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
                new_name = f"{str(prob_num).zfill(4)}. {exact_title}.java"
            
            # 2. Rename the file if the Master Mapping updated it
            if new_name != filename:
                new_filepath = os.path.join(root, new_name)
                print(f"RENAME: '{filename}' -> '{new_name}'")
                os.rename(filepath, new_filepath)
                changes += 1

print(f"Total files renamed: {changes}")
