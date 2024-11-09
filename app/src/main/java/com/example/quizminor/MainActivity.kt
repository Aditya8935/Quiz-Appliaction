package com.example.quizminor

import QuizList
import QuizListAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizminor.databinding.ActivityHomePageBinding
import com.example.quizminor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var title: MutableList<String>
    private lateinit var subtitle: MutableList<String>
    private lateinit var timer: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.setOnClickListener { view ->
            val popupMenu = PopupMenu(this@MainActivity, view)
            popupMenu.inflate(R.menu.popup_menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.option1 -> {
                        val intent = Intent(this@MainActivity, HomePageActivity::class.java)
                        startActivity(intent)
                        true
                    }
                    R.id.option2 -> {
                        val intent = Intent(this@MainActivity, AboutActivity::class.java)
                        startActivity(intent)
                        true
                    }
                    R.id.option3 -> {
                        val intent = Intent(this@MainActivity, SignUpActivity::class.java)
                        startActivity(intent)
                        true
                    }
                    else -> false
                }
            }
            popupMenu.show()
        }


        // Initialize lists for titles, subtitles, and timers for each section
        val section1Titles = arrayListOf("Programming")
        val section1Subtitles = arrayListOf("Let's start exploring JAVA!")
        val section1Timers = arrayListOf("5")

        val section2Titles = arrayListOf("Applied Mechanics")
        val section2Subtitles = arrayListOf("Lets Begin")
        val section2Timers = arrayListOf("5")

        val section3Titles = arrayListOf("English")
        val section3Subtitles = arrayListOf("What about English?")
        val section3Timers = arrayListOf("5")

        val section4Titles = arrayListOf("Electronics and Electrical Engineering")
        val section4Subtitles = arrayListOf("Make Connection")
        val section4Timers = arrayListOf("5")

        val section5Titles = arrayListOf("Maths")
        val section5Subtitles = arrayListOf("Can you solve me?")
        val section5Timers = arrayListOf("5")

        val section6Titles = arrayListOf("Chemistry")
        val section6Subtitles = arrayListOf("Inside the Human Body!")
        val section6Timers = arrayListOf("5")

        val quizList = ArrayList<QuizList>()

        // Add QuizList items for section 1
        for (i in section1Titles.indices) {
            val section1Questions = getSection1Questions()
            val quizItem = QuizList(section1Titles[i], section1Subtitles[i], section1Timers[i])
            quizList.add(quizItem)
        }

        // Add QuizList items for section 2
        for (i in section2Titles.indices) {
            val section2Questions = getSection2Questions()
            val quizItem = QuizList(section2Titles[i], section2Subtitles[i], section2Timers[i])
            quizList.add(quizItem)
        }

        // Add QuizList items for section 3 (Corrected section number)
        for (i in section3Titles.indices) {
            val section3Questions = getSection3Questions()  // Corrected function call
            val quizItem = QuizList(section3Titles[i], section3Subtitles[i], section3Timers[i])
            quizList.add(quizItem)
        }
        // Add QuizList items for section 4
        for (i in section4Titles.indices) {
            val section4Questions = getSection4Questions()
            val quizItem = QuizList(section4Titles[i], section4Subtitles[i], section4Timers[i])
            quizList.add(quizItem)
        }
        // Add QuizList items for section 5
        for (i in section5Titles.indices) {
            val section5Questions = getSection5Questions()
            val quizItem = QuizList(section5Titles[i], section5Subtitles[i], section5Timers[i])
            quizList.add(quizItem)
        }
        // Add QuizList items for section 6
        for (i in section6Titles.indices) {
            val section6Questions = getSection6Questions()
            val quizItem = QuizList(section6Titles[i], section6Subtitles[i], section6Timers[i])
            quizList.add(quizItem)
        }

        val adapter = QuizListAdapter(quizList, this)
        adapter.setOnItemClickListener(object : QuizListAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("SECTION_QUESTIONS", quizList[position])
                startActivity(intent)
            }
        })

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun getSection1Questions(): ArrayList<QuestionModel> {
        val section1Questions = ArrayList<QuestionModel>()
        section1Questions.add(QuestionModel("Invention year of JAVA ?", "1993", "1999", "1995", "1988", "1995"))
        section1Questions.add(QuestionModel("Number of primitive data types in Java are ?", "4", "8", "12", "6", "8"))
        section1Questions.add(QuestionModel("Which component is used to compile, debug and execute the java programs?", "JRE", "JIT", "JDK", "JVM", "JDK"))
        section1Questions.add(QuestionModel("Which one of the following is not a Java feature?", "Object-oriented", "Use of pointers", "Portable", "Dyanamic and Extensible", "Use of pointers"))
        section1Questions.add(QuestionModel("Which of these cannot be used for a variable name in Java?", "Identifier and Keyword", "Identifier", "Keyword", "None of the Above", "Keyword"))
        section1Questions.add(QuestionModel("What is the extension of java code files?", ".js", ".text", ".java", ".class", ".java"))
        section1Questions.add(QuestionModel("Which of the following is not an OOPS concept in Java?", "Polymorphism", "Inheritance", "Compilation", "Encapsulation", "Compilation"))
        section1Questions.add(QuestionModel("Which of these keywords is used to define interfaces in Java", "intf", "Intf", "interface", "Interface", "interface"))
        section1Questions.add(QuestionModel("Which of the following is a superclass of every class in Java?", "Arraylist", "Abstract class", "Object class", "String", "Object class"))
        section1Questions.add(QuestionModel("Which one of the following is not an access modifier", "Protected", "Void", "Public", "Private", "Void"))
        return section1Questions
    }

    private fun getSection2Questions(): ArrayList<QuestionModel> {
        val section2Questions = ArrayList<QuestionModel>()
        section2Questions.add(QuestionModel("f two forces of magnitude P and 2P act on a " +
                "body , then their miniimum resultant is ", "2P", "3P", "P", "4P", "P"))
        section2Questions.add(QuestionModel("Two forces 3N and 1N act at normal to each " +
                "other.The resultant is ", "(10)½", "(12)½ ", "(8)½", "(7)½ ", "(10)½"))
        section2Questions.add(QuestionModel(" The splitting of a force into two perpendicular " +
                "directions without changing its effect is called", "resultant ", "resolution", "moment", "couple", "resolution"))
        section2Questions.add(QuestionModel("" +
                "The effect of a given force remains unaltered at " +
                "any point along the line of action .This is " +
                "according to", "resolution", "law of motion ", "law of transmissibility ", "equilibrium", "law of transmissibility "))
        section2Questions.add(QuestionModel("The forces, which meet at one point and their " +
                "lines of action also lie in the same plane, are " +
                "kNown as", "coplanar concurrent forces", "Coplanar non-concurrent forces", "non-Coplanar concurrent forces", "non-coplaner forces", "coplanar concurrent forces"))
        section2Questions.add(QuestionModel("Two equal forces act on a body.The square of " +
                "the resultant is three times the product of the " +
                "forces. Then the angle between them is", "120° ", "90° ", "60° ", "30° ", "60° "))
        section2Questions.add(QuestionModel("" +
                "A force of 200N acts 40° to the spoke of a " +
                "cycle wheel 250 mm in radius. The moment " +
                "about the center of the wheel will be nearer to", "50 N m", "38 N m", "32 N m", "40 N m", "32 N m"))
        section2Questions.add(QuestionModel("The moment of the 30 N force passing through " +
                "the coordinates (4, 0) and (0, 3) about the origin", "60 Nm ", "100 Nm ", "72 Nm ", "45 Nm ", "72 Nm "))
        section2Questions.add(QuestionModel("A quarter elliptical lamina of base 10cm and " +
                "height 15cm. The Y centroidal distance is ", "63.66 cm", "4.244 cm", "6.366 cm", "10 cm", "6.366 cm"))
        section2Questions.add(QuestionModel("The reaction offered by a smooth surface is", "Parallel to the surface", "Perpendicular to the surface", "Horizontal", "Vertical", "Perpendicular to the surface"))
        return section2Questions
    }

    private fun getSection3Questions(): ArrayList<QuestionModel> {
        val section3Questions = ArrayList<QuestionModel>()

        // Define the existing questions
        section3Questions.add(QuestionModel("They ______________ her and trusted her for years", "Know", "had known", "knew", "known", "knew"))
        section3Questions.add(QuestionModel("Every morning she ______________ up early and gets ready for work.", "is waking", "has woken", "had woken", "wakes", "wakes"))
        section3Questions.add(QuestionModel("The sun ______________ in the east and sets in the west.", "rise", "raises", "rises", "raised", "rises"))
        section3Questions.add(QuestionModel("She ______________ her homework before going to bed last night.", "finishes", "had finished", "finishing", "finished", "finished"))
        section3Questions.add(QuestionModel("He ______________ in London for two years before he moved to New York.", "has lived", "was living", "had lived", "lived", "had lived"))
        section3Questions.add(QuestionModel("I ______________ him since we were children.", "knew", "have known", "knowing", "known", "have known"))
        section3Questions.add(QuestionModel("She ______________ for the exam, so I hope she does well.", "studies", "had studied", "is studying", "has studied", "has studied"))
        section3Questions.add(QuestionModel("He ______________ his car keys, so we couldn't leave on time.", "lost", "loses", "was losing", "had lost", "had lost"))
        section3Questions.add(QuestionModel("The river ______________ for centuries, providing water for the village.", "flows", "is flowing", "has flowed", "flowed", "has flowed"))
        section3Questions.add(QuestionModel("They ______________ on this project for over a year now.", "worked", "are working", "have been working", "had worked", "have been working"))

        return section3Questions
    }

    private fun getSection4Questions(): ArrayList<QuestionModel> {
        val section4Questions = ArrayList<QuestionModel>()

        section4Questions.add(QuestionModel("What is Ohm's law?", "V = IR", "P = VI", "I = VR", "R = VI", "V = IR"))
        section4Questions.add(QuestionModel("What is the unit of electric charge?", "Ampere", "Coulomb", "Volt", "Ohm", "Coulomb"))
        section4Questions.add(QuestionModel("Which semiconductor device is used for amplification?", "Diode", "Transistor", "Resistor", "Capacitor", "Transistor"))
        section4Questions.add(QuestionModel("What is the SI unit of electrical resistance?", "Volt", "Ampere", "Ohm", "Coulomb", "Ohm"))
        section4Questions.add(QuestionModel("What type of material is used for making semiconductors?", "Insulator", "Conductor", "Superconductor", "Intrinsic semiconductor", "Intrinsic semiconductor"))
        section4Questions.add(QuestionModel("What does LED stand for?", "Long Electric Diode", "Light Emitting Device", "Light Emitting Diode", "Low Energy Diode", "Light Emitting Diode"))
        section4Questions.add(QuestionModel("What is the function of a capacitor in an electronic circuit?", "Voltage regulation", "Current amplification", "Energy storage", "Signal modulation", "Energy storage"))
        section4Questions.add(QuestionModel("What is the role of a diode in a circuit?", "Voltage regulation", "Current amplification", "Energy storage", "Directional control of current", "Directional control of current"))
        section4Questions.add(QuestionModel("What is the primary function of a transistor?", "Voltage regulation", "Current amplification", "Energy storage", "Signal modulation", "Current amplification"))
        section4Questions.add(QuestionModel("Which type of material is used in the core of an inductor?", "Insulator", "Conductor", "Superconductor", "Ferromagnetic material", "Ferromagnetic material"))

        return section4Questions
    }


    private fun getSection5Questions(): ArrayList<QuestionModel> {
        val section5Questions = ArrayList<QuestionModel>()

        // Existing questions
        section5Questions.add(QuestionModel("1 + 1 = ?", "1", "2", "3", "4", "2"))
        section5Questions.add(QuestionModel("1 - 1 = ?", "0", "2", "3", "4", "0"))
        section5Questions.add(QuestionModel("What is the value of pi (π) correct to two decimal places?", "3.12", "3.14", "3.16", "3.18", "3.14"))
        section5Questions.add(QuestionModel("Solve for x: 2x + 5 = 15", "x = 5", "x = 6", "x = 7", "x = 8", "x = 5"))
        section5Questions.add(QuestionModel("What is the square root of 64?", "4", "6", "8", "10", "8"))
        section5Questions.add(QuestionModel("Simplify: (2 + 3) * (4 - 1)", "12", "15", "18", "21", "15"))
        section5Questions.add(QuestionModel("What is the next number in the sequence: 1, 4, 9, 16, ...", "25", "36", "49", "64", "25"))
        section5Questions.add(QuestionModel("How many sides does a hexagon have?", "4", "6", "8", "10", "6"))
        section5Questions.add(QuestionModel("What is the value of 5 factorial (5!)?", "10", "15", "20", "120", "120"))
        section5Questions.add(QuestionModel("If a square has a side length of 5 units, what is its area?", "15 square units", "20 square units", "25 square units", "30 square units", "25 square units"))

        return section5Questions
    }


    private fun getSection6Questions(): ArrayList<QuestionModel> {
        val section6Questions = ArrayList<QuestionModel>()

        // Existing questions
        section6Questions.add(QuestionModel("How many bones are there in the human body?", "203", "206", "208", "200", "206"))
        section6Questions.add(QuestionModel("Which is the longest bone in the body?", "femur", "humerus", "scapula", "tibia", "femur"))
        section6Questions.add(QuestionModel("What is the chemical symbol for water?", "Wt", "Wa", "H2O", "H2", "H2O"))
        section6Questions.add(QuestionModel("Which gas do plants absorb from the atmosphere?", "Oxygen", "Carbon dioxide", "Nitrogen", "Hydrogen", "Carbon dioxide"))
        section6Questions.add(QuestionModel("What is the pH of pure water?", "7", "5", "10", "12", "7"))
        section6Questions.add(QuestionModel("What is the chemical name of baking soda?", "Sodium chloride", "Sodium bicarbonate", "Sodium carbonate", "Sodium nitrate", "Sodium bicarbonate"))
        section6Questions.add(QuestionModel("Which gas is produced during photosynthesis?", "Oxygen", "Carbon dioxide", "Nitrogen", "Hydrogen", "Oxygen"))
        section6Questions.add(QuestionModel("What is the chemical symbol for gold?", "Go", "Au", "Ag", "Gd", "Au"))
        section6Questions.add(QuestionModel("What is the process of conversion of sugar into alcohol called?", "Fermentation", "Distillation", "Oxidation", "Hydrolysis", "Fermentation"))
        section6Questions.add(QuestionModel("What is the main component of natural gas?", "Methane", "Ethane", "Propane", "Butane", "Methane"))

        return section6Questions
    }

}

private fun Intent.putExtra(s: String, questions: Any) {

}