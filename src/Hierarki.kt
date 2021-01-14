import kotlin.system.exitProcess

var underTomten = listOf("Glader", "Butter")
var underGlader = listOf("Tröger", "Trötter", "Blyger")
var underButter = listOf("Rådjuret", "Räven", "Haren", "Nyckelpigan")
var underTrötter = listOf("Skumtomten")
var underSkumtomten = listOf("Dammråttan")
var underRäven = listOf("Gråsuggan", "Myran")
var underMyran = listOf("Bladlusen")

val hierarki = mapOf(
    "Tomten" to underTomten,
    "Glader" to underGlader,
    "Butter" to underButter,
    "Trötter" to underTrötter,
    "Skumtomten" to underSkumtomten,
    "Räven" to underRäven,
    "Myran" to underMyran
    )

fun main() {
    println("Skriv in vilken nisse du vill ha information om: ")
    val nisse = readLine()
    val listOfWorkers: MutableList<String> = mutableListOf()

   fun getListOfArbetare(input : String) : List<String> {
        try{
                listOfWorkers.add(hierarki.getValue(input).joinToString())
                hierarki.getValue(input).forEach {
                        e -> hierarki[e]
                    if (hierarki[e] != null){
                        getListOfArbetare(e)
                    }
                }
        }
        catch (e : Exception){
            println("$nisse har inga arbetare eller finns inte på Nordpolen")
            exitProcess(0)
        }
        return listOfWorkers
    }
    println(getListOfArbetare("$nisse").joinToString(prefix = "Under $nisse jobbar: \n"))
}