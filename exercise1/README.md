> What is the value of the variable result at the end of the program when the variable nums refers to the array [1, 2] accepted by the routine avg?

1.0, because method avg() operates with integers. The integer result 1 is cast into a float, so it becomes 1.0.

> What about when the array is empty? Why?

If the array is empty, an exception is thrown and nothing is assigned to result, and thus its value is undefined.
