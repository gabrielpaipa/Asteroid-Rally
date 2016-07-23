/** Logical model for the Asteroid Rally game. */
public class AsteroidRallyModel {

	/** Asteroids. */
	private Extent[] asteroids;

	/** Flags. */
	private Flag[] flags;

	/** Player 1's ship. */
	private Ship ship1;

	/** Player 2's ship. */
	private Ship ship2;

	public AsteroidRallyModel() {
		ship1 = new Ship(0.25, 0.5, Math.PI / 2);
		ship2 = new Ship(0.75, 0.5, Math.PI / 2);
		asteroids = new Extent[10];
		for (int i = 0; i < asteroids.length; i++) {
			do {
				asteroids[i] = new Extent(StdRandom.uniform(), StdRandom.uniform(), 0.05);
			} while (isConflictingAsteroidPosition(i));
		}
		flags = new Flag[5];
		for (int i = 0; i < flags.length; i++) {
			do {
				flags[i] = new Flag(StdRandom.uniform(), StdRandom.uniform());
			} while (isConflictingFlagPosition(i));
		}
	}

	/** Causes both ships to drift and checks for flag hits. */
	public void advance() {
		ship1.drift();
		ship2.drift();
		for (Flag f : flags) {
			if (f.getExtent().overlaps(ship1.getExtent())) {
				f.setHitByShip1();
			}
			if (f.getExtent().overlaps(ship2.getExtent())) {
				f.setHitByShip2();
			}
		}
	}

	/** Returns the asteroids. */
	public Extent[] getAsteroids() {
		return asteroids;
	}

	/** Returns the flags. */
	public Flag[] getFlags() {
		return flags;
	}

	/** Returns ship 1. */
	public Ship getShip1() {
		return ship1;
	}

	/** Returns ship 2. */
	public Ship getShip2() {
		return ship2;
	}

	/**
	 * Returns true if asteroid i overlaps with either ship or with any
	 * lower-indexed asteroid.
	 */
	public boolean isConflictingAsteroidPosition(int i) {
		if (asteroids[i].overlaps(ship1.getExtent())) {
			return true;
		}
		if (asteroids[i].overlaps(ship2.getExtent())) {
			return true;
		}
		for (int j = 0; j < i; j++) {
			if (asteroids[i].overlaps(asteroids[j])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if flag i overlaps with either ship, any asteroid, or any
	 * lower-indexed flag.
	 */
	public boolean isConflictingFlagPosition(int i) {
		if (flags[i].getExtent().overlaps(ship1.getExtent())) return true;
		if (flags[i].getExtent().overlaps(ship2.getExtent())) return true;
		for (int j = 0; j < asteroids.length; j++) {
			if (flags[i].getExtent().overlaps(asteroids[j])) return true;
		}
		for (int j = 0; j < i; j++) {
			if (flags[i].getExtent().overlaps(flags[j].getExtent())) return true;
		}
		return false;
	}

	/**
	 * Returns 1 if player 1 has won, 2 if player 2 has won, or 0 if neither
	 * player has won. A player wins if they hit all flags first or if the other
	 * player hits a rock.
	 */
	public int winner() {
		for(int j=0; j<flags.length; j++){
			if (asteroids[j].overlaps(ship1.getExtent())) {
				return 2;
			}
			if (asteroids[j].overlaps(ship2.getExtent())) {
				return 1;
			}}
		int countship1=0;
		int countship2=0;
		for(int j=0; j<flags.length; j++){
			if(flags[j].hasBeenHitByShip1()){ countship1++;}
			if(flags[j].hasBeenHitByShip2()){ countship2++;}
		}
		if(countship1==flags.length)return 1;
		if(countship2==flags.length)return 2;

		return 0;

	}

}
