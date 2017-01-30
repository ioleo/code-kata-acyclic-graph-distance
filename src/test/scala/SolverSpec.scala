import org.scalatest.{FlatSpec, Matchers}

class SolverSpec extends FlatSpec with Matchers { spec =>

  val input = Array(9, 1, 4, 9, 0, 4, 8, 9, 0, 1)
  val solver = Solver(input)

  it should "solve the problem" in {
    solver.solution shouldBe Array(1, 3, 2, 3, 0, 0, 0, 0, 0)
  }

  it should "find capital city" in {
    solver.capitalCity shouldBe 1
  }

  it should "find further neighbours" in {
    solver.furtherNeighbours(Seq(1)) shouldBe Seq(9)
    solver.furtherNeighbours(Seq(9)) shouldBe Seq(0, 3, 7)
    solver.furtherNeighbours(Seq(0, 3, 7)) shouldBe Seq(4, 8)
    solver.furtherNeighbours(Seq(4, 8)) shouldBe Seq(2, 5, 6)
    solver.furtherNeighbours(Seq(2, 5, 6)) shouldBe Seq()
  }

  it should "know the maximum distance" in {
    solver.maxDistance shouldBe 9
  }

}
