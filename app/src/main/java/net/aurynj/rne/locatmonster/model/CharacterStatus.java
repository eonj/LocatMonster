package net.aurynj.rne.locatmonster.model;

import java.util.Formatter;

public class CharacterStatus {
    public String Name;
    public String Alias;
    public int Level;
    public int MaxHP, MaxMP, MaxSP;
    public int HP, MP, SP;
    public SkillClass[] Skills;
    public int DrawableRes;
    public Class<? extends CharacterClass> Class;
    public static CharacterStatus fromClass(CharacterClass characterClass) {
        CharacterStatus characterStatus = new CharacterStatus();
        characterStatus.Name = characterClass.getName();
        characterStatus.Alias = "";
        characterStatus.Level = characterClass.getDefaultLevel();
        characterStatus.MaxHP = characterClass.getBaseMaxHP() * characterStatus.Level;
        characterStatus.MaxMP = characterClass.getBaseMaxMP() * characterStatus.Level;
        characterStatus.MaxSP = characterClass.getBaseMaxSP() * characterStatus.Level;
        characterStatus.HP = characterStatus.MaxHP;
        characterStatus.MP = characterStatus.MaxMP;
        characterStatus.SP = characterStatus.MaxSP;
        characterStatus.Skills = characterClass.getSkills();
        characterStatus.DrawableRes = characterClass.drawableRes();
        characterStatus.Class = characterClass.getClass();
        return characterStatus;
    }

    public String toString() {
        String aliasPart = (Alias != null && Alias.length() != 0) ? ("alias=" + Alias) : "no_alias";
        Formatter formatter = new Formatter();
        formatter.format("Character %s (%s) [Lv: %d, HP: %d, MP: %d, SP: %d]",
                Name, aliasPart, Level, HP, MP, SP);
        return formatter.toString();
    }

    public void apply(PointClass pointClass, int pointIncrment) {
        switch (pointClass) {
            case HP:
                HP += pointIncrment;
                break;
            case MP:
                MP += pointIncrment;
                break;
            case SP:
                SP += pointIncrment;
                break;
        }
    }
}
