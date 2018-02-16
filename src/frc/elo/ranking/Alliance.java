/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc.elo.ranking;

/**
 *
 * @author lburkowski
 */
public class Alliance {
    public Team team1;
    public Team team2;
    public Team team3;
    public int matchScore;
    
    public Alliance(Team team1, Team team2, Team team3, int matchScore){
        this.team1 = team1;
        this.team2 = team2;
        this.team3 = team3;
        this.matchScore = matchScore;
    }
    
    public double getRank(){
        return (team1.rank + team2.rank + team3.rank);
    }
}
