Shapes4Learn
============

### What is it?

Shapes4Learn is an educational tool for students to practice formal language processing. It is a framework with an interpreter that receives commands as text and allows to create, delete and manipulate shapes.

### What is it for?

It may be used as an introduction to Compilers since it can cover most of the phases: lexical, syntactical and semantic analysis, code optimization and translation. The only and main difference is that, instead of generating machine code, it will interact with the shapes engine.

### Where is it used?

This framework is used for the Languages Processing course in Universidad Maimónides in Buenos Aires, Argentina.

### How does it work?

Shapes4Learn defines a formal language for shapes creation and manipulation. The framework's main components are:
* **Shapes:** Basic objects that can be created, deleted and manipulated in Shape4Learn. In the current version, the implemented shapes are _square_ and _circle_.
* **Shape Ambient:** This component is where shapes live and must keep track of them. Creation, deletion and manipulation actions are provided by this component. The core of Shapes4Learn provides a basic version called BasicShapeAmbient. It is available for users and it is widely used in the tests. 
* **Interpreter:** This is the most important component of the framework because is the one that students must implement. It can be as simple or complex as the developer wants. Shape4Learn packages a trivial **Interpreter** implemented using regular expressions that is used in the tests.
* **InterpreterTests:** A Test Suite that must be passed by any implemented **Interpreter**.

### Class diagram

![alt tag](https://raw.githubusercontent.com/mgiorgio/shapes4learn/master/doc/classdiagram.gif)

### Future steps

##### It is expected in the near future that Shapes4Learn will incorporate the next features:
* More commands in the language.
* More shapes: Triangle.
* More shapes attributes: movements and rotation.
* Better test coverage.

##### Longer term expected features:
* Control structures (loops).
* Relative attribute modifications ("increment position", "move right").

## Shapes4Learn Language Documentation

### About the tokens
In this language, tokens are mostly separated by whitespaces such as space, tab, CR or LF. The only exceptions are the numerical expressions and semi-colon. In the first case, whitespaces are not mandatory meaning that _4*(3+9)_ is valid but also _4 * (3+9 )_. For semi-colons, they can be placed together with the last token of a sentence or separated.

### Available commands

**Create a shape in the Shape Ambient. The new shape will have the provided id:**

create rectangle|circle [id];

**Set the color to an already existing shape in the Shape Ambient. The shape must already exist:**

setcolor [color_def] in shape [id];

**Set the given base on the rectangle defined by the provided id:**

setbase [expression] in rectangle [id];

**Set the given height on the rectangle defined by the provided id:**

setheight [expression] in rectangle [id];

**Set the given radius on the circle defined by the provided id:**

setradius [expression] in circle [id];

**Set the 2D-position (x,y) for the shape given by the id:**
setposition [expression],[expression] in shape [id];

### Defined Grammar (Incomplete)

**A single letter in ascii alphabet:**

[letter] := a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z|A|B|C|D|E|F|G|H|I|J|K|L|O|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z

**An identifier for the source code:**

[id] := [letter][id]|[letter]

**A single digit:**

[digit] := 1|2|3|4|5|6|7|8|9|0

**A single hexadecimal digit:**

[hexdigit] := [digit]|a|b|c|d|e|f|A|B|C|D|E|F

**A color definition in RGB from #000000 to #ffffff:**

[color_def] := #[hexdigit][hexdigit][hexdigit][hexdigit][hexdigit][hexdigit]

**A number composed by a concatenation of one or more single digits:**

[number] := [digit][number]|[digit]

**A mathematical expression that supports numbers, addition, subtraction, multiplication, division and parenthesis. For example:** 9+(4*(5-7)+8/2)

[expression] :=
