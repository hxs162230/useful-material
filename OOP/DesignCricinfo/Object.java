Admin, Player, Umpire, Referee, and Commentator: These classes represent the different people that interact with our system:




public class Player {
  private Person person;
  private ArrayList<PlayerContract> contracts;

  public boolean addContract();
}

public class Admin {
  private Person person;

  public boolean addMatch(Match match);

  public boolean addTeam(Team team);

  public boolean addTournament(Tournament tournament);
}

public class Umpire {
  private Person person;

  public boolean assignMatch(Match match);
}

public class Referee {
  private Person person;

  public boolean assignMatch(Match match);
}

public class Commentator {
  private Person person;

  public boolean assignMatch(Match match);
}


Team, TournamentSquad, and Playing11: Team will announce a squad for a tournament, out of which, the playing 11 will be chosen:

public class Team {
  private String name;
  private List<Player> players;
  private List<News> news;
  private Coach coach;

  public boolean addTournamentSquad(TournamentSquad tournamentSquad);
  public boolean addPlayer(Player player);
  public boolean addNews(News news);
}

public class TournamentSquad {
  private List<Player> players;
  private List<TournamentStat> tournamentStats;

  public boolean addPlayer(Player player);
}

public class Playing11 {
  private List<Player> players;
  private Player twelfthMan;

  public boolean addPlayer(Player player);
}



Over, Ball, Wicket, Commentary, Inning, and Match: Match will be an abstract class, extended by ODI, Test, and T20:


public class Over {
  private int number;
  private List<Ball> balls;

  public boolean addBall(Ball ball);
}

public class Ball {
  private Player balledBy;
  private Player playedBy;
  private BallType type;

  private Wicket wicket;
  private List<Run> runs;
  private Commentary commentary;

}

public class Wicket {
  private WicketType wicketType;
  private Player playerOut;
  private Player caughtBy;
  private Player runoutBy;
  private Player stumpedBy;
}

public class Commentary {
  private String text;
  private Date createdAt;
  private Commentator createdBy;
}

public class Inning {
  private int number;
  private Date startTime;
  private List<Over> overs;

  public boolean addOver(Over over);
}

public abstract class Match {
  private int number;
  private Date startTime;
  private MatchResult result;

  private Playing11[] teams;
  private List<Inning> innings;
  private List<Umpire> umpires;
  private Referee referee;
  private List<Commentator> commentators;
  private List<MatchStat> matchStats;

  public boolean assignStadium(Stadium stadium);

  public boolean assignReferee(Referee referee);
}

public class ODI extends Match {
  //...
}

public class Test extends Match {
  //...
}
