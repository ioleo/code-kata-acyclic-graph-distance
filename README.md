# code-kata-acyclic-graph-distance

You are given an array representing M cities connected with M-1 roads. 
Compute the amount of cities reachable in 1 to M-1 steps from specified start point (the capital city).

```
val input: Array[Int] = Array(9, 1, 4, 9, 0, 4, 8, 9, 0, 1)
```

Which represents following information:

* City #0 has direct road to city #9
* City #1 has direct road with itself (special case -> this is the capital city)
* City #2 has direct road to city #4
* City #3 has direct road to city #9
* ...
* City #8 has direct road to city #0
* City #9 has direct road to city #1

```
val expectedOutput: Array[Int] = Array(1, 3, 2, 3, 0, 0, 0, 0, 0)
```

Which represents following information:

* There are 1 cities at reachable in 1 steps
* There are 3 cities at reachable in 2 steps
* There are 2 cities at reachable in 3 steps
* There are 3 cities at reachable in 4 steps
* ...
* There are 0 cities at reachable in 8 steps
* There are 0 cities at reachable in 9 steps
