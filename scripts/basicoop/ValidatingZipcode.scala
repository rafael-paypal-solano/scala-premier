case class ZipCode (zip: Int, extension: Option[Int] = None) {

    protected def valid(z:Int, e:Option[Int]): Boolean = {
        if(0 < z && z < 100000) e match {
            case None => validUSPS(z, 0)
            case Some(e) => 0 < e && e < 10000 && validUSPS(z, e)
        }
        else
            false
    }

    protected def validUSPS(i: Int, e:Int): Boolean = true

    override def toString = if (extension != None) s"$zip-${extension.get}" else zip.toString
}

