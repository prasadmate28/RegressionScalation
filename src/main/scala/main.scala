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
    //val col_index = Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14)
    println("+=============== load data ===================")
    val data = MatrixD("dataset-p1.csv",1)
    //val x = data.selectCols(Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14))

    val x = data.sliceCol(0,15)
    println("rows "+x.dim1+"cols"+x.dim2)
    //should add column 1 in the begining!!
    println("+=============== augment 1 vector :: data ===================")

    val x1 = x.+^:(VectorD.one(x.dim1))

    val y : VectorD = data.col(15)
    println("X1 dimensions "+ x1.dim1 + " "+ x1.dim2)
    println("y dimentions = "+y.dim)
    println("+=============== Train using regression ===================")

    val rg = new Regression (x1, y)
    rg.train()
    println("========REPORT==============")

    rg.report()
    //println ("vif      = " + rg.vif)

    // Transformed matrix
    println("=============== Transforming original matrix ===================")

    val x4sq: VectorD = x1.col(3).map(Math.pow(_,2))
    println("x4sq dimentions = "+x4sq.dim)

    val data_transformed = data+:x4sq
    println("X1 dimensions "+ data_transformed.dim1 + " "+ data_transformed.dim2)
    //print("data_transformed \n"+data_transformed)
    //val rg_trans = new Regression(data.selectCols(Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)),y)
    //rg_trans.train()

  }
}