package misc;

import kotlin.math.max
import kotlin.system.measureTimeMillis
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

data class State(
    val rank: Int,
    val star: Int,
    val continuousWin: Int,
    val preserveStars: Int
)

class Solution {


    fun calc(starPerRank: Int, winPerPreserve: Int, totalWin: Int, targetRank: Int, gameRecord: String): Boolean {

        //缓存，好像除了浪费内存没啥用（
        val winCache = HashMap<State, State>()
        val failCache = HashMap<State, State>()

        //如果胜利，下一场次的状态
        fun State.win(): State = winCache.computeIfAbsent(this) {

            if (star == starPerRank) {
                State(
                    rank + 1,
                    1,
                    (continuousWin + 1) % winPerPreserve,
                    (continuousWin + 1) / winPerPreserve
                )
            } else {
                State(
                    rank,
                    star + 1,
                    (continuousWin + 1) % winPerPreserve,
                    (continuousWin + 1) / winPerPreserve
                )
            }
        }

        //如果失败，下一场次的状态
        fun State.fail(): State = failCache.computeIfAbsent(this) {
            if (preserveStars > 0) {
                State(
                    rank,
                    star,
                    0,
                    preserveStars - 1
                )
            } else if (star == 0) {
                State(
                    if (rank == 1) 1 else rank - 1,
                    starPerRank - 1,
                    0,
                    0
                )
            } else {
                State(
                    rank,
                    star + 1,
                    0,
                    0
                )
            }
        }
        //计算胜利场次数量

        val restWins = totalWin - gameRecord.count { it == '1' }

        var maxRank = 1


        //模拟
        fun simulate(i: Int, currentState: State, chooseWins: Int) {
            if (chooseWins > restWins) {
                return
            }
            if (i >= gameRecord.length) {
                if (chooseWins == restWins) {
                    maxRank = max(maxRank, currentState.rank)
                }
                return
            }
            when (gameRecord[i]) {
                '0' -> simulate(i + 1, currentState.fail(), chooseWins)
                '1' -> simulate(i + 1, currentState.win(), chooseWins)
                '?' -> {
                    simulate(i + 1, currentState.fail(), chooseWins)
                    simulate(i + 1, currentState.win(), chooseWins + 1)
                }
                else -> throw IllegalArgumentException("Game record should only contains '0', '1' and '?'")
            }
        }

        simulate(0, State(1, 1, 0, 0), 0)
        return maxRank >= targetRank
    }


    fun run() {
        val (m, d, B, C) = readLine()!!.split(" ").map { it.trim().toInt() }
        val S = readLine()!!.split(" ").filter { it.isNotEmpty() }.joinToString("") { it }

        val time = measureTimeMillis {
            val calc = calc(m, d, B, C, S)
            println(calc)
        }

        println("方法执行耗时 $time ms")


    }


}

fun main() {
    Solution().run()

}