# Preparing the worldlist
Download the GNU dictionary https://gcide.gnu.org.ua/download
Unzip it to a folder.
Run the following command on it to gather all the words only, one per line, in a new file called combined.txt
grep -oh "<ent>.*</ent>" * > combined.txt && sed -i "s/<ent>//g" combined.txt  && sed -i "s/<\/ent>//g" combined.txt
This works because dictionary entries are within the <ent> blocks.
Change all words to uppercase, an easy way to do this is using Notepad++'s built in UPPERCASE function. This is because all characters are going to be uppercase in the game and bloom filter comparisons will be easy
There are numbers and some random words like aas at the beginning so get rid of those.
There are also words with spaces in them like "ACORN CUP" and hyphens like "ACORN-SHELL", try to get rid of these since they'll pointlessly take space in the database
They are going to be excluded by the nature of the game since hypens and spaces aren't going to be allowed in the game grid.

# Prepping the database against which words are compared.
A bloom filter will be made of the words, so it can have a small memory footprint.
This will be checked against for each completed word if it's present.