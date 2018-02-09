package main.scala

import scalation.columnar_db
import scalation.random
import scalation.stat._
import scalation.analytics.Regression
import scalation.columnar_db.Relation._
import scalation.linalgebra.{MatrixD, VectoD, VectorD}
import scalation.math.double_exp
import scalation.plot.Plot
import scalation.util.Error
import scalation.stat

object main {
  def main(args: Array[String]): Unit = {
    println("DATA SCIENCE PROJECT ! \n")

    println("+=============== load data ===================")
    val data = MatrixD("dataset-p1.csv",1)

    val x = data.sliceCol(0,15)
    println("Dimensions of data :: rows "+x.dim1+"cols"+x.dim2)

    //should add column 1 in the begining!!
    println("+=============== augment with 1 vector :: data ===================")

    val x1 = x.+^:(VectorD.one(x.dim1))

    val y : VectorD = data.col(15)
    println("X1 dimensions :: " + x1.dim1 + " x "+ x1.dim2)
    println("y dimensions = " + y.dim)

    println("+=============== Train using regression ===================")
    val rg = new Regression (x1, y)
    rg.train()
    println("\n===============  REPORT ==============\n")

    rg.report()
    println("\n=============== VIF  ==============\n")

    println ("vif      = " + rg.vif)

    // Transformed matrix
    println("=============== Transforming original matrix :: [X,x4square] ===================")

    val x4sq: VectorD = x1.col(4  ).map(Math.pow(_,2))
    println("x4sq dimentions = "+x4sq.dim)

    val data_transformed = x1.:^+(x4sq)
    println("X1 dimensions "+ data_transformed.dim1 + " x "+ data_transformed.dim2)

    println("+=============== Train using regression transformed data ===================")
    val rg_trans = new Regression(data_transformed.selectCols(Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16)),y)
    rg_trans.train()
    rg_trans.report()

    println("=============== Removed features from original data matrix ===================")

    val revised_model = new Regression(x1.selectCols(Array(0,1,2,4,5,7,8,9,10,14)),y)
    revised_model.train()
    revised_model.report()



  }
}