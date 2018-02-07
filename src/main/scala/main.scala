package main.scala

import scalation.columnar_db
import scalation.random
import scalation.stat._
import scalation.analytics.SimpleRegression
import scalation.columnar_db.Relation._
import scalation.linalgebra.{MatrixD, VectoD, VectorD}
import scalation.math.double_exp
import scalation.plot.Plot
import scalation.util.Error
import scalation.stat

object main {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    
//    val x = new MatrixD ((20, 5), 1.0,   47.0,   85.4,   5.1,    33.0,
//        1.0,   49.0,   94.2,   3.8,    14.0,
//        1.0,   49.0,   95.3,   8.2,    10.0,
//        1.0,   50.0,   94.7,   5.8,    99.0,
//        1.0,   51.0,   89.4,   7.0,    95.0,
//        1.0,   48.0,   99.5,   9.3,    10.0,
//        1.0,   49.0,   99.8,   2.5,    42.0,
//        1.0,   47.0,   90.9,   6.2,     8.0,
//        1.0,   49.0,   89.2,   7.1,    62.0,
//        1.0,   48.0,   92.7,   5.6,    35.0,
//        1.0,   47.0,   94.4,   5.3,    90.0,
//        1.0,   49.0,   94.1,   5.6,    21.0,
//        1.0,   50.0,   91.6,  10.2,    47.0,
//        1.0,   45.0,   87.1,   5.6,    80.0,
//        1.0,   52.0,  101.3,  10.0,    98.0,
//        1.0,   46.0,   94.5,   7.4,    95.0,
//        1.0,   46.0,   87.0,   3.6,    18.0,
//        1.0,   46.0,   94.5,   4.3,    12.0,
//        1.0,   48.0,   90.5,   9.0,    99.0,
//        1.0,   56.0,   95.7,   7.0,    99.0)
//    var cor = new MatrixD (5,5)
    
    
//      x(i) = exp.gen + exp.gen+ exp.gen
//    }
    
    val data =  MatrixD("/home/sahar/Downloads/dataset-p1.csv",1)
    val x = data.selectCols(Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14))
    //should add column 1 in the begining!!
//    val x1 = 1.0 + x.
//    println("x = "+x)
//    
    val y : VectorD = data.col(15)
    println("y = "+y)
    
    val rg = new SimpleRegression (x, y)
    rg.train ()

    println ("coefficient = " + rg.coefficient)
    println ("            = " + rg.fitLabels)
    println ("fit         = " + rg.fit)
    
    
//    var N = 10000
//    var exp = new scalation.random.Uniform()
//    val x = new VectorD(N)
//    
//    for(i<- 0 until N){
//      x(i) = exp.gen + exp.gen+ exp.gen
//    }
//    
//    val plot = new Histogram(x,40)
//      
//        print(exp.gen)
    
  }
}