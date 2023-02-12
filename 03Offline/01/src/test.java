class test {
    public static void main(String[] args) {
      Passengers crewmate1 = new Crewmates("Deckerd");
      
      Monsters monster1 = new SpaceMonsters("Blob");
      Passengers monsterAdapter = new MonsterAdapter(monster1);
      
      crewmate1.whoAmI();
      crewmate1.work();

      monster1.whoAmI();
      monster1.sabotage();

      monsterAdapter.whoAmI();
      monsterAdapter.work();
    }
}