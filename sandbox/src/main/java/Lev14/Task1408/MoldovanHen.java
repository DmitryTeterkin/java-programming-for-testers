package Lev14.Task1408;

public class MoldovanHen extends Hen {
  @Override
  int getCountOfEggsPerMonth() {
    return 25;
  }

  @Override
  String getDescription() {
    return "Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
  }
}
