package com.example.tmsquizapp.model

class Repo {
    val data = arrayListOf("Fe — это символ какого химического элемента?" ,
        "Какая планета в нашей Солнечной системе самая большая?",
        "Кто расписывал потолок Сикстинской капеллы?",
        "Какой океан самый большой на Земле?")
    val answersAsVariants = arrayListOf(
        arrayListOf("Цинк","Водород","Фтор","Железо"),//4
        arrayListOf("Юпитер","Сатурн","Нептун","Земля"),//1
        arrayListOf("Пабло Пикассо","Леонардо Да Винчи","Микеланджело","Винсент Ван Гог"),//3
        arrayListOf("Индийский","Тихий","Атлантический","Южный")//2
    )
    val answersId = arrayListOf(3,0,2,1)
}