### A data-structure is a way to store and organize data in order to facilitate access and modifications

* In computer science data is an information that is stored or processed by a computer
* A collection with a defined way of accessing and storing items

#### Programming languages have created conventions on how these pieces of data can be described and manipulated in code.

#### What is data type?
An attribute of data that describes the values it can have and how the data can be used

---

#### Numerical Data Type

* Whole numbers
    * Int
    * Long
    * Short
* Decimal numbers
    * Float
    * Double

The difference between each of these data types is the range of numerical values that the data type can store

---

#### Boolean Data Type

* True
* False

#### Character Data Type

* Letters are stored in character data type such are: 'A', 'B', 'C', etc...

#### String Data Type

* Is composed of a sequenced of characters, such are "Hello World", etc...

#### Primitive Data Types

* Int
* Long
* Short
* Float
* Double
* Boolean
* Char

These can also be called basic or value types because these are types that have a fixed size that do not depend on the data inside of them.
However, there are data types that can be built out of other data types.  

### Different data structures are not only designed to organize and store data to suit a specific purpose, but also give a way to access and work with that data in an efficient manner.

We use a reference to find where the data lives in memory we call strings and other data types implemented with data structures reference types.

Primitive Data Types | Referenced Data Types
---------------------| ---------------------
VariableName -> Data | VariableName -> memoryAddress -> Data
---------------------| ---------------------
int                  | string
boolean              | Data structures
character            |
float                |
double               |
short                |
long                 |

#### Array (container that holds data) is collection of elements, where each item is identified by an index or a key
#### Multidimensional is an array of arrays
#### Jagged array has different size of arrays, meaning that the number of columns is not fixed.

#### Linear search is a linear time algorithm, meaning that the time it takes for the algorithm to run increases the size of the input.

#### Sorting, like searching is computationally expensive, because you have to do a lot of comparisons and checks. How many comparisons you do depends on which sorting algorithm you use and how much information you have about your data.

#### Different operations like inserting, accessing and searching on different data structures take different amounts of computational time. To be able to compare these operations on various data structures independently of input, we use something called Big O Notation. Big O Notation is used to describe the performance or complexity of an algorithm.

As long as we know the item's index, accessing it within the array takes what we call O of 1 time or constant time (O (1)).

#### A Stack is an ordered series of objects just like a list, but its intended use is a slightly different. We push objects onto the Stack and pop objects off of it. Stacks follow a Last In, First Out (LIFO) policy.

#### Like a Stacks and Lists, Queues represent a series of ordered objects, but the way we access, add and remove items is a slightly different. It is designed to have elements inserted at the end of the Queue and elements removed from the beginning of the Queue. The Queue follows a First in, First Our (FIFO) policy.

* Enqueue is when an item is added to a list
* Dequeue is when an item is removed from a list


---

# Arrays

* An array is one contagious block in memory that can't be resized
* Every element of an array occupies the same amount of space in memory
  * If array holds primitive data type, the primitive data types size is fixed (e.g int is 4 byte)
  * If array holds objects, then array actually holds object references that are all the same size no matter of object
* If an array starts at memory address X, and the size of each element is Y, we can calculate i-th element memory location simply by X + i * Y
, that's why finding element of array by index is O(1) constant time complexity.

Operation                                             | Time complexity (Big O notation)
------------------------------------------------------|---------------------------------
Retrieve with index                                   | O(1), O of 1, constant time
Retrieve without index                                | O(n), O of n, linear time
Add an element to a full array                        | O(n), O of n, linear time
Add an element to a not full array that has space     | O(1), O of 1, constant time
Insert or update an element at a specific index       | O(1), O of 1, constant time
Delete an element by index setting it to null         | O(1), O of 1, constant time
Delete an element by shifting elements                | O(n), O of n, linear time
