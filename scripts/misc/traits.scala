class ImportantService(name: String) {
	def work(i: Int): Int = {
		println(s"Doing important work $i")
		i + 1
	}
}

trait Logging {
	def info(message: String)
	def warning(message: String)
	def error(message: String)
}

trait StdoutLogging extends Logging {
	def info(message: String) = println(s"INFO $message")
	def warning(message: String) = println(s"WARN $message")
	def error(message: String) = println(s"ERROR $message")
}

val service2 = new ImportantService("two") with StdoutLogging { //Mixing
	override def work(i: Int): Int = {
		info(s"Starting work: i = $i")
		val result = super.work(i)
		info(s"Ending work: i = $i")
		result
	}
}

(1 to 3) foreach(i=> println(s"Result: ${service2.work(i)}"))
