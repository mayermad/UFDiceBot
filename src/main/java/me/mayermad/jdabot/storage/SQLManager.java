package me.mayermad.jdabot.storage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLManager {

    public static void onCreate() {
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS advantages( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "name STRING, advantage INTEGER DEFAULT 0, discordId STRING)");

        //characteristics
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS characteristics( discordId STRING NOT NULL PRIMARY KEY, " +
                "ws INTEGER Default 0, bs INTEGER Default 0, s INTEGER Default 0, t INTEGER Default 0, " +
                "i INTEGER Default 0, ag INTEGER Default 0, dex INTEGER Default 0, int INTEGER Default 0, " +
                "wp INTEGER Default 0, fel INTEGER Default 0, fate INTEGER Default 0, fortune INTEGER Default 0, " +
                "resilience INTEGER Default 0, resolve INTEGER Default 0, movement INTEGER Default 4, " +
                "experience INTEGER Default 0)");

        //basic skills
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS basic(discordId STRING NOT NULL PRIMARY KEY, " +
                "art INTEGER Default 0, athletics INTEGER Default 0, bribery INTEGER Default 0, " +
                "charm INTEGER Default 0, charmAnimal INTEGER Default 0, climb INTEGER Default 0, " +
                "cool INTEGER Default 0, consumeAlcohol INTEGER Default 0, dodge INTEGER Default 0, " +
                "drive INTEGER Default 0, endurance INTEGER Default 0, gamble INTEGER Default 0, " +
                "gossip INTEGER Default 0, haggle INTEGER Default 0, intimidate INTEGER Default 0, " +
                "intuition INTEGER Default 0, leadership INTEGER Default 0, navigation INTEGER Default 0, " +
                "outdoorSurvival INTEGER Default 0, perception INTEGER Default 0, row INTEGER Default 0)");

        //advanced skills
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS advancedSkills(discordId STRING NOT NULL PRIMARY KEY, " +
                "animalCare INTEGER Default -1, channel INTEGER Default -1, evaluate INTEGER Default -1, " +
                "heal INTEGER Default -1, pickLock INTEGER Default -1, pray INTEGER Default -1, " +
                "research INTEGER Default -1, setTrap INTEGER Default -1, sleightOfHand INTEGER Default -1, " +
                "swim INTEGER Default -1, track INTEGER Default -1, trade INTEGER Default -1)");

        //grouped skills
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS animalTraining(discordId STRING NOT NULL PRIMARY KEY, " +
                "demigryph INTEGER Default -1, dog INTEGER Default -1, horse INTEGER Default -1, " +
                "pegasus INTEGER Default -1, pigeon INTEGER Default -1)");
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS art(discordId STRING NOT NULL PRIMARY KEY, " +
                "cartography INTEGER Default 0, engraving INTEGER Default 0, mosaics INTEGER Default 0, " +
                "painting INTEGER Default 0, sculpture INTEGER Default 0, tattoo INTEGER Default 0, " +
                "weaving INTEGER Default 0)");
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS entertain(discordId STRING NOT NULL PRIMARY KEY, " +
                "acting INTEGER Default 0, comedy INTEGER Default 0, singing INTEGER Default 0, " +
                "storytelling INTEGER Default 0)");
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS language(discordId STRING NOT NULL PRIMARY KEY, " +
                "battleTongue INTEGER Default -1, bretonnian INTEGER Default -1, classical INTEGER Default -1, " +
                "guilder INTEGER Default -1, khazalid INTEGER Default -1, magick INTEGER Default -1, " +
                "thief INTEGER Default -1, tilean INTEGER Default -1, albion INTEGER Default -1, " +
                "eltharin INTEGER Default -1, estalian INTEGER Default -1, gospodarinyi INTEGER Default -1, " +
                "grumbarth INTEGER Default -1, mootish INTEGER Default -1, norse INTEGER Default -1, " +
                "reikspiel INTEGER Default -1, queekish INTEGER Default -1, wastelander INTEGER Default -1)");
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS lore(discordId STRING NOT NULL PRIMARY KEY, " +
                "engineering INTEGER Default -1, geology INTEGER Default -1, heraldry INTEGER Default -1, " +
                "history INTEGER Default -1, law INTEGER Default -1, magick INTEGER Default -1, " +
                "metallurgy INTEGER Default -1, science INTEGER Default -1, theology INTEGER Default -1)");
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS melee(discordId STRING NOT NULL PRIMARY KEY, " +
                "basic INTEGER Default 0, brawling INTEGER Default 0, cavalry INTEGER Default 0, " +
                "fencing INTEGER Default 0, flail INTEGER Default 0, parry INTEGER Default 0, " +
                "poleArm INTEGER Default 0, twoHanded INTEGER Default 0)");
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS perform(discordId STRING NOT NULL PRIMARY KEY, " +
                "acrobatics INTEGER Default -1, clowning INTEGER Default -1, dancing INTEGER Default -1, " +
                "firebreathing INTEGER Default -1, juggling INTEGER Default -1, miming INTEGER Default -1, " +
                "ropeWalking INTEGER Default -1)");
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS play(discordId STRING NOT NULL PRIMARY KEY, " +
                "bagpipe INTEGER Default -1, lute INTEGER Default -1, harpsichord INTEGER Default -1, " +
                "horn INTEGER Default -1, violin INTEGER Default -1)");
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS ranged(discordId STRING NOT NULL PRIMARY KEY, " +
                "blackpowder INTEGER Default -1, bow INTEGER Default -1, crossbow INTEGER Default -1, " +
                "engineering INTEGER Default -1, entangling INTEGER Default -1, explosives INTEGER Default -1, " +
                "sling INTEGER Default -1, throwing INTEGER Default -1)");
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS ride(discordId STRING NOT NULL PRIMARY KEY, " +
                "demigryph INTEGER Default 0, greatWolf INTEGER Default 0, griffon INTEGER Default 0, " +
                "horse INTEGER Default 0, pegasus INTEGER Default 0)");
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS sail(discordId STRING NOT NULL PRIMARY KEY, " +
                "barge INTEGER Default -1, caravel INTEGER Default -1, cog INTEGER Default -1, " +
                "frigate INTEGER Default -1, wolfship INTEGER Default -1)");
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS secretSigns(discordId STRING NOT NULL PRIMARY KEY, " +
                "greyOrder INTEGER Default -1, guild INTEGER Default -1, ranger INTEGER Default -1, " +
                "scout INTEGER Default -1, thief INTEGER Default -1, vagabond INTEGER Default -1)");
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS stealth(discordId STRING NOT NULL PRIMARY KEY, " +
                "rural INTEGER Default 0, underground INTEGER Default 0, urban INTEGER Default 0)");
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS trade(discordId STRING NOT NULL PRIMARY KEY, " +
                "apothecary INTEGER Default -1, calligrapher INTEGER Default -1, chandler INTEGER Default -1, " +
                "carpenter INTEGER Default -1, cook INTEGER Default -1, embalmer INTEGER Default -1, " +
                "smith INTEGER Default -1, tanner INTEGER Default -1)");
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS standards(discordId STRING NOT NULL PRIMARY KEY, " +
                "animalTraining STRING DEFAULT \"dog\", art STRING DEFAULT \"cartography\", " +
                "entertain STRING DEFAULT \"acting\", language STRING DEFAULT \"magick\", " +
                "lore STRING DEFAULT \"magick\", melee STRING DEFAULT \"basic\", " +
                "perform STRING DEFAULT \"dancing\", play STRING DEFAULT \"bagpipe\", " +
                "ranged STRING DEFAULT \"throwing\", ride STRING DEFAULT \"horse\", " +
                "secretSigns STRING DEFAULT \"thief\", sail STRING DEFAULT \"cog\", " +
                "stealth STRING DEFAULT \"urban\", trade STRING DEFAULT \"cook\")");
    }

    public static void reset() {
        LiteSQL.onUpdate("UPDATE advantages SET advantage = 0");
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

    public static void addColumn(String table, String name, int def) {
        LiteSQL.onUpdate("ALTER TABLE " + table + " ADD COLUMN " + name + " INTEGER DEFAULT " + def);
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

    public static void setAdvancedSkill(String skill, String playerId, int value) {
        try {
            LiteSQL.onUpdate("UPDATE advancedSkills SET " + skill + " = " + value + " WHERE discordId = \"" + playerId + "\"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setGroupedSkill(String skill,String specialisation, String playerId, int value) {
        try {
            LiteSQL.onUpdate("UPDATE "+ skill +" SET " + specialisation + " = " + value + " WHERE discordId = \"" + playerId + "\"");
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

    public static int getBasicSkill(String skill, String playerId) {
        int value = -1;
        ResultSet resultSet = LiteSQL.onQuery("SELECT * FROM basic WHERE discordId = \"" + playerId + "\"");
        try {
            assert resultSet != null;
            value = resultSet.getInt(skill);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static int getGroupedSkill(String skill, String specialisation, String playerId) {
        int value = -1;
        ResultSet resultSet = LiteSQL.onQuery("SELECT * FROM " + skill + " WHERE discordId = \"" + playerId + "\"");
        try {
            assert resultSet != null;
            value = resultSet.getInt(specialisation);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static int getAdvancedSkill(String skill, String playerId) {
        int value = -1;
        ResultSet resultSet = LiteSQL.onQuery("SELECT * FROM advancedSkills WHERE discordId = \"" + playerId + "\"");
        try {
            assert resultSet != null;
            value = resultSet.getInt(skill);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static String getStandard(String skill, String playerId) {
        String value = "";
        ResultSet resultSet = LiteSQL.onQuery("SELECT * FROM standards WHERE discordId = \"" + playerId + "\"");
        try {
            assert resultSet != null;
            value = resultSet.getString(skill);
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
