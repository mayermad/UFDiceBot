package me.mayermad.jdabot.storage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLManager {

    public static void onCreate() {
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS advantages( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, name STRING, advantage INTEGER DEFAULT 0, discordId STRING)");
        //characteristics
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS characteristics( discordId STRING NOT NULL PRIMARY KEY, ws INTEGER Default 0, bs INTEGER Default 0, s INTEGER Default 0, t INTEGER Default 0, i INTEGER Default 0, ag INTEGER Default 0, dex INTEGER Default 0, int INTEGER Default 0, wp INTEGER Default 0, fel INTEGER Default 0, fate INTEGER Default 0, fortune INTEGER Default 0, resilience INTEGER Default 0, resolve INTEGER Default 0, movement INTEGER Default 4, experience INTEGER Default 0)");
        //basic skills
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS basic(discordId STRING NOT NULL PRIMARY KEY, art INTEGER Default 0, athletics INTEGER Default 0, bribery INTEGER Default 0, charm INTEGER Default 0, charmAnimal INTEGER Default 0, climb INTEGER Default 0, cool INTEGER Default 0, consumeAlcohol INTEGER Default 0, dodge INTEGER Default 0, drive INTEGER Default 0, endurance INTEGER Default 0, entertain INTEGER Default 0, gamble INTEGER Default 0, gossip INTEGER Default 0, haggle INTEGER Default 0, intimidate INTEGER Default 0, intuition INTEGER Default 0, leadership INTEGER Default 0, meleeBasic INTEGER Default 0, melee INTEGER Default 0, navigation INTEGER Default 0, outdoorSurvival INTEGER Default 0, perception INTEGER Default 0, ride INTEGER Default 0, row INTEGER Default 0, stealth INTEGER Default 0)");
        //advanced skills
        LiteSQL.onUpdate("");
        //grouped skills
        LiteSQL.onUpdate("CREATE TABLE");
        LiteSQL.onUpdate("");
        LiteSQL.onUpdate("");
        LiteSQL.onUpdate("");
        LiteSQL.onUpdate("");
        LiteSQL.onUpdate("");
        LiteSQL.onUpdate("");
        LiteSQL.onUpdate("");
        LiteSQL.onUpdate("");
        LiteSQL.onUpdate("");
        LiteSQL.onUpdate("");
        LiteSQL.onUpdate("");
        LiteSQL.onUpdate("");
        LiteSQL.onUpdate("");
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

    public static void createChar(String playerId) {
        LiteSQL.onUpdate("INSERT INTO characteristics (discordId) VALUES (\"" + playerId + "\")");
    }

    public static void setCharacteristic(String characteristic, String playerId, int value) {
        try {
            LiteSQL.onUpdate("UPDATE characteristics SET " + characteristic + " = " + value + " WHERE discordId = \"" + playerId + "\"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void setBasicSkill(String skill, String playerId, int value) {
        try {
            LiteSQL.onUpdate("UPDATE basic SET " + skill + " = " + value + " WHERE discordId = \"" + playerId + "\"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getCharacteristic(String characteristic, String playerId) {
        int value = -1;
        ResultSet resultSet = LiteSQL.onQuery("SELECT * FROM characteristics WHERE discordId = \"" + playerId + "\"");
        try {
            assert resultSet != null;
            value = resultSet.getInt(characteristic);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static int getBasicSkill(String characteristic, String playerId) {
        int value = -1;
        ResultSet resultSet = LiteSQL.onQuery("SELECT * FROM basic WHERE discordId = \"" + playerId + "\"");
        try {
            assert resultSet != null;
            value = resultSet.getInt(characteristic);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static int getAdv(String playerId) {
        int adv = 0;
        ResultSet resultSet = LiteSQL.onQuery("SELECT * FROM advantages WHERE discordId = \"" + playerId + "\"");
        try{
            assert resultSet != null;
            adv = resultSet.getInt("advantage");
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adv;
    }

    public static void advNPC(String npcName, int adv) {
        ResultSet resultSet;
        try {
            resultSet = LiteSQL.onQuery("SELECT advantage FROM advantages WHERE name = \"" + npcName + "\"");
            assert resultSet != null;
            if (resultSet.isClosed()){
                createPlayer("0", npcName);
                resultSet = LiteSQL.onQuery("SELECT advantage FROM advantages WHERE name = \"" + npcName + "\"");
            }
            assert resultSet != null;
            adv = resultSet.getInt("advantage") + adv;
            LiteSQL.onUpdate("UPDATE advantages SET advantage = " + adv + " WHERE name = \"" + npcName + "\"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
