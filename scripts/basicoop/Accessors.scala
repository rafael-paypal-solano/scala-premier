// class Name(var value: String) is conceptually equivalent to

class Name(s: String) {
    private var _value : String = s

    def value: String = value

    def value_(newValue: String): Unit = _value = new Value
}