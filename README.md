![alt text](https://camo.githubusercontent.com/f662676a12bcdaf76cc6b8f49f90431acc40446b/68747470733a2f2f737461746963312e73717561726573706163652e636f6d2f7374617469632f3562393233303030636566333732653561356362353233662f742f3562393235313164346165323337653863643662316535652f313533363432323936323637352f3f666f726d61743d3135303077)

## daytoday-android
The daytoday patient and caregiver Android application.

### Kotlin Standars

**run** and **let** are transformation functions. They take the value of the object they are called against, and return a new value.

The most visible difference between these function are the variables they expose to their block functions.

The run function exposes the value of the object that it was called from as this inside the block.
```
@Test
fun runExample () {
    val result = "Local String".run {
        System.out.println(this) 
        "New String"
    }
    System.out.println(result) 
}
```

The **let** function exposes the value of the object that it was called from as it inside the block, while this is retained from the outer scope.
```
@Test
fun letExample () {
    val result = "Local String".let {
        System.out.println(this.name) 
        System.out.println(it) 
        "New String"
    }
    System.out.println(result) 
}
```

You can rename the default it parameter. You may do this to avoid clashing the default it parameter with an existing variable in the scope (which will happen if you nest two let functions).

```
@Test
fun letExample2 () {
    val result = "Local String".let {me ->
        System.out.println(this.name) 
        System.out.println(me) 
        "New String"
    }
    System.out.println(result) 
}
```

**also vs. apply**
also and apply are typically used when the value of the object they are called against needs to be used for some mutating operation. Any return value from the also and apply blocks is ignored, and the value of the original object is returned.

In this way, we can make use of the original value to perform some mutating logic (whose return value is not consumed by our own code), while retaining the original value.

Like the run function, apply exposes the value of the object it is called against as this.

```
@Test
fun applyExample() {
    val result = "Local String".apply {
        System.out.println(this) 
        "New String" 
    }
    System.out.println(result) 
}
```

Like the let function, also exposes the object that it was called from as it inside the block, while this is retained from the outer scope.

```
@Test
fun alsoExample() {
    val result = "Local String".also {
        System.out.println(this.name) 
        System.out.println(it) 
        "New String" 
    }
    System.out.println(result) 
}
```

And it can be renamed.
```
@Test
fun alsoExample2() {
    val result = "Local String".also { me ->
        System.out.println(this.name) 
        System.out.println(me) 
        "New String" 
    }
    System.out.println(result) 
}
```

Implementing Retrofit in kotlin. 
