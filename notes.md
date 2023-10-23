IOC - inversion of control - we allow spring to manage several
parts of app for us, namely our BEANS

Dependency injection
- Constructor
  - Because the objects we'd like to inject are part of the constructor's definition, the required beans MUST be present.
  - We almost always want this behavior, so, constructor injection is the most common type and the one that is generally recommended to use.
  - In Spring, we actually don't even need Autowired on a constructor... spring assumes that's what we want to do in a bean.
- Setter
  - We can also inject by telling spring to run a Setter method on one of a bean's fields.
  - Unlike constructors, we actually don't need to guarantee we have the specific bean available.
- Field
  - Generally discouraged
  - It generates a Setter for injection at runtime.
  - Because we don't have access to the generated setter at compile time, using it in some instances is a bit trickier... like if we want to apply a mocked dependency in unit testing

Some companies are now even considering spring to be dated, and move beyond it... why? Spring is a pretty heavyweight framework. You basically can not get it running on lower than 1 gb of ram, and even that is kind of slow (for startup)

-xml config, where a bean definition contains the injected bean in its definition

-xml bean values

"What maven command is used to run a spring boot jar"

java -jar