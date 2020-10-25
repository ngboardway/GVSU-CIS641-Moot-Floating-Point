public class ScoreParser {
  public static void parseScores(String data) {
    String[] scores = data.split("\\n");
    for (String score : scores) {
      System.out.println(score);
    }
  }
}
