# Binary-Search-Tree

#### Name: Arjun Kejriwal

As seen in the table and graph in the attached MS Excel file, the
size of the BST does have a positive effect on the height of the 
BST: as the size of the BST increases, the height of the BST increases
as well. However, the effect of the size on the height is more 
pronounced when the size is small and less pronounced when the size
is large. In other words, when a BST contains very few nodes, the
height of the BST increases very fast when nodes are added to the BST.
However, when a BST contains a lot more nodes, the height of the BST
increases slowly as more nodes are added to the BST. This is expected, 
since if a BST contains a lot of nodes, it will contain a lot of branches
as well. Thus, when more nodes are added, the nodes are distributed among
these several branches, which makes it tough for the height of the BST
to increase fast. 

As seen in the table and graph in the attached MS Excel file for
Question 2, the BinarySearchTree implementation of SimpleSSet is 
faster at reading distinct words from the "MobyDick" text than the 
ArraySimpleSSet implementation of SimpleSSet. This can be seen by
the fact that for every 5000 words read by each implementation,the
BinarySearchTree spends lesser time (less than half) than the 
ArraySimpleSSet to read those 5000 words. Since the difference in 
time is less than half, this difference in the speed of reading 
words is definitely significant. This difference is exactly how I 
expected it to be. Both implementations use binary search (with O(log
n) time) to find the position where a word should be added. However, 
the time taken adding the word to the set is lower for BinarySearchTree 
(O(1) time) than for ArraySimpleSSet (O(n) time). Thus, BinarySearchTree
takes lesser time than ArraySimpleSSet to read the distinct words in a 
text file. 
