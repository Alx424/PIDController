public class Main {
  private static PIDController pid;
  private static double current = 0;
  
  public static void main(String[] args) {
    pid = new PIDController(0.0, 100.0, 10.0, 0.0, 0.5, 0.01, 0.3, 10); // set weights, current position, and target
    pid.updateError(current);
    while(true) {
      current += periodic();
      System.out.println(current);
    }
  }
  public static double periodic() { // a function run periodically in FRC robot templates
    double ans = pid.getOutput(); // returns calculated motor output
    pid.updateError(current);
    return ans;
  }
}