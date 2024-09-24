package designpattern._1_creational._004_builder.example_02_Hero;

public record Hero(Profession profession, String name, HairType hairType, HairColor hairColor, Armor armor, Weapon weapon) {

	// Private constructor being called from inner static Builder class
	private Hero(Builder builder) {
		this(builder.profession, builder.name, builder.hairType, builder.hairColor, builder.armor, builder.weapon);
	}

	/** The inner static builder class with same fields as original outer class*/
	public static class Builder {

		private final Profession profession;
		private final String name;
		private HairType hairType;
		private HairColor hairColor;
		private Armor armor;
		private Weapon weapon;

		/** Constructor*/
		public Builder(Profession profession, String name) {
			if (profession == null || name == null) {
				throw new IllegalArgumentException("profession and name can not be null");
			}
			this.profession = profession;
			this.name = name;
		}

		// All Setters returning Builder object so that it will be easy to chain
		public Builder withHairType(HairType hairType) {
			this.hairType = hairType;
			return this;
		}

		public Builder withHairColor(HairColor hairColor) {
			this.hairColor = hairColor;
			return this;
		}

		public Builder withArmor(Armor armor) {
			this.armor = armor;
			return this;
		}

		public Builder withWeapon(Weapon weapon) {
			this.weapon = weapon;
			return this;
		}

		/** build() method which will be called at the end of chain,
		 build() calling Original Outer class private constructor with this object
		 and returns new original Outer class object */
		public Hero build() {
			return new Hero(this);
		}
	}
	
	
	@Override
	public String toString() {

		var sb = new StringBuilder();
		
		sb.append("This is a ").append(profession).append(" named ").append(name);
		
		if (hairColor != null || hairType != null) {
			sb.append(" with ");
			if (hairColor != null) {
				sb.append(hairColor).append(' ');
			}
			if (hairType != null) {
				sb.append(hairType).append(' ');
			}
			sb.append(hairType != HairType.BALD ? "hair" : "head");
		}
		
		if (armor != null) {
			sb.append(" wearing ").append(armor);
		}
		
		if (weapon != null) {
			sb.append(" and wielding a ").append(weapon);
		}
		
		sb.append('.');
		return sb.toString();
	}
}
