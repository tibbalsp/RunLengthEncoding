Author: Patrick Tibbals

A.
    Time Complexity:
        Encode() -> O(n)
        Decode() -> O(n)
        Equal() -> O(n)
B.
    Advantages:
        - Allows for compression of large data files if repeated elements are present
        - A simple algorithm to implement
        - Requires little CPU overhead to run
    Disadvantages:
        - Encoded data must be expanded before it can be evaluated properly
        - If the data doesn't contain repeating elements of 3 or more the compression can actually be longer
    Applications:
        - Bitmap images such as computer icons
        - Compress large text files with limited loss of data
        -
C.
	This assignment took me roughly 8 hours of coding time, the most time-consuming part of the assignment revolved
	around expanded my functionality to allow my RLE class to print to the same text document as the driver class.
	I got around the issue by creating a separate class responsible for printing to the text document and when I
	instantiate the RLE class I pass my Printer class through to the constructor. I found the methods for encode
	and decode relatively easy to implement, but I feel like I am missing a faster way of preforming the decode method.