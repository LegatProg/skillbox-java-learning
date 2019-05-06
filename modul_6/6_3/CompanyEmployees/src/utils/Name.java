package utils;

public class Name {

    private static final String[] NAMES = {"Aaron", "Abraham", "Adam", "Adrian", "Aidan", "Alan", "Albert", "Alejandro",
            "Alex", "Alexander", "Alfred", "Andrew", "Angel", "Anthony", "Antonio", "Ashton", "Austin", "Aaliyah",
            "Abigail", "Ada", "Adelina", "Agatha", "Alexa", "Alexandra", "Alexis", "Alise", "Allison", "Alyssa",
            "Amanda", "Amber", "Amelia", "Angelina", "Anita", "Ann", "Ariana", "Arianna", "Ashley", "Audrey",
            "Autumn", "Ava", "Avery", "Benjamin", "Bernard", "Blake", "Brandon", "Brian", "Bruce", "Bryan",
            "Bailey", "Barbara", "Beatrice", "Belinda", "Brianna", "Bridjet", "Brooke", "Cameron", "Carl",
            "Carlos", "Charles", "Christopher", "Cole", "Connor", "Caleb", "Carter", "Chase", "Christian",
            "Clifford", "Cody", "Colin", "Curtis", "Cyrus", "Caroline", "Catherine", "Cecilia", "Celia", "Chloe",
            "Christine", "Claire", "Daniel", "David", "Dennis", "Devin", "Diego", "Dominic", "Donald", "Douglas",
            "Dylan", "Daisy", "Danielle", "Deborah", "Delia", "Destiny", "Diana", "Dorothy", "Edward", "Elijah",
            "Eric", "Ethan", "Evan", "Eleanor", "Elizabeth", "Ella", "Emily", "Emma", "Erin", "Evelyn", "Francis",
            "Fred", "Faith", "Fiona", "Florence", "Freda", "Gabriel", "Gavin", "Geoffrey", "George", "Gerld", "Gilbert",
            "Gordon", "Graham", "Gregory", "Gloria", "Gabriella", "Gabrielle", "Gladys", "Grace", "Harold", "Harry",
            "Hayden", "Henry", "Herbert", "Horace", "Howard", "Hugh", "Hunter", "Hailey", "Haley", "Hannah", "Helen",
            "Ian", "Isaac", "Isaiah", "Isabel", "Isabella", "Jack", "Jackson", "Jacob", "Jaden", "Jake", "James",
            "Jason", "Jayden", "Jeffery", "Jeremiah", "Jesse", "Jesus", "John", "Jonathan", "Jordan", "Jose", "Joseph",
            "Joshua", "Juan", "Julian", "Justin", "Jacqueline", "Jada", "Jane", "Jasmine", "Jenna", "Jennifer",
            "Jessica", "Jocelyn", "Jordan", "Josephine", "Joyce", "Julia", "Keith", "Kevin", "Kyle", "Kaitlyn",
            "Katelyn", "Katherine", "Kathryn", "Kayla", "Kaylee", "Kimberly", "Kylie", "Landon", "Lawrence", "Leonars",
            "Lewis", "Logan", "Louis", "Lucas", "Luke", "Laura", "Lauren", "Leah", "Leonora", "Leslie", "Lillian",
            "Lily", "Linda", "Lorna", "Luccile", "Lucy", "Lynn", "Malcolm", "Martin", "Mason", "Matthew", "Michael",
            "Miguel", "Miles", "Morgan", "Mabel", "Mackenzie", "Madeline", "Madison", "Makayla", "Margaret", "Maria",
            "Marisa", "Marjorie", "Mary", "Maya", "Megan", "Melanie", "Melissa", "Mia", "Michelle", "Mildred", "Molly",
            "Monica", "Nathan", "Nathaniel", "Neil", "Nicholas", "Noah", "Norman", "Nancy", "Natalie", "Nicole", "Nora",
            "Oliver", "Oscar", "Oswald", "Owen", "Olivia", "Patrick", "Peter", "Philip", "Paige", "Pamela", "Patricia",
            "Pauline", "Penelope", "Priscilla", "Ralph", "Raymond", "Reginald", "Richard", "Robert", "Rodrigo", "Roger",
            "Ronald", "Ryan", "Rachel", "Rebecca", "Riley", "Rita", "Rosalind", "Rose", "Samuel", "Sean", "Sebastian",
            "Seth", "Simon", "Stanley", "Steven", "Samantha", "Sandra", "Sara", "Sarah", "Savannah", "Sharon", "Sheila",
            "Shirley", "Sierra", "Sofia", "Sophia", "Stephanie", "Susan", "Sybil", "Sydney", "Sylvia", "Thomas",
            "Timothy", "Tyler", "Taylor", "Trinity", "Vanessa", "Victoria", "Violet", "Virginia", "Wallace", "Walter",
            "William", "Wyatt", "Winifred", "Xavier", "Yvonne", "Zachary", "Zoe"};

    private static final String[] SURNAMES = {"Abramson", "Adamson", "Adderiy", "Addington", "Adrian", "Albertson", "Aldridge",
            "Allford", "Alsopp", "Anderson", "Andrews", "Archibald", "Arnold", "Arthurs", "Atcheson", "Attwood", "Audley",
            "Austin", "Ayrton", "Babcock", "Backer", "Baldwin", "Bargeman", "Barnes", "Barrington", "Bawerman", "Becker",
            "Benson", "Berrington", "Birch", "Bishop", "Black", "Blare", "Blomfield", "Boolman", "Bootman", "Bosworth",
            "Bradberry", "Bradshaw", "Brickman", "Brooks", "Brown", "Bush", "Calhoun", "Campbell", "Carey", "Carrington",
            "Carroll", "Carter", "Chandter", "Chapman", "Charlson", "Chesterton", "Clapton", "Clifford", "Coleman",
            "Conors", "Cook", "Cramer", "Creighton", "Croftoon", "Crossman", "Daniels", "Davidson", "Day", "Dean",
            "Derrick", "Dickinson", "Dodson", "Donaldson", "Donovan", "Douglas", "Dowman", "Dutton", "Duncan", "Dunce",
            "Durham", "Dyson", "Eddington", "Edwards", "Ellington", "Elmers", "Enderson", "Erickson", "Evans", "Faber",
            "Fane", "Farmer", "Farrell", "Ferguson", "Finch", "Fisher", "Fitzgerald", "Flannagan", "Flatcher", "Fleming",
            "Ford", "Forman", "Forster", "Foster", "Francis", "Fraser", "Freeman", "Fulton", "Galbraith", "Gardner",
            "Garrison", "Gate", "Gerald", "Gibbs", "Gilbert", "Gill", "Gilmore", "Gilmore", "Gimson", "Goldman",
            "Goodman", "Gustman", "Haig", "Hailey", "Hamphrey", "Hancock", "Hardman", "Harrison", "Hawkins", "Higgins",
            "Hodges", "Hoggarth", "Holiday", "Holmes", "Howard", "Jacobson", "James", "Jeff", "Jenkin", "Jerome",
            "Johnson", "Jones", "Keat", "Kelly", "Kendal", "Kennedy", "Kennett", "Kingsman", "Kirk", "Laird", "Lamberts",
            "Larkins", "Lawman", "Leapman", "Leman", "Lewin", "Little", "Livingston", "Longman", "MacAdam", "MacAlister",
            "MacDonald", "Macduff", "Macey", "Mackenzie", "Mansfield", "Marlow", "Marshman", "Mason", "Mathews", "Mercer",
            "Michaelson", "Miers", "Miller", "Miln", "Milton", "Molligan", "Morrison", "Murphy", "Nash", "Nathan", "Neal",
            "Nelson", "Nevill", "Nicholson", "Nyman", "Oakman", "Ogden", "Oldman", "Oldridge", "Oliver", "Osborne",
            "Oswald", "Otis", "Owen", "Page", "Palmer", "Parkinson", "Parson", "Pass", "Paterson", "Peacock", "Pearcy",
            "Peterson", "Philips", "Porter", "Quincy", "Raleigh", "Ralphs", "Ramacey", "Reynolds", "Richards", "Roberts",
            "Roger", "Russel", "Ryder", "Salisburry", "Salomon", "Samuels", "Saunder", "Shackley", "Sheldon", "Sherlock",
            "Shorter", "Simon", "Simpson", "Smith", "Stanley", "Stephen", "Stevenson", "Sykes", "Taft", "Taylor",
            "Thomson", "Thorndike", "Thornton", "Timmons", "Tracey", "Turner", "Vance", "Vaughan", "Wainwright",
            "Walkman", "Wallace", "Waller", "Walter", "Ward", "Warren", "Watson", "Wayne", "Webster", "Wesley", "White",
            "WifKinson", "Winter", "Wood", "Youmans", "Young"};

    public static String getRandomName() {
        String name = NAMES[(int) (Math.random() * (NAMES.length - 1))];
        String surname = SURNAMES[(int) (Math.random() * (SURNAMES.length - 1))];
        return name + " " + surname;
    }

}
