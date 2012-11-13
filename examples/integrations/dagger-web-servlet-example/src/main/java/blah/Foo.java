package blah;
import javax.inject.Inject;


public class Foo {

  @Inject Foo() {}

  public String bar() {
    return "Foo's Bar method was invoked!";
  }

}
