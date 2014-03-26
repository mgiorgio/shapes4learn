Shapes4Learn
============

Shapes4Learn is an educational tool for students to practice formal language processing. It is a framework with an interpreter that receives commands as text and allows to create and manipulate shapes.

It may be used as an introduction to Compilers since it can covers most of the phases: lexical, syntactical and semantic analysis, code optimization and translation. The only and main difference is that, instead of generating machine code, it will interact with the shapes engine.

This framework is used for the Languages Processing course in Universidad Maimónides in Buenos Aires, Argentina.

## Available commands

##### Create a shape in the Shape Ambient. The new shape will have the provided id:
create shape|rectangle|circle [id];

##### Set the color to an already existing shape in the Shape Ambient. The shape must already exist:
setcolor [color_def] in shape [id];

##### Set the given base on the rectangle defined by the provided id:
setbase [expression] in rectangle [id];

##### Set the given height on the rectangle defined by the provided id:
setheight [expression] in rectangle [id];

##### Set the given radius on the circle defined by the provided id:
setradius [expression] in circle [id];

## Defined Grammar (Incomplete)

##### A single letter in ascii alphabet.
[letter] := a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z|A|B|C|D|E|F|G|H|I|J|K|L|O|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z
##### An identifier for the source code.
[id] := [letter][id]|[letter]
##### A single digit.
[digit] := 1|2|3|4|5|6|7|8|9|0
##### A single hexadecimal digit.
[hexdigit] := [digit]|a|b|c|d|e|f|A|B|C|D|E|F
##### A color definition in RGB from #000000 to #ffffff
[color_def] := #[hexdigit][hexdigit][hexdigit][hexdigit][hexdigit][hexdigit]
##### A number composed by a concatenation of one or more single digits.
[number] := [digit][number]|[digit]

## Grammars to be defined by students

##### A mathematical expression that supports numbers, addition, subtraction, multiplication, division and parenthesis. For example: 9+(4*(5-7)+8/2)
[expression] :=
