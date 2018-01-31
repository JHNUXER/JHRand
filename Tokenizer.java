public class Tokenizer {
  private static String trimBoth(String s) {
    return s.substring(1,s.length-2);
  }
  
  public Token[] tokenize(String string) {
    char[] chars = string.toCharArray();
    String tok = "";
    ArrayList<Token> tokens = new ArrayList<Token>();
    int state = 0;
    for (char c : chars) {
      tok += c;
      if (state == 0) {
        if (tok.startsWith('<') && tok.endsWith('>')) {
          tokens.add(new TagReference(tok.substring(1,tok.length-2)));
          tok = "";
        } else if (tok.startsWith('{') && tok.endsWith('}')) {
          String s0 = trimBoth(tok);
          String[] strings = s0.split(";");
          String[] strings2 = strings[0].split(",");
          String d = "";
          if (strings.length > 1) d = strings[1];
          tokens.add(new ConditionalString(strings2,d));
        } else if (tok.startsWith('@') && tok.endsWith('@')) {
          tokens.add(new VariableReference(trimBoth(tok)));
        } else if (tok == " ") {
          continue;
        } else {
          tokens.add(new Token(s));
        }
      }
    }
  }
}
