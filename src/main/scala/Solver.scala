
case class Solver(input: Array[Int]) {

  // graph vertex is a city
  type City = Int

  // graph paths are roads
  case class Road(from: Int, to: Int) {
    // special case: starting vertex - capital city - is marked by a road to itself
    lazy val isCapital: Boolean = from == to
  }

  // mapping input to context class for easier reasoning
  lazy val roads = input.zipWithIndex.map { case (to, from) => Road(from, to) }

  // finding the capital city
  lazy val capitalCity: City = roads.filter(_.isCapital).head.from

  // given a set of cities in the vicinity N, find a set of cities in the vicinity N + 1
  def furtherNeighbours(cities: Seq[City]): Seq[City] = roads
    .filter(road => !road.isCapital && cities.contains(road.to))
    .map(road => road.from)

  // the maximum distance between start vertex and last vertex
  lazy val maxDistance = input.length - 1

  // solve the problem
  lazy val solution: Array[City] = {
    def findSolution(cities: Seq[City], solution: Array[City]): Array[City] = {
      if (solution.length == maxDistance)
        solution
      else {
        val nextCities = furtherNeighbours(cities)
        findSolution(nextCities, solution :+ nextCities.length)
      }
    }

    val startAt = Seq(capitalCity)
    val startWith = Array.empty[City]
    findSolution(startAt, startWith)
  }
}
