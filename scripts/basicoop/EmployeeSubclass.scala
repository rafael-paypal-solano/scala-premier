/*
The primary constructor in a derived class must invoke one of the parent class con‐
structors, either the primary constructor or an auxiliary constructor. In the following
example, Employee is a subclass of Person :
*/

case class Address(val street: String, val city: String, val state: String, val  zip: String) {
    override def toString = s"Address($street. $city, $state. $zip)" 
}

class Person(val name: String, val age: Option[Int] = None, val address: Option[Address] = None) {
    override def toString = s"Person($name, $age, $address)" 
}

class EmployeeByComposition (
    val person: Person,
    val title: String = "[unknown]",
    val manager:  Option[EmployeeByComposition] = None) {
    override def toString = s"EmployeeByComposition($person, $title, $manager)"
}

class EmployeeByInheritance(
    override val name: String,
    override val age: Option[Int] = None,
    override val address: Option[Address] = None,
    val title: String = "[unknown]",
    val manager: Option[EmployeeByInheritance] = None) extends Person(name, age, address) {
    
    override def toString = s"Employee($name, $age, $address, $title, $manager)"    
}

val manager = new EmployeeByComposition(
    new Person( 
        "Rafael R Solano",
        Some(12),
        Some(Address("1 Scala Lane", "Anytown", "CA", "98765"))
    ),
    "The Boss"
)

val manager2 = new EmployeeByInheritance(
    "Rafael R Solano",
    Some(12),
    Some(Address("1 Scala Lane", "Anytown", "CA", "98765")),
    "The Boss"
)


println(manager)
println(manager2)

/*
When inheritance is used, the following rules are recommended:
1. An abstract base class or trait is subclassed one level by concrete classes, including case classes.
2. Concrete classes are never subclassed, except for two cases:
    a. Classes that mix in other behaviors defined in trait s (see Chapter 9). Ideally, those behaviors should be orthogonal, i.e., not overlapping.
    b. Test-only versions to promote automated unit testing.
3. When subclassing seems like the right approach, consider partitioning behaviors into traits and mix in those traits instead.
4. Never split logical state across parent-child type boundaries.
*/