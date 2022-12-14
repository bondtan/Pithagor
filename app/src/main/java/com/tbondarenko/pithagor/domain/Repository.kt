package com.tbondarenko.pithagor.domain

import com.tbondarenko.pithagor.data.Number
import javax.inject.Inject

class Repository @Inject constructor() {

    private val numberOne = Number(
        numberId = 1,
        multiply = listOf(
            "1 * 1 = 1",
            "1 * 2 = 2",
            "1 * 3 = 3",
            "1 * 4 = 4",
            "1 * 5 = 5",
            "1 * 6 = 6",
            "1 * 7 = 7",
            "1 * 8 = 8",
            "1 * 9 = 9",
            "1 * 10 = 10",
        ),
        divide = listOf(
            "1 ÷ 1 = 1",
            "2 ÷ 1 = 2",
            "3 ÷ 1 = 3",
            "4 ÷ 1 = 4",
            "5 ÷ 1 = 5",
            "6 ÷ 1 = 6",
            "7 ÷ 1 = 7",
            "8 ÷ 1 = 8",
            "9 ÷ 1 = 9",
            "10 ÷ 1 = 10",
        )
    )
    private val numberTwo = Number(
        numberId = 2,
        multiply = listOf(
            "2 * 1 = 2",
            "2 * 2 = 4",
            "2 * 3 = 6",
            "2 * 4 = 8",
            "2 * 5 = 10",
            "2 * 6 = 12",
            "2 * 7 = 14",
            "2 * 8 = 16",
            "2 * 9 = 18",
            "2 * 10 = 20",
        ),
        divide = listOf(
            "2 ÷ 2 = 1",
            "4 ÷ 2 = 2",
            "6 ÷ 2 = 3",
            "8 ÷ 2 = 4",
            "10 ÷ 2 = 5",
            "12 ÷ 2 = 6",
            "14 ÷ 2 = 7",
            "16 ÷ 2 = 8",
            "18 ÷ 2 = 9",
            "20 ÷ 2 = 10",
        )
    )
    private val numberThree = Number(
        numberId = 3,
        multiply = listOf(
            "3 * 1 = 3",
            "3 * 2 = 6",
            "3 * 3 = 9",
            "3 * 4 = 12",
            "3 * 5 = 15",
            "3 * 6 = 18",
            "3 * 7 = 21",
            "3 * 8 = 24",
            "3 * 9 = 27",
            "3 * 10 = 30",
        ),
        divide = listOf(
            "3 ÷ 3 = 1",
            "6 ÷ 3 = 2",
            "9 ÷ 3 = 3",
            "12 ÷ 3 = 4",
            "15 ÷ 3 = 5",
            "18 ÷ 3 = 6",
            "21 ÷ 3 = 7",
            "24 ÷ 3 = 8",
            "27 ÷ 3 = 9",
            "30 ÷ 3 = 10",
        )
    )
    private val numberFore = Number(
        numberId = 4,
        multiply = listOf(
            "4 * 1 = 4",
            "4 * 2 = 8",
            "4 * 3 = 12",
            "4 * 4 = 16",
            "4 * 5 = 20",
            "4 * 6 = 24",
            "4 * 7 = 28",
            "4 * 8 = 32",
            "4 * 9 = 36",
            "4 * 10 = 40",
        ),
        divide = listOf(
            "4 ÷ 4 = 1",
            "8 ÷ 4 = 2",
            "12 ÷ 4 = 3",
            "16 ÷ 4 = 4",
            "20 ÷ 4 = 5",
            "24 ÷ 4 = 6",
            "28 ÷ 4 = 7",
            "32 ÷ 4 = 8",
            "36 ÷ 4 = 9",
            "40 ÷ 4 = 10",
        )
    )
    private val numberFive = Number(
        numberId = 5,
        multiply = listOf(
            "5 * 1 = 5",
            "5 * 2 = 10",
            "5 * 3 = 15",
            "5 * 4 = 20",
            "5 * 5 = 25",
            "5 * 6 = 30",
            "5 * 7 = 35",
            "5 * 8 = 40",
            "5 * 9 = 45",
            "5 * 10 = 50",
        ),
        divide = listOf(
            "5 ÷ 5 = 1",
            "10 ÷ 5 = 2",
            "15 ÷ 5 = 3",
            "20 ÷ 5 = 4",
            "25 ÷ 5 = 5",
            "30 ÷ 5 = 6",
            "35 ÷ 5 = 7",
            "40 ÷ 5 = 8",
            "45 ÷ 5 = 9",
            "50 ÷ 5 = 10",
        )
    )
    private val numberSix = Number(
        numberId = 6,
        multiply = listOf(
            "6 * 1 = 6",
            "6 * 2 = 12",
            "6 * 3 = 18",
            "6 * 4 = 24",
            "6 * 5 = 30",
            "6 * 6 = 36",
            "6 * 7 = 42",
            "6 * 8 = 48",
            "6 * 9 = 54",
            "6 * 10 = 60",
        ),
        divide = listOf(
            "6 ÷ 6 = 1",
            "12 ÷ 6 = 2",
            "18 ÷ 6 = 3",
            "24 ÷ 6 = 4",
            "30 ÷ 6 = 5",
            "36 ÷ 6 = 6",
            "42 ÷ 6 = 7",
            "48 ÷ 6 = 8",
            "54 ÷ 6 = 9",
            "60 ÷ 6 = 10",
        )
    )
    private val numberSeven = Number(
        numberId = 7,
        multiply = listOf(
            "7 * 1 = 7",
            "7 * 2 = 14",
            "7 * 3 = 21",
            "7 * 4 = 28",
            "7 * 5 = 35",
            "7 * 6 = 42",
            "7 * 7 = 49",
            "7 * 8 = 56",
            "7 * 9 = 63",
            "7 * 10 = 70",
        ),
        divide = listOf(
            "7 ÷ 7 = 1",
            "14 ÷ 7 = 2",
            "21 ÷ 7 = 3",
            "28 ÷ 7 = 4",
            "35 ÷ 7 = 5",
            "42 ÷ 7 = 6",
            "49 ÷ 7 = 7",
            "56 ÷ 7 = 8",
            "63 ÷ 7 = 9",
            "70 ÷ 7 = 10",
        )
    )
    private val numberEight = Number(
        numberId = 8,
        multiply = listOf(
            "8 * 1 = 8",
            "8 * 2 = 16",
            "8 * 3 = 24",
            "8 * 4 = 32",
            "8 * 5 = 40",
            "8 * 6 = 48",
            "8 * 7 = 56",
            "8 * 8 = 64",
            "8 * 9 = 72",
            "8 * 10 = 80",
        ),
        divide = listOf(
            "8 ÷ 8 = 1",
            "16 ÷ 8 = 2",
            "24 ÷ 8 = 3",
            "32 ÷ 8 = 4",
            "40 ÷ 8 = 5",
            "48 ÷ 8 = 6",
            "56 ÷ 8 = 7",
            "64 ÷ 8 = 8",
            "72 ÷ 8 = 9",
            "80 ÷ 8 = 10",
        )
    )
    private val numberNine = Number(
        numberId = 9,
        multiply = listOf(
            "9 * 1 = 9",
            "9 * 2 = 18",
            "9 * 3 = 27",
            "9 * 4 = 36",
            "9 * 5 = 45",
            "9 * 6 = 54",
            "9 * 7 = 63",
            "9 * 8 = 72",
            "9 * 9 = 81",
            "9 * 10 = 90",
        ),
        divide = listOf(
             "9 ÷ 9 = 1",
             "18 ÷ 9 = 2",
             "27 ÷ 9 = 3",
             "36 ÷ 9 = 4",
             "45 ÷ 9 = 5",
             "54 ÷ 9 = 6",
             "63 ÷ 9 = 7",
             "72 ÷ 9 = 8",
             "81 ÷ 9 = 9",
             "90 ÷ 9 = 10",
        )
    )
    private val numberTen = Number(
        numberId = 10,
        multiply = listOf(
             "10 * 1 = 10",
             "10 * 2 = 20",
             "10 * 3 = 30",
             "10 * 4 = 40",
             "10 * 5 = 50",
             "10 * 6 = 60",
             "10 * 7 = 70",
             "10 * 8 = 80",
             "10 * 9 = 90",
             "10 * 10 = 100",
        ),
        divide = listOf(
             "10 ÷ 10 = 1",
             "20 ÷ 10 = 2",
             "30 ÷ 10 = 3",
             "40 ÷ 10 = 4",
             "50 ÷ 10 = 5",
             "60 ÷ 10 = 6",
             "70 ÷ 10 = 7",
             "80 ÷ 10 = 8",
             "90 ÷ 10 = 9",
             "100 ÷ 10 = 10",
        )
    )

    val pithagorTable = listOf(
        numberOne,
        numberTwo,
        numberThree,
        numberFore,
        numberFive,
        numberSix,
        numberSeven,
        numberEight,
        numberNine,
        numberTen
    )

    fun fetchNumber (value : Int) : Number {
        return pithagorTable.filter { it.numberId ==value }.component1()
    }
}
