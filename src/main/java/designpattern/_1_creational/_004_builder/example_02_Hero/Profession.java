package designpattern._1_creational._004_builder.example_02_Hero;

/**
 * Profession enumeration.
 */
public enum Profession {

  WARRIOR, THIEF, MAGE, PRIEST;

  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
