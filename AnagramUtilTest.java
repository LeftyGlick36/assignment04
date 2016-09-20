package assignment04;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnagramUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSort() {
		assertEquals("abd", AnagramUtil.sort("dab"));
		assertEquals("abcr", AnagramUtil.sort("crab"));
		assertEquals("emoss", AnagramUtil.sort("moses"));
		assertEquals("Adny", AnagramUtil.sort("Andy"));
		assertEquals("eggr", AnagramUtil.sort("greg"));
		assertEquals("adm", AnagramUtil.sort("dam"));
		assertEquals("agiiinrV", AnagramUtil.sort("Virginia"));
		assertEquals("aABCDdEFGHIJKLMNnOPQRSTUVWXYZ", AnagramUtil.sort("ZYXWVUTSRQPONMLKJIHGFEDCBandA"));
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", AnagramUtil.sort("ZYXWVUTSRQPONMLKJIHGFEDCBA"));

	}

	@Test
	public void testInsertionSort() {
		AnagramComparator insertionSortCompare = new AnagramComparator();
		String[] list = { "Ace", "bad", "Foggry", "Even", "Froggy", "dab" };
		String[] numberedList = { "5", "5", "1", "44", "353", "2", "153", "74", "1", "22", "74" };
		AnagramUtil.insertionSort(numberedList, insertionSortCompare);
		AnagramUtil.insertionSort(list, insertionSortCompare);
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}

		for (int i = 0; i < numberedList.length; i++) {
			System.out.println(numberedList[i]);
		}

	}

	@Test
	public void testAreAnagrams() {
		assertTrue(AnagramUtil.areAnagrams("actress", "casters"));
		assertTrue(AnagramUtil.areAnagrams("Foggry", "Froggy"));
		assertTrue(AnagramUtil.areAnagrams("bad", "dab"));

	}

	@Test
	public void testAreAnagramsIgnoreCaps() {
		assertTrue(AnagramUtil.areAnagrams("aLLerGy", "lArgELY"));
		assertTrue(AnagramUtil.areAnagrams("FlIp", "PfLi"));
	}

	@Test
	public void testAreNotAnagrams() {
		assertFalse(AnagramUtil.areAnagrams("salesman", "lameness")); // This is
																		// false
																		// because
																		// salesman
																		// has
																		// an
																		// extra
																		// "a"
																		// (total
																		// of 2)
																		// unlike
																		// lameness
																		// with
																		// 1 "a'
		assertFalse(AnagramUtil.areAnagrams("dudeman", "dudesman"));
	}

	@Test
	public void testGetLargestAnagramGroupStringArray() {
		String[] word = { "alert", "aa", "later", "AA", "bzy", "yzb", "alter", "x", "y" };
		// Removed duplicates and tested anagrams for strings listed on
		// http://www.english-for-students.com/Complete-List-of-Anagrams.html
		// there are two groups of 7 set anagram pairs... this only outputs one
		String[] answers = { "abed", "bade", "bead", "abet", "beat", "beta", "abets", "baste", "betas", "beast",
				"beats", "abut", "tabu", "tuba", "acme", "came", "mace", "acre", "care", "race", "acres", "cares",
				"races", "scare", "actors", "costar", "castor", "actress", "casters", "recasts", "airmen", "marine",
				"remain", "alert", "alter", "later", "alerted", "altered", "related", "treadle", "ales", "leas", "sale",
				"seal", "aligned", "dealing", "leading", "allergy", "gallery", "largely", "regally", "amen", "mane",
				"mean", "name", "anew", "wane", "wean", "angel", "angle", "glean", "antler", "learnt", "rental", "apt",
				"pat", "tap", "arches", "chaser", "search", "are", "ear", "era", "arm", "mar", "ram", "arrest",
				"rarest", "raters", "starer", "artist", "strait", "traits", "arts", "rats", "star", "tars", "arcs",
				"cars", "scar", "ascent", "secant", "stance", "ascot", "coats", "coast", "tacos", "asleep", "elapse",
				"please", "asp", "pas", "sap", "spa", "aspired", "despair", "diapers", "praised", "asps", "pass",
				"saps", "spas", "assert", "asters", "stares", "aster", "rates", "stare", "taser", "tears", "ate", "eat",
				"eta", "tea", "aridest", "astride", "staider", "tardies", "tirades", "auctioned", "cautioned",
				"education", "awls", "laws", "slaw", "baker", "brake", "break", "bard", "brad", "drab", "bared",
				"beard", "bread", "debar", "barely", "barley", "bleary", "bats", "stab", "tabs", "begin", "being",
				"binge", "below", "bowel", "elbow", "bleats", "stable", "tables", "bluest", "bluets", "bustle",
				"sublet", "subtle", "bores", "robes", "sober", "brag", "garb", "grab", "calipers", "replicas",
				"spiracle", "caller", "cellar", "recall", "canter", "nectar", "recant", "trance", "canters", "nectars",
				"recants", "scanter", "trances", "capes", "paces", "space", "caret", "cater", "crate", "trace",
				"carets", "caters", "caster", "crates", "reacts", "recast", "traces", "catered", "created", "reacted",
				"cider", "cried", "dicer", "claimed", "decimal", "declaim", "medical", "claps", "clasp", "scalp",
				"code", "coed", "deco", "construe", "counters", "recounts", "trounces", "corset", "escort", "sector",
				"cratered", "retraced", "terraced", "cruel", "lucre", "ulcer", "dale", "deal", "lade", "lead", "dare",
				"dear", "read", "danger", "gander", "garden", "ranged", "darters", "retards", "starred", "traders",
				"dater", "rated", "trade", "tread", "daters", "trades", "treads", "stared", "dates", "sated", "stead",
				"dearth", "hatred", "thread", "dearths", "hardest", "hatreds", "threads", "trashed", "decanter",
				"cantered", "recanted", "deigns", "design", "signed", "singed", "deist", "diets", "edits", "sited",
				"tides", "demerit", "merited", "mitered", "denter", "rented", "tender", "deltas", "lasted", "slated",
				"demo", "dome", "mode", "desert", "deters", "rested", "detail", "dilate", "tailed", "detains",
				"instead", "sainted", "stained", "detour", "routed", "toured", "diaper", "paired", "repaid", "diet",
				"edit", "tide", "tied", "direst", "driest", "stride", "discounter", "introduces", "reductions", "does",
				"dose", "odes", "doters", "sorted", "stored", "dowry", "rowdy", "wordy", "drapes", "padres", "parsed",
				"rasped", "spared", "spread", "drawer", "redraw", "reward", "warder", "warred", "dues", "sued", "used",
				"duster", "rudest", "rusted", "earned", "endear", "neared", "earnest", "eastern", "nearest", "earns",
				"nears", "saner", "snare", "ears", "eras", "sear", "earth", "hater", "heart", "east", "eats", "sate",
				"seat", "teas", "elan", "lane", "lean", "emigrants", "mastering", "streaming", "emoter", "meteor",
				"remote", "enlarge", "general", "gleaner", "emit", "item", "mite", "time", "emits", "items", "mites",
				"smite", "times", "endive", "envied", "veined", "enlist", "inlets", "listen", "silent", "tinsel",
				"enters", "nester", "resent", "tenser", "eons", "nose", "ones", "esprit", "priest", "sprite", "stripe",
				"esprits", "persist", "spriest", "sprites", "stripes", "ester", "reset", "steer", "terse", "trees",
				"ether", "there", "three", "evil", "live", "veil", "vile", "filets", "itself", "stifle", "filter",
				"lifter", "trifle", "flow", "fowl", "wolf", "forest", "fortes", "foster", "softer", "glare", "lager",
				"large", "regal", "gilder", "girdle", "glider", "gnus", "guns", "snug", "sung", "goer", "gore", "ogre",
				"gory", "gyro", "orgy", "gust", "guts", "tugs", "hare", "hear", "rhea", "hares", "hears", "rheas",
				"share", "shear", "heaps", "phase", "shape", "heros", "hoers", "horse", "shore", "hoes", "hose", "shoe",
				"hops", "posh", "shop", "ideals", "ladies", "sailed", "inks", "sink", "skin", "ires", "rise", "sire",
				"kale", "lake", "leak", "lair", "liar", "rail", "lame", "male", "meal", "lameness", "nameless",
				"salesman", "lament", "mantel", "mantle", "mental", "lapse", "leaps", "pales", "peals", "pleas",
				"sepal", "last", "salt", "slat", "late", "tale", "teal", "leap", "pale", "peal", "plea", "leapt",
				"petal", "plate", "pleat", "least", "slate", "stale", "steal", "tales", "teals", "lemons", "melons",
				"solemn", "limes", "miles", "slime", "smile", "list", "silt", "slit", "lips", "lisp", "slip", "lisper",
				"perils", "pliers", "lister", "liters", "litres", "relist", "tilers", "livers", "silver", "sliver",
				"loop", "polo", "pool", "looped", "poodle", "pooled", "loops", "polos", "pools", "sloop", "spool",
				"lopes", "poles", "slope", "lots", "lost", "slot", "lusters", "results", "rustles", "manes", "manse",
				"means", "names", "marines", "remains", "seminar", "mast", "mats", "tams", "master", "stream", "tamers",
				"mate", "meat", "tame", "team", "mates", "meats", "steam", "tames", "teams", "merit", "mitre", "remit",
				"timer", "merits", "mister", "miters", "mitres", "remits", "timers", "mesa", "same", "seam", "nails",
				"slain", "snail", "naive", "ravine", "vainer", "nape", "neap", "pane", "naps", "pans", "snap", "span",
				"nets", "nest", "sent", "tens", "nope", "open", "peon", "pone", "noter", "toner", "tenor", "notes",
				"onset", "stone", "tones", "now", "own", "won", "observe", "obverse", "verbose", "opt", "pot", "top",
				"opts", "post", "pots", "stop", "tops", "owns", "snow", "sown", "paled", "pedal", "plead", "palest",
				"pastel", "petals", "plates", "pleats", "staple", "panel", "penal", "plane", "pares", "parse", "pears",
				"rapes", "reaps", "spare", "spear", "parley", "pearly", "player", "replay", "parroted", "predator",
				"prorated", "teardrop", "pars", "raps", "rasp", "spar", "parses", "passer", "spares", "sparse",
				"spears", "paltry", "partly", "raptly", "parts", "strap", "traps", "parsley", "parleys", "players",
				"replays", "sparely", "part", "rapt", "trap", "parties", "pastier", "pirates", "traipse", "past",
				"pats", "spat", "taps", "paste", "peats", "septa", "spate", "tapes", "paws", "swap", "wasp", "pelts",
				"slept", "spelt", "pertness", "presents", "serpents", "pest", "pets", "step", "piers", "pries", "spire",
				"pines", "snipe", "spine", "pinto", "piton", "point", "pintos", "piston", "pitons", "points", "pores",
				"poser", "prose", "ropes", "spore", "potters", "protest", "spotter", "present", "repents", "serpent",
				"rashes", "shares", "shears", "rattles", "starlet", "startle", "realist", "saltier", "retails",
				"recused", "reduces", "rescued", "secured", "reigns", "resign", "signer", "singer", "reins", "resin",
				"rinse", "risen", "siren", "repaint", "painter", "pertain", "repaints", "painters", "pantries",
				"pertains", "rescue", "recuse", "secure", "resort", "roster", "sorter", "restrain", "retrains",
				"strainer", "terrains", "trainers", "retests", "setter", "street", "tester", "retrain", "terrain",
				"trainer", "rite", "tier", "tire", "rites", "tiers", "tires", "tries", "rosiest", "sorties", "stories",
				"saint", "satin", "stain", "salve", "slave", "vales", "veals", "seated", "sedate", "teased", "serve",
				"sever", "veers", "verse", "sinew", "swine", "wines", "wisens", "skate", "stake", "steak", "takes",
				"teaks", "skated", "staked", "tasked", "slates", "steals", "tassel", "state", "taste", "teats", "stew",
				"wets", "stow", "tows", "twos", "sway", "ways", "yaws", "taster", "tetras", "treats", "thickets",
				"thickest", "thickset", "weird", "wired", "wider", "whiter", "wither", "writhe" };
		System.out.println(Arrays.toString(AnagramUtil.getLargestAnagramGroup(word)));
		System.out.println(Arrays.toString(AnagramUtil.getLargestAnagramGroup(answers)));

	}

	@Test
	public void testGetLargestAnagramGroupString() {
		fail("Not yet implemented");
	}

}
