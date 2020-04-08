package me.mayermad.jdabot.storage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLManager {

    public static void onCreate() {
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS advantages( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, name STRING, advantage INTEGER DEFAULT 0, discordId STRING)");
    }

    public static void reset() {
        LiteSQL.onUpdate("DELETE FROM advantages");
        LiteSQL.onUpdate("DELETE FROM sqlite_sequence");
    }
    
    public static void advPlayer(String playerId, String playerName, int adv) {
        ResultSet resultSet;
        try {
            resultSet = LiteSQL.onQuery("SELECT advantage FROM advantages WHERE discordId = \"" + playerId + "\"");
            assert resultSet != null;
            if (resultSet.isClosed()){
                createPlayer(playerId, playerName);
                resultSet = LiteSQL.onQuery("SELECT advantage FROM advantages WHERE discordId = \"" + playerId + "\"");
            }
            assert resultSet != null;
            adv = resultSet.getInt("advantage") + adv;
            LiteSQL.onUpdate("UPDATE advantages SET advantage = " + adv + " WHERE discordId = \"" + playerId + "\"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createPlayer(String playerId , String playerName) {
        LiteSQL.onUpdate("INSERT INTO advantages (name, discordId) VALUES (\"" + playerName +"\", \"" + playerId +"\")");
    }

    public static void advNPC(String npcName, int adv) {
        ResultSet resultSet;
        try {
            resultSet = LiteSQL.onQuery("SELECT advantage FROM advantages WHERE name = \"" + npcName + "\"");
            assert resultSet != null;
            if (resultSet.isClosed()){
                createPlayer("0", npcName);
                resultSet = LiteSQL.onQuery("SELECT advantage FROM advantages WHERE name = \"" + npcName + "\"");;
            }
            assert resultSet != null;
            adv = resultSet.getInt("advantage") + adv;
            LiteSQL.onUpdate("UPDATE advantages SET advantage = " + adv + " WHERE name = \"" + npcName + "\"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
