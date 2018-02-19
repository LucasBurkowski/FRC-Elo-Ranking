/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc.elo.ranking;

import java.util.Arrays;

/**
 *
 * @author lburkowski
 */
public class FRCEloRanking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Team[] teamList = TBA.getEventTeams("2016miann");
        Match[] matchList = TBA.getEventMatches("2016miann");
        
        for (Match matchList1 : matchList) {
            Alliance blue = new Alliance();
            Alliance red = new Alliance();
            blue.matchScore = matchList1.blueScore;
            red.matchScore = matchList1.redScore;
            for (Team teamList1 : teamList) {
                if (teamList1.number.equals(matchList1.blueTeams[0])) {
                    blue.team1 = teamList1;
                }
                if (teamList1.number.equals(matchList1.blueTeams[1])) {
                    blue.team2 = teamList1;
                }
                if (teamList1.number.equals(matchList1.blueTeams[2])) {
                    blue.team3 = teamList1;
                }
                if (teamList1.number.equals(matchList1.redTeams[0])) {
                    red.team1 = teamList1;
                }
                if (teamList1.number.equals(matchList1.redTeams[1])) {
                    red.team2 = teamList1;
                }
                if (teamList1.number.equals(matchList1.redTeams[2])) {
                    red.team3 = teamList1;
                }
            }
            Elo.assignRanks(red, blue);
        }
        
        Arrays.sort(teamList, new SortTeams());
        
        for (Team teamList1 : teamList) {
            System.out.println(teamList1.number + " " + teamList1.rank);
        }
    }
    
}
