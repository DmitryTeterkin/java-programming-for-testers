package Lev14.Task1408done;

public class BelarusianHen extends Hen {
  @Override
  int getCountOfEggsPerMonth() {

    return 20;
  }

  @Override
  String getDescription() {
    return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
  }
}