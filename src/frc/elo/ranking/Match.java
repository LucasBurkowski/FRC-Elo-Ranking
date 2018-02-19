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
public class Match {
    int matchNumber;
    Alliance red;
    Alliance blue;
    String[] blueTeams = new String[3];
    String[] redTeams = new String[3];
    long redScore;
    long blueScore;
    
    public Match(String[] blueTeams, String[] redTeams, long redScore, long blueScore){
        this.blueTeams = blueTeams;
        this.redTeams = redTeams;
        this.redScore = redScore;
        this.blueScore = blueScore;
    }
    
    public void setTeams(String[] blue, String[] red){
        this.blueTeams = blue.clone();
        this.redTeams = red.clone();
    }
    
    public void setScores(long blueScore, long redScore){
        this.blueScore = blueScore;
        this.redScore = redScore;
    }
    
}
