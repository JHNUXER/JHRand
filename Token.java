public class Token extends ArrayList<Token> {
  protected String value;
  protected FGen generator;

  public Token(String s) {
    this.value = s;
  }

  public String toString() {
    return value;
  }
}
public class ConditionalString extends Token {
  public HashMap<Condition,String> values = new HashMap<Condition,String>();
  public String default_;

  public String toString() {
    Condition[] keys = new ArrayList<Condition>(values.keySet()).toArray(new Condition[] {});
    for (Condition c : keys) {
      if (c.isTrue()) return values.get(c);
    }
    return default_;
  }
}
public class VariableReference extends Token {
  public String toString() {
    return this.generator.vars.get(this.value);
  }
}
public class TagReference extends Token {
  public String toString() {
    return this.generator.rands(this.value);
  }
}
