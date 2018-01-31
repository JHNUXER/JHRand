public class FGen implements IGenerator {
  public HashMap<String,Token> tokens;

  public void loadFile(File file,boolean mainFile) {
    JSONObject json = (JSONObject) new JSONParser().parse(new FileReader(file));
    String[] keys = new ArrayList<String>(json.keySet()).toArray(new String[] {});
    for (String key : keys) {
      if (key.equals("FIRST") && mainFile) {
        
      } else {
        
      }
    }
  }
}
